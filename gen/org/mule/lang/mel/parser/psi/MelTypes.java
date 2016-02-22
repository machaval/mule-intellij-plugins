// This is a generated file. Not intended for manual editing.
package org.mule.lang.mel.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.mule.lang.mel.parser.MelElementType;
import org.mule.lang.mel.parser.MelTokenType;
import org.mule.lang.mel.parser.psi.impl.*;

public interface MelTypes {

  IElementType ARRAY_EXPRESSION = new MelElementType("ARRAY_EXPRESSION");
  IElementType BINARY_EXPRESSION = new MelElementType("BINARY_EXPRESSION");
  IElementType BLOCK_EXPRESSION = new MelElementType("BLOCK_EXPRESSION");
  IElementType CONDITIONAL_EXPRESSION = new MelElementType("CONDITIONAL_EXPRESSION");
  IElementType DO_WHILE_EXPRESSION = new MelElementType("DO_WHILE_EXPRESSION");
  IElementType EXPRESSION = new MelElementType("EXPRESSION");
  IElementType FOREACH_EXPRESSION = new MelElementType("FOREACH_EXPRESSION");
  IElementType FOR_EXPRESSION = new MelElementType("FOR_EXPRESSION");
  IElementType FQN_TYPE_EXPRESSION = new MelElementType("FQN_TYPE_EXPRESSION");
  IElementType FUNCTION_EXPRESSION = new MelElementType("FUNCTION_EXPRESSION");
  IElementType IF_EXPRESSION = new MelElementType("IF_EXPRESSION");
  IElementType IMPORT_EXPRESSION = new MelElementType("IMPORT_EXPRESSION");
  IElementType INDEXED_EXPRESSION = new MelElementType("INDEXED_EXPRESSION");
  IElementType LITERAL_EXPRESSION = new MelElementType("LITERAL_EXPRESSION");
  IElementType MAP_ENTRY_ELEMENT = new MelElementType("MAP_ENTRY_ELEMENT");
  IElementType MAP_EXPRESSION = new MelElementType("MAP_EXPRESSION");
  IElementType METHOD_CALL_EXPRESSION = new MelElementType("METHOD_CALL_EXPRESSION");
  IElementType NEW_EXPRESSION = new MelElementType("NEW_EXPRESSION");
  IElementType PARAMETER_LIST = new MelElementType("PARAMETER_LIST");
  IElementType PARENTHESIZED_EXPRESSION = new MelElementType("PARENTHESIZED_EXPRESSION");
  IElementType POSTFIX_UNARY_EXPRESSION = new MelElementType("POSTFIX_UNARY_EXPRESSION");
  IElementType PREFIX_UNARY_EXPRESSION = new MelElementType("PREFIX_UNARY_EXPRESSION");
  IElementType REFERENCE_EXPRESSION = new MelElementType("REFERENCE_EXPRESSION");
  IElementType VARIABLE_ASSIGNMENT_EXPRESSION = new MelElementType("VARIABLE_ASSIGNMENT_EXPRESSION");
  IElementType WHILE_EXPRESSION = new MelElementType("WHILE_EXPRESSION");

  IElementType AND = new MelTokenType("&");
  IElementType AND_AND = new MelTokenType("&&");
  IElementType AND_KEYWORD = new MelTokenType("and");
  IElementType AT = new MelTokenType("@");
  IElementType BIG_DECIMAL_LITERAL = new MelTokenType("BIG_DECIMAL_LITERAL");
  IElementType BIG_INTEGER_LITERAL = new MelTokenType("BIG_INTEGER_LITERAL");
  IElementType CHARACTER_LITERAL = new MelTokenType("CHARACTER_LITERAL");
  IElementType COLON = new MelTokenType(":");
  IElementType COMMA = new MelTokenType(",");
  IElementType DEF = new MelTokenType("def");
  IElementType DIVISION = new MelTokenType("/");
  IElementType DO = new MelTokenType("do");
  IElementType DOLLAR = new MelTokenType("$");
  IElementType DOT = new MelTokenType(".");
  IElementType DOUBLE_LITERAL = new MelTokenType("DOUBLE_LITERAL");
  IElementType ELSE = new MelTokenType("else");
  IElementType EQ = new MelTokenType("=");
  IElementType EQUAL = new MelTokenType("==");
  IElementType FALSE_KEYWORD = new MelTokenType("false");
  IElementType FOR = new MelTokenType("for");
  IElementType FOREACH = new MelTokenType("foreach");
  IElementType GREATER = new MelTokenType(">");
  IElementType GREATER_EQUAL = new MelTokenType(">=");
  IElementType HASH = new MelTokenType("#");
  IElementType IDENTIFIER = new MelTokenType("IDENTIFIER");
  IElementType IF = new MelTokenType("if");
  IElementType IMPORT = new MelTokenType("import");
  IElementType IN = new MelTokenType("in");
  IElementType INSTANCEOF_KEYWORD = new MelTokenType("instanceof");
  IElementType INTEGER_LITERAL = new MelTokenType("INTEGER_LITERAL");
  IElementType LBRACE = new MelTokenType("{");
  IElementType LBRACKET = new MelTokenType("[");
  IElementType LESS = new MelTokenType("<");
  IElementType LESS_EQUAL = new MelTokenType("<=");
  IElementType LINE_COMMENT = new MelTokenType("//");
  IElementType LPARENTH = new MelTokenType("(");
  IElementType MINUS = new MelTokenType("-");
  IElementType MINUS_MINUS = new MelTokenType("--");
  IElementType MODULO = new MelTokenType("%");
  IElementType MULTIPLY = new MelTokenType("*");
  IElementType NEGATE = new MelTokenType("!");
  IElementType NEW_KEYWORD = new MelTokenType("new");
  IElementType NOT = new MelTokenType("~");
  IElementType NOT_EQUAL = new MelTokenType("!=");
  IElementType NOT_KEYWORD = new MelTokenType("not");
  IElementType NULL_KEYWORD = new MelTokenType("null");
  IElementType OR = new MelTokenType("|");
  IElementType OR_KEYWORD = new MelTokenType("or");
  IElementType OR_OR = new MelTokenType("||");
  IElementType PLUS = new MelTokenType("+");
  IElementType PLUS_PLUS = new MelTokenType("++");
  IElementType QUESTION = new MelTokenType("?");
  IElementType RBRACE = new MelTokenType("}");
  IElementType RBRACKET = new MelTokenType("]");
  IElementType RETURN = new MelTokenType("return");
  IElementType RPARENTH = new MelTokenType(")");
  IElementType SHIFT_LEFT = new MelTokenType("<<");
  IElementType SHIFT_RIGHT = new MelTokenType(">>");
  IElementType STRING_LITERAL = new MelTokenType("STRING_LITERAL");
  IElementType TRUE_KEYWORD = new MelTokenType("true");
  IElementType WHILE = new MelTokenType("while");
  IElementType XOR = new MelTokenType("^");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARRAY_EXPRESSION) {
        return new MelArrayExpressionImpl(node);
      }
      else if (type == BINARY_EXPRESSION) {
        return new MelBinaryExpressionImpl(node);
      }
      else if (type == BLOCK_EXPRESSION) {
        return new MelBlockExpressionImpl(node);
      }
      else if (type == CONDITIONAL_EXPRESSION) {
        return new MelConditionalExpressionImpl(node);
      }
      else if (type == DO_WHILE_EXPRESSION) {
        return new MelDoWhileExpressionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new MelExpressionImpl(node);
      }
      else if (type == FOREACH_EXPRESSION) {
        return new MelForeachExpressionImpl(node);
      }
      else if (type == FOR_EXPRESSION) {
        return new MelForExpressionImpl(node);
      }
      else if (type == FQN_TYPE_EXPRESSION) {
        return new MelFqnTypeExpressionImpl(node);
      }
      else if (type == FUNCTION_EXPRESSION) {
        return new MelFunctionExpressionImpl(node);
      }
      else if (type == IF_EXPRESSION) {
        return new MelIfExpressionImpl(node);
      }
      else if (type == IMPORT_EXPRESSION) {
        return new MelImportExpressionImpl(node);
      }
      else if (type == INDEXED_EXPRESSION) {
        return new MelIndexedExpressionImpl(node);
      }
      else if (type == LITERAL_EXPRESSION) {
        return new MelLiteralExpressionImpl(node);
      }
      else if (type == MAP_ENTRY_ELEMENT) {
        return new MelMapEntryElementImpl(node);
      }
      else if (type == MAP_EXPRESSION) {
        return new MelMapExpressionImpl(node);
      }
      else if (type == METHOD_CALL_EXPRESSION) {
        return new MelMethodCallExpressionImpl(node);
      }
      else if (type == NEW_EXPRESSION) {
        return new MelNewExpressionImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new MelParameterListImpl(node);
      }
      else if (type == PARENTHESIZED_EXPRESSION) {
        return new MelParenthesizedExpressionImpl(node);
      }
      else if (type == POSTFIX_UNARY_EXPRESSION) {
        return new MelPostfixUnaryExpressionImpl(node);
      }
      else if (type == PREFIX_UNARY_EXPRESSION) {
        return new MelPrefixUnaryExpressionImpl(node);
      }
      else if (type == REFERENCE_EXPRESSION) {
        return new MelReferenceExpressionImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT_EXPRESSION) {
        return new MelVariableAssignmentExpressionImpl(node);
      }
      else if (type == WHILE_EXPRESSION) {
        return new MelWhileExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
