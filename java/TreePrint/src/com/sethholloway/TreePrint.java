package com.sethholloway;

import java.util.ArrayList;
import java.util.List;

public class TreePrint {
	public static void main( String[] args ) {
		List<MyNode> nodes = initializeNodes();
		
		// print the tree with depth shown with tabs
		MyNode.print( nodes );
	}
	
	public static List initializeNodes() {
		// create a list of nodes representing a tree
		List<MyNode> nodes = new ArrayList<MyNode>();
		
		nodes.add(new MyNode( "A", 1, 0 ));
		nodes.add(new MyNode( "B", 2, 1 ));
		nodes.add(new MyNode( "C", 3, 2 ));
		nodes.add(new MyNode( "D", 4, 1 ));
		nodes.add(new MyNode( "E", 5, 0 ));
		nodes.add(new MyNode( "F", 6, 5 ));
		nodes.add(new MyNode( "G", 7, 6 ));
		nodes.add(new MyNode( "H", 8, 7 ));
		nodes.add(new MyNode( "I", 9, 8 ));
		
		return nodes;
	}
}