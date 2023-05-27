package dev.grbackend.utils;

public class Helper {
    public static String getRegexFromPrefix(String prefix){
        String regex = "";
        String [] prefixElements = prefix.split(" ");
        for (int i = 0; i < prefixElements.length; i++){
            char upperChar = Character.toUpperCase(prefixElements[i].charAt(0));
            prefixElements[i] = upperChar + prefixElements[i].substring(1).toLowerCase();
            if( i == prefixElements.length - 1 ) regex += prefixElements[i];
            else regex += prefixElements[i] + " ";
        }
        return  regex+".*";
    }
}
