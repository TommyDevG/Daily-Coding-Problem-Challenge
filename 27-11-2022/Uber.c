#include <stdio.h>
#include <stdlib.h>

// This problem was asked by Uber.
// Given an array of integers, return a new array such that each element at index i of the new array 
// is the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
// If our input was [3, 2, 1], the expected output would be [2, 3, 6].
// Follow-up: what if you can't use division?

int main(int argc, char* argv[]) {

	int array[] = { 1, 2, 3, 4, 5 };
	int product = 1; // J'initialise à 1 car mutliplier par 0 revient à 0 et la valeurs ne change pas
	int* tmpArray = NULL;
	size_t arrayLength = sizeof(array) / sizeof(int);

	tmpArray = malloc(arrayLength * sizeof(int));

	if (tmpArray == NULL) {
		// Si l'allocation dynamique échoue j'arrête le programme
		exit(0);
	}

	for (int ii = 0; ii < arrayLength; ii++) {
		for (int jj = 0; jj < arrayLength; jj++) {
			if (jj != ii) {
				product *= array[jj];
			}
		}
		tmpArray[ii] = product;
		product = 1;
		printf("%d\n", tmpArray[ii]);
	}
	free(tmpArray);

	return 0;
}