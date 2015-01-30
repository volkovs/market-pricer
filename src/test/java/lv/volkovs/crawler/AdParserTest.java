package lv.volkovs.crawler;

import lv.volkovs.model.Ad;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mihails Volkovs on 2015.01.27.
 */
public class AdParserTest {

    private AdParser parser;

    @Before
    public void setUp() {
        parser = new AdParser();
    }

    @Test
    public void parse() throws IOException {
        InputStream html = getClass().getClassLoader().getResourceAsStream("ad.html");
        Ad ad = parser.parse(IOUtils.toString(html));

        assertEquals("Автомат 1.9 дизель. Новое ТО. Климат контроль, полная комплектация, кроме кожи. Состояние у машины как новое, нет ни ржавчины ни царапен. В машине полностью зделана ходовая, ни чего с низу не стучит. Вся электроника работает исправно работает кондиционер климат контроль, заменено масло фильтры. Машина полностью подготовлена к продаже хорошим людям", ad.getText());
        assertEquals(new BigDecimal("3400.00"), ad.getPrice());

        Iterator<Map.Entry<String, String>> iterator = ad.getFeatures().entrySet().iterator();
        assertFeature("Izlaiduma gads", "2003 aprīlis", iterator);
        assertFeature("Motors", "1.9 dīzelis", iterator);
        assertFeature("Ātr.kārba", "Automāts 5 ātrumi", iterator);
        assertFeature("Nobraukums, km", "189 000", iterator);
        assertFeature("Krāsa", "Sudraba", iterator);
        assertFeature("Virsbūves tips", "Minivens", iterator);
        assertFeature("Tehniskā apskate", "10. 2015", iterator);
        assertFeature("Aprīkojums", "Stūres pastiprinātājs, El. logu pacēlāji, Kondicionieris, Klimata kontrole, Salona gaisa filtrs, Borta dators", iterator);
        assertFeature("Gaismas", "LED", iterator);
        assertFeature("Spoguļi", "El. regulējami, Apsildāmi", iterator);
        assertFeature("Salons", "Roku balsti", iterator);
        assertFeature("Sēdekļi", "Apsildāmi", iterator);
        assertFeature("Stūre", "Regulējama, Daudzfunkcionāla", iterator);
        assertFeature("Hi-Fi", "FM/AM, CD", iterator);
        assertFeature("Drošība", "ABS, Centrālā atslēga, Signalizācija, Imobilaizers, Air-bag, ESP", iterator);
    }

    private void assertFeature(String expectedKey, String expectedValue, Iterator<Map.Entry<String, String>> iterator) {
        Map.Entry<String, String> entry = iterator.next();
        assertEquals(expectedKey, entry.getKey());
        assertEquals(expectedValue, entry.getValue());
    }

}
