package ast;

import builtin.TurObject;
import type.Type;

public interface ASTNode {
    Type typeOf();
    boolean isConst();
    TurObject evaluate();
}
