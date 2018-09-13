import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        T t = new T(2);
        t.print();
    }

}

class T {
    private int i = 1;
    
    {
        System.out.println("-" + i);
        i = 3;
        System.out.println("--" + i);
    }
    
    public T(int i) {
        this.i = i;
    }
    
    public void print() {
        System.out.println(i);
    }
}