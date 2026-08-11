package com.miami.game.core.connection.resolver;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirebaseServerHandler.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.connection.resolver.FirebaseConfigHelper", f = "FirebaseServerHandler.kt", i = {}, l = {TsExtractor.TS_PACKET_SIZE, PsExtractor.PRIVATE_STREAM_1}, m = "bootstrap", n = {}, nl = {PsExtractor.PRIVATE_STREAM_1, -1}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper$bootstrap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirebaseConfigHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseConfigHelper$bootstrap$1(FirebaseConfigHelper firebaseConfigHelper, Continuation<? super FirebaseConfigHelper$bootstrap$1> continuation) {
        super(continuation);
        this.this$0 = firebaseConfigHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.bootstrap(this);
    }
}
