package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0015J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0015J\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "clearNodeCacheAfterDispatchedEvent", "", "dispatchCancelAfterDispatchedEvent", "dispatchingEvent", "hitPointerIdsAndNodes", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/input/pointer/Node;", "nodesToRemove", "Landroidx/compose/ui/Modifier$Node;", "removeSpecificNodesAfterDispatchedEvent", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "prunePointerIdsAndChangesNotInNodesList", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "clearPreviouslyHitModifierNodeCache", "dispatchChanges", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "processCancel", "removeInvalidPointerIdsAndChanges", "", "hitNodes", "removePointerInputModifierNode", "pointerInputNode", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HitPathTracker {
    public static final int $stable = 8;
    private boolean clearNodeCacheAfterDispatchedEvent;
    private boolean dispatchCancelAfterDispatchedEvent;
    private boolean dispatchingEvent;
    private boolean removeSpecificNodesAfterDispatchedEvent;
    private final LayoutCoordinates rootCoordinates;
    private final MutableObjectList<Modifier.Node> nodesToRemove = new MutableObjectList<>(0, 1, null);
    private final NodeParent root = new NodeParent();
    private final MutableLongObjectMap<MutableObjectList<Node>> hitPointerIdsAndNodes = new MutableLongObjectMap<>(10);

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    /* renamed from: addHitPath-QJqDSyo$default  reason: not valid java name */
    public static /* synthetic */ void m5238addHitPathQJqDSyo$default(HitPathTracker hitPathTracker, long j, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        hitPathTracker.m5239addHitPathQJqDSyo(j, list, z);
    }

    /* renamed from: addHitPath-QJqDSyo  reason: not valid java name */
    public final void m5239addHitPathQJqDSyo(long j, List<? extends Modifier.Node> list, boolean z) {
        Node node;
        Node node2 = this.root;
        this.hitPointerIdsAndNodes.clear();
        int size = list.size();
        boolean z2 = true;
        for (int i = 0; i < size; i++) {
            final Modifier.Node node3 = list.get(i);
            if (node3.isAttached()) {
                node3.setDetachedListener$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.input.pointer.HitPathTracker$addHitPath$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        HitPathTracker.this.removePointerInputModifierNode(node3);
                    }
                });
                if (z2) {
                    MutableVector<Node> children = node2.getChildren();
                    Node[] nodeArr = children.content;
                    int size2 = children.getSize();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            node = null;
                            break;
                        }
                        node = nodeArr[i2];
                        if (Intrinsics.areEqual(node.getModifierNode(), node3)) {
                            break;
                        }
                        i2++;
                    }
                    Node node4 = node;
                    if (node4 != null) {
                        node4.markIsIn();
                        node4.getPointerIds().add(j);
                        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap = this.hitPointerIdsAndNodes;
                        MutableObjectList<Node> mutableObjectList = mutableLongObjectMap.get(j);
                        if (mutableObjectList == null) {
                            mutableObjectList = new MutableObjectList<>(0, 1, null);
                            mutableLongObjectMap.set(j, mutableObjectList);
                        }
                        mutableObjectList.add(node4);
                        node2 = node4;
                    } else {
                        z2 = false;
                    }
                }
                Node node5 = new Node(node3);
                node5.getPointerIds().add(j);
                MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap2 = this.hitPointerIdsAndNodes;
                MutableObjectList<Node> mutableObjectList2 = mutableLongObjectMap2.get(j);
                if (mutableObjectList2 == null) {
                    mutableObjectList2 = new MutableObjectList<>(0, 1, null);
                    mutableLongObjectMap2.set(j, mutableObjectList2);
                }
                mutableObjectList2.add(node5);
                node2.getChildren().add(node5);
                node2 = node5;
            }
        }
        if (!z) {
            return;
        }
        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap3 = this.hitPointerIdsAndNodes;
        long[] jArr = mutableLongObjectMap3.keys;
        Object[] objArr = mutableLongObjectMap3.values;
        long[] jArr2 = mutableLongObjectMap3.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j2 = jArr2[i3];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j2) < 128) {
                        int i6 = (i3 << 3) + i5;
                        removeInvalidPointerIdsAndChanges(jArr[i6], (MutableObjectList) objArr[i6]);
                    }
                    j2 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removePointerInputModifierNode(Modifier.Node node) {
        if (this.dispatchingEvent) {
            this.removeSpecificNodesAfterDispatchedEvent = true;
            this.nodesToRemove.add(node);
            return;
        }
        this.root.removePointerInputModifierNode(node);
    }

    private final void removeInvalidPointerIdsAndChanges(long j, MutableObjectList<Node> mutableObjectList) {
        this.root.removeInvalidPointerIdsAndChanges(j, mutableObjectList);
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean z) {
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z)) {
            boolean z2 = true;
            this.dispatchingEvent = true;
            boolean dispatchMainEventPass = this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z);
            if (!this.root.dispatchFinalEventPass(internalPointerEvent) && !dispatchMainEventPass) {
                z2 = false;
            }
            this.dispatchingEvent = false;
            if (this.removeSpecificNodesAfterDispatchedEvent) {
                this.removeSpecificNodesAfterDispatchedEvent = false;
                int size = this.nodesToRemove.getSize();
                for (int i = 0; i < size; i++) {
                    removePointerInputModifierNode(this.nodesToRemove.get(i));
                }
                this.nodesToRemove.clear();
            }
            if (this.dispatchCancelAfterDispatchedEvent) {
                this.dispatchCancelAfterDispatchedEvent = false;
                processCancel();
            }
            if (this.clearNodeCacheAfterDispatchedEvent) {
                this.clearNodeCacheAfterDispatchedEvent = false;
                clearPreviouslyHitModifierNodeCache();
            }
            return z2;
        }
        return false;
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        if (this.clearNodeCacheAfterDispatchedEvent) {
            this.clearNodeCacheAfterDispatchedEvent = true;
        } else {
            this.root.clear();
        }
    }

    public final void processCancel() {
        if (this.dispatchingEvent) {
            this.dispatchCancelAfterDispatchedEvent = true;
            return;
        }
        this.root.dispatchCancel();
        clearPreviouslyHitModifierNodeCache();
    }
}
