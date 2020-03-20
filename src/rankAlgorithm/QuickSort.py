def patition(ls, first, last):  # 分裂函数：功能是选取一个‘对比值’，所有大于对比值的后移，小于对比值的前移
    mid = ls[first]  # 选取‘中值’，方便起见选取列表第一位
    leftmark = first + 1
    rightmark = last  # 左右标初值
    done = True
    while done:
        while leftmark <= rightmark and ls[leftmark] <= mid:  # 向右移动左标
            leftmark += 1
        while ls[rightmark] >= mid and leftmark <= rightmark:  # 向左移动右标
            rightmark -= 1
        if leftmark > rightmark:  # 两标交叉，结束循环
            done = False
        else:
            ls[leftmark], ls[rightmark] = ls[rightmark], ls[leftmark]  # 左右标值互换
    ls[first], ls[rightmark] = ls[rightmark], ls[first]  # '中值'就位
    return rightmark


def quickSort(ls):
    quickSortHelper(ls, 0, len(ls) - 1)


def quickSortHelper(ls, first, last):
    if first < last:
        splitpoint = patition(ls, first, last)
        quickSortHelper(ls, first, splitpoint - 1)
        quickSortHelper(ls, splitpoint + 1, last)


# 时间复杂度分析：快速排序分为两部分，分裂和移动。如果每次分裂都能分成均匀两部分，那么复杂度就是O(log n)
# 移动需要将每一项与中值进行对比，复杂度是O(n)
# 综合起来就是O(nlog n)，且不需要额外储存空间

# 缺点是中值选取过于偏离中部，造成左右分裂不平衡，复杂度可能到O(n2),加上递归的开销，比冒泡排序法还糟糕
# 所以问题的关键就是选择“中值”
if __name__ == '__main__':
    ls = [5, 4, 3, 2, 1, 9, 8, 7, 6]
    quickSort(ls)
    print(ls)
