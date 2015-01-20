package lv.volkovs.crawler;

import java.util.List;

/**
 * Created by Mihails Volkovs on 2015.01.20.
 */
public class SiteModelSsLvImpl {

    public static SiteModelSsLvImpl SHARAN = new SiteModelSsLvImpl("transport", "cars", "volkswagen", "sharan");

    private static final String ROOT_URL = "https://www.ss.lv/lv/";

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

    public List<String> getCategories() {

    }

}
