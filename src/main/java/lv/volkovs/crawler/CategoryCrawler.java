package lv.volkovs.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import lv.volkovs.model.Category;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoryCrawler extends WebCrawler {

    private static final Pattern EXTRA_URL_PATTERN = Pattern.compile("\\w+/");

    private Category category;

    public CategoryCrawler(Category category) {
        this.category = category;
    }

    public CategoryCrawler() {
        category = new Category();
        category.setUrl(SiteModelSsLvImpl.ROOT_URL);
    }

    /**
     * You should implement this function to specify whether
     * the given url should be crawled or not (based on your
     * crawling logic).
     */
    @Override
    public boolean shouldVisit(Page page, WebURL url) {
        String categoryUrl = category.getUrl();

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
        System.out.println("URL: " + url);

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
}