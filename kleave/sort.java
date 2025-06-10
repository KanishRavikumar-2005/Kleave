package kleave;

import java.util.List;

public class sort {
    public static <T extends Comparable<T>> void bubble(List<T> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static <T extends Comparable<T>> void selection(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }
            swap(list, i, minIdx);
        }
    }

    public static <T extends Comparable<T>> void insertion(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        if (list.size() < 2) return;
        int mid = list.size() / 2;
        List<T> left = list.subList(0, mid);
        List<T> right = list.subList(mid, list.size());
        mergeSort(left);
        mergeSort(right);
        merge(list, left, right);
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        quickSortHelper(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSortHelper(List<T> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSortHelper(list, low, pi - 1);
            quickSortHelper(list, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    public static <T extends Comparable<T>> void heap(List<T> list) {
        int n = list.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);

        // One by one extract elements
        for (int i = n - 1; i > 0; i--) {
            swap(list, 0, i);
            heapify(list, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(List<T> list, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && list.get(l).compareTo(list.get(largest)) > 0)
            largest = l;

        if (r < n && list.get(r).compareTo(list.get(largest)) > 0)
            largest = r;

        if (largest != i) {
            swap(list, i, largest);
            heapify(list, n, largest);
        }
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
