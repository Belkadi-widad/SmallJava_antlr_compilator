// Generated from C:/Users/TRIUMPHAL/IdeaProjects/PROJET_COMPIL_WS\Expr_arithm.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Expr_arithmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, Modificateur=12, ID_Class=13, ID=14, WS=15, RL=16, 
		Speciaux=17, Comments=18, Comment=19, Cst=20, Par_Ouv=21, Par_Fer=22, 
		Affect=23, Plus=24, Sous=25, Mul_div_mod=26, Pv=27, Ac_fer=28, TYPE=29, 
		Cst_reel=30, SIGN=31, Neg=32, ET=33, OU=34, Comparateur=35, Guillemet=36, 
		Signe_formatage=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "Modificateur", "ID_Class", "ID", "WS", "RL", "Speciaux", 
			"Comments", "Comment", "Cst", "Par_Ouv", "Par_Fer", "Affect", "Plus", 
			"Sous", "Mul_div_mod", "Pv", "Ac_fer", "TYPE", "Cst_reel", "SIGN", "Neg", 
			"ET", "OU", "Comparateur", "Guillemet", "Signe_formatage"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class_SJ'", "'{'", "'main_SJ'", "'import Small_Java.lang'", "'import Small_Java.io'", 
			"','", "'In_SJ'", "'Out_SJ'", "'Si'", "'Alors'", "'Sinon'", null, null, 
			null, null, null, null, null, null, null, "'('", "')'", "':='", "'+'", 
			"'-'", null, "';'", "'}'", null, null, null, "'!'", "'&'", "'|'", null, 
			"'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"Modificateur", "ID_Class", "ID", "WS", "RL", "Speciaux", "Comments", 
			"Comment", "Cst", "Par_Ouv", "Par_Fer", "Affect", "Plus", "Sous", "Mul_div_mod", 
			"Pv", "Ac_fer", "TYPE", "Cst_reel", "SIGN", "Neg", "ET", "OU", "Comparateur", 
			"Guillemet", "Signe_formatage"
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


	public Expr_arithmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr_arithm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0150\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ba\n\r\3"+
		"\16\3\16\7\16\u00be\n\16\f\16\16\16\u00c1\13\16\3\17\6\17\u00c4\n\17\r"+
		"\17\16\17\u00c5\3\17\7\17\u00c9\n\17\f\17\16\17\u00cc\13\17\3\20\6\20"+
		"\u00cf\n\20\r\20\16\20\u00d0\3\20\3\20\3\21\6\21\u00d6\n\21\r\21\16\21"+
		"\u00d7\3\22\7\22\u00db\n\22\f\22\16\22\u00de\13\22\3\23\3\23\3\23\3\23"+
		"\7\23\u00e4\n\23\f\23\16\23\u00e7\13\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\7\24\u00f2\n\24\f\24\16\24\u00f5\13\24\3\24\3\24\3\25"+
		"\3\25\3\25\6\25\u00fc\n\25\r\25\16\25\u00fd\5\25\u0100\n\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u012a\n\36\3\37"+
		"\3\37\3\37\7\37\u012f\n\37\f\37\16\37\u0132\13\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0145\n$\3%\3%\3&\3&\3&\3&\3&\3&"+
		"\5&\u014f\n&\4\u00e5\u00f3\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\13\3\2C\\\5\2\62;"+
		"C\\c|\4\2C\\c|\5\2\13\f\17\17\"\"\3\2\f\f\3\2\62;\3\2\63;\5\2\'\',,\61"+
		"\61\4\2--//\2\u0164\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5V\3\2\2\2\7X"+
		"\3\2\2\2\t`\3\2\2\2\13w\3\2\2\2\r\u008c\3\2\2\2\17\u008e\3\2\2\2\21\u0094"+
		"\3\2\2\2\23\u009b\3\2\2\2\25\u009e\3\2\2\2\27\u00a4\3\2\2\2\31\u00b9\3"+
		"\2\2\2\33\u00bb\3\2\2\2\35\u00c3\3\2\2\2\37\u00ce\3\2\2\2!\u00d5\3\2\2"+
		"\2#\u00dc\3\2\2\2%\u00df\3\2\2\2\'\u00ed\3\2\2\2)\u00ff\3\2\2\2+\u0101"+
		"\3\2\2\2-\u0103\3\2\2\2/\u0105\3\2\2\2\61\u0108\3\2\2\2\63\u010a\3\2\2"+
		"\2\65\u010c\3\2\2\2\67\u010e\3\2\2\29\u0110\3\2\2\2;\u0129\3\2\2\2=\u012b"+
		"\3\2\2\2?\u0133\3\2\2\2A\u0135\3\2\2\2C\u0137\3\2\2\2E\u0139\3\2\2\2G"+
		"\u0144\3\2\2\2I\u0146\3\2\2\2K\u014e\3\2\2\2MN\7e\2\2NO\7n\2\2OP\7c\2"+
		"\2PQ\7u\2\2QR\7u\2\2RS\7a\2\2ST\7U\2\2TU\7L\2\2U\4\3\2\2\2VW\7}\2\2W\6"+
		"\3\2\2\2XY\7o\2\2YZ\7c\2\2Z[\7k\2\2[\\\7p\2\2\\]\7a\2\2]^\7U\2\2^_\7L"+
		"\2\2_\b\3\2\2\2`a\7k\2\2ab\7o\2\2bc\7r\2\2cd\7q\2\2de\7t\2\2ef\7v\2\2"+
		"fg\7\"\2\2gh\7U\2\2hi\7o\2\2ij\7c\2\2jk\7n\2\2kl\7n\2\2lm\7a\2\2mn\7L"+
		"\2\2no\7c\2\2op\7x\2\2pq\7c\2\2qr\7\60\2\2rs\7n\2\2st\7c\2\2tu\7p\2\2"+
		"uv\7i\2\2v\n\3\2\2\2wx\7k\2\2xy\7o\2\2yz\7r\2\2z{\7q\2\2{|\7t\2\2|}\7"+
		"v\2\2}~\7\"\2\2~\177\7U\2\2\177\u0080\7o\2\2\u0080\u0081\7c\2\2\u0081"+
		"\u0082\7n\2\2\u0082\u0083\7n\2\2\u0083\u0084\7a\2\2\u0084\u0085\7L\2\2"+
		"\u0085\u0086\7c\2\2\u0086\u0087\7x\2\2\u0087\u0088\7c\2\2\u0088\u0089"+
		"\7\60\2\2\u0089\u008a\7k\2\2\u008a\u008b\7q\2\2\u008b\f\3\2\2\2\u008c"+
		"\u008d\7.\2\2\u008d\16\3\2\2\2\u008e\u008f\7K\2\2\u008f\u0090\7p\2\2\u0090"+
		"\u0091\7a\2\2\u0091\u0092\7U\2\2\u0092\u0093\7L\2\2\u0093\20\3\2\2\2\u0094"+
		"\u0095\7Q\2\2\u0095\u0096\7w\2\2\u0096\u0097\7v\2\2\u0097\u0098\7a\2\2"+
		"\u0098\u0099\7U\2\2\u0099\u009a\7L\2\2\u009a\22\3\2\2\2\u009b\u009c\7"+
		"U\2\2\u009c\u009d\7k\2\2\u009d\24\3\2\2\2\u009e\u009f\7C\2\2\u009f\u00a0"+
		"\7n\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"\26\3\2\2\2\u00a4\u00a5\7U\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7p\2\2\u00a7"+
		"\u00a8\7q\2\2\u00a8\u00a9\7p\2\2\u00a9\30\3\2\2\2\u00aa\u00ab\7r\2\2\u00ab"+
		"\u00ac\7w\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7k\2\2"+
		"\u00af\u00ba\7e\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3"+
		"\7q\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7e\2\2\u00b6"+
		"\u00b7\7v\2\2\u00b7\u00b8\7g\2\2\u00b8\u00ba\7f\2\2\u00b9\u00aa\3\2\2"+
		"\2\u00b9\u00b0\3\2\2\2\u00ba\32\3\2\2\2\u00bb\u00bf\t\2\2\2\u00bc\u00be"+
		"\t\3\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\34\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\t\4\2"+
		"\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00ca\3\2\2\2\u00c7\u00c9\t\3\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\36\3\2\2"+
		"\2\u00cc\u00ca\3\2\2\2\u00cd\u00cf\t\5\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\b\20\2\2\u00d3 \3\2\2\2\u00d4\u00d6\t\6\2\2\u00d5\u00d4\3\2\2\2"+
		"\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\"\3"+
		"\2\2\2\u00d9\u00db\t\5\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd$\3\2\2\2\u00de\u00dc\3\2\2\2"+
		"\u00df\u00e0\7\61\2\2\u00e0\u00e1\7,\2\2\u00e1\u00e5\3\2\2\2\u00e2\u00e4"+
		"\13\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e6\3\2\2\2"+
		"\u00e5\u00e3\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9"+
		"\7,\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\b\23\2\2"+
		"\u00ec&\3\2\2\2\u00ed\u00ee\7\61\2\2\u00ee\u00ef\7\61\2\2\u00ef\u00f3"+
		"\3\2\2\2\u00f0\u00f2\13\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2"+
		"\u00f3\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f6\u00f7\b\24\2\2\u00f7(\3\2\2\2\u00f8\u0100\t\7\2\2\u00f9"+
		"\u00fb\t\b\2\2\u00fa\u00fc\t\7\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00f8\3\2\2\2\u00ff\u00f9\3\2\2\2\u0100*\3\2\2\2\u0101\u0102\7*\2\2\u0102"+
		",\3\2\2\2\u0103\u0104\7+\2\2\u0104.\3\2\2\2\u0105\u0106\7<\2\2\u0106\u0107"+
		"\7?\2\2\u0107\60\3\2\2\2\u0108\u0109\7-\2\2\u0109\62\3\2\2\2\u010a\u010b"+
		"\7/\2\2\u010b\64\3\2\2\2\u010c\u010d\t\t\2\2\u010d\66\3\2\2\2\u010e\u010f"+
		"\7=\2\2\u010f8\3\2\2\2\u0110\u0111\7\177\2\2\u0111:\3\2\2\2\u0112\u0113"+
		"\7k\2\2\u0113\u0114\7p\2\2\u0114\u0115\7v\2\2\u0115\u0116\7a\2\2\u0116"+
		"\u0117\7U\2\2\u0117\u012a\7L\2\2\u0118\u0119\7h\2\2\u0119\u011a\7n\2\2"+
		"\u011a\u011b\7q\2\2\u011b\u011c\7c\2\2\u011c\u011d\7v\2\2\u011d\u011e"+
		"\7a\2\2\u011e\u011f\7U\2\2\u011f\u012a\7L\2\2\u0120\u0121\7u\2\2\u0121"+
		"\u0122\7v\2\2\u0122\u0123\7t\2\2\u0123\u0124\7k\2\2\u0124\u0125\7p\2\2"+
		"\u0125\u0126\7i\2\2\u0126\u0127\7a\2\2\u0127\u0128\7U\2\2\u0128\u012a"+
		"\7L\2\2\u0129\u0112\3\2\2\2\u0129\u0118\3\2\2\2\u0129\u0120\3\2\2\2\u012a"+
		"<\3\2\2\2\u012b\u012c\5)\25\2\u012c\u0130\7\60\2\2\u012d\u012f\t\7\2\2"+
		"\u012e\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131"+
		"\3\2\2\2\u0131>\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\t\n\2\2\u0134"+
		"@\3\2\2\2\u0135\u0136\7#\2\2\u0136B\3\2\2\2\u0137\u0138\7(\2\2\u0138D"+
		"\3\2\2\2\u0139\u013a\7~\2\2\u013aF\3\2\2\2\u013b\u0145\7@\2\2\u013c\u013d"+
		"\7@\2\2\u013d\u0145\7?\2\2\u013e\u0145\7?\2\2\u013f\u0140\7#\2\2\u0140"+
		"\u0145\7?\2\2\u0141\u0142\7>\2\2\u0142\u0145\7?\2\2\u0143\u0145\7>\2\2"+
		"\u0144\u013b\3\2\2\2\u0144\u013c\3\2\2\2\u0144\u013e\3\2\2\2\u0144\u013f"+
		"\3\2\2\2\u0144\u0141\3\2\2\2\u0144\u0143\3\2\2\2\u0145H\3\2\2\2\u0146"+
		"\u0147\7$\2\2\u0147J\3\2\2\2\u0148\u0149\7\'\2\2\u0149\u014f\7f\2\2\u014a"+
		"\u014b\7\'\2\2\u014b\u014f\7h\2\2\u014c\u014d\7\'\2\2\u014d\u014f\7u\2"+
		"\2\u014e\u0148\3\2\2\2\u014e\u014a\3\2\2\2\u014e\u014c\3\2\2\2\u014fL"+
		"\3\2\2\2\22\2\u00b9\u00bf\u00c5\u00ca\u00d0\u00d7\u00dc\u00e5\u00f3\u00fd"+
		"\u00ff\u0129\u0130\u0144\u014e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}