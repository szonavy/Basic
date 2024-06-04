package practice.mvc.boardgame.controller;

import java.util.*;

public class BoardGameController2 {
    public List<Integer> playerThrows = new ArrayList<>();
    public List<String> fields = new ArrayList<>();

    public BoardGameController2(List<String> pThrows, List<String> board) {
       createTheThrows(pThrows);
       this.fields = board;
    }

    public void createTheThrows(List<String> pThrows){
        String giveTheThrows = pThrows.get(0);
        for(int i = 0; i < giveTheThrows.length(); i++){
            char f = giveTheThrows.charAt(i);
            if(f != ' ') {
                playerThrows.add(Integer.parseInt(String.valueOf(f)));
            }
        }
    }

    public int getTheNumberOfThrows(){
        return playerThrows.size();
    }
    public int getTheNumberOfFields(){
        return fields.size();
    }

    public int getIdOfTheLongestField(){
        int maximum = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 0; i < fields.size(); i++){
            int length = fields.get(i).length();
            if(maximum < length){
                maximum = length;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int getTheLongestFieldLength(){
        return fields.get(getIdOfTheLongestField()).length();
    }
    public String getTheRequestedBoard(int board){
        return fields.get(board -1);
    }
    public Map<Character, Integer> getStatisticOfTheField(int board){
        Map<Character, Integer> statistic = new HashMap<>();
        String f =  getTheRequestedBoard(board -1);

        for(int i = 0; i < f.length(); i++){
            Character c = f.charAt(i);
            statistic.put(c,statistic.get(c) == null ? 1 : statistic.get(c) + 1);
        }
        return statistic;
    }

    public Map<Integer,Character> getTheSpecialCharacters(int board){
        Map<Integer,Character> special = new HashMap<>();
        String f =  getTheRequestedBoard(board -1);

        for(int i = 0; i < f.length(); i++){
            Character spec = f.charAt(i);
            if(spec != 'M'){
                special.put(i,spec);
            }
        }
        return special;
    }

    public Map<Integer,List<Integer>> generateTheGameWithFieldM(int numberOfPlayers) {

        Map<Integer,List<Integer>> game = new HashMap<>();
        for (int i = 0; i < playerThrows.size(); i++) {
            int player = i % numberOfPlayers;
            game.computeIfAbsent(player == 0 ? numberOfPlayers : player, k -> new ArrayList<>()).add(playerThrows.get(i));
            }
        return game;
    }
    public Map<Integer,Integer> placeOfTheWinner(int numberOfPlayers, int board){
        Map<Integer,Integer> lastThrows = new HashMap<>();
        Map<Integer,List<Integer>> game = generateTheGameWithFieldM(numberOfPlayers);
        int b = getTheRequestedBoard(board).length();

        for(Integer p : game.keySet()){
            int amount = 0;
            for(int i = 0; i < game.get(p).size(); i++){
                amount += game.get(p).get(i);
                if(b <= amount){
                    lastThrows.put(p,i + 1);
                    break;
                }
            }
        }
        return lastThrows;
    }
    public Map.Entry<Integer, Integer>theWinnerDetails(int numberOfPlayers, int board){
        Map<Integer,Integer> winner = placeOfTheWinner(numberOfPlayers, board);
        //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return winner.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .get();
    }
    public Map<Integer,Integer> playTheGame(int numberOfPlayers, int board){
        String normal = getTheRequestedBoard(board);
        Map<Integer,List<Integer>> gameThrows = generateTheGameWithFieldM(numberOfPlayers);
        Map<Integer,Integer> position = new HashMap<>();

        //turn sorszama
        int turn = 1;


        for(int j = 1; j <= numberOfPlayers; j++){
            position.put(j,0);
        }
        while(true){
            //jatekosok sorszama
            for(int i = 1; i <= numberOfPlayers; i++ ){
                int roll = gameThrows.get(i).get(turn-1);
                int pos = position.get(i);
                if(pos + roll > normal.length()){
                    position.put(i,pos+roll);
                }else {
                    char recentField = normal.charAt(pos + roll);

                    if (recentField == 'M') {
                        pos += roll;
                        position.put(i, pos);
                    } else if (recentField == 'E') {
                        pos += roll * 2;
                        position.put(i, pos);
                    }
                }
            }

            for(Integer p : position.keySet()){
                if(position.get(p) > normal.length()){
                    return position;
                }
            }
            turn++;
        }

    }

}
