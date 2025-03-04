package com.test.dsa.binarySearch.onAnswers;

import java.util.*;

/**
 * <a href="https://www.naukri.com/code360/problems/allocate-books_1090540">here</a>
 *Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
 * There are ‘m’ number of students, and the task is to allocate all the books to the students.
 * Allocate books in such a way that:
 * 1. Each student gets at least one book.
 * 2. Each book should be allocated to only one student.
 * 3. Book allocation should be in a contiguous manner.
 * You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student
 * is minimum.
 * If the allocation of books is not possible, return -1.
 * Input: ‘n’ = 4 ‘m’ = 2
 * ‘arr’ = [12, 34, 67, 90]
 * Output: 113
 */
public class AllocateBooks {
    public static void main(String[] args) {
        var arr = new ArrayList<>(List.of(25, 46, 28, 49, 24));
        int m = 2;
        final var pages = findPages(arr, arr.size(), m);
        System.out.println(pages);
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        int result = -1;
        if(n < m) {
            return result;
        }

        final var list = arr.stream().sorted().toList();
        final var max = list.get(arr.size() - 1);
        final var sum = arr.stream().reduce(0, Integer::sum);
        System.out.println(max+"\t"+sum);
        for(int i=max; i<=sum; i++) {
            final var studentsCount = getStudentsCount(max, arr);
            if(studentsCount == m) {
                return i;
            }
        }
        return -1;
    }

    /**
     * For optimal code we will use binary search from max to sum
     * To remove half we will we will check for the number of students required for mid pages
     * if students required is greater than from m then we need to eliminate the left half as more number of pages
     * per student
     * In else part when students required is less than or equal to m so we will eliminate right half as we need minimum
     * no of pages
    * */
    public static int findPagesOptimal(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        int result = -1;
        if(n < m) {
            return result;
        }

        final var list = arr.stream().sorted().toList();
        final var max = list.get(arr.size() - 1);
        final var sum = arr.stream().reduce(0, Integer::sum);
        int low = max;
        int high = sum;

        while(low <= high) {
            int mid = (low + high) / 2;
            final var studentsCount = getStudentsCount(max, arr);

            if(studentsCount <= m) {

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /*
    * 25, 46, 28, 49, 24
    * 49
    * */
    private static int getStudentsCount(final Integer maxPage, final ArrayList<Integer> arr) {
        int studentCount = 1;
        int pageCount = 0;
        for (int page : arr) {

            pageCount += page;

            if (pageCount > maxPage) {
                studentCount++;
                pageCount = page;
            }
        }

        return studentCount;
    }

    /**
     * This method will return the number of student required to read all pages if student has reading capacity maxPage
     * In this function we will maintain two variable 1 is for studentCount and second for pageCount
     * We will check if pageCount is less than maxPage then keep adding in pageCount
     * if not then move to next student
     * */
    private static int getStudentsCountStriver(final Integer maxPage, final ArrayList<Integer> arr) {
        int studentCount = 1;
        int pageCount = 0;
        for (int page : arr) {


            if (pageCount + page <= maxPage) {
                pageCount += page;
            } else {
                studentCount++;
                pageCount = page;
            }
        }

        return studentCount;
    }
}
