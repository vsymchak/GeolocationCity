import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Admin on 13.11.2016.
 */
public class Main {


    public static void main(String[] args) throws IOException, JSONException {

        //базовий URL, Geocoding API
        final String baseUrl = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";
        String city;


        //прочитаємо файл
        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());

        //перебераємо міста із файла
        for (String x : lines) {

            //перетворимо назву міста в латиницю
            Translit cityENG = new Translit(x);
            city = cityENG.getTown();

            System.out.println("Name city: " + city);

            //генеруємо URL пошуку
            String url = baseUrl + city;
            //System.out.println(url);

            //запрос до веб сервіса
            JSONObject response = JsonReader.read(url);

            // беремо перший варіант відповіді
            JSONObject location = response.getJSONArray("results").getJSONObject(0);
            location = location.getJSONObject("geometry");
            location = location.getJSONObject("location");
            final double lng = location.getDouble("lng");// долгота
            final double lat = location.getDouble("lat");// широта

            // друк результатів
            System.out.print("Location : ");
            System.out.println(String.format("%f,%f", lat, lng));
            System.out.println();
        }

    }

}
