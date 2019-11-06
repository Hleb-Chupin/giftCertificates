package com.chupin.DAO.DAOImpl;

import com.chupin.DAO.TagDAO;
import com.chupin.model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DAOTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TagDAOImplTest {

    @Autowired
    private TagDAO tagDAO;

    public Tag initializeNewEntity() {
        Tag tagExpected = new Tag();
        tagExpected.setTagName("CityTour");
        tagDAO.save(tagExpected);
        return tagExpected;
    }

    @Test
    public void getAll() {
        assertThat(tagDAO.getAll().isEmpty(), is(true));
        initializeNewEntity();
        assertThat(tagDAO.getAll().isEmpty(), is(false));
    }

    @Test
    public void getById() {
        Tag tagExpected = initializeNewEntity();
        assertThat(tagDAO.getById(tagExpected.getId()), equalTo(tagExpected));
    }

    @Test
    public void save() {
        assertThat(tagDAO.getAll().isEmpty(), is(true));
        initializeNewEntity();
        assertThat(tagDAO.getAll().isEmpty(), is(false));
    }

    @Test
    public void update() {
        Tag tagExpected = initializeNewEntity();
        assertThat(tagDAO.getById(tagExpected.getId()).getTagName(), equalTo(tagExpected.getTagName()));
        tagExpected.setTagName("Changed name");
        tagDAO.update(tagExpected);
        assertThat(tagDAO.getById(tagExpected.getId()).getTagName(), equalTo("Changed name"));
    }

    @Test
    public void delete() {
        Tag tagExpected = initializeNewEntity();
        assertThat(tagDAO.getAll().isEmpty(), is(false));
        tagDAO.delete(tagExpected);
        assertThat(tagDAO.getAll().isEmpty(), is(true));
    }
}