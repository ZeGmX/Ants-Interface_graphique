/* Generated By:JavaCC: Do not edit this line. AntParserConstants.java */
package ant.parser.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface AntParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int LineComment = 3;
  /** RegularExpression Id. */
  int Digit = 4;
  /** RegularExpression Id. */
  int Digits = 5;
  /** RegularExpression Id. */
  int NegDigits = 6;
  /** RegularExpression Id. */
  int IdentHead = 7;
  /** RegularExpression Id. */
  int IdentRest = 8;
  /** RegularExpression Id. */
  int Eol = 9;
  /** RegularExpression Id. */
  int LitStrStart = 10;
  /** RegularExpression Id. */
  int LitStr = 11;
  /** RegularExpression Id. */
  int EscapeQuote = 12;
  /** RegularExpression Id. */
  int EscapeBackslash = 13;
  /** RegularExpression Id. */
  int NormalStringContent = 14;
  /** RegularExpression Id. */
  int TWOPOINTS = 15;
  /** RegularExpression Id. */
  int FOE = 16;
  /** RegularExpression Id. */
  int FOOD = 17;
  /** RegularExpression Id. */
  int MOVE = 18;
  /** RegularExpression Id. */
  int HOME = 19;
  /** RegularExpression Id. */
  int HERE = 20;
  /** RegularExpression Id. */
  int MARK = 21;
  /** RegularExpression Id. */
  int ROCK = 22;
  /** RegularExpression Id. */
  int TURN = 23;
  /** RegularExpression Id. */
  int DROP = 24;
  /** RegularExpression Id. */
  int FLIP = 25;
  /** RegularExpression Id. */
  int AHEAD = 26;
  /** RegularExpression Id. */
  int SENSE = 27;
  /** RegularExpression Id. */
  int RIGHT = 28;
  /** RegularExpression Id. */
  int LEFT = 29;
  /** RegularExpression Id. */
  int GOTO = 30;
  /** RegularExpression Id. */
  int FRIEND = 31;
  /** RegularExpression Id. */
  int UNMARK = 32;
  /** RegularExpression Id. */
  int PICKUP = 33;
  /** RegularExpression Id. */
  int MARKER = 34;
  /** RegularExpression Id. */
  int FOEHOME = 35;
  /** RegularExpression Id. */
  int LEFTAHEAD = 36;
  /** RegularExpression Id. */
  int RIGHTAHEAD = 37;
  /** RegularExpression Id. */
  int FOEMARKER = 38;
  /** RegularExpression Id. */
  int FOEWITHFOOD = 39;
  /** RegularExpression Id. */
  int FRIENDWITHFOOD = 40;
  /** RegularExpression Id. */
  int PlainIdent = 41;
  /** RegularExpression Id. */
  int Anything = 42;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int WITHIN_STRING = 1;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "<LineComment>",
    "<Digit>",
    "<Digits>",
    "<NegDigits>",
    "<IdentHead>",
    "<IdentRest>",
    "<Eol>",
    "\"\\\"\"",
    "\"\\\"\"",
    "\"\\\\\\\"\"",
    "\"\\\\\\\\\"",
    "<NormalStringContent>",
    "\":\"",
    "\"Foe\"",
    "\"Food\"",
    "\"Move\"",
    "\"Home\"",
    "\"Here\"",
    "\"Mark\"",
    "\"Rock\"",
    "\"Turn\"",
    "\"Drop\"",
    "\"Flip\"",
    "\"Ahead\"",
    "\"Sense\"",
    "\"Right\"",
    "\"Left\"",
    "\"Goto\"",
    "\"Friend\"",
    "\"Unmark\"",
    "\"PickUp\"",
    "\"Marker\"",
    "\"FoeHome\"",
    "\"LeftAhead\"",
    "\"RightAhead\"",
    "\"FoeMarker\"",
    "\"FoeWithFood\"",
    "\"FriendWithFood\"",
    "<PlainIdent>",
    "<Anything>",
  };

}