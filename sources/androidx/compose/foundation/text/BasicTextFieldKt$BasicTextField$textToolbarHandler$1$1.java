package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"androidx/compose/foundation/text/BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "hideTextToolbar", "", "showTextToolbar", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 implements TextToolbarHandler {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ TextToolbar $currentTextToolbar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(TextToolbar textToolbar, CoroutineScope coroutineScope) {
        this.$currentTextToolbar = textToolbar;
        this.$coroutineScope = coroutineScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object showTextToolbar(TextFieldSelectionState textFieldSelectionState, Rect rect, Continuation<? super Unit> continuation) {
        BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1 basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1;
        int i;
        Function0<Unit> function0;
        Rect rect2;
        final TextFieldSelectionState textFieldSelectionState2;
        TextToolbar textToolbar;
        final CoroutineScope coroutineScope;
        final TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState;
        if (continuation instanceof BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1) {
            basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1 = (BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1) continuation;
            if ((basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.label & Integer.MIN_VALUE) != 0) {
                basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.label -= Integer.MIN_VALUE;
                Object obj = basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TextToolbar textToolbar2 = this.$currentTextToolbar;
                    final CoroutineScope coroutineScope2 = this.$coroutineScope;
                    boolean canCopy = textFieldSelectionState3.canCopy();
                    final TextToolbarState textToolbarState = TextToolbarState.None;
                    Function0<Unit> function02 = !canCopy ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$2$1$1(textFieldSelectionState3, null), 1, null);
                            TextFieldSelectionState.this.updateTextToolbarState(textToolbarState);
                        }
                    };
                    basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$0 = coroutineScope2;
                    basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$1 = textFieldSelectionState3;
                    basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$2 = textFieldSelectionState3;
                    basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$3 = function02;
                    basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$4 = rect;
                    basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$5 = textToolbar2;
                    basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.label = 1;
                    Object canPaste = textFieldSelectionState3.canPaste(basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1);
                    if (canPaste == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function0 = function02;
                    rect2 = rect;
                    textFieldSelectionState2 = textFieldSelectionState3;
                    textToolbar = textToolbar2;
                    obj = canPaste;
                    coroutineScope = coroutineScope2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionState2 = (TextFieldSelectionState) basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$1;
                    coroutineScope = (CoroutineScope) basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    textToolbar = (TextToolbar) basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$5;
                    rect2 = (Rect) basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$4;
                    function0 = (Function0) basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$3;
                    textFieldSelectionState3 = (TextFieldSelectionState) basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.L$2;
                }
                boolean booleanValue = ((Boolean) obj).booleanValue();
                final TextToolbarState textToolbarState2 = TextToolbarState.None;
                Function0<Unit> function03 = booleanValue ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$2$2$1(textFieldSelectionState2, null), 1, null);
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState2);
                    }
                };
                boolean canCut = textFieldSelectionState2.canCut();
                final TextToolbarState textToolbarState3 = TextToolbarState.None;
                Function0<Unit> function04 = canCut ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$2$3$1(textFieldSelectionState2, null), 1, null);
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState3);
                    }
                };
                boolean canSelectAll = textFieldSelectionState2.canSelectAll();
                final TextToolbarState textToolbarState4 = TextToolbarState.Selection;
                Function0<Unit> function05 = canSelectAll ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        textFieldSelectionState2.selectAll();
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState4);
                    }
                };
                boolean canAutofill = textFieldSelectionState2.canAutofill();
                final TextToolbarState textToolbarState5 = TextToolbarState.None;
                textToolbar.showMenu(rect2, function0, function03, function04, function05, canAutofill ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        textFieldSelectionState2.autofill();
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState5);
                    }
                } : null);
                return Unit.INSTANCE;
            }
        }
        basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1(this, continuation);
        Object obj2 = basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = basicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1.label;
        if (i != 0) {
        }
        boolean booleanValue2 = ((Boolean) obj2).booleanValue();
        final TextToolbarState textToolbarState22 = TextToolbarState.None;
        if (booleanValue2) {
        }
        boolean canCut2 = textFieldSelectionState2.canCut();
        final TextToolbarState textToolbarState32 = TextToolbarState.None;
        if (canCut2) {
        }
        boolean canSelectAll2 = textFieldSelectionState2.canSelectAll();
        final TextToolbarState textToolbarState42 = TextToolbarState.Selection;
        if (canSelectAll2) {
        }
        boolean canAutofill2 = textFieldSelectionState2.canAutofill();
        final TextToolbarState textToolbarState52 = TextToolbarState.None;
        textToolbar.showMenu(rect2, function0, function03, function04, function05, canAutofill2 ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                textFieldSelectionState2.autofill();
                TextFieldSelectionState.this.updateTextToolbarState(textToolbarState52);
            }
        } : null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    public void hideTextToolbar() {
        if (this.$currentTextToolbar.getStatus() == TextToolbarStatus.Shown) {
            this.$currentTextToolbar.hide();
        }
    }
}
