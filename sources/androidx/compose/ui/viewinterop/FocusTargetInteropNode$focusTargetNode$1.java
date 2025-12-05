package androidx.compose.ui.viewinterop;

import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FocusGroupNode.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class FocusTargetInteropNode$focusTargetNode$1 extends FunctionReferenceImpl implements Function2<FocusState, FocusState, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FocusTargetInteropNode$focusTargetNode$1(Object obj) {
        super(2, obj, FocusTargetInteropNode.class, "onFocusStateChange", "onFocusStateChange(Landroidx/compose/ui/focus/FocusState;Landroidx/compose/ui/focus/FocusState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState, FocusState focusState2) {
        invoke2(focusState, focusState2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FocusState focusState, FocusState focusState2) {
        ((FocusTargetInteropNode) this.receiver).onFocusStateChange(focusState, focusState2);
    }
}
