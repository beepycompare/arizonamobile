package com.arizona.launcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService", f = "UpdateService.kt", i = {0, 0, 0, 0}, l = {TypedValues.PositionType.TYPE_CURVE_FIT}, m = "auditFinalizationMetadataIfNeeded", n = {"scope", "stateStore", "maintenance", RemoteConfigConstants.ResponseFieldKey.STATE}, nl = {509}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$auditFinalizationMetadataIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$auditFinalizationMetadataIfNeeded$1(UpdateService updateService, Continuation<? super UpdateService$auditFinalizationMetadataIfNeeded$1> continuation) {
        super(continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object auditFinalizationMetadataIfNeeded;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        auditFinalizationMetadataIfNeeded = this.this$0.auditFinalizationMetadataIfNeeded(null, null, null, this);
        return auditFinalizationMetadataIfNeeded;
    }
}
