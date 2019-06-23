package core;

import com.beust.jcommander.*;
import java.util.*;

@Parameters(separators = "=")

public class CLO {
	// List
	@Parameter(names = { "-l", "--list" }, variableArity = true, description = "Your List")
	static List<String> list = new ArrayList<String>(); // arity = 5

	// String
	@Parameter(names = { "-n", "--names" }, description = "Your name") // required = true
	static String name = null;

	// Integer
	@Parameter(names = { "-a", "--age" }, description = "Your age") // required = true
	static Integer age = null;

	// Boolean
	@Parameter(names = { "-m", "--married" }, description = "Your marriage status") // required = true
	static Boolean married = false;

	// Help
	@Parameter(names = { "-h", "--help" }, help = true, hidden = true)
	static Boolean help = false;
	
	public static void main(String[] args) {
		JCommander.newBuilder().addObject(new CLO()).build().parse(args);
	// Help
		if (help) {
			JCommander.newBuilder().addObject(new CLO()).build().usage();
			System.exit(0);
		}
			// List
			if (list.size() == 0) {
				System.err.print("List is Empty" + "\n");
			} else {
				for (String l : list) {
					System.out.println("List item = " + l);
				}
			}
			// String, Integer, Boolean

			if (name == null || age == null || married == false) {
				System.err.println("Some of the parameter is empty");
			} else {
				System.out.println(
						"Your name is " + name + ", you are " + age + " years old and you are " + (married ? "Married" : "not married"));
			}
		}
	}