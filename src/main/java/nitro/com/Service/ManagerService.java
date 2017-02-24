package nitro.com.Service;

import nitro.com.Entity.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ManagerService {

    @Autowired
    FileManager fileManager;
    public String getPathname(){
        return fileManager.getPathname();
    }
    public String getName(){
        return fileManager.getName();
    }

    public void setFileName(String name){
        fileManager.setName(name);
    }
    public String createFile(String body) throws IOException {

        fileManager.createFile(body);
        return "create";
       // return "create file ";
        //return "creating file in pathname";

    }

    public String[] getList() {

        return fileManager.listPath();

       //return "getting list".split(" ");
        //return fileManager.listPath();
    }

    public String upDateFile(String body) throws IOException {
        return fileManager.upDate(body);
        //return "update file";
    }

    public String deleteAllFile() {
        return "delete all file";
    }

    public String deleteFile() throws FileNotFoundException {

        return fileManager.deleteFile();

    }


    public String getInHex(String name) {
        fileManager.setName(name);
        return fileManager.returnInHex();

    }
}

