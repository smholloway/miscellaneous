package main

import (
    "fmt"
    "math/big"
)

func intfibonacci() func() int64 {
    first, second := int64(0), int64(1)
    return func() int64 {
        first, second = second, first + second
        return first
    }
}

// fibonacci generator
func fibonacci() func() *big.Int {
    first, second := big.NewInt(0), big.NewInt(1)
    return func() *big.Int {
        first, second = second, first.Add(first, second)
        return first
    }
}

func main() {
    f := fibonacci()
    for i := 0; i < 100; i++ {
        fmt.Printf("fib(%v) = %v\n", i, f())
    }
}
