package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusRestorer.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fallback", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/ui/focus/FocusRequester;)V", "getFallback", "()Landroidx/compose/ui/focus/FocusRequester;", "setFallback", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "onExit", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onDetach", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusRestorerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;
    private FocusRequester fallback;
    private PinnableContainer.PinnedHandle pinnedHandle;
    private final Function1<FocusEnterExitScope, Unit> onExit = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onExit$1
        /* JADX INFO: Access modifiers changed from: package-private */
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
            PinnableContainer.PinnedHandle pinnedHandle;
            FocusRequesterModifierNodeKt.saveFocusedChild(FocusRestorerNode.this);
            pinnedHandle = FocusRestorerNode.this.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            FocusRestorerNode focusRestorerNode = FocusRestorerNode.this;
            focusRestorerNode.pinnedHandle = FocusRequesterModifierNodeKt.pinFocusedChild(focusRestorerNode);
        }
    };
    private final Function1<FocusEnterExitScope, Unit> onEnter = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onEnter$1
        /* JADX INFO: Access modifiers changed from: package-private */
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
            PinnableContainer.PinnedHandle pinnedHandle;
            pinnedHandle = FocusRestorerNode.this.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            FocusRestorerNode.this.pinnedHandle = null;
            if (FocusRequesterModifierNodeKt.restoreFocusedChild(FocusRestorerNode.this) || Intrinsics.areEqual(FocusRestorerNode.this.getFallback(), FocusRequester.Companion.getDefault())) {
                return;
            }
            if (Intrinsics.areEqual(FocusRestorerNode.this.getFallback(), FocusRequester.Companion.getCancel())) {
                focusEnterExitScope.cancelFocusChange();
            } else {
                FocusRequester.m3748requestFocus3ESFkO8$default(FocusRestorerNode.this.getFallback(), 0, 1, null);
            }
        }
    };

    public final FocusRequester getFallback() {
        return this.fallback;
    }

    public final void setFallback(FocusRequester focusRequester) {
        this.fallback = focusRequester;
    }

    public FocusRestorerNode(FocusRequester focusRequester) {
        this.fallback = focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setOnEnter(this.onEnter);
        focusProperties.setOnExit(this.onExit);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
        if (pinnedHandle != null) {
            pinnedHandle.release();
        }
        this.pinnedHandle = null;
        super.onDetach();
    }
}
