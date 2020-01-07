package smashranking;
public class SmashRanking {
    public static void main(String[] args) {
        Scene sc=new Scene();
        //sc.addElos("Summer_2018/Melee/Init_ranks.txt");
        sc.addTourney("Summer_2018/Melee/Thursday_Thug_Throwdown_1.txt");
        sc.addTourney("Summer_2018/Melee/Spring_Scuffle_2018.txt");
        sc.addTourney("Summer_2018/Melee/Thursday_Thug_Throwdown_2.txt");
        sc.addTourney("Summer_2018/Melee/Thursday_Thug_Throwdown_3.txt");
        sc.addTourney("Summer_2018/Melee/Watch_the_Chandelier_4.txt");
        sc.addTourney("Summer_2018/Melee/Thursday_Thug_Throwdown_4.txt");
        sc.addTourney("Summer_2018/Melee/Thursday_Thug_Throwdown_6.txt");
        sc.addTourney("Summer_2018/Melee/Montana_Melee_VIII.txt");
        sc.addTourney("Summer_2018/Melee/Thursday_Thug_Throwdown_8.txt");
       sc.print();
     //   sc.prMatchups();
      sc.printMatchups("Pocodudeface");
      sc.printMatchups("MistySkies");
     
              
        
      Fall2017();
       
    }
    
    public static void Fall2017(){
        Scene sc=new Scene();
        sc.addElos("Fall_2017/Init_ranks.txt");
        sc.addTourney("Fall_2017/Impromptu.txt");
        sc.addTourney("Fall_2017/Salty_Ones_7.txt");
        sc.addTourney("Fall_2017/Scrub_RR.txt");
        sc.addGame("Nadamoor","SaLaD",1,3);// Crew qualifier
        sc.addTourney("Fall_2017/Smash_and_Dash_1.txt");
        sc.addTourney("Fall_2017/Smash_and_Dash_2.txt");
        sc.addGame("Xarrite","Boat",2,0);// Fall Brawl
        sc.addTourney("Fall_2017/Smash_and_Dash_3.txt");
        sc.addTourney("Fall_2017/Mountain_Madness.txt");
        sc.addTourney("Fall_2017/Smash_and_Dash_4.txt");
        sc.addTourney("Fall_2017/Impromptu_2.txt");
        sc.addTourney("Fall_2017/Smash_and_Dash_5.txt");
        sc.addTourney("Fall_2017/Smash_and_Dash_6.txt");
        sc.print();
        sc.prMatchups();
   
    }
    
    public static void Spring2018(){
        Scene sc=new Scene();
        sc.addElos("Spring_2018/Melee/Init_ranks.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_7.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_8.txt");
        sc.addTourney("Spring_2018/Melee/Impromptu_3.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_9.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_10.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_11.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_12.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_13.txt");
        sc.addTourney("Spring_2018/Melee/Smash_for_the_Station_II.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_14.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_15.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_16.txt");
        sc.addTourney("Spring_2018/Melee/Arcadian.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_17.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_18.txt");
        sc.addTourney("Spring_2018/Melee/theB100bash.txt");
        sc.addTourney("Spring_2018/Melee/Mountain_Madness_2.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_19.txt");
        sc.addTourney("Spring_2018/Melee/theB100bash2.txt");
        sc.addTourney("Spring_2018/Melee/Watch_the_Chandelier_3.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_20.txt");
        sc.addTourney("Spring_2018/Melee/Mountain_Madness_3.txt");
        sc.addTourney("Spring_2018/Melee/Smash_and_Dash_21.txt");
        sc.print();
       sc.prMatchups();
     //sc.printMatchups("Davidr906");
    }
    
    public static void RivalsSpring2018(){
        Scene sc = new Scene();
        sc.addTourney("Spring_2018/Rivals/The_Forgotten_Ones.txt");
        sc.addTourney("Spring_2018/Rivals/Mountain_Madness_2.txt");
        sc.addTourney("Spring_2018/Rivals/Mountain_Madness_3.txt");
        sc.addTourney("Spring_2018/Rivals/Smash_and_Dash_21.txt");
        sc.print();
        sc.prMatchups();
    }
}
