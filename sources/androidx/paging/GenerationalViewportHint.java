package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PageFetcherSnapshot.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "", "generationId", "", "hint", "Landroidx/paging/ViewportHint;", "<init>", "(ILandroidx/paging/ViewportHint;)V", "getGenerationId", "()I", "getHint", "()Landroidx/paging/ViewportHint;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GenerationalViewportHint {
    private final int generationId;
    private final ViewportHint hint;

    public static /* synthetic */ GenerationalViewportHint copy$default(GenerationalViewportHint generationalViewportHint, int i, ViewportHint viewportHint, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = generationalViewportHint.generationId;
        }
        if ((i2 & 2) != 0) {
            viewportHint = generationalViewportHint.hint;
        }
        return generationalViewportHint.copy(i, viewportHint);
    }

    public final int component1() {
        return this.generationId;
    }

    public final ViewportHint component2() {
        return this.hint;
    }

    public final GenerationalViewportHint copy(int i, ViewportHint hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        return new GenerationalViewportHint(i, hint);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenerationalViewportHint) {
            GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) obj;
            return this.generationId == generationalViewportHint.generationId && Intrinsics.areEqual(this.hint, generationalViewportHint.hint);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.generationId) * 31) + this.hint.hashCode();
    }

    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.generationId + ", hint=" + this.hint + ')';
    }

    public GenerationalViewportHint(int i, ViewportHint hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.generationId = i;
        this.hint = hint;
    }

    public final int getGenerationId() {
        return this.generationId;
    }

    public final ViewportHint getHint() {
        return this.hint;
    }
}
