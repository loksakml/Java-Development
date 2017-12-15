package com.loksa;

import java.util.ArrayList;
import java.util.Collections;


public class LeagueTable<T extends Team>{
    private String name;
    private ArrayList<T> teamList;


    public LeagueTable(String name) {
        this.name = name;
        this.teamList = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public boolean addTeam(T newTeam){
        if(teamList.contains(newTeam)){
            System.out.println(newTeam.getName() + " already exist in the league table.");
            return false;
        } else {
            teamList.add(newTeam);
            return true;
        }
    }


    public void print(){
        Collections.sort(this.teamList);
        for(T team : teamList){
            System.out.println(team.toString());
        }




    }
}
