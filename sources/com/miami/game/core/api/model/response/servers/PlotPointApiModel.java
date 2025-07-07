package com.miami.game.core.api.model.response.servers;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlotPointApiModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/api/model/response/servers/PlotPointApiModel;", "", "online", "", "time", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getOnline", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTime", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/miami/game/core/api/model/response/servers/PlotPointApiModel;", "equals", "", "other", "hashCode", "toString", "", "api-model_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlotPointApiModel {
    @SerializedName("online")
    private final Integer online;
    @SerializedName("time")
    private final Integer time;

    public static /* synthetic */ PlotPointApiModel copy$default(PlotPointApiModel plotPointApiModel, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = plotPointApiModel.online;
        }
        if ((i & 2) != 0) {
            num2 = plotPointApiModel.time;
        }
        return plotPointApiModel.copy(num, num2);
    }

    public final Integer component1() {
        return this.online;
    }

    public final Integer component2() {
        return this.time;
    }

    public final PlotPointApiModel copy(Integer num, Integer num2) {
        return new PlotPointApiModel(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlotPointApiModel) {
            PlotPointApiModel plotPointApiModel = (PlotPointApiModel) obj;
            return Intrinsics.areEqual(this.online, plotPointApiModel.online) && Intrinsics.areEqual(this.time, plotPointApiModel.time);
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
        return "PlotPointApiModel(online=" + num + ", time=" + this.time + ")";
    }

    public PlotPointApiModel(Integer num, Integer num2) {
        this.online = num;
        this.time = num2;
    }

    public final Integer getOnline() {
        return this.online;
    }

    public final Integer getTime() {
        return this.time;
    }
}
