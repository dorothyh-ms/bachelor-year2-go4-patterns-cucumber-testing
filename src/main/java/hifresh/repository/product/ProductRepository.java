package hifresh.repository.product;

import hifresh.domain.purchase.Product;
import hifresh.repository.Repository;

import java.util.Optional;

public interface ProductRepository extends Repository<Product> {

    Product findByName(String name);
}
