package ru.mrlargha.employment.center;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EmploymentApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lru/mrlargha/employment/center/Job;", "", "id", "", "type", "name", "", "descriptionMobile", "icon", "minLevel", "avgHourSalary", "bonusSalary", "Lru/mrlargha/employment/center/BonusSalary;", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILru/mrlargha/employment/center/BonusSalary;)V", "getId", "()I", "getType", "getName", "()Ljava/lang/String;", "getDescriptionMobile", "getIcon", "getMinLevel", "getAvgHourSalary", "getBonusSalary", "()Lru/mrlargha/employment/center/BonusSalary;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "employment-center_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Job {
    private final int avgHourSalary;
    private final BonusSalary bonusSalary;
    private final String descriptionMobile;
    private final String icon;
    private final int id;
    private final int minLevel;
    private final String name;
    private final int type;

    public static /* synthetic */ Job copy$default(Job job, int i, int i2, String str, String str2, String str3, int i3, int i4, BonusSalary bonusSalary, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = job.id;
        }
        if ((i5 & 2) != 0) {
            i2 = job.type;
        }
        if ((i5 & 4) != 0) {
            str = job.name;
        }
        if ((i5 & 8) != 0) {
            str2 = job.descriptionMobile;
        }
        if ((i5 & 16) != 0) {
            str3 = job.icon;
        }
        if ((i5 & 32) != 0) {
            i3 = job.minLevel;
        }
        if ((i5 & 64) != 0) {
            i4 = job.avgHourSalary;
        }
        if ((i5 & 128) != 0) {
            bonusSalary = job.bonusSalary;
        }
        int i6 = i4;
        BonusSalary bonusSalary2 = bonusSalary;
        String str4 = str3;
        int i7 = i3;
        return job.copy(i, i2, str, str2, str4, i7, i6, bonusSalary2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.descriptionMobile;
    }

    public final String component5() {
        return this.icon;
    }

    public final int component6() {
        return this.minLevel;
    }

    public final int component7() {
        return this.avgHourSalary;
    }

    public final BonusSalary component8() {
        return this.bonusSalary;
    }

    public final Job copy(int i, int i2, String name, String descriptionMobile, String icon, int i3, int i4, BonusSalary bonusSalary) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptionMobile, "descriptionMobile");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(bonusSalary, "bonusSalary");
        return new Job(i, i2, name, descriptionMobile, icon, i3, i4, bonusSalary);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Job) {
            Job job = (Job) obj;
            return this.id == job.id && this.type == job.type && Intrinsics.areEqual(this.name, job.name) && Intrinsics.areEqual(this.descriptionMobile, job.descriptionMobile) && Intrinsics.areEqual(this.icon, job.icon) && this.minLevel == job.minLevel && this.avgHourSalary == job.avgHourSalary && Intrinsics.areEqual(this.bonusSalary, job.bonusSalary);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.type)) * 31) + this.name.hashCode()) * 31) + this.descriptionMobile.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.minLevel)) * 31) + Integer.hashCode(this.avgHourSalary)) * 31) + this.bonusSalary.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.type;
        String str = this.name;
        String str2 = this.descriptionMobile;
        String str3 = this.icon;
        int i3 = this.minLevel;
        int i4 = this.avgHourSalary;
        return "Job(id=" + i + ", type=" + i2 + ", name=" + str + ", descriptionMobile=" + str2 + ", icon=" + str3 + ", minLevel=" + i3 + ", avgHourSalary=" + i4 + ", bonusSalary=" + this.bonusSalary + ")";
    }

    public Job(int i, int i2, String name, String descriptionMobile, String icon, int i3, int i4, BonusSalary bonusSalary) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptionMobile, "descriptionMobile");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(bonusSalary, "bonusSalary");
        this.id = i;
        this.type = i2;
        this.name = name;
        this.descriptionMobile = descriptionMobile;
        this.icon = icon;
        this.minLevel = i3;
        this.avgHourSalary = i4;
        this.bonusSalary = bonusSalary;
    }

    public final int getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescriptionMobile() {
        return this.descriptionMobile;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getMinLevel() {
        return this.minLevel;
    }

    public final int getAvgHourSalary() {
        return this.avgHourSalary;
    }

    public final BonusSalary getBonusSalary() {
        return this.bonusSalary;
    }
}
