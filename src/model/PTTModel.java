package model;

import model.identities.*;
import model.procedures.Class;
import model.procedures.ListOfClasses;
import model.procedures.ListOfRequests;
import model.procedures.Request;

/**
 *  Model for the PTT app.
 *  @author RunQi Wang 2471061
 */


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
        return classes.add(c);
    }

    public boolean addClass(Class c){
        if (!classes.contains(c)){
            classes.add(c);
            return true;
        }
        return false;
    }

    public boolean addRequest(String requestTitle, String requestContent, String classID){
        Class c = classes.getClass(classID);
        if(c != null) {
            Request req = new Request(requestTitle, requestContent, c);
            return requests.add(req);
        }
        return false;
    }

    public boolean addRequest(Request req){
        return requests.add(req);
    }


    public boolean approveRequest(int index){
        Request req = requests.getRequest(index);
        if(req != null && requests.getPendingRequests().contains(req)){
            req.approve();
            return true;
        }
        return false;
    }

    public boolean declineRequest(int index){
        Request req = requests.getRequest(index);
        if(req != null && requests.getPendingRequests().contains(req)){
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

    public boolean removeTeacher(int index){
        User u = users.getTeachers().getUser(index);
        if (u != null){
            users.remove(u);
            return true;
        }
        return false;
    }


    public boolean trainTeacher(int index){
        Teacher teacher = (Teacher) users.getTeachers().getUser(index);
        if(teacher != null) {
            teacher.train();
            return true;
        }
        return false;
    }

    public boolean allocateTeacher(int teacherIndex, int requestIndex){
        Teacher t =(Teacher) users.getTeachers().getUser(teacherIndex);
        Request req = requests.getUnallocatedRequests().getRequest(requestIndex);
        if (t != null && req != null) {
            req.allocate();
            t.setClassName(req.getaClass().getClassName());
            t.setRequestName(req.getRequestTitle());
            return true;
        }
        return false;
    }

    // getters & setters
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
