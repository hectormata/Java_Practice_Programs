package String_Practice;

public class PermutationOfAString {

    private void permute(String str, int l, int r) {

        if (l != r) {

            for (int i = l;  i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
        else {
            System.out.println(str);
        }

    }

    public String swap(String a, int i, int j) {

        char tmp;
        char[] charArray = a.toCharArray();
        tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;

        return String.valueOf(charArray);
    }

    public static void main(String[] args) {

        String str = "ROLFORN";
        int n = str.length();
        PermutationOfAString perm = new PermutationOfAString();
        perm.permute(str, 0, n - 1);
    }
}
