package products;

import java.util.List;
import java.util.Map;

public class Catalog implements ICatalog {

    @Override
    public String getCatalog(List<IProduct> products, Map<IProduct, Double> rating) {
        StringBuilder catalog = new StringBuilder();
        IProduct product;
        for (int i = 0; i < products.size(); i++) {
            product = products.get(i);
            double productRating = rating.get(product) == null ? 0 : rating.get(product);
            catalog.append(product.toString())
                    .append("[ рейтинг ").append(productRating).append("]\n");
        }
        return catalog.toString();
    }
}
