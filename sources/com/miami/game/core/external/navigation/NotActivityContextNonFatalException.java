package com.miami.game.core.external.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExternalNavigationNonFatalException.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/external/navigation/NotActivityContextNonFatalException;", "Lcom/miami/game/core/external/navigation/ExternalNavigationNonFatalException;", "message", "", "<init>", "(Ljava/lang/String;)V", "external-navigation_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotActivityContextNonFatalException extends ExternalNavigationNonFatalException {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotActivityContextNonFatalException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
