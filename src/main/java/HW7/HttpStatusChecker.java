package HW7;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        int statusCode = connection.getResponseCode();
        if (statusCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Image not found for this code " + code);
        }
        BufferedImage image = ImageIO.read(new URL(url));
        if (image == null) {
            throw new RuntimeException("Image not found for this code " + code);
        }
        return url;
    }
}
