/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securite_informatique;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Glody KHALIFA DAWILI
 */
public class Securite_informatique {

    /**
     * @param args the command line arguments
     */
    public static int[] generKey(int[] mot, int[] permutation) {
        int index = 0;
        int[] tempo = new int[mot.length];
        for (int i = 0; i < permutation.length; i++) {
            index = permutation[i];
            tempo[i] = mot[index];

        }
        mot = tempo;
        return mot;
    }

     //
    //Etape 3: Division de la clé K en deux blocs de 4 bits : K = k′1||k2
    //
    public static List<int[]> DivKey_K(int[] permutation) {
        List<int[]> list = new ArrayList<>();
        int taille = permutation.length;
        int K1prim = permutation.length / 2;
        int K2prim = taille - K1prim;
        int[] K1 = new int[K1prim];
        int[] K2 = new int[K2prim];

        for (int i = 0; i < K1prim; i++) {

            K1[i] = permutation[i];
        }

        for (int i = K1prim; i < taille; i++) {

            K2[i - K1prim] = permutation[i];

        }
        list.add(K1);
        list.add(K2);
        return list;
    }
        //
    //Etape4: calcule de k1
    //4.a. calculons d'abord le OU logique

    public static int[] OU(int[] A, int[] B) {
        int[] Tempo = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Tempo[i] = (A[i] == 1 || B[i] == 1) ? 1 : 0;
        }
        return Tempo;
    }
    //
    //4.b.calculons le ET logique
    //

    public static int[] ET(int[] A, int[] B) {
        int[] Tempo = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Tempo[i] = (A[i] == 1 && B[i] == 1) ? 1 : 0;
        }
        return Tempo;
    }
        //
    //calculons maintenant le OU exclusive, => c'est avec notre OU se trouvant dans le tempon
    //

    public static int[] OUex(int[] A, int[] B) {
        int[] Tempo = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Tempo[i] = (A[i] == B[i]) ? 0 : 1;
        }
        return Tempo;
    }
        //

    public static void main(String[] args) {
        //
        System.out.println("=================================================");
        System.out.println("======= ALGORITHME DE GENERATION DES CLES =======");
        System.out.println("=================================================");
        //
        // lire les élèment de la clé K
        //
        //
        Scanner KGBA = new Scanner(System.in);
        int index = 0;
        int a = 0;
        int b = 0;
        //
        ///
        //
        int tabkey[] = new int[8];
        Scanner KGBAA = new Scanner(System.in);
        for (int i = 0; i < tabkey.length; i++) {
            System.out.print("saisissez le bit de position " + i + ":");
            tabkey[i] = KGBAA.nextInt();
        }
        //

        //Affichage des données de la clé K 
        //
        System.out.print("K = ");
        for (int i = 0; i < tabkey.length; i++) {
            System.out.print("|" + tabkey[i] + "|");
        }
        //Lecture des élèments des élèments de la fonction de permutation   
        int tabfonction[] = new int[8];
        Scanner KGB = new Scanner(System.in);
        System.out.println("");
        for (int j = 0; j < tabfonction.length; j++) {
            System.out.print("saisissez la valeur de la fonction position " + j + ":");
            tabfonction[j] = KGB.nextInt();
        }
        //

        //Affichage de données de la fonction de permutation 
        //
        System.out.print("Fonction de permutation = ");
        for (int j = 0; j < tabfonction.length; j++) {
            System.out.print("|" + tabfonction[j] + "|");
        }
        //

        //Application de la fonction de permutation  
        //
        int[] tempo;
        System.out.println("");
        tabkey = generKey(tabkey, tabfonction);
        System.out.println("");
        //

        //division de K en deux block=s
        int taille = tabkey.length;
        int longeurK1 = tabkey.length / 2;
        int longeurK2 = taille - longeurK1;
        int[] K1 = new int[longeurK1];
        int[] K2 = new int[longeurK2];
        //
//        K1 = DivKey_K(tabkey).get(0);
//        K2 = DivKey_K(tabkey).get(1);

        //Affectation K2
        System.out.print("k2 = " + "|" + tabkey[4] + "||" + tabkey[1] + "||" + tabkey[3] + "||" + tabkey[0] + "|");
        System.out.println("");
        System.out.print("k'1 = ");
        if (tabkey[6] == tabkey[4]) {
            System.out.print(0 + "||");
        } else {
            System.out.print(1 + "||");
        }
        if (tabkey[5] == tabkey[1]) {
            System.out.print(0 + "||");
        } else {
            System.out.print(1 + "||");
        }
        if (tabkey[2] == tabkey[3]) {
            System.out.print(0 + "||");
        } else {
            System.out.print(1 + "||");
        }
        if (tabkey[7] == tabkey[0]) {
            System.out.print(0 + "||");
        } else {
            System.out.print(1 + "||");
            System.out.println("");
        }
        System.out.print("k'2 = ");
        if (tabkey[6] == tabkey[4]) {
            System.out.print(1 + "||");
        } else if (tabkey[6] == 0 && tabkey[4] == 0) {
            System.out.print(0 + "||");
        } else {
            System.out.print(0 + "||");
        }
        if (tabkey[5] == tabkey[1]) {
            System.out.print(1 + "||");
        } else if (tabkey[5] == 0 && tabkey[1] == 0) {
            System.out.print(0 + "||");
        } else {
            System.out.print(0 + "||");
        }
        if (tabkey[2] == tabkey[3]) {
            System.out.print(1 + "||");
        } else if (tabkey[2] == 0 && tabkey[3] == 0) {
            System.out.print(0 + "||");
        } else {
            System.out.print(0 + "||");
        }
        if (tabkey[7] == tabkey[0]) {
            System.out.print(1 + "||");
        } else if (tabkey[7] == 0 && tabkey[0] == 0) {
            System.out.print(0 + "||");
        } else {
            System.out.print(0 + "||");
            System.out.println("");
        }

        //Application de decalage à gauche pour k1
        //
        System.out.println("k1 = G2(k1) = " + "|" + tabkey[2] + "||" + tabkey[7] + "||" + tabkey[6] + "||" + tabkey[5] + "|");
        //

        //Application de decalage à droite pour k2
        //
        System.out.println("k2 = D1(k2) = " + "|" + tabkey[0] + "||" + tabkey[4] + "||" + tabkey[1] + "||" + tabkey[3] + "|");
        //

        //
        System.out.println("");
        //
        System.out.println("=================================================");
        System.out.println("=========== ALGORITHME DE CHIFFREMENT ===========");
        System.out.println("=================================================");
        //
        // lire les élèments de bloc N de 8 bits
        ////////////////////////////////////
        ////////////////////////////////////
        ///////////////////////////////////
        ///////////////////////////////////
        System.out.println("la Clé avec la fonction H appliquée est : " + Arrays.toString(tabkey));
        System.out.println("la Première clé générée est : " + Arrays.toString(K1));
        System.out.println("la Deuxième clé générée est : " + Arrays.toString(K2));

        //Application des  opérations logiques sur les deux portion de la clé
        int[] K11 = new int[K1.length];
        int[] K12 = new int[K1.length];

        K11 = OUex(K1, K2);
        K12 = ET(K1, K2);

        //Application du decalage 
        tempo = new int[K11.length];
        for (int i = 2; i < K12.length; i++) {
            tempo[i - 2] = K11[i];
        }
        tempo[K12.length - 1] = K11[1];
        tempo[K11.length - 2] = K11[0];
        K11 = tempo;
        tempo = new int[K11.length];
        System.out.println("Première clé générée K1 : " + Arrays.toString(K11));

        a = K12[K12.length - 1];

        tempo[0] = a;
        System.out.println("la gauche de K1: " + Arrays.toString(K11));
        for (int i = 0; i < K12.length - 1; i++) {
            tempo[i + 1] = K12[i];
        }
        K12 = tempo;

        System.out.println("la Deuxième clé générée K2 : " + Arrays.toString(K12));

       //Cryptage du mot
        //initialisation valeurs
        int[] mot = {0, 1, 1, 0, 1, 1, 1, 0};
        int[] pi = {4, 6, 0, 2, 7, 3, 1, 5};

        //application de la fonction de permutation et Round 1
        mot = generKey(mot, pi);
        System.out.println("Mot : " + Arrays.toString(mot));
        int[] Go, G1; //G0 est le premier G0, G1
        int[] Do, D1;
        int[] p = {2, 0, 1, 3};

        Go = DivKey_K(mot).get(0);
        Do = DivKey_K(mot).get(1);

        System.out.println("Mot de gauche Go: " + Arrays.toString(Go));
        System.out.println("Mot de droite Do: " + Arrays.toString(Do));

        D1 = OUex(generKey(Go, p), K11);
        G1 = OUex(Do, OU(Go, K11));

        System.out.println("Mot de gauche G1: " + Arrays.toString(G1));
        System.out.println("Mot de droite D1: " + Arrays.toString(D1));

        //Application d ela permutaion et Round 2
        int[] D2, G2;

        D2 = OUex((generKey(G1, p)), K12);
        G2 = OUex(D1, OU(G1, K12));
        System.out.println("Mot de gauche G2: " + Arrays.toString(G2));
        System.out.println("Mot de droite D2: " + Arrays.toString(D2));

        //Concatenation de G2 et D2
        int[] C = new int[D2.length + G2.length];

        System.arraycopy(G2, 0, C, 0, G2.length);
        System.arraycopy(D2, 0, C, G2.length, D2.length);

        System.out.println("C = " + Arrays.toString(C));
        tempo = new int[pi.length];
        for (int i = 0; i < pi.length; i++) {
            int j = 0;
            boolean bl = false;
            do {
                if (pi[j] == i) {
                    bl = true;
                } else {
                    j++;
                }
            } while (!bl);
            tempo[i] = j;
        }
        int[] pi1 = tempo;

        int[] inversePi = new int[pi.length];

        System.out.println("pi1 = " + Arrays.toString(pi1));

        C = generKey(C, pi1);
        System.out.println("Le Mot Crypter est: " + Arrays.toString(C));

    }

}
