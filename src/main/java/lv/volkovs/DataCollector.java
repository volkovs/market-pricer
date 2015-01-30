package lv.volkovs;

import lv.volkovs.crawler.CategoryCrawler;
import lv.volkovs.crawler.SiteModelSsLvImpl;
import lv.volkovs.model.Ad;
import lv.volkovs.model.Category;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Mihails Volkovs on 2015.01.21.
 */
public class DataCollector {

    public static final String CATEGORY_FILE_NAME = "category.dat";

    public static void main(String... args) throws Exception {
        // crawling target site and saving results
//        save(scan(SiteModelSsLvImpl.SHARAN_CATEGORY));

        // loading ads scanned previously
        Category category = load();

        // filtering
        Stream<Ad> adStream = category.getAds().stream()
                .filter(ad -> ad.getPrice() != null && ad.getPrice().compareTo(BigDecimal.ZERO) > 0);
        List<Object> ads = Arrays.asList(adStream.toArray());
        System.out.println(ads.size());
        System.out.println(ads);
    }

    private static Category load() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(CATEGORY_FILE_NAME));
        Category category = (Category) in.readObject();
        in.close();
        return category;
    }

    private static void save(Category category) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CATEGORY_FILE_NAME));
        out.writeObject(category);
        out.close();
    }

    private static Category scan(Category category) throws Exception {
        CategoryCrawler crawler = new CategoryCrawler();
        crawler.scanAdds(category);
        return category;
    }

}