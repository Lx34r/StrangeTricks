import numpy as np
import random
"""
def Fisher_yate_shuffle(arr):
    length=len(arr)
    for i in range(length)[::-1]:#倒序遍历
        j=random.randint(0,i)    #随机选取0和i之间的一个数j
        #exchange arr[i] and arr[j]
        temp=arr[i]
        arr[i]=arr[j]
        arr[j]=temp
    return arr
    
if __name__=='__main__':
    array = np.arange(1,10)
    shuffle = Fisher_yate_shuffle(array)
    print(shuffle)
"""

def rand():
    return random.randint(0,100000000)

#当序列的长度小于我们随机的数，如何映射到指定范围

def Fisher_yate_shuffle(arr):
    length = len(arr)
    a = range(length) # 给定数组的长度列表
    a.reverse() # 倒序方式进行遍历
    for i in a: # 从大到小取索引
        #j=random.randint(0,i)
        j = rand()
        j = j % length #取余操作进行映射
        #exchange arr[i] and arr[j]
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    return arr

if __name__=='__main__':
    array = np.arange(1,200)
    shuffle = Fisher_yate_shuffle(array)

    print(len(set(shuffle)))
    print(len(shuffle))