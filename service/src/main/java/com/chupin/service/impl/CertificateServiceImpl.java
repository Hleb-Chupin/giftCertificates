package com.chupin.service.impl;

import com.chupin.DAO.CertificateDAO;
import com.chupin.model.Certificate;
import com.chupin.model.Tag;
import com.chupin.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateDAO certificateDAO;


    @Override
    public int createCertificate(Certificate certificate, Set<Tag> tagSet) {
        return certificateDAO.save(certificate, tagSet);
    }

    @Override
    public List<Certificate> getCertificateList() {
        return certificateDAO.getAll();
    }

    @Override
    public Set<Tag> getTagSet(int id) {
        return certificateDAO.getById(id).getTags();
    }

    @Override
    public Certificate getCertificate(int id) {
        return certificateDAO.getById(id);
    }

    @Override
    public void updateCertificate(Certificate certificate, Set<Tag> tagSet) {
        certificateDAO.update(certificate, tagSet);
    }

    @Override
    public void deleteCertificate(Certificate certificate) {
        certificateDAO.delete(certificate);
    }
}
