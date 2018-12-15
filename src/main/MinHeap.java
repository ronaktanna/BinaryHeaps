package main;

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
		
		if (key < this.arr[index]) {
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
}
