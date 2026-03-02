package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Promo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/promo/PromoInfo;", "", NotificationCompat.CATEGORY_PROMO, "", "title", "currentProgress", "", "maxProgress", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getPromo", "()Ljava/lang/String;", "getTitle", "getCurrentProgress", "()I", "getMaxProgress", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PromoInfo {
    @SerializedName("currentProgress")
    private final int currentProgress;
    @SerializedName("maxProgress")
    private final int maxProgress;
    @SerializedName(NotificationCompat.CATEGORY_PROMO)
    private final String promo;
    @SerializedName("text")
    private final String text;
    @SerializedName("title")
    private final String title;

    public static /* synthetic */ PromoInfo copy$default(PromoInfo promoInfo, String str, String str2, int i, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = promoInfo.promo;
        }
        if ((i3 & 2) != 0) {
            str2 = promoInfo.title;
        }
        if ((i3 & 4) != 0) {
            i = promoInfo.currentProgress;
        }
        if ((i3 & 8) != 0) {
            i2 = promoInfo.maxProgress;
        }
        if ((i3 & 16) != 0) {
            str3 = promoInfo.text;
        }
        String str4 = str3;
        int i4 = i;
        return promoInfo.copy(str, str2, i4, i2, str4);
    }

    public final String component1() {
        return this.promo;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.currentProgress;
    }

    public final int component4() {
        return this.maxProgress;
    }

    public final String component5() {
        return this.text;
    }

    public final PromoInfo copy(String promo, String title, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(promo, "promo");
        Intrinsics.checkNotNullParameter(title, "title");
        return new PromoInfo(promo, title, i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PromoInfo) {
            PromoInfo promoInfo = (PromoInfo) obj;
            return Intrinsics.areEqual(this.promo, promoInfo.promo) && Intrinsics.areEqual(this.title, promoInfo.title) && this.currentProgress == promoInfo.currentProgress && this.maxProgress == promoInfo.maxProgress && Intrinsics.areEqual(this.text, promoInfo.text);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.promo.hashCode() * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.currentProgress)) * 31) + Integer.hashCode(this.maxProgress)) * 31;
        String str = this.text;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.promo;
        String str2 = this.title;
        int i = this.currentProgress;
        int i2 = this.maxProgress;
        return "PromoInfo(promo=" + str + ", title=" + str2 + ", currentProgress=" + i + ", maxProgress=" + i2 + ", text=" + this.text + ")";
    }

    public PromoInfo(String promo, String title, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(promo, "promo");
        Intrinsics.checkNotNullParameter(title, "title");
        this.promo = promo;
        this.title = title;
        this.currentProgress = i;
        this.maxProgress = i2;
        this.text = str;
    }

    public final String getPromo() {
        return this.promo;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getCurrentProgress() {
        return this.currentProgress;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    public final String getText() {
        return this.text;
    }
}
