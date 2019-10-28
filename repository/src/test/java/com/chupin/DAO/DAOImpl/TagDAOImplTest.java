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

    private Tag tagExpected;

    @Autowired
    private TagDAO tagDAO;

    public void initializeNewEntity() {
        tagExpected = new Tag();
        tagExpected.setTagName("CityTour");
    }

    @Test
    public void getAll() {
        initializeNewEntity();
        tagDAO.save(tagExpected);
        assertThat(tagDAO.getAll().isEmpty(), is(false));
        assertThat(tagDAO.getAll().size(), equalTo(1));
    }

    @Test
    public void getById() {
        initializeNewEntity();
        tagDAO.save(tagExpected);
        assertThat(tagDAO.getById(tagExpected.getId()), equalTo(tagExpected));
    }

    @Test
    public void save() {
        initializeNewEntity();
        assertThat(tagDAO.getAll().isEmpty(), is(true));
        tagDAO.save(tagExpected);
        assertThat(tagDAO.getAll().isEmpty(), is(false));
    }

    @Test
    public void update() {
        initializeNewEntity();
        tagDAO.save(tagExpected);
        assertThat(tagDAO.getById(tagExpected.getId()).getTagName(), equalTo(tagExpected.getTagName()));
        Tag tagExpectedForThatMethod = tagDAO.getById(tagExpected.getId());
        tagExpectedForThatMethod.setTagName("Mountain holidays");
        tagDAO.update(tagExpectedForThatMethod);
        assertThat(tagDAO.getById(tagExpectedForThatMethod.getId()).getTagName(), equalTo("Mountain holidays"));
    }

    @Test
    public void delete() {
        initializeNewEntity();
        tagDAO.save(tagExpected);
        assertThat(tagDAO.getAll().isEmpty(), is(false));
        tagDAO.delete(tagExpected);
        assertThat(tagDAO.getAll().isEmpty(), is(true));
    }
}