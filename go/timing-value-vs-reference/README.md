To run the timing program, move or rename `pass-by-value.go` and
`pass-by-reference.go` then run the program (`go run timing.go`).

Interested in digging into the assembly to understand the differences? Check out
`assembly-pass-by-value.txt` and `assembly-pass-by-reference.txt`.

Want to generate the assembly yourself? Move or rename the files that
you're not interested in then disassemble with `go build -gcflags -S`

So, which is faster? Pass by reference.

Here are a few runs:

By Value
  Fastest: 19.265219ms
  Average: 21.410666ms
  Slowest: 27.281903ms
By Reference
  Fastest: 17.157218ms
  Average: 18.822421ms
  Slowest: 24.389609ms

By Value
  Fastest: 19.451264ms
  Average: 21.321204ms
  Slowest: 26.318904ms
By Reference
  Fastest: 17.247808ms
  Average: 18.519086ms
  Slowest: 26.185171ms

By Value
  Fastest: 19.23559ms
  Average: 21.357345ms
  Slowest: 28.037467ms
By Reference
  Fastest: 17.24377ms
  Average: 19.106385ms
  Slowest: 24.739507ms

