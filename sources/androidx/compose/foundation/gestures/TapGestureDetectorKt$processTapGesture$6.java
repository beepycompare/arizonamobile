package androidx.compose.foundation.gestures;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$6", f = "TapGestureDetector.kt", i = {}, l = {184, ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class TapGestureDetectorKt$processTapGesture$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $cancelOrReleaseJob;
    final /* synthetic */ PressGestureScopeImpl $pressScope;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$processTapGesture$6(Job job, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super TapGestureDetectorKt$processTapGesture$6> continuation) {
        super(2, continuation);
        this.$cancelOrReleaseJob = job;
        this.$pressScope = pressGestureScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TapGestureDetectorKt$processTapGesture$6(this.$cancelOrReleaseJob, this.$pressScope, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$processTapGesture$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r4.$cancelOrReleaseJob.join(r4) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r4.$pressScope.reset(r4) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
    }
}
