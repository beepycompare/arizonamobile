package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntIntMapKt;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.internal.ViewUtils;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: SlotTableAddresSpace.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \u008c\u00012\u00020\u0001:\u0002\u008c\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\fJ\u0006\u0010/\u001a\u000200J-\u00101\u001a\u00060\tj\u0002`22\u0006\u00103\u001a\u00020\t2\n\u00104\u001a\u00060\tj\u0002`22\n\u00105\u001a\u00060\tj\u0002`6H\u0086\bJ\u0012\u00107\u001a\u0002002\n\u00108\u001a\u00060\tj\u0002`2J\u0014\u00109\u001a\u0002002\n\u00108\u001a\u00060\tj\u0002`2H\u0002J\u0014\u0010:\u001a\u0002002\n\u00108\u001a\u00060\tj\u0002`2H\u0002J\u0006\u0010;\u001a\u00020<J\u0016\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tJ\u0016\u0010@\u001a\u0002002\u0006\u00108\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tJ\u001c\u0010B\u001a\u0004\u0018\u00010\u00012\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010D\u001a\u00020\tJ(\u0010E\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010D\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010\u0001J\u0014\u0010H\u001a\u0004\u0018\u00010 2\n\u0010C\u001a\u00060\tj\u0002`2J(\u0010I\u001a\u00020 2\n\u00104\u001a\u00060\tj\u0002`22\b\u0010J\u001a\u0004\u0018\u00010K2\n\u0010C\u001a\u00060\tj\u0002`2J\u0016\u0010L\u001a\u0002002\u0006\u00103\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tJ\u0010\u0010N\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0002J&\u0010O\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010A\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tJ\u001e\u0010O\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010P\u001a\u00020\tJ\u001e\u0010Q\u001a\u00060\tj\u0002`22\u0006\u0010R\u001a\u00020\u00002\n\u0010S\u001a\u00060\tj\u0002`2J\u001e\u0010T\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22\n\u0010U\u001a\u00060\tj\u0002`2J\u0012\u0010V\u001a\u00020\u001d2\n\u00108\u001a\u00060\tj\u0002`2J\u000e\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u001dJ(\u0010Z\u001a\u0004\u0018\u00010\u001d2\u0006\u0010R\u001a\u00020\u00002\n\u0010[\u001a\u00060\tj\u0002`22\n\u0010\\\u001a\u00060\tj\u0002`2J\u0018\u0010]\u001a\u0002002\u0006\u0010R\u001a\u00020\u00002\b\u0010Y\u001a\u0004\u0018\u00010\u001dJ%\u0010^\u001a\u00020\t2\n\u0010_\u001a\u00060\tj\u0002`22\n\u0010`\u001a\u00060\tj\u0002`2H\u0000¢\u0006\u0002\baJA\u0010b\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bgJA\u0010h\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\biJA\u0010j\u001a\u0002002\n\u00104\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bkJA\u0010l\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bmJK\u0010n\u001a\u0002002\n\u0010C\u001a\u00060\tj\u0002`22\b\b\u0002\u0010o\u001a\u00020X2%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bpJK\u0010q\u001a\u0002002\n\u0010>\u001a\u00060\tj\u0002`22\b\b\u0002\u0010r\u001a\u00020X2%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bsJK\u0010t\u001a\u0002002\n\u0010>\u001a\u00060\tj\u0002`22\b\b\u0002\u0010r\u001a\u00020X2%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020X0dH\u0080\b¢\u0006\u0002\buJA\u0010v\u001a\u0002002\n\u00104\u001a\u00060\tj\u0002`22%\u0010c\u001a!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bwJ\u0015\u0010x\u001a\u00020X2\n\u0010C\u001a\u00060\tj\u0002`2H\u0086\u0002J$\u0010y\u001a\u00020\t2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010z\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0002J(\u0010{\u001a\u00060\tj\u0002`F2\n\u0010|\u001a\u00060\tj\u0002`F2\u0006\u0010z\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0002J(\u0010}\u001a\u00060\tj\u0002`F2\n\u0010C\u001a\u00060\tj\u0002`22\u0006\u0010z\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0002J\u0015\u0010~\u001a\u00020\t2\n\u0010\u007f\u001a\u00060\tj\u0002`FH\u0086\bJ[\u0010\u0080\u0001\u001a\u0003H\u0081\u0001\"\u0005\b\u0000\u0010\u0081\u00012\u0006\u0010\u007f\u001a\u00020\t29\u0010\u0082\u0001\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\t¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(A\u0012\u0005\u0012\u0003H\u0081\u00010\u0083\u0001H\u0086\b¢\u0006\u0003\u0010\u0084\u0001J\u0015\u0010\u0085\u0001\u001a\u0002002\n\u0010\u007f\u001a\u00060\tj\u0002`FH\u0002J\u0019\u0010\u0086\u0001\u001a\u0002002\u0006\u00108\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0002J\t\u0010\u0087\u0001\u001a\u000200H\u0002J\u0007\u0010\u0088\u0001\u001a\u00020KJ\u0012\u0010\u0089\u0001\u001a\u0002002\u0007\u0010\u008a\u0001\u001a\u00020\tH\u0002J\r\u0010\u008b\u0001\u001a\u000200*\u00020\u0003H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006\u008d\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "", "groups", "", "slots", "", "<init>", "([I[Ljava/lang/Object;)V", "groupsCapacity", "", "slotsCapacity", "(II)V", "()V", "getGroups", "()[I", "setGroups", "([I)V", "getSlots", "()[Ljava/lang/Object;", "setSlots", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "_largeSizes", "Landroidx/collection/MutableIntIntMap;", "unallocatedStart", "unallocatedEnd", "freeSlotCount", "anchors", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "sourceInformationMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/composer/linkbuffer/LinkGroupSourceInformation;", "getSourceInformationMap$annotations", "getSourceInformationMap", "()Landroidx/collection/MutableScatterMap;", "setSourceInformationMap", "(Landroidx/collection/MutableScatterMap;)V", "largeSizes", "getLargeSizes", "()Landroidx/collection/MutableIntIntMap;", "calledByMap", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", "validate", "", "allocateGroup", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "key", "parent", DownloaderServiceMarshaller.PARAMS_FLAGS, "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "freeGroupTree", "address", "removeSourceInformation", "freeGroup", "reserveSlots", "", "restoreSlots", TtmlNode.START, TtmlNode.END, "recordLargeBlock", "size", "readSlot", "group", TypedValues.CycleType.S_WAVE_OFFSET, "writeSlot", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "value", "sourceInformationOf", "recordSourceInformation", "sourceInformation", "", "recordCalledBy", "parentKey", "allocateSlots", "resizeSlotRangeAtGroup", "newSize", "copyTreeFrom", "sourceSpace", "sourceAddress", "recordMovedSourceInformation", "previous", "anchorOfAddress", "ownsAnchor", "", "anchor", "moveAnchorFrom", "oldAddress", "newAddress", "moveSourceInformation", "distanceFrom", "groupAddress", "common", "distanceFrom$runtime", "traverseSiblings", "visit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "traverseSiblings$runtime", "traverseSiblingsAfter", "traverseSiblingsAfter$runtime", "traverseChildren", "traverseChildren$runtime", "traverseParents", "traverseParents$runtime", "traverseGroupAndParents", "includeGroup", "traverseGroupAndParents$runtime", "traverseGroup", "includeSiblingsOfStartGroup", "traverseGroup$runtime", "traverseGroupPartially", "traverseGroupPartially$runtime", "traverseAllChildren", "traverseAllChildren$runtime", "contains", "growSlotRangeAtGroup", "currentSize", "shrinkSlotRange", "range", "shrinkSlotRangeAtGroup", "slotSize", "slotRange", "slotAddressAndSize", "R", "block", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "freeSlots", "freeSlotsAt", "growGroups", "toDebugString", "compactAndMaybeGrow", "required", "validateSlotReferences", "Companion", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTableAddressSpace {
    private static final int[] EmptyGroupData;
    private static final Object[] EmptySlotData;
    private MutableIntIntMap _largeSizes;
    private MutableIntObjectMap<LinkAnchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int freeSlotCount;
    private int[] groups;
    private Object[] slots;
    private MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> sourceInformationMap;
    private int unallocatedEnd;
    private int unallocatedStart;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ void getSourceInformationMap$annotations() {
    }

    public SlotTableAddressSpace(int[] iArr, Object[] objArr) {
        this.groups = iArr;
        this.slots = objArr;
        this.unallocatedEnd = objArr.length;
        this.anchors = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final void setGroups(int[] iArr) {
        this.groups = iArr;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final void setSlots(Object[] objArr) {
        this.slots = objArr;
    }

    public final MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> getSourceInformationMap() {
        return this.sourceInformationMap;
    }

    public final void setSourceInformationMap(MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap) {
        this.sourceInformationMap = mutableScatterMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableIntIntMap getLargeSizes() {
        MutableIntIntMap mutableIntIntMap = this._largeSizes;
        if (mutableIntIntMap == null) {
            MutableIntIntMap mutableIntIntMapOf = IntIntMapKt.mutableIntIntMapOf();
            this._largeSizes = mutableIntIntMapOf;
            return mutableIntIntMapOf;
        }
        return mutableIntIntMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SlotTableAddressSpace(int i, int i2) {
        this(r1, r2);
        int[] newGroupsArray;
        Object[] newSlotsArray;
        newGroupsArray = SlotTableAddresSpaceKt.newGroupsArray(i);
        newSlotsArray = SlotTableAddresSpaceKt.newSlotsArray(i2);
    }

    public SlotTableAddressSpace() {
        this(EmptyGroupData, EmptySlotData);
        int[] iArr = this.groups;
        if (iArr[0] == 0 && iArr[1] == -1 && iArr[2] == 0 && iArr[3] == 6 && iArr[4] == 0) {
            int i = iArr[5];
        }
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime() {
        return this.calledByMap;
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        this.calledByMap = mutableIntObjectMap;
    }

    public final void validate() {
        SlotTableAddresSpaceKt.validateFreeList(this.groups);
        validateSlotReferences(this.groups);
    }

    public final int allocateGroup(int i, int i2, int i3) {
        int groupAllocate;
        int groupAllocate2;
        groupAllocate = SlotTableAddresSpaceKt.groupAllocate(getGroups(), i, i2, i3);
        if (groupAllocate < 0) {
            growGroups();
            groupAllocate2 = SlotTableAddresSpaceKt.groupAllocate(getGroups(), i, i2, i3);
            return groupAllocate2;
        }
        return groupAllocate;
    }

    public final void freeGroupTree(int i) {
        removeSourceInformation(i);
        freeGroup(i);
    }

    private final void removeSourceInformation(int i) {
        LinkAnchor linkAnchor;
        LinkAnchor linkAnchor2;
        LinkGroupSourceInformation linkGroupSourceInformation;
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
        if (mutableScatterMap == null || (linkAnchor = this.anchors.get(i)) == null || (linkAnchor2 = this.anchors.get(this.groups[i + 2])) == null || (linkGroupSourceInformation = mutableScatterMap.get(linkAnchor2)) == null) {
            return;
        }
        linkGroupSourceInformation.removeGroup(linkAnchor);
    }

    private final void freeGroup(int i) {
        int[] iArr = this.groups;
        if (i + 6 > iArr.length) {
            return;
        }
        int i2 = i + 4;
        if ((iArr[i2] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK) == 8388607) {
            ComposerKt.composeImmediateRuntimeError("Recursive loop in group structure detected at " + i);
        }
        LinkAnchor linkAnchor = this.anchors.get(i);
        if (linkAnchor != null) {
            linkAnchor.setAddress(-1);
            this.anchors.remove(i);
            MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
            if (mutableScatterMap != null) {
                mutableScatterMap.remove(linkAnchor);
            }
        }
        int i3 = i + 5;
        freeSlots(iArr[i3]);
        iArr[i3] = -1;
        int i4 = iArr[i + 3];
        while (i4 != -1) {
            if (i4 + 6 > iArr.length) {
                return;
            }
            int i5 = iArr[i4 + 1];
            freeGroup(i4);
            i4 = i5;
        }
        iArr[i + 1] = iArr[1];
        iArr[i + 2] = -1;
        iArr[1] = i;
        iArr[i2] = 8388607;
    }

    public final long reserveSlots() {
        int i = this.unallocatedStart;
        int i2 = this.unallocatedEnd;
        this.unallocatedStart = i2;
        return ((UInt.m9999constructorimpl(i2) & 4294967295L) << 32) | (UInt.m9999constructorimpl(i) & 4294967295L);
    }

    public final void restoreSlots(int i, int i2) {
        if (i2 == this.unallocatedEnd) {
            this.unallocatedStart = i;
        }
    }

    public final void recordLargeBlock(int i, int i2) {
        getLargeSizes().set(i, i2);
    }

    public final Object readSlot(int i, int i2) {
        return this.slots[(this.groups[i + 5] >> 4) + i2];
    }

    public final int writeSlot(int i, int i2, Object obj) {
        int i3;
        int[] iArr = this.groups;
        int i4 = i + 5;
        int i5 = iArr[i4];
        if (i5 == -1) {
            i3 = allocateSlots(i2 + 1);
            iArr[i4] = i3;
        } else {
            int i6 = (i5 & 15) + 1;
            int i7 = i5 >> 4;
            if (i6 > 15) {
                i6 = getLargeSizes().get(i7);
            }
            if (i2 >= i6) {
                i5 = growSlotRangeAtGroup(i, i6, i2 + 1);
            }
            i3 = i5;
        }
        this.slots[(i3 >> 4) + i2] = obj;
        return i3;
    }

    public final LinkGroupSourceInformation sourceInformationOf(int i) {
        LinkAnchor linkAnchor;
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
        if (mutableScatterMap == null || (linkAnchor = this.anchors.get(i)) == null) {
            return null;
        }
        return mutableScatterMap.get(linkAnchor);
    }

    public final LinkGroupSourceInformation recordSourceInformation(int i, String str, int i2) {
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
        if (mutableScatterMap == null) {
            mutableScatterMap = ScatterMapKt.mutableScatterMapOf();
            this.sourceInformationMap = mutableScatterMap;
        }
        LinkAnchor anchorOfAddress = anchorOfAddress(i);
        LinkGroupSourceInformation linkGroupSourceInformation = mutableScatterMap.get(anchorOfAddress);
        if (linkGroupSourceInformation == null) {
            linkGroupSourceInformation = new LinkGroupSourceInformation(0, str, 0);
            if (str == null) {
                int i3 = this.groups[i + 3];
                while (i3 != i2 && i3 != -1) {
                    linkGroupSourceInformation.reportGroup(anchorOfAddress(i3));
                    i3 = this.groups[i3 + 1];
                }
            }
            mutableScatterMap.set(anchorOfAddress, linkGroupSourceInformation);
        }
        return linkGroupSourceInformation;
    }

    public final void recordCalledBy(int i, int i2) {
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = IntObjectMapKt.mutableIntObjectMapOf();
            this.calledByMap = mutableIntObjectMap;
        }
        MutableIntSet mutableIntSet = mutableIntObjectMap.get(i);
        if (mutableIntSet == null) {
            mutableIntSet = IntSetKt.mutableIntSetOf();
            mutableIntObjectMap.set(i, mutableIntSet);
        }
        mutableIntSet.add(i2);
    }

    private final int allocateSlots(int i) {
        int i2 = this.unallocatedStart;
        int i3 = i2 + i;
        if (i3 <= this.unallocatedEnd) {
            this.unallocatedStart = i3;
            if (i > 15) {
                getLargeSizes().set(i2, i);
            }
            ArraysKt.fill(this.slots, Composer.Companion.getEmpty(), i2, i3);
            return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i2, i);
        }
        compactAndMaybeGrow(i);
        int i4 = this.unallocatedStart;
        int i5 = i4 + i;
        if (i5 <= this.unallocatedEnd) {
            this.unallocatedStart = i5;
            if (i > 15) {
                getLargeSizes().set(i4, i);
            }
            ArraysKt.fill(this.slots, Composer.Companion.getEmpty(), i4, i5);
            return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i4, i);
        }
        ComposerKt.composeRuntimeError("compactAndMaybeGrow did not grow enough");
        throw new KotlinNothingValueException();
    }

    public final int resizeSlotRangeAtGroup(int i, int i2, int i3) {
        if (i3 == i2) {
            return this.groups[i + 5];
        }
        if (i3 > i2) {
            return growSlotRangeAtGroup(i, i2, i3);
        }
        return shrinkSlotRangeAtGroup(i, i2, i3);
    }

    public final int resizeSlotRangeAtGroup(int i, int i2) {
        int i3;
        int i4 = this.groups[i + 5];
        if (i4 == -1 && i2 == 0) {
            return i4;
        }
        if (i4 == -1) {
            i3 = 0;
        } else {
            int i5 = (i4 & 15) + 1;
            i3 = i5 > 15 ? getLargeSizes().get(i4 >> 4) : i5;
        }
        return resizeSlotRangeAtGroup(i, i3, i2);
    }

    private static final int copyTreeFrom$copyGroup(SlotTableAddressSpace slotTableAddressSpace, SlotTableAddressSpace slotTableAddressSpace2, int i, int i2) {
        int groupAllocate;
        int[] iArr = slotTableAddressSpace.groups;
        Object[] objArr = slotTableAddressSpace.slots;
        int i3 = iArr[i2 + 4];
        int i4 = iArr[i2];
        groupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace2.getGroups(), i4, i, i3);
        if (groupAllocate < 0) {
            slotTableAddressSpace2.growGroups();
            groupAllocate = SlotTableAddresSpaceKt.groupAllocate(slotTableAddressSpace2.getGroups(), i4, i, i3);
        }
        slotTableAddressSpace2.moveSourceInformation(slotTableAddressSpace, slotTableAddressSpace2.moveAnchorFrom(slotTableAddressSpace, i2, groupAllocate));
        int i5 = iArr[i2 + 5];
        if (i5 != -1) {
            int i6 = (i5 & 15) + 1;
            int i7 = i5 >> 4;
            if (i6 > 15) {
                i6 = slotTableAddressSpace.getLargeSizes().get(i7);
            }
            int allocateSlots = slotTableAddressSpace2.allocateSlots(i6);
            ArraysKt.copyInto(objArr, slotTableAddressSpace2.slots, allocateSlots >> 4, i7, i6 + i7);
            slotTableAddressSpace2.groups[groupAllocate + 5] = allocateSlots;
        }
        int i8 = iArr[i2 + 3];
        int i9 = -1;
        while (i8 != -1) {
            int copyTreeFrom$copyGroup = copyTreeFrom$copyGroup(slotTableAddressSpace, slotTableAddressSpace2, groupAllocate, i8);
            if (i9 == -1) {
                slotTableAddressSpace2.groups[groupAllocate + 3] = copyTreeFrom$copyGroup;
            } else {
                slotTableAddressSpace2.groups[i9 + 1] = copyTreeFrom$copyGroup;
            }
            i8 = iArr[i8 + 1];
            i9 = copyTreeFrom$copyGroup;
        }
        return groupAllocate;
    }

    public final int copyTreeFrom(SlotTableAddressSpace slotTableAddressSpace, int i) {
        return copyTreeFrom$copyGroup(slotTableAddressSpace, this, -1, i);
    }

    public final void recordMovedSourceInformation(int i, int i2) {
        LinkGroupSourceInformation linkGroupSourceInformation;
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap = this.sourceInformationMap;
        if (mutableScatterMap == null) {
            return;
        }
        LinkAnchor linkAnchor = this.anchors.get(this.groups[i + 2]);
        if (linkAnchor == null || (linkGroupSourceInformation = mutableScatterMap.get(linkAnchor)) == null) {
            return;
        }
        linkGroupSourceInformation.addGroupAfter(i2 != -1 ? anchorOfAddress(i2) : null, anchorOfAddress(i));
    }

    public final LinkAnchor anchorOfAddress(int i) {
        if (i != -1) {
            if (i == 0) {
                return LinkAnchorKt.getLazyAnchor();
            }
            if (!(i >= 0)) {
                ComposerKt.composeImmediateRuntimeError("Invalid anchor address " + i);
            }
            MutableIntObjectMap<LinkAnchor> mutableIntObjectMap = this.anchors;
            LinkAnchor linkAnchor = mutableIntObjectMap.get(i);
            if (linkAnchor == null) {
                linkAnchor = new LinkAnchor(i);
                mutableIntObjectMap.set(i, linkAnchor);
            }
            return linkAnchor;
        }
        return LinkAnchorKt.getNullAnchor();
    }

    public final boolean ownsAnchor(LinkAnchor linkAnchor) {
        return this.anchors.get(linkAnchor.getAddress()) == linkAnchor;
    }

    public final LinkAnchor moveAnchorFrom(SlotTableAddressSpace slotTableAddressSpace, int i, int i2) {
        this.anchors.containsKey(i2);
        LinkAnchor remove = slotTableAddressSpace.anchors.remove(i);
        if (remove != null) {
            remove.setAddress(i2);
            this.anchors.set(i2, remove);
            return remove;
        }
        return null;
    }

    public final void moveSourceInformation(SlotTableAddressSpace slotTableAddressSpace, LinkAnchor linkAnchor) {
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap;
        LinkGroupSourceInformation linkGroupSourceInformation;
        if (linkAnchor == null || (mutableScatterMap = slotTableAddressSpace.sourceInformationMap) == null || (linkGroupSourceInformation = mutableScatterMap.get(linkAnchor)) == null) {
            return;
        }
        MutableScatterMap<LinkAnchor, LinkGroupSourceInformation> mutableScatterMap2 = this.sourceInformationMap;
        if (mutableScatterMap2 == null) {
            mutableScatterMap2 = ScatterMapKt.mutableScatterMapOf();
            this.sourceInformationMap = mutableScatterMap2;
        } else {
            mutableScatterMap2.contains(linkAnchor);
        }
        mutableScatterMap2.set(linkAnchor, linkGroupSourceInformation);
        mutableScatterMap.remove(linkAnchor);
    }

    public final int distanceFrom$runtime(int i, int i2) {
        int[] iArr = this.groups;
        int i3 = 0;
        while (i != i2 && i >= 0) {
            i3++;
            i = iArr[i + 2];
        }
        return i3;
    }

    public final void traverseSiblings$runtime(int i, Function1<? super Integer, Unit> function1) {
        int[] groups = getGroups();
        while (i >= 0) {
            function1.invoke(Integer.valueOf(i));
            i = groups[i + 1];
        }
    }

    public final void traverseSiblingsAfter$runtime(int i, Function1<? super Integer, Unit> function1) {
        int[] groups = getGroups();
        for (int i2 = groups[i + 1]; i2 >= 0; i2 = groups[i2 + 1]) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public final void traverseChildren$runtime(int i, Function1<? super Integer, Unit> function1) {
        int[] groups = getGroups();
        for (int i2 = groups[i + 3]; i2 > 0; i2 = groups[i2 + 1]) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public static /* synthetic */ void traverseGroupAndParents$runtime$default(SlotTableAddressSpace slotTableAddressSpace, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        int[] groups = slotTableAddressSpace.getGroups();
        int i3 = !z ? groups[i + 2] : i;
        while (i3 > 0) {
            function1.invoke(Integer.valueOf(i3));
            i3 = groups[i3 + 2];
        }
        if (i3 != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
    }

    public final void traverseGroupAndParents$runtime(int i, boolean z, Function1<? super Integer, Unit> function1) {
        int[] groups = getGroups();
        int i2 = !z ? groups[i + 2] : i;
        while (i2 > 0) {
            function1.invoke(Integer.valueOf(i2));
            i2 = groups[i2 + 2];
        }
        if (i2 != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
    }

    public static /* synthetic */ void traverseGroup$runtime$default(SlotTableAddressSpace slotTableAddressSpace, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = slotTableAddressSpace.getGroups();
        int i4 = i;
        while (true) {
            function1.invoke(Integer.valueOf(i4));
            if ((i4 != i || z) && (i3 = groups[i4 + 1]) >= 0) {
                intStack.push(i3);
            }
            i4 = groups[i4 + 3];
            if (i4 < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                i4 = intStack.pop();
            }
        }
    }

    public final void traverseGroup$runtime(int i, boolean z, Function1<? super Integer, Unit> function1) {
        int i2;
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = getGroups();
        int i3 = i;
        while (true) {
            function1.invoke(Integer.valueOf(i3));
            if ((i3 != i || z) && (i2 = groups[i3 + 1]) >= 0) {
                intStack.push(i2);
            }
            i3 = groups[i3 + 3];
            if (i3 < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                i3 = intStack.pop();
            }
        }
    }

    public static /* synthetic */ void traverseGroupPartially$runtime$default(SlotTableAddressSpace slotTableAddressSpace, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
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

    public final void traverseGroupPartially$runtime(int i, boolean z, Function1<? super Integer, Boolean> function1) {
        int i2;
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = getGroups();
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

    public final void traverseAllChildren$runtime(int i, Function1<? super Integer, Unit> function1) {
        int i2;
        if (i < 0 || (i2 = getGroups()[i + 3]) < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = getGroups();
        while (true) {
            function1.invoke(Integer.valueOf(i2));
            int i3 = groups[i2 + 1];
            if (i3 >= 0) {
                intStack.push(i3);
            }
            i2 = groups[i2 + 3];
            if (i2 < 0) {
                if (intStack.tos == 0) {
                    return;
                }
                i2 = intStack.pop();
            }
        }
    }

    public final boolean contains(int i) {
        return i > 0 && i < this.groups[3];
    }

    private final int growSlotRangeAtGroup(int i, int i2, int i3) {
        int i4;
        int i5 = this.unallocatedStart;
        int i6 = this.unallocatedEnd;
        int i7 = i + 5;
        int i8 = this.groups[i7] >> 4;
        int i9 = i8 + i2;
        if (i9 == i5 && (i4 = i8 + i3) <= i6) {
            this.unallocatedStart = i5 + (i3 - i2);
            if (i3 > 15) {
                getLargeSizes().set(i8, i3);
            }
            int slotRangeFromAddressAndSize = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i8, i3);
            Object[] objArr = this.slots;
            if (i4 == i9 + 1) {
                objArr[i9] = SlotTableAddresSpaceKt.Unallocated;
            } else {
                ArraysKt.fill(objArr, SlotTableAddresSpaceKt.Unallocated, i9, i4);
            }
            this.groups[i7] = slotRangeFromAddressAndSize;
            return slotRangeFromAddressAndSize;
        }
        int i10 = i3 - i2;
        Object[] objArr2 = this.slots;
        int i11 = i9 + i10;
        if (i11 < objArr2.length) {
            for (int i12 = i9; i12 < i11; i12++) {
                if (objArr2[i12] == SlotTableAddresSpaceKt.Unallocated) {
                }
            }
            if (i3 > 15) {
                getLargeSizes().set(i8, i3);
            }
            int slotRangeFromAddressAndSize2 = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i8, i3);
            Object[] objArr3 = this.slots;
            int i13 = i8 + i3;
            if (i13 == i9 + 1) {
                objArr3[i9] = SlotTableAddresSpaceKt.Unallocated;
            } else {
                ArraysKt.fill(objArr3, SlotTableAddresSpaceKt.Unallocated, i9, i13);
            }
            this.groups[i7] = slotRangeFromAddressAndSize2;
            this.freeSlotCount -= i10;
            return slotRangeFromAddressAndSize2;
        }
        int i14 = i3 + 8;
        int shrinkSlotRange = shrinkSlotRange(allocateSlots(i14), i14, i3);
        int i15 = shrinkSlotRange >> 4;
        int i16 = this.groups[i7] >> 4;
        if (i15 != i16) {
            Object[] objArr4 = this.slots;
            ArraysKt.copyInto(objArr4, objArr4, i15, i16, i16 + i2);
            freeSlotsAt(i16, i2);
        }
        this.groups[i7] = shrinkSlotRange;
        return shrinkSlotRange;
    }

    private final int shrinkSlotRange(int i, int i2, int i3) {
        int i4 = i >> 4;
        if (i3 == 0) {
            if (i != -1) {
                freeSlotsAt(i4, i2);
            }
            return -1;
        }
        int i5 = i2 - i3;
        int i6 = i4 + i3;
        if (i5 > 0) {
            freeSlotsAt(i6, i5);
        }
        if (i3 > 15) {
            getLargeSizes().set(i4, i3);
        }
        return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i4, i3);
    }

    private final int shrinkSlotRangeAtGroup(int i, int i2, int i3) {
        int i4 = i + 5;
        int shrinkSlotRange = shrinkSlotRange(this.groups[i4], i2, i3);
        this.groups[i4] = shrinkSlotRange;
        return shrinkSlotRange;
    }

    public final int slotSize(int i) {
        if (i == -1) {
            return 0;
        }
        int i2 = (i & 15) + 1;
        return i2 > 15 ? getLargeSizes().get(i >> 4) : i2;
    }

    public final <R> R slotAddressAndSize(int i, Function2<? super Integer, ? super Integer, ? extends R> function2) {
        int i2 = (i & 15) + 1;
        int i3 = i >> 4;
        if (i2 > 15) {
            i2 = getLargeSizes().get(i3);
        }
        return function2.invoke(Integer.valueOf(i3), Integer.valueOf(i2));
    }

    private final void freeSlotsAt(int i, int i2) {
        Object[] objArr = this.slots;
        int i3 = i + i2;
        if (i3 == i + 1) {
            objArr[i] = SlotTableAddresSpaceKt.Unallocated;
        } else {
            ArraysKt.fill(objArr, SlotTableAddresSpaceKt.Unallocated, i, i3);
        }
        this.freeSlotCount += i2;
        if (i2 > 15) {
            getLargeSizes().remove(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void growGroups() {
        int[] iArr = this.groups;
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(this.groups, RangesKt.coerceAtLeast(iArr.length * 2, (int) ViewUtils.EDGE_TO_EDGE_FLAGS));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.groups = copyOf;
        SlotTableAddresSpaceKt.initGroups(copyOf, length);
    }

    public final String toDebugString() {
        StringBuilder sb = new StringBuilder("SlotTableAddressSpace:\n  Group size: ");
        int[] iArr = this.groups;
        sb.append(iArr.length);
        sb.append("\n  Slots size: ");
        sb.append(this.slots.length);
        sb.append("\n\n Groups:\n  Unallocated groups: ");
        int length = (iArr.length - iArr[3]) / 6;
        sb.append(length);
        sb.append('\n');
        int i = 0;
        for (int i2 = iArr[1]; i2 != -1; i2 = iArr[i2 + 1]) {
            i++;
        }
        sb.append("  Free groups:        ");
        sb.append(i);
        sb.append("\n  Total free groups:  ");
        int i3 = i + length;
        sb.append(i3);
        sb.append("\n  Used group%:        ");
        sb.append(((iArr.length / 6) - i3) / (iArr.length / 6));
        sb.append("\n\n Slots:\n  Unallocated slots: ");
        int i4 = this.unallocatedEnd - this.unallocatedStart;
        sb.append(i4);
        sb.append("\n  Slot used%:    ");
        int length2 = this.slots.length;
        sb.append(((length2 - this.freeSlotCount) - i4) / length2);
        sb.append('\n');
        return sb.toString();
    }

    private final void compactAndMaybeGrow(int i) {
        Object[] objArr = this.slots;
        int length = objArr.length;
        int length2 = objArr.length - ((this.unallocatedEnd - this.unallocatedStart) + this.freeSlotCount);
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros((i + length2) + (objArr.length >> 5)));
        if (numberOfLeadingZeros < length) {
            numberOfLeadingZeros = length;
        }
        Object[] newSlotsArray = numberOfLeadingZeros != length ? SlotTableAddresSpaceKt.newSlotsArray(RangesKt.coerceAtLeast(numberOfLeadingZeros, 256)) : objArr;
        MutableIntIntMap mutableIntIntMapOf = IntIntMapKt.mutableIntIntMapOf();
        int i2 = this.groups[3];
        SlotMoveManager slotMoveManager = new SlotMoveManager(objArr, newSlotsArray);
        int i3 = 6;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(6, i2 - 1, 6);
        int i4 = 0;
        if (6 <= progressionLastElement) {
            while (true) {
                int i5 = i3 + 5;
                int i6 = this.groups[i5];
                if (i6 != -1) {
                    int i7 = (i6 & 15) + 1;
                    int i8 = i6 >> 4;
                    if (i7 > 15) {
                        i7 = getLargeSizes().get(i8);
                    }
                    slotMoveManager.move(i4, i8, i8 + i7);
                    if (i7 > 15) {
                        mutableIntIntMapOf.set(i4, i7);
                    }
                    this.groups[i5] = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(i4, i7);
                    i4 += i7;
                }
                if (i3 == progressionLastElement) {
                    break;
                }
                i3 += 6;
            }
        }
        if (!(i4 == length2)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot compaction result, computed we had " + length2 + " slots, but copied " + i4 + " slots");
        }
        this.slots = slotMoveManager.done();
        if (!mutableIntIntMapOf.isNotEmpty()) {
            mutableIntIntMapOf = null;
        }
        this._largeSizes = mutableIntIntMapOf;
        this.unallocatedStart = i4;
        this.unallocatedEnd = newSlotsArray.length;
        this.freeSlotCount = 0;
    }

    private final void validateSlotReferences(int[] iArr) {
        MutableIntIntMap mutableIntIntMapOf = IntIntMapKt.mutableIntIntMapOf();
        int length = this.slots.length;
        int i = 6;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(6, iArr[3] - 1, 6);
        if (6 <= progressionLastElement) {
            while (true) {
                int i2 = iArr[i + 5];
                if (i2 != -1) {
                    int i3 = (i2 & 15) + 1;
                    int i4 = i2 >> 4;
                    if (i3 > 15) {
                        i3 = getLargeSizes().get(i4);
                    }
                    if (i4 < 0) {
                        throw new IllegalStateException(("Group " + i + " has an invalid slot address").toString());
                    }
                    int i5 = i3 + i4;
                    if (i5 > length) {
                        throw new IllegalStateException(("Group " + i + " slot range extends beyond the slot size").toString());
                    }
                    while (i4 < i5) {
                        if (mutableIntIntMapOf.containsKey(i4)) {
                            int i6 = mutableIntIntMapOf.get(i4);
                            throw new IllegalStateException(("Group " + i + " contains a slot address (" + validateSlotReferences$slotRangeTextOf(this, iArr, i) + ") that overlaps with group " + i6 + "'s address (" + validateSlotReferences$slotRangeTextOf(this, iArr, i6) + ')').toString());
                        } else {
                            mutableIntIntMapOf.set(i4, i);
                            i4++;
                        }
                    }
                }
                if (i == progressionLastElement) {
                    break;
                }
                i += 6;
            }
        }
        int length2 = (this.slots.length - mutableIntIntMapOf.getSize()) - (this.unallocatedEnd - this.unallocatedStart);
        if (this.freeSlotCount != length2) {
            throw new IllegalStateException(("Unexpected freeSlotCount, " + this.freeSlotCount + ", expected " + length2).toString());
        }
    }

    /* compiled from: SlotTableAddresSpace.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace$Companion;", "", "<init>", "()V", "EmptyGroupData", "", "EmptySlotData", "", "[Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int[] newGroupsArray;
        Object[] newSlotsArray;
        newGroupsArray = SlotTableAddresSpaceKt.newGroupsArray(6);
        EmptyGroupData = newGroupsArray;
        newSlotsArray = SlotTableAddresSpaceKt.newSlotsArray(0);
        EmptySlotData = newSlotsArray;
    }

    public final void traverseParents$runtime(int i, Function1<? super Integer, Unit> function1) {
        int[] groups = getGroups();
        int i2 = groups[i + 2];
        while (i2 > 0) {
            function1.invoke(Integer.valueOf(i2));
            i2 = groups[i2 + 2];
        }
        if (i2 != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
    }

    private final void freeSlots(int i) {
        if (i != -1) {
            int i2 = (i & 15) + 1;
            int i3 = i >> 4;
            if (i2 > 15) {
                i2 = getLargeSizes().get(i3);
            }
            freeSlotsAt(i3, i2);
        }
    }

    private static final String validateSlotReferences$slotRangeTextOf(SlotTableAddressSpace slotTableAddressSpace, int[] iArr, int i) {
        int i2 = iArr[i + 5];
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            i3 = slotTableAddressSpace.getLargeSizes().get(i4);
        }
        return new StringBuilder().append(i4).append('-').append(i4 + i3).toString();
    }
}
