package androidx.compose.foundation.text.input.internal;

import androidx.collection.MutableIntList;
import androidx.collection.MutableLongList;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IntIntervalTree.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\b\u0001\u0018\u0000 }*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001}B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010'\u001a\u00020\n*\u00020\n¢\u0006\u0004\b(\u0010\fJ\u0011\u0010)\u001a\u00020\n*\u00020\n¢\u0006\u0004\b*\u0010\fJ!\u0010+\u001a\u00020,*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b-\u0010.J3\u0010/\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u00101Jc\u0010G\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072K\u0010I\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020H0JJS\u0010M\u001a\u00020H2K\u0010I\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020H0JJ\u0006\u0010N\u001a\u00020HJ\b\u0010O\u001a\u00020HH\u0002J/\u0010P\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020H0QH\u0082\bJ/\u0010R\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020H0QH\u0082\bJ-\u0010S\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070QH\u0086\bJ#\u0010U\u001a\u00020,2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010VJ#\u0010W\u001a\u00020,2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010VJ'\u0010X\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\bY\u0010ZJ!\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\b\b\u0002\u0010]\u001a\u00020,H\u0002¢\u0006\u0004\b^\u0010_J\u001f\u0010`\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010a\u001a\u00020\nH\u0002¢\u0006\u0004\bb\u0010\u000eJ\u001f\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020\n2\u0006\u0010]\u001a\u00020,H\u0002¢\u0006\u0004\be\u0010_J\b\u0010f\u001a\u00020HH\u0002J\u001f\u0010g\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010h\u001a\u00020\nH\u0002¢\u0006\u0004\bi\u0010\u000eJ\u0017\u0010j\u001a\u00020H2\u0006\u0010\\\u001a\u00020\nH\u0002¢\u0006\u0004\bk\u0010=J\u0017\u0010l\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bm\u0010=J\u0017\u0010n\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bo\u0010=J\u0017\u0010p\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bq\u0010=J\u0013\u0010r\u001a\u00020,2\b\u0010s\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010t\u001a\u00020\u0007H\u0016J\f\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0006\u0010v\u001a\u00020,J\u001d\u0010w\u001a\u00020H*\u00060Bj\u0002`C2\u0006\u0010d\u001a\u00020\n¢\u0006\u0004\bx\u0010yJ\u0015\u0010z\u001a\u00020\n*\u00060Bj\u0002`C¢\u0006\u0004\b{\u0010|R0\u0010\t\u001a\u00060\u0007j\u0002`\b*\u00020\n2\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR(\u0010\u0015\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR(\u0010\u0018\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR(\u0010\u001b\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR(\u0010\u001e\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR(\u0010!\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u0004\u0018\u00018\u0000*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b;\u00108\"\u0004\b<\u0010=R\u0013\u0010?\u001a\u00020\n¢\u0006\n\n\u0002\u0010>\u001a\u0004\b@\u00108R\u0016\u0010A\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010D\u001a\u00060Bj\u0002`C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006~"}, d2 = {"Landroidx/compose/foundation/text/input/internal/IntIntervalTree;", ExifInterface.GPS_DIRECTION_TRUE, "", "source", "<init>", "(Landroidx/compose/foundation/text/input/internal/IntIntervalTree;)V", "value", "", "Landroidx/compose/foundation/text/input/internal/TreeColor;", "color", "Landroidx/compose/foundation/text/input/internal/Node;", "getColor-330cO7A", "(I)I", "setColor-9hnwElY", "(II)V", "parent", "getParent-bLpG9ms", "setParent-cfX_BQo", TtmlNode.LEFT, "getLeft-bLpG9ms", "setLeft-cfX_BQo", TtmlNode.RIGHT, "getRight-bLpG9ms", "setRight-cfX_BQo", TtmlNode.START, "getStart-330cO7A", "setStart-9hnwElY", TtmlNode.END, "getEnd-330cO7A", "setEnd-9hnwElY", "min", "getMin-330cO7A", "setMin-9hnwElY", "max", "getMax-330cO7A", "setMax-9hnwElY", "item", "getItem-330cO7A", "(I)Ljava/lang/Object;", "lowestNode", "lowestNode-bLpG9ms", "next", "next-bLpG9ms", "overlaps", "", "overlaps-XzpGiIY", "(III)Z", "Node", "Node-l-p996k", "(IILjava/lang/Object;I)I", "items", "", "nodeInfo", "Landroidx/collection/MutableLongList;", "totalNodeCount", "getTotalNodeCount", "()I", "deletedNodeCount", "root", "getRoot-27flxzM", "setRoot-330cO7A", "(I)V", "I", "terminator", "getTerminator-27flxzM", "_tempArray", "Landroidx/collection/MutableIntList;", "Landroidx/compose/foundation/text/input/internal/NodeList;", "tempArray", "getTempArray", "()Landroidx/collection/MutableIntList;", "forEachIntervalInRange", "", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "forAllIntervals", "clear", "cleanDeletedNodes", "forEachNodeInRange", "Lkotlin/Function1;", "forEachNodeMinMaxInRange", "mapIntervals", "mapper", "addInterval", "(Ljava/lang/Object;II)Z", "removeInterval", "findNode", "findNode-cKdZwxc", "(Ljava/lang/Object;II)I", "removeNode", TypedValues.AttributesType.S_TARGET, "cleanUp", "removeNode-9hnwElY", "(IZ)V", "transplant", "replacement", "transplant-cfX_BQo", "deleteNode", "node", "deleteNode-9hnwElY", "cleanDeletedNodesIfNeeded", "rebalanceAfterDeletion", "targetParent", "rebalanceAfterDeletion-cfX_BQo", "rebalanceAfterInsertion", "rebalanceAfterInsertion-330cO7A", "rotateLeft", "rotateLeft-330cO7A", "rotateRight", "rotateRight-330cO7A", "updateNodeMinMax", "updateNodeMinMax-330cO7A", "equals", "other", "hashCode", "copy", "isEmpty", "add", "add-ZlWbn38", "(Landroidx/collection/MutableIntList;I)V", "pop", "pop-2SV_EgM", "(Landroidx/collection/MutableIntList;)I", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntIntervalTree<T> {
    private static final int COLOR_PARENT = 0;
    private static final int LEFT_RIGHT = 1;
    private static final int MIN_MAX = 3;
    private static final int NODE_CLEANUP_SIZE_THRESHOLD = 64;
    private static final int START_END = 2;
    private static final int STRIDE = 4;
    private MutableIntList _tempArray;
    private int deletedNodeCount;
    private final List<T> items;
    private final MutableLongList nodeInfo;
    private int root;
    private final int terminator;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public IntIntervalTree() {
        this(null, 1, null);
    }

    /* compiled from: IntIntervalTree.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/IntIntervalTree$Companion;", "", "<init>", "()V", "NODE_CLEANUP_SIZE_THRESHOLD", "", "COLOR_PARENT", "LEFT_RIGHT", "START_END", "MIN_MAX", "STRIDE", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public IntIntervalTree(IntIntervalTree<T> intIntervalTree) {
        if (intIntervalTree != null) {
            this.items = CollectionsKt.toMutableList((Collection) intIntervalTree.items);
            MutableLongList mutableLongList = new MutableLongList(intIntervalTree.nodeInfo._size);
            mutableLongList.addAll(mutableLongList._size, intIntervalTree.nodeInfo);
            this.nodeInfo = mutableLongList;
            this.terminator = intIntervalTree.terminator;
            this.root = intIntervalTree.root;
            this.deletedNodeCount = intIntervalTree.deletedNodeCount;
            return;
        }
        this.items = new ArrayList();
        this.nodeInfo = new MutableLongList(0, 1, null);
        int m1791Nodelp996k = m1791Nodelp996k(Integer.MAX_VALUE, Integer.MIN_VALUE, null, 1);
        this.terminator = m1791Nodelp996k;
        this.root = m1791Nodelp996k;
        this.deletedNodeCount = 0;
    }

    public /* synthetic */ IntIntervalTree(IntIntervalTree intIntervalTree, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : intIntervalTree);
    }

    /* renamed from: getColor-330cO7A  reason: not valid java name */
    public final int m1806getColor330cO7A(int i) {
        return (int) (this.nodeInfo.get(i) >> 32);
    }

    /* renamed from: setColor-9hnwElY  reason: not valid java name */
    public final void m1820setColor9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.set(i, (((int) (mutableLongList.get(i) & 4294967295L)) & 4294967295L) | (i2 << 32));
    }

    /* renamed from: getParent-bLpG9ms  reason: not valid java name */
    public final int m1811getParentbLpG9ms(int i) {
        return Node.m1832constructorimpl((int) (this.nodeInfo.get(i) & 4294967295L));
    }

    /* renamed from: setParent-cfX_BQo  reason: not valid java name */
    public final void m1825setParentcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.set(i, (((int) (mutableLongList.get(i) >> 32)) << 32) | (i2 & 4294967295L));
    }

    /* renamed from: getLeft-bLpG9ms  reason: not valid java name */
    public final int m1808getLeftbLpG9ms(int i) {
        return Node.m1832constructorimpl((int) (this.nodeInfo.get(i + 1) >> 32));
    }

    /* renamed from: setLeft-cfX_BQo  reason: not valid java name */
    public final void m1822setLeftcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 1;
        mutableLongList.set(i3, (((int) (mutableLongList.get(i3) & 4294967295L)) & 4294967295L) | (i2 << 32));
    }

    /* renamed from: getRight-bLpG9ms  reason: not valid java name */
    public final int m1812getRightbLpG9ms(int i) {
        return Node.m1832constructorimpl((int) (this.nodeInfo.get(i + 1) & 4294967295L));
    }

    /* renamed from: setRight-cfX_BQo  reason: not valid java name */
    public final void m1826setRightcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 1;
        mutableLongList.set(i3, (((int) (mutableLongList.get(i3) >> 32)) << 32) | (i2 & 4294967295L));
    }

    /* renamed from: getStart-330cO7A  reason: not valid java name */
    public final int m1814getStart330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 2) >> 32);
    }

    /* renamed from: setStart-9hnwElY  reason: not valid java name */
    public final void m1828setStart9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 2;
        mutableLongList.set(i3, (((int) (mutableLongList.get(i3) & 4294967295L)) & 4294967295L) | (i2 << 32));
    }

    /* renamed from: getEnd-330cO7A  reason: not valid java name */
    public final int m1807getEnd330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 2) & 4294967295L);
    }

    /* renamed from: setEnd-9hnwElY  reason: not valid java name */
    public final void m1821setEnd9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 2;
        mutableLongList.set(i3, (((int) (mutableLongList.get(i3) >> 32)) << 32) | (i2 & 4294967295L));
    }

    /* renamed from: getMin-330cO7A  reason: not valid java name */
    public final int m1810getMin330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 3) >> 32);
    }

    /* renamed from: setMin-9hnwElY  reason: not valid java name */
    public final void m1824setMin9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 3;
        mutableLongList.set(i3, (((int) (mutableLongList.get(i3) & 4294967295L)) & 4294967295L) | (i2 << 32));
    }

    /* renamed from: getMax-330cO7A  reason: not valid java name */
    public final int m1809getMax330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 3) & 4294967295L);
    }

    /* renamed from: setMax-9hnwElY  reason: not valid java name */
    public final void m1823setMax9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 3;
        mutableLongList.set(i3, (((int) (mutableLongList.get(i3) >> 32)) << 32) | (i2 & 4294967295L));
    }

    /* renamed from: getItem-330cO7A  reason: not valid java name */
    private final T m1796getItem330cO7A(int i) {
        return this.items.get(i / 4);
    }

    /* renamed from: lowestNode-bLpG9ms  reason: not valid java name */
    public final int m1816lowestNodebLpG9ms(int i) {
        while (!Node.m1834equalsimpl0(m1808getLeftbLpG9ms(i), this.terminator)) {
            i = m1808getLeftbLpG9ms(i);
        }
        return i;
    }

    /* renamed from: next-bLpG9ms  reason: not valid java name */
    public final int m1817nextbLpG9ms(int i) {
        if (!Node.m1834equalsimpl0(m1812getRightbLpG9ms(i), this.terminator)) {
            return m1816lowestNodebLpG9ms(m1812getRightbLpG9ms(i));
        }
        int m1811getParentbLpG9ms = m1811getParentbLpG9ms(i);
        while (true) {
            int i2 = m1811getParentbLpG9ms;
            int i3 = i;
            i = i2;
            if (Node.m1834equalsimpl0(i, this.terminator) || !Node.m1834equalsimpl0(i3, m1812getRightbLpG9ms(i))) {
                break;
            }
            m1811getParentbLpG9ms = m1811getParentbLpG9ms(i);
        }
        return i;
    }

    /* renamed from: overlaps-XzpGiIY  reason: not valid java name */
    public final boolean m1818overlapsXzpGiIY(int i, int i2, int i3) {
        return IntIntervalTreeKt.intersect(i2, i3, m1814getStart330cO7A(i), m1807getEnd330cO7A(i));
    }

    /* renamed from: Node-l-p996k$default  reason: not valid java name */
    static /* synthetic */ int m1792Nodelp996k$default(IntIntervalTree intIntervalTree, int i, int i2, Object obj, int i3, int i4, Object obj2) {
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return intIntervalTree.m1791Nodelp996k(i, i2, obj, i3);
    }

    /* renamed from: Node-l-p996k  reason: not valid java name */
    private final int m1791Nodelp996k(int i, int i2, T t, int i3) {
        int i4 = this.nodeInfo._size;
        this.nodeInfo.add(i3 << 32);
        this.nodeInfo.add(0L);
        long j = (i2 & 4294967295L) | (i << 32);
        this.nodeInfo.add(j);
        this.nodeInfo.add(j);
        this.items.add(t);
        return Node.m1832constructorimpl(i4);
    }

    private final int getTotalNodeCount() {
        return this.nodeInfo._size / 4;
    }

    /* renamed from: getRoot-27flxzM  reason: not valid java name */
    public final int m1813getRoot27flxzM() {
        return this.root;
    }

    /* renamed from: setRoot-330cO7A  reason: not valid java name */
    public final void m1827setRoot330cO7A(int i) {
        this.root = i;
    }

    /* renamed from: getTerminator-27flxzM  reason: not valid java name */
    public final int m1815getTerminator27flxzM() {
        return this.terminator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableIntList getTempArray() {
        MutableIntList mutableIntList = this._tempArray;
        if (mutableIntList == null) {
            MutableIntList mutableIntList2 = new MutableIntList(0, 1, null);
            this._tempArray = mutableIntList2;
            return mutableIntList2;
        }
        return mutableIntList;
    }

    public final void forEachIntervalInRange(int i, int i2, Function3<? super T, ? super Integer, ? super Integer, Unit> function3) {
        MutableIntList tempArray = getTempArray();
        if (!Node.m1834equalsimpl0(m1813getRoot27flxzM(), m1815getTerminator27flxzM()) && m1809getMax330cO7A(m1813getRoot27flxzM()) >= i && m1810getMin330cO7A(m1813getRoot27flxzM()) <= i2) {
            int m1813getRoot27flxzM = m1813getRoot27flxzM();
            loop0: while (true) {
                boolean z = false;
                while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, m1815getTerminator27flxzM())) {
                    if (z) {
                        if (z) {
                            int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                            if (m1818overlapsXzpGiIY(m1832constructorimpl, i, i2)) {
                                tempArray.add(m1832constructorimpl);
                            }
                            if (Node.m1834equalsimpl0(m1812getRightbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i || m1810getMin330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                                z = true;
                            } else {
                                m1813getRoot27flxzM = m1812getRightbLpG9ms(m1813getRoot27flxzM);
                            }
                        } else if (z) {
                            if (!Node.m1834equalsimpl0(m1811getParentbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM())) {
                                z = Node.m1834equalsimpl0(m1813getRoot27flxzM, m1808getLeftbLpG9ms(m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                            }
                            m1813getRoot27flxzM = m1811getParentbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (Node.m1834equalsimpl0(m1808getLeftbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i) {
                        z = true;
                    } else {
                        m1813getRoot27flxzM = m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                    }
                }
                break loop0;
            }
        }
        tempArray.sort();
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i3 = mutableIntList._size;
        for (int i4 = 0; i4 < i3; i4++) {
            int m1832constructorimpl2 = Node.m1832constructorimpl(iArr[i4]);
            T m1796getItem330cO7A = m1796getItem330cO7A(m1832constructorimpl2);
            if (m1796getItem330cO7A != null) {
                function3.invoke(m1796getItem330cO7A, Integer.valueOf(m1814getStart330cO7A(m1832constructorimpl2)), Integer.valueOf(m1807getEnd330cO7A(m1832constructorimpl2)));
            }
        }
        tempArray.clear();
    }

    public final void forAllIntervals(Function3<? super T, ? super Integer, ? super Integer, Unit> function3) {
        if (Node.m1834equalsimpl0(this.root, this.terminator)) {
            return;
        }
        for (int i = 4; i < this.nodeInfo._size; i += 4) {
            int m1832constructorimpl = Node.m1832constructorimpl(i);
            if (m1806getColor330cO7A(m1832constructorimpl) != 2) {
                int m1814getStart330cO7A = m1814getStart330cO7A(m1832constructorimpl);
                int m1807getEnd330cO7A = m1807getEnd330cO7A(m1832constructorimpl);
                T m1796getItem330cO7A = m1796getItem330cO7A(m1832constructorimpl);
                if (m1796getItem330cO7A != null) {
                    function3.invoke(m1796getItem330cO7A, Integer.valueOf(m1814getStart330cO7A), Integer.valueOf(m1807getEnd330cO7A));
                }
            }
        }
    }

    public final void clear() {
        this.root = this.terminator;
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.removeRange(4, mutableLongList._size);
        List<T> list = this.items;
        list.subList(1, list.size()).clear();
        this.deletedNodeCount = 0;
    }

    private final void cleanDeletedNodes() {
        int i;
        int i2;
        char c;
        char c2;
        long j;
        int i3;
        if (this.deletedNodeCount == 0) {
            return;
        }
        MutableIntList tempArray = getTempArray();
        tempArray.ensureCapacity(getTotalNodeCount());
        int totalNodeCount = getTotalNodeCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = 2;
            i2 = 4;
            c = ' ';
            if (i4 >= totalNodeCount) {
                break;
            }
            if (((int) (this.nodeInfo.get(i4 * 4) >> 32)) == 2) {
                i5++;
            }
            tempArray.add((i4 - i5) * 4);
            i4++;
        }
        this.root = Node.m1832constructorimpl(cleanDeletedNodes$map(tempArray, this.root));
        int i6 = 4;
        while (true) {
            int i7 = this.nodeInfo._size;
            MutableLongList mutableLongList = this.nodeInfo;
            if (i2 < i7) {
                if (((int) (mutableLongList.get(i2) >> c)) == i) {
                    i2 += 4;
                } else {
                    MutableLongList mutableLongList2 = this.nodeInfo;
                    if (i6 != i2) {
                        long j2 = mutableLongList2.get(i2);
                        this.nodeInfo.set(i6, (((int) (j2 >> c)) << c) | (cleanDeletedNodes$map(tempArray, (int) (j2 & 4294967295L)) & 4294967295L));
                        long j3 = this.nodeInfo.get(i2 + 1);
                        c2 = c;
                        this.nodeInfo.set(i6 + 1, (cleanDeletedNodes$map(tempArray, (int) (j3 & 4294967295L)) & 4294967295L) | (cleanDeletedNodes$map(tempArray, (int) (j3 >> c)) << c));
                        MutableLongList mutableLongList3 = this.nodeInfo;
                        mutableLongList3.set(i6 + 2, mutableLongList3.get(i2 + 2));
                        MutableLongList mutableLongList4 = this.nodeInfo;
                        mutableLongList4.set(i6 + 3, mutableLongList4.get(i2 + 3));
                        List<T> list = this.items;
                        list.set(i6 / 4, list.get(i2 / 4));
                        i3 = i2;
                    } else {
                        c2 = c;
                        long j4 = mutableLongList2.get(i2);
                        this.nodeInfo.set(i6, (((int) (j4 >> c2)) << c2) | (cleanDeletedNodes$map(tempArray, (int) (j4 & 4294967295L)) & 4294967295L));
                        i3 = i2;
                        this.nodeInfo.set(i6 + 1, (cleanDeletedNodes$map(tempArray, (int) (j & 4294967295L)) & 4294967295L) | (cleanDeletedNodes$map(tempArray, (int) (this.nodeInfo.get(i2 + 1) >> c2)) << c2));
                    }
                    i2 = i3 + 4;
                    i6 += 4;
                    c = c2;
                    i = 2;
                }
            } else {
                mutableLongList.removeRange(i6, mutableLongList._size);
                List<T> list2 = this.items;
                list2.subList(list2.size() - this.deletedNodeCount, this.items.size()).clear();
                this.deletedNodeCount = 0;
                tempArray.clear();
                return;
            }
        }
    }

    private static final int cleanDeletedNodes$map(MutableIntList mutableIntList, int i) {
        return mutableIntList.get(i / 4);
    }

    private final void forEachNodeMinMaxInRange(int i, int i2, Function1<? super Integer, Unit> function1) {
        if (Node.m1834equalsimpl0(m1813getRoot27flxzM(), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1813getRoot27flxzM()) < i || m1810getMin330cO7A(m1813getRoot27flxzM()) > i2) {
            return;
        }
        int m1813getRoot27flxzM = m1813getRoot27flxzM();
        while (true) {
            boolean z = false;
            while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, m1815getTerminator27flxzM())) {
                if (z) {
                    if (z) {
                        function1.invoke(Integer.valueOf(m1813getRoot27flxzM));
                        if (Node.m1834equalsimpl0(m1812getRightbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i || m1810getMin330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                            z = true;
                        } else {
                            m1813getRoot27flxzM = m1812getRightbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (z) {
                        if (!Node.m1834equalsimpl0(m1811getParentbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM())) {
                            z = Node.m1834equalsimpl0(m1813getRoot27flxzM, m1808getLeftbLpG9ms(m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                        }
                        m1813getRoot27flxzM = m1811getParentbLpG9ms(m1813getRoot27flxzM);
                    }
                } else if (Node.m1834equalsimpl0(m1808getLeftbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i) {
                    z = true;
                } else {
                    m1813getRoot27flxzM = m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                }
            }
            return;
        }
    }

    static /* synthetic */ void forEachNodeMinMaxInRange$default(IntIntervalTree intIntervalTree, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        if (Node.m1834equalsimpl0(intIntervalTree.m1813getRoot27flxzM(), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1813getRoot27flxzM()) < i || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1813getRoot27flxzM()) > i2) {
            return;
        }
        int m1813getRoot27flxzM = intIntervalTree.m1813getRoot27flxzM();
        while (true) {
            boolean z = false;
            while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1815getTerminator27flxzM())) {
                if (z) {
                    if (z) {
                        function1.invoke(Integer.valueOf(m1813getRoot27flxzM));
                        if (Node.m1834equalsimpl0(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                            z = true;
                        } else {
                            m1813getRoot27flxzM = intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (z) {
                        if (!Node.m1834equalsimpl0(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM())) {
                            z = Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1808getLeftbLpG9ms(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                        }
                        m1813getRoot27flxzM = intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM);
                    }
                } else if (Node.m1834equalsimpl0(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i) {
                    z = true;
                } else {
                    m1813getRoot27flxzM = intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                }
            }
            return;
        }
    }

    public final void mapIntervals(int i, int i2, Function1<? super Integer, Integer> function1) {
        MutableIntList tempArray = getTempArray();
        if (!Node.m1834equalsimpl0(m1813getRoot27flxzM(), m1815getTerminator27flxzM()) && m1809getMax330cO7A(m1813getRoot27flxzM()) >= i && m1810getMin330cO7A(m1813getRoot27flxzM()) <= i2) {
            int m1813getRoot27flxzM = m1813getRoot27flxzM();
            loop0: while (true) {
                boolean z = false;
                while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, m1815getTerminator27flxzM())) {
                    if (z) {
                        if (z) {
                            int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                            m1828setStart9hnwElY(m1832constructorimpl, function1.invoke(Integer.valueOf(m1814getStart330cO7A(m1832constructorimpl))).intValue());
                            m1821setEnd9hnwElY(m1832constructorimpl, function1.invoke(Integer.valueOf(m1807getEnd330cO7A(m1832constructorimpl))).intValue());
                            m1824setMin9hnwElY(m1832constructorimpl, function1.invoke(Integer.valueOf(m1810getMin330cO7A(m1832constructorimpl))).intValue());
                            m1823setMax9hnwElY(m1832constructorimpl, function1.invoke(Integer.valueOf(m1809getMax330cO7A(m1832constructorimpl))).intValue());
                            if (m1807getEnd330cO7A(m1832constructorimpl) <= m1814getStart330cO7A(m1832constructorimpl)) {
                                m1805addZlWbn38(tempArray, m1832constructorimpl);
                            }
                            if (Node.m1834equalsimpl0(m1812getRightbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i || m1810getMin330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                                z = true;
                            } else {
                                m1813getRoot27flxzM = m1812getRightbLpG9ms(m1813getRoot27flxzM);
                            }
                        } else if (z) {
                            if (!Node.m1834equalsimpl0(m1811getParentbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM())) {
                                z = Node.m1834equalsimpl0(m1813getRoot27flxzM, m1808getLeftbLpG9ms(m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                            }
                            m1813getRoot27flxzM = m1811getParentbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (Node.m1834equalsimpl0(m1808getLeftbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i) {
                        z = true;
                    } else {
                        m1813getRoot27flxzM = m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                    }
                }
                break loop0;
            }
        }
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i3 = mutableIntList._size;
        for (int i4 = 0; i4 < i3; i4++) {
            m1799removeNode9hnwElY(Node.m1832constructorimpl(iArr[i4]), false);
        }
        tempArray.clear();
        cleanDeletedNodesIfNeeded();
    }

    public final boolean addInterval(T t, int i, int i2) {
        int m1812getRightbLpG9ms;
        if (i < i2 && Node.m1834equalsimpl0(m1795findNodecKdZwxc(t, i, i2), this.terminator)) {
            int m1791Nodelp996k = m1791Nodelp996k(i, i2, t, 0);
            int i3 = this.root;
            int i4 = this.terminator;
            while (!Node.m1834equalsimpl0(i3, this.terminator)) {
                if (m1814getStart330cO7A(m1791Nodelp996k) <= m1814getStart330cO7A(i3)) {
                    m1812getRightbLpG9ms = m1808getLeftbLpG9ms(i3);
                } else {
                    m1812getRightbLpG9ms = m1812getRightbLpG9ms(i3);
                }
                int i5 = m1812getRightbLpG9ms;
                i4 = i3;
                i3 = i5;
            }
            m1825setParentcfX_BQo(m1791Nodelp996k, i4);
            if (Node.m1834equalsimpl0(i4, this.terminator)) {
                this.root = m1791Nodelp996k;
            } else if (m1814getStart330cO7A(m1791Nodelp996k) <= m1814getStart330cO7A(i4)) {
                m1822setLeftcfX_BQo(i4, m1791Nodelp996k);
            } else {
                m1826setRightcfX_BQo(i4, m1791Nodelp996k);
            }
            m1804updateNodeMinMax330cO7A(i4);
            m1798rebalanceAfterInsertion330cO7A(m1791Nodelp996k);
            return true;
        }
        return false;
    }

    public final boolean removeInterval(T t, int i, int i2) {
        if (i >= i2) {
            return false;
        }
        int m1795findNodecKdZwxc = m1795findNodecKdZwxc(t, i, i2);
        if (Node.m1834equalsimpl0(m1795findNodecKdZwxc, this.terminator)) {
            return false;
        }
        m1800removeNode9hnwElY$default(this, m1795findNodecKdZwxc, false, 2, null);
        return true;
    }

    /* renamed from: findNode-cKdZwxc  reason: not valid java name */
    private final int m1795findNodecKdZwxc(T t, int i, int i2) {
        if (Node.m1834equalsimpl0(this.root, this.terminator) || m1809getMax330cO7A(this.root) < i2 || m1810getMin330cO7A(this.root) > i) {
            return this.terminator;
        }
        MutableIntList tempArray = getTempArray();
        m1805addZlWbn38(tempArray, this.root);
        while (tempArray._size != 0) {
            int m1819pop2SV_EgM = m1819pop2SV_EgM(tempArray);
            if (m1814getStart330cO7A(m1819pop2SV_EgM) == i && m1807getEnd330cO7A(m1819pop2SV_EgM) == i2 && Intrinsics.areEqual(m1796getItem330cO7A(m1819pop2SV_EgM), t)) {
                tempArray.clear();
                return m1819pop2SV_EgM;
            }
            if (m1814getStart330cO7A(m1819pop2SV_EgM) >= i) {
                int m1808getLeftbLpG9ms = m1808getLeftbLpG9ms(m1819pop2SV_EgM);
                if (!Node.m1834equalsimpl0(m1808getLeftbLpG9ms, this.terminator) && m1809getMax330cO7A(m1808getLeftbLpG9ms) >= i2) {
                    m1805addZlWbn38(tempArray, m1808getLeftbLpG9ms);
                }
            }
            if (m1814getStart330cO7A(m1819pop2SV_EgM) <= i) {
                int m1812getRightbLpG9ms = m1812getRightbLpG9ms(m1819pop2SV_EgM);
                if (!Node.m1834equalsimpl0(m1812getRightbLpG9ms, this.terminator) && m1810getMin330cO7A(m1812getRightbLpG9ms) <= i && m1809getMax330cO7A(m1812getRightbLpG9ms) >= i2) {
                    m1805addZlWbn38(tempArray, m1812getRightbLpG9ms);
                }
            }
        }
        return this.terminator;
    }

    /* renamed from: removeNode-9hnwElY$default  reason: not valid java name */
    static /* synthetic */ void m1800removeNode9hnwElY$default(IntIntervalTree intIntervalTree, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        intIntervalTree.m1799removeNode9hnwElY(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeNode-9hnwElY  reason: not valid java name */
    public final void m1799removeNode9hnwElY(int i, boolean z) {
        int m1811getParentbLpG9ms;
        int i2;
        int i3;
        int m1806getColor330cO7A = m1806getColor330cO7A(i);
        if (Node.m1834equalsimpl0(m1808getLeftbLpG9ms(i), this.terminator)) {
            i2 = m1812getRightbLpG9ms(i);
            i3 = m1811getParentbLpG9ms(i);
            m1803transplantcfX_BQo(i, m1812getRightbLpG9ms(i));
        } else if (Node.m1834equalsimpl0(m1812getRightbLpG9ms(i), this.terminator)) {
            i2 = m1808getLeftbLpG9ms(i);
            i3 = m1811getParentbLpG9ms(i);
            m1803transplantcfX_BQo(i, m1808getLeftbLpG9ms(i));
        } else {
            int m1816lowestNodebLpG9ms = m1816lowestNodebLpG9ms(m1812getRightbLpG9ms(i));
            int m1806getColor330cO7A2 = m1806getColor330cO7A(m1816lowestNodebLpG9ms);
            int m1812getRightbLpG9ms = m1812getRightbLpG9ms(m1816lowestNodebLpG9ms);
            if (Node.m1834equalsimpl0(m1811getParentbLpG9ms(m1816lowestNodebLpG9ms), i)) {
                m1811getParentbLpG9ms = m1816lowestNodebLpG9ms;
            } else {
                m1811getParentbLpG9ms = m1811getParentbLpG9ms(m1816lowestNodebLpG9ms);
                m1803transplantcfX_BQo(m1816lowestNodebLpG9ms, m1812getRightbLpG9ms(m1816lowestNodebLpG9ms));
                m1826setRightcfX_BQo(m1816lowestNodebLpG9ms, m1812getRightbLpG9ms(i));
                m1825setParentcfX_BQo(m1812getRightbLpG9ms(m1816lowestNodebLpG9ms), m1816lowestNodebLpG9ms);
            }
            m1803transplantcfX_BQo(i, m1816lowestNodebLpG9ms);
            m1822setLeftcfX_BQo(m1816lowestNodebLpG9ms, m1808getLeftbLpG9ms(i));
            m1825setParentcfX_BQo(m1808getLeftbLpG9ms(m1816lowestNodebLpG9ms), m1816lowestNodebLpG9ms);
            m1820setColor9hnwElY(m1816lowestNodebLpG9ms, m1806getColor330cO7A(i));
            m1824setMin9hnwElY(m1816lowestNodebLpG9ms, m1810getMin330cO7A(i));
            m1823setMax9hnwElY(m1816lowestNodebLpG9ms, m1809getMax330cO7A(i));
            m1806getColor330cO7A = m1806getColor330cO7A2;
            i2 = m1812getRightbLpG9ms;
            i3 = m1811getParentbLpG9ms;
        }
        m1804updateNodeMinMax330cO7A(i3);
        if (m1806getColor330cO7A == 1) {
            m1797rebalanceAfterDeletioncfX_BQo(i2, i3);
        }
        m1794deleteNode9hnwElY(i, z);
    }

    /* renamed from: transplant-cfX_BQo  reason: not valid java name */
    private final void m1803transplantcfX_BQo(int i, int i2) {
        if (Node.m1834equalsimpl0(i, i2)) {
            return;
        }
        if (Node.m1834equalsimpl0(m1811getParentbLpG9ms(i), this.terminator)) {
            this.root = i2;
        } else if (Node.m1834equalsimpl0(i, m1808getLeftbLpG9ms(m1811getParentbLpG9ms(i)))) {
            m1822setLeftcfX_BQo(m1811getParentbLpG9ms(i), i2);
        } else {
            m1826setRightcfX_BQo(m1811getParentbLpG9ms(i), i2);
        }
        if (Node.m1834equalsimpl0(i2, this.terminator)) {
            return;
        }
        m1825setParentcfX_BQo(i2, m1811getParentbLpG9ms(i));
    }

    /* renamed from: deleteNode-9hnwElY  reason: not valid java name */
    private final void m1794deleteNode9hnwElY(int i, boolean z) {
        m1820setColor9hnwElY(i, 2);
        this.deletedNodeCount++;
        if (z) {
            cleanDeletedNodesIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanDeletedNodesIfNeeded() {
        if (getTotalNodeCount() <= 64 || this.deletedNodeCount < getTotalNodeCount() / 2) {
            return;
        }
        cleanDeletedNodes();
    }

    /* renamed from: rebalanceAfterDeletion-cfX_BQo  reason: not valid java name */
    private final void m1797rebalanceAfterDeletioncfX_BQo(int i, int i2) {
        int m1811getParentbLpG9ms;
        while (!Node.m1834equalsimpl0(i, this.root) && m1806getColor330cO7A(i) == 1) {
            if (Node.m1834equalsimpl0(i, m1808getLeftbLpG9ms(i2))) {
                int m1812getRightbLpG9ms = m1812getRightbLpG9ms(i2);
                if (m1806getColor330cO7A(m1812getRightbLpG9ms) == 0) {
                    m1820setColor9hnwElY(m1812getRightbLpG9ms, 1);
                    m1820setColor9hnwElY(i2, 0);
                    m1801rotateLeft330cO7A(i2);
                    m1812getRightbLpG9ms = m1812getRightbLpG9ms(i2);
                }
                if (m1806getColor330cO7A(m1808getLeftbLpG9ms(m1812getRightbLpG9ms)) == 1 && m1806getColor330cO7A(m1812getRightbLpG9ms(m1812getRightbLpG9ms)) == 1) {
                    m1820setColor9hnwElY(m1812getRightbLpG9ms, 0);
                    m1811getParentbLpG9ms = m1811getParentbLpG9ms(i2);
                    int i3 = i2;
                    i2 = m1811getParentbLpG9ms;
                    i = i3;
                } else {
                    if (m1806getColor330cO7A(m1812getRightbLpG9ms(m1812getRightbLpG9ms)) == 1) {
                        m1820setColor9hnwElY(m1808getLeftbLpG9ms(m1812getRightbLpG9ms), 1);
                        m1820setColor9hnwElY(m1812getRightbLpG9ms, 0);
                        m1802rotateRight330cO7A(m1812getRightbLpG9ms);
                        m1812getRightbLpG9ms = m1812getRightbLpG9ms(i2);
                    }
                    m1820setColor9hnwElY(m1812getRightbLpG9ms, m1806getColor330cO7A(i2));
                    m1820setColor9hnwElY(i2, 1);
                    m1820setColor9hnwElY(m1812getRightbLpG9ms(m1812getRightbLpG9ms), 1);
                    m1801rotateLeft330cO7A(i2);
                    i = this.root;
                }
            } else {
                int m1808getLeftbLpG9ms = m1808getLeftbLpG9ms(i2);
                if (m1806getColor330cO7A(m1808getLeftbLpG9ms) == 0) {
                    m1820setColor9hnwElY(m1808getLeftbLpG9ms, 1);
                    m1820setColor9hnwElY(i2, 0);
                    m1802rotateRight330cO7A(i2);
                    m1808getLeftbLpG9ms = m1808getLeftbLpG9ms(i2);
                }
                if (m1806getColor330cO7A(m1812getRightbLpG9ms(m1808getLeftbLpG9ms)) == 1 && m1806getColor330cO7A(m1808getLeftbLpG9ms(m1808getLeftbLpG9ms)) == 1) {
                    m1820setColor9hnwElY(m1808getLeftbLpG9ms, 0);
                    m1811getParentbLpG9ms = m1811getParentbLpG9ms(i2);
                    int i32 = i2;
                    i2 = m1811getParentbLpG9ms;
                    i = i32;
                } else {
                    if (m1806getColor330cO7A(m1808getLeftbLpG9ms(m1808getLeftbLpG9ms)) == 1) {
                        m1820setColor9hnwElY(m1812getRightbLpG9ms(m1808getLeftbLpG9ms), 1);
                        m1820setColor9hnwElY(m1808getLeftbLpG9ms, 0);
                        m1801rotateLeft330cO7A(m1808getLeftbLpG9ms);
                        m1808getLeftbLpG9ms = m1808getLeftbLpG9ms(i2);
                    }
                    m1820setColor9hnwElY(m1808getLeftbLpG9ms, m1806getColor330cO7A(i2));
                    m1820setColor9hnwElY(i2, 1);
                    m1820setColor9hnwElY(m1808getLeftbLpG9ms(m1808getLeftbLpG9ms), 1);
                    m1802rotateRight330cO7A(i2);
                    i = this.root;
                }
            }
        }
        m1820setColor9hnwElY(i, 1);
    }

    /* renamed from: rebalanceAfterInsertion-330cO7A  reason: not valid java name */
    private final void m1798rebalanceAfterInsertion330cO7A(int i) {
        while (!Node.m1834equalsimpl0(i, this.root) && m1806getColor330cO7A(m1811getParentbLpG9ms(i)) == 0) {
            int m1811getParentbLpG9ms = m1811getParentbLpG9ms(m1811getParentbLpG9ms(i));
            if (Node.m1834equalsimpl0(m1811getParentbLpG9ms(i), m1808getLeftbLpG9ms(m1811getParentbLpG9ms))) {
                int m1812getRightbLpG9ms = m1812getRightbLpG9ms(m1811getParentbLpG9ms);
                if (m1806getColor330cO7A(m1812getRightbLpG9ms) == 0) {
                    m1820setColor9hnwElY(m1812getRightbLpG9ms, 1);
                    m1820setColor9hnwElY(m1811getParentbLpG9ms(i), 1);
                    m1820setColor9hnwElY(m1811getParentbLpG9ms, 0);
                    i = m1811getParentbLpG9ms;
                } else {
                    if (Node.m1834equalsimpl0(i, m1812getRightbLpG9ms(m1811getParentbLpG9ms(i)))) {
                        i = m1811getParentbLpG9ms(i);
                        m1801rotateLeft330cO7A(i);
                    }
                    m1820setColor9hnwElY(m1811getParentbLpG9ms(i), 1);
                    m1820setColor9hnwElY(m1811getParentbLpG9ms, 0);
                    m1802rotateRight330cO7A(m1811getParentbLpG9ms);
                }
            } else {
                int m1808getLeftbLpG9ms = m1808getLeftbLpG9ms(m1811getParentbLpG9ms);
                if (m1806getColor330cO7A(m1808getLeftbLpG9ms) == 0) {
                    m1820setColor9hnwElY(m1808getLeftbLpG9ms, 1);
                    m1820setColor9hnwElY(m1811getParentbLpG9ms(i), 1);
                    m1820setColor9hnwElY(m1811getParentbLpG9ms, 0);
                    i = m1811getParentbLpG9ms;
                } else {
                    if (Node.m1834equalsimpl0(i, m1808getLeftbLpG9ms(m1811getParentbLpG9ms(i)))) {
                        i = m1811getParentbLpG9ms(i);
                        m1802rotateRight330cO7A(i);
                    }
                    m1820setColor9hnwElY(m1811getParentbLpG9ms(i), 1);
                    m1820setColor9hnwElY(m1811getParentbLpG9ms, 0);
                    m1801rotateLeft330cO7A(m1811getParentbLpG9ms);
                }
            }
        }
        m1820setColor9hnwElY(this.root, 1);
    }

    /* renamed from: rotateLeft-330cO7A  reason: not valid java name */
    private final void m1801rotateLeft330cO7A(int i) {
        int m1812getRightbLpG9ms = m1812getRightbLpG9ms(i);
        m1826setRightcfX_BQo(i, m1808getLeftbLpG9ms(m1812getRightbLpG9ms));
        if (!Node.m1834equalsimpl0(m1808getLeftbLpG9ms(m1812getRightbLpG9ms), this.terminator)) {
            m1825setParentcfX_BQo(m1808getLeftbLpG9ms(m1812getRightbLpG9ms), i);
        }
        m1825setParentcfX_BQo(m1812getRightbLpG9ms, m1811getParentbLpG9ms(i));
        if (Node.m1834equalsimpl0(m1811getParentbLpG9ms(i), this.terminator)) {
            this.root = m1812getRightbLpG9ms;
        } else if (Node.m1834equalsimpl0(m1808getLeftbLpG9ms(m1811getParentbLpG9ms(i)), i)) {
            m1822setLeftcfX_BQo(m1811getParentbLpG9ms(i), m1812getRightbLpG9ms);
        } else {
            m1826setRightcfX_BQo(m1811getParentbLpG9ms(i), m1812getRightbLpG9ms);
        }
        m1822setLeftcfX_BQo(m1812getRightbLpG9ms, i);
        m1825setParentcfX_BQo(i, m1812getRightbLpG9ms);
        m1804updateNodeMinMax330cO7A(i);
    }

    /* renamed from: rotateRight-330cO7A  reason: not valid java name */
    private final void m1802rotateRight330cO7A(int i) {
        int m1808getLeftbLpG9ms = m1808getLeftbLpG9ms(i);
        m1822setLeftcfX_BQo(i, m1812getRightbLpG9ms(m1808getLeftbLpG9ms));
        if (!Node.m1834equalsimpl0(m1812getRightbLpG9ms(m1808getLeftbLpG9ms), this.terminator)) {
            m1825setParentcfX_BQo(m1812getRightbLpG9ms(m1808getLeftbLpG9ms), i);
        }
        m1825setParentcfX_BQo(m1808getLeftbLpG9ms, m1811getParentbLpG9ms(i));
        if (Node.m1834equalsimpl0(m1811getParentbLpG9ms(i), this.terminator)) {
            this.root = m1808getLeftbLpG9ms;
        } else if (Node.m1834equalsimpl0(m1812getRightbLpG9ms(m1811getParentbLpG9ms(i)), i)) {
            m1826setRightcfX_BQo(m1811getParentbLpG9ms(i), m1808getLeftbLpG9ms);
        } else {
            m1822setLeftcfX_BQo(m1811getParentbLpG9ms(i), m1808getLeftbLpG9ms);
        }
        m1826setRightcfX_BQo(m1808getLeftbLpG9ms, i);
        m1825setParentcfX_BQo(i, m1808getLeftbLpG9ms);
        m1804updateNodeMinMax330cO7A(i);
    }

    /* renamed from: updateNodeMinMax-330cO7A  reason: not valid java name */
    private final void m1804updateNodeMinMax330cO7A(int i) {
        while (!Node.m1834equalsimpl0(i, this.terminator)) {
            m1824setMin9hnwElY(i, Math.min(m1814getStart330cO7A(i), Math.min(m1810getMin330cO7A(m1808getLeftbLpG9ms(i)), m1810getMin330cO7A(m1812getRightbLpG9ms(i)))));
            m1823setMax9hnwElY(i, Math.max(m1807getEnd330cO7A(i), Math.max(m1809getMax330cO7A(m1808getLeftbLpG9ms(i)), m1809getMax330cO7A(m1812getRightbLpG9ms(i)))));
            i = m1811getParentbLpG9ms(i);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntIntervalTree) {
            IntIntervalTree intIntervalTree = (IntIntervalTree) obj;
            if (this.nodeInfo.get(this.root + 3) == intIntervalTree.nodeInfo.get(intIntervalTree.root + 3) && getTotalNodeCount() - this.deletedNodeCount == intIntervalTree.getTotalNodeCount() - intIntervalTree.deletedNodeCount) {
                int i = 4;
                int i2 = 4;
                while (i < this.nodeInfo._size && i2 < intIntervalTree.nodeInfo._size) {
                    if (((int) (this.nodeInfo.get(i) >> 32)) == 2) {
                        i += 4;
                    } else {
                        if (((int) (intIntervalTree.nodeInfo.get(i2) >> 32)) != 2) {
                            if (this.nodeInfo.get(i + 2) != intIntervalTree.nodeInfo.get(i2 + 2) || !Intrinsics.areEqual(this.items.get(i / 4), intIntervalTree.items.get(i2 / 4))) {
                                return false;
                            }
                            i += 4;
                        }
                        i2 += 4;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 4; i2 < this.nodeInfo._size; i2 += 4) {
            int m1832constructorimpl = Node.m1832constructorimpl(i2);
            if (m1806getColor330cO7A(m1832constructorimpl) != 2) {
                int m1814getStart330cO7A = ((((i * 31) + m1814getStart330cO7A(m1832constructorimpl)) * 31) + m1807getEnd330cO7A(m1832constructorimpl)) * 31;
                T m1796getItem330cO7A = m1796getItem330cO7A(m1832constructorimpl);
                i = m1814getStart330cO7A + (m1796getItem330cO7A != null ? m1796getItem330cO7A.hashCode() : 0);
            }
        }
        return i;
    }

    public final IntIntervalTree<T> copy() {
        cleanDeletedNodes();
        return new IntIntervalTree<>(this);
    }

    public final boolean isEmpty() {
        return Node.m1834equalsimpl0(this.root, this.terminator);
    }

    /* renamed from: add-ZlWbn38  reason: not valid java name */
    public final void m1805addZlWbn38(MutableIntList mutableIntList, int i) {
        mutableIntList.add(i);
    }

    /* renamed from: pop-2SV_EgM  reason: not valid java name */
    public final int m1819pop2SV_EgM(MutableIntList mutableIntList) {
        return Node.m1832constructorimpl(mutableIntList.removeAt(mutableIntList._size - 1));
    }

    private final void forEachNodeInRange(int i, int i2, Function1<? super Integer, Unit> function1) {
        if (Node.m1834equalsimpl0(m1813getRoot27flxzM(), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1813getRoot27flxzM()) < i || m1810getMin330cO7A(m1813getRoot27flxzM()) > i2) {
            return;
        }
        int m1813getRoot27flxzM = m1813getRoot27flxzM();
        while (true) {
            boolean z = false;
            while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, m1815getTerminator27flxzM())) {
                if (z) {
                    if (z) {
                        int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                        if (m1818overlapsXzpGiIY(m1832constructorimpl, i, i2)) {
                            function1.invoke(Integer.valueOf(m1832constructorimpl));
                        }
                        if (Node.m1834equalsimpl0(m1812getRightbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i || m1810getMin330cO7A(m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                            z = true;
                        } else {
                            m1813getRoot27flxzM = m1812getRightbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (z) {
                        if (!Node.m1834equalsimpl0(m1811getParentbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM())) {
                            z = Node.m1834equalsimpl0(m1813getRoot27flxzM, m1808getLeftbLpG9ms(m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                        }
                        m1813getRoot27flxzM = m1811getParentbLpG9ms(m1813getRoot27flxzM);
                    }
                } else if (Node.m1834equalsimpl0(m1808getLeftbLpG9ms(m1813getRoot27flxzM), m1815getTerminator27flxzM()) || m1809getMax330cO7A(m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i) {
                    z = true;
                } else {
                    m1813getRoot27flxzM = m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                }
            }
            return;
        }
    }

    static /* synthetic */ void forEachNodeInRange$default(IntIntervalTree intIntervalTree, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        if (Node.m1834equalsimpl0(intIntervalTree.m1813getRoot27flxzM(), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1813getRoot27flxzM()) < i || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1813getRoot27flxzM()) > i2) {
            return;
        }
        int m1813getRoot27flxzM = intIntervalTree.m1813getRoot27flxzM();
        while (true) {
            boolean z = false;
            while (!Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1815getTerminator27flxzM())) {
                if (z) {
                    if (z) {
                        int m1832constructorimpl = Node.m1832constructorimpl(m1813getRoot27flxzM);
                        if (intIntervalTree.m1818overlapsXzpGiIY(m1832constructorimpl, i, i2)) {
                            function1.invoke(Integer.valueOf(m1832constructorimpl));
                        }
                        if (Node.m1834equalsimpl0(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) < i || intIntervalTree.m1810getMin330cO7A(intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM)) > i2) {
                            z = true;
                        } else {
                            m1813getRoot27flxzM = intIntervalTree.m1812getRightbLpG9ms(m1813getRoot27flxzM);
                        }
                    } else if (z) {
                        if (!Node.m1834equalsimpl0(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM())) {
                            z = Node.m1834equalsimpl0(m1813getRoot27flxzM, intIntervalTree.m1808getLeftbLpG9ms(intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM))) ? true : true;
                        }
                        m1813getRoot27flxzM = intIntervalTree.m1811getParentbLpG9ms(m1813getRoot27flxzM);
                    }
                } else if (Node.m1834equalsimpl0(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM), intIntervalTree.m1815getTerminator27flxzM()) || intIntervalTree.m1809getMax330cO7A(intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM)) < i) {
                    z = true;
                } else {
                    m1813getRoot27flxzM = intIntervalTree.m1808getLeftbLpG9ms(m1813getRoot27flxzM);
                }
            }
            return;
        }
    }
}
