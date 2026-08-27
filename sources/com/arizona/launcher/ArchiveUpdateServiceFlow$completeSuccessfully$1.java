package com.arizona.launcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ArchiveUpdateServiceFlow", f = "ArchiveUpdateServiceFlow.kt", i = {0, 0}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "completeSuccessfully", n = {"archiveManifest", "operationToken"}, nl = {TypedValues.AttributesType.TYPE_EASING}, s = {"L$0", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateServiceFlow$completeSuccessfully$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateServiceFlow$completeSuccessfully$1(ArchiveUpdateServiceFlow archiveUpdateServiceFlow, Continuation<? super ArchiveUpdateServiceFlow$completeSuccessfully$1> continuation) {
        super(continuation);
        this.this$0 = archiveUpdateServiceFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object completeSuccessfully;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        completeSuccessfully = this.this$0.completeSuccessfully(0L, this);
        return completeSuccessfully;
    }
}
