package crawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Arturo Pacifico Griffini
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 1 || args.length == 2) {
            File inputFileName = new File(args[0]);
            Reader input = null;
            String urlStr = null;
            LinkedList<URL> initURLFrontier = new LinkedList<URL>();
            try {
                input = new FileReader(inputFileName);
                Scanner scn = new Scanner(input);
                while (scn.hasNextLine()) {
                    urlStr = scn.nextLine();

                    System.out.println(urlStr);

                    URL url = new URL(urlStr);
                    initURLFrontier.add(url);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
                System.out.println("Malformed URL: " + urlStr);
                System.exit(1);
            }
            int maxVisits = Integer.MAX_VALUE;
            if (args.length == 2) {
                maxVisits = Integer.parseInt(args[1]);
            }



            Crawler crawler = new Crawler(initURLFrontier, maxVisits);
            crawler.beginCrawling();

        } else {
            usage(1);
        }

    }

    private static void usage(int status) {
        String usagemsg = "2 Arguments \n" +
        		"Fisrt argument is the path of the " +
        		"textfile containing the initial URL frontier. \n" +
        		"The second argument is optional and is the max_number of" +
        		"visits the crawler should make.";
        System.out.println(usagemsg);
        System.exit(status);
    }
}
