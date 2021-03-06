package main;

import java.util.Arrays;

public class MinHeap {
	int heapSize;
	int[] arr;
	int heapCapacity;
	
	MinHeap(int capacity) {
		this.heapSize = 0;
		this.heapCapacity = capacity;
		this.arr = new int[this.heapCapacity];
	}
	
	int leftChild(int index) {
		return 2*index + 1;
	}
	
	int rightChild(int index) {
		return 2*index + 2;
	}
	
	int parent(int index) {
		return (index-1)/2;
	}
	
	public void insertKey(int key) {
		if (this.heapSize == this.heapCapacity) {
			System.out.println("Cannot insert more elements into the heap...");
			return;
		}
		
		this.heapSize++;
		this.arr[this.heapSize-1] = key;
		
		int currentIndex = this.heapSize-1;
		int temp;
		while (currentIndex>=0 && this.arr[this.parent(currentIndex)] > this.arr[currentIndex]) {
			temp = this.arr[this.parent(currentIndex)];
			this.arr[this.parent(currentIndex)] = this.arr[currentIndex];
			this.arr[currentIndex] = temp;
			
			currentIndex = this.parent(currentIndex);
		}
	}
	
	public void decreaseKey(int key, int index) {
		if (index > this.heapCapacity) {
			System.out.println("Index is outside the total values in the heap...");
			return;
		}
		
		if (this.arr[index] < key) {
			System.out.println("Key is at a lesser value than the one proposed for change...");
			return;
		}
		
		this.arr[index] = key;
		int temp;
		while (index >= 0 && this.arr[this.parent(index)] > this.arr[index]) {
			temp = this.arr[this.parent(index)];
			this.arr[this.parent(index)] = this.arr[index];
			this.arr[index] = temp;
			
			index = this.parent(index);
		}
	}
	
	public void minHeapify(int currentIndex) {
		int leftChildIndex = this.leftChild(currentIndex);
		int rightChildIndex = this.rightChild(currentIndex);
		
		int smallestElementIndex = currentIndex;
		if (leftChildIndex < this.heapSize && this.arr[leftChildIndex] < this.arr[currentIndex])
			smallestElementIndex = leftChildIndex;
		else if (rightChildIndex < this.heapSize && this.arr[rightChildIndex] < this.arr[smallestElementIndex])
			smallestElementIndex = rightChildIndex;
		
		if (smallestElementIndex != currentIndex) {
			int temp;
			temp = this.arr[smallestElementIndex];
			this.arr[smallestElementIndex] = this.arr[currentIndex];
			this.arr[currentIndex] = temp;
			
			this.minHeapify(smallestElementIndex);
		}
	}
	
	public void deleteKey(int index) {
		this.decreaseKey(Integer.MIN_VALUE, index);
		this.extractMin();
	}
	
	public int extractMin() {
		if (this.heapSize == 0) {
			System.out.println("No elements in the heap to extract...");
			return Integer.MAX_VALUE;
		}
		
		int toReturn = this.arr[0];
		this.arr[0] = this.arr[this.heapSize-1];
		this.heapSize--;
		
		this.minHeapify(0);
		
		return toReturn;
	}
	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(11);
    minHeap.insertKey(1); 
    minHeap.insertKey(2); 
    System.out.println(Arrays.toString(minHeap.arr));
    minHeap.deleteKey(1); 
    minHeap.insertKey(3); 
    minHeap.insertKey(4); 
    minHeap.insertKey(5); 
    minHeap.insertKey(6);
    
    System.out.println(minHeap.extractMin());
    minHeap.decreaseKey(1, 2);
    System.out.println(minHeap.extractMin());
    
	}
}
