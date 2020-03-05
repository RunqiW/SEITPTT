package model.procedures;

/**
 *  represent a class
 *  stores name semester and  classID(unique).
 *  @author RunQi Wang 2471061
 */

public class Class {

    private String className;
    private String classID;
    private String semester;

    public Class(String className, String classID, String semester) {
        this.className = className;
        this.classID = classID;
        this.semester = semester;
    }

    // getters & setters
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return  className + " " +
                classID + " " +
                semester + "\n";
    }
}
