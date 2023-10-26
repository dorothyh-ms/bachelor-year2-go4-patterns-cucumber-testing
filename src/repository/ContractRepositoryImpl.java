package repository;

import domain.logistics.Contract;
import domain.menu.ingredient.Ingredient;

import java.time.LocalDate;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository{
    private List<Contract> contracts;
    public List<Contract> findByIngredientAndDate(Ingredient ingredient, LocalDate date) {
        return null;

    }
}
