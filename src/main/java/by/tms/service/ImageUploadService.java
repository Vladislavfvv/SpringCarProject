package by.tms.service;

import by.tms.entity.AbstractVehicle;
import by.tms.entity.ImageUpload;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {

    private final Storage<ImageUpload, Long> imageUploadLongService;

    public ImageUploadService(@Qualifier("hibernateImageUploadDao")Storage<ImageUpload, Long> imageUploadLongService) {
        this.imageUploadLongService = imageUploadLongService;
    }

    public void save(String image) {
       // imageUploadLongService.save((ImageUpload) image);

    }
}
