// This is a generated file. Not intended for manual editing.
package org.mule.lang.mel.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.mule.lang.mel.parser.psi.MelTypes.*;
import static org.mule.lang.mel.parser.MelParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MelParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARRAY_EXPRESSION) {
      r = arrayExpression(b, 0);
    }
    else if (t == BINARY_EXPRESSION) {
      r = expression(b, 0, 12);
    }
    else if (t == BLOCK_EXPRESSION) {
      r = blockExpression(b, 0);
    }
    else if (t == CONDITIONAL_EXPRESSION) {
      r = expression(b, 0, 11);
    }
    else if (t == DO_WHILE_EXPRESSION) {
      r = doWhileExpression(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0, -1);
    }
    else if (t == FOR_EXPRESSION) {
      r = forExpression(b, 0);
    }
    else if (t == FOREACH_EXPRESSION) {
      r = foreachExpression(b, 0);
    }
    else if (t == FQN_TYPE_EXPRESSION) {
      r = fqnTypeExpression(b, 0);
    }
    else if (t == FUNCTION_EXPRESSION) {
      r = functionExpression(b, 0);
    }
    else if (t == IF_EXPRESSION) {
      r = ifExpression(b, 0);
    }
    else if (t == IMPORT_EXPRESSION) {
      r = importExpression(b, 0);
    }
    else if (t == INDEXED_EXPRESSION) {
      r = expression(b, 0, 15);
    }
    else if (t == LITERAL_EXPRESSION) {
      r = literalExpression(b, 0);
    }
    else if (t == MAP_ENTRY_ELEMENT) {
      r = mapEntryElement(b, 0);
    }
    else if (t == MAP_EXPRESSION) {
      r = mapExpression(b, 0);
    }
    else if (t == METHOD_CALL_EXPRESSION) {
      r = expression(b, 0, 14);
    }
    else if (t == NEW_EXPRESSION) {
      r = newExpression(b, 0);
    }
    else if (t == PARAMETER_LIST) {
      r = parameterList(b, 0);
    }
    else if (t == PARENTHESIZED_EXPRESSION) {
      r = parenthesizedExpression(b, 0);
    }
    else if (t == POSTFIX_UNARY_EXPRESSION) {
      r = expression(b, 0, 17);
    }
    else if (t == PREFIX_UNARY_EXPRESSION) {
      r = prefixUnaryExpression(b, 0);
    }
    else if (t == REFERENCE_EXPRESSION) {
      r = expression(b, 0, 16);
    }
    else if (t == VARIABLE_ASSIGNMENT_EXPRESSION) {
      r = variableAssignmentExpression(b, 0);
    }
    else if (t == WHILE_EXPRESSION) {
      r = whileExpression(b, 0);
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
    create_token_set_(ARRAY_EXPRESSION, BINARY_EXPRESSION, BLOCK_EXPRESSION, CONDITIONAL_EXPRESSION,
      DO_WHILE_EXPRESSION, EXPRESSION, FOREACH_EXPRESSION, FOR_EXPRESSION,
      FQN_TYPE_EXPRESSION, FUNCTION_EXPRESSION, IF_EXPRESSION, IMPORT_EXPRESSION,
      INDEXED_EXPRESSION, LITERAL_EXPRESSION, MAP_EXPRESSION, METHOD_CALL_EXPRESSION,
      NEW_EXPRESSION, PARENTHESIZED_EXPRESSION, POSTFIX_UNARY_EXPRESSION, PREFIX_UNARY_EXPRESSION,
      REFERENCE_EXPRESSION, VARIABLE_ASSIGNMENT_EXPRESSION, WHILE_EXPRESSION),
  };

  /* ********************************************************** */
  // plusMinusOperations |
  //                            divideMultiplyOperations |
  //                            bitwiseBooleanOperations |
  //                            instanceOfOperation |
  //                            shiftOperations |
  //                            booleanOperations |
  //                            equalityOperations |
  //                            relationalOperations |
  //                            setOperations
  static boolean binaryOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryOperations")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<operator>");
    r = plusMinusOperations(b, l + 1);
    if (!r) r = divideMultiplyOperations(b, l + 1);
    if (!r) r = bitwiseBooleanOperations(b, l + 1);
    if (!r) r = instanceOfOperation(b, l + 1);
    if (!r) r = shiftOperations(b, l + 1);
    if (!r) r = booleanOperations(b, l + 1);
    if (!r) r = equalityOperations(b, l + 1);
    if (!r) r = relationalOperations(b, l + 1);
    if (!r) r = setOperations(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "|" | "^" | "&"
  static boolean bitwiseBooleanOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseBooleanOperations")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, XOR);
    if (!r) r = consumeToken(b, AND);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '!' | "~"
  static boolean bitwiseOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseOperations")) return false;
    if (!nextTokenIs(b, "", NEGATE, NOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEGATE);
    if (!r) r = consumeToken(b, NOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "true" | "false"
  static boolean booleanLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "booleanLiteralExpression")) return false;
    if (!nextTokenIs(b, "", FALSE_KEYWORD, TRUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUE_KEYWORD);
    if (!r) r = consumeToken(b, FALSE_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "&&" | "||"
  static boolean booleanOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "booleanOperations")) return false;
    if (!nextTokenIs(b, "", AND_AND, OR_OR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND_AND);
    if (!r) r = consumeToken(b, OR_OR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ':' expression
  static boolean conditionalExpressionTail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalExpressionTail")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' parameterList ')'
  static boolean constructorExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructorExpression")) return false;
    if (!nextTokenIs(b, LPARENTH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENTH);
    r = r && parameterList(b, l + 1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '*' | '/' | '%'
  static boolean divideMultiplyOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "divideMultiplyOperations")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, DIVISION);
    if (!r) r = consumeToken(b, MODULO);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "==" | "!="
  static boolean equalityOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityOperations")) return false;
    if (!nextTokenIs(b, "", NOT_EQUAL, EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression ';'?
  static boolean expressionSemicolon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionSemicolon")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && expressionSemicolon_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean expressionSemicolon_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionSemicolon_1")) return false;
    consumeToken(b, ";");
    return true;
  }

  /* ********************************************************** */
  // 'instanceof'
  static boolean instanceOfOperation(PsiBuilder b, int l) {
    return consumeToken(b, INSTANCEOF_KEYWORD);
  }

  /* ********************************************************** */
  // expression ':' expression
  public static boolean mapEntryElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapEntryElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_ENTRY_ELEMENT, "<map entry element>");
    r = expression(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // mapEntryElement (',' mapEntryElement)*
  static boolean mapExpressionSequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapExpressionSequence")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mapEntryElement(b, l + 1);
    r = r && mapExpressionSequence_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' mapEntryElement)*
  private static boolean mapExpressionSequence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapExpressionSequence_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!mapExpressionSequence_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapExpressionSequence_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' mapEntryElement
  private static boolean mapExpressionSequence_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapExpressionSequence_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && mapEntryElement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER_LITERAL | BIG_INTEGER_LITERAL | DOUBLE_LITERAL | BIG_DECIMAL_LITERAL
  static boolean numberLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numberLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, BIG_INTEGER_LITERAL);
    if (!r) r = consumeToken(b, DOUBLE_LITERAL);
    if (!r) r = consumeToken(b, BIG_DECIMAL_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression? (',' expression)*
  public static boolean parameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
    r = parameterList_0(b, l + 1);
    r = r && parameterList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression?
  private static boolean parameterList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_0")) return false;
    expression(b, l + 1, -1);
    return true;
  }

  // (',' expression)*
  private static boolean parameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!parameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameterList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expression
  private static boolean parameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-'
  static boolean plusMinusOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plusMinusOperations")) return false;
    if (!nextTokenIs(b, "", PLUS, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '--'| '++'
  static boolean postfixUnaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryOperator")) return false;
    if (!nextTokenIs(b, "", PLUS_PLUS, MINUS_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS_MINUS);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bitwiseOperations |
  //                           '--'| '++' |'+' | '-'  | "return" | "!"
  static boolean prefixUnaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bitwiseOperations(b, l + 1);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, NEGATE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<'  | "<="  | '>'  | ">="
  static boolean relationalOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalOperations")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expressionSemicolon*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    int c = current_position_(b);
    while (true) {
      if (!expressionSemicolon(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // 'in'
  static boolean setOperations(PsiBuilder b, int l) {
    return consumeToken(b, IN);
  }

  /* ********************************************************** */
  // "<<" | ">>"
  static boolean shiftOperations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftOperations")) return false;
    if (!nextTokenIs(b, "", SHIFT_LEFT, SHIFT_RIGHT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SHIFT_LEFT);
    if (!r) r = consumeToken(b, SHIFT_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL | CHARACTER_LITERAL
  static boolean textLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "textLiteralExpression")) return false;
    if (!nextTokenIs(b, "", CHARACTER_LITERAL, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, CHARACTER_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expression
  // Operator priority table:
  // 0: ATOM(importExpression)
  // 1: ATOM(functionExpression)
  // 2: ATOM(variableAssignmentExpression)
  // 3: ATOM(ifExpression)
  // 4: ATOM(foreachExpression)
  // 5: ATOM(forExpression)
  // 6: ATOM(whileExpression)
  // 7: ATOM(doWhileExpression)
  // 8: ATOM(mapExpression)
  // 9: ATOM(arrayExpression)
  // 10: PREFIX(parenthesizedExpression)
  // 11: ATOM(blockExpression)
  // 12: BINARY(conditionalExpression)
  // 13: BINARY(binaryExpression)
  // 14: ATOM(newExpression)
  // 15: POSTFIX(methodCallExpression)
  // 16: BINARY(indexedExpression)
  // 17: POSTFIX(referenceExpression)
  // 18: POSTFIX(postfixUnaryExpression)
  // 19: ATOM(prefixUnaryExpression)
  // 20: ATOM(literalExpression)
  // 21: ATOM(fqnTypeExpression)
  public static boolean expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = importExpression(b, l + 1);
    if (!r) r = functionExpression(b, l + 1);
    if (!r) r = variableAssignmentExpression(b, l + 1);
    if (!r) r = ifExpression(b, l + 1);
    if (!r) r = foreachExpression(b, l + 1);
    if (!r) r = forExpression(b, l + 1);
    if (!r) r = whileExpression(b, l + 1);
    if (!r) r = doWhileExpression(b, l + 1);
    if (!r) r = mapExpression(b, l + 1);
    if (!r) r = arrayExpression(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    if (!r) r = blockExpression(b, l + 1);
    if (!r) r = newExpression(b, l + 1);
    if (!r) r = prefixUnaryExpression(b, l + 1);
    if (!r) r = literalExpression(b, l + 1);
    if (!r) r = fqnTypeExpression(b, l + 1);
    p = r;
    r = r && expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 12 && consumeTokenSmart(b, QUESTION)) {
        r = report_error_(b, expression(b, l, 12));
        r = conditionalExpressionTail(b, l + 1) && r;
        exit_section_(b, l, m, CONDITIONAL_EXPRESSION, r, true, null);
      }
      else if (g < 13 && binaryOperations(b, l + 1)) {
        r = expression(b, l, 13);
        exit_section_(b, l, m, BINARY_EXPRESSION, r, true, null);
      }
      else if (g < 15 && methodCallExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, METHOD_CALL_EXPRESSION, r, true, null);
      }
      else if (g < 16 && consumeTokenSmart(b, LBRACKET)) {
        r = report_error_(b, expression(b, l, 16));
        r = consumeToken(b, RBRACKET) && r;
        exit_section_(b, l, m, INDEXED_EXPRESSION, r, true, null);
      }
      else if (g < 17 && referenceExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, REFERENCE_EXPRESSION, r, true, null);
      }
      else if (g < 18 && postfixUnaryOperator(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, POSTFIX_UNARY_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // 'import' IDENTIFIER ('.' IDENTIFIER)* ('.' '*')?
  public static boolean importExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importExpression")) return false;
    if (!nextTokenIsSmart(b, IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_EXPRESSION, null);
    r = consumeTokenSmart(b, IMPORT);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, IDENTIFIER));
    r = p && report_error_(b, importExpression_2(b, l + 1)) && r;
    r = p && importExpression_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('.' IDENTIFIER)*
  private static boolean importExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importExpression_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!importExpression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "importExpression_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean importExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('.' '*')?
  private static boolean importExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importExpression_3")) return false;
    importExpression_3_0(b, l + 1);
    return true;
  }

  // '.' '*'
  private static boolean importExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && consumeToken(b, MULTIPLY);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'def' IDENTIFIER '(' parameterList ')' blockExpression
  public static boolean functionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionExpression")) return false;
    if (!nextTokenIsSmart(b, DEF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_EXPRESSION, null);
    r = consumeTokenSmart(b, DEF);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, IDENTIFIER));
    r = p && report_error_(b, consumeToken(b, LPARENTH)) && r;
    r = p && report_error_(b, parameterList(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RPARENTH)) && r;
    r = p && blockExpression(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (IDENTIFIER '=' expression) | (fqnTypeExpression IDENTIFIER '=' expression)
  public static boolean variableAssignmentExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableAssignmentExpression")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableAssignmentExpression_0(b, l + 1);
    if (!r) r = variableAssignmentExpression_1(b, l + 1);
    exit_section_(b, m, VARIABLE_ASSIGNMENT_EXPRESSION, r);
    return r;
  }

  // IDENTIFIER '=' expression
  private static boolean variableAssignmentExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableAssignmentExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    r = r && consumeToken(b, EQ);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fqnTypeExpression IDENTIFIER '=' expression
  private static boolean variableAssignmentExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableAssignmentExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fqnTypeExpression(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, EQ);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'if' '(' expression ')' expression ('else' expression)?
  public static boolean ifExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExpression")) return false;
    if (!nextTokenIsSmart(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_EXPRESSION, null);
    r = consumeTokenSmart(b, IF);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LPARENTH));
    r = p && report_error_(b, expression(b, l + 1, -1)) && r;
    r = p && report_error_(b, consumeToken(b, RPARENTH)) && r;
    r = p && report_error_(b, expression(b, l + 1, -1)) && r;
    r = p && ifExpression_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('else' expression)?
  private static boolean ifExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExpression_5")) return false;
    ifExpression_5_0(b, l + 1);
    return true;
  }

  // 'else' expression
  private static boolean ifExpression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExpression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ELSE);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('foreach') '(' IDENTIFIER ':' expression ')' expression
  public static boolean foreachExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachExpression")) return false;
    if (!nextTokenIsSmart(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = foreachExpression_0(b, l + 1);
    r = r && consumeToken(b, LPARENTH);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, RPARENTH);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, FOREACH_EXPRESSION, r);
    return r;
  }

  // ('foreach')
  private static boolean foreachExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, FOREACH);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'for' ('(' expression ';' expression ';' expression ')' | '(' IDENTIFIER ':' expression ')') expression
  public static boolean forExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forExpression")) return false;
    if (!nextTokenIsSmart(b, FOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FOR_EXPRESSION, null);
    r = consumeTokenSmart(b, FOR);
    p = r; // pin = 1
    r = r && report_error_(b, forExpression_1(b, l + 1));
    r = p && expression(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '(' expression ';' expression ';' expression ')' | '(' IDENTIFIER ':' expression ')'
  private static boolean forExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = forExpression_1_0(b, l + 1);
    if (!r) r = forExpression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' expression ';' expression ';' expression ')'
  private static boolean forExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LPARENTH);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, ";");
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, ";");
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' IDENTIFIER ':' expression ')'
  private static boolean forExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forExpression_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LPARENTH);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1, -1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'while' '(' expression ')' expression
  public static boolean whileExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExpression")) return false;
    if (!nextTokenIsSmart(b, WHILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WHILE_EXPRESSION, null);
    r = consumeTokenSmart(b, WHILE);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LPARENTH));
    r = p && report_error_(b, expression(b, l + 1, -1)) && r;
    r = p && report_error_(b, consumeToken(b, RPARENTH)) && r;
    r = p && expression(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'do' blockExpression 'while' '(' expression ')'
  public static boolean doWhileExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doWhileExpression")) return false;
    if (!nextTokenIsSmart(b, DO)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DO_WHILE_EXPRESSION, null);
    r = consumeTokenSmart(b, DO);
    p = r; // pin = 1
    r = r && report_error_(b, blockExpression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, WHILE)) && r;
    r = p && report_error_(b, consumeToken(b, LPARENTH)) && r;
    r = p && report_error_(b, expression(b, l + 1, -1)) && r;
    r = p && consumeToken(b, RPARENTH) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '[' mapExpressionSequence  ']'
  public static boolean mapExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapExpression")) return false;
    if (!nextTokenIsSmart(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACKET);
    r = r && mapExpressionSequence(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, MAP_EXPRESSION, r);
    return r;
  }

  // '[' expression (',' expression)*  ']'
  public static boolean arrayExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpression")) return false;
    if (!nextTokenIsSmart(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACKET);
    r = r && expression(b, l + 1, -1);
    r = r && arrayExpression_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, ARRAY_EXPRESSION, r);
    return r;
  }

  // (',' expression)*
  private static boolean arrayExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpression_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!arrayExpression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayExpression_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expression
  private static boolean arrayExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean parenthesizedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesizedExpression")) return false;
    if (!nextTokenIsSmart(b, LPARENTH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, LPARENTH);
    p = r;
    r = p && expression(b, l, 10);
    r = p && report_error_(b, consumeToken(b, RPARENTH)) && r;
    exit_section_(b, l, m, PARENTHESIZED_EXPRESSION, r, p, null);
    return r || p;
  }

  // '{' expressionSemicolon* '}'
  public static boolean blockExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockExpression")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACE);
    r = r && blockExpression_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK_EXPRESSION, r);
    return r;
  }

  // expressionSemicolon*
  private static boolean blockExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!expressionSemicolon(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "blockExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // "new" fqnTypeExpression constructorExpression
  public static boolean newExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newExpression")) return false;
    if (!nextTokenIsSmart(b, NEW_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NEW_EXPRESSION, null);
    r = consumeTokenSmart(b, NEW_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, fqnTypeExpression(b, l + 1));
    r = p && constructorExpression(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '(' parameterList ')'
  private static boolean methodCallExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodCallExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LPARENTH);
    r = r && parameterList(b, l + 1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, null, r);
    return r;
  }

  // '.' '?'? IDENTIFIER
  private static boolean referenceExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && referenceExpression_0_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?'?
  private static boolean referenceExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression_0_1")) return false;
    consumeTokenSmart(b, QUESTION);
    return true;
  }

  // prefixUnaryOperator expression
  public static boolean prefixUnaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryExpression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, PREFIX_UNARY_EXPRESSION, "<prefix unary expression>");
    r = prefixUnaryOperator(b, l + 1);
    p = r; // pin = 1
    r = r && expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // numberLiteralExpression |
  //                       textLiteralExpression |
  //                       booleanLiteralExpression |
  //                       "null"
  public static boolean literalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPRESSION, "<literal expression>");
    r = numberLiteralExpression(b, l + 1);
    if (!r) r = textLiteralExpression(b, l + 1);
    if (!r) r = booleanLiteralExpression(b, l + 1);
    if (!r) r = consumeTokenSmart(b, NULL_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER ('.' IDENTIFIER)*
  public static boolean fqnTypeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fqnTypeExpression")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FQN_TYPE_EXPRESSION, null);
    r = consumeTokenSmart(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && fqnTypeExpression_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('.' IDENTIFIER)*
  private static boolean fqnTypeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fqnTypeExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!fqnTypeExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fqnTypeExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean fqnTypeExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fqnTypeExpression_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokenSmart(b, DOT);
    p = r; // pin = 1
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
