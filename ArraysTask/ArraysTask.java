package ArraysTask;
import java.util.Scanner;

public class ArraysTask {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] testArray = {12, 7, 25, 3, 18, 9, 30, 14};

        System.out.println("Sum: " + sumArray(testArray));
        System.out.println("Average: " + averageArray(testArray));

        int max = findMax(testArray);
        int min = findMin(testArray);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Difference: " + (max - min));

        System.out.println("Even numbers: " + countEven(testArray));

        System.out.print("Enter a number to search for: ");
        int target = scanner.nextInt();
        int index = indexOf(testArray, target);
        if (index == -1) {
            System.out.println(target + " was not found.");
        } else {
            System.out.println(target + " found at index " + index);
        }

        System.out.print("Original: ");
        printArray(testArray);
        int[] reversed = reverseArray(testArray);
        System.out.print("Reversed: ");
        printArray(reversed);

        int[] grades = readGrades(5);
        System.out.print("Grades: ");
        printArray(grades);
        int passed = countPassed(grades);
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + (grades.length - passed));
    }

    public static int[] readGrades(int size) {
        int[] grades = new int[size];
        for (int i = 0; i < size; i++) {
            int grade;
            do {
                System.out.print("Enter grade for student " + (i + 1) + " (0-100): ");
                grade = scanner.nextInt();
                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade. Please enter a value from 0 to 100.");
                }
            } while (grade < 0 || grade > 100);
            grades[i] = grade;
        }
        return grades;
    }

    public static int countPassed(int[] grades) {
        int count = 0;
        for (int grade : grades) {
            if (grade >= 50) {
                count++;
            }
        }
        return count;
    }

    public static int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length - 1 - i] = arr[i];
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int countEven(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int sumArray(int[] arr) {
        int total = 0;
        for (int value : arr) {
            total += value;
        }
        return total;
    }

    public static double averageArray(int[] arr) {
        return (double) sumArray(arr) / arr.length;
    }
}
