package ru.mrlargha.commonui.elements.donate.presentation.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: DonateBoostModelUi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateModel;", "", "from", "", TypedValues.TransitionType.S_TO, "", "<init>", "(IJ)V", "getFrom", "()I", "getTo", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateRateModel {
    private final int from;
    private final long to;

    public static /* synthetic */ DonateRateModel copy$default(DonateRateModel donateRateModel, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = donateRateModel.from;
        }
        if ((i2 & 2) != 0) {
            j = donateRateModel.to;
        }
        return donateRateModel.copy(i, j);
    }

    public final int component1() {
        return this.from;
    }

    public final long component2() {
        return this.to;
    }

    public final DonateRateModel copy(int i, long j) {
        return new DonateRateModel(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateRateModel) {
            DonateRateModel donateRateModel = (DonateRateModel) obj;
            return this.from == donateRateModel.from && this.to == donateRateModel.to;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.from) * 31) + Long.hashCode(this.to);
    }

    public String toString() {
        int i = this.from;
        return "DonateRateModel(from=" + i + ", to=" + this.to + ")";
    }

    public DonateRateModel(int i, long j) {
        this.from = i;
        this.to = j;
    }

    public final int getFrom() {
        return this.from;
    }

    public final long getTo() {
        return this.to;
    }
}
