package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FactionCaptureData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R5\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\f\b\u0010\u0012\b\b\fJ\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR5\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004\u0012\f\b\u0010\u0012\b\b\fJ\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR7\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\f\b\u0010\u0012\b\b\fJ\u0004\b\b(\u0017¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R7\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0007\u0012\f\b\u0010\u0012\b\b\fJ\u0004\b\b(\u0019¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R7\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\b\u0012\f\b\u0010\u0012\b\b\fJ\u0004\b\b(\u001b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\r¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureData;", "", "leftFaction", "", "rightFaction", "leftScore", "", "rightScore", "remainingSeconds", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getLeftFaction", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "alternate", "left_faction", "getRightFaction", "right_faction", "getLeftScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "left_score", "getRightScore", "right_score", "getRemainingSeconds", "remaining_seconds", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureData;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FactionCaptureData {
    @SerializedName(alternate = {"left_faction"}, value = "leftFaction")
    private final String leftFaction;
    @SerializedName(alternate = {"left_score"}, value = "leftScore")
    private final Integer leftScore;
    @SerializedName(alternate = {"remaining_seconds"}, value = "remainingSeconds")
    private final Integer remainingSeconds;
    @SerializedName(alternate = {"right_faction"}, value = "rightFaction")
    private final String rightFaction;
    @SerializedName(alternate = {"right_score"}, value = "rightScore")
    private final Integer rightScore;
    private final String status;

    public FactionCaptureData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FactionCaptureData copy$default(FactionCaptureData factionCaptureData, String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = factionCaptureData.leftFaction;
        }
        if ((i & 2) != 0) {
            str2 = factionCaptureData.rightFaction;
        }
        if ((i & 4) != 0) {
            num = factionCaptureData.leftScore;
        }
        if ((i & 8) != 0) {
            num2 = factionCaptureData.rightScore;
        }
        if ((i & 16) != 0) {
            num3 = factionCaptureData.remainingSeconds;
        }
        if ((i & 32) != 0) {
            str3 = factionCaptureData.status;
        }
        Integer num4 = num3;
        String str4 = str3;
        return factionCaptureData.copy(str, str2, num, num2, num4, str4);
    }

    public final String component1() {
        return this.leftFaction;
    }

    public final String component2() {
        return this.rightFaction;
    }

    public final Integer component3() {
        return this.leftScore;
    }

    public final Integer component4() {
        return this.rightScore;
    }

    public final Integer component5() {
        return this.remainingSeconds;
    }

    public final String component6() {
        return this.status;
    }

    public final FactionCaptureData copy(String str, String str2, Integer num, Integer num2, Integer num3, String str3) {
        return new FactionCaptureData(str, str2, num, num2, num3, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FactionCaptureData) {
            FactionCaptureData factionCaptureData = (FactionCaptureData) obj;
            return Intrinsics.areEqual(this.leftFaction, factionCaptureData.leftFaction) && Intrinsics.areEqual(this.rightFaction, factionCaptureData.rightFaction) && Intrinsics.areEqual(this.leftScore, factionCaptureData.leftScore) && Intrinsics.areEqual(this.rightScore, factionCaptureData.rightScore) && Intrinsics.areEqual(this.remainingSeconds, factionCaptureData.remainingSeconds) && Intrinsics.areEqual(this.status, factionCaptureData.status);
        }
        return false;
    }

    public int hashCode() {
        String str = this.leftFaction;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.rightFaction;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.leftScore;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.rightScore;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.remainingSeconds;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.status;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.leftFaction;
        String str2 = this.rightFaction;
        Integer num = this.leftScore;
        Integer num2 = this.rightScore;
        Integer num3 = this.remainingSeconds;
        return "FactionCaptureData(leftFaction=" + str + ", rightFaction=" + str2 + ", leftScore=" + num + ", rightScore=" + num2 + ", remainingSeconds=" + num3 + ", status=" + this.status + ")";
    }

    public FactionCaptureData(String str, String str2, Integer num, Integer num2, Integer num3, String str3) {
        this.leftFaction = str;
        this.rightFaction = str2;
        this.leftScore = num;
        this.rightScore = num2;
        this.remainingSeconds = num3;
        this.status = str3;
    }

    public /* synthetic */ FactionCaptureData(String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str3);
    }

    public final String getLeftFaction() {
        return this.leftFaction;
    }

    public final String getRightFaction() {
        return this.rightFaction;
    }

    public final Integer getLeftScore() {
        return this.leftScore;
    }

    public final Integer getRightScore() {
        return this.rightScore;
    }

    public final Integer getRemainingSeconds() {
        return this.remainingSeconds;
    }

    public final String getStatus() {
        return this.status;
    }
}
