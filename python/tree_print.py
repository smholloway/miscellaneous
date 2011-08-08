class Node:
	def __init__(self, label, id, parent_id):
		self.label=label
		self.id=id
		self.parent_id=parent_id
		self.children=[]

	def add_child(parent, child):
		parent.children.append(child)

def pp(nodes):
	pp_stack = []
	for node in nodes:
		if node.parent_id == 0:
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

pp( [ Node("A", 1, 0), Node("B", 2, 0), Node("C", 3, 0) ] )

pp( [ Node("A", 1, 0), Node("B", 2, 1), Node("C", 3, 2) ] )

pp( [ Node("A", 1, 0), Node("B", 2, 0), Node("C", 3, 2) ] )

pp( [ Node("A", 1, 0), Node("B", 2, 3), Node("C", 3, 1) ] )

pp( [ Node("A", 1, 0), Node("B", 2, 1), Node("C", 3, 2), Node("D", 4, 3), Node("E", 5, 4), Node("F", 6, 5) ] )
