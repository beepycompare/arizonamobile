package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MotionSceneScope.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSetRef;", "", "name", "", "(Ljava/lang/String;)V", "getName$constraintlayout_compose_release", "()Ljava/lang/String;", "component1", "component1$constraintlayout_compose_release", "copy", "equals", "", "other", "hashCode", "", "toString", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConstraintSetRef {
    public static final int $stable = 0;
    private final String name;

    public static /* synthetic */ ConstraintSetRef copy$default(ConstraintSetRef constraintSetRef, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = constraintSetRef.name;
        }
        return constraintSetRef.copy(str);
    }

    public final String component1$constraintlayout_compose_release() {
        return this.name;
    }

    public final ConstraintSetRef copy(String str) {
        return new ConstraintSetRef(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConstraintSetRef) && Intrinsics.areEqual(this.name, ((ConstraintSetRef) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "ConstraintSetRef(name=" + this.name + ')';
    }

    public ConstraintSetRef(String str) {
        this.name = str;
    }

    public final String getName$constraintlayout_compose_release() {
        return this.name;
    }
}
