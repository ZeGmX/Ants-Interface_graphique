//
// Generated by JTB 1.3.2
//

package ant.parser.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "Turn"
 * direction -> Direction()
 * eol -> Eol()
 */
public class Turn implements Node {
   public NodeToken nodeToken;
   public Direction direction;
   public Eol eol;

   public Turn(NodeToken n0, Direction n1, Eol n2) {
      nodeToken = n0;
      direction = n1;
      eol = n2;
   }

   public Turn(Direction n0, Eol n1) {
      nodeToken = new NodeToken("Turn");
      direction = n0;
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

