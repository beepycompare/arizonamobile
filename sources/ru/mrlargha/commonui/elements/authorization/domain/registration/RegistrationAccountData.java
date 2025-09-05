package ru.mrlargha.commonui.elements.authorization.domain.registration;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RegistrationAccountData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/registration/RegistrationAccountData;", "", HintConstants.AUTOFILL_HINT_USERNAME, "", HintConstants.AUTOFILL_HINT_PASSWORD, "referralUsername", "promocode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "getPassword", "getReferralUsername", "getPromocode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationAccountData {
    private final String password;
    private final String promocode;
    private final String referralUsername;
    private final String username;

    public static /* synthetic */ RegistrationAccountData copy$default(RegistrationAccountData registrationAccountData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationAccountData.username;
        }
        if ((i & 2) != 0) {
            str2 = registrationAccountData.password;
        }
        if ((i & 4) != 0) {
            str3 = registrationAccountData.referralUsername;
        }
        if ((i & 8) != 0) {
            str4 = registrationAccountData.promocode;
        }
        return registrationAccountData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.username;
    }

    public final String component2() {
        return this.password;
    }

    public final String component3() {
        return this.referralUsername;
    }

    public final String component4() {
        return this.promocode;
    }

    public final RegistrationAccountData copy(String username, String password, String referralUsername, String promocode) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(referralUsername, "referralUsername");
        Intrinsics.checkNotNullParameter(promocode, "promocode");
        return new RegistrationAccountData(username, password, referralUsername, promocode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegistrationAccountData) {
            RegistrationAccountData registrationAccountData = (RegistrationAccountData) obj;
            return Intrinsics.areEqual(this.username, registrationAccountData.username) && Intrinsics.areEqual(this.password, registrationAccountData.password) && Intrinsics.areEqual(this.referralUsername, registrationAccountData.referralUsername) && Intrinsics.areEqual(this.promocode, registrationAccountData.promocode);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.username.hashCode() * 31) + this.password.hashCode()) * 31) + this.referralUsername.hashCode()) * 31) + this.promocode.hashCode();
    }

    public String toString() {
        String str = this.username;
        String str2 = this.password;
        String str3 = this.referralUsername;
        return "RegistrationAccountData(username=" + str + ", password=" + str2 + ", referralUsername=" + str3 + ", promocode=" + this.promocode + ")";
    }

    public RegistrationAccountData(String username, String password, String referralUsername, String promocode) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(referralUsername, "referralUsername");
        Intrinsics.checkNotNullParameter(promocode, "promocode");
        this.username = username;
        this.password = password;
        this.referralUsername = referralUsername;
        this.promocode = promocode;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPromocode() {
        return this.promocode;
    }

    public final String getReferralUsername() {
        return this.referralUsername;
    }

    public final String getUsername() {
        return this.username;
    }
}
