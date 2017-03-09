package com.example;

public class MyClass {

    public static void main(String[] args) {

        test1();
        test2();

    }

    private static void test2() {

        Test2<Number> number = new Test2<Number>(1);
        Test2<Integer> integer = new Test2<Integer>(2);
        getData(number);
        getData(integer);

    }

    /**
     * ?类型实参
     *
     * @param n
     */
    private static void getData(Test2<?> n) {
        System.out.println(n.getT());
    }

    private static void test1() {
        User user = new User("selbylei", 30);
        Test1<User> box = new Test1<User>(user);
        System.out.println(box.toString());
    }
}

class Test2<T> {
    private T t;

    public Test2(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}


//类型限制的范型类
class Test1<T extends User> {
    private T data;

    public Test1() {

    }

    public Test1(T data) {
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getName();
    }
}

class User {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
