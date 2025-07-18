package com.miami.game.core.network.error_handler.call_adapter;

import kotlin.Metadata;
/* compiled from: ApiCallException.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0003\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0003\u0010\nB\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/miami/game/core/network/error_handler/call_adapter/ApiCallException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiCallException extends Exception {
    public ApiCallException() {
    }

    public ApiCallException(String str) {
        super(str);
    }

    public ApiCallException(String str, Throwable th) {
        super(str, th);
    }

    public ApiCallException(Throwable th) {
        super(th);
    }
}
