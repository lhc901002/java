package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflect {
    public static void main(String[] args) {
        try {
            Class<?> class1 = Class.forName("com.reflection.User");
            // 方法1: 实例化默认构造方法，调用set赋值
            User user = (User) class1.newInstance();
            user.setId(1000);
            user.setName("Michael");
            System.out.println(user);  // User{id=1000, name='Michael'}

            // 方法2: 获取指定构造函数，直接在构造函数赋值。
            // 获取全部的构造函数
            Constructor<?> cons[] = class1.getConstructors();
            for (int i = 0; i < cons.length; i++) {
                // 打印每个构造函数参数类型
                Class<?> clazzs[] = cons[i].getParameterTypes();
                System.out.print("cons[" + i + "] (");
                for (int j = 0; j < clazzs.length; j++) {
                    if (j == clazzs.length - 1) {
                        System.out.print(clazzs[j].getName());
                    } else {
                        System.out.print(clazzs[j].getName() + ",");
                    }
                }
                System.out.println(")");
            }
            // 结果
            // cons[0] ()
            // cons[1] (java.lang.Integer,java.lang.String)
            // 根据构造函数创建对象
            User user2 = (User) cons[0].newInstance();
            User user3 = (User) cons[1].newInstance(20, "Rollen");
            System.out.println(user3); // User{id=20, name='Rollen'}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
