package nitro.com.Entity;


import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class FileManager {
    private String pathname = "/home/denis/Рабочий стол/GitTest/1";
    private String name = "new.txt";

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createFile(String body) throws IOException {
        File file = new File(pathname, name);
        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                //Записываем текст у файл
                out.print(body);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String[] listPath(){
        File file = new File(pathname);
        String [] strings=file.list();
        return strings;
    }

    public String upDate(String name,String body) throws IOException{
        File file = new File(pathname, name);
        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                throw new  IOException();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                //Записываем текст у файл
                out.print(body);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "update file";
    }
}
