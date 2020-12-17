package upm.prof.webcrawler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.prof.webcrawler.repository.WebsiteRepository;
import upm.prof.webcrawler.service.WebsiteService;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class WebsiteServiceTests {

    WebsiteRepository websiteRepository;
    WebsiteService websiteService;

    @BeforeEach
    public void setUp() {
        this.websiteRepository = mock(WebsiteRepository.class);
        this.websiteService = new WebsiteService();
        this.websiteService.websiteRepository = websiteRepository;
    }

    @Test
    public void addNullClientTest() {
        websiteService.removeWebsiteById(1);
        verify(this.websiteRepository).deleteById(1);
    }

}
