package com.chupin.DAO;

import com.chupin.model.Certificate;
import com.chupin.model.Tag;

import java.util.List;
import java.util.Set;

public interface CertificateDAO {

    List<Certificate> getAll();

    Certificate getById(long id);

    long save(Certificate certificate);

    void update(Certificate certificate);

    void delete(Certificate certificate);

    Set<Certificate> getByTag(Tag tag);

    List<Certificate> getByPartOfName(String name);

    List<Certificate> getSortedCertificatesByName();
}
