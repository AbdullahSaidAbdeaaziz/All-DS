package com.Abdullah;

public class BST<T extends Comparable<T>>   extends Node<T> {




	private Node<T> root;

	public BST() {
		this.root = null;
	}

	public Node<T> insert(Node<T> pNode, T data) {
			if (pNode == null) {
				Node<T> newNode = new Node<>();
				newNode.data = data;
				pNode = newNode;
			}

			if (data.compareTo(pNode.data) < 0) {
				pNode.setLeft(insert(pNode.getLeft(), data));
			} else if (data.compareTo(pNode.data) > 0) {
				pNode.right = insert(pNode.right, data);
			}
			return pNode;
	}

	public void insert(T item) {
		root = insert(root, item);
	}


	public void inOrder(Node<T> root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft());
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	public void inOrder() {
		inOrder(root);
	}

	public void preOrder(Node<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.getLeft());
		preOrder(root.right);
	}
	public void preOder() {
		preOrder(root);
	}

	public void postOrder(Node<T> root) {
		if (root == null) {
			return;
		}
		postOrder(root.getLeft());
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	public void postOrder() {
		postOrder(root);
	}

	public Node<T> search (Node<T> pNode, T key) {
		if (pNode == null) {
			return null;
		}
		if (pNode.data == key) {
			return pNode;
		}

		if(key.compareTo(pNode.data) < 0) {
			return search(pNode.getLeft(), key);
		}
		else if (key.compareTo(pNode.data) > 0) {
			return search(pNode.right, key);
		}
		return null;
	}

	public boolean search(T key) {
		return search(root, key) != null;
	}

	public T findMin(Node<T> pNode) {
		if (pNode == null) {
			return null;
		} else if (pNode.getLeft() == null) {
			return pNode.data;
		}

		return findMin(pNode.getLeft());
	}

	public T findMin() {
		return findMin(root);
	}
	public T findMax() {
		return findMax(root);
	}

	public T findMax(Node<T> pNode) {
		if (pNode == null) {
			return null;
		} else if (pNode.right == null) {
			return pNode.data;
		}

		return findMin(pNode.right);
	}

	public Node<T> delete(Node<T> pNode, T item) {
			if (pNode == null) {
				return null;
			}

			if (item.compareTo(pNode.data) < 0) {
				pNode.setLeft(delete(pNode.getLeft(), item));
			} else if (item.compareTo(pNode.data) > 0) {
				pNode.right = delete(pNode.right, item);
			} else {
				// leaf Node
				if (pNode.getLeft() == null & pNode.right == null ) {
					pNode = null;
				}

				// have one child
				else if (pNode.getLeft() != null & pNode.right == null) { // in left
					pNode.data = pNode.getLeft().data;
					pNode.setLeft(null);
				}
				else if (pNode.getLeft() == null & pNode.right != null) { // in right
					pNode.data = pNode.right.data;
					pNode.right = null;
				}

				// have two children or more
				else {
					var max = findMax(pNode.getLeft());
					pNode.data = max;
					pNode.setLeft(delete(pNode.getLeft(), max));
				}
			}
			return pNode;
	}
	public boolean delete (T item) {
		return delete(root, item) != null;
	}
}
