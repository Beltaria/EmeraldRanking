package me.bluedyaishela.emeraldranking.utils;

public class TypeChecker {

    public static boolean isInteger(String chaine)
    {
        try {
            Integer.parseInt(chaine);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isString()
    {
        return false;
    }
}
