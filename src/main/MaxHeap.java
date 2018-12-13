package main;

public class MaxHeap {
	
	int heapSize; // Current size of the heap
	int[] arr;
	int heapCapacity; // MAX nodes the heap can accommodate
	
	MaxHeap(int capacity) {
		this.heapSize = 0;
		this.heapCapacity = capacity;
		this.arr = new int[this.heapCapacity];
	}
	
	/* MaxHeapify the tree from the current index. */
	public void maxHeapify(int currentIndex) {
		int leftChildIndex = 2*currentIndex + 1;
		int rightChildIndex = 2*currentIndex + 2;
		
		int largestElementIndex = currentIndex;
		if (leftChildIndex < this.arr.length && this.arr[leftChildIndex] > this.arr[currentIndex])
			largestElementIndex = leftChildIndex;
		if (rightChildIndex < this.arr.length && this.arr[rightChildIndex] > this.arr[currentIndex])
			largestElementIndex = rightChildIndex;
		
		if (largestElementIndex != currentIndex) {
			int leftChild = this.arr[leftChildIndex];
			int rightChild = this.arr[rightChildIndex];
			
			int temp;
			if (Math.max(leftChild, rightChild) == leftChild) {
				temp = this.arr[currentIndex];
				this.arr[currentIndex] = leftChild;
				this.arr[leftChildIndex] = temp;
				
				this.maxHeapify(leftChildIndex);
			} else {
				temp = this.arr[currentIndex];
				this.arr[currentIndex] = rightChild;
				this.arr[rightChildIndex] = temp;
				
				this.maxHeapify(rightChildIndex);
			}
			
		}
	}
	
	/* Insert a key into the MaxHeap */
	public void insertKey(int key) {
		if (this.heapSize == this.heapCapacity) {
			System.out.println("Heap at full capacity...");
			return;
		}
		
		this.heapSize++;
		int currentIndex = this.heapSize - 1;
		this.arr[currentIndex] = key;
		
		int temp;
		while (currentIndex != 0 && this.arr[(currentIndex-1)/2] > this.arr[currentIndex]) {
			temp = this.arr[currentIndex];
			this.arr[currentIndex] = this.arr[(currentIndex-1)/2];
			this.arr[(currentIndex-1)/2] = temp;
			
			currentIndex = (currentIndex-1)/2;
		}
	}
	
	/* Increases the node's value. */
	public void increaseKey(int index, int key) {
		if (this.heapSize == 0 || index >= this.heapSize) {
			System.out.println("Not enough elements in the heap");
			return;
		}
		
		if (this.arr[index] > key) {
			System.out.println("The value at the node is greater than what is being proposed to be increased...");
			return;
		}
		
		this.arr[index] = key;
		int temp;
		
		while(index >=0 && this.arr[(index-1)/2] < this.arr[index]) {
			temp = arr[index];
			arr[index] = arr[(index-1)/2];
			arr[(index-1)/2] = temp;
			
			index = (index-1)/2;
		}
	}
	
	/* Extract the max from the MaxHeap. */
	public int extractMax() {
		if (this.heapSize <= 0) {
			System.out.println("There is no element in the heap...");
			return Integer.MIN_VALUE;
		}
		
		// Get the max value, remove it from the heap
		int max = this.arr[0];
		this.arr[0] = this.arr[this.heapSize-1];
		this.heapSize--;
		
		this.maxHeapify(0);
		
		return max;
	}
	
	
}
