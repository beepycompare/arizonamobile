package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMapKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$suggestSelectionForLongPressOrDoubleClick$2", f = "SelectionManager.kt", i = {}, l = {448}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class SelectionManager$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<TextRange> $selectionInSelectable;
    final /* synthetic */ Ref.LongRef $targetSelectableId;
    final /* synthetic */ Ref.ObjectRef<CharSequence> $textInSelectable;
    int label;
    final /* synthetic */ SelectionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionManager$suggestSelectionForLongPressOrDoubleClick$2(SelectionManager selectionManager, Ref.ObjectRef<CharSequence> objectRef, Ref.ObjectRef<TextRange> objectRef2, Ref.LongRef longRef, Continuation<? super SelectionManager$suggestSelectionForLongPressOrDoubleClick$2> continuation) {
        super(2, continuation);
        this.this$0 = selectionManager;
        this.$textInSelectable = objectRef;
        this.$selectionInSelectable = objectRef2;
        this.$targetSelectableId = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SelectionManager$suggestSelectionForLongPressOrDoubleClick$2(this.this$0, this.$textInSelectable, this.$selectionInSelectable, this.$targetSelectableId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SelectionManager$suggestSelectionForLongPressOrDoubleClick$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TextRange textRange;
        Selectable selectable;
        TextLayoutResult textLayoutResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PlatformSelectionBehaviors platformSelectionBehaviors$foundation = this.this$0.getPlatformSelectionBehaviors$foundation();
            if (platformSelectionBehaviors$foundation != null) {
                this.label = 1;
                obj = platformSelectionBehaviors$foundation.mo1592suggestSelectionForLongPressOrDoubleClickpYaCww(this.$textInSelectable.element, this.$selectionInSelectable.element.m7007unboximpl(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                textRange = null;
                if (textRange != null && !Intrinsics.areEqual(textRange, this.$selectionInSelectable.element) && (selectable = this.this$0.selectionRegistrar.getSelectableMap$foundation().get(this.$targetSelectableId.element)) != null && selectable.getText() == this.$textInSelectable.element) {
                    textLayoutResult = selectable.textLayoutResult();
                    if (textLayoutResult != null) {
                        return Unit.INSTANCE;
                    }
                    Selection selection = new Selection(new Selection.AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(textLayoutResult, TextRange.m7003getStartimpl(textRange.m7007unboximpl())), TextRange.m7003getStartimpl(textRange.m7007unboximpl()), this.$targetSelectableId.element), new Selection.AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(textLayoutResult, TextRange.m6998getEndimpl(textRange.m7007unboximpl())), TextRange.m6998getEndimpl(textRange.m7007unboximpl()), this.$targetSelectableId.element), false, 4, null);
                    this.this$0.selectionRegistrar.setSubselections(LongObjectMapKt.mutableLongObjectMapOf(this.$targetSelectableId.element, selection));
                    this.this$0.getOnSelectionChange().invoke(selection);
                    this.this$0.setPreviousSelectionLayout$foundation(null);
                }
                return Unit.INSTANCE;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        textRange = (TextRange) obj;
        if (textRange != null) {
            textLayoutResult = selectable.textLayoutResult();
            if (textLayoutResult != null) {
            }
        }
        return Unit.INSTANCE;
    }
}
