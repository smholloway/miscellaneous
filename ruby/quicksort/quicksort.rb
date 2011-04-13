def main()
	# Test empty array
	a_unsorted = Array.new 
	# Test array of size 1
	b_unsorted = [0]
	# Test random even-numbered array
	c_unsorted = [1,4,3,2]
	# Test worst-case odd-numbered array
	d_unsorted = [5,4,3,2,1]
	# Test large even-numbered array
	e_unsorted = Array.new
	100.times { |i| e_unsorted.unshift(i) }
	# Test large odd-numbered array
	f_unsorted = Array.new
	99.times { |i| f_unsorted.unshift(i) }
	# Test large all-same array
	g_unsorted = Array.new 
	100.times { |i| g_unsorted.unshift(1) }

	test(a_unsorted,true)
	test(b_unsorted)
	test(c_unsorted)
	test(d_unsorted)
	test(e_unsorted)
	test(f_unsorted)
	test(g_unsorted)
end

def test(array,debug=false)
	sorted = quicksort(array)
	puts "========================="
	puts (sorted==array.sort ? "PROPERLY" : "IMPROPERLY") + " SORTED"
	if (debug==true)
		puts "-------------------------"
		puts "  array unsorted   = " + array.inspect
		puts "  array quick_sort = " + sorted.inspect
		puts "  array ruby_sort  = " + array.sort.inspect
		puts "-------------------------"
	end
	puts "========================="
end

def quicksort(array)
	if array.length <= 1
		return array
	end

	a = array.clone
	less = Array.new 
	more = Array.new 
	pivot = Array.new 
	pivot << a.pop

	a.each do |element|
		if element < pivot.first
			less.unshift(element)
		else
			more.unshift(element)
		end
	end
	return ( quicksort(less) + (pivot) + quicksort(more) )
end

main()
