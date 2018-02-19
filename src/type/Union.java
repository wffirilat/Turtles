package type;

public class Union extends Type {

    public Type[] types;

    public Union(Type t1, Type t2) {
        types = new Type[] {t1, t2};
    }

    public Union(Union u1, Type t2) {
        types = new Type[u1.types.length + 1];
        int i;
        System.arraycopy(u1.types, 0, types, 0, u1.types.length);
        types[u1.types.length] = t2;
    }

    public Union(Type t1, Union u2) {
        types = new Type[1 + u2.types.length];
        types[0] = t1;
        System.arraycopy(u2.types, 0, types, 1, u2.types.length);
    }

    public Union(Union u1, Union u2) {
        types = new Type[u1.types.length + u2.types.length];
        System.arraycopy(u1.types, 0, types, 0, u1.types.length);
        System.arraycopy(u2.types, 0, types, u1.types.length, u2.types.length);
    }
}
