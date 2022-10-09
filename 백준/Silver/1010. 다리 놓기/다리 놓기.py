num = int(input())
list = []
for _ in range(num):
    i = input()

    N ,M = i.split()
    N = int(N)
    M = int(M)
    T = M-N

    M_P = 1
    N_P = 1
    T_P = 1

    for i in range(M):
        M_P *= i+1

    for i in range(N):
        N_P *= i+1

    for i in range(T):
        T_P *= i+1


    print(int(M_P/(N_P*T_P)))
