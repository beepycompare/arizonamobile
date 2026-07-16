package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SlotTableBuilder.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u000bJ\u0012\u00107\u001a\u00020\u00152\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0014\u00109\u001a\u0004\u0018\u00010\u00012\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0014\u0010:\u001a\u0004\u0018\u00010\u00012\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0012\u0010;\u001a\u00020\u00152\n\u00108\u001a\u00060\u0015j\u0002`<J\u0006\u0010=\u001a\u00020\u0005J\n\u0010>\u001a\u000603j\u0002`4J\u0012\u0010\u0014\u001a\u00020\u00152\n\u00108\u001a\u00060\u0015j\u0002`\u0019J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\u0006\u0010B\u001a\u00020@J\u001d\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0001H\u0086\bJ%\u0010F\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0086\bJ%\u0010H\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0086\bJ:\u0010J\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\n\u0010K\u001a\u00060\u0015j\u0002`L2\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010I\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010M\u001a\u00020\u0015J\u0010\u0010N\u001a\u00020@2\b\u0010&\u001a\u0004\u0018\u00010\u0001J\u0010\u0010O\u001a\u00020@2\b\u0010&\u001a\u0004\u0018\u00010\u0001J\u0012\u0010P\u001a\u00020@2\n\u0010K\u001a\u00060\u0015j\u0002`LJ\u001a\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020S2\n\u0010T\u001a\u000603j\u0002`4J\u000e\u0010U\u001a\u00020@2\u0006\u0010V\u001a\u00020WJ\u0016\u0010X\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00152\u0006\u0010V\u001a\u00020WJ\u0006\u0010Y\u001a\u00020@J\u0006\u0010Z\u001a\u00020@J\u0006\u0010[\u001a\u00020\u0003J\b\u0010\\\u001a\u00020@H\u0002J\u0010\u0010]\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u0015H\u0002J\u0014\u0010_\u001a\u00020@2\n\u0010^\u001a\u00060\u0015j\u0002`\u0019H\u0002J\b\u0010`\u001a\u00020@H\u0002J\b\u0010a\u001a\u00020@H\u0002J\u0012\u0010b\u001a\u00020@2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0015j\u0002`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000fR\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0011\u0010)\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b1\u0010+R\u0015\u00102\u001a\u000603j\u0002`48F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006c"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "recordSourceInformation", "", "recordCallByInformation", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;ZZ)V", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;ZZ)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getRecordSourceInformation", "()Z", "setRecordSourceInformation", "(Z)V", "getRecordCallByInformation", "setRecordCallByInformation", "parent", "", "parentStack", "Landroidx/compose/runtime/IntStack;", "previousSibling", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "previousSiblingStack", "nodeCount", "slots", "", "[Ljava/lang/Object;", "slotStart", "slotCurrent", "slotEnd", "inReservedRange", "slotReserveStart", "slotReserveEnd", "slotReserveUsedUpTo", "value", "isClosed", "isEmpty", "parentGroup", "getParentGroup", "()I", "parentAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "getParentAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "slotIndex", "getSlotIndex", "parentHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "getParentHandle", "()J", "groupKey", "address", "groupObjectKey", "groupAux", "flagsOf", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "isNode", "lastRoot", "buildStart", "", "collectSourceInformation", "collectCallByInformation", "startGroup", "key", "objectKey", "startNodeGroup", "node", "startDataGroup", "aux", "startNewGroup", DownloaderServiceMarshaller.PARAMS_FLAGS, "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "endGroup", "append", "insertAux", "addFlags", "moveFrom", "sourceEditor", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "sourceHandle", "recordGroupSourceInformation", "sourceInformation", "", "recordGrouplessCallSourceInformationStart", "recordGrouplessCallSourceInformationEnd", "close", "build", "buildEnd", "saveSlotRange", "group", "restoreFromSlotRange", "reserveSlotSlotRegion", "returnReservedSlotRegion", "slowAppend", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTableBuilder {
    public static final int $stable = 8;
    private final SlotTableAddressSpace addressSpace;
    private boolean inReservedRange;
    private boolean isClosed;
    private int nodeCount;
    private int parent;
    private final IntStack parentStack;
    private int previousSibling;
    private final IntStack previousSiblingStack;
    private boolean recordCallByInformation;
    private boolean recordSourceInformation;
    private int slotCurrent;
    private int slotEnd;
    private int slotReserveEnd;
    private int slotReserveStart;
    private int slotReserveUsedUpTo;
    private int slotStart;
    private Object[] slots;
    private final SlotTable table;

    public SlotTableBuilder(SlotTable slotTable, boolean z, boolean z2) {
        int i;
        this.table = slotTable;
        this.recordSourceInformation = z;
        this.recordCallByInformation = z2;
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        this.addressSpace = addressSpace;
        int i2 = -1;
        this.parent = -1;
        this.parentStack = new IntStack();
        int root = slotTable.getRoot();
        if (root != -1) {
            int[] groups = addressSpace.getGroups();
            while (true) {
                i = i2;
                i2 = root;
                if (i2 < 0) {
                    break;
                }
                root = groups[i2 + 1];
            }
            i2 = i;
        }
        this.previousSibling = i2;
        this.previousSiblingStack = new IntStack();
        this.slots = this.addressSpace.getSlots();
    }

    public static final /* synthetic */ void access$startNewGroup(SlotTableBuilder slotTableBuilder, int i, int i2, Object obj, Object obj2, Object obj3) {
        slotTableBuilder.startNewGroup(i, i2, obj, obj2, obj3);
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final boolean getRecordSourceInformation() {
        return this.recordSourceInformation;
    }

    public final void setRecordSourceInformation(boolean z) {
        this.recordSourceInformation = z;
    }

    public final boolean getRecordCallByInformation() {
        return this.recordCallByInformation;
    }

    public final void setRecordCallByInformation(boolean z) {
        this.recordCallByInformation = z;
    }

    public SlotTableBuilder(SlotTableAddressSpace slotTableAddressSpace, boolean z, boolean z2) {
        this(new SlotTable(0, slotTableAddressSpace, z, z2, 1, null), z, z2);
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.parent == -1;
    }

    public final int getParentGroup() {
        return this.parent;
    }

    public final LinkAnchor getParentAnchor() {
        return this.addressSpace.anchorOfAddress(getParentGroup());
    }

    public final int getSlotIndex() {
        return this.slotCurrent - this.slotStart;
    }

    public final long getParentHandle() {
        return ((this.previousSiblingStack.tos == 0 ? -1 : this.previousSiblingStack.peek()) << 32) | (UInt.m9999constructorimpl(this.parent) & 4294967295L);
    }

    public final int groupKey(int i) {
        return this.addressSpace.getGroups()[i];
    }

    public final Object groupObjectKey(int i) {
        int[] groups = this.addressSpace.getGroups();
        int i2 = groups[i + 4];
        if ((i2 & 16777216) == 16777216) {
            return this.slots[(groups[i + 5] >> 4) + Integer.bitCount(8388608 & i2)];
        }
        return null;
    }

    public final Object groupAux(int i) {
        int[] groups = this.addressSpace.getGroups();
        int i2 = groups[i + 4];
        if ((i2 & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
            return this.slots[(groups[i + 5] >> 4) + Integer.bitCount(25165824 & i2)];
        }
        return Composer.Companion.getEmpty();
    }

    public final int flagsOf(int i) {
        return this.addressSpace.getGroups()[i + 4];
    }

    public final boolean isNode() {
        int i = this.parent;
        return i != -1 && (this.addressSpace.getGroups()[i + 4] & 8388608) == 8388608;
    }

    public final long lastRoot() {
        int root = this.table.getRoot();
        int i = -1;
        if (root != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int root2 = this.table.getRoot();
            int[] groups = slotTableAddressSpace.getGroups();
            int i2 = groups[root2 + 1];
            while (i2 >= 0) {
                int i3 = root;
                root = i2;
                i2 = groups[i2 + 1];
                i = i3;
            }
        }
        return (i << 32) | (UInt.m9999constructorimpl(root) & 4294967295L);
    }

    public final int parent(int i) {
        return this.addressSpace.getGroups()[i + 2];
    }

    public final void buildStart() {
        reserveSlotSlotRegion();
    }

    public final void collectSourceInformation() {
        this.recordSourceInformation = true;
        this.table.setRecordSourceInformation(true);
    }

    public final void collectCallByInformation() {
        this.recordCallByInformation = true;
        this.table.setRecordCallByInformation(true);
    }

    public static /* synthetic */ void startGroup$default(SlotTableBuilder slotTableBuilder, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = Composer.Companion.getEmpty();
        }
        Object obj3 = obj;
        slotTableBuilder.startNewGroup(i, obj3 == Composer.Companion.getEmpty() ? 0 : 16777216, obj3, null, null);
    }

    public final void startGroup(int i, Object obj) {
        startNewGroup(i, obj == Composer.Companion.getEmpty() ? 0 : 16777216, obj, null, null);
    }

    public final void startNodeGroup(int i, Object obj, Object obj2) {
        startNewGroup(i, obj == Composer.Companion.getEmpty() ? 8388608 : 25165824, obj, null, obj2);
    }

    public final void startDataGroup(int i, Object obj, Object obj2) {
        startNewGroup(i, obj == Composer.Companion.getEmpty() ? GroupFlagsKt.HasAuxSlotFlag : 50331648, obj, obj2, null);
    }

    public final void startNewGroup(int i, int i2, Object obj, Object obj2, Object obj3) {
        int groupAllocate;
        int i3 = this.parent;
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        groupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace.getGroups(), i, i3, i2);
        if (groupAllocate < 0) {
            slotTableAddressSpace.growGroups();
            groupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace.getGroups(), i, i3, i2);
        }
        int[] groups = this.addressSpace.getGroups();
        int i4 = this.previousSibling;
        if (i4 != -1) {
            groups[i4 + 1] = groupAllocate;
        } else if (i3 == -1) {
            this.table.setRoot(groupAllocate);
        } else {
            groups[i3 + 3] = groupAllocate;
        }
        this.parentStack.push(i3);
        this.previousSiblingStack.push(i4);
        this.parent = groupAllocate;
        this.previousSibling = -1;
        if (i3 != -1) {
            int i5 = i3 + 4;
            groups[i5] = this.nodeCount | (groups[i5] & (-8388608));
        }
        this.nodeCount = 0;
        saveSlotRange(i3);
        int i6 = this.slotReserveUsedUpTo;
        this.slotStart = i6;
        this.slotCurrent = i6;
        this.slotEnd = this.slotReserveEnd;
        this.inReservedRange = true;
        if ((i2 & 8388608) == 8388608) {
            append(obj3);
        }
        if ((i2 & 16777216) == 16777216) {
            append(obj);
        }
        if ((i2 & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
            append(obj2);
        }
        int i7 = this.slotCurrent;
        int i8 = this.slotStart;
        if (i7 > i8) {
            groups[groupAllocate + 5] = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i8, i7 - i8);
        }
        if (!this.recordSourceInformation || i3 < 0) {
            return;
        }
        this.addressSpace.recordSourceInformation(i3, null, groupAllocate).reportGroup(this.addressSpace.anchorOfAddress(groupAllocate));
    }

    public final int endGroup() {
        int i;
        int i2 = this.parent;
        int[] groups = this.addressSpace.getGroups();
        int i3 = i2 + 4;
        groups[i3] = this.nodeCount | (groups[i3] & (-8388608));
        saveSlotRange(i2);
        int pop = this.parentStack.pop();
        this.parent = pop;
        int pop2 = this.previousSiblingStack.pop();
        if (pop2 != -1) {
            i = groups[pop2 + 1];
        } else if (pop == -1) {
            i = this.table.getRoot();
        } else {
            i = groups[pop + 3];
        }
        this.previousSibling = i;
        restoreFromSlotRange(this.parent);
        int i4 = groups[i3];
        int i5 = (i4 & 8388608) != 8388608 ? i4 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK : 1;
        this.nodeCount = (groups[this.parent + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK) + i5;
        return i5;
    }

    public final void append(Object obj) {
        int i = this.slotCurrent;
        if (i < this.slotEnd) {
            Object[] objArr = this.slots;
            this.slotCurrent = i + 1;
            objArr[i] = obj;
            return;
        }
        slowAppend(obj);
    }

    public final void insertAux(Object obj) {
        int parentGroup = getParentGroup();
        int[] groups = this.addressSpace.getGroups();
        int i = parentGroup + 4;
        int i2 = groups[i] | GroupFlagsKt.HasAuxSlotFlag;
        groups[i] = i2;
        append(obj);
        int bitCount = this.slotStart + Integer.bitCount(25165824 & i2);
        int i3 = bitCount + 1;
        if (i3 != this.slotCurrent) {
            Object[] slots = this.addressSpace.getSlots();
            ArraysKt.copyInto(slots, slots, i3, bitCount, this.slotCurrent - 1);
            slots[bitCount] = obj;
        }
    }

    public final void addFlags(int i) {
        int[] groups = this.addressSpace.getGroups();
        int i2 = this.parent;
        int i3 = i | groups[i2 + 4];
        groups[i2 + 4] = i3;
        int propagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(i3);
        if (propagatingFlagsOf != 0) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i4 = this.parent;
            int[] groups2 = slotTableAddressSpace.getGroups();
            int i5 = groups2[i4 + 2];
            while (i5 > 0) {
                int i6 = i5 + 4;
                int i7 = groups[i6];
                if ((propagatingFlagsOf & i7) == propagatingFlagsOf) {
                    return;
                }
                groups[i6] = i7 | propagatingFlagsOf;
                i5 = groups2[i5 + 2];
            }
            if (i5 != 0) {
                return;
            }
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i4);
        }
    }

    public final void moveFrom(SlotTableEditor slotTableEditor, long j) {
        Intrinsics.areEqual(slotTableEditor.getAddressSpace$runtime(), this.addressSpace);
        long handle = slotTableEditor.handle();
        slotTableEditor.seek(j);
        slotTableEditor.removeGroup(false);
        slotTableEditor.seek(handle);
        int group = GroupHandleKt.getGroup(j);
        int[] groups = this.addressSpace.getGroups();
        int i = this.parent;
        int i2 = this.previousSibling;
        if (i2 != -1) {
            groups[i2 + 1] = group;
        } else if (i == -1) {
            this.table.setRoot(group);
        } else {
            groups[i + 3] = group;
        }
        groups[group + 2] = i;
        groups[group + 1] = -1;
        this.previousSibling = group;
        int i3 = this.nodeCount;
        int i4 = groups[group + 4];
        this.nodeCount = i3 + ((i4 & 8388608) == 8388608 ? 1 : 8388607 & i4);
        int propagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(i4);
        if (propagatingFlagsOf != 0) {
            int[] groups2 = this.addressSpace.getGroups();
            int i5 = i;
            while (i5 > 0) {
                int i6 = i5 + 4;
                int i7 = groups[i6];
                if ((i7 & propagatingFlagsOf) == propagatingFlagsOf) {
                    return;
                }
                groups[i6] = i7 | propagatingFlagsOf;
                i5 = groups2[i5 + 2];
            }
            if (i5 != 0) {
                return;
            }
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
        }
    }

    public final void recordGroupSourceInformation(String str) {
        if (this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, str, -1);
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int i, String str) {
        if (this.recordCallByInformation) {
            this.addressSpace.recordCalledBy(i, groupKey(this.parent));
        }
        if (this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, null, -1).startGrouplessCall(i, str, this.slotCurrent - this.slotStart);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        if (this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, null, -1).endGrouplessCall(this.slotCurrent - this.slotStart);
        }
    }

    public final void close() {
        this.isClosed = true;
    }

    public final SlotTable build() {
        buildEnd();
        close();
        return this.table;
    }

    private final void buildEnd() {
        int i = this.parent;
        if (i != -1) {
            saveSlotRange(i);
        }
        returnReservedSlotRegion();
    }

    private final int saveSlotRange(int i) {
        if (i < 0) {
            return 0;
        }
        int[] groups = this.addressSpace.getGroups();
        int i2 = this.slotCurrent;
        int i3 = this.slotStart;
        if (i2 > i3) {
            if (this.inReservedRange) {
                int i4 = i2 - i3;
                int slotRangeFromAddressAndSize = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i3, i4);
                if (i4 > 15) {
                    this.addressSpace.recordLargeBlock(i3, i4);
                }
                this.slotReserveUsedUpTo = i2;
                groups[i + 5] = slotRangeFromAddressAndSize;
                return i4;
            }
            int i5 = i2 - i3;
            int i6 = this.slotEnd - i3;
            if (i6 != i5) {
                this.addressSpace.resizeSlotRangeAtGroup(i, i6, i5);
            }
            return i5;
        }
        groups[i + 5] = -1;
        return 0;
    }

    private final void restoreFromSlotRange(int i) {
        int i2 = this.addressSpace.getGroups()[i + 5];
        if (i2 != -1) {
            SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
            int i3 = (i2 & 15) + 1;
            int i4 = i2 >> 4;
            if (i3 > 15) {
                i3 = slotTableAddressSpace.getLargeSizes().get(i4);
            }
            this.slotStart = i4;
            int i5 = i4 + i3;
            this.slotEnd = i5;
            this.slotCurrent = i5;
            this.inReservedRange = false;
            return;
        }
        int i6 = this.slotReserveUsedUpTo;
        this.slotStart = i6;
        this.slotCurrent = i6;
        this.slotEnd = this.slotReserveEnd;
        this.inReservedRange = true;
    }

    private final void reserveSlotSlotRegion() {
        long reserveSlots = this.addressSpace.reserveSlots();
        int i = (int) reserveSlots;
        this.slotReserveStart = i;
        this.slotReserveUsedUpTo = i;
        this.slotReserveEnd = (int) (reserveSlots >>> 32);
    }

    private final void returnReservedSlotRegion() {
        int i = this.slotReserveStart;
        int i2 = this.slotReserveEnd;
        if (i != i2) {
            this.addressSpace.restoreSlots(this.slotReserveUsedUpTo, i2);
            this.slotReserveStart = 0;
            this.slotReserveUsedUpTo = 0;
            this.slotReserveEnd = 0;
        }
    }

    private final void slowAppend(Object obj) {
        int i = this.parent;
        int saveSlotRange = saveSlotRange(i);
        returnReservedSlotRegion();
        this.addressSpace.writeSlot(i, saveSlotRange, obj);
        this.slots = this.addressSpace.getSlots();
        reserveSlotSlotRegion();
        restoreFromSlotRange(i);
    }
}
