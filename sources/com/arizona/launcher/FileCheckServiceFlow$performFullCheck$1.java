package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCheckServiceFlow.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.FileCheckServiceFlow", f = "FileCheckServiceFlow.kt", i = {0, 0}, l = {85}, m = "performFullCheck", n = {"releaseOperation", "operationToken"}, nl = {86}, s = {"L$0", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class FileCheckServiceFlow$performFullCheck$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCheckServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCheckServiceFlow$performFullCheck$1(FileCheckServiceFlow fileCheckServiceFlow, Continuation<? super FileCheckServiceFlow$performFullCheck$1> continuation) {
        super(continuation);
        this.this$0 = fileCheckServiceFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object performFullCheck;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        performFullCheck = this.this$0.performFullCheck(0L, null, this);
        return performFullCheck;
    }
}
