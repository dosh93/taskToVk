package utils;

import org.apache.commons.lang3.RandomStringUtils;


public class CommonUtils {

    private static final String CYRILLIC_CHARACTERS = "àáâãäå¸æçèéêëìíîïğñòóôõö÷øùúûüışÿÀÁÂÃÄÅ¨ÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞß";

    public static String getCyrillicUniqueValueChar(int length) {
        return RandomStringUtils.random(length, CYRILLIC_CHARACTERS);
    }

}
