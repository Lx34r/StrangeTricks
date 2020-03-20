package rankAlgorithm;

public class SleepSort {
    /**=========睡眠排序=========
    利用多线程，把接收的每一个参数分别放在不同的线程里面并在每个线程同时使用sleep函数，sleep的时间就是参数的值
    */
    public static class sleepThread extends Thread{
        private int time;
        public sleepThread(int time){
            this.time=time;
        }
        @Override
        public void run() {
            try {
                //放大睡眠时间：为了减小误差，如果数据大小比较相近，睡眠时间较短就容易出现误差
                sleep(time*10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print(time+" ");
        }
    }

    public static void main(String[] args) {
        int num[]= {5,22,10,7,59,3,16,4,11,8,14,24,27,25,26,28,23,99};
        System.out.print("Unsorted：");
        for(int i:num) {
            System.out.print(i+" ");
        }
        System.out.print("\n  Sorted：");
        sleepThread array[]=new sleepThread[num.length];
        for(int i=0;i<array.length;i++) {
            array[i]=new sleepThread(num[i]);
            array[i].start();
        }

    }
}