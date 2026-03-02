package com.arizonagames.feature.arizona.certificate;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/Stat;", "", "title", "", "value", "bonus", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "getBonus", "getIcon", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "certificate"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Stat {
    private final String bonus;
    private final String icon;
    private final String title;
    private final String value;

    public static /* synthetic */ Stat copy$default(Stat stat, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stat.title;
        }
        if ((i & 2) != 0) {
            str2 = stat.value;
        }
        if ((i & 4) != 0) {
            str3 = stat.bonus;
        }
        if ((i & 8) != 0) {
            str4 = stat.icon;
        }
        return stat.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.value;
    }

    public final String component3() {
        return this.bonus;
    }

    public final String component4() {
        return this.icon;
    }

    public final Stat copy(String title, String value, String str, String icon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new Stat(title, value, str, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Stat) {
            Stat stat = (Stat) obj;
            return Intrinsics.areEqual(this.title, stat.title) && Intrinsics.areEqual(this.value, stat.value) && Intrinsics.areEqual(this.bonus, stat.bonus) && Intrinsics.areEqual(this.icon, stat.icon);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.value.hashCode()) * 31;
        String str = this.bonus;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.icon.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = this.value;
        String str3 = this.bonus;
        return "Stat(title=" + str + ", value=" + str2 + ", bonus=" + str3 + ", icon=" + this.icon + ")";
    }

    public Stat(String title, String value, String str, String icon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.title = title;
        this.value = value;
        this.bonus = str;
        this.icon = icon;
    }

    public /* synthetic */ Stat(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, str4);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getBonus() {
        return this.bonus;
    }

    public final String getIcon() {
        return this.icon;
    }
}
