package products;

import java.util.List;
import java.util.Map;

public interface ICatalog {

    String getCatalog(List<IProduct> items, Map<IProduct, Double> rating);

}
