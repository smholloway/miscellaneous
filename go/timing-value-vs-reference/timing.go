package main

import (
	"fmt"
	"sort"
	"time"
)

type ComparableDuration []time.Duration

func (d ComparableDuration) Len() int {
	return len(d)
}

func (d ComparableDuration) Swap(i, j int) {
	d[i], d[j] = d[j], d[i]
}

func (d ComparableDuration) Less(i, j int) bool {
	return d[i] < d[j]
}

func UpdateValueByValue(someVal int) int {
	return someVal + 1
}

func UpdateValueByReference(someVal *int) {
	*someVal = *someVal + 1
}

func FindAverageTime(times []time.Duration) time.Duration {
	n := len(times)
	sum := int64(0)
	for i := 0; i < n; i++ {
		sum += times[i].Nanoseconds()
	}
	return time.Duration(float64(sum) / float64(n))
}

func PrintTimeStatistics(message string, times []time.Duration) {
	sort.Sort(ComparableDuration(times))
	fmt.Println(message)
	fmt.Printf("\tFastest: %v\n", times[0])
	fmt.Printf("\tAverage: %v\n", FindAverageTime(times))
	fmt.Printf("\tSlowest: %v\n", times[len(times)-1])
}

func main() {
	val := 0
	const iterations = 1000
	timesByValue := make([]time.Duration, iterations)
	for i := 0; i < iterations; i++ {
		start := time.Now()
		for j := 0; j < 10000000; j++ {
			val = UpdateValueByValue(val)
		}
		elapsed := time.Now().Sub(start)
		timesByValue[i] = elapsed
	}
	PrintTimeStatistics("By Value", timesByValue)

	val = 0
	timesByReference := make([]time.Duration, iterations)
	for i := 0; i < iterations; i++ {
		start := time.Now()
		for j := 0; j < 10000000; j++ {
			UpdateValueByReference(&val)
		}
		elapsed := time.Now().Sub(start)
		timesByReference[i] = elapsed
	}
	PrintTimeStatistics("By Reference", timesByReference)
}
