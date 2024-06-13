public class candidate{

    private String fullName;

    public candidate(){
        fullName="John Doe";
    }

    public candidate(String fn){
        fullName=fn;
    }
    
    public String toString(){
        return fullName;
    }
    
}