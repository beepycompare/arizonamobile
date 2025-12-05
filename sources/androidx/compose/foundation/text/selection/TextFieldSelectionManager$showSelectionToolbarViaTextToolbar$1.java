package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1", f = "TextFieldSelectionManager.kt", i = {}, l = {1078}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Rect contentRect;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.updateClipboardEntry$foundation(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Snapshot.Companion companion = Snapshot.Companion;
        final TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            Function0<Unit> function0 = textFieldSelectionManager.canShowCopyMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0$0;
                    invokeSuspend$lambda$0$0 = TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1.invokeSuspend$lambda$0$0(TextFieldSelectionManager.this);
                    return invokeSuspend$lambda$0$0;
                }
            } : null;
            Function0<Unit> function02 = textFieldSelectionManager.canShowCutMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0$1;
                    invokeSuspend$lambda$0$1 = TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1.invokeSuspend$lambda$0$1(TextFieldSelectionManager.this);
                    return invokeSuspend$lambda$0$1;
                }
            } : null;
            Function0<Unit> function03 = textFieldSelectionManager.canShowPasteMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0$2;
                    invokeSuspend$lambda$0$2 = TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1.invokeSuspend$lambda$0$2(TextFieldSelectionManager.this);
                    return invokeSuspend$lambda$0$2;
                }
            } : null;
            Function0<Unit> function04 = textFieldSelectionManager.canShowSelectAllMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0$3;
                    invokeSuspend$lambda$0$3 = TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1.invokeSuspend$lambda$0$3(TextFieldSelectionManager.this);
                    return invokeSuspend$lambda$0$3;
                }
            } : null;
            Function0<Unit> function05 = textFieldSelectionManager.canShowAutofillMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0$4;
                    invokeSuspend$lambda$0$4 = TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1.invokeSuspend$lambda$0$4(TextFieldSelectionManager.this);
                    return invokeSuspend$lambda$0$4;
                }
            } : null;
            TextToolbar textToolbar = textFieldSelectionManager.getTextToolbar();
            if (textToolbar != null) {
                contentRect = textFieldSelectionManager.getContentRect();
                textToolbar.showMenu(contentRect, function0, function03, function02, function04, function05);
            }
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(TextFieldSelectionManager textFieldSelectionManager) {
        CoroutineScope coroutineScope$foundation = textFieldSelectionManager.getCoroutineScope$foundation();
        if (coroutineScope$foundation != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope$foundation, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$copy$1$1(textFieldSelectionManager, null), 1, null);
        }
        textFieldSelectionManager.hideSelectionToolbar$foundation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$1(TextFieldSelectionManager textFieldSelectionManager) {
        CoroutineScope coroutineScope$foundation = textFieldSelectionManager.getCoroutineScope$foundation();
        if (coroutineScope$foundation != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope$foundation, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$cut$1$1(textFieldSelectionManager, null), 1, null);
        }
        textFieldSelectionManager.hideSelectionToolbar$foundation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$2(TextFieldSelectionManager textFieldSelectionManager) {
        CoroutineScope coroutineScope$foundation = textFieldSelectionManager.getCoroutineScope$foundation();
        if (coroutineScope$foundation != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope$foundation, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$paste$1$1(textFieldSelectionManager, null), 1, null);
        }
        textFieldSelectionManager.hideSelectionToolbar$foundation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$3(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.selectAll$foundation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$4(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.autofill$foundation();
        return Unit.INSTANCE;
    }
}
