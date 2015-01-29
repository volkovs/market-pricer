package lv.volkovs;

import lv.volkovs.crawler.CategoryCrawler;
import lv.volkovs.crawler.SiteModelSsLvImpl;
import lv.volkovs.model.Category;

import java.io.*;

/**
 * Created by Mihails Volkovs on 2015.01.21.
 */
public class DataCollector {

    public static final String CATEGORY_FILE_NAME = "category.dat";

    public static void main(String... args) throws Exception {
//        CategoryCrawler crawler = new CategoryCrawler();
//        crawler.scanCategories();
//        crawler.scanCategories("transport");
//        crawler.scanCategories("cars");
//        crawler.scanCategories("volkswagen");

        // crawling target site and saving results
//        save(scan(SiteModelSsLvImpl.SHARAN_CATEGORY));

        // loading ads scanned previously
        Category category = load();

        System.out.println(category.toMultilineString());

//        System.out.println(categories);
        System.out.println(SiteModelSsLvImpl.SHARAN_CATEGORY.getAds().size());
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