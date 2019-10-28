package com.chupin.DAO.DAOImpl;

import com.chupin.DAO.CertificateDAO;
import com.chupin.model.Certificate;
import com.chupin.model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DAOTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CertificateDAOImplTest {

    private Certificate certificateExpected;
    private Set<Tag> tagSet;

    @Autowired
    private CertificateDAO certificateDAO;

    public void initializeNewEntity() {
        certificateExpected = new Certificate();
        certificateExpected.setCertificateName("Birthday");
        certificateExpected.setCertificatePrice(200);
        certificateExpected.setCertificateDescription("");
        certificateExpected.setDateOfCreation(LocalDate.now());
        certificateExpected.setDuration(365);
        Tag tag = new Tag();
        tag.setTagName("CityTour");
        tagSet = new HashSet<>();
        tagSet.add(tag);
        certificateExpected.setTags(tagSet);
    }

    public void tearDown() {

    }

    @Test
    public void getAll() {
        initializeNewEntity();
        certificateDAO.save(certificateExpected, tagSet);
        List<Certificate> listCertificateExpected = new ArrayList<>();
        listCertificateExpected.add(certificateExpected);
        assertThat(certificateDAO.getAll(), equalTo(listCertificateExpected));
    }

    @Test
    public void getByTag() {
    }

    @Test
    public void getByPartOfName() {
    }

    @Test
    public void getSortedCertificatesByName() {
    }

    @Test
    public void getById() {
        initializeNewEntity();
        certificateDAO.save(certificateExpected, tagSet);
        assertThat(certificateDAO.getById(certificateExpected.getId()).getTags(), equalTo(tagSet));
        assertThat(certificateDAO.getById(certificateExpected.getId()), equalTo(certificateExpected));
    }

    @Test
    public void save() {
        assertThat(certificateDAO.getAll(), empty());
        initializeNewEntity();
        certificateDAO.save(certificateExpected, tagSet);
        assertThat(certificateDAO.getAll().isEmpty(), is(false));
    }

    @Test
    public void update() {
        initializeNewEntity();
        certificateDAO.save(certificateExpected, tagSet);
        Certificate certificateExepectedForThatMethod = certificateDAO.getById(certificateExpected.getId());
        certificateExepectedForThatMethod.setCertificateName("New Year");
        certificateExepectedForThatMethod.setCertificatePrice(990);
        certificateDAO.update(certificateExepectedForThatMethod, tagSet);
        assertThat(certificateDAO.getById(certificateExepectedForThatMethod.getId()), equalTo(certificateExepectedForThatMethod));
    }

    @Test
    public void delete() {
        initializeNewEntity();
        certificateDAO.save(certificateExpected, tagSet);
        assertThat(certificateDAO.getAll().isEmpty(), is(false));
        certificateDAO.delete(certificateDAO.getById(certificateExpected.getId()));
        assertThat(certificateDAO.getAll().isEmpty(), is(true));
    }
}