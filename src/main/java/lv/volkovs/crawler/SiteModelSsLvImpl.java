package lv.volkovs.crawler;

import com.google.common.collect.Lists;
import lv.volkovs.model.Category;

import java.util.List;

/**
 * Created by Mihails Volkovs on 2015.01.20.
 */
public class SiteModelSsLvImpl {

    public static final String ROOT_URL = "https://www.ss.lv/lv/";

    public static final String VW_URL = ROOT_URL + "transport/cars/volkswagen/";

    public static final String SHARAN_URL = VW_URL + "sharan/";

    public static final Category ROOT_CATEGORY = new Category(ROOT_URL, "root");

    public static final Category VW_CATEGORY = new Category(VW_URL, "volkswagen");

    public static final Category SHARAN_CATEGORY = new Category(SHARAN_URL, "sharan");

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


        new CategoryCrawlerInternal().run();
        return result;

    }

    public Category getCategory(String categoryName) {
        return null;
    }

}
