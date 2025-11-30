package parkingLot.entities;

public abstract class Gate {
    private final int id;
    private final String operatorName;

    public Gate(int id, String operatorName) {
        this.id = id;
        this.operatorName = operatorName;
    }
    public int getId(){
        return id;
    }

    public String getOperatorName(){
        return operatorName;
    }
}
