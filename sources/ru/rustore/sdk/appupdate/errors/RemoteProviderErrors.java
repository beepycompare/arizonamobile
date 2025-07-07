package ru.rustore.sdk.appupdate.errors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.core.exception.RuStoreApplicationBannedException;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.exception.RuStoreUserBannedException;
import ru.rustore.sdk.core.exception.RuStoreUserUnauthorizedException;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/rustore/sdk/appupdate/errors/RemoteProviderErrors;", "", "()V", "ERROR_COMMON", "", "OWNER_BLOCKED", "USER_BLOCKED", "USER_UNAUTHORIZED_ERROR", "toRuStoreException", "Lru/rustore/sdk/core/exception/RuStoreException;", "errorCode", "message", "", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoteProviderErrors {
    private static final int ERROR_COMMON = 999;
    public static final RemoteProviderErrors INSTANCE = new RemoteProviderErrors();
    private static final int OWNER_BLOCKED = 1005;
    private static final int USER_BLOCKED = 1004;
    private static final int USER_UNAUTHORIZED_ERROR = 1001;

    private RemoteProviderErrors() {
    }

    public final RuStoreException toRuStoreException(int i, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return i != 999 ? i != 1001 ? i != 1004 ? i != 1005 ? new RuStoreInstallException(i) : new RuStoreApplicationBannedException() : new RuStoreUserBannedException() : new RuStoreUserUnauthorizedException() : new RuStoreException(message);
    }
}
