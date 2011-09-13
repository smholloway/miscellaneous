package com.sethholloway;

public class BinarySearchTree<T extends Comparable<T>> implements iTree<T> {
	private TreeNode<T> root;
	
	public BinarySearchTree() {
		root = new TreeNode<T>();
	}
	
	public BinarySearchTree(T value) {
		root = new TreeNode<T>(value);
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}
	
	@Override
	public String toString() {
		return (root.toString());
	}
	
	public void inOrder() {
		System.out.print("inOrder:   ");
		inOrder(root);
		System.out.println();
	}
	
	public void inOrder(TreeNode<T> node) {
		if (node.getValue() == null || node == null) return;
		if (node.getLeft() != null) {
			inOrder(node.getLeft());
		}
		System.out.print(node.getValue() + " ");
		if (node.getRight() != null) {
			inOrder(node.getRight());
		}
	}
	
	public void preOrder() {
		System.out.print("preOrder:  ");
		preOrder(root);
		System.out.println();
	}

	public void preOrder(TreeNode<T> node) {
		if (node.getValue() == null) return;
		System.out.print(node.getValue() + " ");
		if (node.getLeft() != null) {
			preOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			preOrder(node.getRight());
		}
	}
	
	public void postOrder() {
		System.out.print("postOrder: ");
		postOrder(root);
		System.out.println();
	}
	
	public void postOrder(TreeNode<T> node) {
		if (node.getValue() == null || node == null) return;
		if (node.getLeft() != null) {
			postOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			postOrder(node.getRight());
		}
		System.out.print(node.getValue() + " ");
	}
	

	@Override
	public boolean contains(T value) {
		return nodeContains(root, value); 
	}
	
	private boolean nodeContains(TreeNode<T> node, T value) {
		boolean result = false;
		
		if (node.getValue() == value) {
			return true;
		} else {
			result = nodeContains(node.getLeft(), value) || nodeContains(node.getRight(), value);
		}
		
		return result;
	}

	@Override
	public boolean add(T value) {
		if (root == null || root.getValue() == null) {
			root = new TreeNode<T>(value);
			return true;
		} else {
			return root.add(value);
		}
	}
	
	private boolean addToNode(TreeNode<T> node, T value) {
		System.out.println("addToNode: " + node.toString() + " = " + value);
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
