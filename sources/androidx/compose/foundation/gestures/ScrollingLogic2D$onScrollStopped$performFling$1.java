package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable2D.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$onScrollStopped$performFling$1", f = "Scrollable2D.kt", i = {0, 1, 1, 2, 2}, l = {378, 381, RendererCapabilities.DECODER_SUPPORT_MASK}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"}, v = 1)
/* loaded from: classes.dex */
public final class ScrollingLogic2D$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic2D$onScrollStopped$performFling$1(ScrollingLogic2D scrollingLogic2D, Continuation<? super ScrollingLogic2D$onScrollStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic2D;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic2D$onScrollStopped$performFling$1 scrollingLogic2D$onScrollStopped$performFling$1 = new ScrollingLogic2D$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic2D$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).m7802unboximpl();
        return scrollingLogic2D$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m600invokesFctU(velocity.m7802unboximpl(), continuation);
    }

    /* renamed from: invoke-sF-c-tU  reason: not valid java name */
    public final Object m600invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic2D$onScrollStopped$performFling$1) create(Velocity.m7784boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
        if (r2 == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NestedScrollDispatcher nestedScrollDispatcher;
        Object m5948dispatchPreFlingQWom1Mo;
        long j;
        long m7796minusAH228Gc;
        Object mo561doFlingAnimationQWom1Mo;
        NestedScrollDispatcher nestedScrollDispatcher2;
        Object m5946dispatchPostFlingRZ2iAVY;
        long j2;
        long j3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j4 = this.J$0;
            nestedScrollDispatcher = this.this$0.nestedScrollDispatcher;
            this.J$0 = j4;
            this.label = 1;
            m5948dispatchPreFlingQWom1Mo = nestedScrollDispatcher.m5948dispatchPreFlingQWom1Mo(j4, this);
            if (m5948dispatchPreFlingQWom1Mo != coroutine_suspended) {
                j = j4;
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    j3 = this.J$1;
                    j2 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    m5946dispatchPostFlingRZ2iAVY = obj;
                    return Velocity.m7784boximpl(Velocity.m7796minusAH228Gc(j2, Velocity.m7796minusAH228Gc(j3, ((Velocity) m5946dispatchPostFlingRZ2iAVY).m7802unboximpl())));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j5 = this.J$1;
            long j6 = this.J$0;
            ResultKt.throwOnFailure(obj);
            m7796minusAH228Gc = j5;
            j = j6;
            mo561doFlingAnimationQWom1Mo = obj;
            long m7802unboximpl = ((Velocity) mo561doFlingAnimationQWom1Mo).m7802unboximpl();
            nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
            this.J$0 = j;
            this.J$1 = m7802unboximpl;
            this.label = 3;
            m5946dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m5946dispatchPostFlingRZ2iAVY(Velocity.m7796minusAH228Gc(m7796minusAH228Gc, m7802unboximpl), m7802unboximpl, this);
            if (m5946dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                j2 = j;
                j3 = m7802unboximpl;
                return Velocity.m7784boximpl(Velocity.m7796minusAH228Gc(j2, Velocity.m7796minusAH228Gc(j3, ((Velocity) m5946dispatchPostFlingRZ2iAVY).m7802unboximpl())));
            }
            return coroutine_suspended;
        } else {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            m5948dispatchPreFlingQWom1Mo = obj;
        }
        m7796minusAH228Gc = Velocity.m7796minusAH228Gc(j, ((Velocity) m5948dispatchPreFlingQWom1Mo).m7802unboximpl());
        this.J$0 = j;
        this.J$1 = m7796minusAH228Gc;
        this.label = 2;
        mo561doFlingAnimationQWom1Mo = this.this$0.mo561doFlingAnimationQWom1Mo(m7796minusAH228Gc, this);
    }
}
