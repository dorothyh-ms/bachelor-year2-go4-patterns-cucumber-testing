package hifresh.repository.product;

import hifresh.domain.purchase.Product;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepositoryListImpl implements ProductRepository{
    @Override
    public Product findById(int id) {
        return null;
    }

    public Product findByName(String name) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
