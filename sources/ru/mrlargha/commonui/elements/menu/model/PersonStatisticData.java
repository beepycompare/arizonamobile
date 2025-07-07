package ru.mrlargha.commonui.elements.menu.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PersonStatisticData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/menu/model/PersonStatisticData;", "", "name", "", FirebaseAnalytics.Param.LEVEL, "", "exp", "maxExp", "<init>", "(Ljava/lang/String;III)V", "getName", "()Ljava/lang/String;", "getLevel", "()I", "getExp", "getMaxExp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonStatisticData {
    private final int exp;
    private final int level;
    @SerializedName("max_exp")
    private final int maxExp;
    private final String name;

    public static /* synthetic */ PersonStatisticData copy$default(PersonStatisticData personStatisticData, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = personStatisticData.name;
        }
        if ((i4 & 2) != 0) {
            i = personStatisticData.level;
        }
        if ((i4 & 4) != 0) {
            i2 = personStatisticData.exp;
        }
        if ((i4 & 8) != 0) {
            i3 = personStatisticData.maxExp;
        }
        return personStatisticData.copy(str, i, i2, i3);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.level;
    }

    public final int component3() {
        return this.exp;
    }

    public final int component4() {
        return this.maxExp;
    }

    public final PersonStatisticData copy(String name, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new PersonStatisticData(name, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PersonStatisticData) {
            PersonStatisticData personStatisticData = (PersonStatisticData) obj;
            return Intrinsics.areEqual(this.name, personStatisticData.name) && this.level == personStatisticData.level && this.exp == personStatisticData.exp && this.maxExp == personStatisticData.maxExp;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.exp)) * 31) + Integer.hashCode(this.maxExp);
    }

    public String toString() {
        String str = this.name;
        int i = this.level;
        int i2 = this.exp;
        return "PersonStatisticData(name=" + str + ", level=" + i + ", exp=" + i2 + ", maxExp=" + this.maxExp + ")";
    }

    public PersonStatisticData(String name, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.level = i;
        this.exp = i2;
        this.maxExp = i3;
    }

    public final String getName() {
        return this.name;
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
}
