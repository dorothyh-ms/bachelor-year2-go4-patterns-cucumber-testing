# HiFresh


Below are the patterns we felt best fit the project description and inputs.

## Gang of Four Patterns

### Composite

The `RecipeComponent`, `Recipe` and `CompositeRecipe` classes follow the Composite pattern. 
`RecipeComponent` is an abstract class (not interface, as this made it easier to inherit and access properties without duplicating them in the child classes). 


`Recipe` is the 'leaf node' of this pattern, and inherits from `RecipeComponent`. 
`CompositeRecipe` also inherits from `RecipeComponent`, and has a list of other `RecipeComponents`, which may be `Recipe` leaves or other `CompositeRecipe` objects.

### Static Factory Method

The classes in the `pricing` package follow the Static Factory Method pattern. In this project, the pattern is used to manage the creation of objects that implement the `RecipePricingStrategy` interface.
The `RecipePricingStrategyFactory` has a static factory method, which takes a `type` string parameter supplied by the RecipeService from the controller. 

This parameter is used to generate the corresponding `RecipePricingStrategy` (the only implementation is `WeightedAveragePricingStrategy`).
We use the Static Factory Method pattern to move the responsibility of creating RecipePricingStrategies from the RecipeService to a dedicated factory class, which obscures all implementations of `RecipePricingStrategy` from the `RecipeService`. 

### Strategy

We use the Strategy pattern to allow different algorithms to be used to calculate recipe price. For example, the WeightedAveragePricingStrategy contains the logic to calculate the price of a `Recipe` using a weighted average. 
The `Recipe` class has a RecipePricingStrategy as an attribute. The `Recipe` class has a `calculateCost` method, which calls the `calculateCost` method of RecipePricingStrategy. The `Recipe` is passed as a parameter to the `RecipePricingStrategy`'s `calculateCost` method

## SOLID 

Dependency inversion principle: 
- We depend on the highest abstractions of `RecipeService` and `RecipeRepository` (both interfaces). The implementation of the interfaces that is used will depend on the Spring profile. 
- We also apply this pattern when handling `Recipes`/`RecipeComponents`/`CompositeRecipes`. `RecipeComponent` is the highest level of abstraction of all three classes, so controller/service/repository methodds depend on `RecipeComponent` in almost all methods (unless a method of `CompositeRecipe` needs to be accessible).

## Tests

Execute tests outlined in the feature files by running `/test/java/hifresh/RunCucumberTest`
