package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PossiblePrise.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/PossiblePrise;", "", "id", "", "title", "", "rarity", FirebaseAnalytics.Param.PRICE, "image", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getRarity", "getPrice", "getImage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PossiblePrise {
    private final int id;
    private final String image;
    private final int price;
    private final String rarity;
    private final String title;

    public static /* synthetic */ PossiblePrise copy$default(PossiblePrise possiblePrise, int i, String str, String str2, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = possiblePrise.id;
        }
        if ((i3 & 2) != 0) {
            str = possiblePrise.title;
        }
        if ((i3 & 4) != 0) {
            str2 = possiblePrise.rarity;
        }
        if ((i3 & 8) != 0) {
            i2 = possiblePrise.price;
        }
        if ((i3 & 16) != 0) {
            str3 = possiblePrise.image;
        }
        String str4 = str3;
        String str5 = str2;
        return possiblePrise.copy(i, str, str5, i2, str4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.rarity;
    }

    public final int component4() {
        return this.price;
    }

    public final String component5() {
        return this.image;
    }

    public final PossiblePrise copy(int i, String title, String rarity, int i2, String image) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(rarity, "rarity");
        Intrinsics.checkNotNullParameter(image, "image");
        return new PossiblePrise(i, title, rarity, i2, image);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PossiblePrise) {
            PossiblePrise possiblePrise = (PossiblePrise) obj;
            return this.id == possiblePrise.id && Intrinsics.areEqual(this.title, possiblePrise.title) && Intrinsics.areEqual(this.rarity, possiblePrise.rarity) && this.price == possiblePrise.price && Intrinsics.areEqual(this.image, possiblePrise.image);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.rarity.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + this.image.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.rarity;
        int i2 = this.price;
        return "PossiblePrise(id=" + i + ", title=" + str + ", rarity=" + str2 + ", price=" + i2 + ", image=" + this.image + ")";
    }

    public PossiblePrise(int i, String title, String rarity, int i2, String image) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(rarity, "rarity");
        Intrinsics.checkNotNullParameter(image, "image");
        this.id = i;
        this.title = title;
        this.rarity = rarity;
        this.price = i2;
        this.image = image;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getRarity() {
        return this.rarity;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getImage() {
        return this.image;
    }
}
