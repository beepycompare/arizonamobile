package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService", f = "UpdateService.kt", i = {0, 0}, l = {354}, m = "runPrimaryGameCheckPreflight", n = {"operationToken", "startedAtElapsedMs"}, nl = {355}, s = {"J$0", "J$1"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$runPrimaryGameCheckPreflight$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$runPrimaryGameCheckPreflight$1(UpdateService updateService, Continuation<? super UpdateService$runPrimaryGameCheckPreflight$1> continuation) {
        super(continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object runPrimaryGameCheckPreflight;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runPrimaryGameCheckPreflight = this.this$0.runPrimaryGameCheckPreflight(0L, this);
        return runPrimaryGameCheckPreflight;
    }
}
