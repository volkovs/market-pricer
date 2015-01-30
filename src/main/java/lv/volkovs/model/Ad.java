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

    private static final long serialVersionUID = -943158700611464332L;

    private String text;

    private String url;

    private String adId;

    private Map<String, String> features = new LinkedHashMap();

    private BigDecimal price = BigDecimal.ZERO;

    public void addFeature(String key, String value) {
        features.put(key, value);
    }

    public Map<String, String> getFeatures() {
        return features;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        if (price != null) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
