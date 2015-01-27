package lv.volkovs.crawler;

import lv.volkovs.model.Ad;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Mihails Volkovs on 2015.01.27.
 */
public class AdParser {

    public Ad parse(String html) {

        Pattern pattern = Pattern.compile("CALC_PRICE = 3400.00;CALC_VALUTA = 'eur'");
        String next = new Scanner(html).next(pattern);
        System.out.println(next);
//        "CALC_PRICE = 3400.00;CALC_VALUTA = 'eur'";

//        System.out.println(html);
        return new Ad("");
    }

}
