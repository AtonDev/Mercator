package crawler;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;

/** Class responsible for the processing and filtering of
 *  new URLs to be added to the url frontier.
 * @author Arturo Pacifico Griffini
 *
 */
public class URLProcessing {

    /** HashSet that contains URLs that have been already visited. */
    private static HashSet<URL> _visitedURLs = new HashSet<URL>();


    /** Return the filtered list of urls after checking
     * whether they were already visited and whether they are relevant.
     * @param urlList
     * @return
     */
    public static LinkedList<URL> filterURLs(LinkedList<URL> urlList) {
        LinkedList<URL> filteredList = new LinkedList<URL>();
        for (URL url : urlList) {
            if (isNotVisited(url)) {
                filteredList.add(url);
            }
        }
        return filteredList;
    }


    /** Returns true iff url was not visited already.
     * @param url
     * @return
     */
    private static boolean isNotVisited(URL url) {
        return !_visitedURLs.contains(url);
    }
}
