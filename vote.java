import java.util.*;

public class vote{

    private int votes;
    private String name;
    private HashMap<String, candidate> candidates = new HashMap<>();
    private SortedMap<Integer, List<String>> value= new TreeMap<Integer, List<String>>();

    public vote(){
        name=null;
    }

    public vote(String n){
        name=n;
    }

    public void addCandidate(String n, candidate c){
        candidates.put(n, c);
    }

    public int candidateNum(){
        return candidates.size();
    }

    public String[] getCandidateNames(){
        String[] candidateKeys = new String[candidateNum()];
        int arrayElement=0;
        for(String x: candidates.keySet()){
            candidateKeys[arrayElement]=x;
            arrayElement++;
        }
        return candidateKeys;
    }
    
    public void setVotes(int votes) {
        this.votes = votes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }
}