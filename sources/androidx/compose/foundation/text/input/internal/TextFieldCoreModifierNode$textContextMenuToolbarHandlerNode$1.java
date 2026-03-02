package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldCoreModifier.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1", f = "TextFieldCoreModifier.kt", i = {}, l = {209, 210}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1> continuation) {
        super(1, continuation);
        this.this$0 = textFieldCoreModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r8.updateClipboardEntry(r7) == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
        if (r8.mo1591onShowSelectionToolbarSbBc2M(r1, r4.getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE(), r7) == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TextFieldSelectionState textFieldSelectionState;
        PlatformSelectionBehaviors platformSelectionBehaviors;
        TextFieldSelectionState textFieldSelectionState2;
        TextFieldSelectionState textFieldSelectionState3;
        TextFieldSelectionState textFieldSelectionState4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            textFieldSelectionState = this.this$0.textFieldSelectionState;
            this.label = 1;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                textFieldSelectionState4 = this.this$0.textFieldSelectionState;
                textFieldSelectionState4.setTextToolbarShown$foundation(true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        platformSelectionBehaviors = this.this$0.platformSelectionBehaviors;
        if (platformSelectionBehaviors != null) {
            textFieldSelectionState2 = this.this$0.textFieldSelectionState;
            CharSequence text = textFieldSelectionState2.getTextFieldState$foundation().getVisualText().getText();
            textFieldSelectionState3 = this.this$0.textFieldSelectionState;
            this.label = 2;
        }
        textFieldSelectionState4 = this.this$0.textFieldSelectionState;
        textFieldSelectionState4.setTextToolbarShown$foundation(true);
        return Unit.INSTANCE;
    }
}
