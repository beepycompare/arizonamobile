package ru.mrlargha.commonui.elements.hud.presentation.api.obj;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudApiRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/api/obj/PlotPoints;", "", "online", "", "time", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getOnline", "()Ljava/lang/Integer;", "setOnline", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTime", "setTime", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/hud/presentation/api/obj/PlotPoints;", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlotPoints {
    @SerializedName("online")
    private Integer online;
    @SerializedName("time")
    private Integer time;

    public PlotPoints() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ PlotPoints copy$default(PlotPoints plotPoints, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = plotPoints.online;
        }
        if ((i & 2) != 0) {
            num2 = plotPoints.time;
        }
        return plotPoints.copy(num, num2);
    }

    public final Integer component1() {
        return this.online;
    }

    public final Integer component2() {
        return this.time;
    }

    public final PlotPoints copy(Integer num, Integer num2) {
        return new PlotPoints(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlotPoints) {
            PlotPoints plotPoints = (PlotPoints) obj;
            return Intrinsics.areEqual(this.online, plotPoints.online) && Intrinsics.areEqual(this.time, plotPoints.time);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.online;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.time;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.online;
        return "PlotPoints(online=" + num + ", time=" + this.time + ")";
    }

    public PlotPoints(Integer num, Integer num2) {
        this.online = num;
        this.time = num2;
    }

    public /* synthetic */ PlotPoints(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public final Integer getOnline() {
        return this.online;
    }

    public final void setOnline(Integer num) {
        this.online = num;
    }

    public final Integer getTime() {
        return this.time;
    }

    public final void setTime(Integer num) {
        this.time = num;
    }
}
