package lv.volkovs;

import lv.volkovs.crawler.CategoryCrawler;
import lv.volkovs.crawler.SiteModelSsLvImpl;
import lv.volkovs.model.Category;

import java.util.List;

/**
 * Created by Mihails Volkovs on 2015.01.21.
 */
public class DataCollector {

    public static void main(String... args) throws Exception {
//        CategoryCrawler crawler = new CategoryCrawler();
//        crawler.scanCategories();
//        crawler.scanCategories("transport");
//        crawler.scanCategories("cars");
//        crawler.scanCategories("volkswagen");

        CategoryCrawler crawler = new CategoryCrawler();
//        List<Category> categories = crawler.scanCategories(SiteModelSsLvImpl.VW_CATEGORY);
        crawler.scanAdds(SiteModelSsLvImpl.SHARAN_CATEGORY);

//        System.out.println(categories);
        System.out.println(SiteModelSsLvImpl.SHARAN_CATEGORY.getAds().size());
    }

}