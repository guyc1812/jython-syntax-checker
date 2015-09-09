import java.io.FileNotFoundException;
import java.io.FileReader;

import org.python.antlr.ParseException;
import org.python.core.CompilerFlags;
import org.python.core.ParserFacade;
import org.python.core.PyException;



public class App {
	public static void main(String[] args) {
		try {
			ParserFacade.parseExpressionOrModule(new FileReader("correct.py"),"correct.py",new CompilerFlags().combine(CompilerFlags.PyCF_ONLY_AST));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PyException e){
			e.getMessage();
		}

		try {
			ParserFacade.parseExpressionOrModule(new FileReader("incorrect.py"),"incorrect.py",new CompilerFlags().combine(CompilerFlags.PyCF_ONLY_AST));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e){
			System.err.println(e.getMessage());
		}
		catch (Exception e){
			System.err.println(e.getClass());
		}
	}
}
