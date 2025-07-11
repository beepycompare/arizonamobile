package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: AwaitFirstLayoutModifier.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "", "wasPositioned", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    public static final int $stable = 0;
    private Continuation<? super Unit> continuation;
    private boolean wasPositioned;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForFirstLayout(Continuation<? super Unit> continuation) {
        AwaitFirstLayoutModifier$waitForFirstLayout$1 awaitFirstLayoutModifier$waitForFirstLayout$1;
        int i;
        Continuation<? super Unit> continuation2;
        if (continuation instanceof AwaitFirstLayoutModifier$waitForFirstLayout$1) {
            awaitFirstLayoutModifier$waitForFirstLayout$1 = (AwaitFirstLayoutModifier$waitForFirstLayout$1) continuation;
            if ((awaitFirstLayoutModifier$waitForFirstLayout$1.label & Integer.MIN_VALUE) != 0) {
                awaitFirstLayoutModifier$waitForFirstLayout$1.label -= Integer.MIN_VALUE;
                Object obj = awaitFirstLayoutModifier$waitForFirstLayout$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitFirstLayoutModifier$waitForFirstLayout$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.wasPositioned) {
                        Continuation<? super Unit> continuation3 = this.continuation;
                        awaitFirstLayoutModifier$waitForFirstLayout$1.L$0 = this;
                        awaitFirstLayoutModifier$waitForFirstLayout$1.L$1 = continuation3;
                        awaitFirstLayoutModifier$waitForFirstLayout$1.label = 1;
                        AwaitFirstLayoutModifier$waitForFirstLayout$1 awaitFirstLayoutModifier$waitForFirstLayout$12 = awaitFirstLayoutModifier$waitForFirstLayout$1;
                        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(awaitFirstLayoutModifier$waitForFirstLayout$12), 1);
                        cancellableContinuationImpl.initCancellability();
                        this.continuation = cancellableContinuationImpl;
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(awaitFirstLayoutModifier$waitForFirstLayout$12);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        continuation2 = continuation3;
                    }
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    continuation2 = (Continuation) awaitFirstLayoutModifier$waitForFirstLayout$1.L$1;
                    AwaitFirstLayoutModifier awaitFirstLayoutModifier = (AwaitFirstLayoutModifier) awaitFirstLayoutModifier$waitForFirstLayout$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (continuation2 != null) {
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m8471constructorimpl(Unit.INSTANCE));
                }
                return Unit.INSTANCE;
            }
        }
        awaitFirstLayoutModifier$waitForFirstLayout$1 = new AwaitFirstLayoutModifier$waitForFirstLayout$1(this, continuation);
        Object obj2 = awaitFirstLayoutModifier$waitForFirstLayout$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitFirstLayoutModifier$waitForFirstLayout$1.label;
        if (i != 0) {
        }
        if (continuation2 != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        if (this.wasPositioned) {
            return;
        }
        this.wasPositioned = true;
        Continuation<? super Unit> continuation = this.continuation;
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m8471constructorimpl(Unit.INSTANCE));
        }
        this.continuation = null;
    }
}
