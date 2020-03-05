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

    public void setTrained(boolean t) {
        isTrained = t;
        if(t) {
            this.trained = "trained.";
        }else {
            this.trained = "untrained";
        }
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

    public String listString() {
        return  this.getFirstName() + " " +
                this.getLastName() + " " +
                this.getUserName() + " " +
                this.isTrained + " " +
                className + " " +
                requestName + "\n";
    }

    @Override
    public String toString() {
        return  this.getFirstName() + " " +
                this.getLastName() + " " +
                this.getUserName() + " " +
                trained + " " +
                className + " " +
                requestName + "\n";
    }
}
