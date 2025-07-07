package ru.mrlargha.arizonaui.mobile.domain.obj;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneUberChoseTaxi;", "", "title", "", FirebaseAnalytics.Param.PRICE, "", "isActive", "", "<init>", "(Ljava/lang/String;IZ)V", "getTitle", "()Ljava/lang/String;", "getPrice", "()I", "()Z", "setActive", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneUberChoseTaxi {
    private boolean isActive;
    private final int price;
    private final String title;

    public static /* synthetic */ MobilePhoneUberChoseTaxi copy$default(MobilePhoneUberChoseTaxi mobilePhoneUberChoseTaxi, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mobilePhoneUberChoseTaxi.title;
        }
        if ((i2 & 2) != 0) {
            i = mobilePhoneUberChoseTaxi.price;
        }
        if ((i2 & 4) != 0) {
            z = mobilePhoneUberChoseTaxi.isActive;
        }
        return mobilePhoneUberChoseTaxi.copy(str, i, z);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.price;
    }

    public final boolean component3() {
        return this.isActive;
    }

    public final MobilePhoneUberChoseTaxi copy(String title, int i, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new MobilePhoneUberChoseTaxi(title, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneUberChoseTaxi) {
            MobilePhoneUberChoseTaxi mobilePhoneUberChoseTaxi = (MobilePhoneUberChoseTaxi) obj;
            return Intrinsics.areEqual(this.title, mobilePhoneUberChoseTaxi.title) && this.price == mobilePhoneUberChoseTaxi.price && this.isActive == mobilePhoneUberChoseTaxi.isActive;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + Integer.hashCode(this.price)) * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        String str = this.title;
        int i = this.price;
        return "MobilePhoneUberChoseTaxi(title=" + str + ", price=" + i + ", isActive=" + this.isActive + ")";
    }

    public MobilePhoneUberChoseTaxi(String title, int i, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.price = i;
        this.isActive = z;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }
}
