package org.michaelliu.java.nio.test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * Created by Michael on 7/21/16.
 */
public class BufferTest {

    public void visitByteBuffer(ByteBuffer buffer) {
        System.out.println(buffer); // show current position, limit and capacity of buffer
        byte i = 11;
        while (buffer.hasRemaining()) {
            int position = buffer.position();
            System.out.println("Current value: " + buffer.get(position) + "\tCurrent status: " + buffer);
            buffer.put(position, i++); // set current position with value i, then auto increment i.
            buffer.position(++position); // set current position to the next available slot
        }
        buffer.rewind(); // set position to 0, but limit stays unchanged. PS: don't use reset(), it only set position to mark.
        System.out.println(buffer);
        while (buffer.hasRemaining()) {
            // get(): get the value of the current position, then position add 1.
            System.out.println("Current value: " + buffer.get() + "\tCurrent status: " + buffer);
        }
    }

    public void convertBuffer(ByteBuffer buffer) {
        System.out.println(buffer);
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer(); // return a new read-only buffer, original buffer remain unchanged.
        try {
            System.out.println(readOnlyBuffer.get(0));
            readOnlyBuffer.put((byte) 10); // this operation will throw ReadOnlyBufferException
        } catch (ReadOnlyBufferException e) {
            System.err.println(e);
        }
        CharBuffer charBuffer = buffer.asCharBuffer(); // return a new char buffer, original buffer remain unchanged.
        // char buffer has half the length of byte buffer, because size of char is twice that of byte
        System.out.println("CharBuffer: pos="
                + charBuffer.position()
                + " lim=" + charBuffer.limit()
                + " cap=" + charBuffer.capacity());
        // char buffer has 1/4 the length of byte buffer, because size of char is 4 times that of byte
        IntBuffer intBuffer = buffer.asIntBuffer();
        System.out.println("IntBuffer: pos="
                + intBuffer.position()
                + " lim=" + intBuffer.limit()
                + " cap=" + intBuffer.capacity());
        int i = 1;
        while (intBuffer.hasRemaining()) {
            intBuffer.put(i++);
        }
        intBuffer.rewind();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
        // get the same result of intBuffer.get()
        while(buffer.hasRemaining()) {
            System.out.println(buffer.getInt());
        }
    }

    public void operateBuffer(ByteBuffer buffer) {
        System.out.println(buffer);
        buffer.position(4); // set current position to index 4
        while (buffer.hasRemaining()) {
            System.out.println("Current value: " + buffer.get());
        }
        buffer.position(4);
        buffer.flip(); // set position to index 0, limit is now set to 4
        while (buffer.hasRemaining()) {
            System.out.println("Current value: " + buffer.get()); // this time only print index 0-3
        }
        buffer.clear(); // set byte buffer to original status, limit=capacity, position=0
        buffer.position(2);
        System.out.println(buffer);
        buffer.mark(); // mark current position: index 2
        buffer.position(6);
        System.out.println(buffer);
        buffer.reset(); // reset current position to index 2
        System.out.println(buffer);
    }

    public static void main(String[] args) {
        BufferTest test = new BufferTest();
        byte[] bytes = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
//        test.visitByteBuffer(buffer);
//        test.convertBuffer(buffer);
        test.operateBuffer(buffer);
    }

}
