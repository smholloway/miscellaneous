def main()
#	puts "method=main"
  a = [1,2,4,3,5]
  b = [1,2,3,4,5]
  c = [5,4,3,2,1]
  d = [1,2,3,4,5]
  puts "a before sort = " + a.to_s
	a = mergesort(a)
  puts "a after sort = " + a.to_s

	if (mergesort(a) == b)
		puts "a did sort to b"
	else
		puts "a did not sort to b"
	end
	puts "a did " + (mergesort(a)==b ? "" : "not") + "sort to b"
end

def mergesort(input_array)
#	puts "method=mergesort"
	if input_array.count < 2
#		puts "input array smaller than 2:  " + input_array.to_s
		return input_array
	end

	middle = input_array.count / 2

	left = input_array[0..middle-1]
	right = input_array[middle..input_array.count]

	left = mergesort(left)
	right = mergesort(right)
	result = merge(left, right)

#puts "results after sort = " + result.to_s

	return result
end

def merge(left, right)
#	puts "method=merge"
#	puts "left = " + left.to_s
#	puts "right = " + right.to_s
	result = []

	while(left.count > 0 or right.count > 0)
		if (left.count > 0 and right.count > 0)
			if (left.first <= right.first)
				result.push(left.first)
				left = left[1..left.count]
			else
				result.push(right.first)
				right = right[1..right.count]
			end
		elsif (left.count > 0)
			result.push(left.first)
			left = left[1..left.count]
		elsif (right.count > 0)
			result.push(right.first)
			right = right[1..right.count]
		end
	end
	return result
end

main()
