package kotlinx.metadata.jvm;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: JvmMemberSignature.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H&R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/metadata/jvm/JvmMemberSignature;", "", "()V", "desc", "", "getDesc$annotations", "getDesc", "()Ljava/lang/String;", "descriptor", "getDescriptor", "name", "getName", "asString", "toString", "Lkotlinx/metadata/jvm/JvmFieldSignature;", "Lkotlinx/metadata/jvm/JvmMethodSignature;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class JvmMemberSignature {
    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated for removal. Use descriptor instead", replaceWith = @ReplaceWith(expression = "descriptor", imports = {}))
    public static /* synthetic */ void getDesc$annotations() {
    }

    public abstract String getDescriptor();

    public abstract String getName();

    public abstract String toString();

    private JvmMemberSignature() {
    }

    public final String getDesc() {
        return getDescriptor();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "asString() is deprecated as redundant. Use toString() instead", replaceWith = @ReplaceWith(expression = "toString()", imports = {}))
    public final String asString() {
        return toString();
    }
}
