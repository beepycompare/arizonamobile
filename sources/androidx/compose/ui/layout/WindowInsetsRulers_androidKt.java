package androidx.compose.ui.layout;

import android.graphics.Rect;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableState;
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
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: WindowInsetsRulers.android.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a3\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"provideWindowInsetsRulers", "", "Landroidx/compose/ui/layout/RulerScope;", "rulerProvider", "Landroidx/compose/ui/layout/WindowInsetsRulerProvider;", "findDisplayCutouts", "", "Landroidx/compose/ui/layout/RectRulers;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "findInsetsAnimationProperties", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "windowInsetsRulers", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "RulerKey", "", "provideInsetsValues", "rulers", "insets", "Landroidx/compose/ui/layout/ValueInsets;", "width", "", "height", "provideInsetsValues-cytEWk0", "(Landroidx/compose/ui/layout/RulerScope;Landroidx/compose/ui/layout/RectRulers;JII)V", "WindowInsetsTypeMap", "Landroidx/collection/IntObjectMap;", "AnimatableInsetsRulers", "", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WindowInsetsRulers_androidKt {
    private static final WindowInsetsRulers[] AnimatableInsetsRulers;
    public static final String RulerKey = "androidx.compose.ui.layout.WindowInsetsRulers";
    private static final IntObjectMap<WindowInsetsRulers> WindowInsetsTypeMap;

    public static final void provideWindowInsetsRulers(RulerScope rulerScope, WindowInsetsRulerProvider windowInsetsRulerProvider) {
        long mo6826getSizeYbymL2g = rulerScope.getCoordinates().mo6826getSizeYbymL2g();
        ScatterMap<Object, WindowWindowInsetsAnimationValues> insetsValues = windowInsetsRulerProvider.getInsetsListener().getInsetsValues();
        int i = (int) (mo6826getSizeYbymL2g >> 32);
        int i2 = (int) (mo6826getSizeYbymL2g & 4294967295L);
        WindowInsetsRulers[] windowInsetsRulersArr = AnimatableInsetsRulers;
        int length = windowInsetsRulersArr.length;
        int i3 = 0;
        while (i3 < length) {
            WindowInsetsRulers windowInsetsRulers = windowInsetsRulersArr[i3];
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = insetsValues.get(windowInsetsRulers);
            Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
            RulerScope rulerScope2 = rulerScope;
            m6962provideInsetsValuescytEWk0(rulerScope2, windowInsetsRulers.getCurrent(), windowWindowInsetsAnimationValues2.m6963getCurrenthdzbrEE(), i, i2);
            if (windowWindowInsetsAnimationValues2.isAnimating()) {
                m6962provideInsetsValuescytEWk0(rulerScope2, windowWindowInsetsAnimationValues2.getSource(), windowWindowInsetsAnimationValues2.m6965getSourceValueInsetshdzbrEE(), i, i2);
                m6962provideInsetsValuescytEWk0(rulerScope2, windowWindowInsetsAnimationValues2.getTarget(), windowWindowInsetsAnimationValues2.m6966getTargetValueInsetshdzbrEE(), i, i2);
            }
            m6962provideInsetsValuescytEWk0(rulerScope2, windowInsetsRulers.getMaximum(), windowWindowInsetsAnimationValues2.m6964getMaximumhdzbrEE(), i, i2);
            i3++;
            rulerScope = rulerScope2;
        }
        RulerScope rulerScope3 = rulerScope;
        MutableObjectList<MutableState<Rect>> cutoutRects = windowInsetsRulerProvider.getCutoutRects();
        if (cutoutRects.isNotEmpty()) {
            List<RectRulers> cutoutRulers = windowInsetsRulerProvider.getCutoutRulers();
            MutableObjectList<MutableState<Rect>> mutableObjectList = cutoutRects;
            Object[] objArr = mutableObjectList.content;
            int i4 = mutableObjectList._size;
            for (int i5 = 0; i5 < i4; i5++) {
                RectRulers rectRulers = cutoutRulers.get(i5);
                Rect rect = (Rect) ((MutableState) objArr[i5]).getValue();
                rulerScope3.provides(rectRulers.getLeft(), rect.left);
                rulerScope3.provides(rectRulers.getTop(), rect.top);
                rulerScope3.provides(rectRulers.getRight(), rect.right);
                rulerScope3.provides(rectRulers.getBottom(), rect.bottom);
            }
        }
    }

    public static final List<RectRulers> findDisplayCutouts(Placeable.PlacementScope placementScope) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        LayoutCoordinates findRootCoordinates = coordinates != null ? LayoutCoordinatesKt.findRootCoordinates(coordinates) : null;
        for (NodeCoordinator nodeCoordinator = findRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) findRootCoordinates : null; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.getWrapped$ui()) {
            int m7135constructorimpl = NodeKind.m7135constructorimpl(262144);
            boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(m7135constructorimpl);
            Modifier.Node tail = nodeCoordinator.getTail();
            if (m7144getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui()) != null) {
                for (Modifier.Node access$headNode = NodeCoordinator.access$headNode(nodeCoordinator, m7144getIncludeSelfInTraversalH91voCI); access$headNode != null && (access$headNode.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0; access$headNode = access$headNode.getChild$ui()) {
                    if ((access$headNode.getKindSet$ui() & m7135constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node node = access$headNode;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    return ((WindowInsetsRulerProvider) traversableNode).getCutoutRulers();
                                }
                            } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
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
        for (NodeCoordinator nodeCoordinator = findRootCoordinates instanceof NodeCoordinator ? (NodeCoordinator) findRootCoordinates : null; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.getWrapped$ui()) {
            int m7135constructorimpl = NodeKind.m7135constructorimpl(262144);
            boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(m7135constructorimpl);
            Modifier.Node tail = nodeCoordinator.getTail();
            if (m7144getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui()) != null) {
                for (Modifier.Node access$headNode = NodeCoordinator.access$headNode(nodeCoordinator, m7144getIncludeSelfInTraversalH91voCI); access$headNode != null && (access$headNode.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0; access$headNode = access$headNode.getChild$ui()) {
                    if ((access$headNode.getKindSet$ui() & m7135constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node node = access$headNode;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (traversableNode.getTraverseKey() == RulerKey) {
                                    WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = ((WindowInsetsRulerProvider) traversableNode).getInsetsValues().get(windowInsetsRulers);
                                    return windowWindowInsetsAnimationValues != null ? windowWindowInsetsAnimationValues : NoWindowInsetsAnimation.INSTANCE;
                                }
                            } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
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

    /* renamed from: provideInsetsValues-cytEWk0  reason: not valid java name */
    private static final void m6962provideInsetsValuescytEWk0(RulerScope rulerScope, RectRulers rectRulers, long j, int i, int i2) {
        if (ValueInsets.m6954equalsimpl0(j, ValueInsets_androidKt.getUnsetValueInsets())) {
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
        mutableIntObjectMap.set(WindowInsetsCompat.Type.displayCutout(), WindowInsetsRulers.Companion.getDisplayCutout());
        WindowInsetsTypeMap = mutableIntObjectMap;
        AnimatableInsetsRulers = new WindowInsetsRulers[]{WindowInsetsRulers.Companion.getStatusBars(), WindowInsetsRulers.Companion.getNavigationBars(), WindowInsetsRulers.Companion.getCaptionBar(), WindowInsetsRulers.Companion.getTappableElement(), WindowInsetsRulers.Companion.getSystemGestures(), WindowInsetsRulers.Companion.getMandatorySystemGestures(), WindowInsetsRulers.Companion.getIme(), WindowInsetsRulers.Companion.getWaterfall(), WindowInsetsRulers.Companion.getDisplayCutout()};
    }
}
