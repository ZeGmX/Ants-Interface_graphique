//
// Generated by JTB 1.3.2
//

package ant.parser.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "Sense"
 * sensedir -> Sensedir()
 * ident -> Ident()
 * ident1 -> Ident()
 * cond -> Cond()
 * eol -> Eol()
 */
public class Sense implements Node {
   public NodeToken nodeToken;
   public Sensedir sensedir;
   public Ident ident;
   public Ident ident1;
   public Cond cond;
   public Eol eol;

   public Sense(NodeToken n0, Sensedir n1, Ident n2, Ident n3, Cond n4, Eol n5) {
      nodeToken = n0;
      sensedir = n1;
      ident = n2;
      ident1 = n3;
      cond = n4;
      eol = n5;
   }

   public Sense(Sensedir n0, Ident n1, Ident n2, Cond n3, Eol n4) {
      nodeToken = new NodeToken("Sense");
      sensedir = n0;
      ident = n1;
      ident1 = n2;
      cond = n3;
      eol = n4;
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

