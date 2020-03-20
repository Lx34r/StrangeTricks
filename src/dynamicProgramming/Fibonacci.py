# 计算Fibonacci序列的第n项
import time

# 递归方法
def rec_fib(n):
    if n <= 1:
        return n
    else:
         return rec_fib(n-1) + rec_fib(n-2)

#自下而上的动态规划方法
def dp_fib(n):
    previousFib = 0
    currentFib = 1
    if n <= 1:
        return n

    # 重复 n-1 次
    for _ in range(n-1):
        newFib = previousFib + currentFib
        previousFib = currentFib
        currentFib = newFib

    return currentFib

if __name__ == '__main__':
 # 递归求解花费时间
    t1 = time.time()
    t = rec_fib(38)
    t2 = time.time()
    print('递归求解结果：%s, 运行时间：%s'%(t, t2-t1))
# DP求解花费时间
    s = dp_fib(38)
    t3 = time.time()
    print('DP求解结果：%s, 运行时间：%s'%(t, t3-t2))