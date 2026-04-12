package ru.mrlargha.employment.center.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerData.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lru/mrlargha/employment/center/data/JobInfo;", "", "buttonBits", "", "buttonBitsWhite", "hourSalary", "", "additionalInfo", "", "Lru/mrlargha/employment/center/data/AdditionalInfo;", "myBonusesInfo", "Lru/mrlargha/employment/center/data/BonusItem;", "<init>", "(IIJLjava/util/List;Ljava/util/List;)V", "getButtonBits", "()I", "getButtonBitsWhite", "getHourSalary", "()J", "getAdditionalInfo", "()Ljava/util/List;", "getMyBonusesInfo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "employment-center"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class JobInfo {
    private final List<AdditionalInfo> additionalInfo;
    private final int buttonBits;
    private final int buttonBitsWhite;
    private final long hourSalary;
    private final List<BonusItem> myBonusesInfo;

    public static /* synthetic */ JobInfo copy$default(JobInfo jobInfo, int i, int i2, long j, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = jobInfo.buttonBits;
        }
        if ((i3 & 2) != 0) {
            i2 = jobInfo.buttonBitsWhite;
        }
        if ((i3 & 4) != 0) {
            j = jobInfo.hourSalary;
        }
        List<AdditionalInfo> list3 = list;
        if ((i3 & 8) != 0) {
            list3 = jobInfo.additionalInfo;
        }
        List<BonusItem> list4 = list2;
        if ((i3 & 16) != 0) {
            list4 = jobInfo.myBonusesInfo;
        }
        long j2 = j;
        return jobInfo.copy(i, i2, j2, list3, list4);
    }

    public final int component1() {
        return this.buttonBits;
    }

    public final int component2() {
        return this.buttonBitsWhite;
    }

    public final long component3() {
        return this.hourSalary;
    }

    public final List<AdditionalInfo> component4() {
        return this.additionalInfo;
    }

    public final List<BonusItem> component5() {
        return this.myBonusesInfo;
    }

    public final JobInfo copy(int i, int i2, long j, List<AdditionalInfo> additionalInfo, List<BonusItem> myBonusesInfo) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(myBonusesInfo, "myBonusesInfo");
        return new JobInfo(i, i2, j, additionalInfo, myBonusesInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JobInfo) {
            JobInfo jobInfo = (JobInfo) obj;
            return this.buttonBits == jobInfo.buttonBits && this.buttonBitsWhite == jobInfo.buttonBitsWhite && this.hourSalary == jobInfo.hourSalary && Intrinsics.areEqual(this.additionalInfo, jobInfo.additionalInfo) && Intrinsics.areEqual(this.myBonusesInfo, jobInfo.myBonusesInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.buttonBits) * 31) + Integer.hashCode(this.buttonBitsWhite)) * 31) + Long.hashCode(this.hourSalary)) * 31) + this.additionalInfo.hashCode()) * 31) + this.myBonusesInfo.hashCode();
    }

    public String toString() {
        int i = this.buttonBits;
        int i2 = this.buttonBitsWhite;
        long j = this.hourSalary;
        List<AdditionalInfo> list = this.additionalInfo;
        return "JobInfo(buttonBits=" + i + ", buttonBitsWhite=" + i2 + ", hourSalary=" + j + ", additionalInfo=" + list + ", myBonusesInfo=" + this.myBonusesInfo + ")";
    }

    public JobInfo(int i, int i2, long j, List<AdditionalInfo> additionalInfo, List<BonusItem> myBonusesInfo) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(myBonusesInfo, "myBonusesInfo");
        this.buttonBits = i;
        this.buttonBitsWhite = i2;
        this.hourSalary = j;
        this.additionalInfo = additionalInfo;
        this.myBonusesInfo = myBonusesInfo;
    }

    public final int getButtonBits() {
        return this.buttonBits;
    }

    public final int getButtonBitsWhite() {
        return this.buttonBitsWhite;
    }

    public final long getHourSalary() {
        return this.hourSalary;
    }

    public final List<AdditionalInfo> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final List<BonusItem> getMyBonusesInfo() {
        return this.myBonusesInfo;
    }
}
