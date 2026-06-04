package com.arizonagames.feature.arizona.certificate;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J_\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0014\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u0006-"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/MainInfo;", "", "type", "", "title", "", "objectViewer", "Lcom/arizonagames/feature/arizona/certificate/ObjectViewer;", "rarityLevel", "rarity", "stats", "", "Lcom/arizonagames/feature/arizona/certificate/Stat;", FirebaseAnalytics.Param.PRICE, "", "priceCurrencyType", "<init>", "(ILjava/lang/String;Lcom/arizonagames/feature/arizona/certificate/ObjectViewer;IILjava/util/List;JI)V", "getType", "()I", "getTitle", "()Ljava/lang/String;", "getObjectViewer", "()Lcom/arizonagames/feature/arizona/certificate/ObjectViewer;", "getRarityLevel", "getRarity", "getStats", "()Ljava/util/List;", "getPrice", "()J", "getPriceCurrencyType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "certificate"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainInfo {
    private final ObjectViewer objectViewer;
    private final long price;
    private final int priceCurrencyType;
    private final int rarity;
    private final int rarityLevel;
    private final List<Stat> stats;
    private final String title;
    private final int type;

    public static /* synthetic */ MainInfo copy$default(MainInfo mainInfo, int i, String str, ObjectViewer objectViewer, int i2, int i3, List list, long j, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mainInfo.type;
        }
        if ((i5 & 2) != 0) {
            str = mainInfo.title;
        }
        if ((i5 & 4) != 0) {
            objectViewer = mainInfo.objectViewer;
        }
        if ((i5 & 8) != 0) {
            i2 = mainInfo.rarityLevel;
        }
        if ((i5 & 16) != 0) {
            i3 = mainInfo.rarity;
        }
        List<Stat> list2 = list;
        if ((i5 & 32) != 0) {
            list2 = mainInfo.stats;
        }
        if ((i5 & 64) != 0) {
            j = mainInfo.price;
        }
        if ((i5 & 128) != 0) {
            i4 = mainInfo.priceCurrencyType;
        }
        int i6 = i4;
        long j2 = j;
        int i7 = i3;
        List list3 = list2;
        return mainInfo.copy(i, str, objectViewer, i2, i7, list3, j2, i6);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final ObjectViewer component3() {
        return this.objectViewer;
    }

    public final int component4() {
        return this.rarityLevel;
    }

    public final int component5() {
        return this.rarity;
    }

    public final List<Stat> component6() {
        return this.stats;
    }

    public final long component7() {
        return this.price;
    }

    public final int component8() {
        return this.priceCurrencyType;
    }

    public final MainInfo copy(int i, String title, ObjectViewer objectViewer, int i2, int i3, List<Stat> stats, long j, int i4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(objectViewer, "objectViewer");
        Intrinsics.checkNotNullParameter(stats, "stats");
        return new MainInfo(i, title, objectViewer, i2, i3, stats, j, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MainInfo) {
            MainInfo mainInfo = (MainInfo) obj;
            return this.type == mainInfo.type && Intrinsics.areEqual(this.title, mainInfo.title) && Intrinsics.areEqual(this.objectViewer, mainInfo.objectViewer) && this.rarityLevel == mainInfo.rarityLevel && this.rarity == mainInfo.rarity && Intrinsics.areEqual(this.stats, mainInfo.stats) && this.price == mainInfo.price && this.priceCurrencyType == mainInfo.priceCurrencyType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.type) * 31) + this.title.hashCode()) * 31) + this.objectViewer.hashCode()) * 31) + Integer.hashCode(this.rarityLevel)) * 31) + Integer.hashCode(this.rarity)) * 31) + this.stats.hashCode()) * 31) + Long.hashCode(this.price)) * 31) + Integer.hashCode(this.priceCurrencyType);
    }

    public String toString() {
        int i = this.type;
        String str = this.title;
        ObjectViewer objectViewer = this.objectViewer;
        int i2 = this.rarityLevel;
        int i3 = this.rarity;
        List<Stat> list = this.stats;
        long j = this.price;
        return "MainInfo(type=" + i + ", title=" + str + ", objectViewer=" + objectViewer + ", rarityLevel=" + i2 + ", rarity=" + i3 + ", stats=" + list + ", price=" + j + ", priceCurrencyType=" + this.priceCurrencyType + ")";
    }

    public MainInfo(int i, String title, ObjectViewer objectViewer, int i2, int i3, List<Stat> stats, long j, int i4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(objectViewer, "objectViewer");
        Intrinsics.checkNotNullParameter(stats, "stats");
        this.type = i;
        this.title = title;
        this.objectViewer = objectViewer;
        this.rarityLevel = i2;
        this.rarity = i3;
        this.stats = stats;
        this.price = j;
        this.priceCurrencyType = i4;
    }

    public final int getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ObjectViewer getObjectViewer() {
        return this.objectViewer;
    }

    public final int getRarityLevel() {
        return this.rarityLevel;
    }

    public final int getRarity() {
        return this.rarity;
    }

    public final List<Stat> getStats() {
        return this.stats;
    }

    public final long getPrice() {
        return this.price;
    }

    public final int getPriceCurrencyType() {
        return this.priceCurrencyType;
    }
}
