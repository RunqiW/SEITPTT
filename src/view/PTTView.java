package view;

import model.PTTModel;
import model.identities.Teacher;
import model.identities.User;

public class PTTView {

    private PTTModel model;

    public PTTView(PTTModel model){
        this.model = model;
    }

    public void enterUsername(){
        System.out.println("Please enter your username.");
    }

    public void enterPassword(){
        System.out.println("Please enter your password.");
    }

    public void failToLoginBoard(){
        System.out.println("Log in failed, please try again.");
    }

    public void adminBoard(){
        System.out.println("Please enter the number of your choice");
        System.out.println( " 1.check approved requests.\n" +
                            " 2.check teacher list.\n" +
                            " 3.add new teacher.\n" +
                            " 4.remove teacher from list.\n" +
                            " 5.allocate teacher to request.\n" +
                            " 6.set teacher to trained.\n" +
                            " 7.log out.");
    }

    public void showApprovedRequest(){
        System.out.print(model.getRequests().getApprovedRequests());
    }

    public void showTeachers(){
        System.out.print(model.getUsers().getTeachers());
    }

    public void addTeacher(int i){
        if(i == 0){
            System.out.println("Please enter teacher's first name.");
        }else if (i == 1){
            System.out.println("Please enter teacher's last name.");
        }else if(i == 2){
            System.out.println("Please enter teacher's password.");
        }else{
            System.err.println("Error, wrong input int");
        }
    }

    public void pTTDirectorBoard(){
        System.out.println("Please enter the number of your choice");
        System.out.println( " 1.check requests.\n" +
                            " 2.check teacher list.\n" +
                            " 3.approve requests.\n" +
                            " 4.decline requests.\n" +
                            " 5.log out.");
    }

    public void showRequest(){
        System.out.print(model.getRequests());
    }

    public void classDirectorBoard(){
        System.out.println("Please enter the number of your choice");
        System.out.println( " 1.check requests.\n" +
                            " 2.create new class.\n" +
                            " 3.add request.\n" +
                            " 4.log out.");
    }

    public void addClass(int i){
        if(i == 0){
            System.out.println("Please enter class name.");
        }else if (i == 1){
            System.out.println("Please enter class semester.");
        }else if(i == 2){
            System.out.println("Please enter class ID.");
        }else{
            System.err.println("Error. wrong input int");
        }
    }

    public void addRequest(int i){
        if(i == 0){
            System.out.println("Please enter request title.");
        }else if (i == 1){
            System.out.println("Please enter request content.");
        }else if(i == 2){
            System.out.println("Please enter class ID.");
        }else{
            System.err.println("Error. wrong input int");
        }
    }

    public void teacherBoard(){
        System.out.println("Please enter the number of your choice");
        System.out.println( " 1.show status.\n" +
                            " 2.log out");
    }

    public void showTeacherstatus(Teacher t){
        System.out.println(t);
    }

    public void logOut(){
        System.out.println("Log out successfully.");
    }

    public void enterInt(){
        System.out.println("Please enter the number of your choice, end with enter");
    }

    public void findUser(int i){
        if(i == 0){
            System.out.println("Please enter a username.");
        }else if(i == 1){
            System.out.println("Please enter user's password.");
        }else if(i == 2){
            System.out.println("Done.");
        }else{
            System.err.println("Error.");
        }
    }

    public void findRequest(int i){
        if(i == 0){
            System.out.println("Please enter a classID, which the request belongs to");
        }else if(i == 1){
            System.out.println("Please enter the request title");
        }else if(i == 2){
            System.out.println("Done.");
        }else{
            System.err.println("Error.");
        }
    }

    public void successMessage(){
        System.out.println("Done.");
    }

    public void errorMessage(){
        System.err.println("Error.");
    }
}
