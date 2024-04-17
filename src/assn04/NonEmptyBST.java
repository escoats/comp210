package assn04;
import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	@Override
	public BST<T> insert(T element) {
		if (isEmpty()) {
			return new NonEmptyBST<T>(element);
		}

		T root = this._element;
		if (element.compareTo(root) == 1) {
			if (_right.isEmpty()) {
				_right = new NonEmptyBST<T>(element);
				return this;
			} else {
				_right.insert(element);
			}
		}
		if (element.compareTo(root) == -1) {
			if (_left.isEmpty()) {
				_left = new NonEmptyBST<T>(element);
				return this;
			} else {
				_left.insert(element);
			}
		}
		if (element.compareTo(root) == 0) {
			return this;
		}
		return this;
	}

	@Override
	public BST<T> remove(T element) {
		if (isEmpty()) {
			return this;
		}
		T root = _element;

		if (element.compareTo(root) == 1) {
			_right = _right.remove(element);
		}
		if (element.compareTo(root) == -1) {
			_left = _left.remove(element);
		}
		if (element.compareTo(root) == 0) {
			return deleteNode();
		}
		return this;
	}

	public BST<T> deleteNode(){
		if (getLeft().isEmpty()){
			return getRight();
		}
		if (getRight().isEmpty()){
			return getLeft();
		}
		if (getLeft().isEmpty() && getRight().isEmpty()){
			return new EmptyBST<T>();
		} else{
			T successor = _right.findMin();
			_element = successor;
			_right = _right.remove(successor);
		}
		return this;
	}
	// TODO: remove all in range (inclusive)
	@Override
	public BST<T> remove_range(T start, T end) {
		if (isEmpty()) {
			return this;
		}
		_left = _left.remove_range(start, end);
		_right = _right.remove_range(start, end);
		if (_element.compareTo(start) >= 0 && _element.compareTo(end) <= 0) {
			return remove(_element);
		}
		return this;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(_element + " ");
		if (_left.isEmpty() == false) {
			_left.printPreOrderTraversal();
		}
		if (_right.isEmpty() == false) {
			_right.printPreOrderTraversal();
		}
	}
	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (_left.isEmpty() == false){
			_left.printPostOrderTraversal();
		} if (_right.isEmpty() == false){
			_right.printPostOrderTraversal();
		}
		System.out.print(_element + " ");
	}

	// The findMin method returns the minimum value in the tree.
	@Override
	public T findMin() {
		if(_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	@Override
	public int getHeight() {
		return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
