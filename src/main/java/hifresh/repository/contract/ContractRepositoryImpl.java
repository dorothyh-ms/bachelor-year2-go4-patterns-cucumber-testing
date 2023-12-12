package hifresh.repository.contract;


import hifresh.domain.purchase.Contract;
import hifresh.domain.recipe.Ingredient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository{
    @Override
    public Contract findById(int id) {
        return null;
    }


    @Override
    public void update(Contract contract) {

    }

    @Override
    public Contract save(Contract contract) {
        return null;
    }
}
