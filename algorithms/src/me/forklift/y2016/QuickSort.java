package me.forklift.y2016;

public class QuickSort {

    public void sort(int[] data, int begin, int end) {

        if (begin >= end) {
            return;
        }

        // do partition job
        int middle = partition(data, begin, end);

        // divide and conquer
        sort(data, begin, middle - 1);
        sort(data, middle + 1, end);

    }

    private int partition(int[] data, int begin, int end) {

        int pivot = data[end];
        int low = begin - 1;
        int high = begin;

        for (; high < end; high++) {
            if (data[high] < pivot) {
                low++;
                swap(data, low, high);
            }
        }

        //always pivot value should be next slot of low value area.
        swap(data, low + 1, end);

        return low + 1;
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