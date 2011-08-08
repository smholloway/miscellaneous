"""
filename:    tree_print.py
author:      Seth Holloway
description: Given an unordered set of Nodes, pretty print them (with tab characters showing depth)
version:     2
"""

class Node:
	def __init__(self, label, id, parent_id):
		self.label     = label
		self.id        = id
		self.parent_id = parent_id

def tree_print(nodes):
	for node in nodes:
		if node.parent_id == 0: # root node
			print node.label
			print_below(nodes, node, 1)
	print ""

def print_below(nodes, parent_node, depth):
	for node in nodes:
		if node.parent_id == parent_node.id:
			for i in range(0,depth):
				print "\t" ,
			print node.label
			print_below(nodes, node, depth+1)

# Test a few cases
tree_print( [ Node("A", 1, 0), Node("B", 2, 0), Node("C", 3, 0) ] )
tree_print( [ Node("A", 1, 0), Node("B", 2, 1), Node("C", 3, 2) ] )
tree_print( [ Node("A", 1, 0), Node("B", 2, 0), Node("C", 3, 2) ] )
tree_print( [ Node("A", 1, 0), Node("B", 2, 3), Node("C", 3, 1) ] )
tree_print( [ Node("A", 1, 0), Node("B", 2, 1), Node("C", 3, 2), Node("D", 4, 3), Node("E", 5, 4), Node("F", 6, 5) ] )
