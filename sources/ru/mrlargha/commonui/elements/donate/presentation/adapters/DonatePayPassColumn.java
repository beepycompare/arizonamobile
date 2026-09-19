package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassReward;
/* compiled from: DonatePayPassAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassColumn;", "", "reward", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "isFirst", "", "isLast", "markerReached", "fill", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassProgressFill;", "pending", "expired", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;ZZZLru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassProgressFill;ZZ)V", "getReward", "()Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "()Z", "getMarkerReached", "getFill", "()Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassProgressFill;", "getPending", "getExpired", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassColumn {
    private final boolean expired;
    private final DonatePayPassProgressFill fill;
    private final boolean isFirst;
    private final boolean isLast;
    private final boolean markerReached;
    private final boolean pending;
    private final DonatePayPassReward reward;

    public static /* synthetic */ DonatePayPassColumn copy$default(DonatePayPassColumn donatePayPassColumn, DonatePayPassReward donatePayPassReward, boolean z, boolean z2, boolean z3, DonatePayPassProgressFill donatePayPassProgressFill, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            donatePayPassReward = donatePayPassColumn.reward;
        }
        if ((i & 2) != 0) {
            z = donatePayPassColumn.isFirst;
        }
        if ((i & 4) != 0) {
            z2 = donatePayPassColumn.isLast;
        }
        if ((i & 8) != 0) {
            z3 = donatePayPassColumn.markerReached;
        }
        if ((i & 16) != 0) {
            donatePayPassProgressFill = donatePayPassColumn.fill;
        }
        if ((i & 32) != 0) {
            z4 = donatePayPassColumn.pending;
        }
        if ((i & 64) != 0) {
            z5 = donatePayPassColumn.expired;
        }
        boolean z6 = z4;
        boolean z7 = z5;
        DonatePayPassProgressFill donatePayPassProgressFill2 = donatePayPassProgressFill;
        boolean z8 = z2;
        return donatePayPassColumn.copy(donatePayPassReward, z, z8, z3, donatePayPassProgressFill2, z6, z7);
    }

    public final DonatePayPassReward component1() {
        return this.reward;
    }

    public final boolean component2() {
        return this.isFirst;
    }

    public final boolean component3() {
        return this.isLast;
    }

    public final boolean component4() {
        return this.markerReached;
    }

    public final DonatePayPassProgressFill component5() {
        return this.fill;
    }

    public final boolean component6() {
        return this.pending;
    }

    public final boolean component7() {
        return this.expired;
    }

    public final DonatePayPassColumn copy(DonatePayPassReward reward, boolean z, boolean z2, boolean z3, DonatePayPassProgressFill fill, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        Intrinsics.checkNotNullParameter(fill, "fill");
        return new DonatePayPassColumn(reward, z, z2, z3, fill, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassColumn) {
            DonatePayPassColumn donatePayPassColumn = (DonatePayPassColumn) obj;
            return Intrinsics.areEqual(this.reward, donatePayPassColumn.reward) && this.isFirst == donatePayPassColumn.isFirst && this.isLast == donatePayPassColumn.isLast && this.markerReached == donatePayPassColumn.markerReached && this.fill == donatePayPassColumn.fill && this.pending == donatePayPassColumn.pending && this.expired == donatePayPassColumn.expired;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.reward.hashCode() * 31) + Boolean.hashCode(this.isFirst)) * 31) + Boolean.hashCode(this.isLast)) * 31) + Boolean.hashCode(this.markerReached)) * 31) + this.fill.hashCode()) * 31) + Boolean.hashCode(this.pending)) * 31) + Boolean.hashCode(this.expired);
    }

    public String toString() {
        DonatePayPassReward donatePayPassReward = this.reward;
        boolean z = this.isFirst;
        boolean z2 = this.isLast;
        boolean z3 = this.markerReached;
        DonatePayPassProgressFill donatePayPassProgressFill = this.fill;
        boolean z4 = this.pending;
        return "DonatePayPassColumn(reward=" + donatePayPassReward + ", isFirst=" + z + ", isLast=" + z2 + ", markerReached=" + z3 + ", fill=" + donatePayPassProgressFill + ", pending=" + z4 + ", expired=" + this.expired + ")";
    }

    public DonatePayPassColumn(DonatePayPassReward reward, boolean z, boolean z2, boolean z3, DonatePayPassProgressFill fill, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        Intrinsics.checkNotNullParameter(fill, "fill");
        this.reward = reward;
        this.isFirst = z;
        this.isLast = z2;
        this.markerReached = z3;
        this.fill = fill;
        this.pending = z4;
        this.expired = z5;
    }

    public final DonatePayPassReward getReward() {
        return this.reward;
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public final boolean isLast() {
        return this.isLast;
    }

    public final boolean getMarkerReached() {
        return this.markerReached;
    }

    public final DonatePayPassProgressFill getFill() {
        return this.fill;
    }

    public final boolean getPending() {
        return this.pending;
    }

    public final boolean getExpired() {
        return this.expired;
    }
}
