package crawler;

import java.io.DataInputStream;
import java.net.URL;
import java.util.LinkedList;

/** Class that represents a web crawler.
 *  It manages the control-flow of the crawler.
 *  It begins crawling given an initial URL frontier
 *  and stops when the frontier is emtpy.
 * @author Arturo Pacifico Griffini
 *
 */
public class Crawler {


    /** FILO Queue that stores the URLS to be crawled. */
    private final LinkedList<URL> _URLFrontier;

    private final int MAX_VISITS;

    /** Constructor that initializes _URLFrontier to
     *  initialURLFrontier.
     *
     * @param initialURLFrontier
     */
    public Crawler(LinkedList<URL> initialURLFrontier, int maxVisits) {
        _URLFrontier = initialURLFrontier;
        MAX_VISITS = maxVisits;
    }


    /** Method that begins the crawling loop of the crawler. */
    public void beginCrawling() {
        int counter = 0;
        while (!_URLFrontier.isEmpty() && counter < MAX_VISITS) {
            URL nextURL = _URLFrontier.remove();
            DataInputStream dis = PageFetching.returnPage(nextURL);
            LinkedList<URL> filteredURLs = new LinkedList<URL>();
            if (dis != null) {
                LinkedList<URL> extractedURLs = PageProcessing.beginPageProcessing(dis);
                filteredURLs = URLProcessing.filterURLs(extractedURLs);
            }
            _URLFrontier.addAll(filteredURLs);

            counter++;
        }
        System.out.println("End of crawling");
    }

}
