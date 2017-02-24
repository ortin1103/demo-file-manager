package nitro.com.Controller;

import nitro.com.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/files")

public class FileController {

    @Autowired
    ManagerService managerService;

    @RequestMapping(value = ("/{filename}"),method = RequestMethod.POST) //создать файл
    public ResponseEntity createFile(@PathVariable String filename , @RequestBody String body) {

        managerService.setFileName(filename);

        try {
            managerService.createFile(body);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("File already exist");
            return new ResponseEntity("File already exsist",HttpStatus.BAD_REQUEST);
        } return new ResponseEntity( managerService.getName(),HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET) //вывести лист

    public ResponseEntity getList(){

       return new ResponseEntity(managerService.getList(),HttpStatus.OK);
    }
    @RequestMapping(value = "/{name}",method = RequestMethod.GET) //get in HEX
    public String getList(@PathVariable String name){

        return managerService.getInHex(name);
    }

    @ResponseStatus (value = HttpStatus.ACCEPTED)
    @RequestMapping(value = "/{name}",method = RequestMethod.PUT) //обновить
    public ResponseEntity updateFile(@PathVariable String name, @RequestBody String body){
        managerService.setFileName(name);
        try {
             managerService.upDateFile(body);
        } catch (IOException e) {
            e.printStackTrace();
        } return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.DELETE) //удалить файл
    public String deleteFile(@PathVariable String name){


            managerService.setFileName(name);
        try {
            return managerService.deleteFile();
        } catch (FileNotFoundException e) {

            return "error";
        }
    }

    @RequestMapping(value ="/",method =RequestMethod.DELETE)  //удалить все в папке
    public  String deleteAllFile(){
       return managerService.deleteAllFile();
    }

}
