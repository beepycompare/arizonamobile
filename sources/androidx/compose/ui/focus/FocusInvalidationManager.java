package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: FocusInvalidationManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010\u001f\u001a\u00020\u0005H\u0002J%\u0010\u001c\u001a\u00020\u0005\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0\r2\u0006\u0010\u001d\u001a\u0002H H\u0002¢\u0006\u0002\u0010!J%\u0010\"\u001a\u00020\u0005\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0\u00102\u0006\u0010\u001d\u001a\u0002H H\u0002¢\u0006\u0002\u0010#R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "invalidateOwnerFocusState", "rootFocusStateFetcher", "Landroidx/compose/ui/focus/FocusState;", "activeFocusTargetNodeFetcher", "Landroidx/compose/ui/focus/FocusTargetNode;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusEventNodesLegacy", "", "focusPropertiesNodesLegacy", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "focusTargetNodesLegacy", "focusTargetsWithInvalidatedFocusEventsLegacy", "isInvalidationScheduled", "", "hasPendingInvalidation", "invalidateNodes", "invalidateNodesLegacy", "invalidateNodesOptimized", "scheduleInvalidation", "node", "scheduleInvalidationForOwner", "setUpOnRequestApplyChangesListener", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "scheduleInvalidationLegacy", "(Ljava/util/List;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final Function0<FocusTargetNode> activeFocusTargetNodeFetcher;
    private final Function0<Unit> invalidateOwnerFocusState;
    private boolean isInvalidationScheduled;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    private final Function0<FocusState> rootFocusStateFetcher;
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    private final List<FocusTargetNode> focusTargetNodesLegacy = new ArrayList();
    private final List<FocusEventModifierNode> focusEventNodesLegacy = new ArrayList();
    private final List<FocusPropertiesModifierNode> focusPropertiesNodesLegacy = new ArrayList();
    private final List<FocusTargetNode> focusTargetsWithInvalidatedFocusEventsLegacy = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0, Function0<? extends FocusState> function02, Function0<FocusTargetNode> function03) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
        this.rootFocusStateFetcher = function02;
        this.activeFocusTargetNodeFetcher = function03;
    }

    public final void scheduleInvalidation(FocusTargetNode focusTargetNode) {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            scheduleInvalidation(this.focusTargetNodes, focusTargetNode);
        } else {
            scheduleInvalidationLegacy(this.focusTargetNodesLegacy, focusTargetNode);
        }
    }

    public final void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode) {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            scheduleInvalidation(this.focusEventNodes, focusEventModifierNode);
        } else {
            scheduleInvalidationLegacy(this.focusEventNodesLegacy, focusEventModifierNode);
        }
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        scheduleInvalidationLegacy(this.focusPropertiesNodesLegacy, focusPropertiesModifierNode);
    }

    public final void scheduleInvalidationForOwner() {
        setUpOnRequestApplyChangesListener();
    }

    public final boolean hasPendingInvalidation() {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            return this.isInvalidationScheduled;
        }
        return (this.focusTargetNodesLegacy.isEmpty() && this.focusPropertiesNodesLegacy.isEmpty() && this.focusEventNodesLegacy.isEmpty()) ? false : true;
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t) {
        if (mutableScatterSet.add(t)) {
            setUpOnRequestApplyChangesListener();
        }
    }

    private final void setUpOnRequestApplyChangesListener() {
        if (this.isInvalidationScheduled) {
            return;
        }
        this.onRequestApplyChangesListener.invoke(new FocusInvalidationManager$setUpOnRequestApplyChangesListener$1(this));
        this.isInvalidationScheduled = true;
    }

    private final <T> void scheduleInvalidationLegacy(List<T> list, T t) {
        if (list.add(t) && this.focusTargetNodesLegacy.size() + this.focusEventNodesLegacy.size() + this.focusPropertiesNodesLegacy.size() == 1) {
            this.onRequestApplyChangesListener.invoke(new FocusInvalidationManager$scheduleInvalidationLegacy$1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateNodes() {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            invalidateNodesOptimized();
        } else {
            invalidateNodesLegacy();
        }
    }

    private final void invalidateNodesOptimized() {
        NodeChain nodes$ui_release;
        long j;
        long j2;
        FocusTargetNode invoke = this.activeFocusTargetNodeFetcher.invoke();
        long j3 = 255;
        if (invoke == null) {
            MutableScatterSet<FocusEventModifierNode> mutableScatterSet = this.focusEventNodes;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j4 = jArr[i];
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        int i3 = 0;
                        while (i3 < i2) {
                            if ((j4 & j3) < 128) {
                                j2 = j3;
                                ((FocusEventModifierNode) objArr[(i << 3) + i3]).onFocusEvent(FocusStateImpl.Inactive);
                            } else {
                                j2 = j3;
                            }
                            j4 >>= 8;
                            i3++;
                            j3 = j2;
                        }
                        j = j3;
                        if (i2 != 8) {
                            break;
                        }
                    } else {
                        j = j3;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                    j3 = j;
                }
            }
        } else if (invoke.isAttached()) {
            if (this.focusTargetNodes.contains(invoke)) {
                invoke.invalidateFocus$ui_release();
            }
            FocusStateImpl focusState = invoke.getFocusState();
            FocusTargetNode focusTargetNode = invoke;
            int m5700constructorimpl = NodeKind.m5700constructorimpl(1024) | NodeKind.m5700constructorimpl(4096);
            if (!focusTargetNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            int i4 = 0;
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                            if ((NodeKind.m5700constructorimpl(1024) & node.getKindSet$ui_release()) != 0) {
                                i4++;
                            }
                            if ((node instanceof FocusEventModifierNode) && this.focusEventNodes.contains(node)) {
                                if (i4 <= 1) {
                                    ((FocusEventModifierNode) node).onFocusEvent(focusState);
                                } else {
                                    ((FocusEventModifierNode) node).onFocusEvent(FocusStateImpl.ActiveParent);
                                }
                                this.focusEventNodes.remove(node);
                            }
                        }
                        node = node.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            MutableScatterSet<FocusEventModifierNode> mutableScatterSet2 = this.focusEventNodes;
            Object[] objArr2 = mutableScatterSet2.elements;
            long[] jArr2 = mutableScatterSet2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr2[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length2)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((j5 & 255) < 128) {
                                ((FocusEventModifierNode) objArr2[(i5 << 3) + i7]).onFocusEvent(FocusStateImpl.Inactive);
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length2) {
                        break;
                    }
                    i5++;
                }
            }
        }
        this.invalidateOwnerFocusState.invoke();
        this.focusTargetNodes.clear();
        this.focusEventNodes.clear();
        this.isInvalidationScheduled = false;
    }

    private final void invalidateNodesLegacy() {
        int i;
        int i2;
        int i3;
        FocusStateImpl focusStateImpl;
        FocusStateImpl focusStateImpl2;
        int i4 = 0;
        if (!this.rootFocusStateFetcher.invoke().getHasFocus()) {
            List<FocusEventModifierNode> list = this.focusEventNodesLegacy;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                list.get(i5).onFocusEvent(FocusStateImpl.Inactive);
            }
            List<FocusTargetNode> list2 = this.focusTargetNodesLegacy;
            int size2 = list2.size();
            while (i4 < size2) {
                FocusTargetNode focusTargetNode = list2.get(i4);
                if (focusTargetNode.isAttached() && !focusTargetNode.isInitialized$ui_release()) {
                    focusTargetNode.initializeFocusState$ui_release(FocusStateImpl.Inactive);
                }
                i4++;
            }
            this.focusTargetNodesLegacy.clear();
            this.focusEventNodesLegacy.clear();
            this.focusPropertiesNodesLegacy.clear();
            this.focusTargetsWithInvalidatedFocusEventsLegacy.clear();
            this.invalidateOwnerFocusState.invoke();
            return;
        }
        List<FocusPropertiesModifierNode> list3 = this.focusPropertiesNodesLegacy;
        int size3 = list3.size();
        int i6 = 0;
        while (true) {
            i = 1024;
            i2 = 1;
            if (i6 >= size3) {
                break;
            }
            FocusPropertiesModifierNode focusPropertiesModifierNode = list3.get(i6);
            if (focusPropertiesModifierNode.getNode().isAttached()) {
                FocusPropertiesModifierNode focusPropertiesModifierNode2 = focusPropertiesModifierNode;
                int m5700constructorimpl = NodeKind.m5700constructorimpl(1024);
                Modifier.Node node = focusPropertiesModifierNode2.getNode();
                MutableVector mutableVector = null;
                while (node != null) {
                    if (node instanceof FocusTargetNode) {
                        this.focusTargetNodesLegacy.add((FocusTargetNode) node);
                    } else if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                        int i7 = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                            if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                i7++;
                                if (i7 == 1) {
                                    node = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != null) {
                                        if (mutableVector != null) {
                                            Boolean.valueOf(mutableVector.add(node));
                                        }
                                        node = null;
                                    }
                                    if (mutableVector != null) {
                                        Boolean.valueOf(mutableVector.add(delegate$ui_release));
                                    }
                                }
                            }
                        }
                        if (i7 == 1) {
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector);
                }
                if (!focusPropertiesModifierNode2.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                }
                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$ui_release = focusPropertiesModifierNode2.getNode().getChild$ui_release();
                if (child$ui_release == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusPropertiesModifierNode2.getNode(), false);
                } else {
                    mutableVector2.add(child$ui_release);
                }
                while (mutableVector2.getSize() != 0) {
                    Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                    if ((node2.getAggregateChildKindSet$ui_release() & m5700constructorimpl) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2, false);
                    } else {
                        while (true) {
                            if (node2 == null) {
                                break;
                            } else if ((node2.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                MutableVector mutableVector3 = null;
                                while (node2 != null) {
                                    if (node2 instanceof FocusTargetNode) {
                                        this.focusTargetNodesLegacy.add((FocusTargetNode) node2);
                                    } else if ((node2.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                        int i8 = 0;
                                        for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                            if ((delegate$ui_release2.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                                i8++;
                                                if (i8 == 1) {
                                                    node2 = delegate$ui_release2;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node2 != null) {
                                                        if (mutableVector3 != null) {
                                                            Boolean.valueOf(mutableVector3.add(node2));
                                                        }
                                                        node2 = null;
                                                    }
                                                    if (mutableVector3 != null) {
                                                        Boolean.valueOf(mutableVector3.add(delegate$ui_release2));
                                                    }
                                                }
                                            }
                                        }
                                        if (i8 == 1) {
                                        }
                                    }
                                    node2 = DelegatableNodeKt.pop(mutableVector3);
                                }
                            } else {
                                node2 = node2.getChild$ui_release();
                            }
                        }
                    }
                }
            }
            i6++;
        }
        this.focusPropertiesNodesLegacy.clear();
        List<FocusEventModifierNode> list4 = this.focusEventNodesLegacy;
        int size4 = list4.size();
        int i9 = 0;
        while (i9 < size4) {
            FocusEventModifierNode focusEventModifierNode = list4.get(i9);
            if (focusEventModifierNode.getNode().isAttached()) {
                FocusEventModifierNode focusEventModifierNode2 = focusEventModifierNode;
                int m5700constructorimpl2 = NodeKind.m5700constructorimpl(i);
                Modifier.Node node3 = focusEventModifierNode2.getNode();
                int i10 = 0;
                int i11 = i2;
                FocusTargetNode focusTargetNode2 = null;
                MutableVector mutableVector4 = null;
                while (node3 != null) {
                    if (node3 instanceof FocusTargetNode) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node3;
                        if (focusTargetNode2 != null) {
                            i10 = i2;
                        }
                        if (this.focusTargetNodesLegacy.contains(focusTargetNode3)) {
                            this.focusTargetsWithInvalidatedFocusEventsLegacy.add(focusTargetNode3);
                            i11 = 0;
                        }
                        focusTargetNode2 = focusTargetNode3;
                    } else if ((node3.getKindSet$ui_release() & m5700constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release();
                        int i12 = 0;
                        while (delegate$ui_release3 != null) {
                            if ((delegate$ui_release3.getKindSet$ui_release() & m5700constructorimpl2) != 0) {
                                i12++;
                                if (i12 == i2) {
                                    node3 = delegate$ui_release3;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node3 != null) {
                                        if (mutableVector4 != null) {
                                            Boolean.valueOf(mutableVector4.add(node3));
                                        }
                                        node3 = null;
                                    }
                                    if (mutableVector4 != null) {
                                        Boolean.valueOf(mutableVector4.add(delegate$ui_release3));
                                    }
                                }
                            }
                            delegate$ui_release3 = delegate$ui_release3.getChild$ui_release();
                            i2 = 1;
                        }
                        int i13 = i2;
                        if (i12 == i13) {
                            i2 = i13;
                        }
                    }
                    node3 = DelegatableNodeKt.pop(mutableVector4);
                    i2 = 1;
                }
                if (!focusEventModifierNode2.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                }
                MutableVector mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$ui_release2 = focusEventModifierNode2.getNode().getChild$ui_release();
                if (child$ui_release2 == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, focusEventModifierNode2.getNode(), false);
                } else {
                    mutableVector5.add(child$ui_release2);
                }
                while (mutableVector5.getSize() != 0) {
                    Modifier.Node node4 = (Modifier.Node) mutableVector5.removeAt(mutableVector5.getSize() - 1);
                    if ((node4.getAggregateChildKindSet$ui_release() & m5700constructorimpl2) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, node4, false);
                    } else {
                        while (node4 != null) {
                            if ((node4.getKindSet$ui_release() & m5700constructorimpl2) != 0) {
                                MutableVector mutableVector6 = null;
                                while (node4 != null) {
                                    if (node4 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) node4;
                                        if (focusTargetNode2 != null) {
                                            i10 = 1;
                                        }
                                        if (this.focusTargetNodesLegacy.contains(focusTargetNode4)) {
                                            this.focusTargetsWithInvalidatedFocusEventsLegacy.add(focusTargetNode4);
                                            i11 = 0;
                                        }
                                        focusTargetNode2 = focusTargetNode4;
                                    } else if ((node4.getKindSet$ui_release() & m5700constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                                        int i14 = 0;
                                        for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                                            if ((delegate$ui_release4.getKindSet$ui_release() & m5700constructorimpl2) != 0) {
                                                i14++;
                                                if (i14 == 1) {
                                                    node4 = delegate$ui_release4;
                                                } else {
                                                    if (mutableVector6 == null) {
                                                        mutableVector6 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node4 != null) {
                                                        if (mutableVector6 != null) {
                                                            Boolean.valueOf(mutableVector6.add(node4));
                                                        }
                                                        node4 = null;
                                                    }
                                                    if (mutableVector6 != null) {
                                                        Boolean.valueOf(mutableVector6.add(delegate$ui_release4));
                                                    }
                                                }
                                            }
                                        }
                                        if (i14 != 1) {
                                            node4 = DelegatableNodeKt.pop(mutableVector6);
                                        }
                                    }
                                    node4 = DelegatableNodeKt.pop(mutableVector6);
                                }
                            } else {
                                node4 = node4.getChild$ui_release();
                            }
                        }
                    }
                }
                i3 = 1;
                if (i11 != 0) {
                    if (i10 != 0) {
                        focusStateImpl2 = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                    } else {
                        if (focusTargetNode2 == null || (focusStateImpl = focusTargetNode2.getFocusState()) == null) {
                            focusStateImpl = FocusStateImpl.Inactive;
                        }
                        focusStateImpl2 = focusStateImpl;
                    }
                    focusEventModifierNode.onFocusEvent(focusStateImpl2);
                }
            } else {
                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                i3 = i2;
            }
            i9++;
            i2 = i3;
            i = 1024;
        }
        this.focusEventNodesLegacy.clear();
        List<FocusTargetNode> list5 = this.focusTargetNodesLegacy;
        int size5 = list5.size();
        while (i4 < size5) {
            FocusTargetNode focusTargetNode5 = list5.get(i4);
            if (focusTargetNode5.isAttached()) {
                FocusStateImpl focusState = focusTargetNode5.getFocusState();
                focusTargetNode5.invalidateFocus$ui_release();
                if (focusState != focusTargetNode5.getFocusState() || this.focusTargetsWithInvalidatedFocusEventsLegacy.contains(focusTargetNode5)) {
                    focusTargetNode5.dispatchFocusCallbacks$ui_release();
                }
            }
            i4++;
        }
        this.focusTargetNodesLegacy.clear();
        this.focusTargetsWithInvalidatedFocusEventsLegacy.clear();
        this.invalidateOwnerFocusState.invoke();
        if (!this.focusPropertiesNodesLegacy.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        if (!this.focusEventNodesLegacy.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        if (this.focusTargetNodesLegacy.isEmpty()) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
    }
}
