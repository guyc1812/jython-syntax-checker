import java.io.FileNotFoundException;
import java.io.FileReader;

import org.python.antlr.ParseException;
import org.python.core.CompilerFlags;
import org.python.core.ParserFacade;
import org.python.core.PyException;
import org.python.core.PyObject;



public class App {
	public static void main(String[] args) {
		try {
			ParserFacade.parseExpressionOrModule(new FileReader("correct.py"),"correct.py",new CompilerFlags().combine(CompilerFlags.PyCF_ONLY_AST));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		} catch (PyException e){
			e.getMessage();
		}

		try {
			ParserFacade.parseExpressionOrModule(new FileReader("incorrect.py"),"incorrect.py",new CompilerFlags().combine(CompilerFlags.PyCF_ONLY_AST));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		} catch (PyException e){
			//e.normalize();
			PyObject v = e.value;
			String message = v.__getitem__(0).toString();
			String line = v.__getitem__(1).__getitem__(1).toString();
			System.err.println("At line " + line + ": " + message);
		}
		catch (ParseException e){
			System.err.println(e.getClass());
		}
	}
}
