package main

import (
	"testing"
)

func TestPyramidOut(t *testing.T) {
	const in1, out1 = 1, "*\n"
	if x := PyramidOut(in1); x != out1 {
		t.Errorf("Pyramid(%i) = %s... expecting %s", in1, x, out1)
	}
	const in2, out2 = 2, " * \n***\n"
	if x := PyramidOut(in2); x != out2 {
		t.Errorf("Pyramid(%i) = %s... expecting %s", in2, x, out2)
	}
	const in3, out3 = 3, "  *  \n *** \n*****\n"
	if x := PyramidOut(in3); x != out3 {
		t.Errorf("Pyramid(%i) = %s... expecting %s", in3, x, out3)
	}
}
