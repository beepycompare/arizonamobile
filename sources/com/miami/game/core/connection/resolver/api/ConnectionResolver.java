package com.miami.game.core.connection.resolver.api;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
/* compiled from: ConnectionResolver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0007J\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0007J\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0007¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "", "getDownloadFilesChannel", "Lkotlin/Pair;", "", "", "channel", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServerMobileList", "getServerDesktopList", "getGameFilesInfoServer", "getNewsServer", "connection-resolver_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ConnectionResolver {
    Object getDownloadFilesChannel(int i, Continuation<? super Pair<String, Integer>> continuation);

    Object getGameFilesInfoServer(int i, Continuation<? super Pair<String, Integer>> continuation);

    Object getNewsServer(int i, Continuation<? super Pair<String, Integer>> continuation);

    Object getServerDesktopList(int i, Continuation<? super Pair<String, Integer>> continuation);

    Object getServerMobileList(int i, Continuation<? super Pair<String, Integer>> continuation);
}
