package hello.web;

import hello.model.StackSite;
import hello.service.SiteService;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.google.common.collect.ImmutableList;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StacksiteControllerTest {

    @Mock
    private SiteService siteService;

    @InjectMocks
    StacksiteController swt;


    @Test
    public void testGetListSites() throws Exception {
        when(siteService.findAll()).thenReturn(ImmutableList.of());

        List<StackSite> list = swt.getListSites();

        verify(siteService).findAll();
    }


}
