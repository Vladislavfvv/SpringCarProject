package by.tms.dao;

import by.tms.entity.FileUploader;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FileUploaderDaoImpl implements FileUploaderDao {


    private final SessionFactory sessionFactory;

    public FileUploaderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(FileUploader fileUploader) {
        sessionFactory.getCurrentSession().save(fileUploader);
    }
}
