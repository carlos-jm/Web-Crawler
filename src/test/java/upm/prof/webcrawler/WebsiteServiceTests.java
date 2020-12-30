package upm.prof.webcrawler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upm.prof.webcrawler.entity.Category;
import upm.prof.webcrawler.entity.Type;
import upm.prof.webcrawler.entity.Website;
import upm.prof.webcrawler.exceptions.AlreadyExistsException;
import upm.prof.webcrawler.exceptions.BadRequestException;
import upm.prof.webcrawler.repository.WebsiteRepository;
import upm.prof.webcrawler.service.CategoryService;
import upm.prof.webcrawler.service.TypeService;
import upm.prof.webcrawler.service.WebsiteService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class WebsiteServiceTests {

    WebsiteRepository websiteRepository;
    WebsiteService websiteService;
    CategoryService categoryService;
    TypeService typeService;

    @BeforeEach
    public void setUp() {
        this.websiteRepository = mock(WebsiteRepository.class);
        this.websiteService = new WebsiteService();
        this.websiteService.websiteRepository = websiteRepository;

        this.categoryService = mock(CategoryService.class);
        this.websiteService.categoryService = this.categoryService;

        this.typeService = mock(TypeService.class);
        this.websiteService.typeService = this.typeService;
    }

    @Test
    public void deleteWebsiteTest() {
        websiteService.removeWebsiteById(1);
        verify(this.websiteRepository).deleteById(1);
    }

    @Test
    public void addWebsiteUrlNullTest() {
        Website website = mock(Website.class);
        Category category = mock(Category.class);
        Type type = mock(Type.class);
        when(website.getUrl()).thenReturn(null);
        when(website.getType()).thenReturn(type);
        when(website.getCategory()).thenReturn(category);
        when(website.getLast_update()).thenReturn("");
        assertThrows(BadRequestException.class, () -> this.websiteService.saveWebsite(website));
    }

    @Test
    public void addWebsiteCategoryNullTest() {
        Website website = mock(Website.class);
        Type type = mock(Type.class);
        when(website.getUrl()).thenReturn("");
        when(website.getType()).thenReturn(type);
        when(website.getCategory()).thenReturn(null);
        when(website.getLast_update()).thenReturn("");
        assertThrows(BadRequestException.class, () -> this.websiteService.saveWebsite(website));
    }

    @Test
    public void addWebsiteLastUpdateNullTest() {
        Website website = mock(Website.class);
        Category category = mock(Category.class);
        Type type = mock(Type.class);
        when(website.getUrl()).thenReturn("");
        when(website.getType()).thenReturn(type);
        when(website.getCategory()).thenReturn(category);
        when(website.getLast_update()).thenReturn(null);
        assertThrows(BadRequestException.class, () -> this.websiteService.saveWebsite(website));
    }

    @Test
    public void addWebsiteTypeNullTest() {
        Website website = mock(Website.class);
        Category category = mock(Category.class);
        when(website.getUrl()).thenReturn("");
        when(website.getType()).thenReturn(null);
        when(website.getCategory()).thenReturn(category);
        when(website.getLast_update()).thenReturn("");
        assertThrows(BadRequestException.class, () -> this.websiteService.saveWebsite(website));
    }

    @Test
    public void addWebsiteAlreadyExistsTest() {
        Website website = mock(Website.class);
        Category category = mock(Category.class);
        Type type = mock(Type.class);
        when(website.getUrl()).thenReturn("");
        when(website.getType()).thenReturn(type);
        when(website.getCategory()).thenReturn(category);
        when(website.getLast_update()).thenReturn("");

        when(website.getId()).thenReturn(0);
        when(this.websiteRepository.findWebsiteById(0)).thenReturn(website);
        assertThrows(AlreadyExistsException.class, () -> this.websiteService.saveWebsite(website));
    }

    @Test
    public void addWebsiteTest() throws BadRequestException, AlreadyExistsException {
        Website website = mock(Website.class);
        Category category = mock(Category.class);
        Type type = mock(Type.class);
        when(website.getUrl()).thenReturn("");
        when(website.getType()).thenReturn(type);
        when(website.getCategory()).thenReturn(category);
        when(website.getLast_update()).thenReturn("");

        when(website.getId()).thenReturn(0);
        when(this.websiteRepository.findWebsiteById(0)).thenReturn(null);
        when(this.websiteRepository.save(website)).thenReturn(website);
        assertEquals(website, this.websiteService.saveWebsite(website));
        verify(this.websiteRepository, times(1)).save(website);
    }

    @Test
    public void getWebsiteByIdTest() {
        Website website = mock(Website.class);
        when(this.websiteRepository.findWebsiteById(0)).thenReturn(website);
        assertEquals(website, this.websiteService.getWebsiteById(0));
        verify(this.websiteRepository, times(1)).findWebsiteById(0);
    }

    @Test
    public void findAllWebsiteTest() {
        this.websiteService.getAllDemoWebsites();
        verify(this.websiteRepository, times(1)).findAll();
    }

    @Test
    public void getFilterWebsiteWebsiteTest() {
        Category category = mock(Category.class);
        Type type = mock(Type.class);

        when(this.categoryService.getCategoryById(-1)).thenReturn(category);
        when(this.typeService.getTypeById(-1)).thenReturn(type);

        this.websiteService.getFilterWebsite("", -1, -1);
        verify(this.websiteRepository, times(1)).filterWebsite("%%", category, type);
    }
}
