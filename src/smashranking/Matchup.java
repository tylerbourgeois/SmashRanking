/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smashranking;

/**
 *
 * @author Tommy
 */
public class Matchup {
    private Player opponent;
    private int setWins;
    private int setLosses;
    private int gameWins;
    private int gameLosses;
    public Matchup(Player opp){opponent=opp;}
    public void incSetWins( ) {setWins++;}
    public void incSetLosses( ) {setLosses++;}
    public void incGameWins(int wins) {gameWins+=wins;}
    public void incGameLosses(int losses) {this.gameLosses += losses;}
    public Player getOpp(){return opponent;}
    public int getOppElo(){return opponent.getElo();}
    @Override
    public String toString(){
        return opponent.getTag()+"\n    Sets: "+setWins+" "+setLosses+"\n    Games: "+gameWins+" "+gameLosses;
    }
}
