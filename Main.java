import java.util.*;

/*
Je récupère la valeur de k et le tableau
je parcours mon tableau avec une premiere boucle for
j'utilise une deuxieme boucle for pour additionner les valeurs ensemble
Je retourne vrai si la somme de deux nombres du tableau égal à k
*/

public class Main {

    public static void main(String[] args) {
        int array[];

        testMethod(array = new int[]{10, 15, 3, 7}, 17, true, "Erreur pour k = 17");
        testMethod(array = new int[]{10, 15, 3, 7}, 27, false, "Erreur pour k = 27");
        testMethod(array = new int[]{10, 15, 3, 8}, 18, true, "Erreur pour k = 18");
        testMethod(array = new int[]{10, 15, 3, 8}, 28, false, "Erreur pour k = 28");
        testMethod(array = new int[]{1, 2}, 3, true, "Erreur pour k = 3");
        testMethod(array = new int[]{1, 2}, 4, false, "Erreur pour k = 4");

    }
    // Je créé une méthode de test pour ne pas avoir à créer un fichier de test
    private static boolean testMethod(int array[], int k, boolean methodReturnExpected, String errorMessage) {
        boolean methodIsOk = false;

        boolean result = sumEqualToK(array, k);
        if (result == methodReturnExpected) {
            methodIsOk = true;
        } else {
            System.out.println(errorMessage);
        }

        return methodIsOk;
    }

    public static boolean sumEqualToK(int[] array, int k) {
        boolean isEqualToK = false;
        int ii = 0;
        int jj= 0;
        int sum = 0;
        // La boucle for est une bonne solution cependant on est obligé de parcourir tout le tableau
//        for(ii = 0; ii < array.length; ii++) {
//            // jj = ii car pas besoin de recommencer depuis le début on a déjà essayé tous les calculs
//            for(jj = ii; jj < array.length ; jj++) {
//                sum = array[ii] + array[jj];
//                if (sum == k) {
//                    isEqualToK = true;
//                }
//                sum = 0;
//            }
//        }

        while(!isEqualToK && ii < array.length) {
            jj = ii + 1; // J'ajoute 1 a ii afin de ne pas additionner le même nombre !!
            while(!isEqualToK && jj < array.length) {
                sum = array[ii] + array[jj];
                if (sum == k) {
                    isEqualToK = true;
                }
                sum = 0;
                jj++;
            }
            ii++;
        }

        return isEqualToK;
    }
}
