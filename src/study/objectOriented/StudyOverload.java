package study.objectOriented;

/**
 * @Description: 方法重载是一个类中定义了多个方法名相同, 而他们的参数的数量不同或数量相同而类型和次序不同, 则称为方法的重载(Overloading)。)方法重载是一个类的多态性表现。
 * 重载规则:
 * 1.被重载的方法必须改变参数列表(参数个数或类型不一样)；
 * 2.被重载的方法可以改变返回类型；
 * 3.被重载的方法可以改变访问修饰符；
 * 4.被重载的方法可以声明新的或更广的检查异常；
 * 5.方法能够在同一个类中或者在一个子类中被重载。
 * 6.无法以返回值类型作为重载函数的区分标准。
 * @Param:
 * @return:
 * @Author: Lx34r
 * @Date: 2020/3/31
 */

public class StudyOverload {
    private String text;

    public StudyOverload(){}//无参构造方法
    public StudyOverload(String text){//有参构造方法，构造方法只能被重载，不能重写
        this.text = text;
    }

    public int test() {
        System.out.println("test1"+text);
        return 1;
    }

    public void test(int a) {
        System.out.println("test2");
        return;
    }

    //以下两个参数类型顺序不同
    public String test(int a, String s) {
        System.out.println("test3");
        return "returntest3";
    }

    public String test(String s, int a) {
        System.out.println("test4");
        return "returntest4";
    }

    public static void main(String[] args) {
        StudyOverload o = new StudyOverload();
        StudyOverload p = new StudyOverload("实例化有参构造方法");//实例化同时赋值

        System.out.println(o.test());
        System.out.println(p.test());

        o.test(1);
        System.out.println(o.test(1, "test3"));
        System.out.println(o.test("test4", 1));
    }
}
