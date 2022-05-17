package products;

import java.util.List;
import java.util.Map;

public interface IRating {

    Map<IProduct, Double> getRating();

    Map<IProduct, List<Integer>> getRatings();

    void setRating(IProduct product, int itemRating);

}
