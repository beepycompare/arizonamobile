package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class TypeParameter<T> extends TypeCapture<T> {
    final TypeVariable<?> typeVariable;

    protected TypeParameter() {
        Type capture = capture();
        Preconditions.checkArgument(capture instanceof TypeVariable, "%s should be a type variable.", capture);
        this.typeVariable = (TypeVariable) capture;
    }

    public final int hashCode() {
        return this.typeVariable.hashCode();
    }

    public final boolean equals(@CheckForNull Object o) {
        if (o instanceof TypeParameter) {
            return this.typeVariable.equals(((TypeParameter) o).typeVariable);
        }
        return false;
    }

    public String toString() {
        return this.typeVariable.toString();
    }
}
