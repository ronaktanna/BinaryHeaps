package main;

public class MaxHeap {
	
	public void maxHeapify(int[] arr, int currentIndex) {
		int leftChildIndex = 2*currentIndex;
		int rightChildIndex = 2*currentIndex + 1;
		
		int largestElementIndex = currentIndex;
		if (leftChildIndex <= arr.length && arr[leftChildIndex] > arr[currentIndex])
			largestElementIndex = leftChildIndex;
		if (rightChildIndex <= arr.length && arr[rightChildIndex] > arr[currentIndex])
			largestElementIndex = rightChildIndex;
		
		if (largestElementIndex != currentIndex) {
			int leftChild = arr[leftChildIndex];
			int rightChild = arr[rightChildIndex];
			
			int temp;
			if (Math.max(leftChild, rightChild) == leftChild) {
				temp = arr[currentIndex];
				arr[currentIndex] = leftChild;
				arr[leftChildIndex] = temp;
				
				this.maxHeapify(arr, leftChildIndex);
			} else {
				temp = arr[currentIndex];
				arr[currentIndex] = rightChild;
				arr[rightChildIndex] = temp;
				
				this.maxHeapify(arr, rightChildIndex);
			}
			
		}
	}
}
