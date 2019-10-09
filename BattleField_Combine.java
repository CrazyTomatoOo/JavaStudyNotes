package BattleField;

import java.io.*;

public class Combine {
    public void combine() {
        try {
            String FileOut = "D:\\output.txt";
            BufferedWriter bw = null;

            bw = new BufferedWriter(new FileWriter(FileOut));
            String FileName = "D:\\output1.txt";
            File file = new File(FileName);
            if (file.exists()) {
                System.out.println(FileName);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                }
                br.close();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

