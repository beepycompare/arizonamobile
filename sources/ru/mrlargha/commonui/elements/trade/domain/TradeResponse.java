package ru.mrlargha.commonui.elements.trade.domain;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TradeResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/trade/domain/TradeResponse;", "", "self", "Lru/mrlargha/commonui/elements/trade/domain/TradeStatus;", TypedValues.AttributesType.S_TARGET, "<init>", "(Lru/mrlargha/commonui/elements/trade/domain/TradeStatus;Lru/mrlargha/commonui/elements/trade/domain/TradeStatus;)V", "getSelf", "()Lru/mrlargha/commonui/elements/trade/domain/TradeStatus;", "getTarget", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TradeResponse {
    private final TradeStatus self;
    private final TradeStatus target;

    public static /* synthetic */ TradeResponse copy$default(TradeResponse tradeResponse, TradeStatus tradeStatus, TradeStatus tradeStatus2, int i, Object obj) {
        if ((i & 1) != 0) {
            tradeStatus = tradeResponse.self;
        }
        if ((i & 2) != 0) {
            tradeStatus2 = tradeResponse.target;
        }
        return tradeResponse.copy(tradeStatus, tradeStatus2);
    }

    public final TradeStatus component1() {
        return this.self;
    }

    public final TradeStatus component2() {
        return this.target;
    }

    public final TradeResponse copy(TradeStatus self, TradeStatus target) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(target, "target");
        return new TradeResponse(self, target);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TradeResponse) {
            TradeResponse tradeResponse = (TradeResponse) obj;
            return Intrinsics.areEqual(this.self, tradeResponse.self) && Intrinsics.areEqual(this.target, tradeResponse.target);
        }
        return false;
    }

    public int hashCode() {
        return (this.self.hashCode() * 31) + this.target.hashCode();
    }

    public String toString() {
        TradeStatus tradeStatus = this.self;
        return "TradeResponse(self=" + tradeStatus + ", target=" + this.target + ")";
    }

    public TradeResponse(TradeStatus self, TradeStatus target) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(target, "target");
        this.self = self;
        this.target = target;
    }

    public final TradeStatus getSelf() {
        return this.self;
    }

    public final TradeStatus getTarget() {
        return this.target;
    }
}
