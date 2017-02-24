package nitro.com.Entity;


import org.springframework.stereotype.Component;

import java.io.*;

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

        if(!file.exists() ){
            file.createNewFile();

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {

                out.print(body);
            } finally {

                out.close();
            }

        } throw new IOException();
    }
    public String[] listPath(){
        File file = new File(pathname);
        String [] strings=file.list();
        return strings;
    }

    public String upDate(String body) throws IOException{
        File file = new File(pathname, name);
        if (!file.exists()) {
            throw new IOException();
        }
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        try {

            out.print(body);
        } finally {

            out.close();
        }

        return "update file "+name;
    }

    public String deleteFile() throws FileNotFoundException {


          new File(pathname,name).delete();
                return "file delete "+name;

    }
    public String returnInHex(){
        File file = new File(pathname,name);
    StringBuilder sb = new StringBuilder();
    try {
        //Объект для чтения файла в буфер
        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
        try {
            //В цикле построчно считываем файл
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } finally {
            //Также не забываем закрыть файл
            in.close();
        }
    } catch(IOException e) {
        throw new RuntimeException(e);
    }

    //Возвращаем полученный текст с файла
    return sb.toString();
}

}
