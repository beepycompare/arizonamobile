package ru.mrlargha.commonui.elements.easter.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AwardItemData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0019\u001a\u00020\tJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/elements/easter/data/AwardItemData;", "", FirebaseAnalytics.Param.LEVEL, "", "title", "", "sysName", "sellPrice", "availableToReceive", "", "wasClicked", "<init>", "(ILjava/lang/String;IIZZ)V", "getLevel", "()I", "getTitle", "()Ljava/lang/String;", "getSysName", "getSellPrice", "getAvailableToReceive", "()Z", "setAvailableToReceive", "(Z)V", "getWasClicked", "setWasClicked", "isAvailable", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AwardItemData {
    private boolean availableToReceive;
    private final int level;
    private final int sellPrice;
    private final int sysName;
    private final String title;
    private boolean wasClicked;

    public static /* synthetic */ AwardItemData copy$default(AwardItemData awardItemData, int i, String str, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = awardItemData.level;
        }
        if ((i4 & 2) != 0) {
            str = awardItemData.title;
        }
        if ((i4 & 4) != 0) {
            i2 = awardItemData.sysName;
        }
        if ((i4 & 8) != 0) {
            i3 = awardItemData.sellPrice;
        }
        if ((i4 & 16) != 0) {
            z = awardItemData.availableToReceive;
        }
        if ((i4 & 32) != 0) {
            z2 = awardItemData.wasClicked;
        }
        boolean z3 = z;
        boolean z4 = z2;
        return awardItemData.copy(i, str, i2, i3, z3, z4);
    }

    public final int component1() {
        return this.level;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.sysName;
    }

    public final int component4() {
        return this.sellPrice;
    }

    public final boolean component5() {
        return this.availableToReceive;
    }

    public final boolean component6() {
        return this.wasClicked;
    }

    public final AwardItemData copy(int i, String title, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new AwardItemData(i, title, i2, i3, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AwardItemData) {
            AwardItemData awardItemData = (AwardItemData) obj;
            return this.level == awardItemData.level && Intrinsics.areEqual(this.title, awardItemData.title) && this.sysName == awardItemData.sysName && this.sellPrice == awardItemData.sellPrice && this.availableToReceive == awardItemData.availableToReceive && this.wasClicked == awardItemData.wasClicked;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.level) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.sysName)) * 31) + Integer.hashCode(this.sellPrice)) * 31) + Boolean.hashCode(this.availableToReceive)) * 31) + Boolean.hashCode(this.wasClicked);
    }

    public String toString() {
        int i = this.level;
        String str = this.title;
        int i2 = this.sysName;
        int i3 = this.sellPrice;
        boolean z = this.availableToReceive;
        return "AwardItemData(level=" + i + ", title=" + str + ", sysName=" + i2 + ", sellPrice=" + i3 + ", availableToReceive=" + z + ", wasClicked=" + this.wasClicked + ")";
    }

    public AwardItemData(int i, String title, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.level = i;
        this.title = title;
        this.sysName = i2;
        this.sellPrice = i3;
        this.availableToReceive = z;
        this.wasClicked = z2;
    }

    public /* synthetic */ AwardItemData(int i, String str, int i2, int i3, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, z, (i4 & 32) != 0 ? false : z2);
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getSysName() {
        return this.sysName;
    }

    public final int getSellPrice() {
        return this.sellPrice;
    }

    public final boolean getAvailableToReceive() {
        return this.availableToReceive;
    }

    public final void setAvailableToReceive(boolean z) {
        this.availableToReceive = z;
    }

    public final boolean getWasClicked() {
        return this.wasClicked;
    }

    public final void setWasClicked(boolean z) {
        this.wasClicked = z;
    }

    public final boolean isAvailable() {
        return this.availableToReceive;
    }
}
