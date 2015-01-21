package lv.volkovs.model;

import java.util.List;

/**
 * Created by Mihails Volkovs on 2015.01.20.
 */
public class Category {

    private String name;

    private String url;

    private Category parentCategory;

    private Category[] subCategories;

    private List<Ad> ads;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Category[] getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Category[] subCategories) {
        this.subCategories = subCategories;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }
}
