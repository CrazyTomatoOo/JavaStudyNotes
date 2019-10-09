package BattleField;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Out {
        public Out(){
            try {
                PrintStream print=new PrintStream("D:\\output1.txt");
                System.setOut(print);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
