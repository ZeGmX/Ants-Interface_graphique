package ant.syntax;

import java.util.ArrayList;
import java.util.List;
import ant.parser.visitor.DepthFirstVisitor;

public class Block {
	public int sourceLine;
	public final String label;
	public final List<Instruction> instructions;

	public Block(int sourceLine, String label) {
		this.sourceLine = sourceLine;
		this.label = label;
		this.instructions = new ArrayList<>();
	}

	public class Parser extends DepthFirstVisitor {
		
		public void visit(ant.parser.syntaxtree.Sense n) {			
			instructions.add(
					new Sense(
							n.nodeToken.beginLine,
							new Sensedir.Parser().visit(n.sensedir),
							n.ident.nodeToken.toString(),
							n.ident1.nodeToken.toString(),
							new Cond.Parser().visit(n.cond)));
		}

		public void visit(ant.parser.syntaxtree.Mark n) {
			instructions.add(new Mark(
					n.nodeToken.beginLine,
					convertLitInt(n.litInt)));
		}

		public void visit(ant.parser.syntaxtree.Unmark n) {
			instructions.add(new Unmark(
					n.nodeToken.beginLine,
					convertLitInt(n.litInt)));
		}

		public void visit(ant.parser.syntaxtree.PickUp n) {
			instructions.add(new PickUp(
					n.nodeToken.beginLine,
					n.ident.nodeToken.toString()));
		}

		public void visit(ant.parser.syntaxtree.Drop n) {
			instructions.add(new Drop(n.nodeToken.beginLine));
		}

		public void visit(ant.parser.syntaxtree.Left n) {
			instructions.add(new TurnLeft(n.nodeToken.beginLine));
		}

		public void visit(ant.parser.syntaxtree.Right n) {
			instructions.add(new TurnRight(n.nodeToken.beginLine));
		}

		public void visit(ant.parser.syntaxtree.Move n) {
			instructions.add(new Move(n.nodeToken.beginLine,n.ident.nodeToken.toString()));
		}

		public void visit(ant.parser.syntaxtree.Flip n) {
			instructions.add(new Flip(n.nodeToken.beginLine,convertLitInt(n.litInt),n.ident.nodeToken.toString(),n.ident1.nodeToken.toString()));
		}

		public void visit(ant.parser.syntaxtree.Goto n) {
			instructions.add(new Goto(n.nodeToken.beginLine,n.ident.nodeToken.toString()));
		}
	}
	
	private static int convertLitInt(ant.parser.syntaxtree.LitInt l) {
		return Integer.parseInt(l.nodeChoice.choice.toString());
	}


}
