def fibonacci(n, memo={}):
    try:
        value = memo[n]
    except KeyError:
        if n <= 0:
            value = 0
        elif n == 1:
            value = 1
        else:
            value = fibonacci(n-1) + fibonacci(n-2)
        memo[n] = value
    return value

def test():
    print "===== TESTS ====="
    print fibonacci(0) == 0
    print fibonacci(1) == 1
    print fibonacci(2) == 1
    print fibonacci(3) == 2
    print fibonacci(4) == 3
    print fibonacci(5) == 5
    print fibonacci(10) == 55
    print fibonacci(16) == 987
    print fibonacci(100) == 354224848179261915075

if __name__ == '__main__':
    test()
