package javacc.cmm;/* Generated By:javacc: Do not edit this line. javacc.cmm.CMMParserTokenManager.java */

/** javacc.cmm.token Manager. */
public class CMMParserTokenManager implements CMMParserConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3f80L) != 0L)
         {
            jjmatchedKind = 16;
            return 27;
         }
         if ((active0 & 0x8000000000L) != 0L)
            return 16;
         return -1;
      case 1:
         if ((active0 & 0x80L) != 0L)
            return 27;
         if ((active0 & 0x3f00L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 1;
            return 27;
         }
         return -1;
      case 2:
         if ((active0 & 0x2f00L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 2;
            return 27;
         }
         if ((active0 & 0x1000L) != 0L)
            return 27;
         return -1;
      case 3:
         if ((active0 & 0x2500L) != 0L)
            return 27;
         if ((active0 & 0xa00L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 3;
            return 27;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 35:
         return jjStopAtPos(0, 19);
      case 40:
         return jjStopAtPos(0, 22);
      case 41:
         return jjStopAtPos(0, 23);
      case 42:
         return jjStopAtPos(0, 38);
      case 43:
         return jjStopAtPos(0, 30);
      case 44:
         return jjStopAtPos(0, 24);
      case 45:
         return jjStopAtPos(0, 31);
      case 47:
         return jjStartNfaWithStates_0(0, 39, 16);
      case 59:
         return jjStopAtPos(0, 25);
      case 60:
         jjmatchedKind = 33;
         return jjMoveStringLiteralDfa1_0(0x2800000000L);
      case 61:
         jjmatchedKind = 29;
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 62:
         jjmatchedKind = 32;
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      case 91:
         jjmatchedKind = 27;
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 93:
         return jjStopAtPos(0, 28);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x1080L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x2400L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0xa00L);
      case 123:
         return jjStopAtPos(0, 20);
      case 125:
         return jjStopAtPos(0, 21);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 61:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(1, 34);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         else if ((active0 & 0x2000000000L) != 0L)
            return jjStopAtPos(1, 37);
         break;
      case 62:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 35);
         break;
      case 93:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(1, 26);
         break;
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x2400L);
      case 102:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(1, 7, 27);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x2400L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0xa00L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x100L);
      case 116:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(2, 12, 27);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 27);
         break;
      case 101:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(3, 8, 27);
         break;
      case 108:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 27);
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(4, 9, 27);
         else if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(4, 11, 27);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 27;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddStates(0, 4);
                  }
                  else if (curChar == 47)
                     jjAddStates(5, 6);
                  else if (curChar == 46)
                     jjCheckNAdd(4);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 14)
                        kind = 14;
                     jjCheckNAdd(1);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 14)
                        kind = 14;
                  }
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAdd(7);
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 16:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(22, 23);
                  else if (curChar == 47)
                     jjCheckNAddStates(7, 9);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAdd(1);
                  break;
               case 2:
                  if (curChar == 48 && kind > 14)
                     kind = 14;
                  break;
               case 3:
                  if (curChar == 46)
                     jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(4);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(7);
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddStates(0, 4);
                  break;
               case 9:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(9);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(10, 11);
                  break;
               case 11:
                  if (curChar == 46 && kind > 15)
                     kind = 15;
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 13:
                  if (curChar == 46)
                     jjCheckNAdd(14);
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(14);
                  break;
               case 15:
                  if (curChar == 47)
                     jjAddStates(5, 6);
                  break;
               case 17:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 18:
                  if ((0x2400L & l) != 0L && kind > 5)
                     kind = 5;
                  break;
               case 19:
                  if (curChar == 10 && kind > 5)
                     kind = 5;
                  break;
               case 20:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 21:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(22, 23);
                  break;
               case 22:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(22, 23);
                  break;
               case 23:
                  if (curChar == 42)
                     jjCheckNAddStates(10, 12);
                  break;
               case 24:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(25, 23);
                  break;
               case 25:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(25, 23);
                  break;
               case 26:
                  if (curChar == 47 && kind > 6)
                     kind = 6;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAddTwoStates(6, 7);
                  break;
               case 27:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAdd(7);
                  }
                  break;
               case 6:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 7:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(7);
                  break;
               case 17:
                  jjAddStates(7, 9);
                  break;
               case 22:
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 24:
               case 25:
                  jjCheckNAddTwoStates(25, 23);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 17:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(7, 9);
                  break;
               case 22:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(22, 23);
                  break;
               case 24:
               case 25:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(25, 23);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 27 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   9, 10, 11, 12, 13, 16, 21, 17, 18, 20, 23, 24, 26, 
};

/** javacc.cmm.token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, "\151\146", "\145\154\163\145", 
"\167\150\151\154\145", "\162\145\141\144", "\167\162\151\164\145", "\151\156\164", 
"\162\145\141\154", null, null, null, null, null, "\43", "\173", "\175", "\50", "\51", "\54", 
"\73", "\133\135", "\133", "\135", "\75", "\53", "\55", "\76", "\74", "\75\75", 
"\74\76", "\76\75", "\74\75", "\52", "\57", };

/** v1.lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xfffff9ff81L, 
};
static final long[] jjtoSkip = {
   0x7eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[27];
static private final int[] jjstateSet = new int[54];
static protected char curChar;
/** Constructor. */
public CMMParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor type static v1.lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public CMMParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise v1.parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 27; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise v1.parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next javacc.cmm.token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
