import random

# http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
def shuffle(l):
    for i in range(len(l)-1, 0, -1):
        r = random.randint(0, i)
        l[i], l[r] = l[r], l[i]
    return l

def tests():
    print shuffle([]) == []
    print shuffle([1]) == [1]
    # The shuffle can return the same list, so these tests are brittle.
    print test_shuffle_probabilistically([1,2])
    print test_shuffle_probabilistically([1,2,3,4,5])
    print test_shuffle_probabilistically([1,2,3,4,5,6,7,8,9,10])

# Because the shuffle can return itself, we will test 10 combinations 
#   and see if the input ever differs from the output
def test_shuffle_probabilistically(l):
    for i in range(10):
        they_do_differ = shuffle(l) == l
        if they_do_differ:
            return True
    return False

if __name__ == "__main__":
    tests()
