package kotlinx.metadata.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: JvmMemberSignature.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkotlinx/metadata/jvm/JvmFieldSignature;", "Lkotlinx/metadata/jvm/JvmMemberSignature;", "name", "", "descriptor", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescriptor", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmFieldSignature extends JvmMemberSignature {
    private final String descriptor;
    private final String name;

    public static /* synthetic */ JvmFieldSignature copy$default(JvmFieldSignature jvmFieldSignature, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jvmFieldSignature.name;
        }
        if ((i & 2) != 0) {
            str2 = jvmFieldSignature.descriptor;
        }
        return jvmFieldSignature.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.descriptor;
    }

    public final JvmFieldSignature copy(String name, String descriptor) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return new JvmFieldSignature(name, descriptor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JvmFieldSignature) {
            JvmFieldSignature jvmFieldSignature = (JvmFieldSignature) obj;
            return Intrinsics.areEqual(this.name, jvmFieldSignature.name) && Intrinsics.areEqual(this.descriptor, jvmFieldSignature.descriptor);
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.descriptor.hashCode();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFieldSignature(String name, String descriptor) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.name = name;
        this.descriptor = descriptor;
    }

    @Override // kotlinx.metadata.jvm.JvmMemberSignature
    public String getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.metadata.jvm.JvmMemberSignature
    public String getName() {
        return this.name;
    }

    @Override // kotlinx.metadata.jvm.JvmMemberSignature
    public String toString() {
        return getName() + AbstractJsonLexerKt.COLON + getDescriptor();
    }
}
