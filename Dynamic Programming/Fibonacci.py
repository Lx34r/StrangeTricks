# calculate nth item of Fibonacci Sequence
import time

# recursive method
def rec_fib(n):
    if n <= 1:
        return n
    else:
         return rec_fib(n-1) + rec_fib(n-2)

# bottom up approach of Dynamic Programming
def dp_fib(n):
    previousFib = 0
    currentFib = 1
    if n <= 1:
        return n

    # repeat n-1 times
    for _ in range(n-1):
        newFib = previousFib + currentFib
        previousFib = currentFib
        currentFib = newFib

    return currentFib

 # time cost of cursive method
t1 = time.time()
t = rec_fib(38)
t2 = time.time()
print('结果：%s, 运行时间：%s'%(t, t2-t1))
# time cose of DP method
s = dp_fib(38)
t3 = time.time()
print('结果：%s, 运行时间：%s'%(t, t3-t2))