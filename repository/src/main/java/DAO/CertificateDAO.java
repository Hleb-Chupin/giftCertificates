package DAO;

import model.Certificate;
import model.Tag;

import java.util.List;

public interface CertificateDAO {

    List<Certificate> getAll();

    List<Certificate> getByTag(Tag tag);

    List<Certificate> getByPartOfName(Tag tag);

    List<Certificate> getSortedCertificatesByName();

    Certificate getById(int id);

    void save(Certificate certificate, Tag tag);

    void update(Certificate certificate, Tag tag);

    void delete(Certificate certificate);
}
