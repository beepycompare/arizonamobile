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
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior enterAlwaysScrollBehavior) {
        this.this$0 = enterAlwaysScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo816onPreScrollOzD1aCk(long j, int i) {
        if (this.this$0.getCanScroll().invoke().booleanValue()) {
            float heightOffset = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m3838getYimpl(j));
            if (heightOffset != this.this$0.getState().getHeightOffset()) {
                return Offset.m3831copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
            }
            return Offset.Companion.m3853getZeroF1C5BW0();
        }
        return Offset.Companion.m3853getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo510onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.this$0.getCanScroll().invoke().booleanValue()) {
            TopAppBarState state = this.this$0.getState();
            state.setContentOffset(state.getContentOffset() + Offset.m3838getYimpl(j));
            if ((this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit()) && Offset.m3838getYimpl(j) == 0.0f && Offset.m3838getYimpl(j2) > 0.0f) {
                this.this$0.getState().setContentOffset(0.0f);
            }
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m3838getYimpl(j));
            return Offset.Companion.m3853getZeroF1C5BW0();
        }
        return Offset.Companion.m3853getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo509onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        EnterAlwaysScrollBehavior$nestedScrollConnection$1 enterAlwaysScrollBehavior$nestedScrollConnection$1;
        long j3;
        long j4;
        if (continuation instanceof EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            if ((enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
                obj = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.L$0 = this;
                    enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = j2;
                    enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 1;
                    obj = super.mo509onPostFlingRZ2iAVY(j, j2, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
                    if (obj != coroutine_suspended) {
                        enterAlwaysScrollBehavior$nestedScrollConnection$1 = this;
                        j3 = j2;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        j4 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.m6913boximpl(Velocity.m6926plusAH228Gc(j4, ((Velocity) obj).m6931unboximpl()));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j3 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
                    enterAlwaysScrollBehavior$nestedScrollConnection$1 = (EnterAlwaysScrollBehavior$nestedScrollConnection$1) enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                long m6931unboximpl = ((Velocity) obj).m6931unboximpl();
                TopAppBarState state = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getState();
                float m6923getYimpl = Velocity.m6923getYimpl(j3);
                DecayAnimationSpec<Float> flingAnimationSpec = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
                AnimationSpec<Float> snapAnimationSpec = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.L$0 = null;
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = m6931unboximpl;
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 2;
                obj = AppBarKt.settleAppBar(state, m6923getYimpl, flingAnimationSpec, snapAnimationSpec, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
                if (obj != coroutine_suspended) {
                    j4 = m6931unboximpl;
                    return Velocity.m6913boximpl(Velocity.m6926plusAH228Gc(j4, ((Velocity) obj).m6931unboximpl()));
                }
                return coroutine_suspended;
            }
        }
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        obj = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.label;
        if (i != 0) {
        }
        long m6931unboximpl2 = ((Velocity) obj).m6931unboximpl();
        TopAppBarState state2 = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getState();
        float m6923getYimpl2 = Velocity.m6923getYimpl(j3);
        DecayAnimationSpec<Float> flingAnimationSpec2 = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec2 = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.L$0 = null;
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.J$0 = m6931unboximpl2;
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122.label = 2;
        obj = AppBarKt.settleAppBar(state2, m6923getYimpl2, flingAnimationSpec2, snapAnimationSpec2, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$122);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
