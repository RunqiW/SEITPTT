package model;

import model.identities.*;
import model.procedures.Class;
import model.procedures.ListOfClasses;
import model.procedures.ListOfRequests;
import model.procedures.Request;

import java.util.SplittableRandom;

public class PTTModel {

    private ListOfUsers users;
    private ListOfClasses classes;
    private ListOfRequests requests;
    private User currentUser;

    public PTTModel(){
        users = new ListOfUsers();
        classes = new ListOfClasses();
        requests = new ListOfRequests();
    }

    public User logIn(String username, String password){
        User u = users.getUser(username, password);
        this.currentUser = u;
        return u;
    }

    public void logOut(){
        this.currentUser = null;
    }

    public boolean addClass(String className, String semester, String id){
        Class c = new Class(className, semester, id);
        if (classes.getClass(id) == null){
            classes.add(c);
            return true;
        }else {
            return false;
        }
    }

    public boolean addClass(Class c){
        if (classes.getClass(c.getClassID()) == null){
            classes.add(c);
            return true;
        }else {
            return false;
        }
    }

    public boolean addRequest(String requestTitle, String requestContent, String classID){
        Class c = classes.getClass(classID);
        Request req = new Request(requestTitle, requestContent, c);
        return requests.add(req);
    }

    public boolean addRequest(Request req){
        return requests.add(req);
    }


    public boolean approveRequest(String classID, String reqTitle){
        Request req = requests.getPendingRequests().getRequest(classID,reqTitle);
        if(req != null){
            req.approve();
            return true;
        }
        return false;
    }

    public boolean declineRequest(String classID, String reqTitle){
        Request req = requests.getPendingRequests().getRequest(classID,reqTitle);
        if(req != null){
            req.decline();
            return true;
        }
        return false;
    }

    public boolean addTeacher(String firstName, String lastName, String username, String password){
        Teacher t = new Teacher(firstName, lastName, username, password);
        return users.add(t);
    }

    public boolean addTeacher(Teacher t){
        return users.add(t);
    }

    public boolean removeTeacher(String username, String password){
        if(users.getUser(username,password) == null){
            return false;
        }
        if(users.getUser(username,password) instanceof Teacher) {
            users.remove(users.getUser(username, password));
            return true;
        }
        return false;
    }


    public boolean trainTeacher(String username, String password){
        Teacher teacher = (Teacher) users.getTeachers().getUser(username, password);
        if(teacher != null) {
            teacher.train();
            return true;
        }
        return false;
    }

    public boolean allocateTeacher(String username, String password, String classID, String requestTitle){
        Teacher t =(Teacher) users.getTeachers().getUser(username, password);
        Request req = requests.getUnallocatedRequests().getRequest(classID,requestTitle);
        Class cl = classes.getClass(classID);
        if (t != null && req != null) {
            req.allocate();
            t.setClassName(cl.getClassName());
            t.setRequestName(req.getRequestTitle());
            return true;
        }
        return false;
    }

    public ListOfUsers getUsers() {
        return users;
    }

    public void setUsers(ListOfUsers users) {
        this.users = users;
    }

    public ListOfClasses getClasses() {
        return classes;
    }

    public void setClasses(ListOfClasses classes) {
        this.classes = classes;
    }

    public ListOfRequests getRequests() {
        return requests;
    }

    public void setRequests(ListOfRequests requests) {
        this.requests = requests;
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
