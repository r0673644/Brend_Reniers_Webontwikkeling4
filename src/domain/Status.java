package domain;

public enum Status {
    ONLINE("online"),OFFLINE("offline"),AWAY("away");
    private String status;
    Status (String status){
        this.status=status;
    }
    Status(){

    }

    public String getStatus(){
        return status;
    }
}
