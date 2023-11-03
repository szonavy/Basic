package practice.simpletasks.overriding;

public class Solution {
    public static void main(String[] args) {

        Sports sp = new Sports();
        Soccer sc = new Soccer();

        System.out.println(sp.getName());
        sp.getNumberOfTeamMembers();
        System.out.println(sc.getName());
        sc.getNumberOfTeamMembers();
    }
}
