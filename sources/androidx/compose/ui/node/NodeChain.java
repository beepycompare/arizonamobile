package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NodeChain.kt */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\t\b\u0001\u0018\u00002\u00020\u0001:\u0002pqB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010,\u001a\u00020-2\b\u0010*\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0002\b.J\b\u0010/\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0015H\u0002J\u0015\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020'H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020-H\u0000¢\u0006\u0002\b6J\u0006\u00107\u001a\u00020-J\b\u00108\u001a\u00020-H\u0002J\u0006\u00109\u001a\u00020-J\u0006\u0010:\u001a\u00020-J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<J\r\u0010>\u001a\u00020-H\u0000¢\u0006\u0002\b?J\r\u0010@\u001a\u00020-H\u0000¢\u0006\u0002\bAJ@\u0010B\u001a\u00060)R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u001f2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010F\u001a\u00020\u001bH\u0002J\u0018\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020\u00152\u0006\u0010I\u001a\u00020\u0010H\u0002J<\u0010J\u001a\u00020-2\u0006\u0010C\u001a\u00020\u001f2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u001bH\u0002J\u0010\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u0015H\u0002J\u0010\u0010M\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u0015H\u0002J\u0018\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020\u0015H\u0002J\u0018\u0010Q\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u0015H\u0002J \u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\u0006\u0010L\u001a\u00020\u0015H\u0002J<\u0010U\u001a\u0004\u0018\u0001HV\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002HV0X2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020\u001b0ZH\u0080\b¢\u0006\u0004\b[\u0010\\J:\u0010]\u001a\u00020-\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002HV0X2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0004\b^\u0010_J*\u0010]\u001a\u00020-2\u0006\u0010`\u001a\u00020\u001f2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\baJ\"\u0010]\u001a\u00020-2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\baJ\"\u0010b\u001a\u00020-2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\bcJ:\u0010d\u001a\u00020-\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002HV0X2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0004\be\u0010_J*\u0010d\u001a\u00020-2\u0006\u0010`\u001a\u00020\u001f2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\bfJ\"\u0010d\u001a\u00020-2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\bfJ(\u0010\u0014\u001a\u0004\u0018\u0001HV\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002HV0XH\u0080\b¢\u0006\u0004\bg\u0010hJ(\u0010\u0018\u001a\u0004\u0018\u0001HV\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002HV0XH\u0080\b¢\u0006\u0004\bi\u0010hJ\u001b\u0010j\u001a\u00020\u001b2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030XH\u0000¢\u0006\u0004\bk\u0010lJ\u0015\u0010j\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001fH\u0000¢\u0006\u0002\bmJ\b\u0010n\u001a\u00020oH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0015@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0018\u00010)R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "sentinelHead", "androidx/compose/ui/node/NodeChain$sentinelHead$1", "Landroidx/compose/ui/node/NodeChain$sentinelHead$1;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "value", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail$ui", "()Landroidx/compose/ui/Modifier$Node;", TtmlNode.TAG_HEAD, "getHead$ui", "isUpdating", "", "isUpdating$ui", "()Z", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "current", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "buffer", "stack", "Landroidx/compose/ui/Modifier;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "useLogger", "", "useLogger$ui", "padChain", "trimChain", "paddedHead", "updateFrom", CmcdData.OBJECT_TYPE_MANIFEST, "updateFrom$ui", "resetState", "resetState$ui", "syncCoordinators", "syncAggregateChildKindSet", "markAsAttached", "runAttachLifecycle", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "markAsDetached", "markAsDetached$ui", "runDetachLifecycle", "runDetachLifecycle$ui", "getDiffer", TypedValues.CycleType.S_WAVE_OFFSET, TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_AFTER, "shouldAttachOnInsert", "propagateCoordinator", TtmlNode.START, "coordinator", "structuralUpdate", "detachAndRemoveNode", "node", "removeNode", "createAndInsertNodeAsChild", "element", "parent", "insertChild", "updateNode", "prev", "next", "firstFromHead", ExifInterface.GPS_DIRECTION_TRUE, "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "headToTail", "headToTail-aLcG6gQ$ui", "(ILkotlin/jvm/functions/Function1;)V", "mask", "headToTail$ui", "headToTailExclusive", "headToTailExclusive$ui", "tailToHead", "tailToHead-aLcG6gQ$ui", "tailToHead$ui", "tail-H91voCI$ui", "(I)Ljava/lang/Object;", "head-H91voCI$ui", "has", "has-H91voCI$ui", "(I)Z", "has$ui", "toString", "", "Differ", "Logger", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NodeChain {
    public static final int $stable = 8;
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    private Logger logger;
    private NodeCoordinator outerCoordinator;
    private final NodeChain$sentinelHead$1 sentinelHead;
    private final MutableVector<Modifier> stack;
    private final Modifier.Node tail;

    /* compiled from: NodeChain.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", FirebaseAnalytics.Param.INDEX, "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeUpdated", "oldIndex", "newIndex", "nodeReused", "nodeInserted", "atIndex", "element", "child", "inserted", "nodeRemoved", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface Logger {
        void linearDiffAborted(int i, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeInserted(int i, int i2, Modifier.Element element, Modifier.Node node, Modifier.Node node2);

        void nodeRemoved(int i, Modifier.Element element, Modifier.Node node);

        void nodeReused(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeUpdated(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.node.NodeChain$sentinelHead$1] */
    public NodeChain(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
        ?? r0 = new Modifier.Node() { // from class: androidx.compose.ui.node.NodeChain$sentinelHead$1
            public String toString() {
                return "<Head>";
            }
        };
        r0.setAggregateChildKindSet$ui(-1);
        this.sentinelHead = r0;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        TailModifierNode tail = innerNodeCoordinator.getTail();
        this.tail = tail;
        this.head = tail;
        this.stack = new MutableVector<>(new Modifier[16], 0);
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final InnerNodeCoordinator getInnerCoordinator$ui() {
        return this.innerCoordinator;
    }

    public final NodeCoordinator getOuterCoordinator$ui() {
        return this.outerCoordinator;
    }

    public final Modifier.Node getTail$ui() {
        return this.tail;
    }

    public final Modifier.Node getHead$ui() {
        return this.head;
    }

    public final boolean isUpdating$ui() {
        return getChild$ui() != null;
    }

    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui();
    }

    public final void useLogger$ui(Logger logger) {
        this.logger = logger;
    }

    private final Modifier.Node padChain() {
        if (!(this.head != this.sentinelHead)) {
            InlineClassHelperKt.throwIllegalStateException("padChain called on already padded chain");
        }
        Modifier.Node node = this.head;
        node.setParent$ui(this.sentinelHead);
        setChild$ui(node);
        return this.sentinelHead;
    }

    private final Modifier.Node trimChain(Modifier.Node node) {
        if (!(node == this.sentinelHead)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain called on already trimmed chain");
        }
        Modifier.Node child$ui = getChild$ui();
        if (child$ui == null) {
            child$ui = this.tail;
        }
        child$ui.setParent$ui(null);
        setChild$ui(null);
        setAggregateChildKindSet$ui(-1);
        updateCoordinator$ui(null);
        if (!(child$ui != this.sentinelHead)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain did not update the head");
        }
        return child$ui;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateFrom$ui(Modifier modifier) {
        MutableVector<Modifier.Element> fillVector;
        MutableVector<Modifier.Element> mutableVector;
        Modifier.Node node;
        Modifier.Node node2;
        Modifier.Node node3;
        Logger logger;
        Modifier.Node padChain = padChain();
        MutableVector<Modifier.Element> mutableVector2 = this.current;
        boolean z = false;
        int size = mutableVector2 != null ? mutableVector2.getSize() : 0;
        MutableVector<Modifier.Element> mutableVector3 = this.buffer;
        if (mutableVector3 == null) {
            mutableVector3 = new MutableVector<>(new Modifier.Element[16], 0);
        }
        fillVector = NodeChainKt.fillVector(modifier, mutableVector3, this.stack);
        MutableVector<Modifier.Element> mutableVector4 = null;
        if (fillVector.getSize() == size) {
            Modifier.Node child$ui = padChain.getChild$ui();
            for (int i = 0; child$ui != null && i < size; i++) {
                if (mutableVector2 == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("expected prior modifier list to be non-empty");
                    throw new KotlinNothingValueException();
                }
                Modifier.Element element = mutableVector2.content[i];
                Modifier.Element element2 = fillVector.content[i];
                int actionForModifiers = NodeChainKt.actionForModifiers(element, element2);
                if (actionForModifiers == 0) {
                    Modifier.Node node4 = child$ui;
                    Logger logger2 = this.logger;
                    if (logger2 != null) {
                        logger2.linearDiffAborted(i, element, element2, node4);
                    }
                    node2 = node4.getParent$ui();
                    if (i < size) {
                        if (mutableVector2 == null) {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("expected prior modifier list to be non-empty");
                            throw new KotlinNothingValueException();
                        } else if (node2 != null) {
                            mutableVector = fillVector;
                            structuralUpdate(i, mutableVector2, mutableVector, node2, !this.layoutNode.getApplyingModifierOnAttach$ui());
                            node = padChain;
                            z = true;
                            this.current = mutableVector;
                            if (mutableVector2 != null) {
                                mutableVector2.clear();
                                mutableVector4 = mutableVector2;
                            }
                            this.buffer = mutableVector4;
                            this.head = trimChain(node);
                            if (z) {
                                return;
                            }
                            syncCoordinators();
                            return;
                        } else {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("structuralUpdate requires a non-null tail");
                            throw new KotlinNothingValueException();
                        }
                    }
                    mutableVector = fillVector;
                    node = padChain;
                    this.current = mutableVector;
                    if (mutableVector2 != null) {
                    }
                    this.buffer = mutableVector4;
                    this.head = trimChain(node);
                    if (z) {
                    }
                } else {
                    if (actionForModifiers != 1) {
                        if (actionForModifiers == 2 && (logger = this.logger) != null) {
                            logger.nodeReused(i, i, element, element2, child$ui);
                        }
                        node3 = child$ui;
                    } else {
                        node3 = child$ui;
                        updateNode(element, element2, node3);
                        Logger logger3 = this.logger;
                        if (logger3 != null) {
                            logger3.nodeUpdated(i, i, element, element2, node3);
                        }
                    }
                    child$ui = node3.getChild$ui();
                }
            }
            node2 = child$ui;
            if (i < size) {
            }
            mutableVector = fillVector;
            node = padChain;
            this.current = mutableVector;
            if (mutableVector2 != null) {
            }
            this.buffer = mutableVector4;
            this.head = trimChain(node);
            if (z) {
            }
        } else if (this.layoutNode.getApplyingModifierOnAttach$ui() && size == 0) {
            int i2 = 0;
            Modifier.Node node5 = padChain;
            while (i2 < fillVector.getSize()) {
                Modifier.Element element3 = fillVector.content[i2];
                Modifier.Node createAndInsertNodeAsChild = createAndInsertNodeAsChild(element3, node5);
                Logger logger4 = this.logger;
                if (logger4 != null) {
                    logger4.nodeInserted(0, i2, element3, node5, createAndInsertNodeAsChild);
                }
                i2++;
                node5 = createAndInsertNodeAsChild;
            }
            syncAggregateChildKindSet();
            mutableVector = fillVector;
            node = padChain;
            z = true;
            this.current = mutableVector;
            if (mutableVector2 != null) {
            }
            this.buffer = mutableVector4;
            this.head = trimChain(node);
            if (z) {
            }
        } else if (fillVector.getSize() != 0) {
            if (mutableVector2 == null) {
                mutableVector2 = new MutableVector<>(new Modifier.Element[16], 0);
            }
            mutableVector = fillVector;
            node = padChain;
            structuralUpdate(0, mutableVector2, mutableVector, node, !this.layoutNode.getApplyingModifierOnAttach$ui());
            z = true;
            this.current = mutableVector;
            if (mutableVector2 != null) {
            }
            this.buffer = mutableVector4;
            this.head = trimChain(node);
            if (z) {
            }
        } else if (mutableVector2 != null) {
            Modifier.Node child$ui2 = padChain.getChild$ui();
            for (int i3 = 0; child$ui2 != null && i3 < mutableVector2.getSize(); i3++) {
                Logger logger5 = this.logger;
                if (logger5 != null) {
                    logger5.nodeRemoved(i3, mutableVector2.content[i3], child$ui2);
                }
                child$ui2 = detachAndRemoveNode(child$ui2).getChild$ui();
            }
            InnerNodeCoordinator innerNodeCoordinator = this.innerCoordinator;
            LayoutNode parent$ui = this.layoutNode.getParent$ui();
            innerNodeCoordinator.setWrappedBy$ui(parent$ui != null ? parent$ui.getInnerCoordinator$ui() : null);
            this.outerCoordinator = this.innerCoordinator;
            mutableVector = fillVector;
            node = padChain;
            this.current = mutableVector;
            if (mutableVector2 != null) {
            }
            this.buffer = mutableVector4;
            this.head = trimChain(node);
            if (z) {
            }
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("expected prior modifier list to be non-empty");
            throw new KotlinNothingValueException();
        }
    }

    public final void syncCoordinators() {
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = this.innerCoordinator;
        for (Modifier.Node parent$ui = this.tail.getParent$ui(); parent$ui != null; parent$ui = parent$ui.getParent$ui()) {
            LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(parent$ui);
            if (asLayoutModifierNode != null) {
                if (parent$ui.getCoordinator$ui() != null) {
                    NodeCoordinator coordinator$ui = parent$ui.getCoordinator$ui();
                    Intrinsics.checkNotNull(coordinator$ui, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator$ui;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui(asLayoutModifierNode);
                    if (layoutModifierNode != parent$ui) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, asLayoutModifierNode);
                    parent$ui.updateCoordinator$ui(layoutModifierNodeCoordinator);
                }
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator2 = layoutModifierNodeCoordinator;
                innerNodeCoordinator.setWrappedBy$ui(layoutModifierNodeCoordinator2);
                layoutModifierNodeCoordinator.setWrapped$ui(innerNodeCoordinator);
                innerNodeCoordinator = layoutModifierNodeCoordinator2;
            } else {
                parent$ui.updateCoordinator$ui(innerNodeCoordinator);
            }
        }
        LayoutNode parent$ui2 = this.layoutNode.getParent$ui();
        innerNodeCoordinator.setWrappedBy$ui(parent$ui2 != null ? parent$ui2.getInnerCoordinator$ui() : null);
        this.outerCoordinator = innerNodeCoordinator;
    }

    private final void syncAggregateChildKindSet() {
        int i = 0;
        for (Modifier.Node parent$ui = this.tail.getParent$ui(); parent$ui != null && parent$ui != this.sentinelHead; parent$ui = parent$ui.getParent$ui()) {
            i |= parent$ui.getKindSet$ui();
            parent$ui.setAggregateChildKindSet$ui(i);
        }
    }

    public final List<ModifierInfo> getModifierInfo() {
        MutableVector<Modifier.Element> mutableVector = this.current;
        if (mutableVector == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.getSize()], 0);
        Modifier.Node head$ui = getHead$ui();
        while (head$ui != null && head$ui != getTail$ui()) {
            NodeCoordinator coordinator$ui = head$ui.getCoordinator$ui();
            if (coordinator$ui == null) {
                throw new IllegalArgumentException("getModifierInfo called on node with no coordinator".toString());
            }
            OwnedLayer layer = coordinator$ui.getLayer();
            this.innerCoordinator.getLayer();
            Modifier.Node child$ui = head$ui.getChild$ui();
            OwnedLayer ownedLayer = (child$ui != this.tail || head$ui.getCoordinator$ui() == child$ui.getCoordinator$ui()) ? null : null;
            if (layer == null) {
                layer = ownedLayer;
            }
            mutableVector2.add(new ModifierInfo(mutableVector.content[i], coordinator$ui, layer));
            head$ui = head$ui.getChild$ui();
            i++;
        }
        return mutableVector2.asMutableList();
    }

    private final Differ getDiffer(Modifier.Node node, int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(node, i, mutableVector, mutableVector2, z);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(node);
        differ.setOffset(i);
        differ.setBefore(mutableVector);
        differ.setAfter(mutableVector2);
        differ.setShouldAttachOnInsert(z);
        return differ;
    }

    public final void propagateCoordinator(Modifier.Node node, NodeCoordinator nodeCoordinator) {
        for (Modifier.Node parent$ui = node.getParent$ui(); parent$ui != null; parent$ui = parent$ui.getParent$ui()) {
            if (parent$ui == this.sentinelHead) {
                LayoutNode parent$ui2 = this.layoutNode.getParent$ui();
                nodeCoordinator.setWrappedBy$ui(parent$ui2 != null ? parent$ui2.getInnerCoordinator$ui() : null);
                this.outerCoordinator = nodeCoordinator;
                return;
            } else if ((NodeKind.m7195constructorimpl(2) & parent$ui.getKindSet$ui()) != 0) {
                return;
            } else {
                parent$ui.updateCoordinator$ui(nodeCoordinator);
            }
        }
    }

    /* compiled from: NodeChain.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0018\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", TypedValues.CycleType.S_WAVE_OFFSET, "", TtmlNode.ANNOTATION_POSITION_BEFORE, "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", TtmlNode.ANNOTATION_POSITION_AFTER, "shouldAttachOnInsert", "", "<init>", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "getOffset", "()I", "setOffset", "(I)V", "getBefore", "()Landroidx/compose/runtime/collection/MutableVector;", "setBefore", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getAfter", "setAfter", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "areItemsTheSame", "oldIndex", "newIndex", "insert", "", "remove", "atIndex", "same", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;

        public Differ(Modifier.Node node, int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z) {
            NodeChain.this = r1;
            this.node = node;
            this.offset = i;
            this.before = mutableVector;
            this.after = mutableVector2;
            this.shouldAttachOnInsert = z;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node) {
            this.node = node;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final void setOffset(int i) {
            this.offset = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            this.after = mutableVector;
        }

        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        public final void setShouldAttachOnInsert(boolean z) {
            this.shouldAttachOnInsert = z;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public boolean areItemsTheSame(int i, int i2) {
            return NodeChainKt.actionForModifiers(this.before.content[this.offset + i], this.after.content[this.offset + i2]) != 0;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void insert(int i) {
            int i2 = this.offset + i;
            Modifier.Node node = this.node;
            this.node = NodeChain.this.createAndInsertNodeAsChild(this.after.content[i2], node);
            Logger logger = NodeChain.this.logger;
            if (logger != null) {
                logger.nodeInserted(i2, i2, this.after.content[i2], node, this.node);
            }
            if (this.shouldAttachOnInsert) {
                Modifier.Node child$ui = this.node.getChild$ui();
                Intrinsics.checkNotNull(child$ui);
                NodeCoordinator coordinator$ui = child$ui.getCoordinator$ui();
                Intrinsics.checkNotNull(coordinator$ui);
                LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if (asLayoutModifierNode != null) {
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(NodeChain.this.getLayoutNode(), asLayoutModifierNode);
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator2 = layoutModifierNodeCoordinator;
                    this.node.updateCoordinator$ui(layoutModifierNodeCoordinator2);
                    NodeChain.this.propagateCoordinator(this.node, layoutModifierNodeCoordinator2);
                    layoutModifierNodeCoordinator.setWrappedBy$ui(coordinator$ui.getWrappedBy$ui());
                    layoutModifierNodeCoordinator.setWrapped$ui(coordinator$ui);
                    coordinator$ui.setWrappedBy$ui(layoutModifierNodeCoordinator2);
                } else {
                    this.node.updateCoordinator$ui(coordinator$ui);
                }
                this.node.markAsAttached$ui();
                this.node.runAttachLifecycle$ui();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
                return;
            }
            this.node.setInsertedNodeAwaitingAttachForInvalidation$ui(true);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void remove(int i, int i2) {
            Modifier.Node child$ui = this.node.getChild$ui();
            Intrinsics.checkNotNull(child$ui);
            Logger logger = NodeChain.this.logger;
            if (logger != null) {
                logger.nodeRemoved(i2, this.before.content[this.offset + i2], child$ui);
            }
            if ((NodeKind.m7195constructorimpl(2) & child$ui.getKindSet$ui()) != 0) {
                NodeCoordinator coordinator$ui = child$ui.getCoordinator$ui();
                Intrinsics.checkNotNull(coordinator$ui);
                NodeCoordinator wrappedBy$ui = coordinator$ui.getWrappedBy$ui();
                NodeCoordinator wrapped$ui = coordinator$ui.getWrapped$ui();
                Intrinsics.checkNotNull(wrapped$ui);
                if (wrappedBy$ui != null) {
                    wrappedBy$ui.setWrapped$ui(wrapped$ui);
                }
                wrapped$ui.setWrappedBy$ui(wrappedBy$ui);
                NodeChain.this.propagateCoordinator(this.node, wrapped$ui);
            }
            this.node = NodeChain.this.detachAndRemoveNode(child$ui);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void same(int i, int i2) {
            Modifier.Node child$ui = this.node.getChild$ui();
            Intrinsics.checkNotNull(child$ui);
            this.node = child$ui;
            Modifier.Element element = this.before.content[this.offset + i];
            Modifier.Element element2 = this.after.content[this.offset + i2];
            if (!Intrinsics.areEqual(element, element2)) {
                NodeChain.this.updateNode(element, element2, this.node);
                Logger logger = NodeChain.this.logger;
                if (logger != null) {
                    int i3 = this.offset;
                    logger.nodeUpdated(i3 + i, i3 + i2, element, element2, this.node);
                    return;
                }
                return;
            }
            Logger logger2 = NodeChain.this.logger;
            if (logger2 != null) {
                int i4 = this.offset;
                logger2.nodeReused(i4 + i, i4 + i2, element, element2, this.node);
            }
        }
    }

    private final void structuralUpdate(int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, Modifier.Node node, boolean z) {
        MyersDiffKt.executeDiff(mutableVector.getSize() - i, mutableVector2.getSize() - i, getDiffer(node, i, mutableVector, mutableVector2, z));
        syncAggregateChildKindSet();
    }

    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui();
            node.markAsDetached$ui();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child$ui = node.getChild$ui();
        Modifier.Node parent$ui = node.getParent$ui();
        if (child$ui != null) {
            child$ui.setParent$ui(parent$ui);
            node.setChild$ui(null);
        }
        if (parent$ui != null) {
            parent$ui.setChild$ui(child$ui);
            node.setParent$ui(null);
        }
        Intrinsics.checkNotNull(parent$ui);
        return parent$ui;
    }

    public final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node node) {
        BackwardsCompatNode backwardsCompatNode;
        if (element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) element).create();
            backwardsCompatNode.setKindSet$ui(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        if (backwardsCompatNode.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.setInsertedNodeAwaitingAttachForInvalidation$ui(true);
        return insertChild(backwardsCompatNode, node);
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node child$ui = node2.getChild$ui();
        if (child$ui != null) {
            child$ui.setParent$ui(node);
            node.setChild$ui(child$ui);
        }
        node2.setChild$ui(node);
        node.setParent$ui(node2);
        return node;
    }

    public final void updateNode(Modifier.Element element, Modifier.Element element2, Modifier.Node node) {
        if ((element instanceof ModifierNodeElement) && (element2 instanceof ModifierNodeElement)) {
            NodeChainKt.updateUnsafe((ModifierNodeElement) element2, node);
            if (node.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui(true);
            }
        } else if (node instanceof BackwardsCompatNode) {
            ((BackwardsCompatNode) node).setElement(element2);
            if (node.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui(true);
            }
        } else {
            InlineClassHelperKt.throwIllegalStateException("Unknown Modifier.Node type");
        }
    }

    public final void headToTail$ui(int i, Function1<? super Modifier.Node, Unit> function1) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return;
        }
        for (Modifier.Node head$ui = getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
            if ((head$ui.getKindSet$ui() & i) != 0) {
                function1.invoke(head$ui);
            }
            if ((head$ui.getAggregateChildKindSet$ui() & i) == 0) {
                return;
            }
        }
    }

    public final void headToTail$ui(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node head$ui = getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
            function1.invoke(head$ui);
        }
    }

    public final void headToTailExclusive$ui(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node head$ui = getHead$ui(); head$ui != null && head$ui != getTail$ui(); head$ui = head$ui.getChild$ui()) {
            function1.invoke(head$ui);
        }
    }

    public final void tailToHead$ui(int i, Function1<? super Modifier.Node, Unit> function1) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return;
        }
        for (Modifier.Node tail$ui = getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
            if ((tail$ui.getKindSet$ui() & i) != 0) {
                function1.invoke(tail$ui);
            }
        }
    }

    public final void tailToHead$ui(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node tail$ui = getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
            function1.invoke(tail$ui);
        }
    }

    /* renamed from: has-H91voCI$ui */
    public final boolean m7156hasH91voCI$ui(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    public final boolean has$ui(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (this.head == this.tail) {
            sb.append("]");
        } else {
            Modifier.Node head$ui = getHead$ui();
            while (true) {
                if (head$ui == null || head$ui == getTail$ui()) {
                    break;
                }
                sb.append(String.valueOf(head$ui));
                if (head$ui.getChild$ui() == this.tail) {
                    sb.append("]");
                    break;
                }
                sb.append(StringUtils.COMMA);
                head$ui = head$ui.getChild$ui();
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void resetState$ui() {
        for (Modifier.Node tail$ui = getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
            if (tail$ui.isAttached()) {
                tail$ui.reset$ui();
            }
        }
        runDetachLifecycle$ui();
        markAsDetached$ui();
    }

    public final void markAsAttached() {
        for (Modifier.Node head$ui = getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
            head$ui.markAsAttached$ui();
        }
    }

    public final void runAttachLifecycle() {
        for (Modifier.Node head$ui = getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
            head$ui.runAttachLifecycle$ui();
            if (head$ui.getInsertedNodeAwaitingAttachForInvalidation$ui()) {
                NodeKindKt.autoInvalidateInsertedNode(head$ui);
            }
            if (head$ui.getUpdatedNodeAwaitingAttachForInvalidation$ui()) {
                NodeKindKt.autoInvalidateUpdatedNode(head$ui);
            }
            head$ui.setInsertedNodeAwaitingAttachForInvalidation$ui(false);
            head$ui.setUpdatedNodeAwaitingAttachForInvalidation$ui(false);
        }
    }

    public final void markAsDetached$ui() {
        for (Modifier.Node tail$ui = getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
            if (tail$ui.isAttached()) {
                tail$ui.markAsDetached$ui();
            }
        }
    }

    public final void runDetachLifecycle$ui() {
        for (Modifier.Node tail$ui = getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
            if (tail$ui.isAttached()) {
                tail$ui.runDetachLifecycle$ui();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: firstFromHead-aLcG6gQ$ui */
    public final /* synthetic */ <T> T m7155firstFromHeadaLcG6gQ$ui(int i, Function1<? super T, Boolean> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node head$ui = getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
                if ((head$ui.getKindSet$ui() & i) != 0) {
                    Object obj = head$ui;
                    MutableVector mutableVector = null;
                    while (obj != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (obj instanceof Object) {
                            if (function1.invoke(obj).booleanValue()) {
                                return (T) obj;
                            }
                        } else {
                            Object obj2 = obj;
                            if ((((Modifier.Node) obj).getKindSet$ui() & i) != 0 && (obj instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = obj.getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            obj = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            Object obj3 = obj;
                                            if (obj != null) {
                                                if (mutableVector != 0) {
                                                    mutableVector.add(obj);
                                                }
                                                obj = (Object) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                        }
                        obj = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui.getAggregateChildKindSet$ui() & i) == 0) {
                    break;
                }
            }
        }
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui */
    public final /* synthetic */ <T> void m7158headToTailaLcG6gQ$ui(int i, Function1<? super T, Unit> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node head$ui = getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
                if ((head$ui.getKindSet$ui() & i) != 0) {
                    Modifier.Node node = head$ui;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node instanceof Object) {
                            function1.invoke(node);
                        } else if ((node.getKindSet$ui() & i) != 0 && (node instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
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
                            if (i2 == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui.getAggregateChildKindSet$ui() & i) == 0) {
                    return;
                }
            }
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui */
    public final /* synthetic */ <T> void m7160tailToHeadaLcG6gQ$ui(int i, Function1<? super T, Unit> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node tail$ui = getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
                if ((tail$ui.getKindSet$ui() & i) != 0) {
                    Modifier.Node node = tail$ui;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node instanceof Object) {
                            function1.invoke(node);
                        } else if ((node.getKindSet$ui() & i) != 0 && (node instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
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
                            if (i2 == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* renamed from: tail-H91voCI$ui */
    public final /* synthetic */ <T> T m7159tailH91voCI$ui(int i) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node tail$ui = getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
                if ((tail$ui.getKindSet$ui() & i) != 0) {
                    T t = (T) tail$ui;
                    MutableVector mutableVector = null;
                    while (t != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (t instanceof Object) {
                            return t;
                        }
                        T t2 = t;
                        if ((((Modifier.Node) t).getKindSet$ui() & i) != 0 && (t instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (Modifier.Node delegate$ui = t.getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        t = (T) delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        T t3 = t;
                                        if (t != null) {
                                            if (mutableVector != 0) {
                                                mutableVector.add(t);
                                            }
                                            t = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        t = (T) DelegatableNodeKt.pop(mutableVector);
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* renamed from: head-H91voCI$ui */
    public final /* synthetic */ <T> T m7157headH91voCI$ui(int i) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node head$ui = getHead$ui(); head$ui != null; head$ui = head$ui.getChild$ui()) {
                if ((head$ui.getKindSet$ui() & i) != 0) {
                    T t = (T) head$ui;
                    MutableVector mutableVector = null;
                    while (t != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (t instanceof Object) {
                            return t;
                        }
                        T t2 = t;
                        if ((((Modifier.Node) t).getKindSet$ui() & i) != 0 && (t instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (Modifier.Node delegate$ui = t.getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        t = (T) delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        T t3 = t;
                                        if (t != null) {
                                            if (mutableVector != 0) {
                                                mutableVector.add(t);
                                            }
                                            t = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        t = (T) DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui.getAggregateChildKindSet$ui() & i) == 0) {
                    break;
                }
            }
        }
        return null;
    }
}
