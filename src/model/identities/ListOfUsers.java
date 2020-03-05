package model.identities;

import java.util.LinkedList;

/**
 *  List of Users
 *  have method to extract sublist from it, typically for teacher list
 *  @author RunQi Wang 2471061
 */

public class ListOfUsers {
    private LinkedList<User> users;

    public ListOfUsers() {
        users = new LinkedList<>();
    }

    public boolean add(User user) {
        if(this.getUser(user.getUserName(),user.getPassword()) == null){
            users.add(user);
            return true;
        }
        return false;
    }

    public void remove(User user){
        users.remove(user);
    }

    public ListOfUsers getTeachers(){
        ListOfUsers teachers = new ListOfUsers();
        for (User u: this.users) {
            if(u instanceof Teacher){
                teachers.add(u);
            }
        }
        return teachers;
    }

    public int indexOf(User u){
        return users.indexOf(u);
    }

    public User getUser(int index){
        return users.get(index);
    }

    public User getUser(String userName, String password){
        for (User u: users) {
            if(u.getUserName().equals(userName) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
    public boolean contains(User u){
        for (User user: users){
            if (user.getUserName().equals(u.getUserName()) && user.getPassword().equals(u.getPassword())){
                return true;
            }
        }
        return false;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        String str ="";
        for (User u:users) {
          str += this.indexOf(u) + ". " + u;
        }
        return str;
    }
}
