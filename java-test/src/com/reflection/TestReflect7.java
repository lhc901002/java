package com.reflection;

public class TestReflect7 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.reflection.VipUser");
            // 取得父类
            Class<?> parentClass = clazz.getSuperclass();
            System.out.println("clazz的父类为：" + parentClass.getName());

            // 获取所有的接口
            Class<?>[] interfaces = clazz.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                System.out.println(interfaces[i].getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
