package org.mule.lang.dw.parser.psi;


import org.jetbrains.annotations.Nullable;

public interface WeaveVariable extends WeaveNamedElement{

    @Nullable
    WeaveExpression getVariableValue();

    @Nullable
    String getVariableName();
}
