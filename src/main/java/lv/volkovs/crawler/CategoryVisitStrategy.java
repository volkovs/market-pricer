package lv.volkovs.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;
import lv.volkovs.model.Category;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mihails Volkovs on 2015.01.24.
 */
public class CategoryVisitStrategy implements VisitStrategy {

    private static final Pattern EXTRA_URL_PATTERN = Pattern.compile("\\w+/");

    private static final Pattern CATEGORY_NAME_PATTERN = Pattern.compile(".*/(\\w+)/");

    @Override
    public boolean shouldVisit(Page page, WebURL url, Category rootCategory) {
        String categoryUrl = rootCategory.getUrl();

        String href = url.getURL().toLowerCase();
        if (!href.startsWith(categoryUrl)) {
            return false;
        }
        String extraUrl = href.replace(categoryUrl, "");
        Matcher matcher = EXTRA_URL_PATTERN.matcher(extraUrl);
        return matcher.matches();
    }

    @Override
    public Category visit(Page page, Category parent) {
        String url = page.getWebURL().getURL();
        return new Category(url, getCategoryName(url));
    }

    private String getCategoryName(String url) {
        Matcher matcher = CATEGORY_NAME_PATTERN.matcher(url);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

}
