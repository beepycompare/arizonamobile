package ru.mrlargha.arizona.promo;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Data.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J}\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0014\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00063"}, d2 = {"Lru/mrlargha/arizona/promo/PromoItem;", "", "id", "", "title", "", "available", "received", "isReferal", "buttonName", "buttonStyle", "timer", "", "badge", "description", "rewards", "", "Lru/mrlargha/arizona/promo/PromoReward;", "<init>", "(ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getAvailable", "getReceived", "getButtonName", "getButtonStyle", "getTimer", "()J", "getBadge", "getDescription", "getRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", NotificationCompat.CATEGORY_PROMO}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PromoItem {
    private final int available;
    private final String badge;
    private final String buttonName;
    private final String buttonStyle;
    private final String description;
    private final int id;
    private final int isReferal;
    private final int received;
    private final List<PromoReward> rewards;
    private final long timer;
    private final String title;

    public static /* synthetic */ PromoItem copy$default(PromoItem promoItem, int i, String str, int i2, int i3, int i4, String str2, String str3, long j, String str4, String str5, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = promoItem.id;
        }
        if ((i5 & 2) != 0) {
            str = promoItem.title;
        }
        if ((i5 & 4) != 0) {
            i2 = promoItem.available;
        }
        if ((i5 & 8) != 0) {
            i3 = promoItem.received;
        }
        if ((i5 & 16) != 0) {
            i4 = promoItem.isReferal;
        }
        if ((i5 & 32) != 0) {
            str2 = promoItem.buttonName;
        }
        if ((i5 & 64) != 0) {
            str3 = promoItem.buttonStyle;
        }
        if ((i5 & 128) != 0) {
            j = promoItem.timer;
        }
        if ((i5 & 256) != 0) {
            str4 = promoItem.badge;
        }
        if ((i5 & 512) != 0) {
            str5 = promoItem.description;
        }
        List<PromoReward> list2 = list;
        if ((i5 & 1024) != 0) {
            list2 = promoItem.rewards;
        }
        List list3 = list2;
        String str6 = str4;
        long j2 = j;
        String str7 = str2;
        String str8 = str3;
        int i6 = i3;
        int i7 = i4;
        int i8 = i2;
        return promoItem.copy(i, str, i8, i6, i7, str7, str8, j2, str6, str5, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.description;
    }

    public final List<PromoReward> component11() {
        return this.rewards;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.available;
    }

    public final int component4() {
        return this.received;
    }

    public final int component5() {
        return this.isReferal;
    }

    public final String component6() {
        return this.buttonName;
    }

    public final String component7() {
        return this.buttonStyle;
    }

    public final long component8() {
        return this.timer;
    }

    public final String component9() {
        return this.badge;
    }

    public final PromoItem copy(int i, String title, int i2, int i3, int i4, String buttonName, String buttonStyle, long j, String badge, String description, List<PromoReward> rewards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        Intrinsics.checkNotNullParameter(buttonStyle, "buttonStyle");
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        return new PromoItem(i, title, i2, i3, i4, buttonName, buttonStyle, j, badge, description, rewards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PromoItem) {
            PromoItem promoItem = (PromoItem) obj;
            return this.id == promoItem.id && Intrinsics.areEqual(this.title, promoItem.title) && this.available == promoItem.available && this.received == promoItem.received && this.isReferal == promoItem.isReferal && Intrinsics.areEqual(this.buttonName, promoItem.buttonName) && Intrinsics.areEqual(this.buttonStyle, promoItem.buttonStyle) && this.timer == promoItem.timer && Intrinsics.areEqual(this.badge, promoItem.badge) && Intrinsics.areEqual(this.description, promoItem.description) && Intrinsics.areEqual(this.rewards, promoItem.rewards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.available)) * 31) + Integer.hashCode(this.received)) * 31) + Integer.hashCode(this.isReferal)) * 31) + this.buttonName.hashCode()) * 31) + this.buttonStyle.hashCode()) * 31) + Long.hashCode(this.timer)) * 31) + this.badge.hashCode()) * 31) + this.description.hashCode()) * 31) + this.rewards.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        int i2 = this.available;
        int i3 = this.received;
        int i4 = this.isReferal;
        String str2 = this.buttonName;
        String str3 = this.buttonStyle;
        long j = this.timer;
        String str4 = this.badge;
        String str5 = this.description;
        return "PromoItem(id=" + i + ", title=" + str + ", available=" + i2 + ", received=" + i3 + ", isReferal=" + i4 + ", buttonName=" + str2 + ", buttonStyle=" + str3 + ", timer=" + j + ", badge=" + str4 + ", description=" + str5 + ", rewards=" + this.rewards + ")";
    }

    public PromoItem(int i, String title, int i2, int i3, int i4, String buttonName, String buttonStyle, long j, String badge, String description, List<PromoReward> rewards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        Intrinsics.checkNotNullParameter(buttonStyle, "buttonStyle");
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        this.id = i;
        this.title = title;
        this.available = i2;
        this.received = i3;
        this.isReferal = i4;
        this.buttonName = buttonName;
        this.buttonStyle = buttonStyle;
        this.timer = j;
        this.badge = badge;
        this.description = description;
        this.rewards = rewards;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getAvailable() {
        return this.available;
    }

    public final int getReceived() {
        return this.received;
    }

    public final int isReferal() {
        return this.isReferal;
    }

    public final String getButtonName() {
        return this.buttonName;
    }

    public final String getButtonStyle() {
        return this.buttonStyle;
    }

    public final long getTimer() {
        return this.timer;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<PromoReward> getRewards() {
        return this.rewards;
    }
}
