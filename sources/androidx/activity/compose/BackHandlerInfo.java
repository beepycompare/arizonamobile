package androidx.activity.compose;

import androidx.navigationevent.NavigationEventInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BackHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/activity/compose/BackHandlerInfo;", "Landroidx/navigationevent/NavigationEventInfo;", "owner", "", "compositeKey", "", "<init>", "(Ljava/lang/Object;J)V", "getOwner", "()Ljava/lang/Object;", "getCompositeKey", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "activity-compose"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class BackHandlerInfo extends NavigationEventInfo {
    private final long compositeKey;
    private final Object owner;

    public static /* synthetic */ BackHandlerInfo copy$default(BackHandlerInfo backHandlerInfo, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = backHandlerInfo.owner;
        }
        if ((i & 2) != 0) {
            j = backHandlerInfo.compositeKey;
        }
        return backHandlerInfo.copy(obj, j);
    }

    public final Object component1() {
        return this.owner;
    }

    public final long component2() {
        return this.compositeKey;
    }

    public final BackHandlerInfo copy(Object obj, long j) {
        return new BackHandlerInfo(obj, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackHandlerInfo) {
            BackHandlerInfo backHandlerInfo = (BackHandlerInfo) obj;
            return Intrinsics.areEqual(this.owner, backHandlerInfo.owner) && this.compositeKey == backHandlerInfo.compositeKey;
        }
        return false;
    }

    public int hashCode() {
        return (this.owner.hashCode() * 31) + Long.hashCode(this.compositeKey);
    }

    public String toString() {
        return "BackHandlerInfo(owner=" + this.owner + ", compositeKey=" + this.compositeKey + ')';
    }

    public BackHandlerInfo(Object obj, long j) {
        this.owner = obj;
        this.compositeKey = j;
    }

    public final long getCompositeKey() {
        return this.compositeKey;
    }

    public final Object getOwner() {
        return this.owner;
    }
}
