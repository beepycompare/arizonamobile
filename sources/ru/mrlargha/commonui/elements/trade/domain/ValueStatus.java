package ru.mrlargha.commonui.elements.trade.domain;

import kotlin.Metadata;
/* compiled from: TradeValueResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/trade/domain/ValueStatus;", "", "value", "", "type", "", "<init>", "(JI)V", "getValue", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ValueStatus {
    private final int type;
    private final long value;

    public static /* synthetic */ ValueStatus copy$default(ValueStatus valueStatus, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = valueStatus.value;
        }
        if ((i2 & 2) != 0) {
            i = valueStatus.type;
        }
        return valueStatus.copy(j, i);
    }

    public final long component1() {
        return this.value;
    }

    public final int component2() {
        return this.type;
    }

    public final ValueStatus copy(long j, int i) {
        return new ValueStatus(j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ValueStatus) {
            ValueStatus valueStatus = (ValueStatus) obj;
            return this.value == valueStatus.value && this.type == valueStatus.type;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.value) * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        long j = this.value;
        return "ValueStatus(value=" + j + ", type=" + this.type + ")";
    }

    public ValueStatus(long j, int i) {
        this.value = j;
        this.type = i;
    }

    public final long getValue() {
        return this.value;
    }

    public final int getType() {
        return this.type;
    }
}
