package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;

    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO (Task 2A): enqueue
    // create new hospital.Prioritized object, insert into heap (parameters: value and priority)
    public void enqueue(V value) {
        Patient newPatient = new Patient(value);
        _heap.add(newPatient);
        bubbleUp(_heap.size() - 1);
    }

    public int bubbleUp(int index){
        int parentIndex = (int)Math.floor((index-1)/2);
        Prioritized<V, P> patient = _heap.get(index);
        Prioritized<V, P> parent = _heap.get(parentIndex);
        if (patient.compareTo(parent) == 1){ //child is greater than parent
            _heap.set(parentIndex, patient); // swap child to parent location
            _heap.set(index, parent); // swap parent to child location
            bubbleUp(parentIndex);
        }
        return index;
    }

    // TODO (Task 2A): enqueue
    @Override
    public void enqueue(V value, P priority) {
        Patient newPatient = new Patient (value, priority);
        _heap.add(newPatient);
        bubbleUp(_heap.size() - 1);
    }

    // TODO (Task 2A): dequeue
    @Override
    public V dequeue() {
        if (_heap.isEmpty()) {
            return null;
        }
        if (_heap.size() == 1){
            V returnVal = _heap.get(0).getValue();
            _heap.remove(_heap.get(0));
            return returnVal;
        }
        Prioritized<V, P> removedPatient = _heap.get(0);
        Prioritized<V, P> replacement = _heap.get(_heap.size() - 1);
        _heap.remove(replacement);
        _heap.set(0, replacement);
        bubbleDown(0);
        return removedPatient.getValue();
    }

    public void bubbleDown(int index) {
        int leftIndex = ((2*index) + 1);
        int rightIndex = ((2*index) + 2);
        Prioritized<V, P> parent = _heap.get(index);
        Prioritized <V, P> leftChild;
        Prioritized<V, P> rightChild;

        if (_heap.size()-1 < leftIndex){ // no children
            return;
        }
        if ((_heap.size() - 1 < rightIndex) && _heap.size()-1 >= leftIndex) { // only one child (left)
            leftChild = _heap.get(leftIndex);
            if (leftChild.compareTo(parent) == 1) {
                _heap.set(leftIndex, parent);
                _heap.set(index, leftChild);
                bubbleDown(leftIndex);
            }
        } else if (_heap.size()-1 >= rightIndex) { // left and right children
            leftChild = _heap.get(leftIndex);
            rightChild = _heap.get(rightIndex);
            if (leftChild.compareTo(rightChild) == 1) {
                if (leftChild.compareTo(parent) == 1) {
                    _heap.set(leftIndex, parent);
                    _heap.set(index, leftChild);
                    bubbleDown(leftIndex);
                }
            } else if (rightChild.compareTo(parent) == 1) {
                _heap.set(rightIndex, parent);
                _heap.set(index, rightChild);
                bubbleDown(rightIndex);
            }
        }
    }

    // TODO (Task 2A): getMax
    @Override
    public V getMax() {
        if (_heap.size() == 0){
            return null;
        } else {
            return _heap.get(0).getValue();
        }
    }

    // TODO (part 2B) : updatePriority
    public void updatePriority(V value, P newPriority) {
        for (int i = 0; i < _heap.size(); i++){
            if (_heap.get(i).getValue() == value){
                P oldPriority = _heap.get(i).getPriority();
                Prioritized<V, P> updatedPatient = new Patient(value, newPriority);
                _heap.set(i, updatedPatient);
                if (oldPriority.compareTo(newPriority) == 1) {
                    bubbleDown(i);
                } else if (oldPriority.compareTo(newPriority) == -1){
                    bubbleUp(i);
                }
            }
        }
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Task 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries) {
        _heap = new ArrayList<>();
        int size = initialEntries.length;
        for (int i = 0; i < size; i++){
            _heap.add(initialEntries[i]);
        }
        int lastParentIndex = (int)Math.floor((size-1)/2);
        for (int i = lastParentIndex; i >= 0; i--){
            bubbleDown(i);
        }

    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }

}
