package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Promo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/promo/PromoInfo;", "", "title", "", "currentProgress", "", "maxProgress", "<init>", "(Ljava/lang/String;II)V", "getTitle", "()Ljava/lang/String;", "getCurrentProgress", "()I", "getMaxProgress", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoInfo {
    private final int currentProgress;
    private final int maxProgress;
    private final String title;

    public static /* synthetic */ PromoInfo copy$default(PromoInfo promoInfo, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = promoInfo.title;
        }
        if ((i3 & 2) != 0) {
            i = promoInfo.currentProgress;
        }
        if ((i3 & 4) != 0) {
            i2 = promoInfo.maxProgress;
        }
        return promoInfo.copy(str, i, i2);
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

    public final PromoInfo copy(String title, int i, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new PromoInfo(title, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PromoInfo) {
            PromoInfo promoInfo = (PromoInfo) obj;
            return Intrinsics.areEqual(this.title, promoInfo.title) && this.currentProgress == promoInfo.currentProgress && this.maxProgress == promoInfo.maxProgress;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + Integer.hashCode(this.currentProgress)) * 31) + Integer.hashCode(this.maxProgress);
    }

    public String toString() {
        String str = this.title;
        int i = this.currentProgress;
        return "PromoInfo(title=" + str + ", currentProgress=" + i + ", maxProgress=" + this.maxProgress + ")";
    }

    public PromoInfo(String title, int i, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.currentProgress = i;
        this.maxProgress = i2;
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
}
