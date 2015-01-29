package lv.volkovs.model;

import com.google.common.collect.Lists;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mihails Volkovs on 2015.01.20.
 */
public class Category implements Serializable {

    private static final long serialVersionUID = -6944047293966434844L;

    private String name;

    private String url;

    private Category parentCategory;

    private Category[] subCategories;

    private List<Ad> ads = Lists.newArrayList();

    public Category(String url, String name) {
        this.url = url;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return name;
    }

    public String toMultilineString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
