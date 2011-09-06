package com.sethholloway;

public class BinarySearchTree<T extends Comparable<T>> implements iTree<T> {
	private TreeNode root;
	
	public BinarySearchTree() {
		root = new TreeNode<T>();
	}
	
	public BinarySearchTree(T value) {
		root = new TreeNode<T>(value);
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
	
	public void inOrder(TreeNode node) {
		if (node == null) return;
		inOrder(node.getLeft());
		System.out.println(node.getValue());
		inOrder(node.getRight());
	}

	public void preOrder(TreeNode node) {
		if (node == null) return;
		System.out.println(node.getValue());
		inOrder(node.getLeft());
		inOrder(node.getRight());
	}
	
	public void postOrder(TreeNode node) {
		if (node == null) return;
		inOrder(node.getLeft());
		inOrder(node.getRight());
		System.out.println(node.getValue());
	}
	

	@Override
	public boolean contains(T value) {
		return nodeContains(root, value);
	}
	
	private boolean nodeContains(TreeNode node, T value) {
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
	
	private boolean addToNode(TreeNode node, T value) {
		if (node.getValue() == null) {
			node.setValue(value);
		} else {
			if (node.getValue().compareTo(value) > 0) { // value is larger than node, go right
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
