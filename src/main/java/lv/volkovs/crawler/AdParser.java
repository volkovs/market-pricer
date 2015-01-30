package lv.volkovs.crawler;

import lv.volkovs.model.Ad;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mihails Volkovs on 2015.01.27.
 */
public class AdParser {

    private static final Pattern PRICE_PATTERN = Pattern.compile("CALC_PRICE = (.+);CALC_VALUTA = 'eur'");

    private static final Pattern FEATURE_PATTERN = Pattern.compile("height=20 class=\"oname12\" width=30>([^<]+):</td><td class=[^>]+ width=\"100%\">([^<]+)<");

    private static final Pattern AD_TEXT_PATTERN = Pattern.compile("style=\"padding-top:8px;\">(.+)<br><br>", Pattern.DOTALL);

    public Ad parse(String html) {
        Ad ad = new Ad();

        // setting price
        Matcher matcher = PRICE_PATTERN.matcher(html);
        if (matcher.find()) {
            ad.setPrice(new BigDecimal(matcher.group(1).trim()));
        }

        // setting ad text
        matcher = AD_TEXT_PATTERN.matcher(html);
        if (matcher.find()){
            ad.setText(matcher.group(1).trim());
        }

        // setting features
        matcher = FEATURE_PATTERN.matcher(html);
        while (matcher.find()) {
            String feature = matcher.group(1).trim();
            String value = matcher.group(2).trim();
            ad.addFeature(feature, value);
        }
        return ad;
    }

}
