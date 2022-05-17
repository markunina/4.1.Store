package products;

import java.util.List;

public interface IFilter {

    List<IProduct> filterByName(String text, List<IProduct> items);

    List<IProduct> filterByAll(String text, List<IProduct> items);

    List<IProduct> filterByPrice(double min, double max, List<IProduct> items);

    List<IProduct> filterAvailable(List<IProduct> items);


}
