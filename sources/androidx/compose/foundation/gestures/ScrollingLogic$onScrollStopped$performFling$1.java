package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import com.google.android.material.internal.ViewUtils;
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
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onScrollStopped$performFling$1", f = "Scrollable.kt", i = {0, 1, 1, 2, 2}, l = {765, ViewUtils.EDGE_TO_EDGE_FLAGS, 771}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
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
        scrollingLogic$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).m8242unboximpl();
        return scrollingLogic$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m596invokesFctU(velocity.m8242unboximpl(), continuation);
    }

    /* renamed from: invoke-sF-c-tU  reason: not valid java name */
    public final Object m596invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onScrollStopped$performFling$1) create(Velocity.m8224boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object m6445dispatchPreFlingQWom1Mo;
        long j;
        long m8236minusAH228Gc;
        Object mo563doFlingAnimationQWom1Mo;
        long m8242unboximpl;
        NestedScrollDispatcher nestedScrollDispatcher2;
        Object m6443dispatchPostFlingRZ2iAVY;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j3 = this.J$0;
            nestedScrollDispatcher = this.this$0.nestedScrollDispatcher;
            this.J$0 = j3;
            this.label = 1;
            m6445dispatchPreFlingQWom1Mo = nestedScrollDispatcher.m6445dispatchPreFlingQWom1Mo(j3, this);
            if (m6445dispatchPreFlingQWom1Mo != coroutine_suspended) {
                j = j3;
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    long j4 = this.J$1;
                    j2 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    m8242unboximpl = j4;
                    m6443dispatchPostFlingRZ2iAVY = obj;
                    return Velocity.m8224boximpl(Velocity.m8236minusAH228Gc(j2, Velocity.m8236minusAH228Gc(m8242unboximpl, ((Velocity) m6443dispatchPostFlingRZ2iAVY).m8242unboximpl())));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j5 = this.J$1;
            long j6 = this.J$0;
            ResultKt.throwOnFailure(obj);
            m8236minusAH228Gc = j5;
            j = j6;
            mo563doFlingAnimationQWom1Mo = obj;
            m8242unboximpl = ((Velocity) mo563doFlingAnimationQWom1Mo).m8242unboximpl();
            nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
            this.J$0 = j;
            this.J$1 = m8242unboximpl;
            this.label = 3;
            m6443dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m6443dispatchPostFlingRZ2iAVY(Velocity.m8236minusAH228Gc(m8236minusAH228Gc, m8242unboximpl), m8242unboximpl, this);
            if (m6443dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                j2 = j;
                return Velocity.m8224boximpl(Velocity.m8236minusAH228Gc(j2, Velocity.m8236minusAH228Gc(m8242unboximpl, ((Velocity) m6443dispatchPostFlingRZ2iAVY).m8242unboximpl())));
            }
            return coroutine_suspended;
        } else {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            m6445dispatchPreFlingQWom1Mo = obj;
        }
        m8236minusAH228Gc = Velocity.m8236minusAH228Gc(j, ((Velocity) m6445dispatchPreFlingQWom1Mo).m8242unboximpl());
        this.J$0 = j;
        this.J$1 = m8236minusAH228Gc;
        this.label = 2;
        mo563doFlingAnimationQWom1Mo = this.this$0.mo563doFlingAnimationQWom1Mo(m8236minusAH228Gc, this);
    }
}
