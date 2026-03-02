package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
/* compiled from: SemanticsNode.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CJ\u001e\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010J\u001a\u00020\tH\u0002J7\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000L2\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u0005H\u0000¢\u0006\u0002\bOJ\"\u0010P\u001a\u00020G*\u00020\u00072\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010N\u001a\u00020\u0005H\u0002J1\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000L2\b\b\u0002\u0010W\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u0005H\u0000¢\u0006\u0002\bXJ,\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00000L2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00000IH\u0002J2\u0010^\u001a\u00020G*\b\u0012\u0004\u0012\u00020\u00000I2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020G0`H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000f\u0010a\u001a\u0004\u0018\u00010bH\u0000¢\u0006\u0002\bcJ\n\u0010d\u001a\u0004\u0018\u00010eH\u0002J\u0016\u0010f\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000IH\u0002J0\u0010g\u001a\u00020\u00002\b\u0010h\u001a\u0004\u0018\u00010i2\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020G0`¢\u0006\u0002\blH\u0002¢\u0006\u0002\bmJ\r\u0010n\u001a\u00020\u0000H\u0000¢\u0006\u0002\boR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b0\u0010*R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u0010.R\u0011\u00104\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u00106\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b7\u0010.R\u0011\u00108\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b9\u0010.R\u0014\u0010:\u001a\u00020(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010*R\u0014\u0010?\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u000fR\u0011\u0010D\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bE\u0010\u0013R\u0014\u0010K\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u000fR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00000L8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00000L8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010Y\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bY\u0010\u000fR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006p"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/Modifier$Node;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<init>", "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "getOuterSemanticsNode$ui", "()Landroidx/compose/ui/Modifier$Node;", "getMergingEnabled", "()Z", "getLayoutNode$ui", "()Landroidx/compose/ui/node/LayoutNode;", "getUnmergedConfig$ui", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isFake", "isFake$ui", "setFake$ui", "(Z)V", "fakeNodeParent", "isUnmergedLeafNode", "isUnmergedLeafNode$ui", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "id", "", "getId", "()I", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getTouchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "boundsInRoot", "getBoundsInRoot", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "boundsInWindow", "getBoundsInWindow", "positionInWindow", "getPositionInWindow-F1C5BW0", "positionOnScreen", "getPositionOnScreen-F1C5BW0", "boundsInParent", "getBoundsInParent$ui", "boundsInImportantForBoundsAncestor", "nodeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isTransparent", "isTransparent$ui", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "config", "getConfig", "mergeConfig", "", "unmergedChildren", "", "mergedConfig", "isMergingSemanticsOfDescendants", "", "includeFakeNodes", "includeDeactivatedNodes", "unmergedChildren$ui", "fillOneLayerOfSemanticsWrappers", "list", "children", "getChildren", "()Ljava/util/List;", "replacedChildren", "getReplacedChildren$ui", "includeReplacedSemantics", "getChildren$ui", "isRoot", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "findOneLayerOfMergingSemanticsNodes", "forEachUnmergedChild", "block", "Lkotlin/Function1;", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui", "findSemanticsModifierNodeToGetBounds", "Landroidx/compose/ui/node/SemanticsModifierNode;", "emitFakeNodes", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "copyWithMergingEnabled", "copyWithMergingEnabled$ui", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Modifier.Node outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node node, boolean z, LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        this.outerSemanticsNode = node;
        this.mergingEnabled = z;
        this.layoutNode = layoutNode;
        this.unmergedConfig = semanticsConfiguration;
        this.id = layoutNode.getSemanticsId();
    }

    public final Modifier.Node getOuterSemanticsNode$ui() {
        return this.outerSemanticsNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public final LayoutNode getLayoutNode$ui() {
        return this.layoutNode;
    }

    public final SemanticsConfiguration getUnmergedConfig$ui() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui() {
        return this.isFake;
    }

    public final void setFake$ui(boolean z) {
        this.isFake = z;
    }

    public final boolean isUnmergedLeafNode$ui() {
        if (this.isFake || !getReplacedChildren$ui().isEmpty()) {
            return false;
        }
        LayoutNode parent$ui = this.layoutNode.getParent$ui();
        while (true) {
            if (parent$ui == null) {
                parent$ui = null;
                break;
            }
            SemanticsConfiguration semanticsConfiguration = parent$ui.getSemanticsConfiguration();
            if (semanticsConfiguration != null && semanticsConfiguration.isMergingSemanticsOfDescendants()) {
                break;
            }
            parent$ui = parent$ui.getParent$ui();
        }
        return parent$ui == null;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final RootForTest getRoot() {
        Owner owner$ui = this.layoutNode.getOwner$ui();
        if (owner$ui != null) {
            return owner$ui.getRootForTest();
        }
        return null;
    }

    public final int getId() {
        return this.id;
    }

    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode findSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
        if (findSemanticsModifierNodeToGetBounds == null) {
            return this.layoutNode.getInnerCoordinator$ui().touchBoundsInRoot();
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(findSemanticsModifierNodeToGetBounds.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig));
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m6787getSizeYbymL2g() {
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        return findCoordinatorToGetBounds$ui != null ? findCoordinatorToGetBounds$ui.mo6224getSizeYbymL2g() : IntSize.Companion.m7731getZeroYbymL2g();
    }

    public final Rect getBoundsInRoot() {
        Rect boundsInRoot;
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            if (!findCoordinatorToGetBounds$ui.isAttached()) {
                findCoordinatorToGetBounds$ui = null;
            }
            if (findCoordinatorToGetBounds$ui != null && (boundsInRoot = LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds$ui)) != null) {
                return boundsInRoot;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInRoot-F1C5BW0  reason: not valid java name */
    public final long m6784getPositionInRootF1C5BW0() {
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            if (!findCoordinatorToGetBounds$ui.isAttached()) {
                findCoordinatorToGetBounds$ui = null;
            }
            if (findCoordinatorToGetBounds$ui != null) {
                return LayoutCoordinatesKt.positionInRoot(findCoordinatorToGetBounds$ui);
            }
        }
        return Offset.Companion.m4543getZeroF1C5BW0();
    }

    public final Rect getBoundsInWindow() {
        Rect boundsInWindow$default;
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            if (!findCoordinatorToGetBounds$ui.isAttached()) {
                findCoordinatorToGetBounds$ui = null;
            }
            if (findCoordinatorToGetBounds$ui != null && (boundsInWindow$default = LayoutCoordinatesKt.boundsInWindow$default(findCoordinatorToGetBounds$ui, false, 1, null)) != null) {
                return boundsInWindow$default;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInWindow-F1C5BW0  reason: not valid java name */
    public final long m6785getPositionInWindowF1C5BW0() {
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            if (!findCoordinatorToGetBounds$ui.isAttached()) {
                findCoordinatorToGetBounds$ui = null;
            }
            if (findCoordinatorToGetBounds$ui != null) {
                return LayoutCoordinatesKt.positionInWindow(findCoordinatorToGetBounds$ui);
            }
        }
        return Offset.Companion.m4543getZeroF1C5BW0();
    }

    /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
    public final long m6786getPositionOnScreenF1C5BW0() {
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            if (!findCoordinatorToGetBounds$ui.isAttached()) {
                findCoordinatorToGetBounds$ui = null;
            }
            if (findCoordinatorToGetBounds$ui != null) {
                return LayoutCoordinatesKt.positionOnScreen(findCoordinatorToGetBounds$ui);
            }
        }
        return Offset.Companion.m4543getZeroF1C5BW0();
    }

    public final Rect getBoundsInParent$ui() {
        LayoutCoordinates coordinates;
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            if (!findCoordinatorToGetBounds$ui.isAttached()) {
                findCoordinatorToGetBounds$ui = null;
            }
            if (findCoordinatorToGetBounds$ui != null && (coordinates = findCoordinatorToGetBounds$ui.getCoordinates()) != null) {
                return boundsInImportantForBoundsAncestor(coordinates);
            }
        }
        return Rect.Companion.getZero();
    }

    private final Rect boundsInImportantForBoundsAncestor(LayoutCoordinates layoutCoordinates) {
        Modifier.Node node;
        SemanticsNode parent = getParent();
        if (parent == null) {
            return Rect.Companion.getZero();
        }
        NodeChain nodes$ui = parent.layoutNode.getNodes$ui();
        int m6535constructorimpl = NodeKind.m6535constructorimpl(8);
        if ((nodes$ui.getAggregateChildKindSet() & m6535constructorimpl) != 0) {
            loop0: for (Modifier.Node head$ui = nodes$ui.getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
                if ((head$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                    node = head$ui;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof SemanticsModifierNode) {
                            if (((SemanticsModifierNode) node).isImportantForBounds()) {
                                break loop0;
                            }
                        } else if ((node.getKindSet$ui() & m6535constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui;
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
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui.getAggregateChildKindSet$ui() & m6535constructorimpl) == 0) {
                    break;
                }
            }
        }
        node = null;
        SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) node;
        NodeCoordinator m6387requireCoordinator64DMado = semanticsModifierNode != null ? DelegatableNodeKt.m6387requireCoordinator64DMado(semanticsModifierNode, NodeKind.m6535constructorimpl(8)) : null;
        if (m6387requireCoordinator64DMado == null) {
            return parent.boundsInImportantForBoundsAncestor(layoutCoordinates);
        }
        return LayoutCoordinates.localBoundingBoxOf$default(m6387requireCoordinator64DMado, layoutCoordinates, false, 2, null);
    }

    public final boolean isTransparent$ui() {
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            return findCoordinatorToGetBounds$ui.isTransparent();
        }
        return false;
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        NodeCoordinator findCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (findCoordinatorToGetBounds$ui != null) {
            return findCoordinatorToGetBounds$ui.get(alignmentLine);
        }
        return Integer.MIN_VALUE;
    }

    public final SemanticsConfiguration getConfig() {
        boolean isMergingSemanticsOfDescendants = isMergingSemanticsOfDescendants();
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        if (isMergingSemanticsOfDescendants) {
            SemanticsConfiguration copy = semanticsConfiguration.copy();
            mergeConfig(new ArrayList(), copy);
            return copy;
        }
        return semanticsConfiguration;
    }

    private final void mergeConfig(List<SemanticsNode> list, SemanticsConfiguration semanticsConfiguration) {
        if (this.unmergedConfig.isClearingSemantics()) {
            return;
        }
        unmergedChildren$ui$default(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = list.get(size2);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                semanticsConfiguration.mergeChild$ui(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(list, semanticsConfiguration);
            }
        }
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List unmergedChildren$ui$default(SemanticsNode semanticsNode, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return semanticsNode.unmergedChildren$ui(list, z, z2);
    }

    public final List<SemanticsNode> unmergedChildren$ui(List<SemanticsNode> list, boolean z, boolean z2) {
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        fillOneLayerOfSemanticsWrappers(this.layoutNode, list, z2);
        if (z) {
            emitFakeNodes(list);
        }
        return list;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode layoutNode, List<SemanticsNode> list, boolean z) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        LayoutNode[] layoutNodeArr = zSortedChildren.content;
        int size = zSortedChildren.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.isAttached() && (z || !layoutNode2.isDeactivated())) {
                if (layoutNode2.getNodes$ui().m6496hasH91voCI$ui(NodeKind.m6535constructorimpl(8))) {
                    list.add(SemanticsNodeKt.SemanticsNode(layoutNode2, this.mergingEnabled));
                } else {
                    fillOneLayerOfSemanticsWrappers(layoutNode2, list, z);
                }
            }
        }
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren$ui$default(this, false, false, false, 7, null);
    }

    public final List<SemanticsNode> getReplacedChildren$ui() {
        return getChildren$ui$default(this, false, true, false, 4, null);
    }

    public static /* synthetic */ List getChildren$ui$default(SemanticsNode semanticsNode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = !semanticsNode.mergingEnabled;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return semanticsNode.getChildren$ui(z, z2, z3);
    }

    public final List<SemanticsNode> getChildren$ui(boolean z, boolean z2, boolean z3) {
        if (!z && this.unmergedConfig.isClearingSemantics()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, arrayList, null, 2, null);
        }
        return unmergedChildren$ui(arrayList, z2, z3);
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final SemanticsNode getParent() {
        LayoutNode layoutNode;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        if (this.mergingEnabled) {
            layoutNode = this.layoutNode.getParent$ui();
            while (layoutNode != null) {
                SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
                if (semanticsConfiguration != null && semanticsConfiguration.isMergingSemanticsOfDescendants()) {
                    break;
                }
                layoutNode = layoutNode.getParent$ui();
            }
        }
        layoutNode = null;
        if (layoutNode == null) {
            layoutNode = this.layoutNode.getParent$ui();
            while (true) {
                if (layoutNode == null) {
                    layoutNode = null;
                    break;
                } else if (layoutNode.getNodes$ui().m6496hasH91voCI$ui(NodeKind.m6535constructorimpl(8))) {
                    break;
                } else {
                    layoutNode = layoutNode.getParent$ui();
                }
            }
        }
        if (layoutNode == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(layoutNode, this.mergingEnabled);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list, list2);
    }

    private final void forEachUnmergedChild(List<SemanticsNode> list, Function1<? super SemanticsNode, Unit> function1) {
        unmergedChildren$ui$default(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            function1.invoke(list.get(size2));
        }
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui() {
        NodeCoordinator m6387requireCoordinator64DMado;
        if (!this.isFake) {
            SemanticsModifierNode findSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
            return (findSemanticsModifierNodeToGetBounds == null || (m6387requireCoordinator64DMado = DelegatableNodeKt.m6387requireCoordinator64DMado(findSemanticsModifierNodeToGetBounds, NodeKind.m6535constructorimpl(8))) == null) ? this.layoutNode.getInnerCoordinator$ui() : m6387requireCoordinator64DMado;
        }
        SemanticsNode parent = getParent();
        if (parent != null) {
            return parent.findCoordinatorToGetBounds$ui();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SemanticsModifierNode findSemanticsModifierNodeToGetBounds() {
        Modifier.Node node;
        boolean isMergingSemanticsOfDescendants = this.unmergedConfig.isMergingSemanticsOfDescendants();
        LayoutNode layoutNode = this.layoutNode;
        SemanticsModifierNode semanticsModifierNode = null;
        if (isMergingSemanticsOfDescendants) {
            NodeChain nodes$ui = layoutNode.getNodes$ui();
            int m6535constructorimpl = NodeKind.m6535constructorimpl(8);
            if ((nodes$ui.getAggregateChildKindSet() & m6535constructorimpl) != 0) {
                node = null;
                for (Modifier.Node head$ui = nodes$ui.getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
                    if ((head$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                        Modifier.Node node2 = head$ui;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof SemanticsModifierNode) {
                                SemanticsModifierNode semanticsModifierNode2 = (SemanticsModifierNode) node2;
                                if (semanticsModifierNode2.isImportantForBounds()) {
                                    if (semanticsModifierNode2.getShouldMergeDescendantSemantics()) {
                                        return semanticsModifierNode2;
                                    }
                                    if (node == null) {
                                        node = semanticsModifierNode2;
                                    }
                                }
                            } else if ((node2.getKindSet$ui() & m6535constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
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
                    }
                    if ((head$ui.getAggregateChildKindSet$ui() & m6535constructorimpl) == 0) {
                        break;
                    }
                }
                semanticsModifierNode = node;
            }
            return semanticsModifierNode;
        }
        NodeChain nodes$ui2 = layoutNode.getNodes$ui();
        int m6535constructorimpl2 = NodeKind.m6535constructorimpl(8);
        if ((nodes$ui2.getAggregateChildKindSet() & m6535constructorimpl2) != 0) {
            loop3: for (Modifier.Node head$ui2 = nodes$ui2.getHead$ui(); head$ui2 != null; head$ui2 = head$ui2.getChild$ui()) {
                if ((head$ui2.getKindSet$ui() & m6535constructorimpl2) != 0) {
                    node = head$ui2;
                    MutableVector mutableVector2 = null;
                    while (node != null) {
                        if (node instanceof SemanticsModifierNode) {
                            if (((SemanticsModifierNode) node).isImportantForBounds()) {
                                semanticsModifierNode = node;
                            }
                        } else if ((node.getKindSet$ui() & m6535constructorimpl2) != 0 && (node instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (Modifier.Node delegate$ui2 = ((DelegatingNode) node).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                if ((delegate$ui2.getKindSet$ui() & m6535constructorimpl2) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        node = delegate$ui2;
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
                                            mutableVector2.add(delegate$ui2);
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                    }
                }
                if ((head$ui2.getAggregateChildKindSet$ui() & m6535constructorimpl2) == 0) {
                    break;
                }
            }
        }
        return semanticsModifierNode;
    }

    private final void emitFakeNodes(List<SemanticsNode> list) {
        final Role access$getRole = SemanticsNodeKt.access$getRole(this);
        if (access$getRole != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && !list.isEmpty()) {
            list.add(m6783fakeSemanticsNodeypyhhiA(access$getRole, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m6793setRolekuIjeqM(semanticsPropertyReceiver, Role.this.m6773unboximpl());
                }
            }));
        }
        if (this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription()) && !list.isEmpty() && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list2 = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
            final String str = list2 != null ? (String) CollectionsKt.firstOrNull((List<? extends Object>) list2) : null;
            if (str != null) {
                list.add(0, m6783fakeSemanticsNodeypyhhiA(null, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                    }
                }));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA  reason: not valid java name */
    private final SemanticsNode m6783fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(false);
        semanticsConfiguration.setClearingSemantics(false);
        function1.invoke(semanticsConfiguration);
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1), false, new LayoutNode(true, role != null ? SemanticsNodeKt.access$roleFakeNodeId(this) : SemanticsNodeKt.access$contentDescriptionFakeNodeId(this)), semanticsConfiguration);
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    public final SemanticsNode copyWithMergingEnabled$ui() {
        return new SemanticsNode(this.outerSemanticsNode, true, this.layoutNode, this.unmergedConfig);
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list, List<SemanticsNode> list2) {
        unmergedChildren$ui$default(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = list.get(size2);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list2.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics()) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(list, list2);
            }
        }
        return list2;
    }
}
