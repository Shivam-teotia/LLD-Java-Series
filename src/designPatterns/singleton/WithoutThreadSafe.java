package designPatterns.singleton;

public class WithoutThreadSafe {
    private static WithoutThreadSafe instance;

    private WithoutThreadSafe(){}

    public static WithoutThreadSafe getInstance(){
        if(instance==null){
            instance= new WithoutThreadSafe();
        }
        return instance;
    }
}
