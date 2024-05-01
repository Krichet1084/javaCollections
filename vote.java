public class vote{

    private int votes;
    private String name;
    private HashMap<String, candidate> candidates = new HashMap<String, candidate>;

    public vote(){

    }

    public vote(String n){
        name=n;
    }

    public void addCandidate(String cn, candidate c){
        candidates.put(cn, c)
    }

    public int candidateNum(){
        return candidates.size();
    }

    public String getName(){
        return name;
    }
}