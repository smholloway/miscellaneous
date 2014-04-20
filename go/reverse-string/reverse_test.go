package main

import "testing"

func TestReverse(t *testing.T) {
	const in, out = "reverse", "esrever"
	if x := Reverse(in); x != out {
		t.Errorf("Reverse(%s) = %s, expected %s\n", in, x, out)
	}
	if x := Reverse(Reverse(in)); x != in {
		t.Errorf("Reverse(Reverse(%s() = %s, expected %s\n", in, x, in)
	}
}
