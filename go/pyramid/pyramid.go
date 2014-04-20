package main

import (
	"bytes"
	"fmt"
	"strings"
)

func main() {
	fmt.Printf("Pyramid\n")
	Pyramid(1)
	Pyramid(2)
	Pyramid(10)
	fmt.Printf("PyramidOut\n")
	fmt.Printf("%s\n", PyramidOut(1))
	fmt.Printf("%s\n", PyramidOut(2))
	fmt.Printf("%s\n", PyramidOut(10))
}

/* Not so testable */
func Pyramid(in int) {
	for i := 0; i < in; i = i + 1 {
		asterisks := strings.Repeat("*", (i+1)*2-1)
		spaces := strings.Repeat(" ", in-i-1)
		fmt.Printf("%s%s%s\n", spaces, asterisks, spaces)
	}
}

/* More testable */
func PyramidOut(in int) string {
	var buffer bytes.Buffer
	for i := 0; i < in; i = i + 1 {
		asterisks := strings.Repeat("*", (i+1)*2-1)
		spaces := strings.Repeat(" ", in-i-1)
		line := strings.Join([]string{spaces, asterisks, spaces, "\n"}, "")
		buffer.WriteString(line)
	}
	return buffer.String()
}
