
package smashranking;
public class Player
{
    private int elo;
    private String tag;
    private Matchup[] matchups;
    private int setsPlayed;
    public Player(String newTag){
        elo = 1200;
        tag = newTag;
        matchups=new Matchup[0];
        setsPlayed = 0; 
    }
    public Player(String newTag,int newelo){
        elo = newelo;
        tag = newTag;
        matchups=new Matchup[0];
        setsPlayed = 0; 
    }
    public int getElo(){return elo;}
    public String getTag(){return tag;}
    
    public void changeElo(int newelo){elo = newelo;}

    public int getSetsPlayed() {return setsPlayed;}
    public void incSets() {setsPlayed++;}
    public void changeMatchups(Player opp, int wins, int losses){
        int i=searchMatchups(opp);
        matchups[i].incGameWins(wins);
        matchups[i].incGameLosses(losses);
        if(wins>losses) matchups[i].incSetWins();
        else matchups[i].incSetLosses();
    }
    public int searchMatchups(Player opp){
        int i=0,l=matchups.length;
        for(;i<l;i++) if(opp==matchups[i].getOpp()) return i;
        Matchup[] temp=new Matchup[l+1];
        for(int j=0;j<l;j++) temp[j]=matchups[j];
        temp[l]=new Matchup(opp);
        matchups=temp;
        return l;
    }
    public void printMatchups(){
        for (Matchup m: matchups) {
            for(int i=0;i<matchups.length-1;i++){
                if(matchups[i].getOppElo()<matchups[i+1].getOppElo()){
                    Matchup temp=matchups[i];
                    matchups[i]=matchups[i+1];
                    matchups[i+1]=temp;
                }
            }
        }
        System.out.println(tag+" vs ");
        for(Matchup m:matchups) System.out.println(" "+m);
    }
    public void printMatchup(Player p){
        int i=searchMatchups(p);
        System.out.println(tag+" vs "+matchups[i]);
    }
}
