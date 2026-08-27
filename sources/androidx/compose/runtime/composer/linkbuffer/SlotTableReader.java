package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.UpdateServiceContract;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SlotTableReader.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u00100\u001a\u0004\u0018\u00010\u00012\n\u00101\u001a\u00060\u0010j\u0002`\u00132\u0006\u0010\u001f\u001a\u00020\u0010J\u001c\u00102\u001a\u0004\u0018\u00010\u00012\n\u00101\u001a\u00060\u0010j\u0002`\u00132\u0006\u0010\u001f\u001a\u00020\u0010J\u0012\u00103\u001a\u00020\u00102\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\u0014\u00106\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010@\u001a\u00020$2\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010;\u001a\u0004\u0018\u00010\u00012\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010=\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010C\u001a\u00020$2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010]\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0014\u0010^\u001a\u0004\u0018\u00010\u00012\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010_\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010`\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010a\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010b\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\n\u0010c\u001a\u00060Oj\u0002`PJ\n\u0010d\u001a\u00060Oj\u0002`PJ\u0012\u0010e\u001a\u00020$2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010f\u001a\u00020$2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0016\u0010g\u001a\u00060\u0010j\u0002`h2\n\u00101\u001a\u00060\u0010j\u0002`\u0013J\n\u0010i\u001a\u00060\u0010j\u0002`hJ\u0006\u0010j\u001a\u00020kJ\u0006\u0010l\u001a\u00020kJ\u0006\u0010m\u001a\u00020kJ\u0006\u0010n\u001a\u00020kJ\u0006\u0010o\u001a\u00020\u0010J\u0006\u0010p\u001a\u00020kJ\u0012\u0010q\u001a\u00020k2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0013J\b\u0010r\u001a\u0004\u0018\u00010\u0001J\u0012\u00109\u001a\u00020\u00102\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0010\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010s\u001a\u00020\u0010J\u0006\u0010t\u001a\u00020kJ\u0006\u0010u\u001a\u00020kJ\u0012\u0010v\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u0013J\u0012\u0010v\u001a\u00020k2\n\u0010c\u001a\u00060Oj\u0002`PJ\f\u0010w\u001a\b\u0012\u0004\u0012\u00020y0xJ \u0010z\u001a\u00020k2\f\b\u0002\u0010{\u001a\u00060\u0010j\u0002`\u00132\n\u0010|\u001a\u00060\u0010j\u0002`hJ\u0012\u0010}\u001a\u00020k2\n\u0010|\u001a\u00060\u0010j\u0002`hJ\u001e\u0010}\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u00132\n\u0010|\u001a\u00060\u0010j\u0002`hJK\u0010~\u001a\u00020k2\n\u0010\u007f\u001a\u00060\u0010j\u0002`\u00132\t\b\u0002\u0010\u0080\u0001\u001a\u00020$2)\u0010\u0081\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u0001H\u0086\bJÂ\u0001\u0010\u0085\u0001\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u00132)\u0010\u0086\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u00012)\u0010\u0087\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u00012)\u0010\u0088\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020k0\u0082\u00012)\u0010\u0089\u0001\u001a$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020k0\u0082\u0001H\u0086\bJA\u0010\u008a\u0001\u001a\u00020k2\n\u0010?\u001a\u00060\u0010j\u0002`\u00132)\u0010\u0087\u0001\u001a$\u0012\u0019\u0012\u00170Oj\u0002`P¢\u0006\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020k0\u0082\u0001H\u0086\bJ\u0018\u0010\u008b\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0082\b¢\u0006\u0003\u0010\u008c\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010)\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b)\u0010'R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010+\u001a\u00060\u0010j\u0002`\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00138F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0011\u0010.\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b/\u0010\u0016R\u0011\u00104\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u0013\u00106\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b:\u0010\u0016R\u0013\u0010;\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b<\u00108R\u0013\u0010=\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b>\u00108R\u0011\u0010@\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bA\u0010'R\u0011\u0010B\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bB\u0010'R\u0011\u0010C\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bC\u0010'R\u0011\u0010D\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bE\u0010'R\u0015\u0010F\u001a\u00060\u0010j\u0002`\u00138F¢\u0006\u0006\u001a\u0004\bG\u0010\u0016R\u0015\u0010H\u001a\u00060\u0010j\u0002`\u00138F¢\u0006\u0006\u001a\u0004\bI\u0010\u0016R\u0011\u0010J\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0015\u0010N\u001a\u00060Oj\u0002`P8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0013\u0010S\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bT\u00108R\u0011\u00103\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bU\u0010\u0016R\u0011\u0010V\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bW\u0010\u0016R\u0015\u0010X\u001a\u00060\u0010j\u0002`Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010\u0016R\u0011\u0010[\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\\\u0010\u0016¨\u0006\u008d\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "groups", "", "slots", "", "[Ljava/lang/Object;", "parent", "", "_current", "value", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", UpdateServiceContract.BundleKey.CURRENT, "getCurrent", "()I", "setCurrent", "(I)V", "slotCurrent", "getSlotCurrent", "setSlotCurrent", "slotEnd", "getSlotEnd", "setSlotEnd", "slotIndex", "getSlotIndex", "previousSlotCurrentOffset", "Landroidx/compose/runtime/IntStack;", "emptyCount", "", "hadNext", "getHadNext", "()Z", "isClosed", "isEmpty", "_previousSibling", "previousSibling", "getPreviousSibling", "setPreviousSibling", "remainingSlots", "getRemainingSlots", "get", "address", "getOrNull", "nodeCount", "parentCurrentSlotOffset", "getParentCurrentSlotOffset", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupKey", "getGroupKey", "groupObjectKey", "getGroupObjectKey", "groupNode", "getGroupNode", "group", "hasObjectKey", "getHasObjectKey", "isGroupEnd", "isNode", "inEmpty", "getInEmpty", "currentGroup", "getCurrentGroup", "parentGroup", "getParentGroup", "parentAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "getParentAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "parentHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "getParentHandle", "()J", "parentNode", "getParentNode", "getNodeCount", "parentNodeCount", "getParentNodeCount", "groupReferenceSlotStartAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "getGroupReferenceSlotStartAddress", "nextParentSlotAddress", "getNextParentSlotAddress", "node", "maybeNode", "parentOf", "firstChildOf", "nextSiblingOf", "childNodeCountOf", "handle", "rootHandle", "recomposeRequired", "hasRecomposeRequired", "flagsOf", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "parentGroupFlags", "close", "", "startGroup", "startNode", "endGroup", "skipGroup", "skipToGroupEnd", "restoreParent", "next", FirebaseAnalytics.Param.INDEX, "beginEmpty", "endEmpty", "reposition", "extractKeys", "", "Landroidx/compose/runtime/composer/linkbuffer/KeyInfo;", "addFlag", "groupAddress", DownloaderServiceMarshaller.PARAMS_FLAGS, "removeFlag", "traverseGroupPartially", TtmlNode.START, "includeSiblingsOfStartGroup", "visit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "traverseChildrenConditionally", "enter", "block", "exit", "skip", "traverseChildrenByHandle", "upToDateSlots", "()[Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTableReader {
    public static final int $stable = 8;
    private int _current;
    private int _previousSibling;
    private SlotTableAddressSpace addressSpace;
    private int emptyCount;
    private int[] groups;
    private boolean hadNext;
    private boolean isClosed;
    private int parent;
    private final IntStack previousSlotCurrentOffset;
    private int slotCurrent;
    private int slotEnd;
    private Object[] slots;
    private final SlotTable table;

    public SlotTableReader(SlotTable slotTable) {
        this.table = slotTable;
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        this.addressSpace = addressSpace;
        this.groups = addressSpace.getGroups();
        this.slots = slotTable.getAddressSpace().getSlots();
        this.parent = -1;
        this._current = slotTable.getRoot();
        this.previousSlotCurrentOffset = new IntStack();
        this._previousSibling = -1;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    private final int getCurrent() {
        return this._current;
    }

    private final void setCurrent(int i) {
        this._current = i;
    }

    public final int getSlotCurrent() {
        return this.slotCurrent;
    }

    public final void setSlotCurrent(int i) {
        this.slotCurrent = i;
    }

    public final int getSlotEnd() {
        return this.slotEnd;
    }

    public final void setSlotEnd(int i) {
        this.slotEnd = i;
    }

    public final int getSlotIndex() {
        int i = this.parent;
        if (i >= 0) {
            return this.slotCurrent - (this.groups[i + 5] >> 4);
        }
        return 0;
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.table.isEmpty();
    }

    public final int getPreviousSibling() {
        return this._previousSibling;
    }

    private final void setPreviousSibling(int i) {
        this._previousSibling = i;
    }

    public final int getRemainingSlots() {
        return this.slotEnd - this.slotCurrent;
    }

    public final Object get(int i, int i2) {
        if (i2 >= 0) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            int i3 = iArr[i + 5];
            if (i3 != -1) {
                int i4 = iArr[i + 4];
                SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
                int i5 = (i3 & 15) + 1;
                int i6 = i3 >> 4;
                if (i5 > 15) {
                    i5 = slotTableAddressSpace.getLargeSizes().get(i6);
                }
                int utilitySlotsCountForFlags = i2 + GroupFlagsKt.utilitySlotsCountForFlags(i4);
                if (utilitySlotsCountForFlags < i5) {
                    return objArr[i6 + utilitySlotsCountForFlags];
                }
            }
        }
        return Composer.Companion.getEmpty();
    }

    public final Object getOrNull(int i, int i2) {
        Object obj = get(i, i2);
        if (obj == null || Intrinsics.areEqual(obj, Composer.Companion.getEmpty())) {
            return null;
        }
        return obj;
    }

    public final int nodeCount(int i) {
        int i2 = this.groups[i + 4];
        if ((i2 & 8388608) == 8388608) {
            return 1;
        }
        return i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final int getParentCurrentSlotOffset() {
        int i = this.groups[this.parent + 5];
        if (i == -1) {
            return 0;
        }
        return this.slotCurrent - (i >> 4);
    }

    public final Object getGroupAux() {
        return groupAux(getCurrent());
    }

    public final int getGroupKey() {
        int current = getCurrent();
        if (current != -1) {
            return this.addressSpace.getGroups()[current];
        }
        return 0;
    }

    public final Object getGroupObjectKey() {
        return groupObjectKey(getCurrent());
    }

    public final Object getGroupNode() {
        return groupNode(getCurrent());
    }

    public final Object groupAux(int i) {
        int[] iArr = this.groups;
        int i2 = iArr[i + 4];
        int i3 = iArr[i + 5];
        if ((i2 & GroupFlagsKt.HasAuxSlotFlag) != 33554432) {
            return Composer.Companion.getEmpty();
        }
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots[(i3 >> 4) + Integer.bitCount(25165824 & i2)];
    }

    public final boolean getHasObjectKey() {
        return hasObjectKey(getCurrent());
    }

    public final boolean hasObjectKey(int i) {
        return (this.groups[i + 4] & 16777216) == 16777216;
    }

    public final Object groupObjectKey(int i) {
        int[] iArr = this.groups;
        int i2 = iArr[i + 4];
        int i3 = iArr[i + 5];
        if ((i2 & 16777216) == 16777216) {
            if (this.emptyCount > 0) {
                this.slots = this.addressSpace.getSlots();
            }
            return this.slots[(i3 >> 4) + Integer.bitCount(8388608 & i2)];
        }
        return null;
    }

    public final Object groupNode(int i) {
        int[] iArr = this.groups;
        int i2 = iArr[i + 4];
        int i3 = iArr[i + 5];
        if ((i2 & 8388608) == 8388608) {
            if (this.emptyCount > 0) {
                this.slots = this.addressSpace.getSlots();
            }
            return this.slots[i3 >> 4];
        }
        return null;
    }

    public final boolean isGroupEnd() {
        return getCurrent() == -1 && !getInEmpty();
    }

    public final boolean isNode() {
        return (this.groups[getCurrent() + 4] & 8388608) == 8388608;
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final boolean isNode(int i) {
        return (this.groups[i + 4] & 8388608) == 8388608;
    }

    public final int getCurrentGroup() {
        return getCurrent();
    }

    public final int getParentGroup() {
        return this.parent;
    }

    public final LinkAnchor getParentAnchor() {
        return this.addressSpace.anchorOfAddress(getParentGroup());
    }

    public final long getParentHandle() {
        return UInt.m10020constructorimpl(this.parent) & 4294967295L;
    }

    public final Object getParentNode() {
        return groupNode(this.parent);
    }

    public final int getNodeCount() {
        return this.groups[getCurrent() + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final int getParentNodeCount() {
        int i = this.parent;
        if (i != -1) {
            int i2 = this.groups[i + 4];
            if ((i2 & 8388608) == 8388608) {
                return 1;
            }
            return i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
        }
        return 0;
    }

    public final int getGroupReferenceSlotStartAddress() {
        return this.groups[this.parent + 5] >> 4;
    }

    public final int getNextParentSlotAddress() {
        return this.slotCurrent;
    }

    public final Object node(int i) {
        return this.slots[this.groups[i + 5] >> 4];
    }

    public final Object maybeNode(int i) {
        if ((this.groups[i + 4] & 8388608) != 8388608) {
            return Composer.Companion.getEmpty();
        }
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots[this.groups[i + 5] >> 4];
    }

    public final int parentOf(int i) {
        return this.groups[i + 2];
    }

    public final int firstChildOf(int i) {
        return this.groups[i + 3];
    }

    public final int nextSiblingOf(int i) {
        return this.groups[i + 1];
    }

    public final int childNodeCountOf(int i) {
        return this.groups[i + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final long handle() {
        return GroupHandleKt.makeGroupHandle(this.parent, getPreviousSibling(), getCurrent());
    }

    public final long rootHandle() {
        return (UInt.m10020constructorimpl(this.table.getRoot()) & 4294967295L) | (-4294967296L);
    }

    public final boolean recomposeRequired(int i) {
        return (this.groups[i + 4] & 67108864) == 67108864;
    }

    public final boolean hasRecomposeRequired(int i) {
        return (this.groups[i + 4] & 201326592) != 0;
    }

    public final int flagsOf(int i) {
        return this.groups[i + 4];
    }

    public final int parentGroupFlags() {
        return flagsOf(this.parent);
    }

    public final void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.table.closeReader(this);
    }

    public final void startGroup() {
        int i;
        int current = getCurrent();
        this.parent = current;
        int[] iArr = this.groups;
        if (current + 6 > iArr.length) {
            return;
        }
        setCurrent(iArr[current + 3]);
        setPreviousSibling(-1);
        this.previousSlotCurrentOffset.push(this.slotEnd - this.slotCurrent);
        int i2 = iArr[current + 5];
        if (i2 == -1) {
            this.slotCurrent = -1;
            this.slotEnd = -1;
            return;
        }
        int i3 = iArr[current + 4];
        int i4 = i2 >> 4;
        this.slotCurrent = GroupFlagsKt.utilitySlotsCountForFlags(i3) + i4;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (i2 == -1) {
            i = 0;
        } else {
            int i5 = (i2 & 15) + 1;
            i = i5 > 15 ? slotTableAddressSpace.getLargeSizes().get(i4) : i5;
        }
        this.slotEnd = i4 + i;
    }

    public final void startNode() {
        if (!isNode()) {
            ComposerKt.composeImmediateRuntimeError("Expected a node group");
        }
        startGroup();
    }

    public final void endGroup() {
        int i;
        int i2 = this.parent;
        int[] iArr = this.groups;
        if (i2 + 6 > iArr.length) {
            return;
        }
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2 + 2];
        this.parent = i4;
        setPreviousSibling(i2);
        setCurrent(i3);
        int i5 = this.groups[i4 + 5];
        int i6 = i5 >> 4;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (i5 == -1) {
            i = 0;
        } else {
            i = (i5 & 15) + 1;
            if (i > 15) {
                i = slotTableAddressSpace.getLargeSizes().get(i6);
            }
        }
        int i7 = i6 + i;
        this.slotEnd = i7;
        this.slotCurrent = i7 - this.previousSlotCurrentOffset.popOr(0);
    }

    public final int skipGroup() {
        int current = getCurrent();
        int[] iArr = this.groups;
        if (current + 6 > iArr.length) {
            return 0;
        }
        int i = iArr[current + 4];
        int i2 = (i & 8388608) == 8388608 ? 1 : i & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
        setCurrent(iArr[current + 1]);
        setPreviousSibling(current);
        return i2;
    }

    public final void skipToGroupEnd() {
        setCurrent(-1);
        setPreviousSibling(0);
        this.slotCurrent = 0;
        this.slotEnd = 0;
    }

    public final void restoreParent(int i) {
        setPreviousSibling(0);
        this.parent = i;
        this.slotCurrent = 0;
        this.slotEnd = 0;
    }

    public final Object next() {
        int i;
        if (getInEmpty() || (i = this.slotCurrent) >= this.slotEnd) {
            this.hadNext = false;
            return Composer.Companion.getEmpty();
        }
        this.hadNext = true;
        Object[] objArr = this.slots;
        this.slotCurrent = i + 1;
        return objArr[i];
    }

    public final int groupKey(int i) {
        return this.groups[i];
    }

    public final Object get(int i) {
        return get(getCurrent(), i);
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void endEmpty() {
        if (!(this.emptyCount > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unbalanced begin/end empty");
        }
        int i = this.emptyCount - 1;
        this.emptyCount = i;
        if (i == 0) {
            this.slots = this.addressSpace.getSlots();
            int[] groups = this.addressSpace.getGroups();
            this.groups = groups;
            int i2 = this.slotEnd - this.slotCurrent;
            int i3 = groups[this.parent + 5];
            if (i3 != -1) {
                SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
                int i4 = (i3 & 15) + 1;
                int i5 = i3 >> 4;
                if (i4 > 15) {
                    i4 = slotTableAddressSpace.getLargeSizes().get(i5);
                }
                int i6 = i5 + i4;
                this.slotCurrent = i6 - i2;
                this.slotEnd = i6;
            }
        }
    }

    public final void reposition(long j) {
        if (getInEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }
        setCurrent(GroupHandleKt.getGroup(j));
        setPreviousSibling(GroupHandleKt.getContext(j));
        this.parent = this.groups[getCurrent() + 2];
    }

    public final List<KeyInfo> extractKeys() {
        ArrayList arrayList = new ArrayList();
        if (!getInEmpty()) {
            int previousSibling = getPreviousSibling();
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            SlotTable slotTable = this.table;
            int currentGroup = getCurrentGroup();
            int[] groups = slotTable.getAddressSpace().getGroups();
            int i = currentGroup;
            int i2 = previousSibling;
            int i3 = 0;
            while (i >= 0) {
                int i4 = iArr[i + 4];
                int i5 = i3 + 1;
                arrayList.add(new KeyInfo(iArr[i], (i4 & 16777216) == 16777216 ? objArr[(iArr[i + 5] >> 4) + Integer.bitCount(i4 & 8388608)] : null, (i2 << 32) | (UInt.m10020constructorimpl(i) & 4294967295L), (i4 & 8388608) == 8388608 ? 1 : 8388607 & i4, i3));
                int i6 = i;
                i = groups[i + 1];
                i2 = i6;
                i3 = i5;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void addFlag$default(SlotTableReader slotTableReader, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = slotTableReader.getParentGroup();
        }
        slotTableReader.addFlag(i, i2);
    }

    public final void addFlag(int i, int i2) {
        int propagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(i2);
        int[] groups = this.addressSpace.getGroups();
        int[] groups2 = this.table.getAddressSpace().getGroups();
        int i3 = i;
        while (i3 > 0) {
            int i4 = i3 + 4;
            int i5 = groups[i4];
            int i6 = i3 == i ? i2 : propagatingFlagsOf;
            if ((i6 & i5) == i6) {
                return;
            }
            groups[i4] = i5 | i6;
            i3 = groups2[i3 + 2];
        }
        if (i3 != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
    }

    public final void removeFlag(int i) {
        removeFlag(this.parent, i);
    }

    public final void removeFlag(int i, int i2) {
        int[] groups = this.addressSpace.getGroups();
        int i3 = i + 4;
        int i4 = groups[i3];
        if ((i2 & i4) == i2) {
            int i5 = i4 & (~i2);
            groups[i3] = i5;
            int propagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(i2);
            if ((i5 & propagatingFlagsOf) != 0) {
                return;
            }
            int i6 = i2 | propagatingFlagsOf;
            int[] groups2 = this.addressSpace.getGroups();
            int i7 = groups2[i + 2];
            while (i7 > 0) {
                int i8 = i7 + 4;
                int i9 = groups[i8];
                if ((i9 & propagatingFlagsOf) == 0) {
                    return;
                }
                int[] groups3 = this.addressSpace.getGroups();
                for (int i10 = groups3[i7 + 3]; i10 > 0; i10 = groups3[i10 + 1]) {
                    if ((groups[i10 + 4] & i6) != 0) {
                        return;
                    }
                }
                groups[i8] = i9 & (~propagatingFlagsOf);
                i7 = groups2[i7 + 2];
            }
            if (i7 != 0) {
                return;
            }
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
        }
    }

    public static /* synthetic */ void traverseGroupPartially$default(SlotTableReader slotTableReader, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
        SlotTableAddressSpace slotTableAddressSpace = slotTableReader.addressSpace;
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = slotTableAddressSpace.getGroups();
        int i4 = i;
        while (true) {
            boolean booleanValue = ((Boolean) function1.invoke(Integer.valueOf(i4))).booleanValue();
            if ((i4 != i || z) && (i3 = groups[i4 + 1]) >= 0) {
                intStack.push(i3);
            }
            i4 = groups[i4 + 3];
            if (!booleanValue || i4 < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                i4 = intStack.pop();
            }
        }
    }

    public final void traverseGroupPartially(int i, boolean z, Function1<? super Integer, Boolean> function1) {
        int i2;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = slotTableAddressSpace.getGroups();
        int i3 = i;
        while (true) {
            boolean booleanValue = function1.invoke(Integer.valueOf(i3)).booleanValue();
            if ((i3 != i || z) && (i2 = groups[i3 + 1]) >= 0) {
                intStack.push(i2);
            }
            i3 = groups[i3 + 3];
            if (!booleanValue || i3 < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                i3 = intStack.pop();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r2 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        r11.invoke(java.lang.Integer.valueOf(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void traverseChildrenConditionally(int i, Function1<? super Integer, Boolean> function1, Function1<? super Integer, Boolean> function12, Function1<? super Integer, Unit> function13, Function1<? super Integer, Unit> function14) {
        int firstChildOf = firstChildOf(i);
        while (firstChildOf != -1) {
            boolean booleanValue = function12.invoke(Integer.valueOf(firstChildOf)).booleanValue();
            int firstChildOf2 = firstChildOf(firstChildOf);
            if (booleanValue || firstChildOf2 == -1 || !function1.invoke(Integer.valueOf(firstChildOf)).booleanValue()) {
                int i2 = firstChildOf;
                firstChildOf = nextSiblingOf(firstChildOf);
                while (firstChildOf == -1) {
                    i2 = parentOf(i2);
                    if (i2 == -1 || i2 == i) {
                        return;
                    }
                    function13.invoke(Integer.valueOf(i2));
                    firstChildOf = nextSiblingOf(i2);
                }
                continue;
            } else {
                firstChildOf = firstChildOf2;
            }
        }
    }

    public final void traverseChildrenByHandle(int i, Function1<? super Long, Unit> function1) {
        long m10020constructorimpl = UInt.m10020constructorimpl(firstChildOf(i)) & 4294967295L;
        long j = -4294967296L;
        while (true) {
            long j2 = m10020constructorimpl | j;
            if (GroupHandleKt.getGroup(j2) == -1) {
                return;
            }
            function1.invoke(Long.valueOf(j2));
            j = GroupHandleKt.getGroup(j2) << 32;
            m10020constructorimpl = UInt.m10020constructorimpl(nextSiblingOf(GroupHandleKt.getGroup(j2))) & 4294967295L;
        }
    }

    private final Object[] upToDateSlots() {
        if (this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }
        return this.slots;
    }

    public final void reposition(int i) {
        reposition(UInt.m10020constructorimpl(i) & 4294967295L);
    }
}
