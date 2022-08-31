public class Convertation {
    public static String convert (int romconv){
        String romfin = "";
        String[] romanhelp1 = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanhelp2 = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < romanhelp1.length; i++) {
            while (romconv >= romanhelp2[i]){
                romconv = romconv - romanhelp2[i];
                romfin = romfin + romanhelp1[i];
            }
        }
        return romfin;
    }
}
