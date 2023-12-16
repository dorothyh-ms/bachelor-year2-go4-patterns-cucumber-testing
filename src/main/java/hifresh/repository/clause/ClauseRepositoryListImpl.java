package hifresh.repository.clause;

import hifresh.domain.purchase.Clause;
import hifresh.domain.purchase.Product;
import hifresh.domain.recipe.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ClauseRepositoryListImpl implements ClauseRepository{

    private final List<Clause> clauses = new ArrayList<>();
    @Override
    public Clause findById(int id) {
        Optional<Clause> clause = clauses.stream().filter(c -> c.getId() == id).findFirst();
        return clause.orElse(null);
    }

    @Override
    public void update(Clause clause) {

    }

    @Override
    public Clause save(Clause clause) {
        return null;
    }

    @Override
    public void clear() {

    }
}
