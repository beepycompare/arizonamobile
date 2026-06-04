package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "", "defend_fraction_id", "", "attack_fraction_id", "date_unix", "", "gangzone_id", "<init>", "(IIJLjava/lang/Integer;)V", "getDefend_fraction_id", "()I", "getAttack_fraction_id", "getDate_unix", "()J", "getGangzone_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(IIJLjava/lang/Integer;)Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CaptureData {
    private final int attack_fraction_id;
    private final long date_unix;
    private final int defend_fraction_id;
    private final Integer gangzone_id;

    public static /* synthetic */ CaptureData copy$default(CaptureData captureData, int i, int i2, long j, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = captureData.defend_fraction_id;
        }
        if ((i3 & 2) != 0) {
            i2 = captureData.attack_fraction_id;
        }
        if ((i3 & 4) != 0) {
            j = captureData.date_unix;
        }
        if ((i3 & 8) != 0) {
            num = captureData.gangzone_id;
        }
        Integer num2 = num;
        return captureData.copy(i, i2, j, num2);
    }

    public final int component1() {
        return this.defend_fraction_id;
    }

    public final int component2() {
        return this.attack_fraction_id;
    }

    public final long component3() {
        return this.date_unix;
    }

    public final Integer component4() {
        return this.gangzone_id;
    }

    public final CaptureData copy(int i, int i2, long j, Integer num) {
        return new CaptureData(i, i2, j, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CaptureData) {
            CaptureData captureData = (CaptureData) obj;
            return this.defend_fraction_id == captureData.defend_fraction_id && this.attack_fraction_id == captureData.attack_fraction_id && this.date_unix == captureData.date_unix && Intrinsics.areEqual(this.gangzone_id, captureData.gangzone_id);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.defend_fraction_id) * 31) + Integer.hashCode(this.attack_fraction_id)) * 31) + Long.hashCode(this.date_unix)) * 31;
        Integer num = this.gangzone_id;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        int i = this.defend_fraction_id;
        int i2 = this.attack_fraction_id;
        long j = this.date_unix;
        return "CaptureData(defend_fraction_id=" + i + ", attack_fraction_id=" + i2 + ", date_unix=" + j + ", gangzone_id=" + this.gangzone_id + ")";
    }

    public CaptureData(int i, int i2, long j, Integer num) {
        this.defend_fraction_id = i;
        this.attack_fraction_id = i2;
        this.date_unix = j;
        this.gangzone_id = num;
    }

    public final int getDefend_fraction_id() {
        return this.defend_fraction_id;
    }

    public final int getAttack_fraction_id() {
        return this.attack_fraction_id;
    }

    public final long getDate_unix() {
        return this.date_unix;
    }

    public final Integer getGangzone_id() {
        return this.gangzone_id;
    }
}
