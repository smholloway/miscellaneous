package com.sethholloway;

public class TreeNode {
	private Object value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode() {
		value = null;
		left  = null;
		right = null;
	}
	
	public TreeNode(Object input) {
		value  = input;
		left  = null;
		right = null;
	}
	
	public Object getValue() {
		return value;
	}

	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Integer) value;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (!(obj instanceof TreeNode)) {
			return false;
		}
		TreeNode other = (TreeNode) obj;
		if (value != other.value) {
			return false;
		} if (left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!left.equals(other.left)) {
			return false;
		} else if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "(" + value + ")";
	}
}
