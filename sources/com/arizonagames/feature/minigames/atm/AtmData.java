package com.arizonagames.feature.minigames.atm;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AtmScreen.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/AtmData;", "", "maxCount", "", "count", "type", "<init>", "(III)V", "getMaxCount", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "getCount", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "atm"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AtmData {
    @SerializedName("count")
    private final int count;
    @SerializedName("maxCount")
    private final int maxCount;
    @SerializedName("type")
    private final int type;

    public AtmData() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ AtmData copy$default(AtmData atmData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = atmData.maxCount;
        }
        if ((i4 & 2) != 0) {
            i2 = atmData.count;
        }
        if ((i4 & 4) != 0) {
            i3 = atmData.type;
        }
        return atmData.copy(i, i2, i3);
    }

    public final int component1() {
        return this.maxCount;
    }

    public final int component2() {
        return this.count;
    }

    public final int component3() {
        return this.type;
    }

    public final AtmData copy(int i, int i2, int i3) {
        return new AtmData(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AtmData) {
            AtmData atmData = (AtmData) obj;
            return this.maxCount == atmData.maxCount && this.count == atmData.count && this.type == atmData.type;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.maxCount) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        int i = this.maxCount;
        int i2 = this.count;
        return "AtmData(maxCount=" + i + ", count=" + i2 + ", type=" + this.type + ")";
    }

    public AtmData(int i, int i2, int i3) {
        this.maxCount = i;
        this.count = i2;
        this.type = i3;
    }

    public /* synthetic */ AtmData(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 50 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getType() {
        return this.type;
    }
}
