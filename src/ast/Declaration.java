package ast;

import builtin.TurNull;
import builtin.TurObject;
import type.NullType;
import type.Type;

public class Declaration implements AssignmentTarget{
    public Type type;
    public String name;

    public Declaration(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Type typeOf() {
        return type;
    }

    @Override
    public boolean isConst() {
        return true;
    }

    @Override
    public TurObject evaluate() {
        return TurNull.instance;
    }
}
