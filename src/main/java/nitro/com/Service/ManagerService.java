package nitro.com.Service;

import nitro.com.Entity.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    FileManager fileManager;

    public String createFile(String body) {

        //fileManager.createFile(body);
       // return "create file ";
        return "creating file in pathname";

    }

    public String[] getList() {

        return fileManager.listPath();

       //return "getting list".split(" ");
        //return fileManager.listPath();
    }

    public String upDateFile(String name) {
        //return fileManager.upDate(name,body);
        return "update file";
    }

    public String deleteAllFile() {
        return "delete all file";
    }

    public String deleteFile() {
        return "delete file";
    }


    public String getInHex(String name) {
        return "return get in Hex";
    }
}

