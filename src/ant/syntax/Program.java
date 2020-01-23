package ant.syntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ant.syntax.Block;
import ant.parser.visitor.DepthFirstVisitor;

public class Program {

	// les blocs sont rangés dans un dictionnaire indexé par le label de chaque bloc
	public final Map<String,Block> blocks; 
	// premier bloc du fichier
	public Block entry;
	
	public Program() {
		this.blocks = new HashMap<>();
	}

	public void print() {
		List<Block> l = new ArrayList<>();
		for (String label: this.blocks.keySet()) {
			Block block = this.blocks.get(label);
			l.add(block);
		}
		l.sort((Block b1, Block b2) -> b1.sourceLine - b2.sourceLine);
		for (Block block: l) {
			System.out.println(block.label+":");
			for (Instruction instr: block.instructions)
				System.out.println("  "+instr);
			System.out.println();
		}
	}
	
	public class Parser extends DepthFirstVisitor {
		
		@Override
		public void visit(ant.parser.syntaxtree.Block n) {
			String label = n.ident.nodeToken.toString();
			Block block = new Block(n.nodeToken.beginLine,label);
			blocks.put(label,block);
			block.new Parser().visit(n.nodeListOptional);
			if (entry==null) entry=block;
		}
	}
}
