package products;

import java.util.List;
import java.util.Optional;

public interface IProducts {

    Optional<IProduct> getById(List<IProduct> items, long id);

    boolean hasItem(List<IProduct> products, long id);

    List<IProduct> getProducts();
}
