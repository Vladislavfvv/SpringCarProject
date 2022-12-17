package by.tms.service;

import by.tms.entity.FileUploader;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FileUploaderService {

    private final Storage<FileUploader, Long> fileUploaderService;

    public FileUploaderService(@Qualifier("hibernateFileUploaderDao") Storage<FileUploader, Long> fileUploaderService) {
        this.fileUploaderService = fileUploaderService;
    }


    public void save(FileUploader upload) {
        fileUploaderService.save(upload);
    }
}
