package ast;

import builtin.TurObject;
import type.NullType;
import type.Type;
import type.Union;

public class IfStatement implements ASTNode {
    public ASTNode test;
    public ASTNode ifBranch;
    public ASTNode elseBranch;

    public IfStatement(ASTNode test, ASTNode ifBranch) {
        this.test = test;
        this.ifBranch = ifBranch;
    }

    public IfStatement(ASTNode test, ASTNode ifBranch, ASTNode elseBranch) {
        this(test, ifBranch);
        this.elseBranch = elseBranch;
    }

    public Type typeOf() {
        if (elseBranch != null) {
            return new Union(ifBranch.typeOf(), elseBranch.typeOf());
        }
        return new Union(ifBranch.typeOf(), NullType.instance);
    }

    public boolean isConst() {
        if (test.isConst()) {
            if (test.evaluate().toBoolean()) {
                return ifBranch.isConst();
            } else if (elseBranch != null) {
                return elseBranch.isConst();
            }
        }
        return false;
    }

    @Override
    public TurObject evaluate() {
        if (test.evaluate().toBoolean()) {
            return ifBranch.evaluate();
        } else if (elseBranch != null) {
            return elseBranch.evaluate();
        } else { return null; }
    }
}
