package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
/* compiled from: FocusRestorer.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0004H\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"PrevFocusedChild", "", "saveFocusedChild", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "restoreFocusedChild", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "focusRestorer", "Landroidx/compose/ui/Modifier;", "fallback", "Landroidx/compose/ui/focus/FocusRequester;", "onRestoreFailed", "Lkotlin/Function0;", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusRestorerKt {
    private static final String PrevFocusedChild = "previouslyFocusedChildHash";

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0043, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean saveFocusedChild(final FocusTargetNode focusTargetNode) {
        if (focusTargetNode.getFocusState().getHasFocus()) {
            FocusTargetNode focusTargetNode2 = focusTargetNode;
            int m6535constructorimpl = NodeKind.m6535constructorimpl(1024);
            if (!focusTargetNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui = focusTargetNode2.getNode().getChild$ui();
            if (child$ui == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode2.getNode(), false);
            } else {
                mutableVector.add(child$ui);
            }
            while (mutableVector.getSize() != 0) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui() & m6535constructorimpl) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui() & m6535constructorimpl) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                    if (focusTargetNode3.getFocusState().getHasFocus()) {
                                        focusTargetNode.setPreviouslyFocusedChildHash(DelegatableNodeKt.requireLayoutNode(focusTargetNode3).getCompositeKeyHash());
                                        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) CompositionLocalConsumerModifierNodeKt.currentValueOf(focusTargetNode, SaveableStateRegistryKt.getLocalSaveableStateRegistry());
                                        if (saveableStateRegistry != null) {
                                            saveableStateRegistry.registerProvider(PrevFocusedChild, new Function0<Object>() { // from class: androidx.compose.ui.focus.FocusRestorerKt$saveFocusedChild$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return Integer.valueOf(FocusTargetNode.this.getPreviouslyFocusedChildHash());
                                                }
                                            });
                                        }
                                        return true;
                                    }
                                } else if ((node.getKindSet$ui() & m6535constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        } else {
                            node = node.getChild$ui();
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0067, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean restoreFocusedChild(FocusTargetNode focusTargetNode) {
        SaveableStateRegistry saveableStateRegistry;
        Object consumeRestored;
        if (focusTargetNode.getPreviouslyFocusedChildHash() == 0 && (saveableStateRegistry = (SaveableStateRegistry) CompositionLocalConsumerModifierNodeKt.currentValueOf(focusTargetNode, SaveableStateRegistryKt.getLocalSaveableStateRegistry())) != null && (consumeRestored = saveableStateRegistry.consumeRestored(PrevFocusedChild)) != null) {
            focusTargetNode.setPreviouslyFocusedChildHash(((Integer) consumeRestored).intValue());
        }
        if (focusTargetNode.getPreviouslyFocusedChildHash() == 0) {
            return false;
        }
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m6535constructorimpl = NodeKind.m6535constructorimpl(1024);
        if (!focusTargetNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui = focusTargetNode2.getNode().getChild$ui();
        if (child$ui == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode2.getNode(), false);
        } else {
            mutableVector.add(child$ui);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui() & m6535constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui() & m6535constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                if (focusTargetNode3.isAttached() && DelegatableNodeKt.requireLayoutNode(focusTargetNode3).getCompositeKeyHash() == focusTargetNode.getPreviouslyFocusedChildHash()) {
                                    return ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled ? restoreFocusedChild(focusTargetNode3) || (focusTargetNode3.fetchFocusProperties$ui().getCanFocus() && FocusTargetModifierNode.m4434requestFocus3ESFkO8$default(focusTargetNode3, 0, 1, null)) : restoreFocusedChild(focusTargetNode3) || FocusTargetModifierNode.m4434requestFocus3ESFkO8$default(focusTargetNode3, 0, 1, null);
                                }
                            } else if ((node.getKindSet$ui() & m6535constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                        }
                        continue;
                    } else {
                        node = node.getChild$ui();
                    }
                }
            }
        }
        return false;
    }

    public static final PinnableContainer.PinnedHandle pinFocusedChild(FocusTargetNode focusTargetNode) {
        PinnableContainer pinnableContainer;
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
        if (findActiveFocusNode == null || (pinnableContainer = (PinnableContainer) CompositionLocalConsumerModifierNodeKt.currentValueOf(findActiveFocusNode, PinnableContainerKt.getLocalPinnableContainer())) == null) {
            return null;
        }
        return pinnableContainer.pin();
    }

    public static /* synthetic */ Modifier focusRestorer$default(Modifier modifier, FocusRequester focusRequester, int i, Object obj) {
        if ((i & 1) != 0) {
            focusRequester = FocusRequester.Companion.getDefault();
        }
        return focusRestorer(modifier, focusRequester);
    }

    public static final Modifier focusRestorer(Modifier modifier, FocusRequester focusRequester) {
        return modifier.then(new FocusRestorerElement(focusRequester));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use focusRestorer(FocusRequester) instead", replaceWith = @ReplaceWith(expression = "this.focusRestorer(onRestoreFailed())", imports = {}))
    public static final Modifier focusRestorer(Modifier modifier, Function0<FocusRequester> function0) {
        FocusRequester focusRequester;
        if (function0 == null || (focusRequester = function0.invoke()) == null) {
            focusRequester = FocusRequester.Companion.getDefault();
        }
        return focusRestorer(modifier, focusRequester);
    }
}
