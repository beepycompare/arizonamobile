package androidx.compose.foundation.gestures;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NonTouchScrollingLogic.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.NonTouchScrollingLogic", f = "NonTouchScrollingLogic.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "userScroll$foundation", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class NonTouchScrollingLogic$userScroll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NonTouchScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonTouchScrollingLogic$userScroll$1(NonTouchScrollingLogic nonTouchScrollingLogic, Continuation<? super NonTouchScrollingLogic$userScroll$1> continuation) {
        super(continuation);
        this.this$0 = nonTouchScrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.userScroll$foundation(null, this);
    }
}
