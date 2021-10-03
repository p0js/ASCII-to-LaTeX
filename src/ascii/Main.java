package ascii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	private static List<String> symbols;
	private static Map<String, String[]> specialSymbols;
	
	/*
	 * Array of ASCIIMath symbols
	 * We're adding \ before the symbol
	 * Example: alpha is changed to \alpha
	 */
	static {
		symbols = new ArrayList<>();
		symbols.add("alpha");
		symbols.add("beta");
		symbols.add("gamma");
		symbols.add("Gamma");
		symbols.add("delta");
		symbols.add("Delta");
		symbols.add("epsilon");
		symbols.add("varepsilon");
		symbols.add("zeta");
		symbols.add("eta");
		symbols.add("theta");
		symbols.add("Theta");
		symbols.add("vartheta");
		symbols.add("iota");
		symbols.add("kappa");
		symbols.add("lambda");
		symbols.add("Lambda");
		symbols.add("mu");
		symbols.add("nu");
		symbols.add("xi");
		symbols.add("Xi");
		symbols.add("pi");
		symbols.add("Pi");
		symbols.add("rho");
		symbols.add("sigma");
		symbols.add("Sigma");
		symbols.add("tau");
		symbols.add("upsilon");
		symbols.add("phi");
		symbols.add("Phi");
		symbols.add("varphi");
		symbols.add("chi");
		symbols.add("psi");
		symbols.add("Psi");
		symbols.add("omega");
		symbols.add("Omega");
		symbols.add("cdot");
		symbols.add("ast");
		symbols.add("star");
		symbols.add("backslash");
		symbols.add("setminus");
		symbols.add("times");
		symbols.add("div");
		symbols.add("ltimes");
		symbols.add("rtimes");
		symbols.add("bowtie");
		symbols.add("circ");
		symbols.add("oplus");
		symbols.add("otimes");
		symbols.add("odot");
		symbols.add("wedge");
		symbols.add("bigwedge");
		symbols.add("vee");
		symbols.add("bigvee");
		symbols.add("cap");
		symbols.add("bigcap");
		symbols.add("cup");
		symbols.add("bigcup");
		symbols.add("frac");
		symbols.add("partial");
		symbols.add("nabla");
		symbols.add("pm");
		symbols.add("emptyset");
		symbols.add("infty");
		symbols.add("therefore");
		symbols.add("because");
		symbols.add("vdots");
		symbols.add("ddots");
		symbols.add("angle");
		symbols.add("frown");
		symbols.add("triangle");
		symbols.add("diamond");
		symbols.add("square");
		symbols.add("lfloor");
		symbols.add("rfloor");
		symbols.add("prec");
		symbols.add("preceq");
		symbols.add("succ");
		symbols.add("succeq");
		symbols.add("in");
		symbols.add("notin");
		symbols.add("subset");
		symbols.add("sup");
		symbols.add("supset");
		symbols.add("subseteq");
		symbols.add("equiv");
		symbols.add("cong");
		symbols.add("approx");
		symbols.add("propto");
		symbols.add("forall");
		symbols.add("exists");
		symbols.add("bot");
		symbols.add("vdash");
		symbols.add("models");
		symbols.add("langle");
		symbols.add("rangle");
		symbols.add("uparrow");
		symbols.add("downarrow");
		symbols.add("rightarrow");
		symbols.add("rightarrowtail");
		symbols.add("twoheadrightarrow");
		symbols.add("mapsto");
		symbols.add("leftarrow");
		symbols.add("leftrightarrow");
		symbols.add("Rightarrow");
		symbols.add("Leftarrow");
		symbols.add("Leftrightarrow");
	}
	/*
	 * first argument is ASCII Math symbol we're looking for
	 * second argument is an array
	 * index 0 represent which side we're checking and replacing 
	 * l - check left side
	 * p - check right side
	 * b - check both sides
	 * index 1 is used when we're checking left side. This string will replace the ASCII Math symbol
	 * index 2 is used when we're checking right side. This string will replace the ASCII Math symbol
	 * index 3 is the closing bracket we're using to end equation
	 */
	static {
		specialSymbols = new LinkedHashMap<String, String[]>();
		specialSymbols.put(")/(", new String[] {"b", "\\frac{", "{", "}"});
		// sqrt
		specialSymbols.put("sqrt(", new String[] {"p", "", "\\sqrt{", "}"});
		specialSymbols.put("sqrt_(", new String[] {"p", "", "\\sqrt[", "]"});
		specialSymbols.put("](", new String[] {"p", "", "]{", "}"});
		// log
		specialSymbols.put("log(", new String[] {"p", "", "\\log{", "}"});
		specialSymbols.put("log_(", new String[] {"p", "", "\\log{", "}a"});
		specialSymbols.put("}a(", new String[] {"p", "", "}{", "}"});
	}

	public static void main(String[] args) {				
		String question = "`omega`";
		String bufor = "";
		
		char[] chars = question.toCharArray();
		ArrayList<Integer> equationsIndexs = new ArrayList<Integer>(); // zmienic na normalny array
		ArrayList<String> equations = new ArrayList<String>();
		
		// searching for equations in question
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '`') {
				equationsIndexs.add(i);
				if (equationsIndexs.size() == 2) {
					equationsIndexs.clear();
					bufor += "$$";
					equations.add(bufor);
					bufor = "";
				}
				else {
					bufor += "$$";
					continue;
				}
			}
			
			if (equationsIndexs.size() == 1) {
				bufor += chars[i];
			}
		}
		
		// changing ASCII Math to LaTeX
		bufor = "";
		String extraKeysBufor = "";
		String symbolASCII = "";
		int endIndex;
		
		for (int i = 0; i < equations.size(); i++) {
			// adding \ before symbols
			for (int k = 0; k < symbols.size(); k++) {
				symbolASCII = symbols.get(k);
				if (equations.get(i).contains(symbolASCII)) {
					bufor = equations.get(i).substring(0, equations.get(i).indexOf(symbolASCII));
					bufor += "\\" + symbolASCII;
					endIndex = equations.get(i).indexOf(symbolASCII) + symbolASCII.length();
					bufor += equations.get(i).substring(endIndex);
					endIndex = bufor.indexOf(symbolASCII) + symbolASCII.length();
					
					while (bufor.substring(endIndex).contains(symbolASCII)) {
						endIndex += bufor.substring(endIndex).indexOf(symbolASCII);
						extraKeysBufor = bufor.substring(0, endIndex);
						extraKeysBufor += "\\" + symbolASCII;
						endIndex = endIndex + symbolASCII.length();
						extraKeysBufor += bufor.substring(endIndex);
						bufor = extraKeysBufor;
					}
					equations.set(i, bufor);
				}
			}
			
			// changing special symbols
			String symbolSide;
			String leftSide = "";
			String rightSide = "";
			bufor = "";
			for (String key : specialSymbols.keySet()) {
				while (equations.get(i).contains(key)) {
					symbolSide = specialSymbols.get(key)[0];
					endIndex = equations.get(i).indexOf(key);
					if (symbolSide.equals("l")) {
						leftSide = checkLeft(equations.get(i), specialSymbols.get(key)[1], specialSymbols.get(key)[3], endIndex);
						equations.set(i, leftSide + equations.get(i).substring(endIndex + key.length()));
					}
					else if (symbolSide.equals("p")) {
						rightSide = checkRight(equations.get(i), specialSymbols.get(key)[2], specialSymbols.get(key)[3], endIndex + key.length());
						equations.set(i, equations.get(i).substring(0, endIndex) + rightSide);
					}
					else {
						leftSide = checkLeft(equations.get(i), specialSymbols.get(key)[1], specialSymbols.get(key)[3], endIndex);
						rightSide = checkRight(equations.get(i), specialSymbols.get(key)[2], specialSymbols.get(key)[3], endIndex + key.length());
						equations.set(i, leftSide + rightSide);
					}
						
				}
			}
		}
		System.out.println(equations.get(0));
	}
	
	private static String checkLeft(String equation, String symbol, String closingBracket, int index) {
		char[] chars = equation.substring(0, index).toCharArray();
		int rightBracket = 0;
		int closingBracketIndex = 0;
		
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == '(' && rightBracket == 0) {
				closingBracketIndex = i;
				break;
			}
			else if (chars[i] == '(')
				rightBracket--;
			else if (chars[i] == ')')
				rightBracket++;
		}
		
		return equation.substring(0, closingBracketIndex) + symbol + equation.substring(closingBracketIndex + 1, index) + closingBracket;
	}
	
	private static String checkRight(String equation, String symbol, String closingBracket, int index) {
		char[] chars = equation.substring(index).toCharArray();
		int rightSideLength = equation.substring(0, index).length();
		int leftBracket = 0;
		int closingBracketIndex = 0;
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ')' && leftBracket == 0) {
				closingBracketIndex = i;
				break;
			}
			else if (chars[i] == ')')
				leftBracket--;
			else if (chars[i] == '(')
				leftBracket++;
		}
		
		return symbol + equation.substring(index, closingBracketIndex + rightSideLength) + closingBracket + equation.substring(closingBracketIndex + 1 + rightSideLength);
	}

}
