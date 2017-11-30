/*
-------------------------- *.c 常见格式 --------------------------

 //头文件
 #include...

 //全局变量
 int a,b;
 ...

 //函数声明
 void func();
 ...

 //主函数
 int main(int argc, char* argv[]){
    ...
    return 0;
 }

 //函数实现
 void func(){
    ...
 }

本CMM.jj文件中所叙述的词法语法规则，只考虑*.c文件中，main函数中的主体部分

--------------------------------------------------------------------

本CMM.jj文件中的部分语法说明：

1.声明语句与赋值语句：必须先声明，后赋值。
  如："int a; a = 1;"为正确语法，而不能使用"int a = 1;"

2.数组的赋值：由于没有只有词法与语法分析，因此数组的赋值只能先统一声明，再对单个元素赋值的方法。
  如："real[] r; r[0] = 0; r[1] = 1;"

3.if-else语句：选择语句包含两种，含else的语句，与不含else的语句。
  如："if(){}"、"if(){}else{}"、"if(){}else if(){}else{}"均为正确语句，但"if(){}else if(){}"则无法识别。

4.算数运算符不含++、--等运算符。

5.需在控制台输入文本。"#"为输入结束符。

--------------------------------------------------------------------

测试用例：
    int a, b;
    real[] r;
    a = 1;
    read(b);
    r[0] = 0;

    while(a < b){
        if(a == 3){
            r[3] = 3;
        }else if(a == 5){
            r[5] = 5;
        }else{
            r[7] = (a * 3) - (b / 3);
        }
        a = a + 1;
    }

    write(a, b, r);

    #
--------------------------------------------------------------------
*/

package javacc.cmm;
/* Generated By:javacc: Do not edit this line. javacc.cmm.CMMParser.java */

public class CMMParser implements CMMParserConstants {
    public static void main(String[] args) throws ParseException{
        CMMParser parser = new CMMParser(System.in);
        parser.Start();
    }

  static final public void Start() throws ParseException {
    Procedure();
    jj_consume_token(19);
  }

  static final public void Procedure() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 20:
      Block();
      break;
    case IF:
    case WHILE:
    case READ:
    case WRITE:
    case INT:
    case REAL:
    case IDENTIFIER:
      label_1:
      while (true) {
        Statement();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case WHILE:
        case READ:
        case WRITE:
        case INT:
        case REAL:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
      }
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Block() throws ParseException {
    jj_consume_token(20);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 20:
        Block();
        break;
      case IF:
      case WHILE:
      case READ:
      case WRITE:
      case INT:
      case REAL:
      case IDENTIFIER:
        label_3:
        while (true) {
          Statement();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case IF:
          case WHILE:
          case READ:
          case WRITE:
          case INT:
          case REAL:
          case IDENTIFIER:
            ;
            break;
          default:
            jj_la1[2] = jj_gen;
            break label_3;
          }
        }
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case READ:
      case WRITE:
      case INT:
      case REAL:
      case IDENTIFIER:
      case 20:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
    }
    jj_consume_token(21);
  }

  static final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case REAL:
      Declaration();
      break;
    case IDENTIFIER:
      Assignment();
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(22);
      Condition();
      jj_consume_token(23);
      Block();
      break;
    case READ:
      jj_consume_token(READ);
      jj_consume_token(22);
      jj_consume_token(IDENTIFIER);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        jj_consume_token(24);
        jj_consume_token(IDENTIFIER);
      }
      jj_consume_token(23);
      jj_consume_token(25);
      break;
    case WRITE:
      jj_consume_token(WRITE);
      jj_consume_token(22);
      Expression();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        jj_consume_token(24);
        Expression();
      }
      jj_consume_token(23);
      jj_consume_token(25);
      break;
    case IF:
      Choice();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Declaration() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case REAL:
      jj_consume_token(REAL);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 26:
      jj_consume_token(26);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(IDENTIFIER);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 24:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      jj_consume_token(24);
      jj_consume_token(IDENTIFIER);
    }
    jj_consume_token(25);
  }

  static final public void Assignment() throws ParseException {
    jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 27:
      jj_consume_token(27);
      jj_consume_token(INTEGER_LITERAL);
      jj_consume_token(28);
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    jj_consume_token(29);
    Expression();
    jj_consume_token(25);
  }

  static final public void Expression() throws ParseException {
    Term();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 30:
      case 31:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 30:
        jj_consume_token(30);
        break;
      case 31:
        jj_consume_token(31);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      Term();
    }
  }

  static final public void Choice() throws ParseException {
    if (jj_2_1(2147483647)) {
      label_8:
      while (true) {
        jj_consume_token(IF);
        jj_consume_token(22);
        Condition();
        jj_consume_token(23);
        Block();
        jj_consume_token(ELSE);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_8;
        }
      }
      Block();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        jj_consume_token(IF);
        jj_consume_token(22);
        Condition();
        jj_consume_token(23);
        Block();
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Condition() throws ParseException {
    Expression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 33:
      jj_consume_token(33);
      break;
    case 34:
      jj_consume_token(34);
      break;
    case 35:
      jj_consume_token(35);
      break;
    case 36:
      jj_consume_token(36);
      break;
    case 37:
      jj_consume_token(37);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Expression();
  }

  static final public void Term() throws ParseException {
    Factor();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 38:
      case 39:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 38:
        jj_consume_token(38);
        break;
      case 39:
        jj_consume_token(39);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      Factor();
    }
  }

  static final public void Factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      break;
    case INTEGER_LITERAL:
      jj_consume_token(INTEGER_LITERAL);
      break;
    case REAL_LITERAL:
      jj_consume_token(REAL_LITERAL);
      break;
    case 22:
      jj_consume_token(22);
      Expression();
      jj_consume_token(23);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3R_28() {
    if (jj_3R_33()) return true;
    return false;
  }

  static private boolean jj_3R_27() {
    if (jj_scan_token(WRITE)) return true;
    if (jj_scan_token(22)) return true;
    if (jj_3R_12()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_32()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(23)) return true;
    if (jj_scan_token(25)) return true;
    return false;
  }

  static private boolean jj_3R_26() {
    if (jj_scan_token(READ)) return true;
    if (jj_scan_token(22)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_31()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(23)) return true;
    if (jj_scan_token(25)) return true;
    return false;
  }

  static private boolean jj_3R_25() {
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(22)) return true;
    if (jj_3R_10()) return true;
    if (jj_scan_token(23)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_24() {
    if (jj_3R_30()) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(38)) {
    jj_scanpos = xsp;
    if (jj_scan_token(39)) return true;
    }
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_21() {
    if (jj_scan_token(22)) return true;
    if (jj_3R_12()) return true;
    if (jj_scan_token(23)) return true;
    return false;
  }

  static private boolean jj_3R_34() {
    if (jj_scan_token(24)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    return false;
  }

  static private boolean jj_3R_22() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_23()) {
    jj_scanpos = xsp;
    if (jj_3R_24()) {
    jj_scanpos = xsp;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3R_28()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_23() {
    if (jj_3R_29()) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(16)) {
    jj_scanpos = xsp;
    if (jj_scan_token(14)) {
    jj_scanpos = xsp;
    if (jj_scan_token(15)) {
    jj_scanpos = xsp;
    if (jj_3R_21()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(20)) return true;
    Token xsp;
    if (jj_3R_13()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_13()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(21)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_3R_18()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_19()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(22)) return true;
    if (jj_3R_10()) return true;
    if (jj_scan_token(23)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_3R_12()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(32)) {
    jj_scanpos = xsp;
    if (jj_scan_token(33)) {
    jj_scanpos = xsp;
    if (jj_scan_token(34)) {
    jj_scanpos = xsp;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(36)) {
    jj_scanpos = xsp;
    if (jj_scan_token(37)) return true;
    }
    }
    }
    }
    }
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3R_32() {
    if (jj_scan_token(24)) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3R_37() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(22)) return true;
    if (jj_3R_10()) return true;
    if (jj_scan_token(23)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_31() {
    if (jj_scan_token(24)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_3R_38() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(22)) return true;
    if (jj_3R_10()) return true;
    if (jj_scan_token(23)) return true;
    if (jj_3R_11()) return true;
    if (jj_scan_token(ELSE)) return true;
    return false;
  }

  static private boolean jj_3R_35() {
    if (jj_scan_token(27)) return true;
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    if (jj_scan_token(28)) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(30)) {
    jj_scanpos = xsp;
    if (jj_scan_token(31)) return true;
    }
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3R_36() {
    Token xsp;
    if (jj_3R_38()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_38()) { jj_scanpos = xsp; break; }
    }
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_33() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_36()) {
    jj_scanpos = xsp;
    if (jj_3R_37()) return true;
    }
    return false;
  }

  static private boolean jj_3R_12() {
    if (jj_3R_14()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_15()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3R_30() {
    if (jj_scan_token(IDENTIFIER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_35()) jj_scanpos = xsp;
    if (jj_scan_token(29)) return true;
    if (jj_3R_12()) return true;
    if (jj_scan_token(25)) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    if (jj_3R_22()) return true;
    return false;
  }

  static private boolean jj_3R_29() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(12)) {
    jj_scanpos = xsp;
    if (jj_scan_token(13)) return true;
    }
    xsp = jj_scanpos;
    if (jj_scan_token(26)) jj_scanpos = xsp;
    if (jj_scan_token(IDENTIFIER)) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_34()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(25)) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    Token xsp;
    if (jj_3R_20()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_20()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated javacc.cmm.token Manager. */
  static public CMMParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[20];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x13e80,0x113e80,0x13e80,0x113e80,0x113e80,0x1000000,0x1000000,0x13e80,0x3000,0x4000000,0x1000000,0x8000000,0xc0000000,0xc0000000,0x80,0x80,0x0,0x0,0x0,0x41c000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3f,0xc0,0xc0,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public CMMParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CMMParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static v1.parser.  ");
      System.out.println("       You must either use ReInit() or set the javacc option STATIC to false");
      System.out.println("       during v1.parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CMMParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public CMMParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static v1.parser. ");
      System.out.println("       You must either use ReInit() or set the javacc option STATIC to false");
      System.out.println("       during v1.parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CMMParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated javacc.cmm.token Manager. */
  public CMMParser(CMMParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static v1.parser. ");
      System.out.println("       You must either use ReInit() or set the javacc option STATIC to false");
      System.out.println("       during v1.parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(CMMParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next javacc.cmm.token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific javacc.cmm.token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate javacc.cmm.ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[40];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 20; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 40; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
