package lv.volkovs.crawler;

import com.google.common.annotations.VisibleForTesting;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import lv.volkovs.model.Ad;
import lv.volkovs.model.Category;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mihails Volkovs on 2015.01.24.
 */
public class AdVisitStrategy implements VisitStrategy {

    private static final Pattern EXTRA_URL_PATTERN = Pattern.compile("(\\w+)\\.html");

    private static AtomicInteger counter = new AtomicInteger(0);

    private static AdParser parser = new AdParser();

    @Override
    public boolean shouldVisit(Page page, WebURL url, Category parent) {
        if (getAddId(url.getURL(), parent) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Category visit(Page page, Category parent) {
        String url = page.getWebURL().getURL();
        String addId = getAddId(url, parent);
        if (addId.contains("page")) {
            return null;
        }

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();

            System.out.println("Html length: " + html.length());

            Ad ad = parser.parse(html);
            ad.setUrl(url);
            ad.setAdId(addId);

            parent.getAds().add(ad);
            counter.incrementAndGet();
        }


        return null;

    }

    @VisibleForTesting
    protected String getAddId(String url, Category parent) {
        String categoryUrl = parent.getUrl();
        String href = url.toLowerCase().replaceFirst("msg/", "");
        if (!href.startsWith(categoryUrl)) {
            return null;
        }
        String extraUrl = href.replace(categoryUrl, "");
        Matcher matcher = EXTRA_URL_PATTERN.matcher(extraUrl);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

}
