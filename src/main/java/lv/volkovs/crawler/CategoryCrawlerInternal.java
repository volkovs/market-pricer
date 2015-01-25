package lv.volkovs.crawler;

import com.google.common.collect.Lists;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import lv.volkovs.model.Category;

import java.util.List;

public class CategoryCrawlerInternal extends WebCrawler {

    private static ThreadLocal<Category> parent = new InheritableThreadLocal();

    private static ThreadLocal<VisitStrategy> visitStrategy = new InheritableThreadLocal();

    private static ThreadLocal<List<Category>> results = new InheritableThreadLocal();

    @Override
    public boolean shouldVisit(Page page, WebURL url) {
        return visitStrategy.get().shouldVisit(page, url, parent.get());
    }

    @Override
    public void visit(Page page) {
        Category category = visitStrategy.get().visit(page, parent.get());
        if (category != null) {
            getResults().add(category);
        }
    }

    public static List<Category> getResults() {
        return results.get();
    }

    public static void resetResults() {
        results.set(Lists.newArrayList());
    }

    public static Category getParent() {
        return parent.get();
    }

    public static void setParent(Category parent) {
        CategoryCrawlerInternal.parent.set(parent);
    }

    public static VisitStrategy getVisitStrategy() {
        return visitStrategy.get();
    }

    public static void setVisitStrategy(VisitStrategy visitStrategy) {
        CategoryCrawlerInternal.visitStrategy.set(visitStrategy);
    }
}