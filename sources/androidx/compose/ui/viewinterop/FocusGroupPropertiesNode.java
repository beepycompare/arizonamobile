package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusEnterExitScope;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusGroupNode.android.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006%"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "<init>", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "attachedViewTreeObserver", "Landroid/view/ViewTreeObserver;", "getAttachedViewTreeObserver", "()Landroid/view/ViewTreeObserver;", "setAttachedViewTreeObserver", "(Landroid/view/ViewTreeObserver;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "getOnEnter", "()Lkotlin/jvm/functions/Function1;", "onExit", "getOnExit", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onGlobalFocusChanged", "oldFocus", "newFocus", "onAttach", "onDetach", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener {
    private ViewTreeObserver attachedViewTreeObserver;
    private View focusedChild;
    private final Function1<FocusEnterExitScope, Unit> onEnter = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onEnter$1
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
            View embeddedView;
            Rect currentlyFocusedRect;
            embeddedView = FocusGroupNode_androidKt.getEmbeddedView(FocusGroupPropertiesNode.this);
            if (embeddedView.isFocused() || embeddedView.hasFocus()) {
                return;
            }
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(FocusGroupPropertiesNode.this).getFocusOwner();
            View requireView = DelegatableNode_androidKt.requireView(FocusGroupPropertiesNode.this);
            Integer m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(focusEnterExitScope.mo4974getRequestedFocusDirectiondhqQ8s());
            currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, requireView, embeddedView);
            if (FocusInteropUtils_androidKt.requestInteropFocus(embeddedView, m4990toAndroidFocusDirection3ESFkO8, currentlyFocusedRect)) {
                return;
            }
            focusEnterExitScope.cancelFocusChange();
        }
    };
    private final Function1<FocusEnterExitScope, Unit> onExit = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onExit$1
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
            View embeddedView;
            Rect currentlyFocusedRect;
            View findNextFocusFromRect;
            boolean containsDescendant;
            embeddedView = FocusGroupNode_androidKt.getEmbeddedView(FocusGroupPropertiesNode.this);
            if (ComposeUiFlags.isViewFocusFixEnabled) {
                if (embeddedView.hasFocus() || embeddedView.isFocused()) {
                    embeddedView.clearFocus();
                }
            } else if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled || !embeddedView.hasFocus()) {
            } else {
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(FocusGroupPropertiesNode.this).getFocusOwner();
                View requireView = DelegatableNode_androidKt.requireView(FocusGroupPropertiesNode.this);
                if (embeddedView instanceof ViewGroup) {
                    currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, requireView, embeddedView);
                    Integer m4990toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4990toAndroidFocusDirection3ESFkO8(focusEnterExitScope.mo4974getRequestedFocusDirectiondhqQ8s());
                    int intValue = m4990toAndroidFocusDirection3ESFkO8 != null ? m4990toAndroidFocusDirection3ESFkO8.intValue() : TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
                    FocusFinder focusFinder = FocusFinder.getInstance();
                    FocusGroupPropertiesNode focusGroupPropertiesNode = FocusGroupPropertiesNode.this;
                    if (focusGroupPropertiesNode.getFocusedChild() != null) {
                        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
                        findNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) requireView, focusGroupPropertiesNode.getFocusedChild(), intValue);
                    } else {
                        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
                        findNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) requireView, currentlyFocusedRect, intValue);
                    }
                    if (findNextFocusFromRect != null) {
                        containsDescendant = FocusGroupNode_androidKt.containsDescendant(embeddedView, findNextFocusFromRect);
                        if (containsDescendant) {
                            findNextFocusFromRect.requestFocus(intValue, currentlyFocusedRect);
                            focusEnterExitScope.cancelFocusChange();
                            return;
                        }
                    }
                    if (!requireView.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus".toString());
                    }
                } else if (!requireView.requestFocus()) {
                    throw new IllegalStateException("host view did not take focus".toString());
                }
            }
        }
    };

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final void setFocusedChild(View view) {
        this.focusedChild = view;
    }

    public final ViewTreeObserver getAttachedViewTreeObserver() {
        return this.attachedViewTreeObserver;
    }

    public final void setAttachedViewTreeObserver(ViewTreeObserver viewTreeObserver) {
        this.attachedViewTreeObserver = viewTreeObserver;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnEnter() {
        return this.onEnter;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnExit() {
        return this.onExit;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setOnEnter(this.onEnter);
        focusProperties.setOnExit(this.onExit);
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        boolean z;
        FocusGroupPropertiesNode focusGroupPropertiesNode = this;
        int m7135constructorimpl = NodeKind.m7135constructorimpl(1024);
        if (!focusGroupPropertiesNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = focusGroupPropertiesNode.getNode();
        if ((node.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
            boolean z2 = false;
            for (Modifier.Node child$ui = node.getChild$ui(); child$ui != null; child$ui = child$ui.getChild$ui()) {
                if ((child$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                    Modifier.Node node2 = child$ui;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node2;
                            if (z2) {
                                return focusTargetNode;
                            }
                            z = false;
                            z2 = true;
                        } else {
                            z = true;
                        }
                        if (z && (node2.getKindSet$ui() & m7135constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node2 = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node2 != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node2);
                                            }
                                            node2 = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector);
                    }
                    continue;
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGlobalFocusChanged(View view, View view2) {
        View embeddedView;
        boolean z;
        boolean z2;
        boolean containsDescendant;
        boolean containsDescendant2;
        FocusGroupPropertiesNode focusGroupPropertiesNode = this;
        if (DelegatableNodeKt.requireLayoutNode(focusGroupPropertiesNode).getOwner$ui() == null) {
            return;
        }
        embeddedView = FocusGroupNode_androidKt.getEmbeddedView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusGroupPropertiesNode).getFocusOwner();
        Owner requireOwner = DelegatableNodeKt.requireOwner(focusGroupPropertiesNode);
        if (view != null && !Intrinsics.areEqual(view, requireOwner)) {
            containsDescendant2 = FocusGroupNode_androidKt.containsDescendant(embeddedView, view);
            if (containsDescendant2) {
                z = true;
                if (view2 != null && !Intrinsics.areEqual(view2, requireOwner)) {
                    containsDescendant = FocusGroupNode_androidKt.containsDescendant(embeddedView, view2);
                    if (containsDescendant) {
                        z2 = true;
                        if (!z && z2) {
                            this.focusedChild = view2;
                            return;
                        } else if (z2) {
                            this.focusedChild = view2;
                            FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
                            if (focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
                                return;
                            }
                            FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
                            return;
                        } else if (z) {
                            this.focusedChild = null;
                            if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                                focusOwner.mo4994clearFocusI7lrPNg(false, true, false, FocusDirection.Companion.m4984getExitdhqQ8s());
                                return;
                            }
                            return;
                        } else {
                            this.focusedChild = null;
                            return;
                        }
                    }
                }
                z2 = false;
                if (!z) {
                }
                if (z2) {
                }
            }
        }
        z = false;
        if (view2 != null) {
            containsDescendant = FocusGroupNode_androidKt.containsDescendant(embeddedView, view2);
            if (containsDescendant) {
            }
        }
        z2 = false;
        if (!z) {
        }
        if (z2) {
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ViewTreeObserver viewTreeObserver = DelegatableNode_androidKt.requireView(this).getViewTreeObserver();
        this.attachedViewTreeObserver = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        ViewTreeObserver viewTreeObserver = this.attachedViewTreeObserver;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.attachedViewTreeObserver = null;
        DelegatableNode_androidKt.requireView(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }
}
