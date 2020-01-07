
package smashranking;
import java.io.*;
public class Scene{
    private Player[] players;
    public Scene(){
        players = new Player[0]; 
        //players=new Player[1];
         //players[0]=new Player("Kombucha");
    }
//    public Scene(String p){
//         players=new Player[1];
//         players[0]=new Player(p);
//    }
//    public Scene(String p,int elo){
//         players=new Player[1];
//         players[0]=new Player(p,elo);
//    }
    public void addPlayer(Player p){
        int leng=players.length;
        Player[] copy=new Player[leng+1];
        for(int i=0;i<leng;i++) copy[i]=players[i];
        copy[leng]=p;
        players=copy;
    }
    public int search(String name){
        for(int i=0;i<players.length;i++){
            if(getTag(i).equals(name)){
                return i;
            }
        }
        addPlayer(new Player(name));
        return (players.length)-1;
    }
    public void addSet(int p1, int p2,int w,int l){
        double e=1/(1+Math.pow(10.,((double)(getElo(p2)-getElo(p1))/400.)));
        double s=0;
        double k1,k2;
        if(players[p1].getSetsPlayed() <= 1)
            k1=33;
        else if(players[p1].getSetsPlayed() <= 3)
            k1=33;
        else
            k1=11;
        if(players[p2].getSetsPlayed() <= 1)
            k2=33;
        else if(players[p2].getSetsPlayed() <= 3)
            k2=33;
        else
            k2=11;
        double c=w-l;
        int m=Math.max(w,l);
        for(int i=0;i<m;i++)
            s+=(m-i)*binom(m-1+i,i)*pw(e,m)*pw(1-e,i)-(i+1)*binom(2*m-2-i,m-1-i)*pw(e,m-1-i)*pw(1-e,m);
        changeElo(p1,(int)(getElo(p1)+k1*(c-s)));
        changeElo(p2,(int)(getElo(p2)-k2*(c-s)));
        players[p1].changeMatchups(players[p2],w,l);
        players[p2].changeMatchups(players[p1],l,w);
        players[p1].incSets();
        players[p2].incSets();
    }
    public void addTourney(String file, boolean disp){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] temp=line.split("\\s");
                int p1=search(temp[0]);
                int p2=search(temp[1]);
                if(disp){
                    int e1=getElo(p1);
                    int e2=getElo(p2);
                    addSet(p1,p2,Integer.parseInt(temp[2]),Integer.parseInt(temp[3]));
                    System.out.println(line);
                    System.out.println(getTag(p1)+": "+e1+"->"+getElo(p1)+" "+getTag(p2)+": "+e2+"->"+getElo(p2)+"\n");
                }
                else
                    addSet(p1,p2,Integer.parseInt(temp[2]),Integer.parseInt(temp[3]));
            }
        }catch(IOException e) {
            System.out.print("Exception");
        }
    }
    public void addTourney(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] temp=line.split("\\s");
                int p1=search(temp[0]);
                int p2=search(temp[1]);
                addSet(p1,p2,Integer.parseInt(temp[2]),Integer.parseInt(temp[3]));
            }
        }catch(IOException e) {
            System.out.print("Exception");
        }
    }
    public void addElos(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] temp=line.split("\\s");
                changeElo(search(temp[0]),Integer.parseInt(temp[1]));
            }
        }catch(IOException e) {
            System.out.print("Exception");
        }
    }
    public void print(){
        for(int i=0; i<getLength();i++){
            for(int j=0; j<getLength()-1;j++){
                if(getElo(j)<getElo(j+1)){
                    Player temp=players[j];
                    players[j]=players[j+1];
                    players[j+1]=temp;
                }
            }
        }
        for(int i=0; i<getLength();i++){
            System.out.println((i+1)+": "+getTag(i)+" "+getElo(i));
        }
        System.out.println();
    }
    private static long binom(int n, int k){
        if (k>n-k)
            k=n-k;
        long b=1;
        for (int i=1, m=n; i<=k; i++, m--)
            b=b*m/i;
        return b;
    }
    private static double pw(double b,int p){
        double out=1;
        for(int i=0;i<p;i++)
            out*=b;
        return out;
    }
    public void printBz(){
        for(int i=0; i<getLength();i++){
            for(int j=0; j<getLength()-1;j++){
                if(getElo(j)<getElo(j+1)){
                    Player temp=players[j];
                    players[j]=players[j+1];
                    players[j+1]=temp;
                }
            }
        }
        for(int i=0; i<getLength();i++){
            if (inBozeman(getTag(i)))
                System.out.println((i+1)+": "+getTag(i)+" "+getElo(i));
        }
        System.out.println();
    }
    public boolean inBozeman(String in){
        String[] bozeman={"Time_Wizard","Dot","Sam_I_Am","Kombucha","Pumpz",
            "Xaritte","Boat","Little_Biggs","$wift","Wyok","Raabionfire","Tosty",
            "L_Ron_Hoyabembe","MistySkies","PocoDudeFace","Devilray","Jello",
            "Big_Tuna","Cheesedork","Putty","Anything","Tempo","Awz","Q","Gallade","Davidr906"};
        for(String p:bozeman) if (p.equals(in)) return true;
        return false;
    }
    public void addGame(String p1, String p2,int w,int l){addSet(search(p1),search(p2),w,l);}
    public Player getPlayer(int n){return players[n];}
    public int getElo(int n){return players[n].getElo();}
    public int getElo(String p){return getElo(search(p));}
    public String getTag(int n){return players[n].getTag();}
    public int getLength(){return players.length;}
    public void changeElo(int n,int newelo){players[n].changeElo(newelo);}
    public void changeElo(String p,int newelo){changeElo(search(p),newelo);}
    public void printMatchups(String p){
        int temp=search(p);
        players[temp].printMatchups();
    }
    public void prMatchups(){
        for(int i=0; i<getLength();i++){
            for(int j=0; j<getLength()-1;j++){
                if(getElo(j)<getElo(j+1)){
                    Player temp=players[j];
                    players[j]=players[j+1];
                    players[j+1]=temp;
                }
            }
        }
        for(int i=0;i<21;i++){
            for(int j=i+1;j<21;j++){
               players[i].printMatchup(players[j]);
            }
        }
    }
}

