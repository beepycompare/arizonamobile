package com.arizona.launcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService", f = "UpdateService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {620}, m = "prepareGameUpdateCheck", n = {"response", "server", "kind", "evaluation", "viceResponse", "operationToken", "migrationPending", "generationIncomplete", "viceEnabled"}, nl = {TypedValues.TransitionType.TYPE_DURATION}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "I$1", "Z$0"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$prepareGameUpdateCheck$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$prepareGameUpdateCheck$1(UpdateService updateService, Continuation<? super UpdateService$prepareGameUpdateCheck$1> continuation) {
        super(continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object prepareGameUpdateCheck;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        prepareGameUpdateCheck = this.this$0.prepareGameUpdateCheck(null, null, null, 0L, this);
        return prepareGameUpdateCheck;
    }
}
