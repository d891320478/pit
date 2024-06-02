import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
        	String a = in.nextLine();
        	if(a.startsWith("[")) {
        		int m = Integer.parseInt(a.substring(1, 3))+3;
        		int s = Integer.parseInt(a.substring(4,6))+29;
        		int z = Integer.parseInt(a.substring(7,9))+5;
        		s+=z/100;
        		z%=100;
        		m+=s/60;
        		s%=60;
        		System.out.println("[0"+m+":"+(s>=10?"":"0")+s+"."+(z>=10?"":"0")+z+"]"+a.substring(10));
        	} else {
        		System.out.println(a);
        	}
        }
    }
}