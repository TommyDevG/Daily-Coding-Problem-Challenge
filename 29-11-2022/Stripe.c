// This problem was asked by Stripe.
// Given an array of integers, find the first missing positive integer in linear time and constant space.
// In other words, find the lowest positive integer that does not exist in the array.
// The array can contain duplicates and negative numbers as well.
// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
// You can modify the input array in-place.

// Je parcours mon tableau en stockant le plus grand et le plus petit élément
// Si le plus petit élément est égale à 1 alors je retourne 0
// Boucle for avec jj du plus petit au plus grand élément 
// Si ii n'est pas dans le tableau parcouru par jj alors je retourne ii 

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int lowestPositiveInteger(int* array, int lenghtArray);
int biggestPostitiveNumber(int* array, int lengthArray);
int smallestPositiveNumber(int* array, int lengthArray);

int main(int argc, char* argv[]) {
    int array[5] = { -1, -3, 0, 1, 6 };

    int lowestPositive = lowestPositiveInteger(array, 5);

    printf("%d", lowestPositive);
}

int lowestPositiveInteger(int* array, int lenghtArray) {

    int lowestPositiveInteger;
    int ii = 0;
    bool isInArray = true;

    int smallestNumber = smallestPositiveNumber(array, lenghtArray);
    int biggestNumber = biggestPostitiveNumber(array, lenghtArray);


    // If the smallest number is 2 or if the biggest number is less or equal to 0, it means that the array dosen't have 1 so the lowest positive integer is 1
    if (smallestNumber == 2 || biggestNumber <= 0) {
        lowestPositiveInteger = 1;
    }
    else {
        // we browse all the number between the smallest and the biggest until we browse them all or we find one of this number in the array
        ii = smallestNumber;
        while (ii < biggestNumber && isInArray == true) {
            isInArray = false; // We need to initialize this to false before we browse the array
            for (int jj = 0; jj < lenghtArray; jj++) {
                // if we find the number in the array then it means that the actual number counld not be the lowest positive integer we are looking for
                if (array[jj] == ii) {
                    isInArray = true;
                }
            }
            // if we don't find the number in the array it means that the number is the one we are looking for
            if (isInArray == false) {
                // I don't want a negative and null number
                if (ii <= 0) {
                    isInArray = true;
                }
                else {
                    lowestPositiveInteger = ii;
                }
            }
            ii++;
        }
    }
    // if all the number are in the array and the lowestPositiveInteger is not yet initialize to 1, we add 1 to the biggest number
    if (isInArray == true && lowestPositiveInteger != 1) {
        lowestPositiveInteger = biggestNumber + 1;
    }
    return lowestPositiveInteger;
}

int biggestPostitiveNumber(int* array, int lengthArray) {
    int biggestNumber = array[0];

    for (int ii = 0; ii < lengthArray; ii++) {
        if (array[ii] > biggestNumber) {
            biggestNumber = array[ii];
        }
    }

    return biggestNumber;
}

int smallestPositiveNumber(int* array, int lengthArray) {
    int smallestNumber = array[0];
    for (int ii = 0; ii < lengthArray; ii++) {
        if (array[ii] < smallestNumber) {
            smallestNumber = array[ii];
        }
    }
    return smallestNumber;
}