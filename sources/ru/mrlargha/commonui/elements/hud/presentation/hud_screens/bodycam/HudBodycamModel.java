package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.bodycam;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: HudBodycamModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/bodycam/HudBodycamModel;", "", "number", "", "seconds", "", "timestamp", "<init>", "(IJJ)V", "getNumber", "()I", "getSeconds", "()J", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudBodycamModel {
    @SerializedName("id")
    private final int number;
    private final long seconds;
    private final long timestamp;

    public static /* synthetic */ HudBodycamModel copy$default(HudBodycamModel hudBodycamModel, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hudBodycamModel.number;
        }
        if ((i2 & 2) != 0) {
            j = hudBodycamModel.seconds;
        }
        if ((i2 & 4) != 0) {
            j2 = hudBodycamModel.timestamp;
        }
        return hudBodycamModel.copy(i, j, j2);
    }

    public final int component1() {
        return this.number;
    }

    public final long component2() {
        return this.seconds;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final HudBodycamModel copy(int i, long j, long j2) {
        return new HudBodycamModel(i, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudBodycamModel) {
            HudBodycamModel hudBodycamModel = (HudBodycamModel) obj;
            return this.number == hudBodycamModel.number && this.seconds == hudBodycamModel.seconds && this.timestamp == hudBodycamModel.timestamp;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.number) * 31) + Long.hashCode(this.seconds)) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        int i = this.number;
        long j = this.seconds;
        return "HudBodycamModel(number=" + i + ", seconds=" + j + ", timestamp=" + this.timestamp + ")";
    }

    public HudBodycamModel(int i, long j, long j2) {
        this.number = i;
        this.seconds = j;
        this.timestamp = j2;
    }

    public final int getNumber() {
        return this.number;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
