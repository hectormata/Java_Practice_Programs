package String_Practice;

import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import javax.crypto.*;
import javax.crypto.spec.*;

// import org.apache.commons.codec.binary.Base64;

public class StringUtils {

    public static final String NEW_LINE = System.getProperty("line.separator");

    private static final String CLASSNAME = StringUtils.class.getName();

    public static boolean IsNullOrEmpty(String val) {
        return ((val == null) || (val.trim().length() <= 0) || "null".equalsIgnoreCase(val.trim()));
    }

    public static boolean IsNullOrEmpty(Collection<?> s) {
        return ((s == null) || (s.size() <= 0));
    }

    public static boolean IsNullOrEmpty(Map<?, ?> s) {
        return ((s == null) || (s.size() <= 0));
    }

    public static boolean IsNullOrEmpty(Object[] s) {
        return ((s == null) || (s.length <= 0));
    }

    // Mask a string with a *'s
    public static String maskStr(String str) {

        String masked = null;

        if (str != null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                sb.append('*');
            }
            masked = sb.toString();
        }

        return masked;
    }

    // Find a key word in a comma delimeter list
    public static boolean isInList(String key, String string) {

        boolean found = false;

        if (string != null && key != null) {
            String[] items = string.split(",");
            for (String item : items) {
                if (item != null & item.equals(key)) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public static String getHostName() {
        final String method = "getHostName";

        String hostName = "";

        try {

            InetAddress localHost = InetAddress.getLocalHost();
            if (localHost != null) {
                String temp1 = localHost.getHostName();
                String temp2 = localHost.getHostAddress();
                String temp3 = localHost.getCanonicalHostName();
                hostName = temp1 + " ( " + temp2 + " - " + temp3 + " ) ";
            }
        } catch (Throwable e) {
            System.err.println(method + "|" + e);
        }

        return hostName;
    }

//    public static Result Encrypt(String stringToEncrypt) {
//        final String METHOD = "Encrypt";
//        String res = "", resMsg = "";
//        boolean success = false;
//        try {
//            res = EncryptionUtil.encrypt(stringToEncrypt);
//            success = true;
//            resMsg = "Successfully encrypted.";
//        } catch (Throwable t) {
//            resMsg = "Encryption Failed. An error has occured while encrypting.";
//            LogExeption(METHOD, "", t);
//        }
//        return new Result(res, resMsg, success);
//    }
//
//    public static Result Decrypt(String stringToDecrypt) {
//        final String METHOD = "Decrypt";
//        String res = "", resMsg = "";
//        boolean success = false;
//        try {
//            res = EncryptionUtil.decrypt(stringToDecrypt);
//            success = true;
//            resMsg = "Successfully decrypted.";
//        } catch (Throwable t) {
//            resMsg = "Decryption Failed. An error has occured while decrypting.";
//            LogExeption(METHOD, "", t, true);
//        }
//        return new Result(res, resMsg, success);
//    }

    private static String GetRandomString(int randStrLength) {
        String res = "";
        SecureRandom randomNum = new SecureRandom();
        for (int i = 0; i < randStrLength; i++) {
            int rndValue = (int) (randomNum.nextInt());
            char base = (rndValue < 26) ? 'A' : 'a';
            res = res + (char) (base + rndValue % 26);
        }
        return res;
    }

//    public static String decrypt(String strToDecrypt) throws Throwable {
//        if (strToDecrypt == null || !strToDecrypt.startsWith("{AES}")) {
//            return strToDecrypt;
//        }
//        String value = RemoveAESPrefix(strToDecrypt);
//        String decryptedString = "";
//        decryptedString = AES_CBC_Processor(value, false);
//        return RemoveHeaderAndFooter(decryptedString);
//    }
//
//    public static String encrypt(String strToEncrypt) throws Throwable {
//        String value = "", encVal = "";
//        value = AddHeaderAndFooter(strToEncrypt, 5);
//        encVal = AES_CBC_Processor(value, true);
//        return AddAESPrefix(encVal);
//    }
//
//    private static String AES_CBC_Processor(String value, boolean isEncrypt) throws Throwable {
//        String res = "";
//        IvParameterSpec iv = new IvParameterSpec(paramKey.getBytes("UTF-8"));
//        SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//        if (isEncrypt) {
//            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//            byte[] encrypted = cipher.doFinal(value.getBytes());
//            res = new String(Base64.encodeBase64(encrypted));
//        } else {
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//            byte[] original = new Base64().decode(value.getBytes());
//            byte[] restemp = cipher.doFinal(original);
//            res = new String(restemp);
//        }
//        return res;
//    }
//
//    private static String AddAESPrefix(String value) {
//        if (value != null) {
//            return "{AES}" + value;
//        }
//        return value;
//    }
//
//    private static String RemoveAESPrefix(String value) {
//        if (value != null && value.startsWith("{AES}")) {
//            return value.substring(5);
//        }
//        return value;
//    }
//
//    private static String AddHeaderAndFooter(String encryptionString, int headFootLen) {
//        return "" + headFootLen + GetRandomString(headFootLen) + encryptionString + GetRandomString(headFootLen) + "" + headFootLen;
//    }
//
//    private static String RemoveHeaderAndFooter(String decryptedString) {
//        String res = "";
//        if (decryptedString != null) {
//            int headerLen = Integer.parseInt(decryptedString.substring(0, 1));
//            int footLen = Integer.parseInt(decryptedString.substring(decryptedString.length() - 1));
//            res = decryptedString.substring(headerLen + 1);
//            res = res.substring(0, res.length() - 1 - footLen);
//        }
//        return res;
//    }

    public static String reverse(String s) {

        int n = s.length();
        char[] a = s.toCharArray();

        for (int i = 0; i < n / 2; i++) {

            char tmp = a[i];
            a[i] = a [n - i - 1];
            a[n - i - 1] = tmp;
        }

        return new String(a);
    }

    public static String getLikeSearchString(String input, boolean isNumOnly) {
        if (!IsNullOrEmpty(input)) {
            String res = input.trim().replaceAll(Pattern.quote("*"), "%");
            if (isNumOnly) {
                res = res.replaceAll("[^0-9%]", "");
            }
            if (!IsNullOrEmpty(res) && !res.contains("%")) {
                res = "%" + res + "%";
            }
            return res;
        }
        return input;
    }

    public static String getLowerCase(String s) {
        return IsNullOrEmpty(s) ? "" : s.trim().toLowerCase();
    }

    public static void main(String[] args) {

        System.out.println(getHostName());
        System.out.println(GetRandomString(12));
        System.out.println(reverse("Barcelona"));
        System.out.println(maskStr("Barcelona"));
        System.out.println(getLowerCase("BARcelona"));
    }
}
