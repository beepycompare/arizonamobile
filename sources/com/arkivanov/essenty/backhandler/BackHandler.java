package com.arkivanov.essenty.backhandler;

import kotlin.Metadata;
/* compiled from: BackHandler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/arkivanov/essenty/backhandler/BackHandler;", "", "isRegistered", "", "callback", "Lcom/arkivanov/essenty/backhandler/BackCallback;", "register", "", "unregister", "back-handler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BackHandler {
    boolean isRegistered(BackCallback backCallback);

    void register(BackCallback backCallback);

    void unregister(BackCallback backCallback);
}
