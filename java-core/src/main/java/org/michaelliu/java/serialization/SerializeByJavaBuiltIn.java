package org.michaelliu.java.serialization;

import org.michaelliu.java.entity.Student;

import java.io.*;

/**
 * Created by Michael on 7/4/16.
 */
public class SerializeByJavaBuiltIn {

    /**
     * 序列化一个对象(存储到一个文件)
     * @throws IOException
     */
    private static void setSerializableObject() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.out"));
        oos.writeObject("Save a object:\n");
        for (int i = 0; i < 1000000; i++) {
            oos.writeObject(new Student(i, "Michael" + i, 25, "Computer Science" + i));
        }
        oos.close();
    }

    /**
     * 反序列化,将该对象恢复(存储到一个文件)
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void getSerializableObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.out"));
        Student student = null;
        while((student = (Student)ois.readObject()) != null){
            //System.out.println(student);
        }
        ois.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException,
            ClassNotFoundException {
        long start = System.currentTimeMillis();
        setSerializableObject();
        long end = System.currentTimeMillis();
        System.out.println("Java Serializable writeObject time: " +
                (end - start) + "ms");

        start = System.currentTimeMillis();
        getSerializableObject();
        end = System.currentTimeMillis();
        System.out.println("Java Serializable readObject time: " +
                (end - start) + "ms");

//        //序列化一个对象(存储到字节数组)
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos2 = new ObjectOutputStream(baos);
//        oos2.writeObject("Save another object:\n");
//        oos2.writeObject(new Student(10001, "Jackson", 22, "Software Engineering"));
//        oos2.close();
//
//        //反序列化,将该对象恢复(存储到字节数组)
//        ObjectInputStream ois2 = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
//        str = (String)ois2.readObject();
//        student = (Student)ois2.readObject();
//        System.out.println(str + student);
    }

}
