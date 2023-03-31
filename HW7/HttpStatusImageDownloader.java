package HW7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private HttpStatusChecker checker;
    public HttpStatusImageDownloader(HttpStatusChecker checker) {
            this.checker = checker;
        }

    public void downloadStatusImage(int code) throws IOException {
        String imageUrl = checker.getStatusImage(code);
        if (imageUrl != null) {
            URL url = new URL(imageUrl);
            InputStream inputStream = url.openStream();
            String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
            FileOutputStream outputStream = new FileOutputStream(fileName);
            byte[] buffer = new byte[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
        } else {
            throw new IOException("No image for this code " + code);
        }
    }
}
