package Test;

public class Test_Override {
    /*
    this-this
    super-this
    this-super
    super-super

     */
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

                    // 在 Test.A 中存在 show(Test.A obj)，直接调用
        a.show(a); // Test.A.show(Test.A)
                    // 在 Test.A 中不存在 show(Test.B obj)，将 Test.B 转型成其父类 Test.A
        a.show(b); // Test.A.show(Test.A)
                    // 在 Test.B 中存在从 Test.A 继承来的 show(Test.C obj)，直接调用
        b.show(c); // Test.A.show(Test.C)
                    // 在 Test.B 中不存在 show(Test.D obj)，但是存在从 Test.A 继承来的 show(Test.C obj)，将 Test.D 转型成其父类 Test.C
        b.show(d); // Test.A.show(Test.C)-----如果B中有了D，则为B.show(Test.D)
        b.show(null);

        b.show(a);//Test.B.show(Test.A)

        System.out.println();

        // -------------------引用的还是 Test.B 对象，所以 ba 和 b 的调用结果一样
        A ba = new B();//
        ba.show(c); // Test.A.show(Test.C)
        ba.show(d); // Test.A.show(Test.C)--A中不存在showD，将D转型成C
        ba.show(a);//Test.B.show(Test.A)


        System.out.println();

        A ca = new C();//
        ca.show(a);//Test.B.show(Test.A)
        ca.show(c);//Test.A.show(Test.C)
        ca.show(d);//Test.A.show(Test.C)


        ca.show(null);//Test.A.show(Test.C)

    }
}

class A {
    public void show(A obj) {
        System.out.println("Test.A.show(Test.A)");
    }
    public void show(C obj) {
        System.out.println("Test.A.show(Test.C)");
    }
}

class B extends A {
    @Override
    public void show(A obj) {
        System.out.println("Test.B.show(Test.A)");
    }

    public void show(D obj){
        System.out.println("Test.B.show(Test.D)");
    }
}

class C extends B {
}

class D extends C {
}

