package com.miami.game.core.gamefiles.info.data.store;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameInfoPrefRepository.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.gamefiles.info.data.store.GameInfoPrefRepository", f = "GameInfoPrefRepository.kt", i = {0, 0, 0}, l = {43}, m = "getCache", n = {"$this$getSuspend$iv", "key$iv", "$i$f$getSuspend"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes4.dex */
public final class GameInfoPrefRepository$getCache$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameInfoPrefRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameInfoPrefRepository$getCache$1(GameInfoPrefRepository gameInfoPrefRepository, Continuation<? super GameInfoPrefRepository$getCache$1> continuation) {
        super(continuation);
        this.this$0 = gameInfoPrefRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCache(this);
    }
}
