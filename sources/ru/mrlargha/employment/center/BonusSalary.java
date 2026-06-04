package ru.mrlargha.employment.center;

import kotlin.Metadata;
/* compiled from: EmploymentApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/employment/center/BonusSalary;", "", "percent", "", "endUnixTime", "", "<init>", "(IJ)V", "getPercent", "()I", "getEndUnixTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "employment-center"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BonusSalary {
    private final long endUnixTime;
    private final int percent;

    public static /* synthetic */ BonusSalary copy$default(BonusSalary bonusSalary, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bonusSalary.percent;
        }
        if ((i2 & 2) != 0) {
            j = bonusSalary.endUnixTime;
        }
        return bonusSalary.copy(i, j);
    }

    public final int component1() {
        return this.percent;
    }

    public final long component2() {
        return this.endUnixTime;
    }

    public final BonusSalary copy(int i, long j) {
        return new BonusSalary(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BonusSalary) {
            BonusSalary bonusSalary = (BonusSalary) obj;
            return this.percent == bonusSalary.percent && this.endUnixTime == bonusSalary.endUnixTime;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.percent) * 31) + Long.hashCode(this.endUnixTime);
    }

    public String toString() {
        int i = this.percent;
        return "BonusSalary(percent=" + i + ", endUnixTime=" + this.endUnixTime + ")";
    }

    public BonusSalary(int i, long j) {
        this.percent = i;
        this.endUnixTime = j;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final long getEndUnixTime() {
        return this.endUnixTime;
    }
}
