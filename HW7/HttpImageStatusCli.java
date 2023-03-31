package HW7;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter HTTP status code: ");
        String input = scanner.nextLine();

        try {
            int code = Integer.parseInt(input);
            String imageUrl = new HttpStatusChecker().getStatusImage(code);
            if (imageUrl != null) {
                HttpStatusChecker checker = new HttpStatusChecker();
                HttpStatusImageDownloader downloader = new HttpStatusImageDownloader(checker);
                downloader.downloadStatusImage(code);
            } else {
                System.out.println("There is no image for HTTP status " + code);
            }
        } catch (RuntimeException e) {
            System.out.println("Please enter valid number");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
