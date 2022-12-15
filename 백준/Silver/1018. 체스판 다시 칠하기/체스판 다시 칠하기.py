InPut = input()
start_b = []
start_w = []
w, h = InPut.split()

w = int(w)
h = int(h)

board = []
for i in range(w):
    board.append(input())

for i in range(w):
    a = []
    b = []
    for j in range(h):
        a.append(0)
        b.append(0)
    start_b.append(a)
    start_w.append(b)


for i in range(w):
    for j in range(h):
        if ((i+1) % 2 == 0 and (j+1) % 2 == 0) or ((i+1) % 2 == 1 and (j+1)%2==1):
            start_w[i][j] = 'W'
            start_b[i][j] = 'B'
        else:
            start_w[i][j] = 'B'
            start_b[i][j] = 'W'

berror, werror = 0,0
be_list = []
we_list = []

for a in range(0,w-8+1):
    for b in range(0,h-8+1):
        for i in range(0,8):
            for j in range(0,8):
                if board[a+i][b+j] != start_b[i][j]:
                    berror += 1
                elif board[a+i][b+j] != start_w[i][j]:
                    werror += 1
        be_list.append(berror)
        we_list.append(werror)
        berror, werror = 0, 0

print(min(min(be_list),min(we_list)))




