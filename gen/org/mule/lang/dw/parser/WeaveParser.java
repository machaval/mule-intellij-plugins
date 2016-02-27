// This is a generated file. Not intended for manual editing.
package org.mule.lang.dw.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.mule.lang.dw.parser.psi.WeaveTypes.*;
import static org.mule.lang.dw.parser.WeaveParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WeaveParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ADDITION_SUBTRACTION_EXPRESSION) {
      r = Expression(b, 0, 11);
    }
    else if (t == AND_EXPRESSION) {
      r = Expression(b, 0, 7);
    }
    else if (t == ANY_DATE_LITERAL) {
      r = AnyDateLiteral(b, 0);
    }
    else if (t == ANY_REGEX_LITERAL) {
      r = AnyRegexLiteral(b, 0);
    }
    else if (t == ARRAY_ELEMENT) {
      r = ArrayElement(b, 0);
    }
    else if (t == ARRAY_EXPRESSION) {
      r = ArrayExpression(b, 0);
    }
    else if (t == AS_EXPRESSION) {
      r = Expression(b, 0, 4);
    }
    else if (t == ATTRIBUTE) {
      r = Attribute(b, 0);
    }
    else if (t == ATTRIBUTE_ELEMENT) {
      r = AttributeElement(b, 0);
    }
    else if (t == ATTRIBUTE_SELECTOR) {
      r = AttributeSelector(b, 0);
    }
    else if (t == ATTRIBUTES) {
      r = Attributes(b, 0);
    }
    else if (t == BINARY_CLOJURE_EXPRESSION) {
      r = Expression(b, 0, 0);
    }
    else if (t == BINARY_EXPRESSION) {
      r = Expression(b, 0, 3);
    }
    else if (t == BODY) {
      r = Body(b, 0);
    }
    else if (t == BOOLEAN_LITERAL) {
      r = BooleanLiteral(b, 0);
    }
    else if (t == BRACKET_SELECTOR_EXPRESSION) {
      r = Expression(b, 0, 16);
    }
    else if (t == CLOJURE_LITERAL_EXPRESSION) {
      r = ClojureLiteralExpression(b, 0);
    }
    else if (t == CLOJURE_WITH_ONE_PARAMETERS_EXPRESSION) {
      r = ClojureWithOneParametersExpression(b, 0);
    }
    else if (t == CLOJURE_WITHOUT_PARAMETERS_EXPRESSION) {
      r = ClojureWithoutParametersExpression(b, 0);
    }
    else if (t == CONDITIONAL_ARRAY_ELEMENT) {
      r = ConditionalArrayElement(b, 0);
    }
    else if (t == CONDITIONAL_ATTRIBUTE) {
      r = ConditionalAttribute(b, 0);
    }
    else if (t == CONDITIONAL_EXPRESSION) {
      r = Expression(b, 0, -1);
    }
    else if (t == CONDITIONAL_KEY_VALUE_PAIR) {
      r = ConditionalKeyValuePair(b, 0);
    }
    else if (t == DATA_TYPE) {
      r = DataType(b, 0);
    }
    else if (t == DEBUG_DIRECTIVE) {
      r = DebugDirective(b, 0);
    }
    else if (t == DECLARED_NAMESPACE) {
      r = DeclaredNamespace(b, 0);
    }
    else if (t == DEFAULT_PATTERN) {
      r = DefaultPattern(b, 0);
    }
    else if (t == DEFAULT_VALUE_EXPRESSION) {
      r = Expression(b, 0, 5);
    }
    else if (t == DIRECTIVE) {
      r = Directive(b, 0);
    }
    else if (t == DOCUMENT) {
      r = Document(b, 0);
    }
    else if (t == DOT_SELECTOR_EXPRESSION) {
      r = Expression(b, 0, 15);
    }
    else if (t == DYNAMIC_KEY_VALUE_PAIR) {
      r = DynamicKeyValuePair(b, 0);
    }
    else if (t == DYNAMIC_RANGE_EXPRESSION) {
      r = DynamicRangeExpression(b, 0);
    }
    else if (t == DYNAMIC_SELECTOR_EXPRESSION) {
      r = Expression(b, 0, 17);
    }
    else if (t == ENCLOSED_EXPRESSION) {
      r = EnclosedExpression(b, 0);
    }
    else if (t == EQUALITY_EXPRESSION) {
      r = Expression(b, 0, 8);
    }
    else if (t == EXPRESSION) {
      r = Expression(b, 0, -1);
    }
    else if (t == EXPRESSION_PATTERN) {
      r = ExpressionPattern(b, 0);
    }
    else if (t == FILTER_SELECTOR_EXPRESSION) {
      r = Expression(b, 0, 19);
    }
    else if (t == FUNCTION_CALL_EXPRESSION) {
      r = Expression(b, 0, 14);
    }
    else if (t == FUNCTION_DEFINITION) {
      r = FunctionDefinition(b, 0);
    }
    else if (t == FUNCTION_DIRECTIVE) {
      r = FunctionDirective(b, 0);
    }
    else if (t == FUNCTION_PARAMETER) {
      r = FunctionParameter(b, 0);
    }
    else if (t == GREATER_THAN_EXPRESSION) {
      r = Expression(b, 0, 10);
    }
    else if (t == HEADER) {
      r = Header(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = Identifier(b, 0);
    }
    else if (t == INPUT_DIRECTIVE) {
      r = InputDirective(b, 0);
    }
    else if (t == IS_EXPRESSION) {
      r = Expression(b, 0, 9);
    }
    else if (t == KEY) {
      r = Key(b, 0);
    }
    else if (t == KEY_EXPRESSION) {
      r = KeyExpression(b, 0);
    }
    else if (t == KEY_VALUE_PAIR) {
      r = KeyValuePair(b, 0);
    }
    else if (t == LAMBDA_LITERAL) {
      r = LambdaLiteral(b, 0);
    }
    else if (t == LITERAL_EXPRESSION) {
      r = LiteralExpression(b, 0);
    }
    else if (t == LITERAL_PATTERN) {
      r = LiteralPattern(b, 0);
    }
    else if (t == MATCH_EXPRESSION) {
      r = Expression(b, 0, 2);
    }
    else if (t == MULTI_VALUE_SELECTOR) {
      r = MultiValueSelector(b, 0);
    }
    else if (t == MULTIPLE_KEY_VALUE_PAIR_OBJ) {
      r = MultipleKeyValuePairObj(b, 0);
    }
    else if (t == MULTIPLICATION_DIVISION_EXPRESSION) {
      r = Expression(b, 0, 13);
    }
    else if (t == NAMED_LITERAL_PATTERN) {
      r = NamedLiteralPattern(b, 0);
    }
    else if (t == NAMED_REGEX_PATTERN) {
      r = NamedRegexPattern(b, 0);
    }
    else if (t == NAMED_TYPE_PATTERN) {
      r = NamedTypePattern(b, 0);
    }
    else if (t == NAMESPACE_DIRECTIVE) {
      r = NamespaceDirective(b, 0);
    }
    else if (t == NULL_LITERAL) {
      r = NullLiteral(b, 0);
    }
    else if (t == NUMBER_LITERAL) {
      r = NumberLiteral(b, 0);
    }
    else if (t == OBJECT_EXPRESSION) {
      r = ObjectExpression(b, 0);
    }
    else if (t == OPTION_ELEMENT) {
      r = OptionElement(b, 0);
    }
    else if (t == OPTIONS) {
      r = Options(b, 0);
    }
    else if (t == OR_EXPRESSION) {
      r = Expression(b, 0, 6);
    }
    else if (t == OUTPUT_DIRECTIVE) {
      r = OutputDirective(b, 0);
    }
    else if (t == PATTERN) {
      r = Pattern(b, 0);
    }
    else if (t == PATTERN_MATCHER_EXPRESSION) {
      r = PatternMatcherExpression(b, 0);
    }
    else if (t == RANGE_EXPRESSION) {
      r = RangeExpression(b, 0);
    }
    else if (t == RANGE_LITERAL) {
      r = RangeLiteral(b, 0);
    }
    else if (t == RANGE_SELECTOR_EXPRESSION) {
      r = Expression(b, 0, 18);
    }
    else if (t == REGEX_PATTERN) {
      r = RegexPattern(b, 0);
    }
    else if (t == RIGHT_LEFT_EXPRESSION) {
      r = Expression(b, 0, 12);
    }
    else if (t == SCHEMA) {
      r = Schema(b, 0);
    }
    else if (t == SCHEMA_ELEMENT) {
      r = SchemaElement(b, 0);
    }
    else if (t == SCHEMA_SELECTOR) {
      r = SchemaSelector(b, 0);
    }
    else if (t == SELECTOR) {
      r = Selector(b, 0);
    }
    else if (t == SIMPLE_ARRAY_ELEMENT) {
      r = SimpleArrayElement(b, 0);
    }
    else if (t == SIMPLE_KEY_VALUE_PAIR) {
      r = SimpleKeyValuePair(b, 0);
    }
    else if (t == SINGLE_KEY_VALUE_PAIR_OBJ) {
      r = SingleKeyValuePairObj(b, 0);
    }
    else if (t == STRING_LITERAL) {
      r = StringLiteral(b, 0);
    }
    else if (t == TERNARY_EXPRESSION) {
      r = Expression(b, 0, 1);
    }
    else if (t == TYPE_DEFINITION) {
      r = TypeDefinition(b, 0);
    }
    else if (t == TYPE_DIRECTIVE) {
      r = TypeDirective(b, 0);
    }
    else if (t == TYPE_LITERAL) {
      r = TypeLiteral(b, 0);
    }
    else if (t == TYPE_PATTERN) {
      r = TypePattern(b, 0);
    }
    else if (t == UNARY_EXPRESSION) {
      r = UnaryExpression(b, 0);
    }
    else if (t == USING_EXPRESSION) {
      r = UsingExpression(b, 0);
    }
    else if (t == VALUE_EXPRESSION) {
      r = ValueExpression(b, 0);
    }
    else if (t == VALUE_SELECTOR) {
      r = ValueSelector(b, 0);
    }
    else if (t == VARIABLE_DEFINITION) {
      r = VariableDefinition(b, 0);
    }
    else if (t == VARIABLE_DIRECTIVE) {
      r = VariableDirective(b, 0);
    }
    else if (t == VARIABLE_REFERENCE_EXPRESSION) {
      r = VariableReferenceExpression(b, 0);
    }
    else if (t == VERSION_DIRECTIVE) {
      r = VersionDirective(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(DEBUG_DIRECTIVE, DIRECTIVE, FUNCTION_DIRECTIVE, INPUT_DIRECTIVE,
      NAMESPACE_DIRECTIVE, OUTPUT_DIRECTIVE, TYPE_DIRECTIVE, VARIABLE_DIRECTIVE,
      VERSION_DIRECTIVE),
    create_token_set_(DEFAULT_PATTERN, EXPRESSION_PATTERN, LITERAL_PATTERN, NAMED_LITERAL_PATTERN,
      NAMED_REGEX_PATTERN, NAMED_TYPE_PATTERN, PATTERN, REGEX_PATTERN,
      TYPE_PATTERN),
    create_token_set_(ADDITION_SUBTRACTION_EXPRESSION, AND_EXPRESSION, ANY_DATE_LITERAL, ANY_REGEX_LITERAL,
      ARRAY_EXPRESSION, AS_EXPRESSION, BINARY_CLOJURE_EXPRESSION, BINARY_EXPRESSION,
      BOOLEAN_LITERAL, BRACKET_SELECTOR_EXPRESSION, CLOJURE_LITERAL_EXPRESSION, CLOJURE_WITHOUT_PARAMETERS_EXPRESSION,
      CLOJURE_WITH_ONE_PARAMETERS_EXPRESSION, CONDITIONAL_EXPRESSION, DEFAULT_VALUE_EXPRESSION, DOT_SELECTOR_EXPRESSION,
      DYNAMIC_RANGE_EXPRESSION, DYNAMIC_SELECTOR_EXPRESSION, ENCLOSED_EXPRESSION, EQUALITY_EXPRESSION,
      EXPRESSION, FILTER_SELECTOR_EXPRESSION, FUNCTION_CALL_EXPRESSION, GREATER_THAN_EXPRESSION,
      IS_EXPRESSION, KEY_EXPRESSION, LAMBDA_LITERAL, LITERAL_EXPRESSION,
      MATCH_EXPRESSION, MULTIPLICATION_DIVISION_EXPRESSION, NULL_LITERAL, NUMBER_LITERAL,
      OBJECT_EXPRESSION, OR_EXPRESSION, PATTERN_MATCHER_EXPRESSION, RANGE_EXPRESSION,
      RANGE_LITERAL, RANGE_SELECTOR_EXPRESSION, RIGHT_LEFT_EXPRESSION, STRING_LITERAL,
      TERNARY_EXPRESSION, TYPE_LITERAL, UNARY_EXPRESSION, USING_EXPRESSION,
      VALUE_EXPRESSION, VARIABLE_REFERENCE_EXPRESSION),
  };

  /* ********************************************************** */
  // RULE_ANY_DATE
  public static boolean AnyDateLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AnyDateLiteral")) return false;
    if (!nextTokenIs(b, RULE_ANY_DATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_ANY_DATE);
    exit_section_(b, m, ANY_DATE_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // RULE_ANY_REGEX
  public static boolean AnyRegexLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AnyRegexLiteral")) return false;
    if (!nextTokenIs(b, RULE_ANY_REGEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_ANY_REGEX);
    exit_section_(b, m, ANY_REGEX_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // ConditionalArrayElement
  //                 | SimpleArrayElement
  public static boolean ArrayElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<array element>");
    r = ConditionalArrayElement(b, l + 1);
    if (!r) r = SimpleArrayElement(b, l + 1);
    exit_section_(b, l, m, ARRAY_ELEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' ( ArrayElement ( ',' ArrayElement )* )? ']'
  public static boolean ArrayExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && ArrayExpression_1(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, ARRAY_EXPRESSION, r);
    return r;
  }

  // ( ArrayElement ( ',' ArrayElement )* )?
  private static boolean ArrayExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression_1")) return false;
    ArrayExpression_1_0(b, l + 1);
    return true;
  }

  // ArrayElement ( ',' ArrayElement )*
  private static boolean ArrayExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArrayElement(b, l + 1);
    r = r && ArrayExpression_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' ArrayElement )*
  private static boolean ArrayExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ArrayExpression_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArrayExpression_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' ArrayElement
  private static boolean ArrayExpression_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ArrayElement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KeyExpression ':' Expression
  public static boolean Attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<attribute>");
    r = KeyExpression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, ATTRIBUTE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ConditionalAttribute
  //            | Attribute
  //            | EnclosedExpression
  public static boolean AttributeElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<attribute element>");
    r = ConditionalAttribute(b, l + 1);
    if (!r) r = Attribute(b, l + 1);
    if (!r) r = EnclosedExpression(b, l + 1);
    exit_section_(b, l, m, ATTRIBUTE_ELEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '@'(DeclaredNamespace? (StringLiteral|Identifier))?
  public static boolean AttributeSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeSelector")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && AttributeSelector_1(b, l + 1);
    exit_section_(b, m, ATTRIBUTE_SELECTOR, r);
    return r;
  }

  // (DeclaredNamespace? (StringLiteral|Identifier))?
  private static boolean AttributeSelector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeSelector_1")) return false;
    AttributeSelector_1_0(b, l + 1);
    return true;
  }

  // DeclaredNamespace? (StringLiteral|Identifier)
  private static boolean AttributeSelector_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeSelector_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributeSelector_1_0_0(b, l + 1);
    r = r && AttributeSelector_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DeclaredNamespace?
  private static boolean AttributeSelector_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeSelector_1_0_0")) return false;
    DeclaredNamespace(b, l + 1);
    return true;
  }

  // StringLiteral|Identifier
  private static boolean AttributeSelector_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeSelector_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = StringLiteral(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '@(' ( AttributeElement ( ',' AttributeElement )* )? ')'
  public static boolean Attributes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<attributes>");
    r = consumeToken(b, "@(");
    r = r && Attributes_1(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    exit_section_(b, l, m, ATTRIBUTES, r, false, null);
    return r;
  }

  // ( AttributeElement ( ',' AttributeElement )* )?
  private static boolean Attributes_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes_1")) return false;
    Attributes_1_0(b, l + 1);
    return true;
  }

  // AttributeElement ( ',' AttributeElement )*
  private static boolean Attributes_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributeElement(b, l + 1);
    r = r && Attributes_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' AttributeElement )*
  private static boolean Attributes_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Attributes_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Attributes_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' AttributeElement
  private static boolean Attributes_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && AttributeElement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression
  public static boolean Body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<body>");
    r = Expression(b, l + 1, -1);
    exit_section_(b, l, m, BODY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TRUE_LITERAL
  //                         | FALSE_LITERAL
  public static boolean BooleanLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanLiteral")) return false;
    if (!nextTokenIs(b, "<boolean literal>", FALSE_LITERAL, TRUE_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<boolean literal>");
    r = consumeToken(b, TRUE_LITERAL);
    if (!r) r = consumeToken(b, FALSE_LITERAL);
    exit_section_(b, l, m, BOOLEAN_LITERAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ClojureLiteralExpression
  //            | ClojureWithOneParametersExpression
  //            | ClojureWithoutParametersExpression
  static boolean ClojureExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClojureLiteralExpression(b, l + 1);
    if (!r) r = ClojureWithOneParametersExpression(b, l + 1);
    if (!r) r = ClojureWithoutParametersExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' '(' ( FunctionParameter ( ',' FunctionParameter )* )? ')' '->' Expression ')'
  public static boolean ClojureLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureLiteralExpression")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && consumeToken(b, L_PARREN);
    r = r && ClojureLiteralExpression_2(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_PARREN);
    exit_section_(b, m, CLOJURE_LITERAL_EXPRESSION, r);
    return r;
  }

  // ( FunctionParameter ( ',' FunctionParameter )* )?
  private static boolean ClojureLiteralExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureLiteralExpression_2")) return false;
    ClojureLiteralExpression_2_0(b, l + 1);
    return true;
  }

  // FunctionParameter ( ',' FunctionParameter )*
  private static boolean ClojureLiteralExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureLiteralExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionParameter(b, l + 1);
    r = r && ClojureLiteralExpression_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' FunctionParameter )*
  private static boolean ClojureLiteralExpression_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureLiteralExpression_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ClojureLiteralExpression_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClojureLiteralExpression_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' FunctionParameter
  private static boolean ClojureLiteralExpression_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureLiteralExpression_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionParameter '->' Expression
  public static boolean ClojureWithOneParametersExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureWithOneParametersExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<clojure with one parameters expression>");
    r = FunctionParameter(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, CLOJURE_WITH_ONE_PARAMETERS_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression
  public static boolean ClojureWithoutParametersExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureWithoutParametersExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<clojure without parameters expression>");
    r = Expression(b, l + 1, -1);
    exit_section_(b, l, m, CLOJURE_WITHOUT_PARAMETERS_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' Expression ')' 'when' Expression
  public static boolean ConditionalArrayElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalArrayElement")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, WHEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, CONDITIONAL_ARRAY_ELEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // '(' KeyExpression ':' Expression ')' 'when' Expression
  public static boolean ConditionalAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAttribute")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && KeyExpression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, WHEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, CONDITIONAL_ATTRIBUTE, r);
    return r;
  }

  /* ********************************************************** */
  // '(' Key ':' Expression ')' 'when' Expression
  public static boolean ConditionalKeyValuePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalKeyValuePair")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && Key(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, WHEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, CONDITIONAL_KEY_VALUE_PAIR, r);
    return r;
  }

  /* ********************************************************** */
  // RULE_MIME_TYPE
  public static boolean DataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataType")) return false;
    if (!nextTokenIs(b, RULE_MIME_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_MIME_TYPE);
    exit_section_(b, m, DATA_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // '%debug' Options?
  public static boolean DebugDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DebugDirective")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<debug directive>");
    r = consumeToken(b, "%debug");
    p = r; // pin = 1
    r = r && DebugDirective_1(b, l + 1);
    exit_section_(b, l, m, DEBUG_DIRECTIVE, r, p, null);
    return r || p;
  }

  // Options?
  private static boolean DebugDirective_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DebugDirective_1")) return false;
    Options(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Identifier '#'
  public static boolean DeclaredNamespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeclaredNamespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<declared namespace>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, HASH);
    exit_section_(b, l, m, DECLARED_NAMESPACE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DEFAULT '->' Expression
  public static boolean DefaultPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefaultPattern")) return false;
    if (!nextTokenIs(b, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, DEFAULT_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // VersionDirective
  //            | NamespaceDirective
  //            | VariableDirective
  //            | OutputDirective
  //            | InputDirective
  //            | DebugDirective
  //            | TypeDirective
  //            | FunctionDirective
  //            | '%ast'
  public static boolean Directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Directive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<directive>");
    r = VersionDirective(b, l + 1);
    if (!r) r = NamespaceDirective(b, l + 1);
    if (!r) r = VariableDirective(b, l + 1);
    if (!r) r = OutputDirective(b, l + 1);
    if (!r) r = InputDirective(b, l + 1);
    if (!r) r = DebugDirective(b, l + 1);
    if (!r) r = TypeDirective(b, l + 1);
    if (!r) r = FunctionDirective(b, l + 1);
    if (!r) r = consumeToken(b, "%ast");
    exit_section_(b, l, m, DIRECTIVE, r, false, HeaderRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // Header? Body
  public static boolean Document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Document")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<document>");
    r = Document_0(b, l + 1);
    r = r && Body(b, l + 1);
    exit_section_(b, l, m, DOCUMENT, r, false, null);
    return r;
  }

  // Header?
  private static boolean Document_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Document_0")) return false;
    Header(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EnclosedExpression
  public static boolean DynamicKeyValuePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DynamicKeyValuePair")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnclosedExpression(b, l + 1);
    exit_section_(b, m, DYNAMIC_KEY_VALUE_PAIR, r);
    return r;
  }

  /* ********************************************************** */
  // '[' Expression RULE_WS+ '..' RULE_WS+ Expression ']'
  public static boolean DynamicRangeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DynamicRangeExpression")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && Expression(b, l + 1, -1);
    r = r && DynamicRangeExpression_2(b, l + 1);
    r = r && consumeToken(b, "..");
    r = r && DynamicRangeExpression_4(b, l + 1);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, DYNAMIC_RANGE_EXPRESSION, r);
    return r;
  }

  // RULE_WS+
  private static boolean DynamicRangeExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DynamicRangeExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_WS);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, RULE_WS)) break;
      if (!empty_element_parsed_guard_(b, "DynamicRangeExpression_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // RULE_WS+
  private static boolean DynamicRangeExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DynamicRangeExpression_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_WS);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, RULE_WS)) break;
      if (!empty_element_parsed_guard_(b, "DynamicRangeExpression_4", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' Expression ')'
  public static boolean EnclosedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnclosedExpression")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_PARREN);
    exit_section_(b, m, ENCLOSED_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier 'when' Expression '->' Expression
  public static boolean ExpressionPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<expression pattern>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, WHEN);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, EXPRESSION_PATTERN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier L_PARREN ( FunctionParameter ( ',' FunctionParameter )* )? R_PARREN Expression
  public static boolean FunctionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<function definition>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, L_PARREN);
    r = r && FunctionDefinition_2(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, FUNCTION_DEFINITION, r, false, null);
    return r;
  }

  // ( FunctionParameter ( ',' FunctionParameter )* )?
  private static boolean FunctionDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_2")) return false;
    FunctionDefinition_2_0(b, l + 1);
    return true;
  }

  // FunctionParameter ( ',' FunctionParameter )*
  private static boolean FunctionDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionParameter(b, l + 1);
    r = r && FunctionDefinition_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' FunctionParameter )*
  private static boolean FunctionDefinition_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionDefinition_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionDefinition_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' FunctionParameter
  private static boolean FunctionDefinition_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '%function' FunctionDefinition
  public static boolean FunctionDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDirective")) return false;
    if (!nextTokenIs(b, FUNCTION_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, FUNCTION_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && FunctionDefinition(b, l + 1);
    exit_section_(b, l, m, FUNCTION_DIRECTIVE, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Identifier ( '=' Expression )?
  public static boolean FunctionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<function parameter>");
    r = Identifier(b, l + 1);
    r = r && FunctionParameter_1(b, l + 1);
    exit_section_(b, l, m, FUNCTION_PARAMETER, r, false, null);
    return r;
  }

  // ( '=' Expression )?
  private static boolean FunctionParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_1")) return false;
    FunctionParameter_1_0(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean FunctionParameter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Directive+ '---'
  public static boolean Header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<header>");
    r = Header_0(b, l + 1);
    r = r && consumeToken(b, DOCUMENT_SEPARATOR);
    exit_section_(b, l, m, HEADER, r, false, null);
    return r;
  }

  // Directive+
  private static boolean Header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Header_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Directive(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!Directive(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Header_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !('---'|'%output'|'%type'|'%function'|'%namespace'|'%var'|'%dw'|'%input')
  static boolean HeaderRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HeaderRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !HeaderRecover_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // '---'|'%output'|'%type'|'%function'|'%namespace'|'%var'|'%dw'|'%input'
  private static boolean HeaderRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HeaderRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOCUMENT_SEPARATOR);
    if (!r) r = consumeToken(b, OUTPUT_DIRECTIVE_KEYWORD);
    if (!r) r = consumeToken(b, TYPE_DIRECTIVE_KEYWORD);
    if (!r) r = consumeToken(b, FUNCTION_DIRECTIVE_KEYWORD);
    if (!r) r = consumeToken(b, NAMESPACE_DIRECTIVE_KEYWORD);
    if (!r) r = consumeToken(b, VAR_DIRECTIVE_KEYWORD);
    if (!r) r = consumeToken(b, VERSION_DIRECTIVE_KEYWORD);
    if (!r) r = consumeToken(b, INPUT_DIRECTIVE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '$$'| ID | '$' | "true" | "false" | "null"
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<identifier>");
    r = consumeToken(b, "$$");
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, TRUE_LITERAL);
    if (!r) r = consumeToken(b, FALSE_LITERAL);
    if (!r) r = consumeToken(b, RULE_NULL_LITERAL);
    exit_section_(b, l, m, IDENTIFIER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%input' Identifier DataType Options?
  public static boolean InputDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InputDirective")) return false;
    if (!nextTokenIs(b, INPUT_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, INPUT_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, Identifier(b, l + 1));
    r = p && report_error_(b, DataType(b, l + 1)) && r;
    r = p && InputDirective_3(b, l + 1) && r;
    exit_section_(b, l, m, INPUT_DIRECTIVE, r, p, null);
    return r || p;
  }

  // Options?
  private static boolean InputDirective_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InputDirective_3")) return false;
    Options(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KeyExpression Attributes?
  public static boolean Key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key>");
    r = KeyExpression(b, l + 1);
    r = r && Key_1(b, l + 1);
    exit_section_(b, l, m, KEY, r, false, null);
    return r;
  }

  // Attributes?
  private static boolean Key_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Key_1")) return false;
    Attributes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DeclaredNamespace? (Identifier
  //            | StringLiteral
  //            | EnclosedExpression)
  public static boolean KeyExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<key expression>");
    r = KeyExpression_0(b, l + 1);
    r = r && KeyExpression_1(b, l + 1);
    exit_section_(b, l, m, KEY_EXPRESSION, r, false, null);
    return r;
  }

  // DeclaredNamespace?
  private static boolean KeyExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyExpression_0")) return false;
    DeclaredNamespace(b, l + 1);
    return true;
  }

  // Identifier
  //            | StringLiteral
  //            | EnclosedExpression
  private static boolean KeyExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    if (!r) r = EnclosedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ConditionalKeyValuePair
  //            | SimpleKeyValuePair
  public static boolean KeyValuePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key value pair>");
    r = ConditionalKeyValuePair(b, l + 1);
    if (!r) r = SimpleKeyValuePair(b, l + 1);
    exit_section_(b, l, m, KEY_VALUE_PAIR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (KeyValuePair | DynamicKeyValuePair) (',' | &'}')
  static boolean KeyValuePairWithComma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePairWithComma")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KeyValuePairWithComma_0(b, l + 1);
    r = r && KeyValuePairWithComma_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KeyValuePair | DynamicKeyValuePair
  private static boolean KeyValuePairWithComma_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePairWithComma_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KeyValuePair(b, l + 1);
    if (!r) r = DynamicKeyValuePair(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' | &'}'
  private static boolean KeyValuePairWithComma_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePairWithComma_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = KeyValuePairWithComma_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean KeyValuePairWithComma_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePairWithComma_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, R_CURLY);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' ( FunctionParameter ( ',' FunctionParameter )* )? ')' '->' Expression
  public static boolean LambdaLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && LambdaLiteral_1(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, LAMBDA_LITERAL, r);
    return r;
  }

  // ( FunctionParameter ( ',' FunctionParameter )* )?
  private static boolean LambdaLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_1")) return false;
    LambdaLiteral_1_0(b, l + 1);
    return true;
  }

  // FunctionParameter ( ',' FunctionParameter )*
  private static boolean LambdaLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionParameter(b, l + 1);
    r = r && LambdaLiteral_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' FunctionParameter )*
  private static boolean LambdaLiteral_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!LambdaLiteral_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LambdaLiteral_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' FunctionParameter
  private static boolean LambdaLiteral_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BooleanLiteral
  //            | NullLiteral
  //            | StringLiteral
  //            | NumberLiteral
  //            | AnyDateLiteral
  //            | AnyRegexLiteral
  //            | TypeLiteral
  //            | LambdaLiteral
  public static boolean LiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<literal expression>");
    r = BooleanLiteral(b, l + 1);
    if (!r) r = NullLiteral(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    if (!r) r = NumberLiteral(b, l + 1);
    if (!r) r = AnyDateLiteral(b, l + 1);
    if (!r) r = AnyRegexLiteral(b, l + 1);
    if (!r) r = TypeLiteral(b, l + 1);
    if (!r) r = LambdaLiteral(b, l + 1);
    exit_section_(b, l, m, LITERAL_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LiteralExpression '->' Expression
  public static boolean LiteralPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<literal pattern>");
    r = LiteralExpression(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, LITERAL_PATTERN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '*'(DeclaredNamespace? (StringLiteral|Identifier))
  public static boolean MultiValueSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiValueSelector")) return false;
    if (!nextTokenIs(b, MULTIPLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTIPLY);
    r = r && MultiValueSelector_1(b, l + 1);
    exit_section_(b, m, MULTI_VALUE_SELECTOR, r);
    return r;
  }

  // DeclaredNamespace? (StringLiteral|Identifier)
  private static boolean MultiValueSelector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiValueSelector_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MultiValueSelector_1_0(b, l + 1);
    r = r && MultiValueSelector_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DeclaredNamespace?
  private static boolean MultiValueSelector_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiValueSelector_1_0")) return false;
    DeclaredNamespace(b, l + 1);
    return true;
  }

  // StringLiteral|Identifier
  private static boolean MultiValueSelector_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiValueSelector_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = StringLiteral(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' KeyValuePairWithComma* '}'
  public static boolean MultipleKeyValuePairObj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultipleKeyValuePairObj")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && MultipleKeyValuePairObj_1(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, MULTIPLE_KEY_VALUE_PAIR_OBJ, r);
    return r;
  }

  // KeyValuePairWithComma*
  private static boolean MultipleKeyValuePairObj_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultipleKeyValuePairObj_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!KeyValuePairWithComma(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MultipleKeyValuePairObj_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // Identifier ':' LiteralExpression '->' Expression
  public static boolean NamedLiteralPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedLiteralPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<named literal pattern>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && LiteralExpression(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, NAMED_LITERAL_PATTERN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier ":" AnyRegexLiteral '->' Expression
  public static boolean NamedRegexPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedRegexPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<named regex pattern>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && AnyRegexLiteral(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, NAMED_REGEX_PATTERN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier "is" TypeLiteral '->' Expression
  public static boolean NamedTypePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedTypePattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<named type pattern>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, "is");
    r = r && TypeLiteral(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, NAMED_TYPE_PATTERN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%namespace' Identifier NAMESPACE_URI
  public static boolean NamespaceDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamespaceDirective")) return false;
    if (!nextTokenIs(b, NAMESPACE_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, NAMESPACE_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, Identifier(b, l + 1));
    r = p && consumeToken(b, NAMESPACE_URI) && r;
    exit_section_(b, l, m, NAMESPACE_DIRECTIVE, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // RULE_NULL_LITERAL
  public static boolean NullLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NullLiteral")) return false;
    if (!nextTokenIs(b, RULE_NULL_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_NULL_LITERAL);
    exit_section_(b, m, NULL_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_LITERAL|INTEGER_LITERAL
  public static boolean NumberLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumberLiteral")) return false;
    if (!nextTokenIs(b, "<number literal>", DOUBLE_LITERAL, INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<number literal>");
    r = consumeToken(b, DOUBLE_LITERAL);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    exit_section_(b, l, m, NUMBER_LITERAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SingleKeyValuePairObj | MultipleKeyValuePairObj
  public static boolean ObjectExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<object expression>");
    r = SingleKeyValuePairObj(b, l + 1);
    if (!r) r = MultipleKeyValuePairObj(b, l + 1);
    exit_section_(b, l, m, OBJECT_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier '=' LiteralExpression
  public static boolean OptionElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<option element>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && LiteralExpression(b, l + 1);
    exit_section_(b, l, m, OPTION_ELEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OptionElement ( ',' OptionElement )*
  public static boolean Options(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Options")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<options>");
    r = OptionElement(b, l + 1);
    r = r && Options_1(b, l + 1);
    exit_section_(b, l, m, OPTIONS, r, false, null);
    return r;
  }

  // ( ',' OptionElement )*
  private static boolean Options_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Options_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Options_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Options_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' OptionElement
  private static boolean Options_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Options_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && OptionElement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '%output' DataType Options?
  public static boolean OutputDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OutputDirective")) return false;
    if (!nextTokenIs(b, OUTPUT_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, OUTPUT_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, DataType(b, l + 1));
    r = p && OutputDirective_2(b, l + 1) && r;
    exit_section_(b, l, m, OUTPUT_DIRECTIVE, r, p, null);
    return r || p;
  }

  // Options?
  private static boolean OutputDirective_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OutputDirective_2")) return false;
    Options(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // RegexPattern | NamedRegexPattern | TypePattern | NamedTypePattern | LiteralPattern | NamedLiteralPattern | ExpressionPattern | DefaultPattern
  public static boolean Pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<pattern>");
    r = RegexPattern(b, l + 1);
    if (!r) r = NamedRegexPattern(b, l + 1);
    if (!r) r = TypePattern(b, l + 1);
    if (!r) r = NamedTypePattern(b, l + 1);
    if (!r) r = LiteralPattern(b, l + 1);
    if (!r) r = NamedLiteralPattern(b, l + 1);
    if (!r) r = ExpressionPattern(b, l + 1);
    if (!r) r = DefaultPattern(b, l + 1);
    exit_section_(b, l, m, PATTERN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' PatternWithComma+ '}'
  public static boolean PatternMatcherExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternMatcherExpression")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && PatternMatcherExpression_1(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, PATTERN_MATCHER_EXPRESSION, r);
    return r;
  }

  // PatternWithComma+
  private static boolean PatternMatcherExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternMatcherExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PatternWithComma(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!PatternWithComma(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PatternMatcherExpression_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (Pattern) (',' | &'}')
  static boolean PatternWithComma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternWithComma")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PatternWithComma_0(b, l + 1);
    r = r && PatternWithComma_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Pattern)
  private static boolean PatternWithComma_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternWithComma_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' | &'}'
  private static boolean PatternWithComma_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternWithComma_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = PatternWithComma_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean PatternWithComma_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternWithComma_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, R_CURLY);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RangeLiteral|DynamicRangeExpression
  public static boolean RangeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeExpression")) return false;
    if (!nextTokenIs(b, "<range expression>", L_BRACKET, RULE_RANGE_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<range expression>");
    r = RangeLiteral(b, l + 1);
    if (!r) r = DynamicRangeExpression(b, l + 1);
    exit_section_(b, l, m, RANGE_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RULE_RANGE_LITERAL
  public static boolean RangeLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeLiteral")) return false;
    if (!nextTokenIs(b, RULE_RANGE_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_RANGE_LITERAL);
    exit_section_(b, m, RANGE_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // RULE_ANY_REGEX '->' Expression
  public static boolean RegexPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexPattern")) return false;
    if (!nextTokenIs(b, RULE_ANY_REGEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_ANY_REGEX);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, REGEX_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // '{' ( SchemaElement ( ',' SchemaElement )* )? '}'
  public static boolean Schema(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Schema")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && Schema_1(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, SCHEMA, r);
    return r;
  }

  // ( SchemaElement ( ',' SchemaElement )* )?
  private static boolean Schema_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Schema_1")) return false;
    Schema_1_0(b, l + 1);
    return true;
  }

  // SchemaElement ( ',' SchemaElement )*
  private static boolean Schema_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Schema_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SchemaElement(b, l + 1);
    r = r && Schema_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' SchemaElement )*
  private static boolean Schema_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Schema_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Schema_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Schema_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' SchemaElement
  private static boolean Schema_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Schema_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && SchemaElement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier ':' LiteralExpression
  public static boolean SchemaElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SchemaElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<schema element>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && LiteralExpression(b, l + 1);
    exit_section_(b, l, m, SCHEMA_ELEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '^'(DeclaredNamespace? (StringLiteral|Identifier))?
  public static boolean SchemaSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SchemaSelector")) return false;
    if (!nextTokenIs(b, XOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, XOR);
    r = r && SchemaSelector_1(b, l + 1);
    exit_section_(b, m, SCHEMA_SELECTOR, r);
    return r;
  }

  // (DeclaredNamespace? (StringLiteral|Identifier))?
  private static boolean SchemaSelector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SchemaSelector_1")) return false;
    SchemaSelector_1_0(b, l + 1);
    return true;
  }

  // DeclaredNamespace? (StringLiteral|Identifier)
  private static boolean SchemaSelector_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SchemaSelector_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SchemaSelector_1_0_0(b, l + 1);
    r = r && SchemaSelector_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DeclaredNamespace?
  private static boolean SchemaSelector_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SchemaSelector_1_0_0")) return false;
    DeclaredNamespace(b, l + 1);
    return true;
  }

  // StringLiteral|Identifier
  private static boolean SchemaSelector_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SchemaSelector_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = StringLiteral(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ValueSelector |
  //          AttributeSelector |
  //          SchemaSelector |
  //          MultiValueSelector
  public static boolean Selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Selector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<selector>");
    r = ValueSelector(b, l + 1);
    if (!r) r = AttributeSelector(b, l + 1);
    if (!r) r = SchemaSelector(b, l + 1);
    if (!r) r = MultiValueSelector(b, l + 1);
    exit_section_(b, l, m, SELECTOR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression
  public static boolean SimpleArrayElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleArrayElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<simple array element>");
    r = Expression(b, l + 1, -1);
    exit_section_(b, l, m, SIMPLE_ARRAY_ELEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Key ':' Expression
  public static boolean SimpleKeyValuePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleKeyValuePair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<simple key value pair>");
    r = Key(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, SIMPLE_KEY_VALUE_PAIR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KeyValuePair
  public static boolean SingleKeyValuePairObj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SingleKeyValuePairObj")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<single key value pair obj>");
    r = KeyValuePair(b, l + 1);
    exit_section_(b, l, m, SINGLE_KEY_VALUE_PAIR_OBJ, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTED_STRING
  //                       | SINGLE_QUOTED_STRING
  public static boolean StringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringLiteral")) return false;
    if (!nextTokenIs(b, "<string literal>", DOUBLE_QUOTED_STRING, SINGLE_QUOTED_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<string literal>");
    r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    exit_section_(b, l, m, STRING_LITERAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier '=' TypeLiteral
  public static boolean TypeDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<type definition>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && TypeLiteral(b, l + 1);
    exit_section_(b, l, m, TYPE_DEFINITION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%type' TypeDefinition
  public static boolean TypeDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDirective")) return false;
    if (!nextTokenIs(b, TYPE_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, TYPE_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && TypeDefinition(b, l + 1);
    exit_section_(b, l, m, TYPE_DIRECTIVE, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // RULE_TYPE_ID Schema?
  public static boolean TypeLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeLiteral")) return false;
    if (!nextTokenIs(b, RULE_TYPE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_TYPE_ID);
    r = r && TypeLiteral_1(b, l + 1);
    exit_section_(b, m, TYPE_LITERAL, r);
    return r;
  }

  // Schema?
  private static boolean TypeLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeLiteral_1")) return false;
    Schema(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeLiteral '->' Expression
  public static boolean TypePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypePattern")) return false;
    if (!nextTokenIs(b, RULE_TYPE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeLiteral(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, TYPE_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // DeclaredNamespace? (StringLiteral|Identifier)
  public static boolean ValueSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueSelector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<value selector>");
    r = ValueSelector_0(b, l + 1);
    r = r && ValueSelector_1(b, l + 1);
    exit_section_(b, l, m, VALUE_SELECTOR, r, false, null);
    return r;
  }

  // DeclaredNamespace?
  private static boolean ValueSelector_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueSelector_0")) return false;
    DeclaredNamespace(b, l + 1);
    return true;
  }

  // StringLiteral|Identifier
  private static boolean ValueSelector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueSelector_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = StringLiteral(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier '='  Expression
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<Variable>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, VARIABLE_DEFINITION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%var' VariableDefinition
  public static boolean VariableDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDirective")) return false;
    if (!nextTokenIs(b, VAR_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, VAR_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && VariableDefinition(b, l + 1);
    exit_section_(b, l, m, VARIABLE_DIRECTIVE, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Identifier
  public static boolean VariableReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableReferenceExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variable reference expression>");
    r = Identifier(b, l + 1);
    exit_section_(b, l, m, VARIABLE_REFERENCE_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%dw'  DOUBLE_LITERAL
  public static boolean VersionDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VersionDirective")) return false;
    if (!nextTokenIs(b, VERSION_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, VERSION_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && consumeToken(b, DOUBLE_LITERAL);
    exit_section_(b, l, m, VERSION_DIRECTIVE, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Document
  static boolean root(PsiBuilder b, int l) {
    return Document(b, l + 1);
  }

  /* ********************************************************** */
  // Expression root: Expression
  // Operator priority table:
  // 0: BINARY(ConditionalExpression)
  // 1: POSTFIX(BinaryClojureExpression)
  // 2: BINARY(TernaryExpression)
  // 3: POSTFIX(MatchExpression)
  // 4: BINARY(BinaryExpression)
  // 5: BINARY(AsExpression)
  // 6: BINARY(DefaultValueExpression)
  // 7: BINARY(OrExpression)
  // 8: BINARY(AndExpression)
  // 9: BINARY(EqualityExpression)
  // 10: BINARY(IsExpression)
  // 11: BINARY(GreaterThanExpression)
  // 12: BINARY(AdditionSubtractionExpression)
  // 13: BINARY(RightLeftExpression)
  // 14: BINARY(MultiplicationDivisionExpression)
  // 15: POSTFIX(FunctionCallExpression)
  // 16: POSTFIX(DotSelectorExpression)
  // 17: POSTFIX(BracketSelectorExpression)
  // 18: BINARY(DynamicSelectorExpression)
  // 19: POSTFIX(RangeSelectorExpression)
  // 20: BINARY(FilterSelectorExpression)
  // 21: ATOM(UsingExpression)
  // 22: ATOM(UnaryExpression)
  // 23: ATOM(ValueExpression)
  public static boolean Expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = UsingExpression(b, l + 1);
    if (!r) r = UnaryExpression(b, l + 1);
    if (!r) r = ValueExpression(b, l + 1);
    p = r;
    r = r && Expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && ConditionalExpression_0(b, l + 1)) {
        r = report_error_(b, Expression(b, l, 0));
        r = ConditionalExpression_1(b, l + 1) && r;
        exit_section_(b, l, m, CONDITIONAL_EXPRESSION, r, true, null);
      }
      else if (g < 1 && BinaryClojureExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, BINARY_CLOJURE_EXPRESSION, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, REPLACE)) {
        r = report_error_(b, Expression(b, l, 2));
        r = TernaryExpression_1(b, l + 1) && r;
        exit_section_(b, l, m, TERNARY_EXPRESSION, r, true, null);
      }
      else if (g < 3 && MatchExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, MATCH_EXPRESSION, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, RULE_BINARY_OPERATORS)) {
        r = Expression(b, l, 4);
        exit_section_(b, l, m, BINARY_EXPRESSION, r, true, null);
      }
      else if (g < 5 && consumeTokenSmart(b, AS)) {
        r = Expression(b, l, 5);
        exit_section_(b, l, m, AS_EXPRESSION, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, DEFAULT)) {
        r = Expression(b, l, 6);
        exit_section_(b, l, m, DEFAULT_VALUE_EXPRESSION, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, OR_KEYWORD)) {
        r = Expression(b, l, 7);
        exit_section_(b, l, m, OR_EXPRESSION, r, true, null);
      }
      else if (g < 8 && consumeTokenSmart(b, AND_KEYWORD)) {
        r = Expression(b, l, 8);
        exit_section_(b, l, m, AND_EXPRESSION, r, true, null);
      }
      else if (g < 9 && EqualityExpression_0(b, l + 1)) {
        r = Expression(b, l, 9);
        exit_section_(b, l, m, EQUALITY_EXPRESSION, r, true, null);
      }
      else if (g < 10 && consumeTokenSmart(b, IS)) {
        r = Expression(b, l, 10);
        exit_section_(b, l, m, IS_EXPRESSION, r, true, null);
      }
      else if (g < 11 && GreaterThanExpression_0(b, l + 1)) {
        r = Expression(b, l, 11);
        exit_section_(b, l, m, GREATER_THAN_EXPRESSION, r, true, null);
      }
      else if (g < 12 && AdditionSubtractionExpression_0(b, l + 1)) {
        r = Expression(b, l, 12);
        exit_section_(b, l, m, ADDITION_SUBTRACTION_EXPRESSION, r, true, null);
      }
      else if (g < 13 && consumeTokenSmart(b, SHIFT_RIGHT)) {
        r = Expression(b, l, 13);
        exit_section_(b, l, m, RIGHT_LEFT_EXPRESSION, r, true, null);
      }
      else if (g < 14 && MultiplicationDivisionExpression_0(b, l + 1)) {
        r = Expression(b, l, 14);
        exit_section_(b, l, m, MULTIPLICATION_DIVISION_EXPRESSION, r, true, null);
      }
      else if (g < 15 && FunctionCallExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, FUNCTION_CALL_EXPRESSION, r, true, null);
      }
      else if (g < 16 && DotSelectorExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, DOT_SELECTOR_EXPRESSION, r, true, null);
      }
      else if (g < 17 && BracketSelectorExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, BRACKET_SELECTOR_EXPRESSION, r, true, null);
      }
      else if (g < 18 && consumeTokenSmart(b, L_BRACKET)) {
        r = report_error_(b, Expression(b, l, 18));
        r = consumeToken(b, R_BRACKET) && r;
        exit_section_(b, l, m, DYNAMIC_SELECTOR_EXPRESSION, r, true, null);
      }
      else if (g < 19 && consumeTokenSmart(b, RULE_RANGE_LITERAL)) {
        r = true;
        exit_section_(b, l, m, RANGE_SELECTOR_EXPRESSION, r, true, null);
      }
      else if (g < 20 && FilterSelectorExpression_0(b, l + 1)) {
        r = report_error_(b, Expression(b, l, 20));
        r = FilterSelectorExpression_1(b, l + 1) && r;
        exit_section_(b, l, m, FILTER_SELECTOR_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // WHEN | UNLESS
  private static boolean ConditionalExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, WHEN);
    if (!r) r = consumeTokenSmart(b, UNLESS);
    exit_section_(b, m, null, r);
    return r;
  }

  // OTHERWISE Expression
  private static boolean ConditionalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OTHERWISE);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RULE_BINARY_CLOJURE_OPERATORS ClojureExpression
  private static boolean BinaryClojureExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BinaryClojureExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, RULE_BINARY_CLOJURE_OPERATORS);
    r = r && ClojureExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WITH ClojureExpression
  private static boolean TernaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TernaryExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITH);
    r = r && ClojureExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RULE_MATCH_LITERAL (PatternMatcherExpression | Expression)
  private static boolean MatchExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, RULE_MATCH_LITERAL);
    r = r && MatchExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PatternMatcherExpression | Expression
  private static boolean MatchExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PatternMatcherExpression(b, l + 1);
    if (!r) r = Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '==' | '!=' | '~='
  private static boolean EqualityExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EqualityExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, EQUAL);
    if (!r) r = consumeTokenSmart(b, NOT_EQUAL);
    if (!r) r = consumeTokenSmart(b, SIMILAR);
    exit_section_(b, m, null, r);
    return r;
  }

  // '>' | '>=' | '<' | '<='
  private static boolean GreaterThanExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GreaterThanExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, GREATER);
    if (!r) r = consumeTokenSmart(b, GREATER_EQUAL);
    if (!r) r = consumeTokenSmart(b, LESS);
    if (!r) r = consumeTokenSmart(b, LESS_EQUAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' | '-'
  private static boolean AdditionSubtractionExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditionSubtractionExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, PLUS);
    if (!r) r = consumeTokenSmart(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  // '*' | '/'
  private static boolean MultiplicationDivisionExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicationDivisionExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, MULTIPLY);
    if (!r) r = consumeTokenSmart(b, DIVISION);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' ( Expression ( ',' Expression )* )? ')'
  private static boolean FunctionCallExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, L_PARREN);
    r = r && FunctionCallExpression_0_1(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( Expression ( ',' Expression )* )?
  private static boolean FunctionCallExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallExpression_0_1")) return false;
    FunctionCallExpression_0_1_0(b, l + 1);
    return true;
  }

  // Expression ( ',' Expression )*
  private static boolean FunctionCallExpression_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallExpression_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    r = r && FunctionCallExpression_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' Expression )*
  private static boolean FunctionCallExpression_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallExpression_0_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionCallExpression_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionCallExpression_0_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Expression
  private static boolean FunctionCallExpression_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallExpression_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( '..' | '.' ) Selector
  private static boolean DotSelectorExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DotSelectorExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DotSelectorExpression_0_0(b, l + 1);
    r = r && Selector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '..' | '.'
  private static boolean DotSelectorExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DotSelectorExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, "..");
    if (!r) r = consumeTokenSmart(b, ".");
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' Selector ']'
  private static boolean BracketSelectorExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BracketSelectorExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, L_BRACKET);
    r = r && Selector(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' '?' '('
  private static boolean FilterSelectorExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FilterSelectorExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, L_BRACKET);
    r = r && consumeToken(b, QUESTION);
    r = r && consumeToken(b, L_PARREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ')' ']'
  private static boolean FilterSelectorExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FilterSelectorExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, R_PARREN);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // USING '(' VariableDefinition ( ',' VariableDefinition )* ')' Expression
  public static boolean UsingExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsingExpression")) return false;
    if (!nextTokenIsFast(b, USING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, USING);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, L_PARREN));
    r = p && report_error_(b, VariableDefinition(b, l + 1)) && r;
    r = p && report_error_(b, UsingExpression_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, R_PARREN)) && r;
    r = p && Expression(b, l + 1, -1) && r;
    exit_section_(b, l, m, USING_EXPRESSION, r, p, null);
    return r || p;
  }

  // ( ',' VariableDefinition )*
  private static boolean UsingExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsingExpression_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!UsingExpression_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "UsingExpression_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' VariableDefinition
  private static boolean UsingExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsingExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && VariableDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RULE_UNARY_OPERATOS Expression
  public static boolean UnaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression")) return false;
    if (!nextTokenIsFast(b, RULE_UNARY_OPERATOS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, RULE_UNARY_OPERATOS);
    p = r; // pin = 1
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, UNARY_EXPRESSION, r, p, null);
    return r || p;
  }

  // ObjectExpression
  //                   |LiteralExpression
  //                   |RangeExpression
  //                   |ArrayExpression
  //                   |VariableReferenceExpression
  //                   |EnclosedExpression
  public static boolean ValueExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<value expression>");
    r = ObjectExpression(b, l + 1);
    if (!r) r = LiteralExpression(b, l + 1);
    if (!r) r = RangeExpression(b, l + 1);
    if (!r) r = ArrayExpression(b, l + 1);
    if (!r) r = VariableReferenceExpression(b, l + 1);
    if (!r) r = EnclosedExpression(b, l + 1);
    exit_section_(b, l, m, VALUE_EXPRESSION, r, false, null);
    return r;
  }

  final static Parser HeaderRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return HeaderRecover(b, l + 1);
    }
  };
}
