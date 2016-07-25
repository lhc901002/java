package org.michaelliu.demo.java.io.serialize;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.beans.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Michael on 7/4/16.
 */
public class SerializeByJavaBuiltIn {

    private static Log log = LogFactory.getLog(SerializeByJavaBuiltIn.class);

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
            //log.info(student);
        }
        ois.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException,
            ClassNotFoundException {
        long start = System.currentTimeMillis();
        setSerializableObject();
        long end = System.currentTimeMillis();
        log.info("Java Serializable writeObject time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        getSerializableObject();
        end = System.currentTimeMillis();
        log.info("Java Serializable readObject time: " + (end - start) + "ms");

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
//        log.info(str + student);
    }

}
