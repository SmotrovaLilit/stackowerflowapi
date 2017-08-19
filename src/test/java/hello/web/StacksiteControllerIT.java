package hello.web;

import com.google.common.collect.ImmutableList;
import hello.model.StackSite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StacksiteControllerIT {

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void before() {
        mongoTemplate.dropCollection(StackSite.class);
        mongoTemplate.save(new StackSite("website1", "website", "icon", "title", "description"));
        mongoTemplate.save(new StackSite("website2", "website", "icon", "title", "description"));
    }

    @Test
    public void getListSites() throws Exception {
        ResponseEntity<List<StackSite>> repositoryEntity = restTemplate.exchange(
                "http://localhost:8090/api/sites",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StackSite>>() {
                }
        );

        List<StackSite> actualList = repositoryEntity.getBody();
        assertThat(actualList.size(),is(2));

        List<String> actualIds = actualList.stream()
                .map(stackSite -> stackSite.getId())
                .collect(collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
        assertThat(actualIds, containsInAnyOrder("website1", "website2"));
    }

}
