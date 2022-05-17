package products;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rating implements IRating {

    private static Map<IProduct, List<Integer>> ratings = new HashMap<>();
    private static Map<IProduct, Double> rating = new HashMap<>();

    @Override
    public Map<IProduct, Double> getRating() {
        return rating;
    }

    @Override
    public Map<IProduct, List<Integer>> getRatings() {
        return ratings;
    }

    @Override
    public void setRating(IProduct product, int itemRating) {
        List<Integer> itemRatings;
        if (ratings.containsKey(product)) {
            ratings.get(product).add(itemRating);
        } else {
            itemRatings = new ArrayList<>();
            itemRatings.add(itemRating);
            ratings.put(product, itemRatings);
        }
        int sumRatings = 0;
        for (var r : ratings.get(product)) {
            sumRatings += r;
        }
        var newRating = new BigDecimal(sumRatings)
                .divide(new BigDecimal(ratings.get(product).size()))
                .round(new MathContext(2))
                .doubleValue();
        rating.put(product, newRating);
    }
}

