//
// Generated by JTB 1.3.2
//

package ant.parser.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "Here"
 */
public class Here implements Node {
   public NodeToken nodeToken;

   public Here(NodeToken n0) {
      nodeToken = n0;
   }

   public Here() {
      nodeToken = new NodeToken("Here");
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

