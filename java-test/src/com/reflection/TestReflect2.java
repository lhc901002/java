package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflect2 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.reflection.User");
            // 取得本类的全部属性
            Field[] field = clazz.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                // 获取访问控制符（private, public, protected等）
                int modifiers = field[i].getModifiers();
                String modifier = Modifier.toString(modifiers);
                System.out.print(modifier + " ");
                // 获取属性类型和属性名字
                Class<?> type = field[i].getType();
                System.out.println(type.getName() + " " + field[i].getName() + ";");
            }

            // 取得public属性
            Field[] field2 = clazz.getFields();
            for (int i = 0; i < field2.length; i++) {
                int modifiers = field2[i].getModifiers();
                String modifier = Modifier.toString(modifiers);
                System.out.print(modifier + " ");
                Class<?> type = field2[i].getType();
                System.out.println(type.getName() + " " + field2[i].getName() + ";");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
