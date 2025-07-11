package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: BattlePassData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/LevelItem;", "", "itemId", "", "available", "value", "<init>", "(III)V", "getItemId", "()I", "getAvailable", "getValue", "isAvailable", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LevelItem {
    private final int available;
    @SerializedName(FirebaseAnalytics.Param.ITEM_ID)
    private final int itemId;
    private final int value;

    public static /* synthetic */ LevelItem copy$default(LevelItem levelItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = levelItem.itemId;
        }
        if ((i4 & 2) != 0) {
            i2 = levelItem.available;
        }
        if ((i4 & 4) != 0) {
            i3 = levelItem.value;
        }
        return levelItem.copy(i, i2, i3);
    }

    public final int component1() {
        return this.itemId;
    }

    public final int component2() {
        return this.available;
    }

    public final int component3() {
        return this.value;
    }

    public final LevelItem copy(int i, int i2, int i3) {
        return new LevelItem(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LevelItem) {
            LevelItem levelItem = (LevelItem) obj;
            return this.itemId == levelItem.itemId && this.available == levelItem.available && this.value == levelItem.value;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.itemId) * 31) + Integer.hashCode(this.available)) * 31) + Integer.hashCode(this.value);
    }

    public String toString() {
        int i = this.itemId;
        int i2 = this.available;
        return "LevelItem(itemId=" + i + ", available=" + i2 + ", value=" + this.value + ")";
    }

    public LevelItem(int i, int i2, int i3) {
        this.itemId = i;
        this.available = i2;
        this.value = i3;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final int getAvailable() {
        return this.available;
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean isAvailable() {
        return this.available == 1;
    }
}
