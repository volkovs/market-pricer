package lv.volkovs.crawler;

import com.google.common.base.Preconditions;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import lv.volkovs.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mihails Volkovs on 2015.01.23.
 */
public class CategoryCrawler {

    public List<Category> scanCategories() throws Exception {
        return scanCategories(SiteModelSsLvImpl.ROOT_CATEGORY);
    }

    public List<Category> scanCategories(final String categoryName) throws Exception {
        List<Category> previouslyFoundCategories = CategoryCrawlerInternal.getResults();
        Preconditions.checkState(previouslyFoundCategories != null);
        Optional<Category> found = previouslyFoundCategories.stream().filter((Category category) -> category.getName().equals(categoryName)).findFirst();
        if (found.isPresent()) {
            return scanCategories(found.get());
        }
        throw new RuntimeException(String.format("Category '%s' not found in previous category search", categoryName));
    }

    public List<Category> scanCategories(Category category) throws Exception {
        return scanInternal(category, new CategoryVisitStrategy());
    }

    public List<Category> scanAdds(Category parent) throws Exception {
        return scanInternal(parent, new AdVisitStrategy());
    }

    private List<Category> scanInternal(Category category, VisitStrategy visitStrategy) throws Exception {
        CategoryCrawlerInternal.resetResults();
        CategoryCrawlerInternal.setParent(category);
        CategoryCrawlerInternal.setVisitStrategy(visitStrategy);
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder("./target/root");
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        controller.addSeed(category.getUrl());
        controller.start(CategoryCrawlerInternal.class, 7);
        return CategoryCrawlerInternal.getResults();
    }
}
