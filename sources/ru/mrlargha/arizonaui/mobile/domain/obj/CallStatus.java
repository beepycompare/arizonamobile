package ru.mrlargha.arizonaui.mobile.domain.obj;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/CallStatus;", "", NotificationCompat.CATEGORY_STATUS, "", "type", "<init>", "(II)V", "getStatus", "()I", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallStatus {
    private final int status;
    private final int type;

    public static /* synthetic */ CallStatus copy$default(CallStatus callStatus, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = callStatus.status;
        }
        if ((i3 & 2) != 0) {
            i2 = callStatus.type;
        }
        return callStatus.copy(i, i2);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.type;
    }

    public final CallStatus copy(int i, int i2) {
        return new CallStatus(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CallStatus) {
            CallStatus callStatus = (CallStatus) obj;
            return this.status == callStatus.status && this.type == callStatus.type;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.status) * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        int i = this.status;
        return "CallStatus(status=" + i + ", type=" + this.type + ")";
    }

    public CallStatus(int i, int i2) {
        this.status = i;
        this.type = i2;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }
}
