package tests.pCCTest;

import static org.junit.Assert.*;

import graphes.exceptions.ArcNégatifEx;
import graphes.exceptions.NoPathEx;
import org.junit.Test;

import graphes.GrapheLA;
import graphes.GrapheMA;

import pCC.IGraphe;
import pCC.PCCBellman;
import pCC.PCCDijkstra;

public class PCCTest {

    @Test
    public void test() {
        IGraphe g = new GrapheMA(9);  // test de l'exercice 3.1
        tester3_1(g);
        g = new GrapheLA(9);
        tester3_1(g);

        g = new GrapheMA(10);  // test de l'exercice 3.2
        tester3_2(g);
        g = new GrapheLA(10);
        tester3_2(g);

        g = new GrapheMA(7);  // test de l'exercice 3.6
        tester3_6(g);
        g = new GrapheLA(7);
        tester3_6(g);
    }

    void tester3_1(IGraphe g) {
        assertEquals(9, g.getNbSommets());

        g.ajouterArc(1,3,2);
        g.ajouterArc(1,4,1);
        g.ajouterArc(2,7,3);
        g.ajouterArc(3,8,2);
        g.ajouterArc(4,2,3);
        g.ajouterArc(4,3,5);
        g.ajouterArc(4,5,3);
        g.ajouterArc(5,3,1);
        g.ajouterArc(5,7,3);
        g.ajouterArc(5,8,7);
        g.ajouterArc(7,2,2);
        g.ajouterArc(7,6,1);
        g.ajouterArc(8,6,4);
        g.ajouterArc(8,7,2);
        g.ajouterArc(9,8,10);

        // test de l'algo de dijkstra
        // chemins
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 8).getChemin(), new int[]{1, 3, 8});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 7).getChemin(), new int[]{1, 3, 8, 7});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 6).getChemin(), new int[]{1, 3, 8, 7, 6});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 5).getChemin(), new int[]{1, 4, 5});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 4).getChemin(), new int[]{1, 4});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 3).getChemin(), new int[]{1, 3});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 2).getChemin(), new int[]{1, 4, 2});

        // longeur des chemins
        assertEquals(PCCDijkstra.PCC(g, 1, 8).getLongeurChemin(), 4);
        assertEquals(PCCDijkstra.PCC(g, 1, 7).getLongeurChemin(), 6);
        assertEquals(PCCDijkstra.PCC(g, 1, 6).getLongeurChemin(), 7);
        assertEquals(PCCDijkstra.PCC(g, 1, 5).getLongeurChemin(), 4);
        assertEquals(PCCDijkstra.PCC(g, 1, 4).getLongeurChemin(), 1);
        assertEquals(PCCDijkstra.PCC(g, 1, 3).getLongeurChemin(), 2);
        assertEquals(PCCDijkstra.PCC(g, 1, 2).getLongeurChemin(), 4);

        boolean b = false;
        try{
            PCCDijkstra.PCC(g, 1, 9);
        } catch (NoPathEx e){
            b = true;
        }finally {
            assertTrue(b);
        }

        // test de l'algo de bellman
        /*assertArrayEquals(PCCBellman.PCC(g, 1, 8).getChemin(), new int[]{1, 3, 8});
        assertArrayEquals(PCCBellman.PCC(g, 1, 7).getChemin(), new int[]{1, 3, 8, 7});
        assertArrayEquals(PCCBellman.PCC(g, 1, 6).getChemin(), new int[]{1, 3, 8, 7, 6});
        assertArrayEquals(PCCBellman.PCC(g, 1, 5).getChemin(), new int[]{1, 4, 5});
        assertArrayEquals(PCCBellman.PCC(g, 1, 4).getChemin(), new int[]{1, 4});
        assertArrayEquals(PCCBellman.PCC(g, 1, 3).getChemin(), new int[]{1, 3});
        assertArrayEquals(PCCBellman.PCC(g, 1, 2).getChemin(), new int[]{1, 4, 2});

        assertEquals(PCCBellman.PCC(g, 1, 8).getLongeurChemin(), 4);
        assertEquals(PCCBellman.PCC(g, 1, 7).getLongeurChemin(), 6);
        assertEquals(PCCBellman.PCC(g, 1, 6).getLongeurChemin(), 7);
        assertEquals(PCCBellman.PCC(g, 1, 5).getLongeurChemin(), 4);
        assertEquals(PCCBellman.PCC(g, 1, 4).getLongeurChemin(), 1);
        assertEquals(PCCBellman.PCC(g, 1, 3).getLongeurChemin(), 2);
        assertEquals(PCCBellman.PCC(g, 1, 2).getLongeurChemin(), 4);

        b = false;
        try{
            PCCBellman.PCC(g, 1, 9);
        } catch (NoPathEx e){
            b = true;
        }finally {
            assertTrue(b);
        }*/
    }

    void tester3_2(IGraphe g){
        assertEquals(10, g.getNbSommets());

        g.ajouterArc(1,2,8);
        g.ajouterArc(1,4,3);
        g.ajouterArc(2,3,4);
        g.ajouterArc(2,5,5);
        g.ajouterArc(3,6,1);
        g.ajouterArc(3,9,5);
        g.ajouterArc(4,5,2);
        g.ajouterArc(4,10,1);
        g.ajouterArc(5,7,3);
        g.ajouterArc(5,9,2);
        g.ajouterArc(6,8,5);
        g.ajouterArc(7,8,4);
        g.ajouterArc(9,8,2);
        g.ajouterArc(10,6,6);
        g.ajouterArc(10,7,6);



        assertArrayEquals(PCCDijkstra.PCC(g, 1, 8).getChemin(), new int[]{1, 4, 5, 9, 8});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 7).getChemin(), new int[]{1, 4, 5, 7});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 6).getChemin(), new int[]{1, 4, 10, 6});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 5).getChemin(), new int[]{1, 4, 5});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 4).getChemin(), new int[]{1, 4});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 3).getChemin(), new int[]{1, 2, 3});
        assertArrayEquals(PCCDijkstra.PCC(g, 1, 2).getChemin(), new int[]{1, 2});

        assertEquals(PCCDijkstra.PCC(g, 1, 8).getLongeurChemin(), 9);
        assertEquals(PCCDijkstra.PCC(g, 1, 7).getLongeurChemin(), 8);
        assertEquals(PCCDijkstra.PCC(g, 1, 6).getLongeurChemin(), 10);
        assertEquals(PCCDijkstra.PCC(g, 1, 5).getLongeurChemin(), 5);
        assertEquals(PCCDijkstra.PCC(g, 1, 4).getLongeurChemin(), 3);
        assertEquals(PCCDijkstra.PCC(g, 1, 3).getLongeurChemin(), 12);
        assertEquals(PCCDijkstra.PCC(g, 1, 2).getLongeurChemin(), 8);

        assertArrayEquals(PCCBellman.PCC(g, 1, 8).getChemin(), new int[]{1, 4, 5, 9, 8});
        assertArrayEquals(PCCBellman.PCC(g, 1, 7).getChemin(), new int[]{1, 4, 5, 7});
        assertArrayEquals(PCCBellman.PCC(g, 1, 6).getChemin(), new int[]{1, 4, 10, 6});
        assertArrayEquals(PCCBellman.PCC(g, 1, 5).getChemin(), new int[]{1, 4, 5});
        assertArrayEquals(PCCBellman.PCC(g, 1, 4).getChemin(), new int[]{1, 4});
        assertArrayEquals(PCCBellman.PCC(g, 1, 3).getChemin(), new int[]{1, 2, 3});
        assertArrayEquals(PCCBellman.PCC(g, 1, 2).getChemin(), new int[]{1, 2});

        assertEquals(PCCBellman.PCC(g, 1, 8).getLongeurChemin(), 9);
        assertEquals(PCCBellman.PCC(g, 1, 7).getLongeurChemin(), 8);
        assertEquals(PCCBellman.PCC(g, 1, 6).getLongeurChemin(), 10);
        assertEquals(PCCBellman.PCC(g, 1, 5).getLongeurChemin(), 5);
        assertEquals(PCCBellman.PCC(g, 1, 4).getLongeurChemin(), 3);
        assertEquals(PCCBellman.PCC(g, 1, 3).getLongeurChemin(), 12);
        assertEquals(PCCBellman.PCC(g, 1, 2).getLongeurChemin(), 8);
    }

    void tester3_6(IGraphe g){
        assertEquals(7, g.getNbSommets());

        g.ajouterArc(1,1,7);
        g.ajouterArc(1,3,1);
        g.ajouterArc(1,4,4);
        g.ajouterArc(1,5,2);
        g.ajouterArc(1,6,-3);
        g.ajouterArc(3,1,5);
        g.ajouterArc(3,5,2);
        g.ajouterArc(3,6,7);
        g.ajouterArc(4,7,4);
        g.ajouterArc(5,7,10);
        g.ajouterArc(6,4,5);
        g.ajouterArc(6,5,3);

        // nous nous assurons qu'une exception est levée

        boolean b = false;
        try {
            PCCDijkstra.PCC(g, 1, 1);
        }catch (ArcNégatifEx e){
            assertTrue(true);
            b = true;
        }finally {
            assertTrue(b);
        }

    }

}