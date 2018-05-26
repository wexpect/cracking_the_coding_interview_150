/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package copyarraytest;

/**
 *
 * @author Rui
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] state = {0, 1, 0, 1};

        int[] state_old1 = state;

        int[] state_old2 = (int[])state.clone();

        int a = state[0];
        int b = state[1];
        int c = state[2];
        int d = state[3];


        
        state[0] = 0;
        state[1] = 0;
        state[2] = 1;
        state[3] = 1;

//        state_old1[0] = 0;
//        state_old1[1] = 0;
//        state_old1[2] = 1;
//        state_old1[3] = 1;

        System.out.println(state[0]+" "+state[1]+" "+state[2]+" "+state[3]);
        System.out.println(state_old1[0]+" "+state_old1[1]+" "+state_old1[2]+" "+state_old1[3]);
        System.out.println(state_old2[0]+" "+state_old2[1]+" "+state_old2[2]+" "+state_old2[3]);
        System.out.println(a+" "+b+" "+c+" "+d);



        int[][] A = {{0,1},{2,3}};
        int[][] B = new int[2][2];
        B[0][0] = A[0][0];
        B[0][1] = A[0][1];
        B[1][0] = A[1][0];
        B[1][1] = A[1][1];

        A[0][0] = 5;
        A[0][1] = 6;

        System.out.println(A[0][0]+" "+A[0][1]);
        System.out.println(B[0][0]+" "+B[0][1]);
    }

}
