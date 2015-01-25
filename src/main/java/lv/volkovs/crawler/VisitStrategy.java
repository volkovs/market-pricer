package lv.volkovs.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;
import lv.volkovs.model.Category;

import java.util.List;

/**
 * Created by Mihails Volkovs on 2015.01.24.
 */
public interface VisitStrategy {

    public boolean shouldVisit(Page page, WebURL url, Category rootCategory);

    public Category visit(Page page, Category category);

}
