package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TokenManager.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0000\u0010\u0002\"\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"isViceCity", "", "()Z", "setViceCity", "(Z)V", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "_token", "", "get_token", "()Ljava/lang/String;", "set_token", "(Ljava/lang/String;)V", "token", "getToken", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TokenManagerKt {
    private static String _token = "";
    private static boolean isViceCity;
    private static int serverId;

    public static final boolean isViceCity() {
        return isViceCity;
    }

    public static final void setViceCity(boolean z) {
        isViceCity = z;
    }

    public static final int getServerId() {
        return serverId;
    }

    public static final void setServerId(int i) {
        serverId = i;
    }

    public static final String get_token() {
        return _token;
    }

    public static final void set_token(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        _token = str;
    }

    public static final String getToken() {
        return "Bearer " + _token;
    }
}
