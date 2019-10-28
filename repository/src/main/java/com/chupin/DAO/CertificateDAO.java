package com.chupin.DAO;

import com.chupin.model.Certificate;
import com.chupin.model.Tag;

import java.util.List;
import java.util.Set;

public interface CertificateDAO {

    List<Certificate> getAll();

    List<Certificate> getByTag(Tag tag);

    List<Certificate> getByPartOfName(Tag tag);

    List<Certificate> getSortedCertificatesByName();

    Certificate getById(int id);

    int save(Certificate certificate, Set<Tag> tagList);

    void update(Certificate certificate, Set<Tag> tagList);

    void delete(Certificate certificate);
}
