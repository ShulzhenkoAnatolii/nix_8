package ua.com.alevel;

public final class ReverseStringUtil {
    public static String reverse(String src) {
        for (int i = 0; i < src.length() - 1; i++) {
            if (Character.isLetter(src.charAt(i)) && Character.isLetter(src.charAt(i + 1))) {
                String word = src.substring(i, i + 1);
                i++;
                while (i < src.length() && Character.isLetter(src.charAt(i))) {
                    word = word + src.charAt(i);
                    i++;
                }
                String reversedWord = "";
                for (int j = word.length() - 1; j >= 0; j--) reversedWord += word.charAt(j);
                src = src.replace(word, reversedWord);
            }
        }
        return src;
    }

    public static String reverse(String src, String dest) {
        return src.replaceAll(dest, reverse(dest));
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex) {
            return src.substring(0, lastIndex) + reverse(src.substring(lastIndex, firstIndex + 1)) + src.substring(firstIndex + 1, src.length());
        }
        return src.substring(0, firstIndex) + reverse(src.substring(firstIndex, lastIndex + 1)) + src.substring(lastIndex + 1, src.length());
    }
}
