def indentation_checker(input):
	# ensure the first line is left-aligned at 0
	if (spaces(input[0]) != 0):
		return False

	# emulate a stack with a list
	indent_level = []
	indent_level.append(0)

	# flag to determine if previous line encountered was a control flow statement
	previous_line_was_control = False

	# iterate over all input lines
	for line in input:
		previous_indentation_level = indent_level[-1]
		current_indentation_level = spaces(line)	

		if previous_line_was_control:
			# ensure we have added spaces after a control flow statement
			if current_indentation_level <= indent_level[-1]:
				return False
			previous_line_was_control = False
			indent_level.append(current_indentation_level)

		# are we at a valid indent level?
		if not current_indentation_level in indent_level:
			return False

		# is this line a control flow statement
		if line.endswith(":"):
			previous_line_was_control = True
			previous_indentation_level = current_indentation_level

	# check to see that we did not exit without an indentation after a control flow statement
	if previous_line_was_control:
		return False

	# if we made it this far, the indentation was clean
	return True

# generic function to return the number of spaces at the beginning of a string
def spaces(input):
	if input.startswith(' '):
		return 1 + spaces(input[1:])
	else:
		return 0

# main will check the indentation in this file
def main():
	# read this program into a variable so we can check indentation on a working file
	filename = "indentation_checker.py" 
	source = open(filename, 'r').readlines()
	# if this program compiles and runs via python indentation_checker.py
	#   we should see that the indentation check is True
	print "Indentation check on %s is %s" %(filename, indentation_checker(source))

# some tests
def test():
	print "### TESTS RUNNING ###"
	print spaces(" test") , "should be 1"
	print spaces("  test") , "should be 2"
	print spaces("   test") , "should be 3"
	print indentation_checker([" def main():"]) , "should be False"
	print indentation_checker(["def main():"]) , "should be False"
	print indentation_checker(["print foo"]) , "should be True"
	print indentation_checker(["def main():", "  print foo"]) , "should be True"
	print indentation_checker(["def main():", "  print foo", "print bar"]) , "should be True"
	print indentation_checker(["def main():", "print foo", "print bar"]) , "should be False"
	print indentation_checker(["print begin", "def main():", "  print foo", "  print bar"]) , "should be True"
	print indentation_checker(["def main():", "  if True:", "    print 'True'", "print 'end'"]) , "should be True"
	print indentation_checker(["print begin", " def main():"]) , "should be False"
	print indentation_checker(["print begin", "def main():", " print 'begin'", "  print 'end'"]) , "should be False"
	print "### TESTS COMPLETED ###\n"

test()
main()
