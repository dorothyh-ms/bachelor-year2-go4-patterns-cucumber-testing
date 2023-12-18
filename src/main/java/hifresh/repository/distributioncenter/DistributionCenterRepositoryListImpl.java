package hifresh.repository.distributioncenter;

import hifresh.domain.purchase.Contract;
import hifresh.domain.purchase.DistributionCenter;
import hifresh.domain.recipe.Ingredient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile(value = {"listrepo"})
public class DistributionCenterRepositoryListImpl implements DistributionCenterRepository{

    private final List<DistributionCenter> distributionCenterList = new ArrayList<>();
    @Override
    public DistributionCenter findById(int id) {
        Optional<DistributionCenter> distributionCenter = distributionCenterList.stream().filter(d -> d.getId() == id).findFirst();
        return distributionCenter.orElse(null);

    }




    @Override
    public DistributionCenter save(DistributionCenter distributionCenter) {

        if (distributionCenter.getId() == 0){ // if id not set
            distributionCenter.setId(distributionCenterList.stream()
                    .mapToInt(DistributionCenter::getId)
                    .max()
                    .orElse(1));
        }
        distributionCenterList.add(distributionCenter);
        return distributionCenter;
    }

    @Override
    public void clear() {
        distributionCenterList.clear();

    }
}
