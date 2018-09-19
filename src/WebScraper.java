import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Counts the number of times a word appears on a webpage.
     * @param url the url to read text from
     * @param search the word to search for
     */
    public static void countWords(final String url, final String search) {
        String contents = urlToString(url);
        String[] words = contents.split("\\s+");

        System.out.println("WORD COUNT: " + words.length);


        int count = 0;
        for (String word:words) {
            if (word.replaceAll(",","").toLowerCase().equals(search.toLowerCase())) {
                count++;
            }
        }

        System.out.println("SEARCH WORD (\"" + search + "\") COUNT:" + count);


    }

    public static void main(String[] unused) {
        countWords("http://erdani.com/tdpl/hamlet.txt", "prince");
    }
}
