package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.LinkComposerKt;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SlotTableEditor.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001zB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001b\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\u0010%\u001a\u00060\tj\u0002`&J\u0014\u0010 \u001a\u0004\u0018\u00010\u00012\n\u0010%\u001a\u00060\tj\u0002`&J\u001e\u0010'\u001a\u00020(2\f\b\u0002\u0010%\u001a\u00060\tj\u0002`&2\b\u0010)\u001a\u0004\u0018\u00010\u0001J\u0012\u0010*\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010%\u001a\u00060\tj\u0002`&J\u0012\u0010+\u001a\u00020\t2\n\u0010,\u001a\u00060\tj\u0002`&J\u0012\u0010-\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\u0012\u0010.\u001a\u00020\t2\n\u0010%\u001a\u00060\tj\u0002`&J\n\u0010/\u001a\u000600j\u0002`1J\u0016\u0010\u0012\u001a\u00060\tj\u0002`&2\n\u00102\u001a\u00060\tj\u0002`&J\u0006\u00103\u001a\u00020(J\u0006\u00104\u001a\u00020(J\u0006\u00105\u001a\u00020(J\u0010\u00106\u001a\u00020(2\b\b\u0002\u00107\u001a\u00020\u0015J\u001a\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u00032\n\u0010/\u001a\u000600j\u0002`1J\u0014\u0010:\u001a\u00020(2\n\u0010%\u001a\u00060\tj\u0002`&H\u0002J\u000e\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\tJ\u0012\u0010;\u001a\u00020(2\n\u0010/\u001a\u000600j\u0002`1J(\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u00032\n\u0010?\u001a\u000600j\u0002`12\f\b\u0002\u0010@\u001a\u000600j\u0002`1J,\u0010=\u001a\u000600j\u0002`12\u0006\u0010A\u001a\u00020\u00002\n\u0010?\u001a\u000600j\u0002`12\f\b\u0002\u0010@\u001a\u000600j\u0002`1J\u0006\u0010B\u001a\u00020\tJ\u0006\u0010C\u001a\u00020(J\u000e\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020FJ\u0012\u0010D\u001a\u00020(2\n\u0010/\u001a\u000600j\u0002`1J\u0010\u0010G\u001a\u00020(2\b\u0010 \u001a\u0004\u0018\u00010\u0001J\u0010\u0010H\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u001e\u0010I\u001a\u0004\u0018\u00010\u00012\n\u0010J\u001a\u00060\tj\u0002`K2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u001a\u0010L\u001a\u0004\u0018\u00010\u00012\u0006\u0010M\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u0010\u0010N\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u000e\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\tJ\u0012\u0010Q\u001a\u00020\u00152\n\u0010R\u001a\u000600j\u0002`1J\"\u0010S\u001a\u00020\u00032\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020(0U¢\u0006\u0002\bWH\u0086\bJ\u0015\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020\tH\u0000¢\u0006\u0002\bZJ\u001a\u0010[\u001a\u00020(2\n\u0010\\\u001a\u00060\tj\u0002`&2\u0006\u0010]\u001a\u00020^J5\u0010_\u001a\u00020(2\n\u0010\\\u001a\u00060\tj\u0002`&2\n\u0010`\u001a\u00060\tj\u0002`&2\u0006\u0010a\u001a\u00020\t2\u0006\u0010]\u001a\u00020^H\u0000¢\u0006\u0002\bbJ\u0012\u0010c\u001a\u00020(2\n\u0010d\u001a\u00060\tj\u0002`eJ\u001a\u0010f\u001a\u00020(2\u0006\u0010g\u001a\u00020h2\n\u0010d\u001a\u00060\tj\u0002`eJ\u0006\u0010i\u001a\u00020(J4\u0010j\u001a\u00020(2\n\u0010%\u001a\u00060\tj\u0002`&2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u0015H\u0002Jd\u0010o\u001a\u00020(*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010p2\u0006\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t28\u0010T\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(M\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020(0sH\u0082\b¢\u0006\u0002\u0010vJ`\u0010o\u001a\u00020(*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010p2\n\u0010w\u001a\u00060\tj\u0002`x28\u0010T\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(M\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020(0sH\u0082\b¢\u0006\u0002\u0010yR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016R\u001e\u0010#\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011¨\u0006{"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "parent", "", "current", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "getAddressSpace$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "currentGroup", "getCurrentGroup", "()I", "parentGroup", "getParentGroup", "isNode", "", "()Z", "isGroupEnd", "value", "isClosed", "isEmpty", "groupKey", "getGroupKey", "objectKey", "getObjectKey", "()Ljava/lang/Object;", "node", "getNode", "isParentGroupANode", "previousSibling", "getPreviousSibling", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "updateNode", "", "newValue", "flagsOf", "nodeCountOf", "groups", "parentOf", "firstChildOf", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "groupAddress", "close", "startGroup", "endGroup", "removeGroup", "freeGroup", "insertGroupFrom", "insertTable", "insertGroup", "moveGroup", TypedValues.CycleType.S_WAVE_OFFSET, "moveFrom", "sourceTable", "sourceHandle", FirebaseAnalytics.Param.DESTINATION, "sourceEditor", "skipGroup", "skipToGroupEnd", "seek", "anchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "updateParentNode", "updateAux", "setAbsolute", "slotAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "setRelative", FirebaseAnalytics.Param.INDEX, "appendSlot", "trimSlots", "slots", "containsHandle", "groupHandle", "buildInsertTable", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "Lkotlin/ExtensionFunctionType;", "bashGroup", "newKey", "bashGroup$runtime", "visitSlotsInRememberOrder", "inGroup", "callback", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor$VisitSlotsInRememberOrderCallback;", "visitTailSlotsInRememberOrder", "firstTailGroupToVisit", "tailSlots", "visitTailSlotsInRememberOrder$runtime", "removeAllInstancesOfFlags", DownloaderServiceMarshaller.PARAMS_FLAGS, "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "addFlagsToAllGroupsIn", "groupSet", "Landroidx/collection/IntSet;", "reset", "propagateChanges", "nodeCountDelta", "flagsToRemove", "flagsToAdd", "removingGroup", "forEachSlotInRangeIndexed", "", TtmlNode.START, TtmlNode.END, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "([Ljava/lang/Object;IILkotlin/jvm/functions/Function2;)V", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "([Ljava/lang/Object;ILkotlin/jvm/functions/Function2;)V", "VisitSlotsInRememberOrderCallback", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTableEditor {
    public static final int $stable = 8;
    private final SlotTableAddressSpace addressSpace;
    private int current;
    private boolean isClosed;
    private int parent = -1;
    private int previousSibling = -1;
    private final SlotTable table;

    /* compiled from: SlotTableEditor.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor$VisitSlotsInRememberOrderCallback;", "", "visit", "", "group", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "slotIndex", "slot", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface VisitSlotsInRememberOrderCallback {
        boolean visit(int i, int i2, Object obj);
    }

    public SlotTableEditor(SlotTable slotTable) {
        this.table = slotTable;
        this.current = slotTable.getRoot();
        this.addressSpace = slotTable.getAddressSpace();
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final SlotTableAddressSpace getAddressSpace$runtime() {
        return this.addressSpace;
    }

    public final int getCurrentGroup() {
        return this.current;
    }

    public final int getParentGroup() {
        return this.parent;
    }

    public final boolean isNode() {
        return (this.addressSpace.getGroups()[this.current + 4] & 8388608) == 8388608;
    }

    public final boolean isGroupEnd() {
        return this.current == -1;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.table.isEmpty();
    }

    public final int getGroupKey() {
        return this.addressSpace.getGroups()[this.current];
    }

    public final Object getObjectKey() {
        return objectKey(this.current);
    }

    public final Object getNode() {
        return node(this.current);
    }

    public final boolean isParentGroupANode() {
        return (this.addressSpace.getGroups()[this.parent + 4] & 8388608) == 8388608;
    }

    public final int getPreviousSibling() {
        return this.previousSibling;
    }

    public final int groupKey(int i) {
        return this.addressSpace.getGroups()[i];
    }

    public final Object objectKey(int i) {
        int[] groups = this.addressSpace.getGroups();
        int i2 = groups[i + 4];
        if ((i2 & 16777216) == 16777216) {
            return this.addressSpace.getSlots()[(groups[i + 5] >> 4) + Integer.bitCount(8388608 & i2)];
        }
        return Composer.Companion.getEmpty();
    }

    public final Object node(int i) {
        int[] groups = this.addressSpace.getGroups();
        if ((groups[i + 4] & 8388608) == 8388608) {
            return this.addressSpace.getSlots()[groups[i + 5] >> 4];
        }
        return null;
    }

    public static /* synthetic */ void updateNode$default(SlotTableEditor slotTableEditor, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = slotTableEditor.getCurrentGroup();
        }
        slotTableEditor.updateNode(i, obj);
    }

    public final void updateNode(int i, Object obj) {
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int[] groups = slotTableAddressSpace.getGroups();
        Object[] slots = slotTableAddressSpace.getSlots();
        int i2 = groups[i + 4];
        slots[groups[i + 5] >> 4] = obj;
    }

    public final int flagsOf(int i) {
        return this.addressSpace.getGroups()[i + 4];
    }

    public final boolean isNode(int i) {
        return (flagsOf(i) & 8388608) == 8388608;
    }

    public final int nodeCountOf(int i) {
        int i2 = this.addressSpace.getGroups()[i + 4];
        if ((i2 & 8388608) == 8388608) {
            return 1;
        }
        return i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final int parentOf(int i) {
        return this.addressSpace.getGroups()[i + 2];
    }

    public final int firstChildOf(int i) {
        return this.addressSpace.getGroups()[i + 3];
    }

    public final long handle() {
        return (this.previousSibling << 32) | (UInt.m9999constructorimpl(this.current) & 4294967295L);
    }

    public final int parentGroup(int i) {
        return this.addressSpace.getGroups()[i + 2];
    }

    public final void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.table.closeEditor(this);
    }

    public final void startGroup() {
        int i = this.current;
        if (!(i > 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a group because current does not refer to a child of a group");
        }
        this.parent = i;
        int[] groups = this.addressSpace.getGroups();
        if (i + 6 > groups.length) {
            return;
        }
        this.current = groups[i + 3];
        this.previousSibling = -1;
    }

    public final void endGroup() {
        int i = this.parent;
        int[] groups = this.addressSpace.getGroups();
        if (i + 6 > groups.length) {
            return;
        }
        int i2 = groups[i + 1];
        this.parent = groups[i + 2];
        this.previousSibling = i;
        this.current = i2;
    }

    public static /* synthetic */ void removeGroup$default(SlotTableEditor slotTableEditor, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        slotTableEditor.removeGroup(z);
    }

    public final void removeGroup(boolean z) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.current;
        int i2 = groups[i + 4];
        propagateChanges(i, -((i2 & 8388608) == 8388608 ? 1 : 8388607 & i2), GroupFlagsKt.propagatingFlagsOf(i2), 0, true);
        int i3 = groups[i + 1];
        int i4 = this.previousSibling;
        if (i4 == -1) {
            int i5 = this.parent;
            if (i5 == -1) {
                this.table.setRoot(i3);
            } else {
                groups[i5 + 3] = i3;
            }
        } else {
            groups[i4 + 1] = i3;
        }
        if (z) {
            this.addressSpace.freeGroupTree(i);
        }
        this.current = i3;
    }

    public final void insertGroupFrom(SlotTable slotTable, long j) {
        if (!Intrinsics.areEqual(slotTable.getAddressSpace(), this.table.getAddressSpace())) {
            throw new IllegalArgumentException("Cannot insert a group from an unrelated table".toString());
        }
        SlotTableEditor openEditor = slotTable.openEditor();
        try {
            openEditor.seek(j);
            openEditor.removeGroup(false);
            Unit unit = Unit.INSTANCE;
            openEditor.close();
            insertGroup(GroupHandleKt.getGroup(j));
        } catch (Throwable th) {
            openEditor.close();
            throw th;
        }
    }

    private final void insertGroup(int i) {
        int i2 = this.previousSibling;
        int i3 = this.parent;
        int[] groups = this.addressSpace.getGroups();
        if (i2 != -1) {
            groups[i2 + 1] = i;
        } else if (i3 == -1) {
            this.table.setRoot(i);
        } else {
            groups[i3 + 3] = i;
        }
        groups[i + 2] = i3;
        groups[i + 1] = this.current;
        int i4 = groups[i + 4];
        int i5 = (i4 & 8388608) != 8388608 ? i4 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK : 1;
        this.current = i;
        propagateChanges(i, i5, 0, GroupFlagsKt.propagatingFlagsOf(i4), false);
    }

    public final void moveGroup(int i) {
        if (i == 0) {
            return;
        }
        int i2 = this.current;
        int i3 = this.previousSibling;
        int[] groups = this.addressSpace.getGroups();
        int i4 = 0;
        int i5 = i2;
        int i6 = i3;
        while (i4 < i) {
            int i7 = groups[i5 + 1];
            if (i7 == -1) {
                throw new IllegalStateException(("Offset(" + i + ") too large").toString());
            }
            i4++;
            i6 = i5;
            i5 = i7;
        }
        int i8 = i5 + 1;
        groups[i6 + 1] = groups[i8];
        groups[i8] = i2;
        if (i3 == -1) {
            groups[this.parent + 3] = i5;
        } else {
            groups[i3 + 1] = i5;
        }
        this.current = i5;
    }

    public final void moveGroup(long j) {
        int i = this.current;
        int i2 = this.previousSibling;
        int group = GroupHandleKt.getGroup(j);
        int context = GroupHandleKt.getContext(j);
        int[] groups = this.addressSpace.getGroups();
        int i3 = this.parent;
        if ((context == -1 && groups[i3 + 3] != group) || (context != -1 && groups[context + 1] != group)) {
            context = i;
            while (context != -1) {
                int i4 = groups[context + 1];
                if (i4 == group) {
                    break;
                }
                context = i4;
            }
            if (context == -1) {
                throw new IllegalStateException(("Could not find the group previous to current(" + i + ')').toString());
            }
        }
        int i5 = group + 1;
        groups[context + 1] = groups[i5];
        groups[i5] = i;
        if (i2 == -1) {
            groups[i3 + 3] = group;
        } else {
            groups[i2 + 1] = group;
        }
        this.current = group;
    }

    public static /* synthetic */ void moveFrom$default(SlotTableEditor slotTableEditor, SlotTable slotTable, long j, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = -1;
        }
        slotTableEditor.moveFrom(slotTable, j, j2);
    }

    public static /* synthetic */ long moveFrom$default(SlotTableEditor slotTableEditor, SlotTableEditor slotTableEditor2, long j, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = -1;
        }
        return slotTableEditor.moveFrom(slotTableEditor2, j, j2);
    }

    public final long moveFrom(SlotTableEditor slotTableEditor, long j, long j2) {
        int group;
        long j3;
        slotTableEditor.seek(j);
        if (!Intrinsics.areEqual(slotTableEditor.addressSpace, this.addressSpace)) {
            group = this.addressSpace.copyTreeFrom(slotTableEditor.addressSpace, GroupHandleKt.getGroup(j));
            slotTableEditor.removeGroup(true);
        } else {
            group = GroupHandleKt.getGroup(j);
            slotTableEditor.removeGroup(false);
        }
        if (j2 != -1) {
            j3 = handle();
            seek(j2);
        } else {
            j3 = -1;
        }
        int i = this.previousSibling;
        insertGroup(group);
        this.previousSibling = i;
        this.current = group;
        long m9999constructorimpl = (i << 32) | (UInt.m9999constructorimpl(group) & 4294967295L);
        if (j3 != -1) {
            seek(j3);
        }
        if (this.table.getRecordSourceInformation()) {
            this.addressSpace.recordMovedSourceInformation(group, i);
        }
        return m9999constructorimpl;
    }

    public final int skipGroup() {
        int i = this.current;
        if (i == -1) {
            throw new IllegalStateException("Skipping past the end of a group".toString());
        }
        this.previousSibling = i;
        this.current = this.addressSpace.getGroups()[i + 1];
        int i2 = this.addressSpace.getGroups()[i + 4];
        if ((i2 & 8388608) == 8388608) {
            return 1;
        }
        return i2 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
    }

    public final void skipToGroupEnd() {
        int i = this.current;
        if (i != -1) {
            int i2 = this.previousSibling;
            int[] groups = this.addressSpace.getGroups();
            while (i != -1) {
                i2 = i;
                i = groups[i + 1];
            }
            this.previousSibling = i2;
            this.current = -1;
        }
    }

    public final void seek(LinkAnchor linkAnchor) {
        seek(UInt.m9999constructorimpl(linkAnchor.getAddress()) & 4294967295L);
    }

    public final void seek(long j) {
        int i;
        containsHandle(j);
        int context = GroupHandleKt.getContext(j);
        int[] groups = this.addressSpace.getGroups();
        int group = GroupHandleKt.getGroup(j);
        int i2 = group == -1 ? context : groups[group + 2];
        if (group == -1) {
            context = -1;
        }
        this.parent = i2;
        this.current = group;
        if (context != -1 ? groups[context + 1] != group : !(i2 != -1 ? groups[i2 + 3] == group : this.table.getRoot() == group)) {
            if (i2 == -1) {
                i = this.table.getRoot();
            } else {
                i = groups[i2 + 3];
            }
            int[] groups2 = this.addressSpace.getGroups();
            int i3 = -1;
            while (i >= 0 && i != group) {
                i3 = i;
                i = groups2[i + 1];
            }
            context = i3;
        }
        if (context != -1) {
            int i4 = groups[context + 1];
        } else if (i2 == -1) {
            this.table.getRoot();
        } else {
            int i5 = groups[i2 + 3];
        }
        this.previousSibling = context;
    }

    public final void updateParentNode(Object obj) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.parent;
        int i2 = groups[i + 4];
        this.addressSpace.getSlots()[groups[i + 5] >> 4] = obj;
    }

    public final void updateAux(Object obj) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.current;
        int i2 = groups[i + 4];
        this.addressSpace.getSlots()[(groups[i + 5] >> 4) + Integer.bitCount(25165824 & i2)] = obj;
    }

    public final Object setAbsolute(int i, Object obj) {
        Object[] slots = this.addressSpace.getSlots();
        if (i >= 0) {
            int length = slots.length;
        }
        Object obj2 = slots[i];
        slots[i] = obj;
        return obj2;
    }

    public final Object setRelative(int i, Object obj) {
        return setAbsolute((this.addressSpace.getGroups()[this.parent + 5] >> 4) + i, obj);
    }

    public final void appendSlot(Object obj) {
        int[] groups = this.addressSpace.getGroups();
        int i = this.parent;
        int i2 = groups[i + 5];
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (i2 == -1) {
            slotTableAddressSpace.writeSlot(i, 0, obj);
            return;
        }
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            i3 = slotTableAddressSpace.getLargeSizes().get(i4);
        }
        this.addressSpace.writeSlot(i, i3, obj);
    }

    public final void trimSlots(int i) {
        int i2;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int i3 = this.parent;
        int[] groups = slotTableAddressSpace.getGroups();
        int i4 = groups[i3 + 5];
        if (i4 == -1) {
            i2 = 0;
        } else {
            i2 = (i4 & 15) + 1;
            if (i2 > 15) {
                i2 = slotTableAddressSpace.getLargeSizes().get(i4 >> 4);
            }
        }
        int i5 = i2 - i;
        if (!(i5 >= GroupFlagsKt.utilitySlotsCountForFlags(groups[i3 + 4]))) {
            ComposerKt.composeImmediateRuntimeError("Attempted to trim more slots than the group has");
        }
        slotTableAddressSpace.resizeSlotRangeAtGroup(i3, i5);
    }

    public final boolean containsHandle(long j) {
        int group = GroupHandleKt.getGroup(j);
        if (group == -1) {
            group = GroupHandleKt.getContext(j);
        }
        if (group == -1) {
            return false;
        }
        int root = this.table.getRoot();
        int[] groups = this.addressSpace.getGroups();
        int[] groups2 = this.addressSpace.getGroups();
        int i = group;
        while (true) {
            if (i <= 0) {
                if (!(i != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
                }
                return false;
            } else if (i == root) {
                return true;
            } else {
                if (i <= 0) {
                    return false;
                }
                int i2 = i + 2;
                if (groups[i2] == -1) {
                    int[] groups3 = this.addressSpace.getGroups();
                    for (int i3 = root; i3 >= 0; i3 = groups3[i3 + 1]) {
                        if (i3 == i) {
                            return true;
                        }
                    }
                    continue;
                }
                i = groups2[i2];
            }
        }
    }

    public final SlotTable buildInsertTable(Function1<? super SlotTableBuilder, Unit> function1) {
        SlotTable.Companion companion = SlotTable.Companion;
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(getAddressSpace$runtime(), false, false);
        slotTableBuilder.buildStart();
        function1.invoke(slotTableBuilder);
        return slotTableBuilder.build();
    }

    public final void bashGroup$runtime(int i) {
        this.addressSpace.getGroups()[getCurrentGroup()] = i;
    }

    public final void visitSlotsInRememberOrder(int i, VisitSlotsInRememberOrderCallback visitSlotsInRememberOrderCallback) {
        int i2;
        if (i < 0) {
            return;
        }
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        int i3 = groups[i + 5];
        int i4 = -1;
        if (i3 != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i5 = (i3 & 15) + 1;
            int i6 = i3 >> 4;
            if (i5 > 15) {
                i5 = slotTableAddressSpace.getLargeSizes().get(i6);
            }
            int i7 = i5 + i6;
            for (int i8 = i6; i8 < i7; i8++) {
                int i9 = i8 - i6;
                Object obj = slots[i8];
                if (obj instanceof RememberObserverHolder) {
                    int address = LinkComposerKt.asLinkRememberObserverHolder((RememberObserverHolder) obj).getAfter().getAddress();
                    while (i4 != address) {
                        if (i4 < 0) {
                            i4 = groups[i + 3];
                        } else {
                            i4 = groups[i4 + 1];
                        }
                        if (!(i4 >= 0)) {
                            ComposerKt.composeImmediateRuntimeError("A RememberObserver cannot be forgotten correctly because its group ordering metadata is inconsistent with the rest of the SlotTable");
                        }
                        visitSlotsInRememberOrder(i4, visitSlotsInRememberOrderCallback);
                    }
                }
                if (visitSlotsInRememberOrderCallback.visit(i, i9, obj)) {
                    slots[i9 + i6] = Composer.Companion.getEmpty();
                }
            }
        }
        if (i4 < 0) {
            i2 = groups[i + 3];
        } else {
            i2 = groups[i4 + 1];
        }
        while (i2 >= 0) {
            visitSlotsInRememberOrder(i2, visitSlotsInRememberOrderCallback);
            i2 = groups[i2 + 1];
        }
    }

    public final void visitTailSlotsInRememberOrder$runtime(int i, int i2, int i3, VisitSlotsInRememberOrderCallback visitSlotsInRememberOrderCallback) {
        int i4;
        int i5;
        if (i < 0) {
            return;
        }
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        int i6 = groups[i + 5];
        int i7 = i6 >> 4;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int i8 = -1;
        if (i6 == -1) {
            i4 = 0;
        } else {
            i4 = (i6 & 15) + 1;
            if (i4 > 15) {
                i4 = slotTableAddressSpace.getLargeSizes().get(i7);
            }
        }
        int i9 = (i4 + i7) - i3;
        int i10 = i9 + i3;
        boolean z = false;
        for (int i11 = i9; i11 < i10; i11++) {
            int i12 = i11 - i9;
            Object obj = slots[i11];
            if (obj instanceof RememberObserverHolder) {
                int address = LinkComposerKt.asLinkRememberObserverHolder((RememberObserverHolder) obj).getAfter().getAddress();
                while (i8 != address) {
                    if (i8 < 0) {
                        i8 = groups[i + 3];
                    } else {
                        i8 = groups[i8 + 1];
                    }
                    if (!(i8 >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("A RememberObserver cannot be forgotten correctly because its group ordering metadata is inconsistent with the rest of the SlotTable");
                    }
                    z |= i2 == i8;
                    if (z) {
                        visitSlotsInRememberOrder(i8, visitSlotsInRememberOrderCallback);
                    }
                }
            }
            if (visitSlotsInRememberOrderCallback.visit(i, i12, obj)) {
                slots[i12 + i7] = Composer.Companion.getEmpty();
            }
        }
        if (i8 < 0) {
            i5 = groups[i + 3];
        } else {
            i5 = groups[i8 + 1];
        }
        while (i5 >= 0) {
            z |= i2 == i5;
            if (z) {
                visitSlotsInRememberOrder(i5, visitSlotsInRememberOrderCallback);
            }
            i5 = groups[i5 + 1];
        }
    }

    public final void removeAllInstancesOfFlags(int i) {
        boolean z;
        int propagatingFlagsOf = i | GroupFlagsKt.propagatingFlagsOf(i);
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int[] groups = slotTableAddressSpace.getGroups();
        int root = this.table.getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups2 = slotTableAddressSpace.getGroups();
        while (true) {
            int i2 = root + 4;
            int i3 = groups[i2];
            if ((propagatingFlagsOf & i3) == 0) {
                z = false;
            } else {
                groups[i2] = i3 & (~propagatingFlagsOf);
                z = true;
            }
            int i4 = groups2[root + 1];
            if (i4 >= 0) {
                intStack.push(i4);
            }
            root = groups2[root + 3];
            if (!z || root < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                root = intStack.pop();
            }
        }
    }

    public final void reset() {
        this.parent = -1;
        this.previousSibling = -1;
        this.current = this.table.getRoot();
    }

    private final void propagateChanges(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int[] groups = this.addressSpace.getGroups();
        int[] groups2 = this.addressSpace.getGroups();
        int i7 = groups2[i + 2];
        while (true) {
            if (i7 <= 0) {
                if (i7 != 0) {
                    return;
                }
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
                return;
            }
            int i8 = i7 + 4;
            int i9 = groups[i8];
            if (i2 != 0) {
                i9 = (i9 & (-8388608)) | ((8388607 & i9) + i2);
                groups[i8] = i9;
                if ((i9 & 8388608) == 8388608) {
                    i2 = 0;
                }
            }
            if (i3 != 0) {
                int i10 = (i3 >> 1) | i3;
                int[] groups3 = this.addressSpace.getGroups();
                for (int i11 = groups3[i7 + 3]; i11 > 0; i11 = groups3[i11 + 1]) {
                    if ((z && i11 == i) || (groups[i11 + 4] & i10) == 0) {
                    }
                }
                i5 = i3;
                if ((i5 == 0 || i4 != 0) && (i6 = ((~i5) & i9) | i4) != i9) {
                    groups[i8] = i6;
                    i3 = i5;
                } else {
                    i4 = 0;
                }
                if (i2 != 0 && i3 == 0 && i4 == 0) {
                    return;
                }
                i7 = groups2[i7 + 2];
            }
            i5 = 0;
            if (i5 == 0) {
            }
            groups[i8] = i6;
            i3 = i5;
            if (i2 != 0) {
            }
            i7 = groups2[i7 + 2];
        }
    }

    private final void forEachSlotInRangeIndexed(Object[] objArr, int i, int i2, Function2<? super Integer, Object, Unit> function2) {
        for (int i3 = i; i3 < i2; i3++) {
            function2.invoke(Integer.valueOf(i3 - i), objArr[i3]);
        }
    }

    private final void forEachSlotInRangeIndexed(Object[] objArr, int i, Function2<? super Integer, Object, Unit> function2) {
        if (i != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i2 = (i & 15) + 1;
            int i3 = i >> 4;
            if (i2 > 15) {
                i2 = slotTableAddressSpace.getLargeSizes().get(i3);
            }
            int i4 = i2 + i3;
            for (int i5 = i3; i5 < i4; i5++) {
                function2.invoke(Integer.valueOf(i5 - i3), objArr[i5]);
            }
        }
    }

    public final void moveFrom(SlotTable slotTable, long j, long j2) {
        SlotTableEditor openEditor = slotTable.openEditor();
        try {
            moveFrom(openEditor, j, j2);
        } finally {
            openEditor.close();
        }
    }

    public final void addFlagsToAllGroupsIn(IntSet intSet, int i) {
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        propagateChanges(iArr[(i2 << 3) + i4], 0, 0, i, false);
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            }
            i2++;
        }
    }
}
