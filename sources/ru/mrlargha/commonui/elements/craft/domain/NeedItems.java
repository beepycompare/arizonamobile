package ru.mrlargha.commonui.elements.craft.domain;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftItemInfo.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/NeedItems;", "", "item", "", "amount", "icon", "", "playerAmount", "", "<init>", "(IILjava/lang/String;J)V", "getItem", "()I", "getAmount", "getIcon", "()Ljava/lang/String;", "getPlayerAmount", "()J", "Lcom/google/gson/annotations/SerializedName;", "value", "player_amount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NeedItems {
    private final int amount;
    private final String icon;
    private final int item;
    @SerializedName("player_amount")
    private final long playerAmount;

    public static /* synthetic */ NeedItems copy$default(NeedItems needItems, int i, int i2, String str, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = needItems.item;
        }
        if ((i3 & 2) != 0) {
            i2 = needItems.amount;
        }
        if ((i3 & 4) != 0) {
            str = needItems.icon;
        }
        if ((i3 & 8) != 0) {
            j = needItems.playerAmount;
        }
        String str2 = str;
        return needItems.copy(i, i2, str2, j);
    }

    public final int component1() {
        return this.item;
    }

    public final int component2() {
        return this.amount;
    }

    public final String component3() {
        return this.icon;
    }

    public final long component4() {
        return this.playerAmount;
    }

    public final NeedItems copy(int i, int i2, String str, long j) {
        return new NeedItems(i, i2, str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NeedItems) {
            NeedItems needItems = (NeedItems) obj;
            return this.item == needItems.item && this.amount == needItems.amount && Intrinsics.areEqual(this.icon, needItems.icon) && this.playerAmount == needItems.playerAmount;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.item) * 31) + Integer.hashCode(this.amount)) * 31;
        String str = this.icon;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.playerAmount);
    }

    public String toString() {
        int i = this.item;
        int i2 = this.amount;
        String str = this.icon;
        return "NeedItems(item=" + i + ", amount=" + i2 + ", icon=" + str + ", playerAmount=" + this.playerAmount + ")";
    }

    public NeedItems(int i, int i2, String str, long j) {
        this.item = i;
        this.amount = i2;
        this.icon = str;
        this.playerAmount = j;
    }

    public /* synthetic */ NeedItems(int i, int i2, String str, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, (i3 & 8) != 0 ? -1L : j);
    }

    public final int getItem() {
        return this.item;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getPlayerAmount() {
        return this.playerAmount;
    }
}
