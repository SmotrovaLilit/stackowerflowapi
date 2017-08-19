package hello.repository;

import hello.model.StackSite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackSiteRepository extends MongoRepository<StackSite, String> {

}
