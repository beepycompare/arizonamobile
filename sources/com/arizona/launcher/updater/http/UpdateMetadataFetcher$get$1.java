package com.arizona.launcher.updater.http;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateMetadataFetcher.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.http.UpdateMetadataFetcher", f = "UpdateMetadataFetcher.kt", i = {0, 1, 1}, l = {12, 13}, m = "get", n = {"url", "url", "first"}, nl = {13, 14}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateMetadataFetcher$get$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateMetadataFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateMetadataFetcher$get$1(UpdateMetadataFetcher updateMetadataFetcher, Continuation<? super UpdateMetadataFetcher$get$1> continuation) {
        super(continuation);
        this.this$0 = updateMetadataFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.get(null, this);
    }
}
