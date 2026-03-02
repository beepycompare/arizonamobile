package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable2D.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$doFlingAnimation$2", f = "Scrollable2D.kt", i = {}, l = {456}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class ScrollingLogic2D$doFlingAnimation$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {

    /* renamed from: $$v$c$androidx-compose-ui-unit-Velocity$-available$0  reason: not valid java name */
    final /* synthetic */ long f17$$v$c$androidxcomposeuiunitVelocity$available$0;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic2D$doFlingAnimation$2(ScrollingLogic2D scrollingLogic2D, long j, Ref.LongRef longRef, Continuation<? super ScrollingLogic2D$doFlingAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic2D;
        this.f17$$v$c$androidxcomposeuiunitVelocity$available$0 = j;
        this.$result = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic2D$doFlingAnimation$2 scrollingLogic2D$doFlingAnimation$2 = new ScrollingLogic2D$doFlingAnimation$2(this.this$0, this.f17$$v$c$androidxcomposeuiunitVelocity$available$0, this.$result, continuation);
        scrollingLogic2D$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic2D$doFlingAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollingLogic2D$doFlingAnimation$2) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlingBehavior flingBehavior;
        float m567getMagnitudeTH1AsA0;
        long j;
        Ref.LongRef longRef;
        long doFlingAnimation_QWom1Mo$toDecomposedVelocity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
            final ScrollingLogic2D scrollingLogic2D = this.this$0;
            final long j2 = this.f17$$v$c$androidxcomposeuiunitVelocity$available$0;
            ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic2D$doFlingAnimation$2$flingScope$1
                @Override // androidx.compose.foundation.gestures.ScrollScope
                public float scrollBy(float f) {
                    long doFlingAnimation_QWom1Mo$toDecomposedOffset;
                    float doFlingAnimation_QWom1Mo$toMagnitudeFloat;
                    Function0 function0;
                    doFlingAnimation_QWom1Mo$toDecomposedOffset = ScrollingLogic2D.doFlingAnimation_QWom1Mo$toDecomposedOffset(f, j2);
                    if (!Offset.m4524equalsimpl0(doFlingAnimation_QWom1Mo$toDecomposedOffset, Offset.Companion.m4543getZeroF1C5BW0())) {
                        function0 = ScrollingLogic2D.this.isScrollableNodeAttached;
                        if (!((Boolean) function0.invoke()).booleanValue()) {
                            throw new FlingCancellationException();
                        }
                    }
                    doFlingAnimation_QWom1Mo$toMagnitudeFloat = ScrollingLogic2D.doFlingAnimation_QWom1Mo$toMagnitudeFloat(nestedScrollScope.mo531scrollByWithOverscrollOzD1aCk(doFlingAnimation_QWom1Mo$toDecomposedOffset, NestedScrollSource.Companion.m5964getSideEffectWNlRxjI()));
                    return doFlingAnimation_QWom1Mo$toMagnitudeFloat;
                }
            };
            ScrollingLogic2D scrollingLogic2D2 = this.this$0;
            long j3 = this.f17$$v$c$androidxcomposeuiunitVelocity$available$0;
            Ref.LongRef longRef2 = this.$result;
            flingBehavior = scrollingLogic2D2.flingBehavior;
            m567getMagnitudeTH1AsA0 = Scrollable2DKt.m567getMagnitudeTH1AsA0(j3);
            this.L$0 = longRef2;
            this.J$0 = j3;
            this.label = 1;
            obj = flingBehavior.performFling(scrollScope, m567getMagnitudeTH1AsA0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = j3;
            longRef = longRef2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j = this.J$0;
            longRef = (Ref.LongRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        doFlingAnimation_QWom1Mo$toDecomposedVelocity = ScrollingLogic2D.doFlingAnimation_QWom1Mo$toDecomposedVelocity(((Number) obj).floatValue(), j);
        longRef.element = doFlingAnimation_QWom1Mo$toDecomposedVelocity;
        return Unit.INSTANCE;
    }
}
