package ru.mrlargha.commonui.elements.craft.domain;

import kotlin.Metadata;
/* compiled from: CraftResultResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CraftStart;", "", "time", "", "<init>", "(J)V", "getTime", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftStart {
    private final long time;

    public static /* synthetic */ CraftStart copy$default(CraftStart craftStart, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = craftStart.time;
        }
        return craftStart.copy(j);
    }

    public final long component1() {
        return this.time;
    }

    public final CraftStart copy(long j) {
        return new CraftStart(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CraftStart) && this.time == ((CraftStart) obj).time;
    }

    public int hashCode() {
        return Long.hashCode(this.time);
    }

    public String toString() {
        return "CraftStart(time=" + this.time + ")";
    }

    public CraftStart(long j) {
        this.time = j;
    }

    public final long getTime() {
        return this.time;
    }
}
