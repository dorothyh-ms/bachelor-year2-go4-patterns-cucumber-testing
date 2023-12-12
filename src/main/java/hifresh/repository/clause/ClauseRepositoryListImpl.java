package hifresh.repository.clause;

import hifresh.domain.purchase.Clause;
import org.springframework.stereotype.Repository;


@Repository
public class ClauseRepositoryListImpl implements ClauseRepository{
    @Override
    public Clause findById(int id) {
        return null;
    }

    @Override
    public void update(Clause clause) {

    }

    @Override
    public Clause save(Clause clause) {
        return null;
    }
}
