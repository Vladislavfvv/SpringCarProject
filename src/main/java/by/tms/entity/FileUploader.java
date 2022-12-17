package by.tms.entity;

import javax.persistence.*;

@Entity
@Table(name = "filesUpload")
public class FileUploader extends AbstractEntity{

    private String fileName;
    @Lob
    private byte[] data;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @OneToOne
    private Car car;

    public FileUploader() {
    }

    public FileUploader(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public FileUploader(Car car) {
        this.car = car;
    }

    public FileUploader(String fileName, byte[] data, Car car) {
        this.fileName = fileName;
        this.data = data;
        this.car = car;
    }

}
