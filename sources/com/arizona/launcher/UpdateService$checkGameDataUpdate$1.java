package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService", f = "UpdateService.kt", i = {}, l = {757}, m = "checkGameDataUpdate", n = {}, s = {})
/* loaded from: classes3.dex */
public final class UpdateService$checkGameDataUpdate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$checkGameDataUpdate$1(UpdateService updateService, Continuation<? super UpdateService$checkGameDataUpdate$1> continuation) {
        super(continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object checkGameDataUpdate;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkGameDataUpdate = this.this$0.checkGameDataUpdate(null, this);
        return checkGameDataUpdate;
    }
}
