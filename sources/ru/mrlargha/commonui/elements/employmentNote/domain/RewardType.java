package ru.mrlargha.commonui.elements.employmentNote.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TasksResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/domain/RewardType;", "", "type", "", "amount", "", "item", "<init>", "(IJLjava/lang/Integer;)V", "getType", "()I", "getAmount", "()J", "getItem", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(IJLjava/lang/Integer;)Lru/mrlargha/commonui/elements/employmentNote/domain/RewardType;", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardType {
    private final long amount;
    private final Integer item;
    private final int type;

    public static /* synthetic */ RewardType copy$default(RewardType rewardType, int i, long j, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rewardType.type;
        }
        if ((i2 & 2) != 0) {
            j = rewardType.amount;
        }
        if ((i2 & 4) != 0) {
            num = rewardType.item;
        }
        return rewardType.copy(i, j, num);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.amount;
    }

    public final Integer component3() {
        return this.item;
    }

    public final RewardType copy(int i, long j, Integer num) {
        return new RewardType(i, j, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RewardType) {
            RewardType rewardType = (RewardType) obj;
            return this.type == rewardType.type && this.amount == rewardType.amount && Intrinsics.areEqual(this.item, rewardType.item);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.type) * 31) + Long.hashCode(this.amount)) * 31;
        Integer num = this.item;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        int i = this.type;
        long j = this.amount;
        return "RewardType(type=" + i + ", amount=" + j + ", item=" + this.item + ")";
    }

    public RewardType(int i, long j, Integer num) {
        this.type = i;
        this.amount = j;
        this.item = num;
    }

    public final int getType() {
        return this.type;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final Integer getItem() {
        return this.item;
    }
}
