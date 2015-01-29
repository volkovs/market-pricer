package lv.volkovs.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mihails Volkovs on 2015.01.20.
 */
public class Ad implements Serializable {

    private String text;

    private String url;

    private String adId;

    private Map<String, String> features = new LinkedHashMap();

    private BigDecimal price;

    public Ad(String text) {
        this.text = text;
    }

    public void addFeature(String key, String value) {
        features.put(key, value);
    }

    public Map<String, String> getFeatures() {
        return features;
    }

    public String getText() {
        return text;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
