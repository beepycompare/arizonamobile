package ru.mrlargha.feature.starter_pack.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StarterPackModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/starter_pack/models/StarterPackRewardsModel;", "", "title", "", "icon", "color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "starter-pack_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StarterPackRewardsModel {
    private final String color;
    private final String icon;
    private final String title;

    public static /* synthetic */ StarterPackRewardsModel copy$default(StarterPackRewardsModel starterPackRewardsModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = starterPackRewardsModel.title;
        }
        if ((i & 2) != 0) {
            str2 = starterPackRewardsModel.icon;
        }
        if ((i & 4) != 0) {
            str3 = starterPackRewardsModel.color;
        }
        return starterPackRewardsModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.color;
    }

    public final StarterPackRewardsModel copy(String title, String icon, String color) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(color, "color");
        return new StarterPackRewardsModel(title, icon, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StarterPackRewardsModel) {
            StarterPackRewardsModel starterPackRewardsModel = (StarterPackRewardsModel) obj;
            return Intrinsics.areEqual(this.title, starterPackRewardsModel.title) && Intrinsics.areEqual(this.icon, starterPackRewardsModel.icon) && Intrinsics.areEqual(this.color, starterPackRewardsModel.color);
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.icon.hashCode()) * 31) + this.color.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = this.icon;
        return "StarterPackRewardsModel(title=" + str + ", icon=" + str2 + ", color=" + this.color + ")";
    }

    public StarterPackRewardsModel(String title, String icon, String color) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(color, "color");
        this.title = title;
        this.icon = icon;
        this.color = color;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getColor() {
        return this.color;
    }
}
