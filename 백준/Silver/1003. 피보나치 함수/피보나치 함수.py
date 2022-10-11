zero = 0
one = 0

# def fibonacci(n):
#     global zero
#     global one
#     if n==0:
#         #print("0")
#         zero += 1
#         return 0
#     elif n == 1:
#         #print("1")
#         one += 1
#         return 1
#     else:
#         return fibonacci(n-1) + fibonacci(n-2)

def fibonacci(n):
    cache = [0 for _ in range(n+1)]

    for j in range(n+1):
        #print(j)
        if j == 0:
            cache[j] = 0
        elif j == 1:
            cache[j] = 1
        else:
            cache[j] = cache[j - 1] + cache[j - 2]
    #print(cache)
    return cache[n]

if __name__ == "__main__":

    n = int(input())
    for i in range(n):
        num = int(input())
        if num == 0:
            print(1, 0)
        else:
            print(fibonacci(num-1), fibonacci(num))
    # for n in range(1, 11):
    #     print(n, fibonacci(n))