package com.arkivanov.decompose.mainthread;

import kotlin.Metadata;
/* compiled from: NotOnMainThreadException.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/mainthread/NotOnMainThreadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "currentThreadName", "", "<init>", "(Ljava/lang/String;)V", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotOnMainThreadException extends Exception {
    public NotOnMainThreadException(String str) {
        super("Expected to be called on the main thread, but was " + (str == null ? "unknown" : str));
    }
}
