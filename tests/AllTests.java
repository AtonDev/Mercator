package crawler.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CrawlerTest.class, PageFetchingTest.class,
        PageProcessingTest.class, URLProcessingTest.class })
public class AllTests {

}
