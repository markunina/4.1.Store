package input;

public interface IInput {
    int getNumber(int minValue, int maxValue);

    String getString();

    double getPrice(double min, double max);

    long getId();
}
