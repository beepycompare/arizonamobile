package ru.mrlargha.arizonaui.family.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpgradeData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/family/data/UpgradeData;", "", "id", "", "title", "", "desc", "icon", FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.CURRENCY, FirebaseAnalytics.Param.LEVEL, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getDesc", "getIcon", "getPrice", "getCurrency", "getLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpgradeData {
    private final String currency;
    private final String desc;
    private final String icon;
    private final int id;
    private final int level;
    private final int price;
    private final String title;

    public static /* synthetic */ UpgradeData copy$default(UpgradeData upgradeData, int i, String str, String str2, String str3, int i2, String str4, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = upgradeData.id;
        }
        if ((i4 & 2) != 0) {
            str = upgradeData.title;
        }
        if ((i4 & 4) != 0) {
            str2 = upgradeData.desc;
        }
        if ((i4 & 8) != 0) {
            str3 = upgradeData.icon;
        }
        if ((i4 & 16) != 0) {
            i2 = upgradeData.price;
        }
        if ((i4 & 32) != 0) {
            str4 = upgradeData.currency;
        }
        if ((i4 & 64) != 0) {
            i3 = upgradeData.level;
        }
        String str5 = str4;
        int i5 = i3;
        int i6 = i2;
        String str6 = str2;
        return upgradeData.copy(i, str, str6, str3, i6, str5, i5);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.icon;
    }

    public final int component5() {
        return this.price;
    }

    public final String component6() {
        return this.currency;
    }

    public final int component7() {
        return this.level;
    }

    public final UpgradeData copy(int i, String title, String desc, String icon, int i2, String currency, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new UpgradeData(i, title, desc, icon, i2, currency, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpgradeData) {
            UpgradeData upgradeData = (UpgradeData) obj;
            return this.id == upgradeData.id && Intrinsics.areEqual(this.title, upgradeData.title) && Intrinsics.areEqual(this.desc, upgradeData.desc) && Intrinsics.areEqual(this.icon, upgradeData.icon) && this.price == upgradeData.price && Intrinsics.areEqual(this.currency, upgradeData.currency) && this.level == upgradeData.level;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + this.currency.hashCode()) * 31) + Integer.hashCode(this.level);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.desc;
        String str3 = this.icon;
        int i2 = this.price;
        String str4 = this.currency;
        return "UpgradeData(id=" + i + ", title=" + str + ", desc=" + str2 + ", icon=" + str3 + ", price=" + i2 + ", currency=" + str4 + ", level=" + this.level + ")";
    }

    public UpgradeData(int i, String title, String desc, String icon, int i2, String currency, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.id = i;
        this.title = title;
        this.desc = desc;
        this.icon = icon;
        this.price = i2;
        this.currency = currency;
        this.level = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final int getLevel() {
        return this.level;
    }
}
