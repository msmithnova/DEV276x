public class Crypto {

    public static void main(String[] args) {
        String result;
        result = normalizeText("This is some \"really\" great. (Text)!?");
        System.out.println(result);
        result = caesarify("ILIKEZOOS", 1);
        System.out.println(result);
        result = caesarify("ILIKEAPPLES", -1);
        System.out.println(result);
        result = groupify("HITHERE", 2);
        System.out.println(result);
        result = groupify("HITHERE", 3);
        System.out.println(result);
        result = groupify("HITHERE", 4);
        System.out.println(result);
        result = groupify("HITHERE", 5);
        System.out.println(result);
        result = encryptString("This is some \"really\" great. (Text)!?", -5, 5);
        System.out.println(result);
    }

    private static String normalizeText(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int intC = (int) c;
            if ( (intC >= 65 && intC <= 90) || (intC >=97 && intC <= 122) ) result += c;
        }
        return result.toUpperCase();
    }

    private static String caesarify(String text, int key) {
        String result = "";
        String shift = shiftAlphabet(key);
        for (int i = 0; i < text.length(); i++) {
            result += shift.charAt((int) text.charAt(i) - 65);
        }
        return result;
    }

    private static String groupify(String text, int len) {
        String result = "";
        for (int i = 0; i < text.length(); i += len) {
            if (i + len < text.length()) {
                result += text.substring(i, i + len);
                result += " ";
            } else {
                String rest = text.substring(i);
                result += rest;
                for (int j = 0; j < len - rest.length(); j++) {
                    result += 'x';
                }
            }
        }
        return result;
    }

    private static String encryptString(String text, int shift, int groupSize) {
        String result;
        result = normalizeText(text);
        result = caesarify(result, shift);
        result= groupify(result, groupSize);
        return result;
    }

    // Supplied method
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
}
