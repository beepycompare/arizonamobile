package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onScrollStopped$performFling$1", f = "Scrollable.kt", i = {0, 1, 1, 2, 2}, l = {748, 751, 754}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* loaded from: classes.dex */
public final class ScrollingLogic$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onScrollStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onScrollStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).m6931unboximpl();
        return scrollingLogic$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m530invokesFctU(velocity.m6931unboximpl(), continuation);
    }

    /* renamed from: invoke-sF-c-tU  reason: not valid java name */
    public final Object m530invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onScrollStopped$performFling$1) create(Velocity.m6913boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
        if (r2 == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NestedScrollDispatcher nestedScrollDispatcher;
        Object m5189dispatchPreFlingQWom1Mo;
        long j;
        long m6925minusAH228Gc;
        Object m522doFlingAnimationQWom1Mo;
        long m6931unboximpl;
        NestedScrollDispatcher nestedScrollDispatcher2;
        Object m5187dispatchPostFlingRZ2iAVY;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j3 = this.J$0;
            nestedScrollDispatcher = this.this$0.nestedScrollDispatcher;
            this.J$0 = j3;
            this.label = 1;
            m5189dispatchPreFlingQWom1Mo = nestedScrollDispatcher.m5189dispatchPreFlingQWom1Mo(j3, this);
            if (m5189dispatchPreFlingQWom1Mo != coroutine_suspended) {
                j = j3;
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    long j4 = this.J$1;
                    j2 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    m6931unboximpl = j4;
                    m5187dispatchPostFlingRZ2iAVY = obj;
                    return Velocity.m6913boximpl(Velocity.m6925minusAH228Gc(j2, Velocity.m6925minusAH228Gc(m6931unboximpl, ((Velocity) m5187dispatchPostFlingRZ2iAVY).m6931unboximpl())));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j5 = this.J$1;
            long j6 = this.J$0;
            ResultKt.throwOnFailure(obj);
            m6925minusAH228Gc = j5;
            j = j6;
            m522doFlingAnimationQWom1Mo = obj;
            m6931unboximpl = ((Velocity) m522doFlingAnimationQWom1Mo).m6931unboximpl();
            nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
            this.J$0 = j;
            this.J$1 = m6931unboximpl;
            this.label = 3;
            m5187dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m5187dispatchPostFlingRZ2iAVY(Velocity.m6925minusAH228Gc(m6925minusAH228Gc, m6931unboximpl), m6931unboximpl, this);
            if (m5187dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                j2 = j;
                return Velocity.m6913boximpl(Velocity.m6925minusAH228Gc(j2, Velocity.m6925minusAH228Gc(m6931unboximpl, ((Velocity) m5187dispatchPostFlingRZ2iAVY).m6931unboximpl())));
            }
            return coroutine_suspended;
        } else {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            m5189dispatchPreFlingQWom1Mo = obj;
        }
        m6925minusAH228Gc = Velocity.m6925minusAH228Gc(j, ((Velocity) m5189dispatchPreFlingQWom1Mo).m6931unboximpl());
        this.J$0 = j;
        this.J$1 = m6925minusAH228Gc;
        this.label = 2;
        m522doFlingAnimationQWom1Mo = this.this$0.m522doFlingAnimationQWom1Mo(m6925minusAH228Gc, this);
    }
}
