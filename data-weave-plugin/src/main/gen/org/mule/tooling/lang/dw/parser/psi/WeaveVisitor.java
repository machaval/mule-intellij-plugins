// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.NavigatablePsiElement;

public class WeaveVisitor extends PsiElementVisitor {

  public void visitAdditionSubtractionExpression(@NotNull WeaveAdditionSubtractionExpression o) {
    visitExpression(o);
  }

  public void visitAndExpression(@NotNull WeaveAndExpression o) {
    visitExpression(o);
  }

  public void visitAnyDateLiteral(@NotNull WeaveAnyDateLiteral o) {
    visitExpression(o);
  }

  public void visitAnyRegexLiteral(@NotNull WeaveAnyRegexLiteral o) {
    visitExpression(o);
  }

  public void visitArrayElement(@NotNull WeaveArrayElement o) {
    visitPsiElement(o);
  }

  public void visitArrayExpression(@NotNull WeaveArrayExpression o) {
    visitExpression(o);
    // visitNavigatablePsiElement(o);
  }

  public void visitArrayType(@NotNull WeaveArrayType o) {
    visitType(o);
  }

  public void visitAsExpression(@NotNull WeaveAsExpression o) {
    visitExpression(o);
  }

  public void visitAttribute(@NotNull WeaveAttribute o) {
    visitPsiElement(o);
  }

  public void visitAttributeElement(@NotNull WeaveAttributeElement o) {
    visitPsiElement(o);
  }

  public void visitAttributeSelector(@NotNull WeaveAttributeSelector o) {
    visitPsiElement(o);
  }

  public void visitAttributes(@NotNull WeaveAttributes o) {
    visitPsiElement(o);
  }

  public void visitAttributesType(@NotNull WeaveAttributesType o) {
    visitType(o);
  }

  public void visitBinaryExpression(@NotNull WeaveBinaryExpression o) {
    visitExpression(o);
  }

  public void visitBody(@NotNull WeaveBody o) {
    visitPsiElement(o);
  }

  public void visitBooleanLiteral(@NotNull WeaveBooleanLiteral o) {
    visitExpression(o);
  }

  public void visitBracketSelectorExpression(@NotNull WeaveBracketSelectorExpression o) {
    visitExpression(o);
  }

  public void visitClojureExpression(@NotNull WeaveClojureExpression o) {
    visitExpression(o);
  }

  public void visitConditionalArrayElement(@NotNull WeaveConditionalArrayElement o) {
    visitPsiElement(o);
  }

  public void visitConditionalAttribute(@NotNull WeaveConditionalAttribute o) {
    visitPsiElement(o);
  }

  public void visitConditionalExpression(@NotNull WeaveConditionalExpression o) {
    visitExpression(o);
  }

  public void visitConditionalKeyValuePair(@NotNull WeaveConditionalKeyValuePair o) {
    visitPsiElement(o);
  }

  public void visitCustomLoader(@NotNull WeaveCustomLoader o) {
    visitPsiElement(o);
  }

  public void visitDataFormat(@NotNull WeaveDataFormat o) {
    visitPsiElement(o);
  }

  public void visitDeclaredNamespace(@NotNull WeaveDeclaredNamespace o) {
    visitPsiElement(o);
  }

  public void visitDefaultPattern(@NotNull WeaveDefaultPattern o) {
    visitPattern(o);
  }

  public void visitDefaultValueExpression(@NotNull WeaveDefaultValueExpression o) {
    visitExpression(o);
  }

  public void visitDirective(@NotNull WeaveDirective o) {
    visitPsiElement(o);
  }

  public void visitDocument(@NotNull WeaveDocument o) {
    visitNavigatablePsiElement(o);
  }

  public void visitDotSelectorExpression(@NotNull WeaveDotSelectorExpression o) {
    visitExpression(o);
  }

  public void visitDynamicKeyValuePair(@NotNull WeaveDynamicKeyValuePair o) {
    visitPsiElement(o);
  }

  public void visitDynamicRangeExpression(@NotNull WeaveDynamicRangeExpression o) {
    visitExpression(o);
  }

  public void visitDynamicSelectorExpression(@NotNull WeaveDynamicSelectorExpression o) {
    visitExpression(o);
  }

  public void visitEnclosedExpression(@NotNull WeaveEnclosedExpression o) {
    visitExpression(o);
  }

  public void visitEqualityExpression(@NotNull WeaveEqualityExpression o) {
    visitExpression(o);
  }

  public void visitExpression(@NotNull WeaveExpression o) {
    visitPsiElement(o);
  }

  public void visitExpressionPattern(@NotNull WeaveExpressionPattern o) {
    visitPattern(o);
    // visitNamedElement(o);
  }

  public void visitFilterSelectorExpression(@NotNull WeaveFilterSelectorExpression o) {
    visitExpression(o);
  }

  public void visitFqnIdentifier(@NotNull WeaveFqnIdentifier o) {
    visitPsiElement(o);
  }

  public void visitFunctionCallExpression(@NotNull WeaveFunctionCallExpression o) {
    visitExpression(o);
  }

  public void visitFunctionDefinition(@NotNull WeaveFunctionDefinition o) {
    visitNamedElement(o);
  }

  public void visitFunctionDirective(@NotNull WeaveFunctionDirective o) {
    visitDirective(o);
  }

  public void visitFunctionParameter(@NotNull WeaveFunctionParameter o) {
    visitVariable(o);
  }

  public void visitGreaterThanExpression(@NotNull WeaveGreaterThanExpression o) {
    visitExpression(o);
  }

  public void visitHeader(@NotNull WeaveHeader o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull WeaveIdentifier o) {
    visitPsiElement(o);
  }

  public void visitIdentifierPackage(@NotNull WeaveIdentifierPackage o) {
    visitPsiElement(o);
  }

  public void visitImportDirective(@NotNull WeaveImportDirective o) {
    visitDirective(o);
  }

  public void visitImportedElement(@NotNull WeaveImportedElement o) {
    visitPsiElement(o);
  }

  public void visitInputDirective(@NotNull WeaveInputDirective o) {
    visitDirective(o);
  }

  public void visitIsExpression(@NotNull WeaveIsExpression o) {
    visitExpression(o);
  }

  public void visitKey(@NotNull WeaveKey o) {
    visitPsiElement(o);
  }

  public void visitKeyExpression(@NotNull WeaveKeyExpression o) {
    visitExpression(o);
  }

  public void visitKeyType(@NotNull WeaveKeyType o) {
    visitType(o);
  }

  public void visitKeyValuePair(@NotNull WeaveKeyValuePair o) {
    visitPsiElement(o);
  }

  public void visitKeyValuePairType(@NotNull WeaveKeyValuePairType o) {
    visitType(o);
  }

  public void visitLambdaLiteral(@NotNull WeaveLambdaLiteral o) {
    visitExpression(o);
  }

  public void visitLiteralExpression(@NotNull WeaveLiteralExpression o) {
    visitExpression(o);
  }

  public void visitLiteralPattern(@NotNull WeaveLiteralPattern o) {
    visitPattern(o);
  }

  public void visitMatchExpression(@NotNull WeaveMatchExpression o) {
    visitExpression(o);
  }

  public void visitMultiValueSelector(@NotNull WeaveMultiValueSelector o) {
    visitPsiElement(o);
  }

  public void visitMultipleKeyValuePairObj(@NotNull WeaveMultipleKeyValuePairObj o) {
    visitPsiElement(o);
  }

  public void visitMultiplicationDivisionExpression(@NotNull WeaveMultiplicationDivisionExpression o) {
    visitExpression(o);
  }

  public void visitNameType(@NotNull WeaveNameType o) {
    visitType(o);
  }

  public void visitNamedLiteralPattern(@NotNull WeaveNamedLiteralPattern o) {
    visitPattern(o);
    // visitNamedElement(o);
  }

  public void visitNamedRegexPattern(@NotNull WeaveNamedRegexPattern o) {
    visitPattern(o);
    // visitNamedElement(o);
  }

  public void visitNamedTypePattern(@NotNull WeaveNamedTypePattern o) {
    visitPattern(o);
    // visitNamedElement(o);
  }

  public void visitNamespaceDirective(@NotNull WeaveNamespaceDirective o) {
    visitDirective(o);
  }

  public void visitNullLiteral(@NotNull WeaveNullLiteral o) {
    visitExpression(o);
  }

  public void visitNumberLiteral(@NotNull WeaveNumberLiteral o) {
    visitExpression(o);
  }

  public void visitObjectExpression(@NotNull WeaveObjectExpression o) {
    visitExpression(o);
    // visitNavigatablePsiElement(o);
  }

  public void visitObjectType(@NotNull WeaveObjectType o) {
    visitType(o);
  }

  public void visitOptionElement(@NotNull WeaveOptionElement o) {
    visitPsiElement(o);
  }

  public void visitOptions(@NotNull WeaveOptions o) {
    visitPsiElement(o);
  }

  public void visitOrExpression(@NotNull WeaveOrExpression o) {
    visitExpression(o);
  }

  public void visitOutputDirective(@NotNull WeaveOutputDirective o) {
    visitDirective(o);
  }

  public void visitPattern(@NotNull WeavePattern o) {
    visitPsiElement(o);
  }

  public void visitPatternMatcherExpression(@NotNull WeavePatternMatcherExpression o) {
    visitExpression(o);
  }

  public void visitRangeExpression(@NotNull WeaveRangeExpression o) {
    visitExpression(o);
  }

  public void visitRangeLiteral(@NotNull WeaveRangeLiteral o) {
    visitExpression(o);
  }

  public void visitRangeSelectorExpression(@NotNull WeaveRangeSelectorExpression o) {
    visitExpression(o);
  }

  public void visitReferenceType(@NotNull WeaveReferenceType o) {
    visitType(o);
  }

  public void visitRegexPattern(@NotNull WeaveRegexPattern o) {
    visitPattern(o);
  }

  public void visitRightLeftExpression(@NotNull WeaveRightLeftExpression o) {
    visitExpression(o);
  }

  public void visitSchema(@NotNull WeaveSchema o) {
    visitPsiElement(o);
  }

  public void visitSchemaElement(@NotNull WeaveSchemaElement o) {
    visitPsiElement(o);
  }

  public void visitSchemaSelector(@NotNull WeaveSchemaSelector o) {
    visitPsiElement(o);
  }

  public void visitSelector(@NotNull WeaveSelector o) {
    visitPsiElement(o);
  }

  public void visitSimpleArrayElement(@NotNull WeaveSimpleArrayElement o) {
    visitPsiElement(o);
  }

  public void visitSimpleKeyValuePair(@NotNull WeaveSimpleKeyValuePair o) {
    visitNavigatablePsiElement(o);
  }

  public void visitSimpleType(@NotNull WeaveSimpleType o) {
    visitType(o);
  }

  public void visitSingleKeyValuePairObj(@NotNull WeaveSingleKeyValuePairObj o) {
    visitPsiElement(o);
  }

  public void visitStringLiteral(@NotNull WeaveStringLiteral o) {
    visitExpression(o);
  }

  public void visitType(@NotNull WeaveType o) {
    visitPsiElement(o);
  }

  public void visitTypeDefinition(@NotNull WeaveTypeDefinition o) {
    visitPsiElement(o);
  }

  public void visitTypeDirective(@NotNull WeaveTypeDirective o) {
    visitDirective(o);
  }

  public void visitTypeLiteral(@NotNull WeaveTypeLiteral o) {
    visitExpression(o);
  }

  public void visitTypePattern(@NotNull WeaveTypePattern o) {
    visitPattern(o);
  }

  public void visitTypeType(@NotNull WeaveTypeType o) {
    visitType(o);
  }

  public void visitUnionType(@NotNull WeaveUnionType o) {
    visitType(o);
  }

  public void visitUsingExpression(@NotNull WeaveUsingExpression o) {
    visitExpression(o);
  }

  public void visitValueExpression(@NotNull WeaveValueExpression o) {
    visitExpression(o);
  }

  public void visitValueSelector(@NotNull WeaveValueSelector o) {
    visitPsiElement(o);
  }

  public void visitVariableDefinition(@NotNull WeaveVariableDefinition o) {
    visitVariable(o);
  }

  public void visitVariableDirective(@NotNull WeaveVariableDirective o) {
    visitDirective(o);
  }

  public void visitVariableReferenceExpression(@NotNull WeaveVariableReferenceExpression o) {
    visitExpression(o);
  }

  public void visitVersionDirective(@NotNull WeaveVersionDirective o) {
    visitDirective(o);
  }

  public void visitNavigatablePsiElement(@NotNull NavigatablePsiElement o) {
    visitElement(o);
  }

  public void visitNamedElement(@NotNull WeaveNamedElement o) {
    visitPsiElement(o);
  }

  public void visitVariable(@NotNull WeaveVariable o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
