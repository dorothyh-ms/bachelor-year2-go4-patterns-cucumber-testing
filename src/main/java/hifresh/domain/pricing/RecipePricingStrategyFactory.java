package hifresh.domain.pricing;

public class RecipePricingStrategyFactory {
    public static RecipePricingStrategy getPricingStrategy(String type) {
        return switch(type){
            case "weightedaverage" -> new WeightedAveragePricingStrategy();
            default -> new MaximumPricingStategy();
        };

    }
}
