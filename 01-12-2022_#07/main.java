import java.util.*;
/*
This problem was asked by Facebook.
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.
*/

public class main {

    public static void main(String[]args) {

        // Generate the mapping
        Map<String, String> mapping = new HashMap<>();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int ii = 0; ii < 26; ii++) {

            char currentLetter = alphabet.charAt(ii);

            mapping.put(String.valueOf(currentLetter), String.valueOf(ii + 1)); // I want to start at 1 because a equal 1
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the message to decode : ");
        String encodedMessage = scanner.next();
        String decodedMessage = "";
        int nbrOfWay = 1;
        int ii = 0;

        do {

            // I need string not char to concatenate them for a number
            String currentDigit = String.valueOf(encodedMessage.charAt(ii));
            String nextDigit = String.valueOf(encodedMessage.charAt(ii + 1));
            String number = currentDigit + nextDigit;

            if (mapping.containsValue(number)) {
                nbrOfWay++;
            }

            ii++;

        } while(ii < encodedMessage.length() - 1); // - 1 to stay in the range of the length of encodedMessage with the variable nextDigit

        System.out.println(nbrOfWay);
    }
}

