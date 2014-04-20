package main

import (
	"fmt"
)

func main() {
	const in = "reverse"
	reversed := Reverse(in)
	fmt.Printf("reverse: %s\n", reversed)
}

func Reverse(in string) string {
	runes := []rune(in)
	for i, j := 0, len(in)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}
