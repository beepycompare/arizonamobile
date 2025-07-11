package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService", f = "UpdateService.kt", i = {0, 0, 0, 0}, l = {792}, m = "getFilesToDownload", n = {"sources", "dir", "destDir", "updateFiles"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
public final class UpdateService$getFilesToDownload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$getFilesToDownload$1(UpdateService updateService, Continuation<? super UpdateService$getFilesToDownload$1> continuation) {
        super(continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object filesToDownload;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        filesToDownload = this.this$0.getFilesToDownload(null, null, null, this);
        return filesToDownload;
    }
}
