package ast;

import type.Type;

public class Block implements ASTNode {
    public ASTNode[] exprs;

    public Block(ASTNode... nodes) {
        exprs = nodes;
    }

    public Type typeOf() {
        return exprs[exprs.length - 1].typeOf();
    }
}
