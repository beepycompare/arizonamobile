package ru.mrlargha.commonui.elements.easter.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainInfo.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/easter/data/MainInfo;", "", FirebaseAnalytics.Param.LEVEL, "", "exp", "maxExp", "timestampEnd", "", "availableToReceive", "", "<init>", "(IIIJLjava/util/List;)V", "getLevel", "()I", "getExp", "getMaxExp", "getTimestampEnd", "()J", "getAvailableToReceive", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainInfo {
    private final List<Integer> availableToReceive;
    private final int exp;
    private final int level;
    private final int maxExp;
    private final long timestampEnd;

    public static /* synthetic */ MainInfo copy$default(MainInfo mainInfo, int i, int i2, int i3, long j, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = mainInfo.level;
        }
        if ((i4 & 2) != 0) {
            i2 = mainInfo.exp;
        }
        if ((i4 & 4) != 0) {
            i3 = mainInfo.maxExp;
        }
        if ((i4 & 8) != 0) {
            j = mainInfo.timestampEnd;
        }
        List<Integer> list2 = list;
        if ((i4 & 16) != 0) {
            list2 = mainInfo.availableToReceive;
        }
        List list3 = list2;
        int i5 = i3;
        return mainInfo.copy(i, i2, i5, j, list3);
    }

    public final int component1() {
        return this.level;
    }

    public final int component2() {
        return this.exp;
    }

    public final int component3() {
        return this.maxExp;
    }

    public final long component4() {
        return this.timestampEnd;
    }

    public final List<Integer> component5() {
        return this.availableToReceive;
    }

    public final MainInfo copy(int i, int i2, int i3, long j, List<Integer> availableToReceive) {
        Intrinsics.checkNotNullParameter(availableToReceive, "availableToReceive");
        return new MainInfo(i, i2, i3, j, availableToReceive);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MainInfo) {
            MainInfo mainInfo = (MainInfo) obj;
            return this.level == mainInfo.level && this.exp == mainInfo.exp && this.maxExp == mainInfo.maxExp && this.timestampEnd == mainInfo.timestampEnd && Intrinsics.areEqual(this.availableToReceive, mainInfo.availableToReceive);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.level) * 31) + Integer.hashCode(this.exp)) * 31) + Integer.hashCode(this.maxExp)) * 31) + Long.hashCode(this.timestampEnd)) * 31) + this.availableToReceive.hashCode();
    }

    public String toString() {
        int i = this.level;
        int i2 = this.exp;
        int i3 = this.maxExp;
        long j = this.timestampEnd;
        return "MainInfo(level=" + i + ", exp=" + i2 + ", maxExp=" + i3 + ", timestampEnd=" + j + ", availableToReceive=" + this.availableToReceive + ")";
    }

    public MainInfo(int i, int i2, int i3, long j, List<Integer> availableToReceive) {
        Intrinsics.checkNotNullParameter(availableToReceive, "availableToReceive");
        this.level = i;
        this.exp = i2;
        this.maxExp = i3;
        this.timestampEnd = j;
        this.availableToReceive = availableToReceive;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getExp() {
        return this.exp;
    }

    public final int getMaxExp() {
        return this.maxExp;
    }

    public final long getTimestampEnd() {
        return this.timestampEnd;
    }

    public final List<Integer> getAvailableToReceive() {
        return this.availableToReceive;
    }
}
