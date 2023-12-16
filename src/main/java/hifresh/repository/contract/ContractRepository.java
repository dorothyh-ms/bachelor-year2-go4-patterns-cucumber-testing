package hifresh.repository.contract;

import hifresh.domain.purchase.Clause;
import hifresh.domain.purchase.Contract;
import hifresh.repository.Repository;

public interface ContractRepository extends Repository<Contract> {

    void setClauseOfContract(int contractId, Clause clause);
}
