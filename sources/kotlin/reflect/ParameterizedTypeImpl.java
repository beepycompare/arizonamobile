package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001a"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "getRawType", "getOwnerType", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> rawType, Type type, List<? extends Type> typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.rawType = rawType;
        this.ownerType = type;
        this.typeArguments = (Type[]) typeArguments.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public String getTypeName() {
        String typeToString;
        String typeToString2;
        StringBuilder sb = new StringBuilder();
        Type type = this.ownerType;
        if (type != null) {
            typeToString2 = TypesJVMKt.typeToString(type);
            sb.append(typeToString2);
            sb.append("$");
            sb.append(this.rawType.getSimpleName());
        } else {
            typeToString = TypesJVMKt.typeToString(this.rawType);
            sb.append(typeToString);
        }
        Type[] typeArr = this.typeArguments;
        if (!(typeArr.length == 0)) {
            ArraysKt.joinTo(typeArr, sb, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : "<", (r14 & 8) != 0 ? "" : ">", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : ParameterizedTypeImpl$getTypeName$1$1.INSTANCE);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return Intrinsics.areEqual(this.rawType, parameterizedType.getRawType()) && Intrinsics.areEqual(this.ownerType, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.rawType.hashCode();
        Type type = this.ownerType;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
