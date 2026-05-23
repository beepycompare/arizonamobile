package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001Bi\u0012`\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2'\u0010\u001b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001c¢\u0006\u0002\b\u001fH\u0096@¢\u0006\u0002\u0010 Rk\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultTransformableState;", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "centroid", "", "zoomChange", "panChange", "rotationChange", "", "<init>", "(Lkotlin/jvm/functions/Function4;)V", "getOnTransformation", "()Lkotlin/jvm/functions/Function4;", "transformScope", "Landroidx/compose/foundation/gestures/TransformScope;", "transformMutex", "Landroidx/compose/foundation/MutatorMutex;", "isTransformingState", "Landroidx/compose/runtime/MutableState;", "", "transform", "transformPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTransformInProgress", "()Z", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultTransformableState implements TransformableState {
    private final MutableState<Boolean> isTransformingState;
    private final Function4<Offset, Float, Offset, Float, Unit> onTransformation;
    private final TransformScope transformScope = new TransformScope() { // from class: androidx.compose.foundation.gestures.DefaultTransformableState$transformScope$1
        @Override // androidx.compose.foundation.gestures.TransformScope
        /* renamed from: transformBy-d-4ec7I  reason: not valid java name */
        public void mo477transformByd4ec7I(float f, long j, float f2) {
            mo478transformByWithCentroidIEwrmTk(Offset.Companion.m5118getUnspecifiedF1C5BW0(), f, j, f2);
        }

        @Override // androidx.compose.foundation.gestures.TransformScope
        /* renamed from: transformByWithCentroid-IEwrmTk  reason: not valid java name */
        public void mo478transformByWithCentroidIEwrmTk(long j, float f, long j2, float f2) {
            DefaultTransformableState.this.getOnTransformation().invoke(Offset.m5092boximpl(j), Float.valueOf(f), Offset.m5092boximpl(j2), Float.valueOf(f2));
        }
    };
    private final MutatorMutex transformMutex = new MutatorMutex();

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultTransformableState(Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit> function4) {
        MutableState<Boolean> mutableStateOf$default;
        this.onTransformation = function4;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isTransformingState = mutableStateOf$default;
    }

    public final Function4<Offset, Float, Offset, Float, Unit> getOnTransformation() {
        return this.onTransformation;
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    public Object transform(MutatePriority mutatePriority, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new DefaultTransformableState$transform$2(this, mutatePriority, function2, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    public boolean isTransformInProgress() {
        return this.isTransformingState.getValue().booleanValue();
    }
}
