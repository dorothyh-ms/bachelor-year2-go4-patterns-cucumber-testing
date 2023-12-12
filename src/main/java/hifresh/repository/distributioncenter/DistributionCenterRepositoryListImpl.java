package hifresh.repository.distributioncenter;

import hifresh.domain.purchase.DistributionCenter;
import org.springframework.stereotype.Repository;

@Repository
public class DistributionCenterRepositoryListImpl implements DistributionCenterRepository{
    @Override
    public DistributionCenter findById(int id) {
        return null;
    }


    @Override
    public void update(DistributionCenter distributionCenter) {

    }

    @Override
    public DistributionCenter save(DistributionCenter distributionCenter) {
        return null;
    }
}
