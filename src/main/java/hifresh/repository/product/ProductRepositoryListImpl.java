package hifresh.repository.product;

import hifresh.domain.purchase.Contract;
import hifresh.domain.purchase.Product;
import hifresh.domain.recipe.RecipeComponent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepositoryListImpl implements ProductRepository{

    List<Product> productList = new ArrayList<>();
    @Override
    public Product findById(int id) {

        Optional<Product> product = productList.stream().filter(r -> r.getId() == id).findFirst();
        return product.orElse(null);
    }

    public Product findByName(String name) {

        Optional<Product> product = productList.stream().filter(r -> r.getName().equals(name)).findFirst();
        return product.orElse(null);
    }



    @Override
    public Product save(Product product) {
        productList.add(product);
        return product;
    }

    @Override
    public void clear() {
        this.productList.clear();
    }

    @Override
    public void addContractToProduct(int productId, Contract contract) {
        Product product = findById(productId);
        product.addContract(contract);
        contract.setProduct(product);
    }
}
