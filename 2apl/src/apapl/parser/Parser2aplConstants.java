/* Generated By:JavaCC: Do not edit this line. Parser2aplConstants.java */
package apapl.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface Parser2aplConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMANT = 9;
  /** RegularExpression Id. */
  int FORMAL_COMMANT = 10;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMANT = 11;
  /** RegularExpression Id. */
  int FILENAME = 17;
  /** RegularExpression Id. */
  int INCLHEAD = 18;
  /** RegularExpression Id. */
  int CAPSHEAD = 19;
  /** RegularExpression Id. */
  int BBHEAD = 20;
  /** RegularExpression Id. */
  int GBHEAD = 21;
  /** RegularExpression Id. */
  int GPRULEHEAD = 22;
  /** RegularExpression Id. */
  int PRRULEHEAD = 23;
  /** RegularExpression Id. */
  int PCRULEHEAD = 24;
  /** RegularExpression Id. */
  int PLANHEAD = 25;
  /** RegularExpression Id. */
  int SANCTIONHEAD = 26;
  /** RegularExpression Id. */
  int OHEAD = 27;
  /** RegularExpression Id. */
  int PHEAD = 28;
  /** RegularExpression Id. */
  int AND = 29;
  /** RegularExpression Id. */
  int OR = 30;
  /** RegularExpression Id. */
  int NOT = 31;
  /** RegularExpression Id. */
  int TRUE = 32;
  /** RegularExpression Id. */
  int IF = 33;
  /** RegularExpression Id. */
  int THEN = 34;
  /** RegularExpression Id. */
  int ELSE = 35;
  /** RegularExpression Id. */
  int WHILE = 36;
  /** RegularExpression Id. */
  int DO = 37;
  /** RegularExpression Id. */
  int SELECT = 38;
  /** RegularExpression Id. */
  int MARKER_BEGIN = 39;
  /** RegularExpression Id. */
  int MARKER_END = 40;
  /** RegularExpression Id. */
  int TESTAND = 41;
  /** RegularExpression Id. */
  int SKIPPLAN = 42;
  /** RegularExpression Id. */
  int SEND = 43;
  /** RegularExpression Id. */
  int PRINT = 44;
  /** RegularExpression Id. */
  int CREATE = 45;
  /** RegularExpression Id. */
  int CLONE = 46;
  /** RegularExpression Id. */
  int RELEASE = 47;
  /** RegularExpression Id. */
  int EXECUTE = 48;
  /** RegularExpression Id. */
  int UPDATEBB = 49;
  /** RegularExpression Id. */
  int GOALACTION = 50;
  /** RegularExpression Id. */
  int COMMA = 51;
  /** RegularExpression Id. */
  int B = 52;
  /** RegularExpression Id. */
  int G = 53;
  /** RegularExpression Id. */
  int GE = 54;
  /** RegularExpression Id. */
  int P = 55;
  /** RegularExpression Id. */
  int AT = 56;
  /** RegularExpression Id. */
  int SLASHJADE = 57;
  /** RegularExpression Id. */
  int UNDERSCORE = 58;
  /** RegularExpression Id. */
  int LBRACE = 59;
  /** RegularExpression Id. */
  int RBRACE = 60;
  /** RegularExpression Id. */
  int DOTCOMMA = 61;
  /** RegularExpression Id. */
  int LISTL = 62;
  /** RegularExpression Id. */
  int LISTR = 63;
  /** RegularExpression Id. */
  int ACCL = 64;
  /** RegularExpression Id. */
  int ACCR = 65;
  /** RegularExpression Id. */
  int LEFTARROW = 66;
  /** RegularExpression Id. */
  int RIGHTARROW = 67;
  /** RegularExpression Id. */
  int DOT = 68;
  /** RegularExpression Id. */
  int IMPL = 69;
  /** RegularExpression Id. */
  int RELATIONAL = 70;
  /** RegularExpression Id. */
  int SIGN = 71;
  /** RegularExpression Id. */
  int COLON = 72;
  /** RegularExpression Id. */
  int IDENT = 73;
  /** RegularExpression Id. */
  int VARNAME = 74;
  /** RegularExpression Id. */
  int NUM = 75;
  /** RegularExpression Id. */
  int NUMNAME = 76;
  /** RegularExpression Id. */
  int NAMEDOT = 77;
  /** RegularExpression Id. */
  int VERT = 78;
  /** RegularExpression Id. */
  int QUOTE = 79;
  /** RegularExpression Id. */
  int QUOTE1 = 80;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_SINGLE_LINE_COMMANT = 1;
  /** Lexical state. */
  int IN_FORMAL_COMMANT = 2;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMANT = 3;
  /** Lexical state. */
  int IN_INCLUDE_SECTION = 4;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"%\"",
    "\"//\"",
    "<token of kind 7>",
    "\"/*\"",
    "<SINGLE_LINE_COMMANT>",
    "\"*/\"",
    "\"*/\"",
    "<token of kind 12>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<FILENAME>",
    "\"Include:\"",
    "\"BeliefUpdates:\"",
    "\"Beliefs:\"",
    "\"Goals:\"",
    "\"PG-rules:\"",
    "\"PR-rules:\"",
    "\"PC-rules:\"",
    "\"Plans:\"",
    "\"Sanctions:\"",
    "\"Obligations:\"",
    "\"Prohibitions:\"",
    "\"and\"",
    "\"or\"",
    "\"not\"",
    "\"true\"",
    "\"if\"",
    "\"then\"",
    "\"else\"",
    "\"while\"",
    "\"do\"",
    "\"#\"",
    "<MARKER_BEGIN>",
    "<MARKER_END>",
    "\"&\"",
    "\"skip\"",
    "\"send\"",
    "\"print\"",
    "\"create\"",
    "\"clone\"",
    "\"release\"",
    "\"execute\"",
    "\"updateBB\"",
    "<GOALACTION>",
    "\",\"",
    "\"B\"",
    "\"G\"",
    "\"!G\"",
    "\"P\"",
    "\"@\"",
    "\"/JADE\"",
    "\"_\"",
    "\"(\"",
    "\")\"",
    "\";\"",
    "\"[\"",
    "\"]\"",
    "\"{\"",
    "\"}\"",
    "\"<-\"",
    "\"->\"",
    "\".\"",
    "\":-\"",
    "<RELATIONAL>",
    "<SIGN>",
    "\":\"",
    "<IDENT>",
    "<VARNAME>",
    "<NUM>",
    "<NUMNAME>",
    "<NAMEDOT>",
    "\"|\"",
    "<QUOTE>",
    "<QUOTE1>",
    "\"?\"",
    "\"*\"",
    "\"/\"",
  };

}
