package com.loksa;



public class Main {

    public static void main(String[] args) {

        LeagueTable<BasketballTeam> basketballLeagueTable = new LeagueTable<>("Basketball League Table");
        LeagueTable<FootballTeam> footballLeagueTable = new LeagueTable<>("Football League Table");

        BasketballTeam meh = new  BasketballTeam("Basketball Meh",28);
        BasketballTeam first = new BasketballTeam("Basketball First",56);
        BasketballTeam second = new BasketballTeam("Basketball Second",44);
        BasketballTeam gold = new BasketballTeam("Basketball Gold",78);
        BasketballTeam whatever = new BasketballTeam("Basketball Whatever",56);
        FootballTeam huh = new FootballTeam("Football Huh", 90);


        basketballLeagueTable.addTeam(meh);
        basketballLeagueTable.addTeam(first);
        basketballLeagueTable.addTeam(gold);
        basketballLeagueTable.addTeam(whatever);
        basketballLeagueTable.addTeam(meh);
        basketballLeagueTable.addTeam(second);
        //basketballLeagueTable.addTeam(huh);

        basketballLeagueTable.print();









    }
}
