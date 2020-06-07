package sraiges;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Snail extends Thread {

    private static final int FINISH = 1000;
    private String name;
    private int distance;
    private Date startTime;
    private Date finishTime;


    public Snail(String name) {
        this.name = name;
        this.distance = 0;
        this.startTime = null;
        this.finishTime = null;
    }

    @Override
     public void run() {
        startTime = new Date();
        System.out.println("SNAIL START!" + startTime);
        int status = 0;
        while (this.distance < FINISH) {
            this.distance += (int) (Math.random() * 10 + 1);
            if (this.distance < FINISH) {
                if (status < this.distance / 100) {
                    System.out.println("Sraige " + this.getName() + " nusliauze " + this.distance);
                    status++;
                }
                try {
                    Thread.sleep((int) (Math.random() * 100 + 1));
                } catch (InterruptedException ex) {
                    // ignored
                }
            }
        }
        this.finishTime = new Date();
        System.out.println("Snail FINISH!" + finishTime);
    }
public long time() {
        if (this.startTime != null && this.finishTime != null) {
            return this.finishTime.getTime() - this.startTime.getTime();
        }
        return Long.MAX_VALUE;
    }
}
