package products;

import java.util.List;

//Single responsibility principle
public class Filter implements IFilter{

    @Override
    public List<IProduct> filterByName(String text, List<IProduct> items) {
        CharSequence str = new StringBuilder(text);
        List<IProduct> filtredList = items.stream().filter(o -> o.getProductName().contains(str)).toList();
        return filtredList;
    }

    @Override
    public List<IProduct> filterByAll(String text, List<IProduct> items) {
        CharSequence str = new StringBuilder(text);
        List<IProduct> filtredList = items.stream().filter(o -> o.getProductName().contains(str) || o.getDescription().contains(str)).toList();
        return filtredList;
    }

    @Override
    public List<IProduct> filterByPrice(double min, double max, List<IProduct> items) {
        List<IProduct> filtredList = items.stream().filter(o -> o.getPrice() >= min || o.getPrice() <= max).toList();
        return filtredList;
    }

    @Override
    public List<IProduct> filterAvailable(List<IProduct> items) {
        List<IProduct> filtredList = items.stream().filter(o -> o.getQuantity() > 0).toList();
        return filtredList;
    }
}
