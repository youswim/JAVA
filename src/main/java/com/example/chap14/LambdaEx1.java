package com.example.chap14;

public class LambdaEx1 {
//    함수형 인터페이스를 다양한 방법으로 구현해서 사용하는 방법
//    규칙1 : 람다식의 내용이 한줄이면 세미콜론과 중괄호를 사용하지 않는다.
//    규칙2 : 람다식에 return 키워드를 넣으려면 세미콜론과 중괄호를 사용해야 한다. (람다식이 한줄이면 return안써도 됨)

    static void excute(MyFunction1 f){
        f.run();
    }

    static MyFunction1 getMyFunction() {
        return () -> System.out.println("f3.run");
    }

    public static void main(String[]args) {
        MyFunction1 f1 = () -> System.out.println("f1.run()");

        MyFunction1 f2 = new MyFunction1() {
            @Override
            public void run() {
            }
        };

        MyFunction1 f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        excute(f1);
        excute(()-> System.out.println("run()"));
    }
}

@FunctionalInterface
interface MyFunction1 {
    void run();
}