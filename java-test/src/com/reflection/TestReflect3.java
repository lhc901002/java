package com.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflect3 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.reflection.User");
            // 获取本类的全部方法（包括自身定义的方法和从父类继承的public方法）
            Method[] methods = clazz.getMethods();
            for (int i = 0; i < methods.length; i++) {
                // 获取方法的返回类型
                Class<?> returnType = methods[i].getReturnType();
                // 获取方法的参数类型
                Class<?> [] paramTypes = methods[i].getParameterTypes();
                // 获取方法的访问控制符
                int modifiers = methods[i].getModifiers();
                String modifier = Modifier.toString(modifiers);
                // 打印方法的访问控制符、返回类型、方法名
                System.out.print(modifier + " " + returnType.getName() + " " + methods[i].getName() + " (");
                for (int j = 0; j < paramTypes.length; ++j) {
                    // 打印方法参数类型名
                    System.out.print(paramTypes[j].getName() + " arg" + j);
                    if (j < paramTypes.length - 1) {
                        System.out.print(",");
                    }
                }
                // 获取方法抛出的异常类型
                Class<?> [] exceptionTypes = methods[i].getExceptionTypes();
                if (exceptionTypes.length > 0) {
                    System.out.print(") throws ");
                    for (int k = 0; k < exceptionTypes.length; k++) {
                        // 打印抛出异常类型名
                        System.out.print(exceptionTypes[k].getName() + " ");
                        if (k < exceptionTypes.length - 1) {
                            System.out.print(",");
                        }
                    }
                } else {
                    System.out.print(")");
                }
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
