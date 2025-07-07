package androidx.compose.ui.focus;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
/* compiled from: FocusProperties.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\tø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "requestedFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "getRequestedFocusDirection-dhqQ-8s", "()I", "cancelFocus", "", "cancelFocusChange", "Landroidx/compose/ui/focus/CancelIndicatingFocusBoundaryScope;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusEnterExitScope {
    void cancelFocusChange();

    /* renamed from: getRequestedFocusDirection-dhqQ-8s */
    int mo3717getRequestedFocusDirectiondhqQ8s();

    @Deprecated(message = "Use cancelFocusChange instead", replaceWith = @ReplaceWith(expression = "cancelFocusChange", imports = {}))
    default void cancelFocus() {
        cancelFocusChange();
    }
}
