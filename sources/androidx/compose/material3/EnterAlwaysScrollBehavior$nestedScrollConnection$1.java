package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior enterAlwaysScrollBehavior) {
        this.this$0 = enterAlwaysScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo929onPreScrollOzD1aCk(long j, int i) {
        if (this.this$0.getCanScroll().invoke().booleanValue()) {
            float heightOffset = this.this$0.getState().getHeightOffset();
            TopAppBarState state = this.this$0.getState();
            state.setHeightOffset(state.getHeightOffset() + Float.intBitsToFloat((int) (4294967295L & j)));
            if (!this.this$0.getReverseLayout() && heightOffset != this.this$0.getState().getHeightOffset()) {
                return Offset.m5030copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
            }
            return Offset.Companion.m5052getZeroF1C5BW0();
        }
        return Offset.Companion.m5052getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo578onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.this$0.getCanScroll().invoke().booleanValue()) {
            TopAppBarState state = this.this$0.getState();
            int i2 = (int) (j & 4294967295L);
            state.setContentOffset(state.getContentOffset() + Float.intBitsToFloat(i2));
            if (!this.this$0.getReverseLayout()) {
                TopAppBarState state2 = this.this$0.getState();
                state2.setHeightOffset(state2.getHeightOffset() + Float.intBitsToFloat(i2));
            }
            return Offset.Companion.m5052getZeroF1C5BW0();
        }
        return Offset.Companion.m5052getZeroF1C5BW0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b0, code lost:
        if (r13 != r0) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo577onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        int i;
        EnterAlwaysScrollBehavior$nestedScrollConnection$1 enterAlwaysScrollBehavior$nestedScrollConnection$1;
        long j3;
        long m8243unboximpl;
        if (continuation instanceof EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            if ((enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
                Object obj = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Velocity.m8235getYimpl(j2) > 0.0f && (this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit())) {
                        this.this$0.getState().setContentOffset(0.0f);
                    }
                    enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = j2;
                    enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 1;
                    enterAlwaysScrollBehavior$nestedScrollConnection$1 = this;
                    obj = super.mo577onPostFlingRZ2iAVY(j, j2, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
                    if (obj != coroutine_suspended) {
                        j3 = j2;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        m8243unboximpl = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.m8225boximpl(Velocity.m8238plusAH228Gc(m8243unboximpl, ((Velocity) obj).m8243unboximpl()));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j3 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
                    ResultKt.throwOnFailure(obj);
                    enterAlwaysScrollBehavior$nestedScrollConnection$1 = this;
                }
                m8243unboximpl = ((Velocity) obj).m8243unboximpl();
                TopAppBarState state = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getState();
                float m8235getYimpl = Velocity.m8235getYimpl(j3);
                DecayAnimationSpec<Float> flingAnimationSpec = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
                AnimationSpec<Float> snapAnimationSpec = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = m8243unboximpl;
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 2;
                obj = AppBarKt.settleAppBar(state, m8235getYimpl, flingAnimationSpec, snapAnimationSpec, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
            }
        }
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object obj2 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.label;
        if (i != 0) {
        }
        m8243unboximpl = ((Velocity) obj2).m8243unboximpl();
        TopAppBarState state2 = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getState();
        float m8235getYimpl2 = Velocity.m8235getYimpl(j3);
        DecayAnimationSpec<Float> flingAnimationSpec2 = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec2 = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.J$0 = m8243unboximpl;
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.label = 2;
        obj2 = AppBarKt.settleAppBar(state2, m8235getYimpl2, flingAnimationSpec2, snapAnimationSpec2, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122);
    }
}
