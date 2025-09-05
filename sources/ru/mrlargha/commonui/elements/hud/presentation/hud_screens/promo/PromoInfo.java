package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Promo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/promo/PromoInfo;", "", "title", "", "currentProgress", "", "maxProgress", "text", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getCurrentProgress", "()I", "getMaxProgress", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoInfo {
    @SerializedName("currentProgress")
    private final int currentProgress;
    @SerializedName("maxProgress")
    private final int maxProgress;
    @SerializedName("text")
    private final String text;
    @SerializedName("title")
    private final String title;

    public static /* synthetic */ PromoInfo copy$default(PromoInfo promoInfo, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = promoInfo.title;
        }
        if ((i3 & 2) != 0) {
            i = promoInfo.currentProgress;
        }
        if ((i3 & 4) != 0) {
            i2 = promoInfo.maxProgress;
        }
        if ((i3 & 8) != 0) {
            str2 = promoInfo.text;
        }
        return promoInfo.copy(str, i, i2, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.currentProgress;
    }

    public final int component3() {
        return this.maxProgress;
    }

    public final String component4() {
        return this.text;
    }

    public final PromoInfo copy(String title, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new PromoInfo(title, i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PromoInfo) {
            PromoInfo promoInfo = (PromoInfo) obj;
            return Intrinsics.areEqual(this.title, promoInfo.title) && this.currentProgress == promoInfo.currentProgress && this.maxProgress == promoInfo.maxProgress && Intrinsics.areEqual(this.text, promoInfo.text);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + Integer.hashCode(this.currentProgress)) * 31) + Integer.hashCode(this.maxProgress)) * 31;
        String str = this.text;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.title;
        int i = this.currentProgress;
        int i2 = this.maxProgress;
        return "PromoInfo(title=" + str + ", currentProgress=" + i + ", maxProgress=" + i2 + ", text=" + this.text + ")";
    }

    public PromoInfo(String title, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.currentProgress = i;
        this.maxProgress = i2;
        this.text = str;
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
