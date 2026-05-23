package com.skydoves.cloudy;

import android.os.Build;
import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.cloudy.CloudyBackground_androidKt$cloudy$3$1", f = "CloudyBackground.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
final class CloudyBackground_androidKt$cloudy$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $cpuBlurEnabled;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudyBackground_androidKt$cloudy$3$1(boolean z, Continuation<? super CloudyBackground_androidKt$cloudy$3$1> continuation) {
        super(2, continuation);
        this.$cpuBlurEnabled = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudyBackground_androidKt$cloudy$3$1(this.$cpuBlurEnabled, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudyBackground_androidKt$cloudy$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Build.VERSION.SDK_INT < 31 && this.$cpuBlurEnabled) {
            Log.w("CloudyBackground", "cloudy(sky) on API " + Build.VERSION.SDK_INT + " uses CPU-based blur. Performance may be degraded for large blur radii or frequent updates.");
        }
        return Unit.INSTANCE;
    }
}
