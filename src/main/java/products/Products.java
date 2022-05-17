package products;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Products implements IProducts {

    private static List<IProduct> products = new ArrayList<>();

    @Override
    public Optional<IProduct> getById(List<IProduct> items, long id) {
        Optional<IProduct> item = items.stream().filter(i -> i.getId() == id).findFirst();
        return item;
    }

    @Override
    public boolean hasItem(List<IProduct> products, long id) {
        if (getById(products, id).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public List<IProduct> getProducts() {
        return products;
    }

}
