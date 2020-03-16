import java.util.Date;
import java.math.BigInteger;

public class Fibonacci {
    // 主函数
    public static void main(String[] args) {
        Date start_time =  new Date(); //开始时间
        int n = 38;
        BigInteger t1 = DP_fib(n);  // 动态规划法求解
        Date end_time1 =  new Date(); // 结束时间
        Long cost_time1 = end_time1.getTime()-start_time.getTime();  // 计算时间，返回毫秒数
        System.out.println(String.format("The fib(%d) is %s.\nDP Cost time is %.3fs.", n, t1, cost_time1*1.0/1000));


        BigInteger t2 = rec_fib(n);  // 递归法求解
        Date end_time2 =  new Date(); // 结束时间
        Long cost_time2 = end_time2.getTime()-end_time1.getTime();  // 计算时间，返回毫秒数
        System.out.println(String.format("The fib(%d) is %s.\nrec Cost time is %.3fs.", n, t2, cost_time2*1.0/1000));

    }

    // 利用递归方法计算斐波那契数列的第n项
    public static BigInteger rec_fib(int n){
        if(n == 0)
            return BigInteger.ZERO;
        if(n ==1)
            return BigInteger.ONE;
        else
            return rec_fib(n-1).add(rec_fib(n-2));
    }

    // 利用动态规划法(DP)计算斐波那契数列的第n项
    public static BigInteger DP_fib(int n){
        if(n == 0)
            return BigInteger.ZERO;
        if(n == 1)
            return BigInteger.ONE;
        else {
            BigInteger previousFib = BigInteger.ZERO;
            BigInteger currentFib = BigInteger.ONE;
            BigInteger newFib;

            for(int i=1; i<n; i++){ // 重复循环n-1次
                newFib =  previousFib.add(currentFib);
                previousFib = currentFib;
                currentFib = newFib;
            }

            return currentFib;
        }
    }
}