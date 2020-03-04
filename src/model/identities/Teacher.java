package model.identities;

import model.procedures.Request;

public class Teacher extends User{

    private boolean isTrained = false;
    private String trained = "untrained";
    private String requestName;
    private String className;

    public Teacher(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void train() {
        this.isTrained = true;
        trained = "trained";
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return  this.getFirstName() + "\t" +
                this.getLastName() + "\t" +
                this.getUserName() + "\t" +
                trained + "\t" +
                className + "\t" +
                requestName + "\n";
    }
}
