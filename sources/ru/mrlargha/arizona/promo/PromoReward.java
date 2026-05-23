package ru.mrlargha.arizona.promo;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006."}, d2 = {"Lru/mrlargha/arizona/promo/PromoReward;", "", "id", "", "image", "", "title", "requirement", "available", "received", "timer", "", "currentAmount", "maxAmount", "color", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJIILjava/lang/String;)V", "getId", "()I", "getImage", "()Ljava/lang/String;", "getTitle", "getRequirement", "getAvailable", "getReceived", "getTimer", "()J", "getCurrentAmount", "getMaxAmount", "getColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", NotificationCompat.CATEGORY_PROMO}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PromoReward {
    private final int available;
    private final String color;
    private final int currentAmount;
    private final int id;
    private final String image;
    private final int maxAmount;
    private final int received;
    private final String requirement;
    private final long timer;
    private final String title;

    public static /* synthetic */ PromoReward copy$default(PromoReward promoReward, int i, String str, String str2, String str3, int i2, int i3, long j, int i4, int i5, String str4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = promoReward.id;
        }
        if ((i6 & 2) != 0) {
            str = promoReward.image;
        }
        if ((i6 & 4) != 0) {
            str2 = promoReward.title;
        }
        if ((i6 & 8) != 0) {
            str3 = promoReward.requirement;
        }
        if ((i6 & 16) != 0) {
            i2 = promoReward.available;
        }
        if ((i6 & 32) != 0) {
            i3 = promoReward.received;
        }
        if ((i6 & 64) != 0) {
            j = promoReward.timer;
        }
        if ((i6 & 128) != 0) {
            i4 = promoReward.currentAmount;
        }
        if ((i6 & 256) != 0) {
            i5 = promoReward.maxAmount;
        }
        if ((i6 & 512) != 0) {
            str4 = promoReward.color;
        }
        String str5 = str4;
        int i7 = i4;
        long j2 = j;
        int i8 = i2;
        int i9 = i3;
        String str6 = str2;
        String str7 = str3;
        return promoReward.copy(i, str, str6, str7, i8, i9, j2, i7, i5, str5);
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.color;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.requirement;
    }

    public final int component5() {
        return this.available;
    }

    public final int component6() {
        return this.received;
    }

    public final long component7() {
        return this.timer;
    }

    public final int component8() {
        return this.currentAmount;
    }

    public final int component9() {
        return this.maxAmount;
    }

    public final PromoReward copy(int i, String image, String title, String requirement, int i2, int i3, long j, int i4, int i5, String color) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(requirement, "requirement");
        Intrinsics.checkNotNullParameter(color, "color");
        return new PromoReward(i, image, title, requirement, i2, i3, j, i4, i5, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PromoReward) {
            PromoReward promoReward = (PromoReward) obj;
            return this.id == promoReward.id && Intrinsics.areEqual(this.image, promoReward.image) && Intrinsics.areEqual(this.title, promoReward.title) && Intrinsics.areEqual(this.requirement, promoReward.requirement) && this.available == promoReward.available && this.received == promoReward.received && this.timer == promoReward.timer && this.currentAmount == promoReward.currentAmount && this.maxAmount == promoReward.maxAmount && Intrinsics.areEqual(this.color, promoReward.color);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.id) * 31) + this.image.hashCode()) * 31) + this.title.hashCode()) * 31) + this.requirement.hashCode()) * 31) + Integer.hashCode(this.available)) * 31) + Integer.hashCode(this.received)) * 31) + Long.hashCode(this.timer)) * 31) + Integer.hashCode(this.currentAmount)) * 31) + Integer.hashCode(this.maxAmount)) * 31) + this.color.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.image;
        String str2 = this.title;
        String str3 = this.requirement;
        int i2 = this.available;
        int i3 = this.received;
        long j = this.timer;
        int i4 = this.currentAmount;
        int i5 = this.maxAmount;
        return "PromoReward(id=" + i + ", image=" + str + ", title=" + str2 + ", requirement=" + str3 + ", available=" + i2 + ", received=" + i3 + ", timer=" + j + ", currentAmount=" + i4 + ", maxAmount=" + i5 + ", color=" + this.color + ")";
    }

    public PromoReward(int i, String image, String title, String requirement, int i2, int i3, long j, int i4, int i5, String color) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(requirement, "requirement");
        Intrinsics.checkNotNullParameter(color, "color");
        this.id = i;
        this.image = image;
        this.title = title;
        this.requirement = requirement;
        this.available = i2;
        this.received = i3;
        this.timer = j;
        this.currentAmount = i4;
        this.maxAmount = i5;
        this.color = color;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getRequirement() {
        return this.requirement;
    }

    public final int getAvailable() {
        return this.available;
    }

    public final int getReceived() {
        return this.received;
    }

    public final long getTimer() {
        return this.timer;
    }

    public final int getCurrentAmount() {
        return this.currentAmount;
    }

    public final int getMaxAmount() {
        return this.maxAmount;
    }

    public final String getColor() {
        return this.color;
    }
}
