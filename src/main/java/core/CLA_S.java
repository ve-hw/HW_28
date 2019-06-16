package core;
public class CLA_S {
public static void main (String[] args) {
	if (args.length == 0) {System.err.println("No Argument!"); System.exit(0);}
	System.out.println("Hello " + args[0]);
}
}