package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001cH\u0016J.\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J.\u0010$\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u001a\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u0017\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+H\u0082\bJ\b\u0010,\u001a\u00020\u0018H\u0016J\u0006\u0010-\u001a\u00020\u0018J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010/\u001a\u000200H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "<init>", "(Landroidx/compose/ui/Modifier$Node;)V", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "wasIn", "", "isIn", "hasExited", "removeInvalidPointerIdsAndChanges", "", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "dispatchMainEventPass", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "dispatchFinalEventPass", "buildCache", "hasPositionChanged", "oldEvent", "newEvent", "clearCache", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchCancel", "markIsIn", "cleanUpHits", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long j, MutableObjectList<Node> mutableObjectList) {
        if (this.pointerIds.contains(j) && !mutableObjectList.contains(this)) {
            this.pointerIds.remove(j);
            this.relevantChanges.remove(j);
        }
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].removeInvalidPointerIdsAndChanges(j, mutableObjectList);
        }
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(LongSparseArray<PointerInputChange> longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        PointerInputChange pointerInputChange;
        boolean z2;
        LayoutCoordinates layoutCoordinates2;
        int m5793getExit7fucELk;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        int i3;
        boolean buildCache = super.buildCache(longSparseArray, layoutCoordinates, internalPointerEvent, z);
        boolean z5 = true;
        if (this.modifierNode.isAttached()) {
            Modifier.Node node = this.modifierNode;
            int m6258constructorimpl = NodeKind.m6258constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) node);
                } else if ((node.getKindSet$ui_release() & m6258constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i4 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & m6258constructorimpl) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i4 == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.coordinates == null) {
                return true;
            }
            int size = longSparseArray.size();
            int i5 = 0;
            while (i5 < size) {
                long keyAt = longSparseArray.keyAt(i5);
                PointerInputChange valueAt = longSparseArray.valueAt(i5);
                if (this.pointerIds.contains(keyAt)) {
                    boolean z6 = z5;
                    int i6 = i5;
                    long m5840getPreviousPositionF1C5BW0 = valueAt.m5840getPreviousPositionF1C5BW0();
                    z4 = z6;
                    long m5839getPositionF1C5BW0 = valueAt.m5839getPositionF1C5BW0();
                    if ((((m5840getPreviousPositionF1C5BW0 & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0 && (((m5839getPositionF1C5BW0 & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0) {
                        ArrayList arrayList = new ArrayList(valueAt.getHistorical().size());
                        List<HistoricalChange> historical = valueAt.getHistorical();
                        z3 = buildCache;
                        int size2 = historical.size();
                        i = size;
                        int i7 = 0;
                        while (i7 < size2) {
                            HistoricalChange historicalChange = historical.get(i7);
                            int i8 = size2;
                            int i9 = i7;
                            long m5763getPositionF1C5BW0 = historicalChange.m5763getPositionF1C5BW0();
                            if ((((m5763getPositionF1C5BW0 & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0) {
                                long uptimeMillis = historicalChange.getUptimeMillis();
                                i3 = i6;
                                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                                Intrinsics.checkNotNull(layoutCoordinates3);
                                arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates3.mo5976localPositionOfR5De75A(layoutCoordinates, m5763getPositionF1C5BW0), historicalChange.m5762getOriginalEventPositionF1C5BW0$ui_release(), null));
                            } else {
                                i3 = i6;
                            }
                            i7 = i9 + 1;
                            size2 = i8;
                            i6 = i3;
                        }
                        i2 = i6;
                        LongSparseArray<PointerInputChange> longSparseArray2 = this.relevantChanges;
                        LayoutCoordinates layoutCoordinates4 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates4);
                        long mo5976localPositionOfR5De75A = layoutCoordinates4.mo5976localPositionOfR5De75A(layoutCoordinates, m5840getPreviousPositionF1C5BW0);
                        LayoutCoordinates layoutCoordinates5 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates5);
                        longSparseArray2.put(keyAt, PointerInputChange.m5828copyOHpmEuE$default(valueAt, 0L, 0L, layoutCoordinates5.mo5976localPositionOfR5De75A(layoutCoordinates, m5839getPositionF1C5BW0), false, 0L, mo5976localPositionOfR5De75A, false, 0, arrayList, 0L, 731, null));
                    } else {
                        z3 = buildCache;
                        i = size;
                        i2 = i6;
                    }
                } else {
                    z3 = buildCache;
                    i = size;
                    z4 = z5;
                    i2 = i5;
                }
                i5 = i2 + 1;
                z5 = z4;
                buildCache = z3;
                size = i;
            }
            boolean z7 = buildCache;
            boolean z8 = z5;
            if (this.relevantChanges.isEmpty()) {
                this.pointerIds.clear();
                getChildren().clear();
                return z8;
            }
            int size3 = this.pointerIds.getSize();
            while (true) {
                size3--;
                if (-1 >= size3) {
                    break;
                } else if (!longSparseArray.containsKey(this.pointerIds.m5933get_I2yYro(size3))) {
                    this.pointerIds.removeAt(size3);
                }
            }
            ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
            int size4 = this.relevantChanges.size();
            for (int i10 = 0; i10 < size4; i10++) {
                arrayList2.add(this.relevantChanges.valueAt(i10));
            }
            PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size5 = changes.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size5) {
                    pointerInputChange = null;
                    break;
                }
                PointerInputChange pointerInputChange2 = changes.get(i11);
                if (internalPointerEvent.m5767activeHoverEvent0FcD4WY(pointerInputChange2.m5837getIdJ3iCeTQ())) {
                    pointerInputChange = pointerInputChange2;
                    break;
                }
                i11++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 != null) {
                if (!z) {
                    z2 = false;
                    this.isIn = false;
                } else {
                    z2 = false;
                    if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                        Intrinsics.checkNotNull(this.coordinates);
                        this.isIn = !PointerEventKt.m5783isOutOfBoundsO0kMr_c(pointerInputChange3, layoutCoordinates2.mo5975getSizeYbymL2g());
                    }
                }
                if (this.isIn != this.wasIn && (PointerEventType.m5788equalsimpl0(pointerEvent.m5781getType7fucELk(), PointerEventType.Companion.m5794getMove7fucELk()) || PointerEventType.m5788equalsimpl0(pointerEvent.m5781getType7fucELk(), PointerEventType.Companion.m5792getEnter7fucELk()) || PointerEventType.m5788equalsimpl0(pointerEvent.m5781getType7fucELk(), PointerEventType.Companion.m5793getExit7fucELk()))) {
                    if (this.isIn) {
                        m5793getExit7fucELk = PointerEventType.Companion.m5792getEnter7fucELk();
                    } else {
                        m5793getExit7fucELk = PointerEventType.Companion.m5793getExit7fucELk();
                    }
                    pointerEvent.m5782setTypeEhbLWgg$ui_release(m5793getExit7fucELk);
                } else if (PointerEventType.m5788equalsimpl0(pointerEvent.m5781getType7fucELk(), PointerEventType.Companion.m5792getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                    pointerEvent.m5782setTypeEhbLWgg$ui_release(PointerEventType.Companion.m5794getMove7fucELk());
                } else if (PointerEventType.m5788equalsimpl0(pointerEvent.m5781getType7fucELk(), PointerEventType.Companion.m5793getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                    pointerEvent.m5782setTypeEhbLWgg$ui_release(PointerEventType.Companion.m5794getMove7fucELk());
                }
            } else {
                z2 = false;
            }
            boolean z9 = (z7 || !PointerEventType.m5788equalsimpl0(pointerEvent.m5781getType7fucELk(), PointerEventType.Companion.m5794getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z8 : z2;
            this.pointerEvent = pointerEvent;
            return z9;
        }
        return true;
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.getChanges().size() != pointerEvent2.getChanges().size()) {
            return true;
        }
        int size = pointerEvent2.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m4302equalsimpl0(pointerEvent.getChanges().get(i).m5839getPositionF1C5BW0(), pointerEvent2.getChanges().get(i).m5839getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (!this.relevantChanges.isEmpty() && this.modifierNode.isAttached()) {
            function0.invoke();
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].dispatchCancel();
        }
        Modifier.Node node = this.modifierNode;
        int m6258constructorimpl = NodeKind.m6258constructorimpl(16);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) node).onCancelPointerInput();
            } else if ((node.getKindSet$ui_release() & m6258constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                    if ((delegate$ui_release.getKindSet$ui_release() & m6258constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            boolean pressed = pointerInputChange.getPressed();
            boolean m5767activeHoverEvent0FcD4WY = internalPointerEvent.m5767activeHoverEvent0FcD4WY(pointerInputChange.m5837getIdJ3iCeTQ());
            boolean z = this.isIn;
            if ((!pressed && !m5767activeHoverEvent0FcD4WY) || (!pressed && !z)) {
                this.pointerIds.remove(pointerInputChange.m5837getIdJ3iCeTQ());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m5788equalsimpl0(pointerEvent.m5781getType7fucELk(), PointerEventType.Companion.m5793getExit7fucELk());
    }

    public String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        if (!this.relevantChanges.isEmpty() && this.modifierNode.isAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates2 = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates2);
            long mo5975getSizeYbymL2g = layoutCoordinates2.mo5975getSizeYbymL2g();
            Modifier.Node node = this.modifierNode;
            int m6258constructorimpl = NodeKind.m6258constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) node).mo237onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, mo5975getSizeYbymL2g);
                } else if ((node.getKindSet$ui_release() & m6258constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & m6258constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.isAttached()) {
                MutableVector<Node> children = getChildren();
                Node[] nodeArr = children.content;
                int size = children.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    LongSparseArray<PointerInputChange> longSparseArray2 = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    nodeArr[i2].dispatchMainEventPass(longSparseArray2, layoutCoordinates3, internalPointerEvent, z);
                }
            }
            if (this.modifierNode.isAttached()) {
                Modifier.Node node2 = this.modifierNode;
                int m6258constructorimpl2 = NodeKind.m6258constructorimpl(16);
                MutableVector mutableVector2 = null;
                while (node2 != null) {
                    if (node2 instanceof PointerInputModifierNode) {
                        ((PointerInputModifierNode) node2).mo237onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, mo5975getSizeYbymL2g);
                    } else if ((node2.getKindSet$ui_release() & m6258constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                        int i3 = 0;
                        for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                            if ((delegate$ui_release2.getKindSet$ui_release() & m6258constructorimpl2) != 0) {
                                i3++;
                                if (i3 == 1) {
                                    node2 = delegate$ui_release2;
                                } else {
                                    if (mutableVector2 == null) {
                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node2 != null) {
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(node2);
                                        }
                                        node2 = null;
                                    }
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(delegate$ui_release2);
                                    }
                                }
                            }
                        }
                        if (i3 == 1) {
                        }
                    }
                    node2 = DelegatableNodeKt.pop(mutableVector2);
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        boolean z = false;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.isAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long mo5975getSizeYbymL2g = layoutCoordinates.mo5975getSizeYbymL2g();
            Modifier.Node node = this.modifierNode;
            int m6258constructorimpl = NodeKind.m6258constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) node).mo237onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, mo5975getSizeYbymL2g);
                } else if ((node.getKindSet$ui_release() & m6258constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & m6258constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.isAttached()) {
                MutableVector<Node> children = getChildren();
                Node[] nodeArr = children.content;
                int size = children.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    nodeArr[i2].dispatchFinalEventPass(internalPointerEvent);
                }
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
