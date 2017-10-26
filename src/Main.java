import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String s = "";
        s = open_url("http://beans.itcarlow.ie/prices.html");
        s = s.substring(230,234);
        double preis = Double.parseDouble(s);
        if(preis < 4.76)
            System.out.println(s);
        else
            System.out.println("Der Kaffee ist im Moment zu teuer.");


        s = open_url("http://beans.itcarlow.ie/prices-loyalty.html");
        s = s.substring(247,251);
        preis = Double.parseDouble(s);
        if(preis < 4.76)
            System.out.println(s);
        else
            System.out.println("Der Special - Offer - Kaffee ist im Moment zu teuer.");



    }

    private static String open_url(String u ) {
        System.out.println("Connecting to website...");
        String result = "";
        String line = null;

        try {
            URL url = new URL(u);
            InputStream stream = url.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            while((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Connection error!");
        }

        return result;

    }
}
