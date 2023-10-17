package repository;

import domain.Contract;
import domain.Ingredient;

import java.time.LocalDate;
import java.util.List;

public class ContractRepository {
    public List<Contract> findByIngredientAndDate(Ingredient ingredient, LocalDate date) {
    }
}
