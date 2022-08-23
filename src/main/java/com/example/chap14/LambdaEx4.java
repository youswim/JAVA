package com.example.chap14;

// 메서드 참조. 직접 만든 예제 코드
public class LambdaEx4 {
    String str = "123";
    MyFunction5 f1 = (s) -> Integer.parseInt(s);
    MyFunction5 f2 = Integer::parseInt;
    // 매서드 참조에서 생략된 매개변수와 리턴타입은 함수형 인터페이스의 메서드를 보면 알 수 있다.

    String str1 = "hello";
    String str2 = "hello";

    MyFunction6 f3 = (s1, s2) -> s1.equals(s2);
    MyFunction6 f4 = String::equals;

//    두개의 String을 받아서 boolean을 결과로 반환하는 메서드는 다른 클래스에도 있을 수 있다.
//    따라서 어떤 클래스의 equals를 사용할 것인지 명시한다.

    MyClass obj = new MyClass();
    MyFunction7 f5 = (o) -> obj.equals(o);
    MyFunction7 f6 = obj::equals;
    
}

@FunctionalInterface
interface MyFunction5{
    Integer myFunction(String s);
}

@FunctionalInterface
interface MyFunction6{
    Boolean myFunction(String s1, String s2);
}

@FunctionalInterface
interface MyFunction7 {
    Boolean myFunction(MyClass myClass);
}

class MyClass {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}