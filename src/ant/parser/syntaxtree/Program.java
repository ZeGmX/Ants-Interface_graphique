//
// Generated by JTB 1.3.2
//

package ant.parser.syntaxtree;

/**
 * Grammar production:
 * nodeOptional -> ( Eol() )?
 * nodeListOptional -> ( Block() )*
 * nodeToken -> <EOF>
 */
public class Program implements Node {
   public NodeOptional nodeOptional;
   public NodeListOptional nodeListOptional;
   public NodeToken nodeToken;

   public Program(NodeOptional n0, NodeListOptional n1, NodeToken n2) {
      nodeOptional = n0;
      nodeListOptional = n1;
      nodeToken = n2;
   }

   public Program(NodeOptional n0, NodeListOptional n1) {
      nodeOptional = n0;
      nodeListOptional = n1;
      nodeToken = new NodeToken("");
   }

   public void accept(ant.parser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(ant.parser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(ant.parser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(ant.parser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

