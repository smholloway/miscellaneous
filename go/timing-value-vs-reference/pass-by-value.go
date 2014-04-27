package main

import (
	"fmt"
)

func UpdateValueByValue(someVal int) int {
	return someVal + 1
}

func main() {
	val := 0
	val = UpdateValueByValue(val)
	fmt.Println("Done")
}
