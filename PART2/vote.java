import java.util.*;

public class vote{

    private int votes;
    private String name;
    private HashMap<String, candidate> candidates = new HashMap<>();
    private SortedMap<Integer, List<String>> value= new TreeMap<>();

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
        return candidates.size()+1;
    }

    public void remove(String c){
        candidates.remove(c);
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
    
    public void voteEnded(List<Integer> v, String[] c){
        for(int x=0; x<c.length-1; x++){
            value.computeIfAbsent(v.get(x), k -> new ArrayList<String>()).add(c[x]);
        }
        for (Map.Entry<Integer, List<String>> entry : value.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
    }

    public boolean checkDuplicate(String c){
        return (candidates.get(c)!=null);
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

    public String toString(){
        return "Vote name: "+name;
    }
}