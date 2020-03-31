package study.objectOriented;

/**
 * @Description: 方法重写是在子类存在方法与父类的方法的名字相同, 而且参数的个数与类型一样, 返回值也一样的方法, 就称为重写(Overriding)。方法重写是子类与父类的一种多态性表现.
 * 方法的重写规则
 * 1.参数列表必须完全与被重写方法的相同。
 * 2.返回类型与被重写方法的返回类型可以不相同，但是必须是父类返回值的派生类（java5 及更早版本返回类型要一样，java7 及更高版本可以不同）。
 * 3.访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为 public，那么在子类中重写该方法就不能声明为 protected。
 * 4.父类的成员方法只能被它的子类重写。
 * 5.声明为 final 的方法不能被重写。
 * 6.声明为 static 的方法不能被重写，但是能够被再次声明。
 * 7.子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private 和 final 的方法。
 * 8.子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法。
 * 9.重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
 * 10.构造方法不能被重写。
 * 11.如果不能继承一个方法，则不能重写这个方法。
 * @Param:
 * @return:
 * @Author: Lx34r
 * @Date: 2020/3/31
 */

class Animal {

    public void run() {
        System.out.println("动物会跑");
    }

}

class Dog extends Animal {
    public void run() {
        System.out.println("小狗会跑");
        super.run();//当需要在子类中调用父类的被重写方法时，要使用 super 关键字。
    }

    public void bark() {
        System.out.println("小狗会叫");
    }

}

public class StudyOverride {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        Dog d = new Dog();

        a.run();
        b.run();
        //b.bark();//err:Cannot resolve method 'bark' in 'Animal',b的引用类型Animal没有bark方法
        d.bark();

    }
}
