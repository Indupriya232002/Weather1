import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Weather {

    private static final String API_KEY = "b6907d289e10d714a6e88b30761fae22";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("1. Get weather");
            System.out.println("2. Get Wind Speed");
            System.out.println("3. Get Pressure");
            System.out.println("0. Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the date: ");
                    String date = scanner.next();
                    printWeather(date);
                    break;
                case 2:
                    System.out.println("Enter the date: ");
                    date = scanner.next();
                    printWindSpeed(date);
                    break;
                case 3:
                    System.out.println("Enter the date: ");
                    date = scanner.next();
                    printPressure(date);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 0);
    }

    private static void printWeather(String date) throws IOException {
        URL url = new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=" + API_KEY + "&date=" + date);
        URLConnection connection = url.openConnection();
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);

        String json = bufferedReader.readLine();
        System.out.println(json);
    }

    private static void printWindSpeed(String date) throws IOException {
        URL url = new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=" + API_KEY + "&date=" + date);
        URLConnection connection = url.openConnection();
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);

        String json = bufferedReader.readLine();
        int windSpeed = Integer.parseInt(json.split(",")[10], 10);
        System.out.println("Wind speed: " + windSpeed);
    }

    private static void printPressure(String date) throws IOException {
        URL url = new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=" + API_KEY + "&date=" + date);
        URLConnection connection = url.openConnection();
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);

        String json = bufferedReader.readLine();
        int pressure = Integer.parseInt(json.split(",")[11], 10);
        System.out.println("Pressure: " + pressure);
    }
}