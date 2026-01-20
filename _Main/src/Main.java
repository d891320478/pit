public class Main {

    public static void main(String[] args) {
        String a = "0_WECHAT:QRCODE-LOGIN:40601768786441079##49532c229983c667ef330b6fb04648e8#https://agent.lianqiai.cn";
        String[] b = a.split("#");
        System.out.println(b.length);
        System.out.println(b[2]);
        System.out.println(b.length);
    }
}