package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/family/data/FamilyCharterData;", "", "name", "", "leader", "taxCurrent", "", "taxTotal", "incomeDay", "incomeWeek", "incomeMonth", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIII)V", "getName", "()Ljava/lang/String;", "getLeader", "getTaxCurrent", "()I", "getTaxTotal", "getIncomeDay", "getIncomeWeek", "getIncomeMonth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyCharterData {
    private final int incomeDay;
    private final int incomeMonth;
    private final int incomeWeek;
    private final String leader;
    private final String name;
    private final int taxCurrent;
    private final int taxTotal;

    public static /* synthetic */ FamilyCharterData copy$default(FamilyCharterData familyCharterData, String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = familyCharterData.name;
        }
        if ((i6 & 2) != 0) {
            str2 = familyCharterData.leader;
        }
        if ((i6 & 4) != 0) {
            i = familyCharterData.taxCurrent;
        }
        if ((i6 & 8) != 0) {
            i2 = familyCharterData.taxTotal;
        }
        if ((i6 & 16) != 0) {
            i3 = familyCharterData.incomeDay;
        }
        if ((i6 & 32) != 0) {
            i4 = familyCharterData.incomeWeek;
        }
        if ((i6 & 64) != 0) {
            i5 = familyCharterData.incomeMonth;
        }
        int i7 = i4;
        int i8 = i5;
        int i9 = i3;
        int i10 = i;
        return familyCharterData.copy(str, str2, i10, i2, i9, i7, i8);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.leader;
    }

    public final int component3() {
        return this.taxCurrent;
    }

    public final int component4() {
        return this.taxTotal;
    }

    public final int component5() {
        return this.incomeDay;
    }

    public final int component6() {
        return this.incomeWeek;
    }

    public final int component7() {
        return this.incomeMonth;
    }

    public final FamilyCharterData copy(String name, String leader, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(leader, "leader");
        return new FamilyCharterData(name, leader, i, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyCharterData) {
            FamilyCharterData familyCharterData = (FamilyCharterData) obj;
            return Intrinsics.areEqual(this.name, familyCharterData.name) && Intrinsics.areEqual(this.leader, familyCharterData.leader) && this.taxCurrent == familyCharterData.taxCurrent && this.taxTotal == familyCharterData.taxTotal && this.incomeDay == familyCharterData.incomeDay && this.incomeWeek == familyCharterData.incomeWeek && this.incomeMonth == familyCharterData.incomeMonth;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.leader.hashCode()) * 31) + Integer.hashCode(this.taxCurrent)) * 31) + Integer.hashCode(this.taxTotal)) * 31) + Integer.hashCode(this.incomeDay)) * 31) + Integer.hashCode(this.incomeWeek)) * 31) + Integer.hashCode(this.incomeMonth);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.leader;
        int i = this.taxCurrent;
        int i2 = this.taxTotal;
        int i3 = this.incomeDay;
        int i4 = this.incomeWeek;
        return "FamilyCharterData(name=" + str + ", leader=" + str2 + ", taxCurrent=" + i + ", taxTotal=" + i2 + ", incomeDay=" + i3 + ", incomeWeek=" + i4 + ", incomeMonth=" + this.incomeMonth + ")";
    }

    public FamilyCharterData(String name, String leader, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(leader, "leader");
        this.name = name;
        this.leader = leader;
        this.taxCurrent = i;
        this.taxTotal = i2;
        this.incomeDay = i3;
        this.incomeWeek = i4;
        this.incomeMonth = i5;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLeader() {
        return this.leader;
    }

    public final int getTaxCurrent() {
        return this.taxCurrent;
    }

    public final int getTaxTotal() {
        return this.taxTotal;
    }

    public final int getIncomeDay() {
        return this.incomeDay;
    }

    public final int getIncomeWeek() {
        return this.incomeWeek;
    }

    public final int getIncomeMonth() {
        return this.incomeMonth;
    }
}
