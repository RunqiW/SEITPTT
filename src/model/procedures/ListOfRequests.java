package model.procedures;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfRequests {

    private LinkedList<Request> requests;

    public ListOfRequests(){
        requests = new LinkedList<>();
    }

    public boolean add(Request req){
        if (!this.contains(req)){
            requests.add(req);
            return true;
        }
        return false;
    }

    public void remove(Request req){
        requests.remove(req);
    }

    public Request getRequest(int index){
        return requests.get(index);
    }

    public int indexOf(Request req){
        return requests.indexOf(req);
    }


    public Request getRequest(String classID, String requestTitle){
        for (Request req: requests) {
            if(req.getaClass().getClassID() == classID && req.getRequestTitle().contentEquals(requestTitle)){
                return req;
            }
        }
        return null;
    }

    public boolean contains(Request r){
        for (Request req: requests){
            if (req.getRequestTitle().contentEquals(r.getRequestTitle()) && req.getaClass().getClassID().contentEquals(r.getaClass().getClassID())){
                return true;
            }
        }
        return false;
    }


    public ListOfRequests getApprovedRequests(){
        ListOfRequests approvedRequests = new ListOfRequests();
        for (Request req: this.requests) {
            if(req.isApproved()){
                approvedRequests.add(req);
            }
        }
        return approvedRequests;
    }

    public ListOfRequests getAllocatedRequests(){
        ListOfRequests allocatedRequest = new ListOfRequests();
        for(Request req: this.getApprovedRequests().requests) {
            if(req.isAllocated()){
                allocatedRequest.add(req);
            }
        }
        return allocatedRequest;
    }

    public ListOfRequests getUnallocatedRequests(){
        ListOfRequests unallocatedRequest = new ListOfRequests();
        for(Request req: this.getApprovedRequests().requests) {
            if(!req.isAllocated()){
                unallocatedRequest.add(req);
            }
        }
        return unallocatedRequest;
    }

    public ListOfRequests getPendingRequests(){
        ListOfRequests pendingRequests = new ListOfRequests();
        for (Request req: this.requests) {
            if(req.getStatus() == 2){
                pendingRequests.add(req);
            }
        }
        return pendingRequests;
    }

    @Override
    public String toString() {
        String str = "";
        for (Request req:requests) {
            str += this.indexOf(req) + ". " + req;
        }
        return str;
    }
}
