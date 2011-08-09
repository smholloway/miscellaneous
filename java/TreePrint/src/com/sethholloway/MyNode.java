package com.sethholloway;

import java.util.ArrayList;
import java.util.List;

public class MyNode {
	private final String label;
	private final int id;
	private final int parent_id;
	
	public MyNode() {
		this.label     = "";
		this.id        = 0;
		this.parent_id = 0;
	}
	
	public MyNode( String _label, int _id, int _parent_id ) {
		this.label     = _label;
		this.id        = _id;
		this.parent_id = _parent_id;
	}
	
	public static void print( List<MyNode> nodes ) {
		for ( MyNode node : nodes ) {
			if ( node.parent_id == 0 ) {
				System.out.println(node.label);
				printBelow( nodes, node, 1 );
			}
		}
	}
	
	private static void printBelow( List<MyNode> nodes, MyNode currentNode, int depth ) {
		for ( MyNode node : nodes ) {
			if ( node.parent_id == currentNode.id ) {			
				for ( int i = 0; i < depth; i++ ) {
					System.out.print("\t");
				}
				System.out.println(node.label);
				printBelow( nodes, node, depth+1 );
			}
		}
	}

}
