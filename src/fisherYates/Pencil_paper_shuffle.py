import numpy as np
import random

def Pencil_paper_shuffle(arr):
    arr = list(arr)
    new_arr = []
    length = len(arr)
    print(length)
    while(length>0):
        j = random.randint(0,length-1)
        new_arr.append(arr[j])
        arr.remove(arr[j])
        #arr[j] = arr[length-1]
        length -=1
        print('arr is {}---new_arr is {}'.format(arr, new_arr))
    return new_arr

if __name__=='__main__':
    array=np.arange(1,10)
    shuffle = Pencil_paper_shuffle(array)
    print(shuffle)