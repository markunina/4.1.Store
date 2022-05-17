package input;

import java.util.Scanner;

public class Input implements IInput {

    public static final Scanner scanner = new Scanner(System.in);

    public int getNumber(int minValue, int maxValue) {
        int number;
        try {
            number = Integer.parseInt(scanner.nextLine());
            if (number <= maxValue || number >= minValue) {
                return number;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Пожалуйста, введите число");
        }
        return 0;
    }

    public String getString() {
        return scanner.nextLine();
    }

    public double getPrice(double min, double max) {
        double price;
        while (true) {
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price >= min && price <= max) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        return price;
    }

    @Override
    public long getId() {
        long number;
        try {
            number = Long.parseLong(scanner.nextLine());
            return number;
        } catch (Exception e) {
            throw new IllegalArgumentException("Пожалуйста, введите корректный id");
        }
    }

}