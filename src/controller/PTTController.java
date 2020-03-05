package controller;


import model.*;
import model.identities.*;
import model.procedures.*;
import model.procedures.Class;
import view.PTTView;

import java.util.Scanner;

public class PTTController {
    private PTTView view;
    private PTTModel model;
    private Scanner scanner;
    private DAO dao;

    public PTTController(){
        this.model = new PTTModel();
        this.view = new PTTView(model);
        dao = new DAO();
    }

    public void initData(){
/*
        Class c1 = new Class("Math","Math109-19201","19-20-1");
        Class c2 = new Class("Math","Math109-19202","19-20-2");
        Class c = new Class("Physics","PHS322-19201","19-20-1");
        Administrator a = new Administrator("Runqi", "Wang","wrq", "123456");
        PTTDirector a1 = new PTTDirector("Xubin","Qiu","qxb","654321");
        ClassDirector a2 = new ClassDirector("YU","Wang","YW","456789");
        Teacher a3 = new Teacher("Weicheng","Xu", "WCX","987654");

        Request r = new Request("TA","fniqbjhbfewufbwueqbfuwqbfiuw", c);
        model.getUsers().add(a);
        model.getUsers().add(a1);
        model.getUsers().add(a2);
        model.getUsers().add(a3);
        model.addClass(c);
        model.addClass(c1);
        model.addClass(c2);
        model.addRequest(r);
*/
        dao.readFile(model);
    }

    public void startPTT(){
        scanner = new Scanner(System.in);
        view.enterUsername();
        String username = scanner.nextLine();
        view.enterPassword();
        String password = scanner.nextLine();
        User u = model.logIn(username,password);
        if(u instanceof Administrator){
            this.adminBoard();
        }else if(u instanceof PTTDirector){
            this.pTTDirectorBoard();
        }else if(u instanceof ClassDirector){
            this.classDirectorBoard();
        }else if(u instanceof Teacher){
            this.teacherBoard();
        }else{
            view.failToLoginBoard();
            this.startPTT();
        }
    }

    public void adminBoard(){
        view.adminBoard();
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            view.showApprovedRequest();
            this.adminBoard();
        }else if(choice == 2){
            view.showTeachers();
            this.adminBoard();
        }else if (choice ==3){
            String[] teacher = new String[3];
            for(int i = 0; i < 3; i++){
                view.addTeacher(i);
                teacher[i] = scanner.nextLine();
            }
            if(model.addTeacher(teacher[0],teacher[1],teacher[0]+teacher[1],teacher[2])){
                view.successMessage();
            }else {
                view.errorMessage();
            }
            dao.writeUsers(model.getUsers());
            this.adminBoard();
        }else if (choice ==4){
            int index = this.enterInt();
            if(model.removeTeacher(index)){
                view.successMessage();
            }else{
                view.errorMessage();
            }
            dao.writeUsers(model.getUsers());
            this.adminBoard();
        }else if (choice == 5){
            view.selectTeacher();
            int indexTeacher = scanner.nextInt();
            scanner.nextLine();
            view.selectRequest();
            int indexRequest = scanner.nextInt();
            scanner.nextLine();
            if(model.allocateTeacher(indexTeacher, indexRequest)){
                view.successMessage();
            }else {
                view.errorMessage();
            }
            dao.writeUsers(model.getUsers());
            dao.writeRequests(model.getRequests());
            this.adminBoard();
        }else if (choice ==6){
            int index = this.enterInt();
            if(model.trainTeacher(index)){
                view.successMessage();
            }else{
                view.errorMessage();
            }
            dao.writeUsers(model.getUsers());
            this.adminBoard();
        }else if (choice ==7){
            this.restartPTT();
        }else{
            view.enterInt();
            this.adminBoard();
        }
    }

    public void pTTDirectorBoard(){
        view.pTTDirectorBoard();
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            view.showRequest();
            this.pTTDirectorBoard();
        }else if(choice == 2){
            view.showTeachers();
            this.pTTDirectorBoard();
        }else if (choice ==3){
            int index = this.enterInt();
            if(model.approveRequest(index)){
                view.successMessage();
            }else{
                view.errorMessage();
            }
            dao.writeRequests(model.getRequests());
            this.pTTDirectorBoard();
        }else if (choice ==4){
            int index = this.enterInt();
            if(model.declineRequest(index)){
                view.successMessage();
            }else{
                view.errorMessage();
            }
            dao.writeRequests(model.getRequests());
            this.pTTDirectorBoard();
        }else if (choice ==5){
            this.restartPTT();
        }else{
            view.enterInt();
            this.pTTDirectorBoard();
        }

    }

    public void classDirectorBoard(){
        view.classDirectorBoard();
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1) {
            view.showRequest();
            this.classDirectorBoard();
        }else if(choice == 2){
            view.showClasses();
            this.classDirectorBoard();
        }else if(choice == 3){
            String[] cl = new String[3];
            for(int i = 0; i < 3; i++){
                view.addClass(i);
                cl[i] = scanner.nextLine();
            }
            if(model.addClass(cl[0],cl[1],cl[2])){
                view.successMessage();
            }else {
                view.errorMessage();
            }
            dao.writeClasses(model.getClasses());
            this.classDirectorBoard();
        }else if (choice ==4){
            String[] req = new String[3];
            for(int i = 0; i<3; i++){
                view.addRequest(i);
                req[i] = scanner.nextLine();
            }
            if(model.addRequest(req[0],req[1],req[2])){
                view.successMessage();
            }else{
                view.errorMessage();
            }
            dao.writeRequests(model.getRequests());
            this.classDirectorBoard();
        }else if (choice ==5){
            this.restartPTT();
        }else{
            view.enterInt();
            this.classDirectorBoard();
        }

    }

    public void teacherBoard(){
        view.teacherBoard();
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            view.showTeacherStatus((Teacher)model.getCurrentUser());
            this.teacherBoard();
        }else if(choice == 2){
            this.restartPTT();
        }else{
            view.enterInt();
            this.teacherBoard();
        }

    }

    public void restartPTT(){
        model.logOut();
        view.logOut();
        this.startPTT();
    }

    public int enterInt(){
        view.enterInt();
        int index = scanner.nextInt();
        scanner.nextLine();
        return index;
    }
}
