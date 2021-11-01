package com.luxoft.reflection;

import java.lang.reflect.*;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflection {
    public static void main(String[] args) {
        System.out.println("Метод принимает класс и возвращает созданный объект этого класса");
        Object instance = null;
        instance = Reflection.createInstance(Car.class);
        System.out.println((instance));
        // Error here
//        instance = Reflection.createInstance(Car.class, "Tesla", 1000);
//        System.out.println(((Car)instance));

        System.out.println("\n");
        System.out.println("Метод принимает object и вызывает у него все методы без параметров");
        Reflection.callMethodsWithoutParams(instance);

        System.out.println("\n");
        System.out.println("Метод принимает object и выводит на экран все сигнатуры методов в который есть final");
        Reflection.printFinalMethods(instance);

        System.out.println("\n");
        System.out.println("Метод принимает Class и выводит все не публичные методы этого класса");
        Reflection.printNonPublicMethods(instance);

        System.out.println("\n");
        System.out.println("Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует");
        Reflection.printClassParentsAndInterfaces(new ArrayList());

        System.out.println("\n");
        System.out.println("Метод принимает объект и меняет все его приватные поля на их нулевые значение (null, 0, false etc)+");
        Reflection.setDefaultPrivateValues(instance);
        System.out.println(instance);
    }

    //    Метод принимает класс и возвращает созданный объект этого класса
    public static Object createInstance(Class c, Object ...arguments) {
        Object result = null;
        Class[] argumentTypes = new Class[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            argumentTypes[i] = arguments[i].getClass();
        }
        for (Class t : argumentTypes) {
            System.out.println(t.toString());
        }
        try {
            result = c.getConstructor(argumentTypes).newInstance(arguments);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    }

//    Метод принимает object и вызывает у него все методы без параметров
    public static void callMethodsWithoutParams(Object object) {
        Class c = object.getClass();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                if (!method.canAccess(object)) {
                    method.trySetAccessible();
                }
                try {
                    method.invoke(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    public static void printFinalMethods(Object object) {
        Class c = object.getClass();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

//    Метод принимает Class и выводит все не публичные методы этого класса
    public static void printNonPublicMethods(Object object) {
        Class c = object.getClass();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

//    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    public static void printClassParentsAndInterfaces(Object object) {
        Class c = object.getClass();
        List<Class> ancestors = new ArrayList<Class>();
        Class ancestor = c;
        do {
            ancestor = ancestor.getSuperclass();
            ancestors.add(ancestor);
        } while (!ancestor.getName().equals(Object.class.getName()));
        System.out.println(String.format("Parents of %s are: ", c.getName()));
        ancestors.stream().forEach(value -> System.out.println(value));

        System.out.println(String.format("Interfaces of %s are: ", c.getName()));
        Arrays.stream(c.getInterfaces()).forEach(value -> System.out.println(value));
    }

//    Метод принимает объект и меняет все его приватные поля на их нулевые значение (null, 0, false etc)+
    public static void setDefaultPrivateValues(Object object) {
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (!field.canAccess(object)) {
                field.trySetAccessible();
            }
            var newValue = Array.get(Array.newInstance(field.getType(), 1), 0);
            try {
                field.set(object, newValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("Default value for %s is %s.", field.getType(), newValue));
        }
    }
}
