package ru.mrlargha.commonui.elements.employmentNote.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TasksResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJv\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001d¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/domain/TaskStats;", "", "userName", "", "hoursPlayed", "", "privilegesLevel", "maxPrivilegesLevel", "benefitLevelProgress", "benefitLevelProgressMax", "respectsCount", "viewMode", "", "privilegeStatusCurrent", "privilegeStatusMax", "<init>", "(Ljava/lang/String;IIIIIIZLjava/lang/Integer;Ljava/lang/Integer;)V", "getUserName", "()Ljava/lang/String;", "getHoursPlayed", "()I", "getPrivilegesLevel", "getMaxPrivilegesLevel", "getBenefitLevelProgress", "getBenefitLevelProgressMax", "getRespectsCount", "getViewMode", "()Z", "getPrivilegeStatusCurrent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivilegeStatusMax", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;IIIIIIZLjava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/employmentNote/domain/TaskStats;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskStats {
    private final int benefitLevelProgress;
    private final int benefitLevelProgressMax;
    private final int hoursPlayed;
    private final int maxPrivilegesLevel;
    private final Integer privilegeStatusCurrent;
    private final Integer privilegeStatusMax;
    private final int privilegesLevel;
    private final int respectsCount;
    private final String userName;
    private final boolean viewMode;

    public static /* synthetic */ TaskStats copy$default(TaskStats taskStats, String str, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Integer num, Integer num2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = taskStats.userName;
        }
        if ((i7 & 2) != 0) {
            i = taskStats.hoursPlayed;
        }
        if ((i7 & 4) != 0) {
            i2 = taskStats.privilegesLevel;
        }
        if ((i7 & 8) != 0) {
            i3 = taskStats.maxPrivilegesLevel;
        }
        if ((i7 & 16) != 0) {
            i4 = taskStats.benefitLevelProgress;
        }
        if ((i7 & 32) != 0) {
            i5 = taskStats.benefitLevelProgressMax;
        }
        if ((i7 & 64) != 0) {
            i6 = taskStats.respectsCount;
        }
        if ((i7 & 128) != 0) {
            z = taskStats.viewMode;
        }
        if ((i7 & 256) != 0) {
            num = taskStats.privilegeStatusCurrent;
        }
        if ((i7 & 512) != 0) {
            num2 = taskStats.privilegeStatusMax;
        }
        Integer num3 = num;
        Integer num4 = num2;
        int i8 = i6;
        boolean z2 = z;
        int i9 = i4;
        int i10 = i5;
        return taskStats.copy(str, i, i2, i3, i9, i10, i8, z2, num3, num4);
    }

    public final String component1() {
        return this.userName;
    }

    public final Integer component10() {
        return this.privilegeStatusMax;
    }

    public final int component2() {
        return this.hoursPlayed;
    }

    public final int component3() {
        return this.privilegesLevel;
    }

    public final int component4() {
        return this.maxPrivilegesLevel;
    }

    public final int component5() {
        return this.benefitLevelProgress;
    }

    public final int component6() {
        return this.benefitLevelProgressMax;
    }

    public final int component7() {
        return this.respectsCount;
    }

    public final boolean component8() {
        return this.viewMode;
    }

    public final Integer component9() {
        return this.privilegeStatusCurrent;
    }

    public final TaskStats copy(String userName, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        return new TaskStats(userName, i, i2, i3, i4, i5, i6, z, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TaskStats) {
            TaskStats taskStats = (TaskStats) obj;
            return Intrinsics.areEqual(this.userName, taskStats.userName) && this.hoursPlayed == taskStats.hoursPlayed && this.privilegesLevel == taskStats.privilegesLevel && this.maxPrivilegesLevel == taskStats.maxPrivilegesLevel && this.benefitLevelProgress == taskStats.benefitLevelProgress && this.benefitLevelProgressMax == taskStats.benefitLevelProgressMax && this.respectsCount == taskStats.respectsCount && this.viewMode == taskStats.viewMode && Intrinsics.areEqual(this.privilegeStatusCurrent, taskStats.privilegeStatusCurrent) && Intrinsics.areEqual(this.privilegeStatusMax, taskStats.privilegeStatusMax);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.userName.hashCode() * 31) + Integer.hashCode(this.hoursPlayed)) * 31) + Integer.hashCode(this.privilegesLevel)) * 31) + Integer.hashCode(this.maxPrivilegesLevel)) * 31) + Integer.hashCode(this.benefitLevelProgress)) * 31) + Integer.hashCode(this.benefitLevelProgressMax)) * 31) + Integer.hashCode(this.respectsCount)) * 31) + Boolean.hashCode(this.viewMode)) * 31;
        Integer num = this.privilegeStatusCurrent;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.privilegeStatusMax;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        String str = this.userName;
        int i = this.hoursPlayed;
        int i2 = this.privilegesLevel;
        int i3 = this.maxPrivilegesLevel;
        int i4 = this.benefitLevelProgress;
        int i5 = this.benefitLevelProgressMax;
        int i6 = this.respectsCount;
        boolean z = this.viewMode;
        Integer num = this.privilegeStatusCurrent;
        return "TaskStats(userName=" + str + ", hoursPlayed=" + i + ", privilegesLevel=" + i2 + ", maxPrivilegesLevel=" + i3 + ", benefitLevelProgress=" + i4 + ", benefitLevelProgressMax=" + i5 + ", respectsCount=" + i6 + ", viewMode=" + z + ", privilegeStatusCurrent=" + num + ", privilegeStatusMax=" + this.privilegeStatusMax + ")";
    }

    public TaskStats(String userName, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.userName = userName;
        this.hoursPlayed = i;
        this.privilegesLevel = i2;
        this.maxPrivilegesLevel = i3;
        this.benefitLevelProgress = i4;
        this.benefitLevelProgressMax = i5;
        this.respectsCount = i6;
        this.viewMode = z;
        this.privilegeStatusCurrent = num;
        this.privilegeStatusMax = num2;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final int getHoursPlayed() {
        return this.hoursPlayed;
    }

    public final int getPrivilegesLevel() {
        return this.privilegesLevel;
    }

    public final int getMaxPrivilegesLevel() {
        return this.maxPrivilegesLevel;
    }

    public final int getBenefitLevelProgress() {
        return this.benefitLevelProgress;
    }

    public final int getBenefitLevelProgressMax() {
        return this.benefitLevelProgressMax;
    }

    public final int getRespectsCount() {
        return this.respectsCount;
    }

    public final boolean getViewMode() {
        return this.viewMode;
    }

    public final Integer getPrivilegeStatusCurrent() {
        return this.privilegeStatusCurrent;
    }

    public final Integer getPrivilegeStatusMax() {
        return this.privilegeStatusMax;
    }
}
