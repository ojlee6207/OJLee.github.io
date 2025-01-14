def sum(a,b,c):
    return a+b+c

def average(a,b,c):
    return sum(a,b,c)/3

def passfail(a,b,c):
    avg = average(a,b,c)
    if avg >= 60 and a>=40 and b>=40 and c>=40:
        return "합격"
    else:
        return "불합격"

if __name__ == '__main__':
    print(sum(100,30,50))