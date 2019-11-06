package com.chupin.service;

import com.chupin.model.Certificate;
import com.chupin.model.Tag;

import java.util.List;
import java.util.Set;

public interface CertificateService {

    int createCertificate(Certificate certificate, Set<Tag> tagSet);

    List<Certificate> getCertificateList();

    Set<Tag> getTagSet(int id);

    Certificate getCertificate(int id);

    void updateCertificate(Certificate certificate, Set<Tag> tagSet);

    void deleteCertificate(Certificate certificate);

}
