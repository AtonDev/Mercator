/**
 *
 */
package crawler;

import java.io.DataInputStream;
import java.net.URL;
import java.util.LinkedList;

/** Class responsible for page processing.
 * URL extraction; indexing; parsing.
 * @author Arturo Pacifico Griffini
 *
 */
public class PageProcessing {

    /** Begins the processing of the web page and
     *  returns the extracted links.
     * @param pageDataStream
     * @return
     */
    public static LinkedList<URL> beginPageProcessing(DataInputStream dis) {
        LinkedList<URL> result = new LinkedList<URL>();
        /*try {
            String inputLine;
            while ((inputLine = pageReader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return result;
    }

}
