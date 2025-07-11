package ru.mrlargha.commonui.elements.authorization.domain.registration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RegistrationReferralData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/registration/RegistrationReferralData;", "", "referralMethod", "", "referralUsername", "", "<init>", "(ILjava/lang/String;)V", "getReferralMethod", "()I", "getReferralUsername", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationReferralData {
    private final int referralMethod;
    private final String referralUsername;

    public static /* synthetic */ RegistrationReferralData copy$default(RegistrationReferralData registrationReferralData, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = registrationReferralData.referralMethod;
        }
        if ((i2 & 2) != 0) {
            str = registrationReferralData.referralUsername;
        }
        return registrationReferralData.copy(i, str);
    }

    public final int component1() {
        return this.referralMethod;
    }

    public final String component2() {
        return this.referralUsername;
    }

    public final RegistrationReferralData copy(int i, String str) {
        return new RegistrationReferralData(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegistrationReferralData) {
            RegistrationReferralData registrationReferralData = (RegistrationReferralData) obj;
            return this.referralMethod == registrationReferralData.referralMethod && Intrinsics.areEqual(this.referralUsername, registrationReferralData.referralUsername);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.referralMethod) * 31;
        String str = this.referralUsername;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i = this.referralMethod;
        return "RegistrationReferralData(referralMethod=" + i + ", referralUsername=" + this.referralUsername + ")";
    }

    public RegistrationReferralData(int i, String str) {
        this.referralMethod = i;
        this.referralUsername = str;
    }

    public final int getReferralMethod() {
        return this.referralMethod;
    }

    public final String getReferralUsername() {
        return this.referralUsername;
    }
}
