package practice.codinggame.thor;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int ThorX = in.nextInt(); // Thor's starting X position
        int ThorY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt();// The remaining amount of turns Thor can move. Do not remove this line.

        if(ThorX < lightX && ThorY < lightY){
            ThorX++;
            ThorY++;
            System.out.println("SE");
            }
            
        else if(ThorX > lightX && ThorY > lightY){
            ThorX--;
            ThorY--;
            System.out.println("NW");
            }
            
        else if(ThorX < lightX && ThorY > lightY){
            ThorX++;
            ThorY--;
            System.out.println("NE");
            }
        else if(ThorX > lightX && ThorY < lightY){
            ThorX--;
            ThorY++;
            System.out.println("SW");
            }
        else if(ThorY<lightY){
            ThorY++;
            System.out.println("S");
            }
        else if(ThorY>lightY){
            ThorY--;
            System.out.println("N");
        }
        else if( ThorX > lightX){
            ThorX--;
            System.out.println("W");
        }
        else {
            ThorX++;
            System.out.println("E");
                    }
                }
            }
}