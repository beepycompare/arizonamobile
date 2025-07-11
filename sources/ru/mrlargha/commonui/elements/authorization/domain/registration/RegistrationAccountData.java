package ru.mrlargha.commonui.elements.authorization.domain.registration;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RegistrationAccountData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/registration/RegistrationAccountData;", "", HintConstants.AUTOFILL_HINT_USERNAME, "", HintConstants.AUTOFILL_HINT_PASSWORD, "referralUsername", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "getPassword", "getReferralUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationAccountData {
    private final String password;
    private final String referralUsername;
    private final String username;

    public static /* synthetic */ RegistrationAccountData copy$default(RegistrationAccountData registrationAccountData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationAccountData.username;
        }
        if ((i & 2) != 0) {
            str2 = registrationAccountData.password;
        }
        if ((i & 4) != 0) {
            str3 = registrationAccountData.referralUsername;
        }
        return registrationAccountData.copy(str, str2, str3);
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

    public final RegistrationAccountData copy(String username, String password, String referralUsername) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(referralUsername, "referralUsername");
        return new RegistrationAccountData(username, password, referralUsername);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegistrationAccountData) {
            RegistrationAccountData registrationAccountData = (RegistrationAccountData) obj;
            return Intrinsics.areEqual(this.username, registrationAccountData.username) && Intrinsics.areEqual(this.password, registrationAccountData.password) && Intrinsics.areEqual(this.referralUsername, registrationAccountData.referralUsername);
        }
        return false;
    }

    public int hashCode() {
        return (((this.username.hashCode() * 31) + this.password.hashCode()) * 31) + this.referralUsername.hashCode();
    }

    public String toString() {
        String str = this.username;
        String str2 = this.password;
        return "RegistrationAccountData(username=" + str + ", password=" + str2 + ", referralUsername=" + this.referralUsername + ")";
    }

    public RegistrationAccountData(String username, String password, String referralUsername) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(referralUsername, "referralUsername");
        this.username = username;
        this.password = password;
        this.referralUsername = referralUsername;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getReferralUsername() {
        return this.referralUsername;
    }

    public final String getUsername() {
        return this.username;
    }
}
