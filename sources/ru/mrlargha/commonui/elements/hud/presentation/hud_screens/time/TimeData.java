package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.time;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/TimeData;", "", "timestamp", "", "playedToday", "", "playedHour", "components", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/Component;", "<init>", "(JIILjava/util/List;)V", "getTimestamp", "()J", "getPlayedToday", "()I", "getPlayedHour", "getComponents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TimeData {
    private final List<Component> components;
    private final int playedHour;
    private final int playedToday;
    private final long timestamp;

    public static /* synthetic */ TimeData copy$default(TimeData timeData, long j, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = timeData.timestamp;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            i = timeData.playedToday;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = timeData.playedHour;
        }
        int i5 = i2;
        List<Component> list2 = list;
        if ((i3 & 8) != 0) {
            list2 = timeData.components;
        }
        return timeData.copy(j2, i4, i5, list2);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final int component2() {
        return this.playedToday;
    }

    public final int component3() {
        return this.playedHour;
    }

    public final List<Component> component4() {
        return this.components;
    }

    public final TimeData copy(long j, int i, int i2, List<Component> components) {
        Intrinsics.checkNotNullParameter(components, "components");
        return new TimeData(j, i, i2, components);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimeData) {
            TimeData timeData = (TimeData) obj;
            return this.timestamp == timeData.timestamp && this.playedToday == timeData.playedToday && this.playedHour == timeData.playedHour && Intrinsics.areEqual(this.components, timeData.components);
        }
        return false;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.timestamp) * 31) + Integer.hashCode(this.playedToday)) * 31) + Integer.hashCode(this.playedHour)) * 31) + this.components.hashCode();
    }

    public String toString() {
        long j = this.timestamp;
        int i = this.playedToday;
        int i2 = this.playedHour;
        return "TimeData(timestamp=" + j + ", playedToday=" + i + ", playedHour=" + i2 + ", components=" + this.components + ")";
    }

    public TimeData(long j, int i, int i2, List<Component> components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.timestamp = j;
        this.playedToday = i;
        this.playedHour = i2;
        this.components = components;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getPlayedToday() {
        return this.playedToday;
    }

    public final int getPlayedHour() {
        return this.playedHour;
    }

    public final List<Component> getComponents() {
        return this.components;
    }
}
