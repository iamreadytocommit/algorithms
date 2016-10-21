package me.forklift.y2016;

import java.lang.Math;

public class HeapSort {

    public void sort(int[] data) {
        int len = data.length;

        // do heapify from first parent node(= lengh / 2)
        for (int ii = data.length / 2; ii > 1; ii--) {
            heapify(data, ii);
            // exchange maximum value and last index value
            swap(data, 0, --len);
        }

    }

    private void heapify(int[] data, int node) {

        if (node <= 0) {
            return;
        }

        int parent = node - 1;
        int left = node * 2 < data.length ? (node * 2) - 1 : -1;
        int right = (node * 2) + 1 < data.length ? (node * 2) : -1;
        int lVal = left == -1 ? 0 : data[left];
        int rVal = right == -1 ? 0 : data[right];

        // make max heap tree
        if (data[parent] < Math.max(lVal, rVal)) {
            if (lVal > rVal) {
                swap(data, parent, left);
            } else {
                swap(data, parent, right);
            }
        }

        heapify(data, --node);
    }

    private void swap(int[] data, int x, int y) throws RuntimeException {
        if (x < 0 || x >= data.length) {
            throw new RuntimeException("Out of Range!! x value is " + x);
        }

        if (y < 0 || y >= data.length) {
            throw new RuntimeException("Out of Range!! y value is " + x);
        }

        if (x == y) {
            return;
        }

        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;

    }

}
