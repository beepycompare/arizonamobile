package coil3.compose;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import coil3.compose.internal.UtilsKt;
import coil3.size.Size;
import coil3.size.SizeResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: ConstraintsSizeResolver.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil3/compose/ConstraintsSizeResolver;", "Lcoil3/size/SizeResolver;", "Landroidx/compose/ui/layout/LayoutModifier;", "<init>", "()V", "latestConstraints", "Landroidx/compose/ui/unit/Constraints;", "J", "continuations", "", "Lkotlin/coroutines/Continuation;", "", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "setConstraints", "setConstraints-BRTryo0", "(J)V", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConstraintsSizeResolver implements SizeResolver, LayoutModifier {
    public static final int $stable = 0;
    private long latestConstraints = UtilsKt.getZeroConstraints();
    private List<Continuation<Unit>> continuations = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.CancellableContinuation, T, java.lang.Object] */
    @Override // coil3.size.SizeResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object size(Continuation<? super Size> continuation) {
        ConstraintsSizeResolver$size$1 constraintsSizeResolver$size$1;
        int i;
        Ref.ObjectRef objectRef;
        Throwable th;
        if (continuation instanceof ConstraintsSizeResolver$size$1) {
            constraintsSizeResolver$size$1 = (ConstraintsSizeResolver$size$1) continuation;
            if ((constraintsSizeResolver$size$1.label & Integer.MIN_VALUE) != 0) {
                constraintsSizeResolver$size$1.label -= Integer.MIN_VALUE;
                Object obj = constraintsSizeResolver$size$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = constraintsSizeResolver$size$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Constraints.m6641isZeroimpl(this.latestConstraints)) {
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        try {
                            constraintsSizeResolver$size$1.L$0 = objectRef2;
                            constraintsSizeResolver$size$1.label = 1;
                            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(constraintsSizeResolver$size$1), 1);
                            cancellableContinuationImpl.initCancellability();
                            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                            objectRef2.element = cancellableContinuationImpl2;
                            this.continuations.add(cancellableContinuationImpl2);
                            Object result = cancellableContinuationImpl.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(constraintsSizeResolver$size$1);
                            }
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef = objectRef2;
                        } catch (Throwable th2) {
                            objectRef = objectRef2;
                            th = th2;
                            TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                            throw th;
                        }
                    }
                    return UtilsKt.m7770toSizeBRTryo0(this.latestConstraints);
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    objectRef = (Ref.ObjectRef) constraintsSizeResolver$size$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                        throw th;
                    }
                }
                TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                return UtilsKt.m7770toSizeBRTryo0(this.latestConstraints);
            }
        }
        constraintsSizeResolver$size$1 = new ConstraintsSizeResolver$size$1(this, continuation);
        Object obj2 = constraintsSizeResolver$size$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = constraintsSizeResolver$size$1.label;
        if (i != 0) {
        }
        TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
        return UtilsKt.m7770toSizeBRTryo0(this.latestConstraints);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo658measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        m7744setConstraintsBRTryo0(j);
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1() { // from class: coil3.compose.ConstraintsSizeResolver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = ConstraintsSizeResolver.measure_3p2s80s$lambda$1(Placeable.this, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* renamed from: setConstraints-BRTryo0  reason: not valid java name */
    public final void m7744setConstraintsBRTryo0(long j) {
        this.latestConstraints = j;
        if (Constraints.m6641isZeroimpl(j)) {
            return;
        }
        List<Continuation<Unit>> list = this.continuations;
        if (list.isEmpty()) {
            return;
        }
        this.continuations = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Result.Companion companion = Result.Companion;
            ((Continuation) it.next()).resumeWith(Result.m8471constructorimpl(Unit.INSTANCE));
        }
    }
}
