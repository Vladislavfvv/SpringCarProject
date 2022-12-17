package by.tms.storage;

import by.tms.entity.ImageUpload;
import by.tms.entity.Offer;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateImageUploadDao implements Storage<ImageUpload, Long>{

    @Autowired
    private SessionFactory sessionFactory;


    public void save(MultipartFile imageUpload) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(Base64.getEncoder().encodeToString(imageUpload.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public ImageUpload save(ImageUpload entity) {
        return null;
    }

    @Override
    public Optional<ImageUpload> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public ImageUpload delete(ImageUpload entity) {
        return null;
    }

    @Override
    public List<ImageUpload> getListOfEntity() {
        return null;
    }

    @Override
    public Optional<ImageUpload> findEntity(String parameter) {
        return Optional.empty();
    }

    @Override
    public Optional<ImageUpload> findVehicleByOwner(User currentUser) {
        return Optional.empty();
    }
}
