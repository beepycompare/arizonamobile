package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "", "defend_fraction_id", "", "attack_fraction_id", "date_unix", "", "<init>", "(IIJ)V", "getDefend_fraction_id", "()I", "getAttack_fraction_id", "getDate_unix", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CaptureData {
    private final int attack_fraction_id;
    private final long date_unix;
    private final int defend_fraction_id;

    public static /* synthetic */ CaptureData copy$default(CaptureData captureData, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = captureData.defend_fraction_id;
        }
        if ((i3 & 2) != 0) {
            i2 = captureData.attack_fraction_id;
        }
        if ((i3 & 4) != 0) {
            j = captureData.date_unix;
        }
        return captureData.copy(i, i2, j);
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

    public final CaptureData copy(int i, int i2, long j) {
        return new CaptureData(i, i2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CaptureData) {
            CaptureData captureData = (CaptureData) obj;
            return this.defend_fraction_id == captureData.defend_fraction_id && this.attack_fraction_id == captureData.attack_fraction_id && this.date_unix == captureData.date_unix;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.defend_fraction_id) * 31) + Integer.hashCode(this.attack_fraction_id)) * 31) + Long.hashCode(this.date_unix);
    }

    public String toString() {
        int i = this.defend_fraction_id;
        int i2 = this.attack_fraction_id;
        return "CaptureData(defend_fraction_id=" + i + ", attack_fraction_id=" + i2 + ", date_unix=" + this.date_unix + ")";
    }

    public CaptureData(int i, int i2, long j) {
        this.defend_fraction_id = i;
        this.attack_fraction_id = i2;
        this.date_unix = j;
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
}
