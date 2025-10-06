package ru.mrlargha.feature.arizona.cases.data.remote.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesBadgesModel;", "", "name", "", "icon", "style", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getIcon", "getStyle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesBadgesModel {
    @SerializedName("icon")
    private final String icon;
    @SerializedName("name")
    private final String name;
    @SerializedName("style")
    private final String style;

    public static /* synthetic */ CasesBadgesModel copy$default(CasesBadgesModel casesBadgesModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = casesBadgesModel.name;
        }
        if ((i & 2) != 0) {
            str2 = casesBadgesModel.icon;
        }
        if ((i & 4) != 0) {
            str3 = casesBadgesModel.style;
        }
        return casesBadgesModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.style;
    }

    public final CasesBadgesModel copy(String name, String icon, String style) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(style, "style");
        return new CasesBadgesModel(name, icon, style);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesBadgesModel) {
            CasesBadgesModel casesBadgesModel = (CasesBadgesModel) obj;
            return Intrinsics.areEqual(this.name, casesBadgesModel.name) && Intrinsics.areEqual(this.icon, casesBadgesModel.icon) && Intrinsics.areEqual(this.style, casesBadgesModel.style);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.icon.hashCode()) * 31) + this.style.hashCode();
    }

    public String toString() {
        String str = this.name;
        String str2 = this.icon;
        return "CasesBadgesModel(name=" + str + ", icon=" + str2 + ", style=" + this.style + ")";
    }

    public CasesBadgesModel(String name, String icon, String style) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(style, "style");
        this.name = name;
        this.icon = icon;
        this.style = style;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getStyle() {
        return this.style;
    }
}
