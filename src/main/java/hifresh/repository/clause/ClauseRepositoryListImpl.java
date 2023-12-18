package hifresh.repository.clause;

import hifresh.domain.purchase.Clause;
import hifresh.domain.purchase.DistributionCenter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
@Profile(value = {"listrepo"})
public class ClauseRepositoryListImpl implements ClauseRepository{

    private final List<Clause> clauseList = new ArrayList<>();
    @Override
    public Clause findById(int id) {
        Optional<Clause> clause = clauseList.stream().filter(c -> c.getId() == id).findFirst();
        return clause.orElse(null);
    }


    @Override
    public Clause save(Clause clause) {
        if (clause.getId() == 0){ // if id not set
            clause.setId(clauseList.stream()
                    .mapToInt(Clause::getId)
                    .max()
                    .orElse(1));
        }
        clauseList.add(clause);
        return clause;
    }

    @Override
    public void clear() {

    }
}
