package practice;

public class StringReplace {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("We are happy");
        System.out.println(sb.toString().replaceAll(" ","%20"));
    }
}
