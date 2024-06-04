package practice.mvc.boardgame;

import practice.a_common.MyFileReader;
import practice.mvc.boardgame.controller.BoardGameController2;

import java.util.List;
import java.util.Map;

public class Main {
    public static final String DIRECTORY = "src/main/java/src/main/resources/resources/complextasks/boardgame/";
    private static final String FILE_IN_THROWS = DIRECTORY + "dobasok.txt";
    private static final String FILE_IN_FIELDS = DIRECTORY + "osvenyek.txt";
    private static final String FILE_OUT = DIRECTORY + "specialcharacters.txt";

    public static void main(String[] args) {
        MyFileReader readerThrows = new MyFileReader(FILE_IN_THROWS);
        MyFileReader readerFields = new MyFileReader(FILE_IN_FIELDS);


        List<String> playersThrows = readerThrows.readLines();
        List<String> fields = readerFields.readLines();

        BoardGameController2 game = new BoardGameController2(playersThrows,fields);

        System.out.println("\nTask 2:");
        System.out.println("The number of throws: " + game.getTheNumberOfThrows());
        System.out.println("The number of boards: " + game.getTheNumberOfFields());

        System.out.println("\nTask 3:");
        System.out.println("The index of the longest field: " + (game.getIdOfTheLongestField() + 1 ));
        System.out.println("The length of the longest field: " + game.getTheLongestFieldLength());

        System.out.println("\nTask 5:");
        int gamePlayers = 5;
        int gameBoard = 9;
        System.out.println(game.getStatisticOfTheField(gameBoard));

        System.out.println("\nTask 6:");
        System.out.println(game.getTheSpecialCharacters(gameBoard));

        System.out.println("\nTask 7:");
        System.out.println(game.placeOfTheWinner(gamePlayers,gameBoard));
        System.out.println("The winner the turn: " + game.theWinnerDetails(gamePlayers,gameBoard));

        System.out.println("\nTask 8:");
        Map<Integer,Integer> players = game.playTheGame(gamePlayers,gameBoard);
        System.out.println(players);
        for(Integer p : players.keySet()){
            if(players.get(p) >= game.getTheRequestedBoard(gameBoard).length()){
                System.out.println("Winners: " + p);
            }else{
                System.out.println("Not winners: " + p + " "+ players.get(p));
            }
        }
    }
}
