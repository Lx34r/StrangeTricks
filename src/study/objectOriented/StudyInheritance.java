package study.objectOriented;

class SuperClass {
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n)："+n);
        this.n = n;
    }
}
// SubClass 类继承
class SubClass extends SuperClass{
    private int n;

    SubClass(){ // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public SubClass(int n){
        super(400);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }
}
// SubClass2 类继承
class SubClass2 extends SubClass{//java中extends可以多重继承，但不可以多继承
    private int n;

    SubClass2(){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass2(int n){ // 自动调用父类的无参数构造器
        System.out.println("SubClass2(int n):"+n);
        this.n = n;
    }
}

//使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口
interface A{
    public void eat();
    public void sleep();

}

interface B{
    public void show();

}

class C implements A,B {
    @Override
    public void eat() {
        System.out.println("吃吃吃");
    }

    @Override
    public void sleep() {
        System.out.println("睡睡睡");
    }

    @Override
    public void show() {
        System.out.println("show");
    }
}

public class StudyInheritance{
    public static void main (String args[]){
        System.out.println("------SubClass 类继承------");
        SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(100);
        System.out.println("------SubClass2 类继承------");
        SubClass2 sc3 = new SubClass2();
        SubClass2 sc4 = new SubClass2(200);

        System.out.println("------接口继承------");
        C c = new C();
        c.eat();
        c.sleep();
        c.show();
    }
}