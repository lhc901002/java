package org.michaelliu.demo.java.io.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.michaelliu.java.entity.Student;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Michael on 7/4/16.
 */
public class SerializeByKryo {

    private static Kryo initKryo() {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        return kryo;
    }

    private static void setSerializableObject(Kryo kryo) throws FileNotFoundException {
        kryo.register(Student.class);
        Output output = new Output(new FileOutputStream("student.out"));
        for (int i = 0; i < 1000000; i++) {
            kryo.writeObject(output, new Student(i, "Michael" + i, 25, "Computer Science" + i));
        }
        output.flush();
        output.close();
    }

    private static void getSerializableObject(Kryo kryo) throws FileNotFoundException, KryoException {
        Input input = new Input(new FileInputStream("student.out"));
        Student student = null;
        while((student = kryo.readObject(input, Student.class)) != null){
            //System.out.println(student);
        }
        input.close();
    }

    public static void main(String[] args) throws IOException {
        Kryo kryo = initKryo();
        long start = System.currentTimeMillis();
        setSerializableObject(kryo);
        long end = System.currentTimeMillis();
        System.out.println("Kryo Serializable writeObject time: " +
                (end - start) + "ms");
        start = System.currentTimeMillis();
        getSerializableObject(kryo);
        end = System.currentTimeMillis();
        System.out.println("Kryo Serializable readObject time: " +
                (end - start) + "ms");
    }

}
