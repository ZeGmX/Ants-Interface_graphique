//
// Generated by JTB 1.3.2
//

package ant.parser.visitor;
import ant.parser.syntaxtree.*;
import java.util.*;

/**
 * All GJ void visitors must implement this interface.
 */

public interface GJVoidVisitor<A> {

   //
   // GJ void Auto class visitors
   //

   public void visit(NodeList n, A argu);
   public void visit(NodeListOptional n, A argu);
   public void visit(NodeOptional n, A argu);
   public void visit(NodeSequence n, A argu);
   public void visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * nodeOptional -> ( Eol() )?
    * nodeListOptional -> ( Block() )*
    * nodeToken -> <EOF>
    */
   public void visit(Program n, A argu);

   /**
    * ident -> Ident()
    * nodeToken -> ":"
    * eol -> Eol()
    * nodeListOptional -> ( Instr() )*
    */
   public void visit(Block n, A argu);

   /**
    * nodeChoice -> ( Sense() | Mark() | Unmark() | PickUp() | Drop() | Goto() | Turn() | Move() | Flip() )
    */
   public void visit(Instr n, A argu);

   /**
    * nodeToken -> "Sense"
    * sensedir -> Sensedir()
    * ident -> Ident()
    * ident1 -> Ident()
    * cond -> Cond()
    * eol -> Eol()
    */
   public void visit(Sense n, A argu);

   /**
    * nodeToken -> "Mark"
    * litInt -> LitInt()
    * eol -> Eol()
    */
   public void visit(Mark n, A argu);

   /**
    * nodeToken -> "Unmark"
    * litInt -> LitInt()
    * eol -> Eol()
    */
   public void visit(Unmark n, A argu);

   /**
    * nodeToken -> "PickUp"
    * ident -> Ident()
    * eol -> Eol()
    */
   public void visit(PickUp n, A argu);

   /**
    * nodeToken -> "Drop"
    * eol -> Eol()
    */
   public void visit(Drop n, A argu);

   /**
    * nodeToken -> "Turn"
    * direction -> Direction()
    * eol -> Eol()
    */
   public void visit(Turn n, A argu);

   /**
    * nodeToken -> "Move"
    * ident -> Ident()
    * eol -> Eol()
    */
   public void visit(Move n, A argu);

   /**
    * nodeToken -> "Flip"
    * litInt -> LitInt()
    * ident -> Ident()
    * ident1 -> Ident()
    * eol -> Eol()
    */
   public void visit(Flip n, A argu);

   /**
    * nodeToken -> "Goto"
    * ident -> Ident()
    * eol -> Eol()
    */
   public void visit(Goto n, A argu);

   /**
    * nodeChoice -> ( Left() | Right() )
    */
   public void visit(Direction n, A argu);

   /**
    * nodeToken -> "Left"
    */
   public void visit(Left n, A argu);

   /**
    * nodeToken -> "Right"
    */
   public void visit(Right n, A argu);

   /**
    * nodeChoice -> ( Friend() | Foe() | FriendWithFood() | FoeWithFood() | Food() | Rock() | Marker() | FoeMarker() | Home() | FoeHome() )
    */
   public void visit(Cond n, A argu);

   /**
    * nodeToken -> "Friend"
    */
   public void visit(Friend n, A argu);

   /**
    * nodeToken -> "Foe"
    */
   public void visit(Foe n, A argu);

   /**
    * nodeToken -> "FriendWithFood"
    */
   public void visit(FriendWithFood n, A argu);

   /**
    * nodeToken -> "FoeWithFood"
    */
   public void visit(FoeWithFood n, A argu);

   /**
    * nodeToken -> "Food"
    */
   public void visit(Food n, A argu);

   /**
    * nodeToken -> "Rock"
    */
   public void visit(Rock n, A argu);

   /**
    * nodeToken -> "Marker"
    * litInt -> LitInt()
    */
   public void visit(Marker n, A argu);

   /**
    * nodeToken -> "FoeMarker"
    */
   public void visit(FoeMarker n, A argu);

   /**
    * nodeToken -> "Home"
    */
   public void visit(Home n, A argu);

   /**
    * nodeToken -> "FoeHome"
    */
   public void visit(FoeHome n, A argu);

   /**
    * nodeChoice -> ( Here() | Ahead() | LeftAhead() | RightAhead() )
    */
   public void visit(Sensedir n, A argu);

   /**
    * nodeToken -> "Here"
    */
   public void visit(Here n, A argu);

   /**
    * nodeToken -> "Ahead"
    */
   public void visit(Ahead n, A argu);

   /**
    * nodeToken -> "LeftAhead"
    */
   public void visit(LeftAhead n, A argu);

   /**
    * nodeToken -> "RightAhead"
    */
   public void visit(RightAhead n, A argu);

   /**
    * nodeToken -> <PlainIdent>
    */
   public void visit(Ident n, A argu);

   /**
    * nodeChoice -> ( <Digits> | <NegDigits> )
    */
   public void visit(LitInt n, A argu);

   /**
    * nodeList -> ( <Eol> )+
    */
   public void visit(Eol n, A argu);

}

