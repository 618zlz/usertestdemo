package com.example.usertestdemo.util;


import java.util.Locale;

//测试多语言
public class LocaleUtil {
    public static Locale localeByLanguageTag(String languageTag) {
        if(languageTag == null || languageTag.equals(" ") || languageTag.length() == 0) {
            return Locale.getDefault();
        }
        Locale locale;
        switch (languageTag.toLowerCase()) {
            case "zh":
                locale = Locale.CHINESE;
                break;
            case "zh-cn":
                locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case "en":
                locale = Locale.ENGLISH;
                break;
            default:
                locale = Locale.ROOT;
                break;
        }
        return locale;
    }

}
