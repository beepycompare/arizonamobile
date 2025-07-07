package androidx.compose.foundation.text.input.internal.selection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionState.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {0, 0, 0}, l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE}, m = "detectCursorHandleDragGestures", n = {"this", "cursorDragStart", "cursorDragDelta"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes.dex */
public final class TextFieldSelectionState$detectCursorHandleDragGestures$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$detectCursorHandleDragGestures$1(TextFieldSelectionState textFieldSelectionState, Continuation<? super TextFieldSelectionState$detectCursorHandleDragGestures$1> continuation) {
        super(continuation);
        this.this$0 = textFieldSelectionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object detectCursorHandleDragGestures;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        detectCursorHandleDragGestures = this.this$0.detectCursorHandleDragGestures(null, this);
        return detectCursorHandleDragGestures;
    }
}
