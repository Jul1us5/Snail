package sraiges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Sraiges {

    public static void main(String[] args) {
        Snail[] snails = {
            new Snail("Pirma"),
            new Snail("Antra"),
            new Snail("Tracia"),
            new Snail("Ketvirta"),
            new Snail("Penkta"),
        };
        System.out.println("Race started at " + new Date());
        for (Snail snail : snails) {
            snail.start();
        }
        for (Snail snail : snails) {
            try {
                snail.join();
            } catch (InterruptedException ex) {
                // ignored
            }
        }
        System.out.println("Race finished at " + new Date());
        Arrays.sort(snails, new Comparator<Snail>() {
            @Override
            public int compare(Snail s1, Snail s2) {
                if (s1.time() > s2.time()) {
                    return 1;
                } else if (s1.time() == s2.time()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("Winner is " + snails[0].getName());
    }
}

