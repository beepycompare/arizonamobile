package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: FocusProperties.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a)\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003H\u0002¨\u0006\u000b"}, d2 = {"focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusProperties;", "", "Lkotlin/ExtensionFunctionType;", "toUsingEnterExitScope", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "Landroidx/compose/ui/focus/FocusDirection;", "Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusPropertiesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<FocusEnterExitScope, Unit> toUsingEnterExitScope(final Function1<? super FocusDirection, FocusRequester> function1) {
        return new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$toUsingEnterExitScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusEnterExitScope focusEnterExitScope) {
                invoke2(focusEnterExitScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FocusEnterExitScope focusEnterExitScope) {
                FocusRequester invoke = function1.invoke(FocusDirection.m3718boximpl(focusEnterExitScope.mo3717getRequestedFocusDirectiondhqQ8s()));
                if (invoke == FocusRequester.Companion.getCancel()) {
                    focusEnterExitScope.cancelFocusChange();
                } else if (invoke != FocusRequester.Companion.getDefault()) {
                    FocusRequester.m3748requestFocus3ESFkO8$default(invoke, 0, 1, null);
                }
            }
        };
    }

    public static final Modifier focusProperties(Modifier modifier, Function1<? super FocusProperties, Unit> function1) {
        return modifier.then(new FocusPropertiesElement(new FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(function1)));
    }
}
