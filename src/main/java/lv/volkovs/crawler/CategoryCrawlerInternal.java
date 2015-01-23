package lv.volkovs.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import lv.volkovs.model.Category;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoryCrawlerInternal extends WebCrawler {

    private static final Pattern EXTRA_URL_PATTERN = Pattern.compile("\\w+/");

    private static final Pattern CATEGORY_NAME_PATTERN = Pattern.compile(".*/(\\w+)/");

    public static ThreadLocal<List<Category>> results = new InheritableThreadLocal();

    public static ThreadLocal<Category> sourceCategory = new InheritableThreadLocal();

    @Override
    public boolean shouldVisit(Page page, WebURL url) {
        String categoryUrl = sourceCategory.get().getUrl();

        String href = url.getURL().toLowerCase();
        if (!href.startsWith(categoryUrl)) {
            return false;
        }
        String extraUrl = href.replace(categoryUrl, "");
        Matcher matcher = EXTRA_URL_PATTERN.matcher(extraUrl);
        return matcher.matches();
    }

    /**
     * This function is called when a page is fetched and ready
     * to be processed by your program.
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        results.get().add(new Category(url, getCategoryName(url)));

//        if (page.getParseData() instanceof HtmlParseData) {
//            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
//            String text = htmlParseData.getText();
//            String html = htmlParseData.getHtml();
//            Set<WebURL> links = htmlParseData.getOutgoingUrls();
//
//            System.out.println("Text length: " + text.length());
//            System.out.println("Html length: " + html.length());
//            System.out.println("Number of outgoing links: " + links.size());
//        }
    }

    private String getCategoryName(String url) {
        Matcher matcher = CATEGORY_NAME_PATTERN.matcher(url);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}