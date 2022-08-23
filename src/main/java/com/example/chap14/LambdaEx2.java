package com.example.chap14;

public class LambdaEx2 {
    public static void main(String[] args) {

        MyFunction2 f = ()->{};
        Object obj = (MyFunction2)(()->{});
        String str = ((Object)(MyFunction2)(()->{})).toString();

        System.out.println("f = " + f);
        System.out.println("obj = " + obj);
        System.out.println("str = " + str);

//        System.out.println(()->{});
//        람다식은 Object로 변환 불가!

        System.out.println((MyFunction2)(()->{}));
//        System.out.println((MyFunction2)(()->{}).toString());
//        람다식을 Object로 변환 불가하므로, 람다식에 toString도 바로 적용이 불가능함.
        System.out.println(((Object)(MyFunction2)(()->{})).toString());

        System.out.println(new Test());

    }

}

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}

class Test {

}
