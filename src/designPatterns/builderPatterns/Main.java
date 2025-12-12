package designPatterns.builderPatterns;

public class Main {
    public static void main(String[] args){
        HttpRequest request1 = new HttpRequest.Builder("https://api.example.com/data").build();
        HttpRequest request2 = new HttpRequest.Builder("https://api.example.com/submit")
                .method("POST")
                .body("{\"key\":\"value\"}")
                .timeout(15000)
                .build();
    }
}
