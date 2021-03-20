import com.google.gson.Gson;
import jdk.nashorn.internal.parser.Scanner;

import java.io.*;

public class Main {

    public static void main(String args[]){
        new Scanner(System.in);

        System.out.println("1 - Cчитать из JSON файла\n Записать в JSON файл");

        openJSON();
    }
    private static void openJSON(){
        Gson gson = new Gson();
        StringBuilder string = new StringBuilder();
        try(BufferedReader br = new BufferedReader (new FileReader("./User.txt"))){
           string.append(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = gson.fromJson(string.toString(),User.class);
        System.out.println(user.firstname+" "+user.lastname+" "+user.school);
    }
    private static void saveJSON(){
        User student = new User();
        student.firstname = "Александр";
        student.lastname = "Викторов";
        student.school = 17;

        Gson gson = new Gson();
        try (FileWriter fl = new FileWriter("./User.txt")){
            fl.write(gson.toJson(student));
        }catch (IOException e){
            System.out.println("Err");
        }
        System.out.println(gson.toJson(student));
    }
}
