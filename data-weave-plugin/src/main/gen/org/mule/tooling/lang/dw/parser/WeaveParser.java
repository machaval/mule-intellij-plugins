// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.mule.tooling.lang.dw.parser.psi.WeaveTypes.*;
import static org.mule.tooling.lang.dw.parser.WeaveParserUtil.*;
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
    if (t == ANY_DATE_LITERAL) {
      r = AnyDateLiteral(b, 0);
    }
    else if (t == ANY_REGEX_LITERAL) {
      r = AnyRegexLiteral(b, 0);
    }
    else if (t == ARRAY_EXPRESSION) {
      r = ArrayExpression(b, 0);
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
    else if (t == ATTRIBUTES_TYPE) {
      r = AttributesType(b, 0);
    }
    else if (t == BODY) {
      r = Body(b, 0);
    }
    else if (t == BOOLEAN_LITERAL) {
      r = BooleanLiteral(b, 0);
    }
    else if (t == CONDITIONAL_ATTRIBUTE) {
      r = ConditionalAttribute(b, 0);
    }
    else if (t == CONDITIONAL_KEY_VALUE_PAIR) {
      r = ConditionalKeyValuePair(b, 0);
    }
    else if (t == CUSTOM_LOADER) {
      r = CustomLoader(b, 0);
    }
    else if (t == DATA_FORMAT) {
      r = DataFormat(b, 0);
    }
    else if (t == DECLARED_NAMESPACE) {
      r = DeclaredNamespace(b, 0);
    }
    else if (t == DEFAULT_PATTERN) {
      r = DefaultPattern(b, 0);
    }
    else if (t == DIRECTIVE) {
      r = Directive(b, 0);
    }
    else if (t == DOCUMENT) {
      r = Document(b, 0);
    }
    else if (t == DYNAMIC_KEY_VALUE_PAIR) {
      r = DynamicKeyValuePair(b, 0);
    }
    else if (t == DYNAMIC_RANGE_EXPRESSION) {
      r = DynamicRangeExpression(b, 0);
    }
    else if (t == ENCLOSED_EXPRESSION) {
      r = EnclosedExpression(b, 0);
    }
    else if (t == EXPRESSION) {
      r = Expression(b, 0, -1);
    }
    else if (t == EXPRESSION_PATTERN) {
      r = ExpressionPattern(b, 0);
    }
    else if (t == FQN_IDENTIFIER) {
      r = FqnIdentifier(b, 0);
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
    else if (t == HEADER) {
      r = Header(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = Identifier(b, 0);
    }
    else if (t == IDENTIFIER_PACKAGE) {
      r = IdentifierPackage(b, 0);
    }
    else if (t == IMPORT_DIRECTIVE) {
      r = ImportDirective(b, 0);
    }
    else if (t == IMPORTED_ELEMENT) {
      r = ImportedElement(b, 0);
    }
    else if (t == INPUT_DIRECTIVE) {
      r = InputDirective(b, 0);
    }
    else if (t == KEY) {
      r = Key(b, 0);
    }
    else if (t == KEY_EXPRESSION) {
      r = KeyExpression(b, 0);
    }
    else if (t == KEY_TYPE) {
      r = KeyType(b, 0);
    }
    else if (t == KEY_VALUE_PAIR) {
      r = KeyValuePair(b, 0);
    }
    else if (t == KEY_VALUE_PAIR_TYPE) {
      r = KeyValuePairType(b, 0);
    }
    else if (t == LAMBDA_LITERAL) {
      r = LambdaLiteral(b, 0);
    }
    else if (t == LAMBDA_TYPE_PARAMETER) {
      r = LambdaTypeParameter(b, 0);
    }
    else if (t == LITERAL_EXPRESSION) {
      r = LiteralExpression(b, 0);
    }
    else if (t == LITERAL_PATTERN) {
      r = LiteralPattern(b, 0);
    }
    else if (t == MULTI_VALUE_SELECTOR) {
      r = MultiValueSelector(b, 0);
    }
    else if (t == MULTIPLE_KEY_VALUE_PAIR_OBJ) {
      r = MultipleKeyValuePairObj(b, 0);
    }
    else if (t == NAME_TYPE) {
      r = NameType(b, 0);
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
    else if (t == REGEX_PATTERN) {
      r = RegexPattern(b, 0);
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
    else if (t == SIMPLE_KEY_VALUE_PAIR) {
      r = SimpleKeyValuePair(b, 0);
    }
    else if (t == SINGLE_KEY_VALUE_PAIR_OBJ) {
      r = SingleKeyValuePairObj(b, 0);
    }
    else if (t == STRING_LITERAL) {
      r = StringLiteral(b, 0);
    }
    else if (t == TYPE) {
      r = Type(b, 0, -1);
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
    else if (t == TYPE_PARAMETER) {
      r = TypeParameter(b, 0);
    }
    else if (t == TYPE_PATTERN) {
      r = TypePattern(b, 0);
    }
    else if (t == UNDEFINED_LITERAL) {
      r = UndefinedLiteral(b, 0);
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
    create_token_set_(DIRECTIVE, FUNCTION_DIRECTIVE, IMPORT_DIRECTIVE, INPUT_DIRECTIVE,
      NAMESPACE_DIRECTIVE, OUTPUT_DIRECTIVE, TYPE_DIRECTIVE, VARIABLE_DIRECTIVE,
      VERSION_DIRECTIVE),
    create_token_set_(DEFAULT_PATTERN, EXPRESSION_PATTERN, LITERAL_PATTERN, NAMED_LITERAL_PATTERN,
      NAMED_REGEX_PATTERN, NAMED_TYPE_PATTERN, PATTERN, REGEX_PATTERN,
      TYPE_PATTERN),
    create_token_set_(ARRAY_TYPE, ATTRIBUTES_TYPE, KEY_TYPE, KEY_VALUE_PAIR_TYPE,
      LAMBDA_TYPE, NAME_TYPE, OBJECT_TYPE, REFERENCE_TYPE,
      SIMPLE_TYPE, TYPE, TYPE_TYPE, UNION_TYPE),
    create_token_set_(ADDITION_SUBTRACTION_EXPRESSION, AND_EXPRESSION, ANY_DATE_LITERAL, ANY_REGEX_LITERAL,
      ARRAY_EXPRESSION, AS_EXPRESSION, BINARY_EXPRESSION, BOOLEAN_LITERAL,
      BRACKET_SELECTOR_EXPRESSION, CLOJURE_EXPRESSION, CONDITIONAL_EXPRESSION, DEFAULT_VALUE_EXPRESSION,
      DOT_SELECTOR_EXPRESSION, DYNAMIC_RANGE_EXPRESSION, DYNAMIC_SELECTOR_EXPRESSION, ENCLOSED_EXPRESSION,
      EQUALITY_EXPRESSION, EXPRESSION, FILTER_SELECTOR_EXPRESSION, FUNCTION_CALL_EXPRESSION,
      GREATER_THAN_EXPRESSION, IS_EXPRESSION, KEY_EXPRESSION, LAMBDA_LITERAL,
      LITERAL_EXPRESSION, MATCH_EXPRESSION, MULTIPLICATION_DIVISION_EXPRESSION, NULL_LITERAL,
      NUMBER_LITERAL, OBJECT_EXPRESSION, OR_EXPRESSION, PATTERN_MATCHER_EXPRESSION,
      RANGE_EXPRESSION, RANGE_LITERAL, RANGE_SELECTOR_EXPRESSION, RIGHT_LEFT_EXPRESSION,
      STRING_LITERAL, TYPE_LITERAL, UNDEFINED_LITERAL, USING_EXPRESSION,
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
  // Expression
  //                 | '(' Expression ')' 'when' Expression
  static boolean ArrayElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayElement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    if (!r) r = ArrayElement_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' Expression ')' 'when' Expression
  private static boolean ArrayElement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayElement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, WHEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
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
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE, "<attribute>");
    r = KeyExpression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ConditionalAttribute
  //            | Attribute
  //            | EnclosedExpression
  public static boolean AttributeElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_ELEMENT, "<attribute element>");
    r = ConditionalAttribute(b, l + 1);
    if (!r) r = Attribute(b, l + 1);
    if (!r) r = EnclosedExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTES, "<attributes>");
    r = consumeToken(b, "@(");
    r = r && Attributes_1(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    exit_section_(b, l, m, r, false, null);
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
  // "@""(" NameType ":" Type ")"
  public static boolean AttributesType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributesType")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTES_TYPE, null);
    r = consumeToken(b, AT);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, L_PARREN));
    r = p && report_error_(b, NameType(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && report_error_(b, Type(b, l + 1, -1)) && r;
    r = p && consumeToken(b, R_PARREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Expression
  public static boolean Body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY, "<body>");
    r = Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TRUE_LITERAL
  //                         | FALSE_LITERAL
  public static boolean BooleanLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanLiteral")) return false;
    if (!nextTokenIs(b, "<boolean literal>", FALSE_LITERAL, TRUE_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, TRUE_LITERAL);
    if (!r) r = consumeToken(b, FALSE_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' KeyExpression ':' Expression ')' 'when' Expression
  public static boolean ConditionalAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAttribute")) return false;
    if (!nextTokenIs(b, L_PARREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_ATTRIBUTE, null);
    r = consumeToken(b, L_PARREN);
    r = r && KeyExpression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, WHEN);
    p = r; // pin = 6
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // Identifier"!"
  public static boolean CustomLoader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomLoader")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CUSTOM_LOADER, "<custom loader>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, ESCLAMATION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RULE_MIME_TYPE
  public static boolean DataFormat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataFormat")) return false;
    if (!nextTokenIs(b, RULE_MIME_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_MIME_TYPE);
    exit_section_(b, m, DATA_FORMAT, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier '#'
  public static boolean DeclaredNamespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeclaredNamespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARED_NAMESPACE, "<declared namespace>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, HASH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OTHERWISE '->' Expression
  public static boolean DefaultPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefaultPattern")) return false;
    if (!nextTokenIs(b, OTHERWISE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OTHERWISE);
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
  //            | TypeDirective
  //            | ImportDirective
  //            | FunctionDirective
  public static boolean Directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Directive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, DIRECTIVE, "<directive>");
    r = VersionDirective(b, l + 1);
    if (!r) r = NamespaceDirective(b, l + 1);
    if (!r) r = VariableDirective(b, l + 1);
    if (!r) r = OutputDirective(b, l + 1);
    if (!r) r = InputDirective(b, l + 1);
    if (!r) r = TypeDirective(b, l + 1);
    if (!r) r = ImportDirective(b, l + 1);
    if (!r) r = FunctionDirective(b, l + 1);
    exit_section_(b, l, m, r, false, HeaderRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // Header ('---'  Body) ? | Body
  public static boolean Document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Document")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOCUMENT, "<document>");
    r = Document_0(b, l + 1);
    if (!r) r = Body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Header ('---'  Body) ?
  private static boolean Document_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Document_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Header(b, l + 1);
    r = r && Document_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('---'  Body) ?
  private static boolean Document_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Document_0_1")) return false;
    Document_0_1_0(b, l + 1);
    return true;
  }

  // '---'  Body
  private static boolean Document_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Document_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOCUMENT_SEPARATOR);
    r = r && Body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // OBJECT_KEYWORD ('<''{' ((KeyValuePairType) (',' KeyValuePairType)*)? '}''>')?
  static boolean ExpandedObjectType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType")) return false;
    if (!nextTokenIs(b, OBJECT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OBJECT_KEYWORD);
    p = r; // pin = 1
    r = r && ExpandedObjectType_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('<''{' ((KeyValuePairType) (',' KeyValuePairType)*)? '}''>')?
  private static boolean ExpandedObjectType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType_1")) return false;
    ExpandedObjectType_1_0(b, l + 1);
    return true;
  }

  // '<''{' ((KeyValuePairType) (',' KeyValuePairType)*)? '}''>'
  private static boolean ExpandedObjectType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && consumeToken(b, L_CURLY);
    r = r && ExpandedObjectType_1_0_2(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((KeyValuePairType) (',' KeyValuePairType)*)?
  private static boolean ExpandedObjectType_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType_1_0_2")) return false;
    ExpandedObjectType_1_0_2_0(b, l + 1);
    return true;
  }

  // (KeyValuePairType) (',' KeyValuePairType)*
  private static boolean ExpandedObjectType_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpandedObjectType_1_0_2_0_0(b, l + 1);
    r = r && ExpandedObjectType_1_0_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KeyValuePairType)
  private static boolean ExpandedObjectType_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType_1_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KeyValuePairType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' KeyValuePairType)*
  private static boolean ExpandedObjectType_1_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType_1_0_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ExpandedObjectType_1_0_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpandedObjectType_1_0_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' KeyValuePairType
  private static boolean ExpandedObjectType_1_0_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpandedObjectType_1_0_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && KeyValuePairType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CASE_KEYWORD Identifier 'when' Expression '->' Expression
  public static boolean ExpressionPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPattern")) return false;
    if (!nextTokenIs(b, CASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE_KEYWORD);
    r = r && Identifier(b, l + 1);
    r = r && consumeToken(b, WHEN);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, EXPRESSION_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // CustomLoader? IdentifierPackage Identifier
  public static boolean FqnIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FqnIdentifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FQN_IDENTIFIER, "<fqn identifier>");
    r = FqnIdentifier_0(b, l + 1);
    r = r && IdentifierPackage(b, l + 1);
    r = r && Identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CustomLoader?
  private static boolean FqnIdentifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FqnIdentifier_0")) return false;
    CustomLoader(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Identifier TypeParameterDeclaration? L_PARREN ( FunctionParameter ( ',' FunctionParameter )* )? R_PARREN ( ":" Type "=" | "=")? Expression
  public static boolean FunctionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEFINITION, "<function definition>");
    r = Identifier(b, l + 1);
    r = r && FunctionDefinition_1(b, l + 1);
    r = r && consumeToken(b, L_PARREN);
    p = r; // pin = 3
    r = r && report_error_(b, FunctionDefinition_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, R_PARREN)) && r;
    r = p && report_error_(b, FunctionDefinition_5(b, l + 1)) && r;
    r = p && Expression(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeParameterDeclaration?
  private static boolean FunctionDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_1")) return false;
    TypeParameterDeclaration(b, l + 1);
    return true;
  }

  // ( FunctionParameter ( ',' FunctionParameter )* )?
  private static boolean FunctionDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_3")) return false;
    FunctionDefinition_3_0(b, l + 1);
    return true;
  }

  // FunctionParameter ( ',' FunctionParameter )*
  private static boolean FunctionDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionParameter(b, l + 1);
    r = r && FunctionDefinition_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' FunctionParameter )*
  private static boolean FunctionDefinition_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_3_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FunctionDefinition_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionDefinition_3_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' FunctionParameter
  private static boolean FunctionDefinition_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ":" Type "=" | "=")?
  private static boolean FunctionDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_5")) return false;
    FunctionDefinition_5_0(b, l + 1);
    return true;
  }

  // ":" Type "=" | "="
  private static boolean FunctionDefinition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionDefinition_5_0_0(b, l + 1);
    if (!r) r = consumeToken(b, EQ);
    exit_section_(b, m, null, r);
    return r;
  }

  // ":" Type "="
  private static boolean FunctionDefinition_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, EQ);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '%function' FunctionDefinition
  public static boolean FunctionDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDirective")) return false;
    if (!nextTokenIs(b, FUNCTION_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DIRECTIVE, null);
    r = consumeToken(b, FUNCTION_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && FunctionDefinition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // VARIABLE_DECLARATION ('=' Expression)?
  public static boolean FunctionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_PARAMETER, "<function parameter>");
    r = VARIABLE_DECLARATION(b, l + 1);
    r = r && FunctionParameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('=' Expression)?
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
  // Directive+
  public static boolean Header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADER, "<header>");
    r = Directive(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!Directive(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Header", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !('---'|OUTPUT_DIRECTIVE_KEYWORD|'%type'|'%function'|'%namespace'|'%var'|'%dw'|'%input'|IMPORT_DIRECTIVE_KEYWORD)
  static boolean HeaderRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HeaderRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !HeaderRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '---'|OUTPUT_DIRECTIVE_KEYWORD|'%type'|'%function'|'%namespace'|'%var'|'%dw'|'%input'|IMPORT_DIRECTIVE_KEYWORD
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
    if (!r) r = consumeToken(b, IMPORT_DIRECTIVE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOLLAR_VARIABLE | ID | '+''+' | '-''-' | 'match'
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = consumeToken(b, DOLLAR_VARIABLE);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = Identifier_2(b, l + 1);
    if (!r) r = Identifier_3(b, l + 1);
    if (!r) r = consumeToken(b, "match");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '+''+'
  private static boolean Identifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && consumeToken(b, PLUS);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-''-'
  private static boolean Identifier_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && consumeToken(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (Identifier "::")*
  public static boolean IdentifierPackage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IdentifierPackage")) return false;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_PACKAGE, "<identifier package>");
    int c = current_position_(b);
    while (true) {
      if (!IdentifierPackage_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IdentifierPackage", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // Identifier "::"
  private static boolean IdentifierPackage_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IdentifierPackage_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, "::");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT_DIRECTIVE_KEYWORD (ImportedElement (',' ImportedElement)* 'from')? FqnIdentifier
  public static boolean ImportDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDirective")) return false;
    if (!nextTokenIs(b, IMPORT_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_DIRECTIVE, null);
    r = consumeToken(b, IMPORT_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, ImportDirective_1(b, l + 1));
    r = p && FqnIdentifier(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (ImportedElement (',' ImportedElement)* 'from')?
  private static boolean ImportDirective_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDirective_1")) return false;
    ImportDirective_1_0(b, l + 1);
    return true;
  }

  // ImportedElement (',' ImportedElement)* 'from'
  private static boolean ImportDirective_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDirective_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImportedElement(b, l + 1);
    r = r && ImportDirective_1_0_1(b, l + 1);
    r = r && consumeToken(b, "from");
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ImportedElement)*
  private static boolean ImportDirective_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDirective_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ImportDirective_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportDirective_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' ImportedElement
  private static boolean ImportDirective_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDirective_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ImportedElement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier ('as' Identifier)?
  public static boolean ImportedElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportedElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORTED_ELEMENT, "<imported element>");
    r = Identifier(b, l + 1);
    r = r && ImportedElement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('as' Identifier)?
  private static boolean ImportedElement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportedElement_1")) return false;
    ImportedElement_1_0(b, l + 1);
    return true;
  }

  // 'as' Identifier
  private static boolean ImportedElement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportedElement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "as");
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '%input' VARIABLE_DECLARATION DataFormat Options?
  public static boolean InputDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InputDirective")) return false;
    if (!nextTokenIs(b, INPUT_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INPUT_DIRECTIVE, null);
    r = consumeToken(b, INPUT_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, VARIABLE_DECLARATION(b, l + 1));
    r = p && report_error_(b, DataFormat(b, l + 1)) && r;
    r = p && InputDirective_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
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
    Marker m = enter_section_(b, l, _NONE_, KEY, "<key>");
    r = KeyExpression(b, l + 1);
    r = r && Key_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
    Marker m = enter_section_(b, l, _COLLAPSE_, KEY_EXPRESSION, "<key expression>");
    r = KeyExpression_0(b, l + 1);
    r = r && KeyExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // NameType AttributesType?
  public static boolean KeyType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, KEY_TYPE, "<key type>");
    r = NameType(b, l + 1);
    r = r && KeyType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AttributesType?
  private static boolean KeyType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyType_1")) return false;
    AttributesType(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ConditionalKeyValuePair
  //            | SimpleKeyValuePair
  public static boolean KeyValuePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE_PAIR, "<key value pair>");
    r = ConditionalKeyValuePair(b, l + 1);
    if (!r) r = SimpleKeyValuePair(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KeyType ('?')? ":" Type
  public static boolean KeyValuePairType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePairType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE_PAIR_TYPE, "<key value pair type>");
    r = KeyType(b, l + 1);
    r = r && KeyValuePairType_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('?')?
  private static boolean KeyValuePairType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePairType_1")) return false;
    KeyValuePairType_1_0(b, l + 1);
    return true;
  }

  // ('?')
  private static boolean KeyValuePairType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValuePairType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUESTION);
    exit_section_(b, m, null, r);
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
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, R_CURLY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TypeParameterDeclaration? '(' ( FunctionParameter ( ',' FunctionParameter )* )? ')' '->' Expression
  public static boolean LambdaLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral")) return false;
    if (!nextTokenIs(b, "<lambda literal>", L_PARREN, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA_LITERAL, "<lambda literal>");
    r = LambdaLiteral_0(b, l + 1);
    r = r && consumeToken(b, L_PARREN);
    r = r && LambdaLiteral_2(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TypeParameterDeclaration?
  private static boolean LambdaLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_0")) return false;
    TypeParameterDeclaration(b, l + 1);
    return true;
  }

  // ( FunctionParameter ( ',' FunctionParameter )* )?
  private static boolean LambdaLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_2")) return false;
    LambdaLiteral_2_0(b, l + 1);
    return true;
  }

  // FunctionParameter ( ',' FunctionParameter )*
  private static boolean LambdaLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionParameter(b, l + 1);
    r = r && LambdaLiteral_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' FunctionParameter )*
  private static boolean LambdaLiteral_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!LambdaLiteral_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LambdaLiteral_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' FunctionParameter
  private static boolean LambdaLiteral_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaLiteral_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Type | Identifier ':' Type
  public static boolean LambdaTypeParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaTypeParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA_TYPE_PARAMETER, "<lambda type parameter>");
    r = Type(b, l + 1, -1);
    if (!r) r = LambdaTypeParameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Identifier ':' Type
  private static boolean LambdaTypeParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaTypeParameter_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Type(b, l + 1, -1);
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
  //            | LambdaLiteral
  //            | UndefinedLiteral
  //            | TypeLiteral
  public static boolean LiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, LITERAL_EXPRESSION, "<literal expression>");
    r = BooleanLiteral(b, l + 1);
    if (!r) r = NullLiteral(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    if (!r) r = NumberLiteral(b, l + 1);
    if (!r) r = AnyDateLiteral(b, l + 1);
    if (!r) r = AnyRegexLiteral(b, l + 1);
    if (!r) r = LambdaLiteral(b, l + 1);
    if (!r) r = UndefinedLiteral(b, l + 1);
    if (!r) r = TypeLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CASE_KEYWORD LiteralExpression '->' Expression
  public static boolean LiteralPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralPattern")) return false;
    if (!nextTokenIs(b, CASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE_KEYWORD);
    r = r && LiteralExpression(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, LITERAL_PATTERN, r);
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
  // ((Identifier"#")?Identifier | StringLiteral) | '('TypeParameter')'
  public static boolean NameType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAME_TYPE, "<name type>");
    r = NameType_0(b, l + 1);
    if (!r) r = NameType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Identifier"#")?Identifier | StringLiteral
  private static boolean NameType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NameType_0_0(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Identifier"#")?Identifier
  private static boolean NameType_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameType_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NameType_0_0_0(b, l + 1);
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Identifier"#")?
  private static boolean NameType_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameType_0_0_0")) return false;
    NameType_0_0_0_0(b, l + 1);
    return true;
  }

  // Identifier"#"
  private static boolean NameType_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameType_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, HASH);
    exit_section_(b, m, null, r);
    return r;
  }

  // '('TypeParameter')'
  private static boolean NameType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameType_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PARREN);
    r = r && TypeParameter(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CASE_KEYWORD Identifier ':' LiteralExpression '->' Expression
  public static boolean NamedLiteralPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedLiteralPattern")) return false;
    if (!nextTokenIs(b, CASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE_KEYWORD);
    r = r && Identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && LiteralExpression(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, NAMED_LITERAL_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // CASE_KEYWORD Identifier ":" AnyRegexLiteral '->' Expression
  public static boolean NamedRegexPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedRegexPattern")) return false;
    if (!nextTokenIs(b, CASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE_KEYWORD);
    r = r && Identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && AnyRegexLiteral(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, NAMED_REGEX_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // CASE_KEYWORD Identifier "is" TypeLiteral '->' Expression
  public static boolean NamedTypePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedTypePattern")) return false;
    if (!nextTokenIs(b, CASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE_KEYWORD);
    r = r && Identifier(b, l + 1);
    r = r && consumeToken(b, "is");
    r = r && TypeLiteral(b, l + 1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, NAMED_TYPE_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // '%namespace' Identifier NAMESPACE_URI
  public static boolean NamespaceDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamespaceDirective")) return false;
    if (!nextTokenIs(b, NAMESPACE_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_DIRECTIVE, null);
    r = consumeToken(b, NAMESPACE_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, Identifier(b, l + 1));
    r = p && consumeToken(b, NAMESPACE_URI) && r;
    exit_section_(b, l, m, r, p, null);
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
  // DOUBLE_LITERAL | INTEGER_LITERAL
  public static boolean NumberLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumberLiteral")) return false;
    if (!nextTokenIs(b, "<number literal>", DOUBLE_LITERAL, INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = consumeToken(b, DOUBLE_LITERAL);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SingleKeyValuePairObj | MultipleKeyValuePairObj
  public static boolean ObjectExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_EXPRESSION, "<object expression>");
    r = SingleKeyValuePairObj(b, l + 1);
    if (!r) r = MultipleKeyValuePairObj(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier '=' LiteralExpression
  public static boolean OptionElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTION_ELEMENT, "<option element>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && LiteralExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OptionElement ( ',' OptionElement )*
  public static boolean Options(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Options")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTIONS, "<options>");
    r = OptionElement(b, l + 1);
    r = r && Options_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // OUTPUT_DIRECTIVE_KEYWORD (":" Type)? DataFormat Options?
  public static boolean OutputDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OutputDirective")) return false;
    if (!nextTokenIs(b, OUTPUT_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OUTPUT_DIRECTIVE, null);
    r = consumeToken(b, OUTPUT_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, OutputDirective_1(b, l + 1));
    r = p && report_error_(b, DataFormat(b, l + 1)) && r;
    r = p && OutputDirective_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (":" Type)?
  private static boolean OutputDirective_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OutputDirective_1")) return false;
    OutputDirective_1_0(b, l + 1);
    return true;
  }

  // ":" Type
  private static boolean OutputDirective_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OutputDirective_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Options?
  private static boolean OutputDirective_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OutputDirective_3")) return false;
    Options(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // RegexPattern 
  //           | NamedRegexPattern 
  //           | TypePattern 
  //           | NamedTypePattern 
  //           | LiteralPattern 
  //           | NamedLiteralPattern 
  //           | ExpressionPattern 
  //           | DefaultPattern
  public static boolean Pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pattern")) return false;
    if (!nextTokenIs(b, "<pattern>", CASE_KEYWORD, OTHERWISE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PATTERN, "<pattern>");
    r = RegexPattern(b, l + 1);
    if (!r) r = NamedRegexPattern(b, l + 1);
    if (!r) r = TypePattern(b, l + 1);
    if (!r) r = NamedTypePattern(b, l + 1);
    if (!r) r = LiteralPattern(b, l + 1);
    if (!r) r = NamedLiteralPattern(b, l + 1);
    if (!r) r = ExpressionPattern(b, l + 1);
    if (!r) r = DefaultPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' Pattern+ '}'
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

  // Pattern+
  private static boolean PatternMatcherExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PatternMatcherExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Pattern(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!Pattern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PatternMatcherExpression_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RangeLiteral|DynamicRangeExpression
  public static boolean RangeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeExpression")) return false;
    if (!nextTokenIs(b, "<range expression>", L_BRACKET, RULE_RANGE_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, RANGE_EXPRESSION, "<range expression>");
    r = RangeLiteral(b, l + 1);
    if (!r) r = DynamicRangeExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // CASE_KEYWORD RULE_ANY_REGEX '->' Expression
  public static boolean RegexPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexPattern")) return false;
    if (!nextTokenIs(b, CASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CASE_KEYWORD, RULE_ANY_REGEX);
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
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_ELEMENT, "<schema element>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && LiteralExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // (ValueSelector |
  //          AttributeSelector |
  //          SchemaSelector |
  //          MultiValueSelector) ('!'| '?')?
  public static boolean Selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Selector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SELECTOR, "<selector>");
    r = Selector_0(b, l + 1);
    r = r && Selector_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ValueSelector |
  //          AttributeSelector |
  //          SchemaSelector |
  //          MultiValueSelector
  private static boolean Selector_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Selector_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ValueSelector(b, l + 1);
    if (!r) r = AttributeSelector(b, l + 1);
    if (!r) r = SchemaSelector(b, l + 1);
    if (!r) r = MultiValueSelector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('!'| '?')?
  private static boolean Selector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Selector_1")) return false;
    Selector_1_0(b, l + 1);
    return true;
  }

  // '!'| '?'
  private static boolean Selector_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Selector_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ESCLAMATION);
    if (!r) r = consumeToken(b, QUESTION);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Key ':' Expression
  public static boolean SimpleKeyValuePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleKeyValuePair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_KEY_VALUE_PAIR, "<simple key value pair>");
    r = Key(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' ((KeyValuePairType) (',' KeyValuePairType)*)? '}'
  static boolean SimpleObjectType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleObjectType")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, L_CURLY);
    p = r; // pin = 1
    r = r && report_error_(b, SimpleObjectType_1(b, l + 1));
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((KeyValuePairType) (',' KeyValuePairType)*)?
  private static boolean SimpleObjectType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleObjectType_1")) return false;
    SimpleObjectType_1_0(b, l + 1);
    return true;
  }

  // (KeyValuePairType) (',' KeyValuePairType)*
  private static boolean SimpleObjectType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleObjectType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleObjectType_1_0_0(b, l + 1);
    r = r && SimpleObjectType_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KeyValuePairType)
  private static boolean SimpleObjectType_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleObjectType_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KeyValuePairType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' KeyValuePairType)*
  private static boolean SimpleObjectType_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleObjectType_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SimpleObjectType_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SimpleObjectType_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' KeyValuePairType
  private static boolean SimpleObjectType_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleObjectType_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && KeyValuePairType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KeyValuePair
  public static boolean SingleKeyValuePairObj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SingleKeyValuePairObj")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_KEY_VALUE_PAIR_OBJ, "<single key value pair obj>");
    r = KeyValuePair(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTED_STRING
  //                       | SINGLE_QUOTED_STRING
  public static boolean StringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringLiteral")) return false;
    if (!nextTokenIs(b, "<string literal>", DOUBLE_QUOTED_STRING, SINGLE_QUOTED_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier '=' TypeLiteral
  public static boolean TypeDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DEFINITION, "<type definition>");
    r = Identifier(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && TypeLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%type' TypeDefinition TypeParameterDeclaration?
  public static boolean TypeDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDirective")) return false;
    if (!nextTokenIs(b, TYPE_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DIRECTIVE, null);
    r = consumeToken(b, TYPE_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, TypeDefinition(b, l + 1));
    r = p && TypeDirective_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeParameterDeclaration?
  private static boolean TypeDirective_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDirective_2")) return false;
    TypeParameterDeclaration(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Type Schema?
  public static boolean TypeLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_LITERAL, "<type literal>");
    r = Type(b, l + 1, -1);
    r = r && TypeLiteral_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Schema?
  private static boolean TypeLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeLiteral_1")) return false;
    Schema(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Identifier ( '<:' Type)?
  public static boolean TypeParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_PARAMETER, "<type parameter>");
    r = Identifier(b, l + 1);
    r = r && TypeParameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '<:' Type)?
  private static boolean TypeParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameter_1")) return false;
    TypeParameter_1_0(b, l + 1);
    return true;
  }

  // '<:' Type
  private static boolean TypeParameter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameter_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUB_TYPE);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<' (TypeParameter (',' TypeParameter)*)? '>'
  static boolean TypeParameterDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameterDeclaration")) return false;
    if (!nextTokenIs(b, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && TypeParameterDeclaration_1(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TypeParameter (',' TypeParameter)*)?
  private static boolean TypeParameterDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameterDeclaration_1")) return false;
    TypeParameterDeclaration_1_0(b, l + 1);
    return true;
  }

  // TypeParameter (',' TypeParameter)*
  private static boolean TypeParameterDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameterDeclaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeParameter(b, l + 1);
    r = r && TypeParameterDeclaration_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypeParameter)*
  private static boolean TypeParameterDeclaration_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameterDeclaration_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TypeParameterDeclaration_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeParameterDeclaration_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' TypeParameter
  private static boolean TypeParameterDeclaration_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameterDeclaration_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypeParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CASE_KEYWORD Type '->' Expression
  public static boolean TypePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypePattern")) return false;
    if (!nextTokenIs(b, CASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE_KEYWORD);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, ARROW_TOKEN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, TYPE_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // '?''?''?'
  public static boolean UndefinedLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UndefinedLiteral")) return false;
    if (!nextTokenIs(b, QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUESTION);
    r = r && consumeToken(b, QUESTION);
    r = r && consumeToken(b, QUESTION);
    exit_section_(b, m, UNDEFINED_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier (":" Type)?
  static boolean VARIABLE_DECLARATION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_DECLARATION")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    r = r && VARIABLE_DECLARATION_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (":" Type)?
  private static boolean VARIABLE_DECLARATION_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_DECLARATION_1")) return false;
    VARIABLE_DECLARATION_1_0(b, l + 1);
    return true;
  }

  // ":" Type
  private static boolean VARIABLE_DECLARATION_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_DECLARATION_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DeclaredNamespace? (StringLiteral|Identifier)
  public static boolean ValueSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueSelector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_SELECTOR, "<value selector>");
    r = ValueSelector_0(b, l + 1);
    r = r && ValueSelector_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // VARIABLE_DECLARATION '='  Expression
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<Variable>");
    r = VARIABLE_DECLARATION(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%var' VariableDefinition
  public static boolean VariableDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDirective")) return false;
    if (!nextTokenIs(b, VAR_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DIRECTIVE, null);
    r = consumeToken(b, VAR_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && VariableDefinition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // FqnIdentifier
  public static boolean VariableReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableReferenceExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_REFERENCE_EXPRESSION, "<variable reference expression>");
    r = FqnIdentifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '%dw'  DOUBLE_LITERAL
  public static boolean VersionDirective(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VersionDirective")) return false;
    if (!nextTokenIs(b, VERSION_DIRECTIVE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VERSION_DIRECTIVE, null);
    r = consumeToken(b, VERSION_DIRECTIVE_KEYWORD);
    p = r; // pin = 1
    r = r && consumeToken(b, DOUBLE_LITERAL);
    exit_section_(b, l, m, r, p, null);
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
  // 1: POSTFIX(MatchExpression)
  // 2: BINARY(BinaryExpression)
  // 3: PREFIX(ClojureExpression)
  // 4: BINARY(AsExpression)
  // 5: BINARY(DefaultValueExpression)
  // 6: BINARY(OrExpression)
  // 7: BINARY(AndExpression)
  // 8: BINARY(EqualityExpression)
  // 9: BINARY(IsExpression)
  // 10: BINARY(GreaterThanExpression)
  // 11: BINARY(AdditionSubtractionExpression)
  // 12: BINARY(RightLeftExpression)
  // 13: BINARY(MultiplicationDivisionExpression)
  // 14: POSTFIX(FunctionCallExpression)
  // 15: POSTFIX(DotSelectorExpression)
  // 16: BINARY(FilterSelectorExpression)
  // 17: POSTFIX(BracketSelectorExpression)
  // 18: BINARY(DynamicSelectorExpression)
  // 19: POSTFIX(RangeSelectorExpression)
  // 20: ATOM(UsingExpression)
  // 21: ATOM(ValueExpression)
  public static boolean Expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = ClojureExpression(b, l + 1);
    if (!r) r = UsingExpression(b, l + 1);
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
      else if (g < 1 && MatchExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, MATCH_EXPRESSION, r, true, null);
      }
      else if (g < 2 && Identifier(b, l + 1)) {
        r = Expression(b, l, 2);
        exit_section_(b, l, m, BINARY_EXPRESSION, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, AS)) {
        r = Expression(b, l, 4);
        exit_section_(b, l, m, AS_EXPRESSION, r, true, null);
      }
      else if (g < 5 && consumeTokenSmart(b, DEFAULT)) {
        r = Expression(b, l, 5);
        exit_section_(b, l, m, DEFAULT_VALUE_EXPRESSION, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, OR_KEYWORD)) {
        r = Expression(b, l, 6);
        exit_section_(b, l, m, OR_EXPRESSION, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, AND_KEYWORD)) {
        r = Expression(b, l, 7);
        exit_section_(b, l, m, AND_EXPRESSION, r, true, null);
      }
      else if (g < 8 && EqualityExpression_0(b, l + 1)) {
        r = Expression(b, l, 8);
        exit_section_(b, l, m, EQUALITY_EXPRESSION, r, true, null);
      }
      else if (g < 9 && consumeTokenSmart(b, IS)) {
        r = Expression(b, l, 9);
        exit_section_(b, l, m, IS_EXPRESSION, r, true, null);
      }
      else if (g < 10 && GreaterThanExpression_0(b, l + 1)) {
        r = Expression(b, l, 10);
        exit_section_(b, l, m, GREATER_THAN_EXPRESSION, r, true, null);
      }
      else if (g < 11 && AdditionSubtractionExpression_0(b, l + 1)) {
        r = Expression(b, l, 11);
        exit_section_(b, l, m, ADDITION_SUBTRACTION_EXPRESSION, r, true, null);
      }
      else if (g < 12 && RightLeftExpression_0(b, l + 1)) {
        r = Expression(b, l, 12);
        exit_section_(b, l, m, RIGHT_LEFT_EXPRESSION, r, true, null);
      }
      else if (g < 13 && MultiplicationDivisionExpression_0(b, l + 1)) {
        r = Expression(b, l, 13);
        exit_section_(b, l, m, MULTIPLICATION_DIVISION_EXPRESSION, r, true, null);
      }
      else if (g < 14 && FunctionCallExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, FUNCTION_CALL_EXPRESSION, r, true, null);
      }
      else if (g < 15 && DotSelectorExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, DOT_SELECTOR_EXPRESSION, r, true, null);
      }
      else if (g < 16 && FilterSelectorExpression_0(b, l + 1)) {
        r = report_error_(b, Expression(b, l, 16));
        r = consumeToken(b, R_BRACKET) && r;
        exit_section_(b, l, m, FILTER_SELECTOR_EXPRESSION, r, true, null);
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

  // RULE_MATCH_LITERAL (PatternMatcherExpression )
  private static boolean MatchExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, RULE_MATCH_LITERAL);
    r = r && MatchExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PatternMatcherExpression )
  private static boolean MatchExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PatternMatcherExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean ClojureExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureExpression")) return false;
    if (!nextTokenIsSmart(b, L_PARREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = ClojureExpression_0(b, l + 1);
    p = r;
    r = p && Expression(b, l, 3);
    exit_section_(b, l, m, CLOJURE_EXPRESSION, r, p, null);
    return r || p;
  }

  // '(' ( FunctionParameter ( ',' FunctionParameter )* )? ')' '->'
  private static boolean ClojureExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, L_PARREN);
    r = r && ClojureExpression_0_1(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, ARROW_TOKEN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( FunctionParameter ( ',' FunctionParameter )* )?
  private static boolean ClojureExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureExpression_0_1")) return false;
    ClojureExpression_0_1_0(b, l + 1);
    return true;
  }

  // FunctionParameter ( ',' FunctionParameter )*
  private static boolean ClojureExpression_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureExpression_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionParameter(b, l + 1);
    r = r && ClojureExpression_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' FunctionParameter )*
  private static boolean ClojureExpression_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureExpression_0_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ClojureExpression_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClojureExpression_0_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' FunctionParameter
  private static boolean ClojureExpression_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClojureExpression_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && FunctionParameter(b, l + 1);
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

  // '>' '>'
  private static boolean RightLeftExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightLeftExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, GREATER);
    r = r && consumeToken(b, GREATER);
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

  // '[' '?'
  private static boolean FilterSelectorExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FilterSelectorExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, L_BRACKET);
    r = r && consumeToken(b, QUESTION);
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

  // USING '(' VariableDefinition ( ',' VariableDefinition )* ')' Expression
  public static boolean UsingExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsingExpression")) return false;
    if (!nextTokenIsSmart(b, USING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USING_EXPRESSION, null);
    r = consumeTokenSmart(b, USING);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, L_PARREN));
    r = p && report_error_(b, VariableDefinition(b, l + 1)) && r;
    r = p && report_error_(b, UsingExpression_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, R_PARREN)) && r;
    r = p && Expression(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
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

  // ObjectExpression
  //                   |RangeExpression
  //                   |ArrayExpression
  //                   |VariableReferenceExpression
  //                   |EnclosedExpression
  //                   |LiteralExpression
  public static boolean ValueExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, VALUE_EXPRESSION, "<value expression>");
    r = ObjectExpression(b, l + 1);
    if (!r) r = RangeExpression(b, l + 1);
    if (!r) r = ArrayExpression(b, l + 1);
    if (!r) r = VariableReferenceExpression(b, l + 1);
    if (!r) r = EnclosedExpression(b, l + 1);
    if (!r) r = LiteralExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression root: Type
  // Operator priority table:
  // 0: BINARY(UnionType)
  // 1: ATOM(LambdaType)
  // 2: ATOM(ObjectType)
  // 3: ATOM(ArrayType)
  // 4: ATOM(TypeType)
  // 5: ATOM(SimpleType)
  // 6: ATOM(ReferenceType)
  public static boolean Type(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Type")) return false;
    addVariant(b, "<type>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<type>");
    r = LambdaType(b, l + 1);
    if (!r) r = ObjectType(b, l + 1);
    if (!r) r = ArrayType(b, l + 1);
    if (!r) r = TypeType(b, l + 1);
    if (!r) r = SimpleType(b, l + 1);
    if (!r) r = ReferenceType(b, l + 1);
    p = r;
    r = r && Type_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Type_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Type_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, OR)) {
        r = Type(b, l, 0);
        exit_section_(b, l, m, UNION_TYPE, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // '(' LambdaTypeParameter (',' LambdaTypeParameter)* ')' '=>' Type
  public static boolean LambdaType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaType")) return false;
    if (!nextTokenIsSmart(b, L_PARREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA_TYPE, null);
    r = consumeTokenSmart(b, L_PARREN);
    r = r && LambdaTypeParameter(b, l + 1);
    r = r && LambdaType_2(b, l + 1);
    r = r && consumeToken(b, R_PARREN);
    r = r && consumeToken(b, FAT_ARROW);
    p = r; // pin = 5
    r = r && Type(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' LambdaTypeParameter)*
  private static boolean LambdaType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaType_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!LambdaType_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LambdaType_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' LambdaTypeParameter
  private static boolean LambdaType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && LambdaTypeParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ExpandedObjectType | SimpleObjectType
  public static boolean ObjectType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectType")) return false;
    if (!nextTokenIsSmart(b, L_CURLY, OBJECT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_TYPE, "<object type>");
    r = ExpandedObjectType(b, l + 1);
    if (!r) r = SimpleObjectType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ARRAY_KEYWORD ('<' Type '>')?
  public static boolean ArrayType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayType")) return false;
    if (!nextTokenIsSmart(b, ARRAY_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ARRAY_KEYWORD);
    r = r && ArrayType_1(b, l + 1);
    exit_section_(b, m, ARRAY_TYPE, r);
    return r;
  }

  // ('<' Type '>')?
  private static boolean ArrayType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayType_1")) return false;
    ArrayType_1_0(b, l + 1);
    return true;
  }

  // '<' Type '>'
  private static boolean ArrayType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LESS);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // TYPE_KEYWORD ('<' Type '>')?
  public static boolean TypeType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeType")) return false;
    if (!nextTokenIsSmart(b, TYPE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, TYPE_KEYWORD);
    r = r && TypeType_1(b, l + 1);
    exit_section_(b, m, TYPE_TYPE, r);
    return r;
  }

  // ('<' Type '>')?
  private static boolean TypeType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeType_1")) return false;
    TypeType_1_0(b, l + 1);
    return true;
  }

  // '<' Type '>'
  private static boolean TypeType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LESS);
    r = r && Type(b, l + 1, -1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // SIMPLE_TYPE_LITERAL
  public static boolean SimpleType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType")) return false;
    if (!nextTokenIsSmart(b, SIMPLE_TYPE_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, SIMPLE_TYPE_LITERAL);
    exit_section_(b, m, SIMPLE_TYPE, r);
    return r;
  }

  // FqnIdentifier ('<' Type (',' Type)* '>')?
  public static boolean ReferenceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_TYPE, "<reference type>");
    r = FqnIdentifier(b, l + 1);
    r = r && ReferenceType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('<' Type (',' Type)* '>')?
  private static boolean ReferenceType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceType_1")) return false;
    ReferenceType_1_0(b, l + 1);
    return true;
  }

  // '<' Type (',' Type)* '>'
  private static boolean ReferenceType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LESS);
    r = r && Type(b, l + 1, -1);
    r = r && ReferenceType_1_0_2(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Type)*
  private static boolean ReferenceType_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceType_1_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ReferenceType_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ReferenceType_1_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Type
  private static boolean ReferenceType_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceType_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && Type(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  final static Parser HeaderRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return HeaderRecover(b, l + 1);
    }
  };
}
