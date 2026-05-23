package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$3", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
final class TransformableStateKt$rotateBy$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $centroid;
    final /* synthetic */ float $degrees;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$rotateBy$3(long j, float f, Continuation<? super TransformableStateKt$rotateBy$3> continuation) {
        super(2, continuation);
        this.$centroid = j;
        this.$degrees = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableStateKt$rotateBy$3 transformableStateKt$rotateBy$3 = new TransformableStateKt$rotateBy$3(this.$centroid, this.$degrees, continuation);
        transformableStateKt$rotateBy$3.L$0 = obj;
        return transformableStateKt$rotateBy$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$rotateBy$3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ((TransformScope) this.L$0).mo478transformByWithCentroidIEwrmTk(this.$centroid, 1.0f, Offset.Companion.m5119getZeroF1C5BW0(), this.$degrees);
        return Unit.INSTANCE;
    }
}
