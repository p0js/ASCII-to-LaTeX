package ascii;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AsciiTranslator {
	private static List<String> symbols;
	private static Map<String, String[]> specialSymbols;
	
	public void AsciiTranslator() {
	}
	
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
		symbols.add("supset");
		symbols.add("subseteq");
		symbols.add("supseteq");
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
		symbols.add("int");
		symbols.add("oint");
		symbols.add("aleph");
		symbols.add("ldots");
		symbols.add("cdots");
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
		specialSymbols.put("root(", new String[] {"p", "", "\\sqrt[", "]%%"});
		specialSymbols.put("]%%(", new String[] {"p", "", "]{", "}"});
		// log
		specialSymbols.put("log(", new String[] {"p", "", "\\log{", "}"});
		specialSymbols.put("log_(", new String[] {"p", "", "\\log{", "}%%"});
		specialSymbols.put("}%%(", new String[] {"p", "", "}{", "}"});
		// rest
		specialSymbols.put("hat(", new String[] {"p", "", "\\hat{", "}"});
		specialSymbols.put("bar(", new String[] {"p", "", "\\bar{", "}"});
		specialSymbols.put("overline(", new String[] {"p", "", "\\overline{", "}"});
		specialSymbols.put("ul(", new String[] {"p", "", "\\ul{", "}"});
		specialSymbols.put("underline(", new String[] {"p", "", "\\underline{", "}"});
		specialSymbols.put("vec(", new String[] {"p", "", "\\vec{", "}"});
		specialSymbols.put("tilde(", new String[] {"p", "", "\\tilde{", "}"});
		specialSymbols.put("dot(", new String[] {"p", "", "\\dot{", "}"});
		specialSymbols.put("ddot(", new String[] {"p", "", "\\ddot{", "}"});
		specialSymbols.put("ubrace(", new String[] {"p", "", "\\underbrace{", "}"});
		specialSymbols.put("underbrace(", new String[] {"p", "", "\\underbrace{", "}"});
		specialSymbols.put("obrace(", new String[] {"p", "", "\\overbrace{", "}"});
		specialSymbols.put("overbrace(", new String[] {"p", "", "\\overbrace{", "}"});
		specialSymbols.put("del", new String[] {"p", "", "\\partial", ""});
		specialSymbols.put("grad", new String[] {"p", "", "\\nabla", ""});
		specialSymbols.put("+-", new String[] {"p", "", "\\pm", ""});
		specialSymbols.put("O/", new String[] {"p", "", "\\emptyset", ""});
		specialSymbols.put("oo", new String[] {"p", "", "\\infty", ""});
		specialSymbols.put(":.", new String[] {"p", "", "\\therefore", ""});
		specialSymbols.put(":'", new String[] {"p", "", "\\because", ""});
		specialSymbols.put("/_", new String[] {"p", "", "\\angle", ""});
		specialSymbols.put("/_\\", new String[] {"p", "", "\\triangle", ""});
		specialSymbols.put("lceiling", new String[] {"p", "", "\\lceil", ""});
		specialSymbols.put("rceiling", new String[] {"p", "", "\\rceil", ""});
		specialSymbols.put("|~", new String[] {"p", "", "\\lceil", ""});
		specialSymbols.put("~|", new String[] {"p", "", "\\rceil", ""});
		specialSymbols.put("ne", new String[] {"p", "", "\\neq", ""});
		specialSymbols.put("!=", new String[] {"p", "", "\\neq", ""});
		specialSymbols.put("<=", new String[] {"p", "", "\\leq", ""});
		specialSymbols.put("le", new String[] {"p", "", "\\leq", ""});
		specialSymbols.put(">=", new String[] {"p", "", "\\geq", ""});
		specialSymbols.put("ge", new String[] {"p", "", "\\geq", ""});
		specialSymbols.put("!in", new String[] {"p", "", "\\notin", ""});
		specialSymbols.put("sub", new String[] {"p", "", "\\subset", ""});
		specialSymbols.put("sup", new String[] {"p", "", "\\supset", ""});
		specialSymbols.put("sube", new String[] {"p", "", "\\subseteq", ""});
		specialSymbols.put("supe", new String[] {"p", "", "\\supseteq", ""});
		specialSymbols.put("-=", new String[] {"p", "", "\\", "\\equiv"});
		specialSymbols.put("~=", new String[] {"p", "", "\\cong", ""});
		specialSymbols.put("~~", new String[] {"p", "", "\\approx", ""});
		specialSymbols.put("prop", new String[] {"p", "", "\\propto", ""});
	}
	
	public static String toLatex(String question) {
		ArrayList<String> equations = new ArrayList<String>();
		equations = findEquations(question);
		
		// changing ASCII Math to LaTeX		
		for (int i = 0; i < equations.size(); i++) {
			// adding \ before symbols
			equations.set(i, changeSymbols(equations.get(i)));
			
			// changing special symbols
			equations.set(i, changeSpecialSymbols(equations.get(i), i));
			
			/* changing simple divisions, example: a/b to frac{a}{b}
			 * but not changing more complex divisons like (a+b)/(a-b)
			 */
			equations.set(i, changeDivision(equations.get(i)));
			
		}
		
		// changing old equations with new ones
		question = newQuestion(question, equations);
		
		return question;		
	}
	
	private static ArrayList<String> findEquations(String question) {
		String bufor = "";
		
		char[] chars = question.toCharArray();
		ArrayList<Integer> equationsIndexs = new ArrayList<Integer>();
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
		
		return equations;
	}
	
	private static String newQuestion(String question, ArrayList<String> equations) {
		char[] chars = question.toCharArray();
		boolean equationSide = false;
		int startEqIndex = 0, startQuestionIndex = 0, equationNumber = 0;
		String newQ = "";
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '`' && !equationSide) {
				startEqIndex = i;
				newQ = newQ +  question.substring(startQuestionIndex, startEqIndex);
				equationSide = true;
			}
			else if (chars[i] == '`' && equationSide) {
				newQ = newQ + equations.get(equationNumber);
				startQuestionIndex = i + 1;
				equationSide = false;
			}
		}
		newQ = newQ + question.substring(startQuestionIndex);
		
		return newQ;
	}
	
	private static String changeSymbols(String equation) {
		String bufor = "";
		String extraKeysBufor = "";
		String symbolASCII = "";
		int endIndex;
		
		for (int k = 0; k < symbols.size(); k++) {
			symbolASCII = symbols.get(k);
			if (equation.contains(symbolASCII)) {
				bufor = equation.substring(0, equation.indexOf(symbolASCII));
				bufor += "\\" + symbolASCII;
				endIndex = equation.indexOf(symbolASCII) + symbolASCII.length();
				bufor += equation.substring(endIndex);
				endIndex = bufor.indexOf(symbolASCII) + symbolASCII.length();
				
				while (bufor.substring(endIndex).contains(symbolASCII)) {
					endIndex += bufor.substring(endIndex).indexOf(symbolASCII);
					extraKeysBufor = bufor.substring(0, endIndex);
					extraKeysBufor += "\\" + symbolASCII;
					endIndex = endIndex + symbolASCII.length();
					extraKeysBufor += bufor.substring(endIndex);
					bufor = extraKeysBufor;
				}
				equation = bufor;
			}
		}
		
		return equation;
	}
	
	private static String changeSpecialSymbols(String equation, int i) {
		String symbolSide;
		String leftSide = "";
		String rightSide = "";
		int endIndex;
		
		for (String key : specialSymbols.keySet()) {
			while (equation.contains(key)) {
				symbolSide = specialSymbols.get(key)[0];
				endIndex = equation.indexOf(key);
				if (symbolSide.equals("l")) {
					leftSide = checkLeft(equation, specialSymbols.get(key)[1], specialSymbols.get(key)[3], endIndex);
					equation = leftSide + equation.substring(endIndex + key.length());
				}
				else if (symbolSide.equals("p")) {
					rightSide = checkRight(equation, specialSymbols.get(key)[2], specialSymbols.get(key)[3], endIndex + key.length());
					equation = equation.substring(0, endIndex) + rightSide;
				}
				else {
					leftSide = checkLeft(equation, specialSymbols.get(key)[1], specialSymbols.get(key)[3], endIndex);
					rightSide = checkRight(equation, specialSymbols.get(key)[2], specialSymbols.get(key)[3], endIndex + key.length());
					equation = leftSide + rightSide;
				}
			}
		}
		return equation;
	}
	
	private static String changeDivision(String equation) {
		String changedEquation = "";
		String restOfEquation = equation;
		int divisionIndex = equation.indexOf("/");
		char leftChar, rightChar;
		
		if (!restOfEquation.contains("/"))
			return equation;
		
		while (restOfEquation.contains("/")) {
			leftChar = restOfEquation.charAt(divisionIndex - 1);
			rightChar = restOfEquation.charAt(divisionIndex + 1);
			
			changedEquation += restOfEquation.substring(0, divisionIndex - 1) + "frac{" + leftChar + "}/{" + rightChar + "}";
			restOfEquation = restOfEquation.substring(divisionIndex + 2);
			
			if (restOfEquation.contains("/"))
				divisionIndex = restOfEquation.indexOf("/");
			else
				changedEquation += restOfEquation;
			
		}
		
		return changedEquation;
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
