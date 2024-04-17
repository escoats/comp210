package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private int _height;
    private int _size;
    
    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
        _height = -1;
        _size = 0;
    }

    /**
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateLeft() {
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO

         return null;
     }
    
    /**
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO

         return null;
     }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return _height;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) { // TODO - done?
        if (element.compareTo(_value) == -1){
            if (_left.isEmpty()){
                _left = new AVLTree<T>();
                _left._value = element;
                _left._height ++;
                _size ++;

            } else {
                _left.insert(element);
            }
        } else if (element.compareTo(_value) == 1){
            if (_right.isEmpty()){
                _right = new AVLTree<T>();
                _right._value = element;
                _right._height++;
                _size ++;
            } else {
            _right.insert(element);
            }
        }
        return rebalance();
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
    	// TODO
        if (element.compareTo(_value) == -1){ // element to be removed is smaller than root, go left
            _left.remove(element);
            _left._height --;
            _size--;
        } else if (element.compareTo(_value) == 1){
            _right.remove(element);
            _right._height --;
            _size--;
        } else if (element.compareTo(_value) == 0){
            // delete the node

        }

        return rebalance();
    }

    @Override
    public T findMin() { // TODO: done?
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (_left.isEmpty()) {
            return _value;
        }
        return _left.findMin();
    }

    @Override
    public T findMax() { // TODO: done?
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (_right.isEmpty()){
            return _value;
        }
        return _right.findMax();
    }

    @Override
    public boolean contains(T element) {
    	// TODO
        // while loop? if element is found, return True and break the loop.
        // if entire tree has been traversed without finding the element, return false

        return false;
    }


    @Override
    public boolean rangeContain(T start, T end) {
        // TODO

        return false;
    }


    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }
         return _right;
    }

    public boolean isBalanced(){
         // find balance factor lmao
        int balanceFactor = _right.height() - _left.height();
        if (balanceFactor < -1 || balanceFactor > 1){
            return false;
        } else{
            return true;
        }
    }

    public SelfBalancingBST<T> rebalance(){
        if (isBalanced()){
            return this;
        } else{
            // rebalance tree.
            // fuck.
        }
        return null;
    }

    public int balanceFactor(){
         return _right.height() - _left.height();
    }
}

