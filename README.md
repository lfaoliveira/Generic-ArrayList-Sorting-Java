# Generified-ArrayList-Sorting-Java
A generic implementation of some mainstream generified sorting algorithms in Java. The Project was created for a Algorithms and Data Structures Class in the Universidade Federal do Maranhão(UFMA).

The code reads a .csv file from a given filepath, creates an ArrayList of type Product(a place holder for the data) and then proceeds to show a Menu for the sorting of the data. using the Comparator interface in Java; by choosing a sorting algorithm, there is the option for sorting in ascending order and descending order. In the end of the execution, the times for sorting using a Numeric criteria and a Text criteria are printed. the sorting algorithms used are: SelectionSort, InsertionSort, QuickSort, MergeSort, HeapSort and two hibrids, Quick-MergeSort(QuickSort that uses MergeSort after the height "h" of the sub-tree) and Selection-InsertionSort(takes a x% of the array as input and sorts the first x% and the last x% of the array using SelectionSort, then proceeds to sort using InsertionSort). The time results for the selected sorting algorithm is printed on the screen.
