package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudDriftCounterData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004R7\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\b(\u0012¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R7\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0006\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\b(\u0017¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0018\u0010\rR7\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\b\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\b(\u001a¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0019\u0010\rR7\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\u001a\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\b(\u001c¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u001b\u0010\r¨\u0006+"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounterData;", "", "countdownSeconds", "", "points", "", "elapsedSeconds", "multiplier", "minimumSpeedKmh", "currentSpeedKmh", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCountdownSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "alternate", "countdown_seconds", "getPoints", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getElapsedSeconds", "elapsed_seconds", "getMultiplier", "getMinimumSpeedKmh", "minimum_speed_kmh", "getCurrentSpeedKmh", "current_speed_kmh", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounterData;", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftCounterData {
    @SerializedName(alternate = {"countdown_seconds"}, value = "countdownSeconds")
    private final Integer countdownSeconds;
    @SerializedName(alternate = {"current_speed_kmh"}, value = "currentSpeedKmh")
    private final Integer currentSpeedKmh;
    @SerializedName(alternate = {"elapsed_seconds"}, value = "elapsedSeconds")
    private final Integer elapsedSeconds;
    @SerializedName(alternate = {"minimum_speed_kmh"}, value = "minimumSpeedKmh")
    private final Integer minimumSpeedKmh;
    private final Integer multiplier;
    private final Long points;

    public HudDriftCounterData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ HudDriftCounterData copy$default(HudDriftCounterData hudDriftCounterData, Integer num, Long l, Integer num2, Integer num3, Integer num4, Integer num5, int i, Object obj) {
        if ((i & 1) != 0) {
            num = hudDriftCounterData.countdownSeconds;
        }
        if ((i & 2) != 0) {
            l = hudDriftCounterData.points;
        }
        if ((i & 4) != 0) {
            num2 = hudDriftCounterData.elapsedSeconds;
        }
        if ((i & 8) != 0) {
            num3 = hudDriftCounterData.multiplier;
        }
        if ((i & 16) != 0) {
            num4 = hudDriftCounterData.minimumSpeedKmh;
        }
        if ((i & 32) != 0) {
            num5 = hudDriftCounterData.currentSpeedKmh;
        }
        Integer num6 = num4;
        Integer num7 = num5;
        return hudDriftCounterData.copy(num, l, num2, num3, num6, num7);
    }

    public final Integer component1() {
        return this.countdownSeconds;
    }

    public final Long component2() {
        return this.points;
    }

    public final Integer component3() {
        return this.elapsedSeconds;
    }

    public final Integer component4() {
        return this.multiplier;
    }

    public final Integer component5() {
        return this.minimumSpeedKmh;
    }

    public final Integer component6() {
        return this.currentSpeedKmh;
    }

    public final HudDriftCounterData copy(Integer num, Long l, Integer num2, Integer num3, Integer num4, Integer num5) {
        return new HudDriftCounterData(num, l, num2, num3, num4, num5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudDriftCounterData) {
            HudDriftCounterData hudDriftCounterData = (HudDriftCounterData) obj;
            return Intrinsics.areEqual(this.countdownSeconds, hudDriftCounterData.countdownSeconds) && Intrinsics.areEqual(this.points, hudDriftCounterData.points) && Intrinsics.areEqual(this.elapsedSeconds, hudDriftCounterData.elapsedSeconds) && Intrinsics.areEqual(this.multiplier, hudDriftCounterData.multiplier) && Intrinsics.areEqual(this.minimumSpeedKmh, hudDriftCounterData.minimumSpeedKmh) && Intrinsics.areEqual(this.currentSpeedKmh, hudDriftCounterData.currentSpeedKmh);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.countdownSeconds;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.points;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.elapsedSeconds;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.multiplier;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.minimumSpeedKmh;
        int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.currentSpeedKmh;
        return hashCode5 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.countdownSeconds;
        Long l = this.points;
        Integer num2 = this.elapsedSeconds;
        Integer num3 = this.multiplier;
        Integer num4 = this.minimumSpeedKmh;
        return "HudDriftCounterData(countdownSeconds=" + num + ", points=" + l + ", elapsedSeconds=" + num2 + ", multiplier=" + num3 + ", minimumSpeedKmh=" + num4 + ", currentSpeedKmh=" + this.currentSpeedKmh + ")";
    }

    public HudDriftCounterData(Integer num, Long l, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.countdownSeconds = num;
        this.points = l;
        this.elapsedSeconds = num2;
        this.multiplier = num3;
        this.minimumSpeedKmh = num4;
        this.currentSpeedKmh = num5;
    }

    public /* synthetic */ HudDriftCounterData(Integer num, Long l, Integer num2, Integer num3, Integer num4, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5);
    }

    public final Integer getCountdownSeconds() {
        return this.countdownSeconds;
    }

    public final Long getPoints() {
        return this.points;
    }

    public final Integer getElapsedSeconds() {
        return this.elapsedSeconds;
    }

    public final Integer getMultiplier() {
        return this.multiplier;
    }

    public final Integer getMinimumSpeedKmh() {
        return this.minimumSpeedKmh;
    }

    public final Integer getCurrentSpeedKmh() {
        return this.currentSpeedKmh;
    }
}
