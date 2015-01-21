package lv.volkovs.crawler;

import com.google.common.collect.Lists;
import lv.volkovs.model.Category;

import java.util.List;

/**
 * Created by Mihails Volkovs on 2015.01.20.
 */
public class SiteModelSsLvImpl {

    public static SiteModelSsLvImpl SHARAN = new SiteModelSsLvImpl("transport", "cars", "volkswagen", "sharan");

    public static final String ROOT_URL = "https://www.ss.lv/lv/";

    private static final String URL_TEMPLATE = "https://www.ss.lv/lv/%s/%s/%s/%s/sell/";

    private final String category;

    private final String subCategory;

    private final String brand;

    private final String model;

    public SiteModelSsLvImpl(String category, String subCategory, String brand, String model) {
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public List<Category> getCategories() {
        List<Category> result = Lists.newArrayList();
        Category rootCategory = new Category();
        rootCategory.setUrl(ROOT_URL);

        new CategoryCrawler(rootCategory).run();
        return result;

    }

    public Category getCategory(String categoryName) {
        return null;
    }

}
