package hello.service;


import com.google.common.collect.ImmutableList;
import hello.model.SiteDto;
import hello.model.SitesDto;
import hello.model.StackSite;
import hello.repository.StackSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class SiteService {
    private static List<StackSite> items = new ArrayList<>();

    @Autowired
    private StackSiteRepository repository;


    @Autowired
    private StackExchangeClient client;

    static {
        items.add(new StackSite("1", "http://30-tele2.backend.chulakov.ru/upload/photo/cache/wid_1200_80_1_5968d10a28a3f.jpg",
                "http://google.ru", "title", "описание"));
        items.add(new StackSite("2", "http://30-tele2.backend.chulakov.ru/upload/photo/cache/wid_240_80_1_5968d11093fbd.jpg",
                "http://google.ru", "title1", "описание1"));
    }

    @PostConstruct
    public void init() {
       // repository.save(items);
    }

/*    public List<StackSite> findAll() {

        return repository.findAll();
    } */

    public List<StackSite> findAll() {
        return client.getSites().stream()
                .map(this::toStackSite)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    public StackSite toStackSite(@NotNull SiteDto dto) {
        return new StackSite(dto.getSite_url(),
                dto.getFavicon_url(),
                dto.getSite_url(),
                dto.getName(),
                dto.getAudience()
        );
    }
}
