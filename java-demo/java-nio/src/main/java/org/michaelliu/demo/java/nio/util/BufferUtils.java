package org.michaelliu.demo.java.nio.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by Michael on 7/20/16.
 */
public class BufferUtils {

    private static final String CHARSET_UTF8 = "UTF-8";

    public static ByteBuffer getByteBuffer(String str) {
        return ByteBuffer.wrap(str.getBytes());
    }

    public static String getString(ByteBuffer buffer) {
        return getString(buffer, CHARSET_UTF8);
    }

    public static String getString(ByteBuffer buffer, String charset) {
        if(buffer == null) {
            throw new IllegalArgumentException("The buffer must not be null");
        }
        try {
            CharsetDecoder decoder = Charset.forName(charset).newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            buffer.flip();
            return charBuffer.toString();
        } catch (CharacterCodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
