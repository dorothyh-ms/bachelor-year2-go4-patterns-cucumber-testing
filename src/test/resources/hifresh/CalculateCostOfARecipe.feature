Feature: Calculate cost of a recipe

	As a menu team member 
	I want to calculate the cost of a recipe for HiFresh at a given time
	So that I can propose the right recipes at the right time to our customers

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
            | product_id | product_name       |
            | 1          | flour              |
            | 2          | milk               |
            | 3          | cheese             |
            | 4          | self-raising flour |

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



    Scenario: Calculate price of a recipe on a given date  #DONE see calculaterecipecost.xslx
        Given the date is 2024-03-15
        Then the average cost of recipe 4 is 0.9153333

    Scenario: Calculate the price of a recipe with a subrecipe on a given date # MVP: suppose subrecipe is of exact quantity needed
        Given the date is 2024-03-15
        Then the average cost of recipe 3 is 0.9153333







