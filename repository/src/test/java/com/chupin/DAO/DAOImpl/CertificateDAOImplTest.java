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

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DAOTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CertificateDAOImplTest {

    @Autowired
    private CertificateDAO certificateDAO;

    public List<Certificate> initializeNewEntities() {
        String[] names = {"Neris fishing", "Family and the forest", "London sightseeing", "Baloon flight", "Wine testing"};
        String[] tags = {"Fishing", "Holiday", "Citytour", "Air", "Food"};
        List<Certificate> listCertificatesInit = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Certificate certificate = new Certificate();
            certificate.setCertificateName(names[i]);
            Tag tag = new Tag();
            tag.setTagName(tags[i]);
            Set<Tag> setOfTags = new HashSet<>();
            setOfTags.add(tag);
            certificate.setTags(setOfTags);
            certificateDAO.save(certificate);
            listCertificatesInit.add(certificate);
        }
        return listCertificatesInit;
    }

    @Test
    public void getAll() {
        assertThat(certificateDAO.getAll().isEmpty(), is(true));
        List<Certificate> expectedList = initializeNewEntities();
        assertThat(certificateDAO.getAll(), equalTo(expectedList));
    }

    @Test
    public void getByTag() {
        List<Certificate> expectedList = initializeNewEntities();
        assertThat(certificateDAO.getByTag(expectedList.get(2).getTags().iterator().next()).iterator().next(), equalTo(expectedList.get(2)));
    }

    @Test
    public void getByPartOfName() {
        List<Certificate> expectedList = initializeNewEntities();
        String expectedName = expectedList.get(1).getCertificateName();
        String partName = expectedName.substring(1, expectedName.length() - 1);
        assertThat(certificateDAO.getByPartOfName(partName).get(0), equalTo(expectedList.get(1)));
    }

    //
    @Test
    public void getSortedCertificatesByName() {
        List<Certificate> expectedList = initializeNewEntities();
        assertThat(certificateDAO.getSortedCertificatesByName().get(3), equalTo(expectedList.get(0)));
    }

    @Test
    public void getById() {
        List<Certificate> expectedList = initializeNewEntities();
        Certificate expectedCertificate = expectedList.get(3);
        assertThat(certificateDAO.getById(expectedCertificate.getId()), equalTo(expectedCertificate));
    }

    @Test
    public void save() {
        List<Certificate> expectedList = initializeNewEntities();
        assertThat(certificateDAO.getAll().isEmpty(), is(false));
    }

    //
    @Test
    public void update() {
        List<Certificate> expectedList = initializeNewEntities();
        Certificate expectedCertificate = expectedList.get(2);
        expectedCertificate.setCertificateName("Changed name");
        certificateDAO.update(expectedCertificate);
        assertThat(certificateDAO.getById(expectedCertificate.getId()), equalTo(expectedCertificate));
    }

    @Test
    public void delete() {
        List<Certificate> expectedList = initializeNewEntities();
        assertThat(certificateDAO.getAll().isEmpty(), is(false));
        for (int i = 0; i < expectedList.size(); i++) {
            certificateDAO.delete(expectedList.get(i));
        }
        assertThat(certificateDAO.getAll().isEmpty(), is(true));
    }
}