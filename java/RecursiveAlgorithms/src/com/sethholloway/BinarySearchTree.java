package com.sethholloway;

public class BinarySearchTree<T extends Comparable<T>> implements iTree {
	private TreeNode root;
	
	public BinarySearchTree() {
		root = new TreeNode();
	}
	
	public BinarySearchTree(T value) {
		root = new TreeNode(value);
	}

	@Override
	public boolean contains(T value) {
		return nodeContains(root, value);
	}
	
	private static boolean nodeContains(TreeNode node, Object value) {
		boolean result = false;
		
		if (node.getValue() == value) {
			return true;
		} else {
			result = nodeContains(node.getLeft(), value) | nodeContains(node.getRight(), value);
		}
		
		return result;
	}

	@Override
	public boolean add(T value) {
		return addToNode(root, value);
	}
	
	private static boolean addToNode(TreeNode node, Object value) {
		
		if (node.getValue() == null) {
			node.setValue(value);
		} else {
			if (value.U) {
				addToNode(node.getLeft(), value);
			} else {
				addToNode(node.getRight(), value);
			}
		}
		
		
		return true;	
	}

	@Override
	public boolean remove(T value) {
		boolean result = false;
		
		return result;
	}

}
