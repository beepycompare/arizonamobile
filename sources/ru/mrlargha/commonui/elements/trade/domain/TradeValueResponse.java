package ru.mrlargha.commonui.elements.trade.domain;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TradeValueResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/trade/domain/TradeValueResponse;", "", "self", "Lru/mrlargha/commonui/elements/trade/domain/ValueStatus;", TypedValues.AttributesType.S_TARGET, "<init>", "(Lru/mrlargha/commonui/elements/trade/domain/ValueStatus;Lru/mrlargha/commonui/elements/trade/domain/ValueStatus;)V", "getSelf", "()Lru/mrlargha/commonui/elements/trade/domain/ValueStatus;", "getTarget", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TradeValueResponse {
    private final ValueStatus self;
    private final ValueStatus target;

    public static /* synthetic */ TradeValueResponse copy$default(TradeValueResponse tradeValueResponse, ValueStatus valueStatus, ValueStatus valueStatus2, int i, Object obj) {
        if ((i & 1) != 0) {
            valueStatus = tradeValueResponse.self;
        }
        if ((i & 2) != 0) {
            valueStatus2 = tradeValueResponse.target;
        }
        return tradeValueResponse.copy(valueStatus, valueStatus2);
    }

    public final ValueStatus component1() {
        return this.self;
    }

    public final ValueStatus component2() {
        return this.target;
    }

    public final TradeValueResponse copy(ValueStatus self, ValueStatus target) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(target, "target");
        return new TradeValueResponse(self, target);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TradeValueResponse) {
            TradeValueResponse tradeValueResponse = (TradeValueResponse) obj;
            return Intrinsics.areEqual(this.self, tradeValueResponse.self) && Intrinsics.areEqual(this.target, tradeValueResponse.target);
        }
        return false;
    }

    public int hashCode() {
        return (this.self.hashCode() * 31) + this.target.hashCode();
    }

    public String toString() {
        ValueStatus valueStatus = this.self;
        return "TradeValueResponse(self=" + valueStatus + ", target=" + this.target + ")";
    }

    public TradeValueResponse(ValueStatus self, ValueStatus target) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(target, "target");
        this.self = self;
        this.target = target;
    }

    public final ValueStatus getSelf() {
        return this.self;
    }

    public final ValueStatus getTarget() {
        return this.target;
    }
}
