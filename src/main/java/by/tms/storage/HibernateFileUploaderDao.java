package by.tms.storage;

import by.tms.entity.FileUploader;
import by.tms.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateFileUploaderDao implements Storage<FileUploader, Long> {

    private final SessionFactory sessionFactory;

    public HibernateFileUploaderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public FileUploader save(FileUploader fileUploader) {
        return (FileUploader) sessionFactory.getCurrentSession().save(fileUploader);
    }

    @Override
    public Optional<FileUploader> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public FileUploader delete(FileUploader entity) {
        return null;
    }


    @Override
    public List<FileUploader> getListOfEntity() {
        return null;
    }

    @Override
    public Optional<FileUploader> findEntity(String parameter) {
        return Optional.empty();
    }

    @Override
    public Optional<FileUploader> findVehicleByOwner(User currentUser) {
        return Optional.empty();
    }
}
