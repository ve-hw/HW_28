package core;

import com.beust.jcommander.*;
import java.math.*;
import java.util.*;

public class CLO_calc {
// Operator
	@Parameter(names = { "-o", "--operator" }, description = "Operator")
	static String operator = null;

	// Operands
	@Parameter(names = { "-l", "--operands" }, variableArity = true, description = "List of Operands")
	static List<Double> operands = new ArrayList<Double>();

	public static void main(String[] args) {
		for (String a : args) {
			if (a.matches("[@#&]")) {
				System.err.println("Invalid characters");
				System.exit(1);
			}
		}
			JCommander.newBuilder().addObject(new CLO_calc()).build().parse(args);

			if (operator == null || !operator.matches("[+-/*/]")) {
				System.err.println("Please specify operator + - * or /");
			}

			else if (operands.size() == 0) {
				System.err.println("List of operands is empty");
			}

			else {
				Double result = operands.get(0);
				for (int i = 1; i < operands.size(); i++) {
					switch (operator) {
					case "+":
						result += operands.get(i);
						break;
					case "-":
						result -= operands.get(i);
						break;
					case "*":
						result *= operands.get(i);
						break;
					case "/":
						result /= operands.get(i);
						break;

					}
				}
				System.out.println(new BigDecimal(result).setScale(2, RoundingMode.HALF_UP));

		}
	}
}