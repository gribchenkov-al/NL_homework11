import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int calculateCost(String сountry, String city, int weight, Map<Address, Integer> costPerAddress) {
        Address findAdress = new Address(сountry, city);

        if (costPerAddress.get(findAdress) == null) {
            System.out.println("Адрес доставки не обслуживается");
            return 0;
        } else {
            int costKg = costPerAddress.get(findAdress);
            System.out.println("Стоимость доставки вашей посылки до " + сountry + "," + city + " составляет " + costKg * weight);
            return costKg * weight;
        }

    }

    public static void main(String[] args) {
        Address addressOne = new Address("Россия", "Пенза");
        Address addressTwo = new Address("Россия", "Санкт-Петербург");
        Address addressThree = new Address("Япония", "Токио");

        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(addressOne, 120);
        costPerAddress.put(addressTwo, 300);
        costPerAddress.put(addressThree, 1000);

        Scanner input = new Scanner(System.in);

        int finalCost = 0;

        while (true) {

            System.out.println("Заполнение нового заказа.");
            System.out.println("Введите страну:");
            String country = input.next();

            if (country.equalsIgnoreCase("end")) {
                System.out.println("Итоговая стоимость всех доставок: " + finalCost + " Руб.");
                break;
            }

            System.out.println("Введите город:");
            String city = input.next();
            System.out.println("Введите вес (кг) :");
            int weight = input.nextInt();
            finalCost = finalCost + calculateCost(country, city, weight, costPerAddress);
            System.out.println("Общая стоимость всех доставок: " + finalCost + " Руб. ");
            System.out.println();

        }
    }
}