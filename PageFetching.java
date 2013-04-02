package crawler;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/** Class that manages fetching the pages from the web.
 * @author Arturo Pacifico Griffini
 *
 */
public class PageFetching {

    /** Methods that manages the fetching and returning the
     *  content of URL.
     * @param url
     * @return
     * @throws IOException
     */
    public static DataInputStream returnPage(URL url) {
        InputStream is = null;
        DataInputStream dis = null;
        try {
            is = url.openStream();
            dis = new DataInputStream(new BufferedInputStream(is));
        } catch (IOException exc) {
            exc.printStackTrace();
            System.out.println(exc.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return dis;
    }

}
