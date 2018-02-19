package ast;

import builtin.TurObject;
import type.Type;

public class Assignment implements ASTNode {
    public AssignmentTarget target;
    public ASTNode value;

    public Assignment(AssignmentTarget target, ASTNode value) {
        this.target = target;
        this.value = value;
    }

    @Override
    public Type typeOf() {
        return value.typeOf();
    }

    @Override
    public boolean isConst() {
        return value.isConst();
    }

    @Override
    public TurObject evaluate() {
        return value.evaluate();
    }
}
