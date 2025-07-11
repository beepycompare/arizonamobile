package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneRate;", "", "rate", "", "isActive", "", "<init>", "(Ljava/lang/String;Z)V", "getRate", "()Ljava/lang/String;", "()Z", "setActive", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneRate {
    private boolean isActive;
    private final String rate;

    public static /* synthetic */ MobilePhoneRate copy$default(MobilePhoneRate mobilePhoneRate, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mobilePhoneRate.rate;
        }
        if ((i & 2) != 0) {
            z = mobilePhoneRate.isActive;
        }
        return mobilePhoneRate.copy(str, z);
    }

    public final String component1() {
        return this.rate;
    }

    public final boolean component2() {
        return this.isActive;
    }

    public final MobilePhoneRate copy(String rate, boolean z) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        return new MobilePhoneRate(rate, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobilePhoneRate) {
            MobilePhoneRate mobilePhoneRate = (MobilePhoneRate) obj;
            return Intrinsics.areEqual(this.rate, mobilePhoneRate.rate) && this.isActive == mobilePhoneRate.isActive;
        }
        return false;
    }

    public int hashCode() {
        return (this.rate.hashCode() * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        String str = this.rate;
        return "MobilePhoneRate(rate=" + str + ", isActive=" + this.isActive + ")";
    }

    public MobilePhoneRate(String rate, boolean z) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.rate = rate;
        this.isActive = z;
    }

    public final String getRate() {
        return this.rate;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }
}
