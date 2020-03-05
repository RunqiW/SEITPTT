package model.procedures;

public class Request {

    private Class aClass;
    private String requestTitle;
    private String requestContent;
    private int status = 2;
    private String statusMessage = "";
    private boolean allocated = false;
    private String allowcateMessage ="";

//    public Request(String requestTitle, String requestContent,String classID){
//        this.requestTitle = requestTitle;
//        this.requestContent = requestContent;
//        this.aClass =
//    }

    public Request(String requestTitle, String requestContent, Class aClass){
        this.aClass = aClass;
        this.requestTitle = requestTitle;
        this.requestContent = requestContent;
        statusMessage = "Pending";
        allowcateMessage = "unallocated";
    }


    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getRequestTitle() {
        return requestTitle;
    }

    public void setRequestTitle(String requestTitle) {
        this.requestTitle = requestTitle;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public boolean isApproved() {
        boolean approved = false;
        if(status == 0){approved = true;}
        return approved;
    }

    public void approve() {
        status = 0;
        statusMessage = "Approved";
    }

    public void decline() {
        status = 1;
        statusMessage = "Declined";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if(status == 0){
            statusMessage = "Approved";
        }else if(status == 1){
            statusMessage = "Declined";
        }else if(status == 2){
            statusMessage = "Pending";
        }
        this.status = status;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public void allocate(){
        allocated = true;
        allowcateMessage = "allocated";
    }

    public boolean isAllocated(){
        return allocated;
    }

    @Override
    public String toString() {
        return  requestTitle + " " +
                requestContent + " " +
                this.getaClass().getClassName() + " " +
                this.getaClass().getClassID() + " " +
                this.getaClass().getSemester() + " " +
                status + " " +
                allocated + "\n";
    }

    public String listString(){
        return  requestTitle + " " +
                requestContent + " " +
                this.getaClass().getClassName() + " " +
                this.getaClass().getClassID() + " " +
                this.getaClass().getSemester() + " " +
                statusMessage + " " +
                allowcateMessage + "\n";
    }
}
