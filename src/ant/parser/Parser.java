package ant.parser;

import ant.parser.parser.AntParser;
import ant.parser.parser.ParseException;
import ant.syntax.Program;

public class Parser {

	private static AntParser parser;
	
	public static Program run(java.io.InputStream is) throws ParseException {
		if (parser==null) parser=new AntParser(is); else AntParser.ReInit(is);
		ant.parser.syntaxtree.Program n = AntParser.Program();
		Program p = new Program();
		(p.new Parser()).visit(n);
		return p;
	}

}
