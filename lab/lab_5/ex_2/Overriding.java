package lab.lab_5.ex_2;

class Base {
    void foo() {
        System.out.println("bar");
    }
}

class SubClass extends Base {
    @Override
    void foo() {
        System.out.println("baz");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Base base_class = new Base();
        Base sub_class = new SubClass();
        SubClass sub_class_ = new SubClass();

        base_class.foo();
        sub_class.foo();
        sub_class_.foo();
    }
}
