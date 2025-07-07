package ru.mrlargha.commonui.elements.authorization.domain.recovery;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Recovery.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/recovery/SetRecoveryInfo;", "", HintConstants.AUTOFILL_HINT_USERNAME, "", "recoveryMethod", "", "recoveryValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "getRecoveryMethod", "()I", "getRecoveryValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SetRecoveryInfo {
    private final int recoveryMethod;
    private final String recoveryValue;
    private final String username;

    public static /* synthetic */ SetRecoveryInfo copy$default(SetRecoveryInfo setRecoveryInfo, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = setRecoveryInfo.username;
        }
        if ((i2 & 2) != 0) {
            i = setRecoveryInfo.recoveryMethod;
        }
        if ((i2 & 4) != 0) {
            str2 = setRecoveryInfo.recoveryValue;
        }
        return setRecoveryInfo.copy(str, i, str2);
    }

    public final String component1() {
        return this.username;
    }

    public final int component2() {
        return this.recoveryMethod;
    }

    public final String component3() {
        return this.recoveryValue;
    }

    public final SetRecoveryInfo copy(String username, int i, String recoveryValue) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(recoveryValue, "recoveryValue");
        return new SetRecoveryInfo(username, i, recoveryValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SetRecoveryInfo) {
            SetRecoveryInfo setRecoveryInfo = (SetRecoveryInfo) obj;
            return Intrinsics.areEqual(this.username, setRecoveryInfo.username) && this.recoveryMethod == setRecoveryInfo.recoveryMethod && Intrinsics.areEqual(this.recoveryValue, setRecoveryInfo.recoveryValue);
        }
        return false;
    }

    public int hashCode() {
        return (((this.username.hashCode() * 31) + Integer.hashCode(this.recoveryMethod)) * 31) + this.recoveryValue.hashCode();
    }

    public String toString() {
        String str = this.username;
        int i = this.recoveryMethod;
        return "SetRecoveryInfo(username=" + str + ", recoveryMethod=" + i + ", recoveryValue=" + this.recoveryValue + ")";
    }

    public SetRecoveryInfo(String username, int i, String recoveryValue) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(recoveryValue, "recoveryValue");
        this.username = username;
        this.recoveryMethod = i;
        this.recoveryValue = recoveryValue;
    }

    public final int getRecoveryMethod() {
        return this.recoveryMethod;
    }

    public final String getRecoveryValue() {
        return this.recoveryValue;
    }

    public final String getUsername() {
        return this.username;
    }
}
