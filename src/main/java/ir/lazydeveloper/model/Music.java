package ir.lazydeveloper.model;

import lombok.Data;

import java.io.InputStream;
import java.sql.Date;

@Data
public class Music {
    private int id;
    private String musicName;
    private InputStream pictureFile;
    private InputStream musicFile;
    private String category;
    private String artisName;
    private int personID;
    private Date Uploaded;
    private Date modTime;
}
