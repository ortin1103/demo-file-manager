package nitro.com.Controller;

import nitro.com.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")

public class FileController {

    @Autowired
    ManagerService managerService;

    @RequestMapping(method = RequestMethod.POST) //создать файл
    public String createFile(@RequestBody String body) {

        return managerService.createFile(body);
    }

    @RequestMapping(method = RequestMethod.GET) //вывести лист
    public String[] getList(){

       return managerService.getList();
    }
    @RequestMapping(value = "/{name}",method = RequestMethod.GET) //вывести лист
    public String getList(@PathVariable String name){

        return managerService.getInHex(name);
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.PUT) //обновить
    public String updateFile(@PathVariable String name, @RequestBody String body){

        return managerService.upDateFile(body);
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.DELETE) //удалить файл
    public String deleteFile(@PathVariable String name){

        return managerService.deleteFile();
    }

    @RequestMapping(value ="/",method =RequestMethod.DELETE)  //удалить все в папке
    public  String deleteAllFile(){
       return managerService.deleteAllFile();
    }

}
