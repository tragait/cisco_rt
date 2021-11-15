package com.rt;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final BEventBroker broker = new BEventBroker();
        final LButton button1 = new LButton("1", broker);
        final LButton button2 = new LButton("2", broker);
        final LEDLight ledLight = new LEDLight("LED-1");
        final Set observerSet = new HashSet();
        observerSet.add(ledLight);

        broker.register(button1,observerSet);
        broker.register(button2,observerSet);

        systemInput(button1, button2);
    }

    public static void systemInput(final LButton b1, final LButton b2){
        final Scanner sc= new Scanner(System.in);
        String str;
        do {
            System.out.print("press a button (1 or 2) or to quit (q): ");
            str = sc.nextLine();
            if("1".equals(str))
                b1.buttonPressed();
            else if("2".equals(str))
                b2.buttonPressed();
            else if("q".equals(str))
                System.out.println("exiting");
            else
                System.out.println("wrong button pressed.");
        }while(!"q".equals(str));
    }
}
