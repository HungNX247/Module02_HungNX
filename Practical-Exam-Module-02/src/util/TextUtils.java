package util;

public class TextUtils {
    public static String removeAccent(String text) {
        if (text == null) {
            return "";
        }
        String normalized = java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFD);
        String noAccent = normalized.replaceAll("\\p{M}", "");
        return noAccent.replace("đ", "d").replace("Đ", "D");
    }
}
