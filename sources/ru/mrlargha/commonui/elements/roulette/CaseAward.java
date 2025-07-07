package ru.mrlargha.commonui.elements.roulette;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Roulette.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/roulette/CaseAward;", "", "name", "", "data", "sysName", "rarity", "", "url", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getData", "getSysName", "getRarity", "()I", "getUrl", "getDescription", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CaseAward {
    private final String data;
    private final String description;
    private final String name;
    private final int rarity;
    private final String sysName;
    private final String url;

    public static /* synthetic */ CaseAward copy$default(CaseAward caseAward, String str, String str2, String str3, int i, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = caseAward.name;
        }
        if ((i2 & 2) != 0) {
            str2 = caseAward.data;
        }
        if ((i2 & 4) != 0) {
            str3 = caseAward.sysName;
        }
        if ((i2 & 8) != 0) {
            i = caseAward.rarity;
        }
        if ((i2 & 16) != 0) {
            str4 = caseAward.url;
        }
        if ((i2 & 32) != 0) {
            str5 = caseAward.description;
        }
        String str6 = str4;
        String str7 = str5;
        return caseAward.copy(str, str2, str3, i, str6, str7);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.data;
    }

    public final String component3() {
        return this.sysName;
    }

    public final int component4() {
        return this.rarity;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.description;
    }

    public final CaseAward copy(String name, String data, String sysName, int i, String url, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(sysName, "sysName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(description, "description");
        return new CaseAward(name, data, sysName, i, url, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CaseAward) {
            CaseAward caseAward = (CaseAward) obj;
            return Intrinsics.areEqual(this.name, caseAward.name) && Intrinsics.areEqual(this.data, caseAward.data) && Intrinsics.areEqual(this.sysName, caseAward.sysName) && this.rarity == caseAward.rarity && Intrinsics.areEqual(this.url, caseAward.url) && Intrinsics.areEqual(this.description, caseAward.description);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.data.hashCode()) * 31) + this.sysName.hashCode()) * 31) + Integer.hashCode(this.rarity)) * 31) + this.url.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        String str = this.name;
        String str2 = this.data;
        String str3 = this.sysName;
        int i = this.rarity;
        String str4 = this.url;
        return "CaseAward(name=" + str + ", data=" + str2 + ", sysName=" + str3 + ", rarity=" + i + ", url=" + str4 + ", description=" + this.description + ")";
    }

    public CaseAward(String name, String data, String sysName, int i, String url, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(sysName, "sysName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(description, "description");
        this.name = name;
        this.data = data;
        this.sysName = sysName;
        this.rarity = i;
        this.url = url;
        this.description = description;
    }

    public final String getName() {
        return this.name;
    }

    public final String getData() {
        return this.data;
    }

    public final String getSysName() {
        return this.sysName;
    }

    public final int getRarity() {
        return this.rarity;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getDescription() {
        return this.description;
    }
}
