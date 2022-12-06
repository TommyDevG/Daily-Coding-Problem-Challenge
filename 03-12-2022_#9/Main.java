import java.util.*;

//This problem was asked by Airbnb.
//Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//Follow-up: Can you do this in O(N) time and constant space?

/*
divisé par 2 la taille du tableau et additionner au reste de la division ou arrondir au chiffre supérieur

 */

public class Main {

    public static void main(String[] args) {
        int array[] = {5, 1, 1};
        System.out.println(sum(array));

    }

    // Solution trouvé sur internet bcp plus propre et qui gère tous les cas de figures !!!!!!!
    public static int findMaximumNonAdjacentSum(int arr[]) {
        int len = arr.length;
        if(len == 0 ) {
            return 0;
        }

        if(len ==1 ) {
            return arr[0];
        }

        int[] sum = new int[len];
        sum[len-1] = arr[len-1];
        sum[len-2] = Math.max(arr[len-1], arr[len-2]);

        for(int i=len-3;i>=0;i--) {
            sum[i] = Math.max(arr[i] + sum[i+2], sum[i+1]);
        }

        return sum[0];
    }

    // Non prise en compte des tableau entre 0 et 3 occurrences !!!!!!!!!!!!
    public static int sum(int array[]) {
        int sum = 0;

        int sum1 = findSumAtGivenIndex(0, array);
        int sum2 = findSumAtGivenIndex(1, array);

        if (sum1 > sum2) {
            sum = sum1;
        } else {
            sum = sum2;
        }

        return sum;
    }

    public static int findSumAtGivenIndex(int index, int array[]) {
        int sum = array[index];
        while (index < array.length) {
            if (index+4 >= array.length) {
                if (index+3 >= array.length) {
                    sum += array[index+2];
                    index += 3;
                } else {
                    if (array[index+3] > array[index+2]) {
                        sum += array[index+3];
                        index += 4;

                    } else {
                        sum += array[index+2];
                        index += 4;
                    }
                }
            }else {
                if (array[index+3] > array[index+2] + array[index+4]) {
                    sum += array[index+3];
                    index += 3;

                } else {
                    sum += array[index+2];
                    index += 2;
                }
            }
        }
        return sum;
    }
}
