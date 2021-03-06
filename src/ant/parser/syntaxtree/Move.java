//
// Generated by JTB 1.3.2
//

package ant.parser.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "Move"
 * ident -> Ident()
 * eol -> Eol()
 */
public class Move implements Node {
   public NodeToken nodeToken;
   public Ident ident;
   public Eol eol;

   public Move(NodeToken n0, Ident n1, Eol n2) {
      nodeToken = n0;
      ident = n1;
      eol = n2;
   }

   public Move(Ident n0, Eol n1) {
      nodeToken = new NodeToken("Move");
      ident = n0;
      eol = n1;
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

