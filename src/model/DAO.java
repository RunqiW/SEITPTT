package model;

import model.PTTModel;
import model.identities.*;
import model.procedures.Class;
import model.procedures.ListOfClasses;
import model.procedures.ListOfRequests;
import model.procedures.Request;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DAO {

    private final String fileDir = "data/";
    FileReader reader;

    public DAO(){

    }

    public void readFile(PTTModel model){
        this.readUsers(model.getUsers());
        this.readClasses(model.getClasses());
        this.readRequests(model.getRequests());
    }

    public void initReader(String file){
        try{
            this.reader = new FileReader(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }




    public ListOfUsers readUsers(ListOfUsers listOfUsers){
        String userFile = this.fileDir + "userfile.txt";
        this.initReader(userFile);
        Scanner s = new Scanner(reader);
        //s.nextLine()
        while(s.hasNextLine()){
            listOfUsers.add(this.readUser(s));
        }
        this.close();
        return listOfUsers;
    }

    public User readUser(Scanner s){
        String type = s.next();
        String[] values = new String[4];
        for (int i=0 ;i<4;i++) {
            values[i] = s.next();
        }
        User u = null;
        if(type.contains("Teacher")){
            Teacher t= new Teacher(values[0],values[1],values[2],values[3]);
            if(s.hasNext()){
                Boolean b = s.nextBoolean();
                t.setTrained(b);
            }
            if(s.hasNext()){
                t.setClassName(s.next());
            }
            if(s.hasNext()){
                t.setRequestName(s.next());
            }
            u = t;
        }else if(type.contains("PTTDirector")){
            u = new PTTDirector(values[0],values[1],values[2],values[3]);
        }else if(type.contains("ClassDirector")){
            u = new ClassDirector(values[0],values[1],values[2],values[3]);
        }else if(type.contains("Administrator")){
            u = new Administrator(values[0],values[1],values[2],values[3]);
        }
        if(s.hasNextLine()){
            s.nextLine();
        }
        return u;
    }

    public ListOfClasses readClasses(ListOfClasses listOfClasses){
        String classFile = this.fileDir + "classfile.txt";
        this.initReader(classFile);
        Scanner s = new Scanner(reader);
        //s.nextLine();
        while(s.hasNextLine()){
            listOfClasses.add(this.readClass(s));
        }
        this.close();
        return listOfClasses;
    }

    public Class readClass(Scanner s){
        String className = s.next();
        String classID = s.next();
        String classSemester =s.next();
        Class cl = new Class(className, classID, classSemester);
        if(s.hasNextLine()){
            s.nextLine();
        }
        return cl;
    }

    public ListOfRequests readRequests(ListOfRequests listOfRequests){
        String requestFile = this.fileDir + "requestfile.txt";
        this.initReader(requestFile);
        Scanner s = new Scanner(reader);
        //s.nextLine();
        while(s.hasNextLine()){
            listOfRequests.add(this.readRequest(s));
        }
        this.close();
        return listOfRequests;
    }

    public Request readRequest(Scanner s){
        String[] str = new String[5];
        for (int i=0 ;i<5;i++) {
            str[i] = s.next();
        }
        Class cl = new Class(str[2], str[3], str[4]);
        Request req = new Request(str[0], str[1], cl);
        if(s.hasNext()) {
            int status = s.nextInt();
            req.setStatus(status);
        }
        if(s.hasNext()){
            Boolean al = s.nextBoolean();
            req.setAllocated(al);
        }
        if(s.hasNextLine()){
            s.nextLine();
        }
        return req;
    }

    public void writeUsers(ListOfUsers listOfUsers){
        String targetFile = this.fileDir + "userfile.txt";
        String str ="";
        String type ="";
        for (User u:listOfUsers.getUsers()) {
            if (u instanceof Teacher){
                type = "Teacher";
            }else if(u instanceof Administrator){
                type = "Administrator";
            }else if(u instanceof PTTDirector){
                type = "PTTDirector";
            }else if(u instanceof ClassDirector){
                type = "ClassDirector";
            }
            str += type + " " + u.listString();
        }
        try {
            FileWriter fileWriter = new FileWriter(targetFile);
            fileWriter.write(str);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeClasses(ListOfClasses listOfClasses){
        String targetFile = this.fileDir + "classfile.txt";
        String str = "";
        for (Class cl:listOfClasses.getClasses()) {
            str += cl;
        }
        try {
            FileWriter fileWriter = new FileWriter(targetFile);
            fileWriter.write(str);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeRequests(ListOfRequests listOfRequests){
        String targetFile = this.fileDir + "requestfile.txt";
        String str = "";
        for(Request req:listOfRequests.getRequests()){
            str += req;
        }
        try {
            FileWriter fileWriter = new FileWriter(targetFile);
            fileWriter.write(str);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            reader.close();
        }catch( IOException e){
            e.printStackTrace();
        }

    }
}
