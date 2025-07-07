package kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lkotlinx/metadata/KmFlexibleTypeUpperBound;", "", "type", "Lkotlinx/metadata/KmType;", "typeFlexibilityId", "", "(Lkotlinx/metadata/KmType;Ljava/lang/String;)V", "getType", "()Lkotlinx/metadata/KmType;", "setType", "(Lkotlinx/metadata/KmType;)V", "getTypeFlexibilityId", "()Ljava/lang/String;", "setTypeFlexibilityId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmFlexibleTypeUpperBound {
    private KmType type;
    private String typeFlexibilityId;

    public static /* synthetic */ KmFlexibleTypeUpperBound copy$default(KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound, KmType kmType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            kmType = kmFlexibleTypeUpperBound.type;
        }
        if ((i & 2) != 0) {
            str = kmFlexibleTypeUpperBound.typeFlexibilityId;
        }
        return kmFlexibleTypeUpperBound.copy(kmType, str);
    }

    public final KmType component1() {
        return this.type;
    }

    public final String component2() {
        return this.typeFlexibilityId;
    }

    public final KmFlexibleTypeUpperBound copy(KmType type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new KmFlexibleTypeUpperBound(type, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KmFlexibleTypeUpperBound) {
            KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = (KmFlexibleTypeUpperBound) obj;
            return Intrinsics.areEqual(this.type, kmFlexibleTypeUpperBound.type) && Intrinsics.areEqual(this.typeFlexibilityId, kmFlexibleTypeUpperBound.typeFlexibilityId);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.typeFlexibilityId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "KmFlexibleTypeUpperBound(type=" + this.type + ", typeFlexibilityId=" + this.typeFlexibilityId + ')';
    }

    public KmFlexibleTypeUpperBound(KmType type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.typeFlexibilityId = str;
    }

    public final KmType getType() {
        return this.type;
    }

    public final String getTypeFlexibilityId() {
        return this.typeFlexibilityId;
    }

    public final void setType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.type = kmType;
    }

    public final void setTypeFlexibilityId(String str) {
        this.typeFlexibilityId = str;
    }
}
