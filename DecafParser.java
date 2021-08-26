// Generated from Decaf.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, PROGRAM=2, IF=3, ELSE=4, FOR=5, WHILE=6, RETURN=7, BREAK=8, CONTINUE=9, 
		BOOLEAN=10, CHAR=11, INT=12, STRING=13, TRUE=14, FALSE=15, VOID=16, STRUCT=17, 
		CALLOUT=18, SEMICOLON=19, LCURLY=20, RCURLY=21, LSQUARE=22, RSQUARE=23, 
		LROUND=24, RROUND=25, COMMA=26, QUOTES=27, APOSTROPHE=28, ADD=29, SUB=30, 
		MULTIPLY=31, DIVIDE=32, REMINDER=33, AND=34, OR=35, NOT=36, GREATER_OP=37, 
		LESS_OP=38, GREATER_eq_op=39, LESS_eq_op=40, EQUAL_OP=41, ADD_eq_op=42, 
		SUB_eq_op=43, EQUALITY_OP=44, UNEQUALITY_OP=45, POINT=46, ID=47, ALPHA=48, 
		DECIMAL_LITERAL=49, DIGIT=50, HEX_LITERAL=51, BOOL_LITERAL=52, STRING_LITERAL=53, 
		ALPHA_NUM=54, HEX_DIGIT=55, LINE_COMMENT=56, COMMENT=57, NEWLINE=58, WHITESPACE=59;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_vardeclr = 2, RULE_vardeclrs = 3, 
		RULE_field_declr = 4, RULE_array_id = 5, RULE_field_var = 6, RULE_var_id = 7, 
		RULE_struct_declr = 8, RULE_method_declr = 9, RULE_return_type = 10, RULE_block = 11, 
		RULE_statement = 12, RULE_method_call = 13, RULE_expr = 14, RULE_location = 15, 
		RULE_int_literal = 16, RULE_rel_op = 17, RULE_eq_op = 18, RULE_cond_op = 19, 
		RULE_literal = 20, RULE_bin_op = 21, RULE_arith_op = 22, RULE_var_type = 23, 
		RULE_assign_op = 24, RULE_method_name = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "vardeclr", "vardeclrs", "field_declr", "array_id", 
			"field_var", "var_id", "struct_declr", "method_declr", "return_type", 
			"block", "statement", "method_call", "expr", "location", "int_literal", 
			"rel_op", "eq_op", "cond_op", "literal", "bin_op", "arith_op", "var_type", 
			"assign_op", "method_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'Program'", "'if'", "'else'", "'for'", "'while'", "'return'", 
			"'break'", "'continue'", "'boolean'", "'char'", "'int'", "'string'", 
			"'True'", "'False'", "'void'", "'struct'", "'callout'", "';'", "'{'", 
			"'}'", "'['", "']'", "'('", "')'", "','", "'\"'", "'''", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'>'", "'<'", "'>='", "'<='", 
			"'='", "'+='", "'-='", "'=='", "'!='", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CLASS", "PROGRAM", "IF", "ELSE", "FOR", "WHILE", "RETURN", "BREAK", 
			"CONTINUE", "BOOLEAN", "CHAR", "INT", "STRING", "TRUE", "FALSE", "VOID", 
			"STRUCT", "CALLOUT", "SEMICOLON", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", 
			"LROUND", "RROUND", "COMMA", "QUOTES", "APOSTROPHE", "ADD", "SUB", "MULTIPLY", 
			"DIVIDE", "REMINDER", "AND", "OR", "NOT", "GREATER_OP", "LESS_OP", "GREATER_eq_op", 
			"LESS_eq_op", "EQUAL_OP", "ADD_eq_op", "SUB_eq_op", "EQUALITY_OP", "UNEQUALITY_OP", 
			"POINT", "ID", "ALPHA", "DECIMAL_LITERAL", "DIGIT", "HEX_LITERAL", "BOOL_LITERAL", 
			"STRING_LITERAL", "ALPHA_NUM", "HEX_DIGIT", "LINE_COMMENT", "COMMENT", 
			"NEWLINE", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Decaf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(DecafParser.CLASS, 0); }
		public TerminalNode PROGRAM() { return getToken(DecafParser.PROGRAM, 0); }
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(CLASS);
			setState(53);
			match(PROGRAM);
			setState(54);
			match(LCURLY);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << STRUCT))) != 0)) {
				{
				{
				setState(55);
				declaration();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public Struct_declrContext struct_declr() {
			return getRuleContext(Struct_declrContext.class,0);
		}
		public VardeclrContext vardeclr() {
			return getRuleContext(VardeclrContext.class,0);
		}
		public VardeclrsContext vardeclrs() {
			return getRuleContext(VardeclrsContext.class,0);
		}
		public Method_declrContext method_declr() {
			return getRuleContext(Method_declrContext.class,0);
		}
		public Field_declrContext field_declr() {
			return getRuleContext(Field_declrContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				struct_declr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				vardeclr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				vardeclrs();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				method_declr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				field_declr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclrContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Field_varContext field_var() {
			return getRuleContext(Field_varContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public VardeclrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardeclr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterVardeclr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitVardeclr(this);
		}
	}

	public final VardeclrContext vardeclr() throws RecognitionException {
		VardeclrContext _localctx = new VardeclrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardeclr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			var_type();
			setState(71);
			field_var();
			setState(72);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclrsContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public List<Field_varContext> field_var() {
			return getRuleContexts(Field_varContext.class);
		}
		public Field_varContext field_var(int i) {
			return getRuleContext(Field_varContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public VardeclrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardeclrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterVardeclrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitVardeclrs(this);
		}
	}

	public final VardeclrsContext vardeclrs() throws RecognitionException {
		VardeclrsContext _localctx = new VardeclrsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardeclrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(74);
			var_type();
			setState(75);
			field_var();
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(77);
				match(COMMA);
				setState(78);
				var_type();
				setState(79);
				field_var();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_declrContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public List<Field_varContext> field_var() {
			return getRuleContexts(Field_varContext.class);
		}
		public Field_varContext field_var(int i) {
			return getRuleContext(Field_varContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Field_declrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_declr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterField_declr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitField_declr(this);
		}
	}

	public final Field_declrContext field_declr() throws RecognitionException {
		Field_declrContext _localctx = new Field_declrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field_declr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			var_type();
			setState(89);
			field_var();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(90);
				match(COMMA);
				setState(91);
				field_var();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LSQUARE() { return getToken(DecafParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(DecafParser.RSQUARE, 0); }
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public TerminalNode POINT() { return getToken(DecafParser.POINT, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Array_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterArray_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitArray_id(this);
		}
	}

	public final Array_idContext array_id() throws RecognitionException {
		Array_idContext _localctx = new Array_idContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_array_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ID);
			setState(100);
			match(LSQUARE);
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
				{
				setState(101);
				int_literal();
				}
				break;
			case ID:
				{
				setState(102);
				var_id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(105);
			match(RSQUARE);
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(106);
				match(POINT);
				setState(107);
				location();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_varContext extends ParserRuleContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public Array_idContext array_id() {
			return getRuleContext(Array_idContext.class,0);
		}
		public Field_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterField_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitField_var(this);
		}
	}

	public final Field_varContext field_var() throws RecognitionException {
		Field_varContext _localctx = new Field_varContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field_var);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				var_id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				array_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode POINT() { return getToken(DecafParser.POINT, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Var_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterVar_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitVar_id(this);
		}
	}

	public final Var_idContext var_id() throws RecognitionException {
		Var_idContext _localctx = new Var_idContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(115);
				match(POINT);
				setState(116);
				location();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_declrContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(DecafParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<VardeclrContext> vardeclr() {
			return getRuleContexts(VardeclrContext.class);
		}
		public VardeclrContext vardeclr(int i) {
			return getRuleContext(VardeclrContext.class,i);
		}
		public List<VardeclrsContext> vardeclrs() {
			return getRuleContexts(VardeclrsContext.class);
		}
		public VardeclrsContext vardeclrs(int i) {
			return getRuleContext(VardeclrsContext.class,i);
		}
		public Struct_declrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterStruct_declr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitStruct_declr(this);
		}
	}

	public final Struct_declrContext struct_declr() throws RecognitionException {
		Struct_declrContext _localctx = new Struct_declrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_struct_declr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(STRUCT);
			setState(120);
			match(ID);
			setState(121);
			match(LCURLY);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << STRING) | (1L << STRUCT))) != 0)) {
				{
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(122);
					vardeclr();
					}
					break;
				case 2:
					{
					setState(123);
					vardeclrs();
					}
					break;
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(RCURLY);
			setState(130);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_declrContext extends ParserRuleContext {
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public List<Var_idContext> var_id() {
			return getRuleContexts(Var_idContext.class);
		}
		public Var_idContext var_id(int i) {
			return getRuleContext(Var_idContext.class,i);
		}
		public Method_declrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_declr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterMethod_declr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitMethod_declr(this);
		}
	}

	public final Method_declrContext method_declr() throws RecognitionException {
		Method_declrContext _localctx = new Method_declrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_method_declr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			return_type();
			setState(133);
			method_name();
			setState(134);
			match(LROUND);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << STRUCT))) != 0)) {
				{
				setState(139);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN:
				case INT:
				case STRING:
				case STRUCT:
					{
					{
					setState(135);
					var_type();
					setState(136);
					var_id();
					}
					}
					break;
				case VOID:
					{
					setState(138);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(141);
					match(COMMA);
					setState(142);
					var_type();
					setState(143);
					var_id();
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(152);
			match(RROUND);
			setState(153);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitReturn_type(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_return_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case INT:
			case STRING:
			case STRUCT:
				{
				setState(155);
				var_type();
				}
				break;
			case VOID:
				{
				setState(156);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public List<VardeclrContext> vardeclr() {
			return getRuleContexts(VardeclrContext.class);
		}
		public VardeclrContext vardeclr(int i) {
			return getRuleContext(VardeclrContext.class,i);
		}
		public List<VardeclrsContext> vardeclrs() {
			return getRuleContexts(VardeclrsContext.class);
		}
		public VardeclrsContext vardeclrs(int i) {
			return getRuleContext(VardeclrsContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(LCURLY);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << STRING) | (1L << STRUCT))) != 0)) {
				{
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(160);
					vardeclr();
					}
					break;
				case 2:
					{
					setState(161);
					vardeclrs();
					}
					break;
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << RETURN) | (1L << BREAK) | (1L << ID))) != 0)) {
				{
				{
				setState(167);
				statement();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode IF() { return getToken(DecafParser.IF, 0); }
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(DecafParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(DecafParser.WHILE, 0); }
		public List<TerminalNode> EQUAL_OP() { return getTokens(DecafParser.EQUAL_OP); }
		public TerminalNode EQUAL_OP(int i) {
			return getToken(DecafParser.EQUAL_OP, i);
		}
		public TerminalNode RETURN() { return getToken(DecafParser.RETURN, 0); }
		public TerminalNode FOR() { return getToken(DecafParser.FOR, 0); }
		public List<Var_idContext> var_id() {
			return getRuleContexts(Var_idContext.class);
		}
		public Var_idContext var_id(int i) {
			return getRuleContext(Var_idContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(DecafParser.COMMA, 0); }
		public List<Int_literalContext> int_literal() {
			return getRuleContexts(Int_literalContext.class);
		}
		public Int_literalContext int_literal(int i) {
			return getRuleContext(Int_literalContext.class,i);
		}
		public TerminalNode BREAK() { return getToken(DecafParser.BREAK, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		int _la;
		try {
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				location();
				setState(176);
				assign_op();
				setState(177);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				location();
				setState(180);
				assign_op();
				setState(181);
				expr(0);
				setState(182);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				method_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(IF);
				setState(186);
				match(LROUND);
				setState(187);
				expr(0);
				setState(188);
				match(RROUND);
				setState(189);
				block();
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(190);
					match(ELSE);
					setState(191);
					block();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				match(WHILE);
				setState(195);
				match(LROUND);
				setState(196);
				expr(0);
				setState(197);
				match(RROUND);
				setState(198);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(200);
				location();
				setState(201);
				match(EQUAL_OP);
				setState(202);
				expr(0);
				setState(203);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(205);
				match(RETURN);
				setState(206);
				expr(0);
				setState(207);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(209);
				match(FOR);
				setState(210);
				var_id();
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL_OP) {
					{
					setState(211);
					match(EQUAL_OP);
					setState(212);
					int_literal();
					}
				}

				setState(215);
				match(COMMA);
				setState(222);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					{
					setState(216);
					var_id();
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==EQUAL_OP) {
						{
						setState(217);
						match(EQUAL_OP);
						setState(218);
						int_literal();
						}
					}

					}
					}
					break;
				case DECIMAL_LITERAL:
				case HEX_LITERAL:
					{
					setState(221);
					int_literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(224);
				block();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(226);
				match(BREAK);
				setState(227);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_callContext extends ParserRuleContext {
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitMethod_call(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			method_name();
			setState(231);
			match(LROUND);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LROUND) | (1L << SUB) | (1L << NOT) | (1L << ID) | (1L << DECIMAL_LITERAL) | (1L << HEX_LITERAL) | (1L << BOOL_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(232);
				expr(0);
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(233);
					match(COMMA);
					setState(234);
					expr(0);
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(242);
			match(RROUND);
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(243);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode SUB() { return getToken(DecafParser.SUB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode NOT() { return getToken(DecafParser.NOT, 0); }
		public TerminalNode LROUND() { return getToken(DecafParser.LROUND, 0); }
		public TerminalNode RROUND() { return getToken(DecafParser.RROUND, 0); }
		public Bin_opContext bin_op() {
			return getRuleContext(Bin_opContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(247);
				location();
				}
				break;
			case 2:
				{
				setState(248);
				literal();
				}
				break;
			case 3:
				{
				setState(249);
				match(SUB);
				setState(250);
				expr(4);
				}
				break;
			case 4:
				{
				setState(251);
				method_call();
				}
				break;
			case 5:
				{
				setState(252);
				match(NOT);
				setState(253);
				expr(2);
				}
				break;
			case 6:
				{
				setState(254);
				match(LROUND);
				setState(255);
				expr(0);
				setState(256);
				match(RROUND);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(266);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(260);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(261);
					bin_op();
					setState(262);
					expr(6);
					}
					} 
				}
				setState(268);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LocationContext extends ParserRuleContext {
		public Var_idContext var_id() {
			return getRuleContext(Var_idContext.class,0);
		}
		public Array_idContext array_id() {
			return getRuleContext(Array_idContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitLocation(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_location);
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				var_id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				array_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(DecafParser.DECIMAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(DecafParser.HEX_LITERAL, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterInt_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitInt_literal(this);
		}
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_int_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_la = _input.LA(1);
			if ( !(_la==DECIMAL_LITERAL || _la==HEX_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_opContext extends ParserRuleContext {
		public TerminalNode GREATER_OP() { return getToken(DecafParser.GREATER_OP, 0); }
		public TerminalNode LESS_OP() { return getToken(DecafParser.LESS_OP, 0); }
		public TerminalNode LESS_eq_op() { return getToken(DecafParser.LESS_eq_op, 0); }
		public TerminalNode GREATER_eq_op() { return getToken(DecafParser.GREATER_eq_op, 0); }
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterRel_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitRel_op(this);
		}
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_OP) | (1L << LESS_OP) | (1L << GREATER_eq_op) | (1L << LESS_eq_op))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Eq_opContext extends ParserRuleContext {
		public TerminalNode EQUALITY_OP() { return getToken(DecafParser.EQUALITY_OP, 0); }
		public TerminalNode UNEQUALITY_OP() { return getToken(DecafParser.UNEQUALITY_OP, 0); }
		public Eq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterEq_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitEq_op(this);
		}
	}

	public final Eq_opContext eq_op() throws RecognitionException {
		Eq_opContext _localctx = new Eq_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !(_la==EQUALITY_OP || _la==UNEQUALITY_OP) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_opContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(DecafParser.AND, 0); }
		public TerminalNode OR() { return getToken(DecafParser.OR, 0); }
		public Cond_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterCond_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitCond_op(this);
		}
	}

	public final Cond_opContext cond_op() throws RecognitionException {
		Cond_opContext _localctx = new Cond_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cond_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(DecafParser.BOOL_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		try {
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				int_literal();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				match(BOOL_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bin_opContext extends ParserRuleContext {
		public Arith_opContext arith_op() {
			return getRuleContext(Arith_opContext.class,0);
		}
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public Bin_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterBin_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitBin_op(this);
		}
	}

	public final Bin_opContext bin_op() throws RecognitionException {
		Bin_opContext _localctx = new Bin_opContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bin_op);
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case MULTIPLY:
			case DIVIDE:
			case REMINDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				arith_op();
				}
				break;
			case GREATER_OP:
			case LESS_OP:
			case GREATER_eq_op:
			case LESS_eq_op:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				rel_op();
				}
				break;
			case EQUALITY_OP:
			case UNEQUALITY_OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				eq_op();
				}
				break;
			case AND:
			case OR:
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				cond_op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arith_opContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(DecafParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(DecafParser.SUB, 0); }
		public TerminalNode MULTIPLY() { return getToken(DecafParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(DecafParser.DIVIDE, 0); }
		public TerminalNode REMINDER() { return getToken(DecafParser.REMINDER, 0); }
		public Arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterArith_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitArith_op(this);
		}
	}

	public final Arith_opContext arith_op() throws RecognitionException {
		Arith_opContext _localctx = new Arith_opContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MULTIPLY) | (1L << DIVIDE) | (1L << REMINDER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DecafParser.INT, 0); }
		public TerminalNode STRING() { return getToken(DecafParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(DecafParser.BOOLEAN, 0); }
		public TerminalNode STRUCT() { return getToken(DecafParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Struct_declrContext struct_declr() {
			return getRuleContext(Struct_declrContext.class,0);
		}
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterVar_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitVar_type(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_var_type);
		try {
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				match(BOOLEAN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(297);
				match(STRUCT);
				setState(298);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(299);
				struct_declr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode EQUAL_OP() { return getToken(DecafParser.EQUAL_OP, 0); }
		public TerminalNode ADD_eq_op() { return getToken(DecafParser.ADD_eq_op, 0); }
		public TerminalNode SUB_eq_op() { return getToken(DecafParser.SUB_eq_op, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitAssign_op(this);
		}
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL_OP) | (1L << ADD_eq_op) | (1L << SUB_eq_op))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterMethod_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitMethod_name(this);
		}
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0135\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\5\3G\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5T\n\5\f\5\16\5W\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7j\n\7\3\7\3\7\3\7\5\7o\n\7\3\b\3\b\5"+
		"\bs\n\b\3\t\3\t\3\t\5\tx\n\t\3\n\3\n\3\n\3\n\3\n\7\n\177\n\n\f\n\16\n"+
		"\u0082\13\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008e"+
		"\n\13\3\13\3\13\3\13\3\13\7\13\u0094\n\13\f\13\16\13\u0097\13\13\5\13"+
		"\u0099\n\13\3\13\3\13\3\13\3\f\3\f\5\f\u00a0\n\f\3\r\3\r\3\r\7\r\u00a5"+
		"\n\r\f\r\16\r\u00a8\13\r\3\r\7\r\u00ab\n\r\f\r\16\r\u00ae\13\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00c3\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d8\n\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00de\n\16\3\16\5\16\u00e1\n\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00e7\n\16\3\17\3\17\3\17\3\17\3\17\7\17\u00ee\n\17\f\17"+
		"\16\17\u00f1\13\17\5\17\u00f3\n\17\3\17\3\17\5\17\u00f7\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0105\n\20\3\20"+
		"\3\20\3\20\3\20\7\20\u010b\n\20\f\20\16\20\u010e\13\20\3\21\3\21\5\21"+
		"\u0112\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\5\26"+
		"\u011f\n\26\3\27\3\27\3\27\3\27\5\27\u0125\n\27\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\5\31\u012f\n\31\3\32\3\32\3\33\3\33\3\33\2\3\36\34"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\b\4\2\63\63"+
		"\65\65\3\2\'*\3\2./\3\2$%\3\2\37#\3\2+-\2\u014d\2\66\3\2\2\2\4F\3\2\2"+
		"\2\6H\3\2\2\2\bL\3\2\2\2\nZ\3\2\2\2\fe\3\2\2\2\16r\3\2\2\2\20t\3\2\2\2"+
		"\22y\3\2\2\2\24\u0086\3\2\2\2\26\u009f\3\2\2\2\30\u00a1\3\2\2\2\32\u00e6"+
		"\3\2\2\2\34\u00e8\3\2\2\2\36\u0104\3\2\2\2 \u0111\3\2\2\2\"\u0113\3\2"+
		"\2\2$\u0115\3\2\2\2&\u0117\3\2\2\2(\u0119\3\2\2\2*\u011e\3\2\2\2,\u0124"+
		"\3\2\2\2.\u0126\3\2\2\2\60\u012e\3\2\2\2\62\u0130\3\2\2\2\64\u0132\3\2"+
		"\2\2\66\67\7\3\2\2\678\7\4\2\28<\7\26\2\29;\5\4\3\2:9\3\2\2\2;>\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\27\2\2@\3\3\2\2\2AG\5\22"+
		"\n\2BG\5\6\4\2CG\5\b\5\2DG\5\24\13\2EG\5\n\6\2FA\3\2\2\2FB\3\2\2\2FC\3"+
		"\2\2\2FD\3\2\2\2FE\3\2\2\2G\5\3\2\2\2HI\5\60\31\2IJ\5\16\b\2JK\7\25\2"+
		"\2K\7\3\2\2\2LM\5\60\31\2MN\5\16\b\2NU\3\2\2\2OP\7\34\2\2PQ\5\60\31\2"+
		"QR\5\16\b\2RT\3\2\2\2SO\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2"+
		"\2WU\3\2\2\2XY\7\25\2\2Y\t\3\2\2\2Z[\5\60\31\2[`\5\16\b\2\\]\7\34\2\2"+
		"]_\5\16\b\2^\\\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2"+
		"\2cd\7\25\2\2d\13\3\2\2\2ef\7\61\2\2fi\7\30\2\2gj\5\"\22\2hj\5\20\t\2"+
		"ig\3\2\2\2ih\3\2\2\2jk\3\2\2\2kn\7\31\2\2lm\7\60\2\2mo\5 \21\2nl\3\2\2"+
		"\2no\3\2\2\2o\r\3\2\2\2ps\5\20\t\2qs\5\f\7\2rp\3\2\2\2rq\3\2\2\2s\17\3"+
		"\2\2\2tw\7\61\2\2uv\7\60\2\2vx\5 \21\2wu\3\2\2\2wx\3\2\2\2x\21\3\2\2\2"+
		"yz\7\23\2\2z{\7\61\2\2{\u0080\7\26\2\2|\177\5\6\4\2}\177\5\b\5\2~|\3\2"+
		"\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\27\2\2\u0084\u0085\7"+
		"\25\2\2\u0085\23\3\2\2\2\u0086\u0087\5\26\f\2\u0087\u0088\5\64\33\2\u0088"+
		"\u0098\7\32\2\2\u0089\u008a\5\60\31\2\u008a\u008b\5\20\t\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008e\7\22\2\2\u008d\u0089\3\2\2\2\u008d\u008c\3\2\2\2"+
		"\u008e\u0095\3\2\2\2\u008f\u0090\7\34\2\2\u0090\u0091\5\60\31\2\u0091"+
		"\u0092\5\20\t\2\u0092\u0094\3\2\2\2\u0093\u008f\3\2\2\2\u0094\u0097\3"+
		"\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u008d\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\7\33\2\2\u009b\u009c\5\30\r\2\u009c\25\3\2\2\2\u009d"+
		"\u00a0\5\60\31\2\u009e\u00a0\7\22\2\2\u009f\u009d\3\2\2\2\u009f\u009e"+
		"\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u00a6\7\26\2\2\u00a2\u00a5\5\6\4\2\u00a3"+
		"\u00a5\5\b\5\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ac\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00ab\5\32\16\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b0\7\27\2\2\u00b0\31\3\2\2\2\u00b1\u00b2\5 \21"+
		"\2\u00b2\u00b3\5\62\32\2\u00b3\u00b4\5\36\20\2\u00b4\u00e7\3\2\2\2\u00b5"+
		"\u00b6\5 \21\2\u00b6\u00b7\5\62\32\2\u00b7\u00b8\5\36\20\2\u00b8\u00b9"+
		"\7\25\2\2\u00b9\u00e7\3\2\2\2\u00ba\u00e7\5\34\17\2\u00bb\u00bc\7\5\2"+
		"\2\u00bc\u00bd\7\32\2\2\u00bd\u00be\5\36\20\2\u00be\u00bf\7\33\2\2\u00bf"+
		"\u00c2\5\30\r\2\u00c0\u00c1\7\6\2\2\u00c1\u00c3\5\30\r\2\u00c2\u00c0\3"+
		"\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00e7\3\2\2\2\u00c4\u00c5\7\b\2\2\u00c5"+
		"\u00c6\7\32\2\2\u00c6\u00c7\5\36\20\2\u00c7\u00c8\7\33\2\2\u00c8\u00c9"+
		"\5\30\r\2\u00c9\u00e7\3\2\2\2\u00ca\u00cb\5 \21\2\u00cb\u00cc\7+\2\2\u00cc"+
		"\u00cd\5\36\20\2\u00cd\u00ce\7\25\2\2\u00ce\u00e7\3\2\2\2\u00cf\u00d0"+
		"\7\t\2\2\u00d0\u00d1\5\36\20\2\u00d1\u00d2\7\25\2\2\u00d2\u00e7\3\2\2"+
		"\2\u00d3\u00d4\7\7\2\2\u00d4\u00d7\5\20\t\2\u00d5\u00d6\7+\2\2\u00d6\u00d8"+
		"\5\"\22\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2"+
		"\u00d9\u00e0\7\34\2\2\u00da\u00dd\5\20\t\2\u00db\u00dc\7+\2\2\u00dc\u00de"+
		"\5\"\22\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e1\3\2\2\2"+
		"\u00df\u00e1\5\"\22\2\u00e0\u00da\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e3\5\30\r\2\u00e3\u00e7\3\2\2\2\u00e4\u00e5\7\n\2\2"+
		"\u00e5\u00e7\7\25\2\2\u00e6\u00b1\3\2\2\2\u00e6\u00b5\3\2\2\2\u00e6\u00ba"+
		"\3\2\2\2\u00e6\u00bb\3\2\2\2\u00e6\u00c4\3\2\2\2\u00e6\u00ca\3\2\2\2\u00e6"+
		"\u00cf\3\2\2\2\u00e6\u00d3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\33\3\2\2"+
		"\2\u00e8\u00e9\5\64\33\2\u00e9\u00f2\7\32\2\2\u00ea\u00ef\5\36\20\2\u00eb"+
		"\u00ec\7\34\2\2\u00ec\u00ee\5\36\20\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00ea\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2"+
		"\2\2\u00f4\u00f6\7\33\2\2\u00f5\u00f7\7\25\2\2\u00f6\u00f5\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\35\3\2\2\2\u00f8\u00f9\b\20\1\2\u00f9\u0105\5 \21"+
		"\2\u00fa\u0105\5*\26\2\u00fb\u00fc\7 \2\2\u00fc\u0105\5\36\20\6\u00fd"+
		"\u0105\5\34\17\2\u00fe\u00ff\7&\2\2\u00ff\u0105\5\36\20\4\u0100\u0101"+
		"\7\32\2\2\u0101\u0102\5\36\20\2\u0102\u0103\7\33\2\2\u0103\u0105\3\2\2"+
		"\2\u0104\u00f8\3\2\2\2\u0104\u00fa\3\2\2\2\u0104\u00fb\3\2\2\2\u0104\u00fd"+
		"\3\2\2\2\u0104\u00fe\3\2\2\2\u0104\u0100\3\2\2\2\u0105\u010c\3\2\2\2\u0106"+
		"\u0107\f\7\2\2\u0107\u0108\5,\27\2\u0108\u0109\5\36\20\b\u0109\u010b\3"+
		"\2\2\2\u010a\u0106\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\37\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0112\5\20\t"+
		"\2\u0110\u0112\5\f\7\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112!"+
		"\3\2\2\2\u0113\u0114\t\2\2\2\u0114#\3\2\2\2\u0115\u0116\t\3\2\2\u0116"+
		"%\3\2\2\2\u0117\u0118\t\4\2\2\u0118\'\3\2\2\2\u0119\u011a\t\5\2\2\u011a"+
		")\3\2\2\2\u011b\u011f\5\"\22\2\u011c\u011f\7\67\2\2\u011d\u011f\7\66\2"+
		"\2\u011e\u011b\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011f+"+
		"\3\2\2\2\u0120\u0125\5.\30\2\u0121\u0125\5$\23\2\u0122\u0125\5&\24\2\u0123"+
		"\u0125\5(\25\2\u0124\u0120\3\2\2\2\u0124\u0121\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0124\u0123\3\2\2\2\u0125-\3\2\2\2\u0126\u0127\t\6\2\2\u0127/\3\2"+
		"\2\2\u0128\u012f\7\16\2\2\u0129\u012f\7\17\2\2\u012a\u012f\7\f\2\2\u012b"+
		"\u012c\7\23\2\2\u012c\u012f\7\61\2\2\u012d\u012f\5\22\n\2\u012e\u0128"+
		"\3\2\2\2\u012e\u0129\3\2\2\2\u012e\u012a\3\2\2\2\u012e\u012b\3\2\2\2\u012e"+
		"\u012d\3\2\2\2\u012f\61\3\2\2\2\u0130\u0131\t\7\2\2\u0131\63\3\2\2\2\u0132"+
		"\u0133\7\61\2\2\u0133\65\3\2\2\2!<FU`inrw~\u0080\u008d\u0095\u0098\u009f"+
		"\u00a4\u00a6\u00ac\u00c2\u00d7\u00dd\u00e0\u00e6\u00ef\u00f2\u00f6\u0104"+
		"\u010c\u0111\u011e\u0124\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}