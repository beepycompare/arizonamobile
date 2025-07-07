package kotlinx.metadata;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* compiled from: Extensions.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/metadata/KmExtensionType;", "", "klass", "Lkotlin/reflect/KClass;", "Lkotlinx/metadata/KmExtensionVisitor;", "(Lkotlin/reflect/KClass;)V", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmExtensionType {
    private final KClass<? extends KmExtensionVisitor> klass;

    public KmExtensionType(KClass<? extends KmExtensionVisitor> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
    }

    public boolean equals(Object obj) {
        return (obj instanceof KmExtensionType) && Intrinsics.areEqual(this.klass, ((KmExtensionType) obj).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        String name = JvmClassMappingKt.getJavaClass((KClass) this.klass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }
}
