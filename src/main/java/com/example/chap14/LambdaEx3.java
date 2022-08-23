package com.example.chap14;

public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        inner.method(100);

        MyFunction4 f = Integer::parseInt;
    }
}

@FunctionalInterface
interface MyFunction4 {
    int myMethod(String s);
}

@FunctionalInterface
interface MyFunction3 {
    void myMethod();
}

class Outer {
    int val = 10;

    class Inner {
        int val = 20;

        void method(int i) { // final int i를 사용해도 된다.
            int val = 30;
//            val = 20; 오류!
//            i = 10; 오류!
//            람다식 내에서 참조하는 지역변수는 final이 없더라도 상수로 간주된다.
//            람다식 내에서 참조하는 지역변수는 람다식의 안과 밖에서 변경이 허용되지 않는다.
//            Effectively final : 상수로 선언되지는 않았지만, 선언 후 값이 변경되지 않는 변수.
//            MyFunction3 f = (i) -> {};
//            외부 지역변수와 같은 이름의 람다식 매개변수는 불허!
            MyFunction3 f = () -> {
                System.out.println("i = " + i);
                System.out.println("val = " + val);
                System.out.println("this.val = " + this.val);
                System.out.println("Outer.this.val = " + Outer.this.val);
//                Inner, Outer클래스의 멤버변수는 상수로 간주되지 않으므로, 값의 변경이 가능하다.
            };
            f.myMethod();
        }
    }
}
