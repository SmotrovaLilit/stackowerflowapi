package hello.web;

import hello.model.StackSite;
import hello.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/sites")
public class StacksiteController {

    @Autowired
    private SiteService siteService;

    @RequestMapping
    public List<StackSite> getListSites() {
        return siteService.findAll();
    }
}
