package ru.mrlargha.commonui.elements.trade.domain;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TradeInfo.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/trade/domain/TradeInfo;", "", "type", "", "name", "", "limits", "", "", "", "<init>", "(ILjava/lang/String;Ljava/util/Map;)V", "getType", "()I", "getName", "()Ljava/lang/String;", "getLimits", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TradeInfo {
    private final Map<String, List<Long>> limits;
    private final String name;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TradeInfo copy$default(TradeInfo tradeInfo, int i, String str, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tradeInfo.type;
        }
        if ((i2 & 2) != 0) {
            str = tradeInfo.name;
        }
        if ((i2 & 4) != 0) {
            map = tradeInfo.limits;
        }
        return tradeInfo.copy(i, str, map);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final Map<String, List<Long>> component3() {
        return this.limits;
    }

    public final TradeInfo copy(int i, String name, Map<String, ? extends List<Long>> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new TradeInfo(i, name, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TradeInfo) {
            TradeInfo tradeInfo = (TradeInfo) obj;
            return this.type == tradeInfo.type && Intrinsics.areEqual(this.name, tradeInfo.name) && Intrinsics.areEqual(this.limits, tradeInfo.limits);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.type) * 31) + this.name.hashCode()) * 31;
        Map<String, List<Long>> map = this.limits;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        int i = this.type;
        String str = this.name;
        return "TradeInfo(type=" + i + ", name=" + str + ", limits=" + this.limits + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TradeInfo(int i, String name, Map<String, ? extends List<Long>> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = i;
        this.name = name;
        this.limits = map;
    }

    public final int getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ TradeInfo(int i, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, List<Long>> getLimits() {
        return this.limits;
    }
}
