package com.Abdullah;

public class Node <T extends Comparable<? extends  T>> {
		public T data;
		private Node<T> left;
		public Node<T> right;
		Node() {
			data = null;
			setLeft(right = null);
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

}
