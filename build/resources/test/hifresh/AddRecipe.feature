Feature: Add a recipe

  As a menu team member
  I want to add a recipe
  So that customers can order the recipe

  Background:
    Given recipes
      | recipe_id | recipe_name    | recipe_description           |
      | 1         | pancakes       | Gorgeous pancakes            |
      | 2         | Pizza          | Deep pan pizza               |
      | 3         | Cheese Sauce   | Cheesy Sauce                 |
      | 4         | Bechamel Sauce | Creamy Dreamy Bechamel Sauce |

    Given subrecipes
      | recipe_id | subrecipe |
      | 3         | 4         |


    Given products
      | product_id | product_name       | unit      |
      | 1          | flour              | GRAM      |
      | 2          | milk               | MILILITRE |
      | 3          | cheese             | GRAM      |
      | 4          | self-raising flour | GRAM      |
      | 5          | tomatoes           | GRAM      |
      | 6          | beef mince         | GRAM      |
      | 7          | spaghetti          | GRAM      |
      | 8          | ham                | GRAM      |

    Given ingredients
      | ingredient_id | product_id | recipe_id | quantity | unit      |
      | 1             | 1          | 1         | 100      | GRAM      |
      | 3             | 3          | 2         | 20       | GRAM      |
      | 4             | 3          | 3         | 20       | GRAM      |
      | 5             | 3          | 4         | 40       | GRAM      |
      | 6             | 2          | 4         | 600      | MILILITRE |

    Given steps
      | step_id | description                              | recipe_id | order |
      | 1       | step 1                                   | 1         | 1     |
      | 2       | step 2                                   | 1         | 2     |
      | 3       | Add the cheese to the bechamel sauce     | 3         | 1     |
      | 4       | Heat gently for 5 minutes                | 3         | 2     |
      | 5       | Lookup online how to make bechamel sauce | 4         | 1     |

    Given distributioncentres
      | distributioncentre_id | distributioncentre_name |
      | 1                     | DC1                     |
      | 2                     | DC2                     |

    Given contracts
      | contract_id | product_id | supplier_id    | distributioncentre_id |
      | 1           | 1          | 1              | 1                     |
      | 2           | 1          | 2              | 2                     |
      | 3           | 2          | 1              | 1                     |
      | 4           | 2          | 2              | 2                     |
      | 5           | 3          | 1              | 1                     |
      | 6           | 3          | 2              | 2                     |


    Given clauses
      | clause_id   | contract_id | price        | maxQuantity    | unit       | start_date  | end_date   |
      | 1           | 1           | 0.0015       | 100000         | GRAM       | 2024-01-01  | 2024-01-31 |
      | 2           | 2           | 0.00135      | 80000          | GRAM       | 2024-01-01  | 2024-01-31 |
      | 3           | 1           | 0.0015       | 100000         | GRAM       | 2024-01-01  | 2024-01-31 |
      | 4           | 2           | 0.00135      | 80000          | GRAM       | 2024-01-01  | 2024-01-31 |
      | 5           | 3           | 0.0015       | 100000         | MILILITRE  | 2024-01-01  | 2024-01-31 |
      | 6           | 4           | 0.00135      | 80000          | MILILITRE  | 2024-01-01  | 2024-01-31 |
      | 7           | 1           | 0.0015       | 100000         | GRAM       | 2024-03-01  | 2024-03-31 |
      | 8           | 2           | 0.00135      | 100000         | GRAM       | 2024-03-01  | 2024-03-31 |
      | 9           | 1           | 0.0015       | 100000         | GRAM       | 2024-03-01  | 2024-03-31 |
      | 10          | 2           | 0.00135      | 100000         | GRAM       | 2024-03-01  | 2024-03-31 |
      | 11          | 3           | 0.0015       | 80000          | MILILITRE  | 2024-03-01  | 2024-03-31 |
      | 12          | 4           | 0.00135      | 80000          | MILILITRE  | 2024-03-01  | 2024-03-31 |
      | 13          | 3           | 0.0015       | 80000          | MILILITRE  | 2024-03-01  | 2024-03-31 |
      | 14          | 4           | 0.00135      | 80000          | MILILITRE  | 2024-03-01  | 2024-03-31 |
      | 15          | 5           | 0.00135      | 100000         | GRAM       | 2024-03-01  | 2024-03-31 |
      | 16          | 6           | 0.00135      | 100000         | MILILITRE  | 2024-03-01  | 2024-03-31 |
      | 17          | 5           | 0.0014       | 80000          | GRAM       | 2024-03-01  | 2024-03-31 |
      | 18          | 6           | 0.00145      | 80000          | MILILITRE  | 2024-03-01  | 2024-03-31 |

#  Scenario: Add recipe
#    When I add recipe 5 with name "bolognese sauce"
#    And I add ingredient 500 grammes "tomatoes" to recipe 5
#    And I add ingredient 250 grammes "beef mince" to recipe 5
#    And I append these preparation steps  to recipe 5
#      | Put a large saucepan on a medium heat and add 1 tbsp olive oil. |
#      | Increase the heat to medium-high, add the beef mince and cook stirring for 3-4 mins until the meat is browned all over. |
#      | Chop the tomatoes |
#      | Add the tomatoes, Cook for a few minutes. |
#      | Season with salt and black pepper to taste. |
#    Then recipe 5 should have 2 ingredients and 5 preparation steps

#if you don't succeed in handling the above format you can fall back to this:
  # ALT - Add recipe
   Scenario: Add recipe
        When I add recipe 5 with name "bolognese sauce"
		And I add ingredient 500 grammes "tomatoes" to recipe 5
		And I add ingredient 250 grammes "beef mince" to recipe 5
		And I append a preparation step to recipe 5 with description "Put a large saucepan on a medium heat and add 1 tbsp olive oil"
		And I append a preparation step to recipe 5 with description "Increase the heat to medium-high, add the beef mince and cook stirring for 3-4 mins until the meat is browned all over"
		And I append a preparation step to recipe 5 with description "Chop the tomatoes"
		And I append a preparation step to recipe 5 with description "Add the tomatoes, Cook for a few minutes"
		And I append a preparation step to recipe 5 with description "Season with salt and black pepper to taste"
		Then recipe 5 should have 2 ingredients and 5 preparation steps
		And preparation step 3 is "Chop the tomatoes"



#  Scenario: Add recipe with subrecipe
#    When I add recipe 6 with name "Baked spaghetti alla carbonara"
#    And I add these ingredients to recipe 6
#      | quantity | product    |
#      | 200      | ham  |
#      | 500      | spaghettti |
#      | 50       | cheese |
#    And I add subrecipe 3 to recipe 6
#    And I append these preparation steps  to recipe 6
#      | Boil the spaghetti |
#      | Heat the oven to 180°C |
#      | Add the spagghetti to an ovendish and top it with the ham and cheese sauce |
#      | Grate the cheese and sprinkle it over the spaghetti |
#      | Put in the oven for 10 minutes |
#    Then recipe 6 should have 3 ingredients and 5 preparation steps and 1 subrecipe

  #  ALT - Add recipe with subrecipe
    Scenario: Add recipe with subrecipe
    When I add recipe 6 with name "Baked spaghetti alla carbonara"
     And I add ingredient 200 grammes "ham" to recipe 6
     And I add ingredient 500 grammes "spaghettti" to recipe 6
      And I add ingredient 50 grammes "cheese" to recipe 6

      And I add subrecipe 3 to recipe 6
     And I append a preparation step to recipe 6 with description "Boil the spaghetti"
     And I append a preparation step to recipe 6 with description "Heat the oven to 180°C"
     And I append a preparation step to recipe 6 with description "Add the spagghetti to an ovendish and top it with the ham and cheese sauce"
     And I append a preparation step to recipe 6 with description "Grate the cheese and sprinkle it over the spaghetti"
     And I append a preparation step to recipe 6 with description "Put in the oven for 10 minutes"

    Then recipe 6 should have 3 ingredients and 5 preparation steps and 1 subrecipe




  Scenario: Add a step to a recipe
    When i add a step "Serve hot" to recipe 1
    Then the recipe has 3 steps
    And the last step of recipe 1 has description "Serve hot"

  Scenario: Insert a step into a recipe
    When I add a step  "Grate the cheese" to recipe 3 before step 1
    Then the recipe has 3 steps
    And step 1 for recipe 3 is "Grate the cheese"
    And step 2 for recipe 3 is "Add the cheese to the bechamel sauce"
    And step 3 for recipe 3 is "Heat gently for 5 minutes"





