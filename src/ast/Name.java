package ast;

import builtin.TurObject;
import type.Type;

public class Name implements AssignmentTarget, ASTNode {
    public Declaration declaration;

    public Name(Declaration declaration) {
        this.declaration = declaration;
    }

    public Type typeOf() {
        return declaration.type;
    }

    @Override
    public boolean isConst() {
        return false;
    }

    @Override
    public TurObject evaluate() {
        return null;
    }
}
