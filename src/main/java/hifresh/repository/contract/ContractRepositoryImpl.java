package hifresh.repository.contract;


import hifresh.domain.purchase.Clause;
import hifresh.domain.purchase.Contract;
import hifresh.domain.recipe.Ingredient;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile(value = {"listrepo"})
public class ContractRepositoryImpl implements ContractRepository{
    private final List<Contract> contractList = new ArrayList<>();
    @Override
    public Contract findById(int id) {
        Optional<Contract> contract = contractList.stream().filter(r -> r.getId() == id).findFirst();
        return contract.orElse(null);
    }




    @Override
    public Contract save(Contract contract) {
        contractList.add(contract);
        return contract;
    }

    @Override
    public void clear() {
        contractList.clear();
    }

    @Override
    public void setClauseOfContract(int contractId, Clause clause) {
        Contract contract = findById(contractId);
        contract.addClause(clause);
        clause.setContract(contract);
    }
}
