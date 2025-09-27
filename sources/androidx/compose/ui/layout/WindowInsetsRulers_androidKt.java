package androidx.compose.ui.layout;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeKindKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: WindowInsetsRulers.android.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a3\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"findDisplayCutouts", "", "Landroidx/compose/ui/layout/RectRulers;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "findInsetsAnimationProperties", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "windowInsetsRulers", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "applyWindowInsetsRulers", "Landroidx/compose/ui/Modifier;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "RulerKey", "", "provideInsetsValues", "", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "insets", "Landroidx/compose/ui/layout/ValueInsets;", "width", "", "height", "provideInsetsValues-cytEWk0", "(Landroidx/compose/ui/layout/RulerScope;Landroidx/compose/ui/layout/RectRulers;JII)V", "WindowInsetsTypeMap", "Landroidx/collection/IntObjectMap;", "AnimatableInsetsRulers", "", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "AnimatableRulers", "Landroidx/collection/MutableIntObjectMap;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WindowInsetsRulers_androidKt {
    private static final WindowInsetsRulers[] AnimatableInsetsRulers;
    private static final MutableIntObjectMap<WindowInsetsRulers> AnimatableRulers;
    private static final String RulerKey = "androidx.compose.ui.layout.WindowInsetsRulers";
    private static final IntObjectMap<WindowInsetsRulers> WindowInsetsTypeMap;

    public static final List<RectRulers> findDisplayCutouts(Placeable.PlacementScope placementScope) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        LayoutCoordinates findRootCoordinates = coordinates != null ? LayoutCoordinatesKt.findRootCoordinates(coordinates) : null;
        for (NodeCoordinator nodeCoordinator = findRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) findRootCoordinates : null; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.getWrapped$ui_release()) {
            int m6258constructorimpl = NodeKind.m6258constructorimpl(262144);
            boolean m6267getIncludeSelfInTraversalH91voCI = NodeKindKt.m6267getIncludeSelfInTraversalH91voCI(m6258constructorimpl);
            Modifier.Node tail = nodeCoordinator.getTail();
            if (m6267getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
                for (Modifier.Node access$headNode = NodeCoordinator.access$headNode(nodeCoordinator, m6267getIncludeSelfInTraversalH91voCI); access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & m6258constructorimpl) != 0; access$headNode = access$headNode.getChild$ui_release()) {
                    if ((access$headNode.getKindSet$ui_release() & m6258constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node node = access$headNode;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    return ((RulerProviderModifierNode) traversableNode).getCutoutRulers();
                                }
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
                            node = DelegatableNodeKt.access$pop(mutableVector);
                        }
                    }
                    if (access$headNode != tail) {
                    }
                }
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final WindowInsetsAnimation findInsetsAnimationProperties(Placeable.PlacementScope placementScope, WindowInsetsRulers windowInsetsRulers) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        LayoutCoordinates findRootCoordinates = coordinates != null ? LayoutCoordinatesKt.findRootCoordinates(coordinates) : null;
        for (NodeCoordinator nodeCoordinator = findRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) findRootCoordinates : null; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.getWrapped$ui_release()) {
            int m6258constructorimpl = NodeKind.m6258constructorimpl(262144);
            boolean m6267getIncludeSelfInTraversalH91voCI = NodeKindKt.m6267getIncludeSelfInTraversalH91voCI(m6258constructorimpl);
            Modifier.Node tail = nodeCoordinator.getTail();
            if (m6267getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
                for (Modifier.Node access$headNode = NodeCoordinator.access$headNode(nodeCoordinator, m6267getIncludeSelfInTraversalH91voCI); access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & m6258constructorimpl) != 0; access$headNode = access$headNode.getChild$ui_release()) {
                    if ((access$headNode.getKindSet$ui_release() & m6258constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node node = access$headNode;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = ((RulerProviderModifierNode) traversableNode).getInsetsValues().get(windowInsetsRulers);
                                    return windowWindowInsetsAnimationValues != null ? windowWindowInsetsAnimationValues : NoWindowInsetsAnimation.INSTANCE;
                                }
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
                            node = DelegatableNodeKt.access$pop(mutableVector);
                        }
                    }
                    if (access$headNode != tail) {
                    }
                }
            }
        }
        return NoWindowInsetsAnimation.INSTANCE;
    }

    public static final Modifier applyWindowInsetsRulers(Modifier modifier, InsetsListener insetsListener) {
        return modifier.then(new RulerProviderModifierElement(insetsListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: provideInsetsValues-cytEWk0  reason: not valid java name */
    public static final void m6086provideInsetsValuescytEWk0(RulerScope rulerScope, RectRulers rectRulers, long j, int i, int i2) {
        if (ValueInsets.m6077equalsimpl0(j, ValueInsets_androidKt.getUnsetValueInsets())) {
            return;
        }
        rulerScope.provides(rectRulers.getLeft(), (int) ((j >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        rulerScope.provides(rectRulers.getTop(), (int) ((j >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        rulerScope.provides(rectRulers.getRight(), i - ((int) ((j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
        rulerScope.provides(rectRulers.getBottom(), i2 - ((int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    static {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(8);
        mutableIntObjectMap.set(WindowInsetsCompat.Type.statusBars(), WindowInsetsRulers.Companion.getStatusBars());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.navigationBars(), WindowInsetsRulers.Companion.getNavigationBars());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.captionBar(), WindowInsetsRulers.Companion.getCaptionBar());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.ime(), WindowInsetsRulers.Companion.getIme());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.systemGestures(), WindowInsetsRulers.Companion.getSystemGestures());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.mandatorySystemGestures(), WindowInsetsRulers.Companion.getMandatorySystemGestures());
        mutableIntObjectMap.set(WindowInsetsCompat.Type.tappableElement(), WindowInsetsRulers.Companion.getTappableElement());
        WindowInsetsTypeMap = mutableIntObjectMap;
        AnimatableInsetsRulers = new WindowInsetsRulers[]{WindowInsetsRulers.Companion.getStatusBars(), WindowInsetsRulers.Companion.getNavigationBars(), WindowInsetsRulers.Companion.getCaptionBar(), WindowInsetsRulers.Companion.getTappableElement(), WindowInsetsRulers.Companion.getSystemGestures(), WindowInsetsRulers.Companion.getMandatorySystemGestures(), WindowInsetsRulers.Companion.getIme(), WindowInsetsRulers.Companion.getWaterfall(), WindowInsetsRulers.Companion.getDisplayCutout()};
        MutableIntObjectMap<WindowInsetsRulers> mutableIntObjectMap2 = new MutableIntObjectMap<>(7);
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.statusBars(), WindowInsetsRulers.Companion.getStatusBars());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.navigationBars(), WindowInsetsRulers.Companion.getNavigationBars());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.captionBar(), WindowInsetsRulers.Companion.getCaptionBar());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.systemGestures(), WindowInsetsRulers.Companion.getSystemGestures());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.tappableElement(), WindowInsetsRulers.Companion.getTappableElement());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.mandatorySystemGestures(), WindowInsetsRulers.Companion.getMandatorySystemGestures());
        mutableIntObjectMap2.set(WindowInsetsCompat.Type.ime(), WindowInsetsRulers.Companion.getIme());
        AnimatableRulers = mutableIntObjectMap2;
    }
}
