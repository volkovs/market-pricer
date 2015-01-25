package lv.volkovs.crawler;

import lv.volkovs.model.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mihails Volkovs on 2015.01.25.
 */
public class AddVisitStrategyTest {

    @Test
    public void getAdId() {
        AdVisitStrategy visitStrategy = new AdVisitStrategy();
        Category parent = new Category("https://www.ss.lv/lv/transport/cars/volkswagen/sharan/", "sharan");
        String addId = visitStrategy.getAddId("https://www.ss.lv/msg/lv/transport/cars/volkswagen/sharan/bglpf.html", parent);
        assertEquals("bglpf", addId);
    }

}
