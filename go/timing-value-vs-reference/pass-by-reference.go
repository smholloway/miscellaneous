package main

import (
	"fmt"
)

func UpdateValueByReference(someVal *int) {
	*someVal = *someVal + 1
}

func main() {
	val := 0
	UpdateValueByReference(&val)
	fmt.Println("Done")
}
