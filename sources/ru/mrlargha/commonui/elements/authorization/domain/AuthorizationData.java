package ru.mrlargha.commonui.elements.authorization.domain;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AuthorizationData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/AuthorizationData;", "", HintConstants.AUTOFILL_HINT_USERNAME, "", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "getPassword", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthorizationData {
    private final String password;
    private final String username;

    public static /* synthetic */ AuthorizationData copy$default(AuthorizationData authorizationData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authorizationData.username;
        }
        if ((i & 2) != 0) {
            str2 = authorizationData.password;
        }
        return authorizationData.copy(str, str2);
    }

    public final String component1() {
        return this.username;
    }

    public final String component2() {
        return this.password;
    }

    public final AuthorizationData copy(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        return new AuthorizationData(username, password);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthorizationData) {
            AuthorizationData authorizationData = (AuthorizationData) obj;
            return Intrinsics.areEqual(this.username, authorizationData.username) && Intrinsics.areEqual(this.password, authorizationData.password);
        }
        return false;
    }

    public int hashCode() {
        return (this.username.hashCode() * 31) + this.password.hashCode();
    }

    public String toString() {
        String str = this.username;
        return "AuthorizationData(username=" + str + ", password=" + this.password + ")";
    }

    public AuthorizationData(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        this.username = username;
        this.password = password;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getUsername() {
        return this.username;
    }
}
