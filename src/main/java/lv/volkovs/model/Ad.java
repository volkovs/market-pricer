package lv.volkovs.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mihails Volkovs on 2015.01.20.
 */
public class Ad {

    private String text;

    private Map<String, String> features = new HashMap();

    public Ad(String text) {
        this.text = text;
    }

    public void addFeature(String key, String value) {
        features.put(key, value);
    }

    public Map<String, String> getFeatures() {
        return features;
    }
}
