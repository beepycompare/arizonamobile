package com.miami.game.core.external.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExternalNavigationNonFatalException.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/external/navigation/ShareImageNonFatalException;", "Lcom/miami/game/core/external/navigation/ExternalNavigationNonFatalException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShareImageNonFatalException extends ExternalNavigationNonFatalException {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareImageNonFatalException(String message, Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
