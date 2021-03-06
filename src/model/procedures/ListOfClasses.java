package model.procedures;

import java.util.LinkedList;

/**
 *  list of class
 *  @author RunQi Wang 2471061
 */

public class ListOfClasses {

    private LinkedList<Class> classes;

    public ListOfClasses(){
        classes = new LinkedList<>();
    }

    public boolean add(Class aClass){
        if(!this.contains(aClass)){
            classes.add(aClass);
            return true;
        }
        return false;
    }

    public Class getClass(int index){
        return classes.get(index);
    }

    public int indexOf(Class cl){
        return classes.indexOf(cl);
    }

    public Class getClass(String classID){
        for (Class c: this.classes) {
            if (c.getClassID().equals(classID)){
                return c;
            }
        }
        return null;
    }

    public boolean contains(Class c){
        for (Class cl: classes) {
            if(cl.getClassID().contentEquals(c.getClassID())){
                return true;
            }
        }
        return false;
    }

    public LinkedList<Class> getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        String str = "";
        for (Class cl:classes) {
            str += this.indexOf(cl) + ". " + cl;
        }
        return str;
    }
}
