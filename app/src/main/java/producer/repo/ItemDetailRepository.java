package producer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import producer.data.ItemDetail;

/**
 * Created by yogibutola on 8/25/18.
 */
@Repository
public interface ItemDetailRepository extends CrudRepository<ItemDetail, Long> {
}
