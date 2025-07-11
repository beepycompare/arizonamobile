package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OldPrise.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/OldPrise;", "", "id", "", "title", "", "style", FirebaseAnalytics.Param.PRICE, "image", "time", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getStyle", "getPrice", "getImage", "getTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OldPrise {
    private final int id;
    private final String image;
    private final int price;
    private final String style;
    private final long time;
    private final String title;

    public static /* synthetic */ OldPrise copy$default(OldPrise oldPrise, int i, String str, String str2, int i2, String str3, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = oldPrise.id;
        }
        if ((i3 & 2) != 0) {
            str = oldPrise.title;
        }
        if ((i3 & 4) != 0) {
            str2 = oldPrise.style;
        }
        if ((i3 & 8) != 0) {
            i2 = oldPrise.price;
        }
        if ((i3 & 16) != 0) {
            str3 = oldPrise.image;
        }
        if ((i3 & 32) != 0) {
            j = oldPrise.time;
        }
        long j2 = j;
        String str4 = str3;
        String str5 = str2;
        return oldPrise.copy(i, str, str5, i2, str4, j2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.style;
    }

    public final int component4() {
        return this.price;
    }

    public final String component5() {
        return this.image;
    }

    public final long component6() {
        return this.time;
    }

    public final OldPrise copy(int i, String title, String style, int i2, String image, long j) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(image, "image");
        return new OldPrise(i, title, style, i2, image, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OldPrise) {
            OldPrise oldPrise = (OldPrise) obj;
            return this.id == oldPrise.id && Intrinsics.areEqual(this.title, oldPrise.title) && Intrinsics.areEqual(this.style, oldPrise.style) && this.price == oldPrise.price && Intrinsics.areEqual(this.image, oldPrise.image) && this.time == oldPrise.time;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.style.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + this.image.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.style;
        int i2 = this.price;
        String str3 = this.image;
        return "OldPrise(id=" + i + ", title=" + str + ", style=" + str2 + ", price=" + i2 + ", image=" + str3 + ", time=" + this.time + ")";
    }

    public OldPrise(int i, String title, String style, int i2, String image, long j) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(image, "image");
        this.id = i;
        this.title = title;
        this.style = style;
        this.price = i2;
        this.image = image;
        this.time = j;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getStyle() {
        return this.style;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getImage() {
        return this.image;
    }

    public final long getTime() {
        return this.time;
    }
}
