package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0082\b\u001a\b\u0010\u001f\u001a\u00020 H\u0000\u001a\"\u0010!\u001a\u00020 *\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001a\u0014\u0010%\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u0014\u0010(\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u0014\u0010)\u001a\u00020**\u00020+2\u0006\u0010,\u001a\u00020\u0001H\u0000\u001a\u0015\u0010-\u001a\u00020.*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010/\u001a\u00020.*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102*\u00020&2\b\b\u0002\u00103\u001a\u00020\u0001H\u0002\u001a7\u00104\u001a\u00020\u0001\"\u0004\b\u0000\u00105*\u0012\u0012\u0004\u0012\u0002H506j\b\u0012\u0004\u0012\u0002H5`72\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020.09H\u0082\b\u001a>\u0010:\u001a\u0004\u0018\u0001H5\"\u0004\b\u0000\u00105*\u0012\u0012\u0004\u0012\u0002H506j\b\u0012\u0004\u0012\u0002H5`72\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020.09H\u0082\b¢\u0006\u0002\u0010;\u001a.\u0010<\u001a\u0004\u0018\u00010=*\u0012\u0012\u0004\u0012\u00020=06j\b\u0012\u0004\u0012\u00020=`72\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0001H\u0002\u001a;\u0010@\u001a\u00020=*\u0012\u0012\u0004\u0012\u00020=06j\b\u0012\u0004\u0012\u00020=`72\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020=0BH\u0082\b\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u0014\u0010D\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000102*\u00020&2\b\b\u0002\u00103\u001a\u00020\u0001H\u0002\u001a\u0015\u0010F\u001a\u00020.*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010G\u001a\u00020.*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010H\u001a\u00020.*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001aD\u0010I\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00012\u0006\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0002\u001a\u0015\u0010J\u001a\u00020.*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010$\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000102*\u00020&2\b\b\u0002\u00103\u001a\u00020\u0001H\u0002\u001a,\u0010O\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020=06j\b\u0012\u0004\u0012\u00020=`72\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0001H\u0002\u001a\u0015\u0010P\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000102*\u00020&2\b\b\u0002\u00103\u001a\u00020\u0001H\u0002\u001a\u0015\u0010R\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u0014\u0010S\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u0015\u0010M\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0082\b\u001a\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000102*\u00020&2\b\b\u0002\u00103\u001a\u00020\u0001H\u0002\u001a,\u0010U\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020=06j\b\u0012\u0004\u0012\u00020=`72\u0006\u0010V\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0001H\u0002\u001a \u0010W\u001a\b\u0012\u0004\u0012\u00020\u000102*\u00020&2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00010YH\u0002\u001a\u0014\u0010Z\u001a\u00020\u0001*\u00020&2\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u0014\u0010[\u001a\u00020\\*\u00020\\2\u0006\u0010]\u001a\u00020\u0001H\u0002\u001a\r\u0010^\u001a\u00020\u0001*\u00020.H\u0082\b\u001a\u001c\u0010_\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020.H\u0002\u001a\u001d\u0010`\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010a\u001a\u00020\u0001H\u0082\b\u001a\u001c\u0010b\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0001H\u0002\u001a\u001c\u0010c\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001a\u001c\u0010d\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020.H\u0002\u001a\u001c\u0010e\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001a\u001d\u0010f\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0019\u001a\u00020\u0001*\u00020\u001a8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006g"}, d2 = {"Aux_Mask", "", "Aux_Shift", "ContainsMark_Mask", "ContainsMark_Shift", "DataAnchor_Offset", "EmptyLongArray", "", "GroupInfo_Offset", "Group_Fields_Size", "Key_Offset", "LIVE_EDIT_INVALID_KEY", "Mark_Mask", "Mark_Shift", "MinGroupGrowthSize", "MinSlotsGrowthSize", "NodeBit_Mask", "NodeBit_Shift", "NodeCount_Mask", "ObjectKey_Mask", "ObjectKey_Shift", "ParentAnchor_Offset", "Size_Offset", "Slots_Shift", "parentAnchorPivot", "firstBitSet", "", "getFirstBitSet", "(J)I", "countOneBits", "value", "throwConcurrentModificationException", "", "add", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "key", "addAux", "", "address", "auxIndex", "compositionGroupOf", "Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/SlotTable;", "group", "containsAnyMark", "", "containsMark", "dataAnchor", "dataAnchors", "", "len", "fastIndexOf", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "predicate", "Lkotlin/Function1;", "fastLastOrNull", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "find", "Landroidx/compose/runtime/Anchor;", FirebaseAnalytics.Param.INDEX, "effectiveSize", "getOrAdd", "block", "Lkotlin/Function0;", "groupInfo", "groupSize", "groupSizes", "hasAux", "hasMark", "hasObjectKey", "initGroup", "isNode", "hasDataKey", "hasData", "parentAnchor", UserMetadata.KEYDATA_FILENAME, "locationOf", "nodeCount", "nodeCounts", "nodeIndex", "objectKeyIndex", "parentAnchors", FirebaseAnalytics.Event.SEARCH, FirebaseAnalytics.Param.LOCATION, "slice", "indices", "", "slotAnchor", "summarize", "", "size", "toBit", "updateContainsMark", "updateDataAnchor", "anchor", "updateGroupKey", "updateGroupSize", "updateMark", "updateNodeCount", "updateParentAnchor", "runtime_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTableKt {
    private static final int Aux_Mask = 268435456;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 67108864;
    private static final int ContainsMark_Shift = 26;
    private static final int DataAnchor_Offset = 4;
    private static final long[] EmptyLongArray = new long[0];
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int LIVE_EDIT_INVALID_KEY = -3;
    private static final int Mark_Mask = 134217728;
    private static final int Mark_Shift = 27;
    private static final int MinGroupGrowthSize = 32;
    private static final int MinSlotsGrowthSize = 32;
    private static final int NodeBit_Mask = 1073741824;
    private static final int NodeBit_Shift = 30;
    private static final int NodeCount_Mask = 67108863;
    private static final int ObjectKey_Mask = 536870912;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;

    public static final /* synthetic */ void access$add(MutableIntObjectMap mutableIntObjectMap, int i, int i2) {
        add(mutableIntObjectMap, i, i2);
    }

    public static final /* synthetic */ void access$addAux(int[] iArr, int i) {
        addAux(iArr, i);
    }

    public static final /* synthetic */ int access$auxIndex(int[] iArr, int i) {
        return auxIndex(iArr, i);
    }

    public static final /* synthetic */ List access$dataAnchors(int[] iArr, int i) {
        return dataAnchors(iArr, i);
    }

    public static final /* synthetic */ Anchor access$find(ArrayList arrayList, int i, int i2) {
        return find(arrayList, i, i2);
    }

    public static final /* synthetic */ int access$groupSize(int[] iArr, int i) {
        return groupSize(iArr, i);
    }

    public static final /* synthetic */ List access$groupSizes(int[] iArr, int i) {
        return groupSizes(iArr, i);
    }

    public static final /* synthetic */ void access$initGroup(int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4) {
        initGroup(iArr, i, i2, z, z2, z3, i3, i4);
    }

    public static final /* synthetic */ List access$keys(int[] iArr, int i) {
        return keys(iArr, i);
    }

    public static final /* synthetic */ int access$locationOf(ArrayList arrayList, int i, int i2) {
        return locationOf(arrayList, i, i2);
    }

    public static final /* synthetic */ List access$nodeCounts(int[] iArr, int i) {
        return nodeCounts(iArr, i);
    }

    public static final /* synthetic */ int access$objectKeyIndex(int[] iArr, int i) {
        return objectKeyIndex(iArr, i);
    }

    public static final /* synthetic */ List access$parentAnchors(int[] iArr, int i) {
        return parentAnchors(iArr, i);
    }

    public static final /* synthetic */ int access$search(ArrayList arrayList, int i, int i2) {
        return search(arrayList, i, i2);
    }

    public static final /* synthetic */ int access$slotAnchor(int[] iArr, int i) {
        return slotAnchor(iArr, i);
    }

    public static final /* synthetic */ String access$summarize(String str, int i) {
        return summarize(str, i);
    }

    public static final /* synthetic */ void access$updateContainsMark(int[] iArr, int i, boolean z) {
        updateContainsMark(iArr, i, z);
    }

    public static final /* synthetic */ void access$updateGroupKey(int[] iArr, int i, int i2) {
        updateGroupKey(iArr, i, i2);
    }

    public static final /* synthetic */ void access$updateGroupSize(int[] iArr, int i, int i2) {
        updateGroupSize(iArr, i, i2);
    }

    public static final /* synthetic */ void access$updateMark(int[] iArr, int i, boolean z) {
        updateMark(iArr, i, z);
    }

    public static final /* synthetic */ void access$updateNodeCount(int[] iArr, int i, int i2) {
        updateNodeCount(iArr, i, i2);
    }

    private static final int toBit(boolean z) {
        return z ? 1 : 0;
    }

    private static final <T> T fastLastOrNull(ArrayList<T> arrayList, Function1<? super T, Boolean> function1) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            T t = arrayList.get(size);
            if (function1.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    private static final <T> int fastIndexOf(ArrayList<T> arrayList, Function1<? super T, Boolean> function1) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (function1.invoke(arrayList.get(i)).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final String summarize(String str, int i) {
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "androidx.", "a.", false, 4, (Object) null), "compose.", "c.", false, 4, (Object) null), "runtime.", "r.", false, 4, (Object) null), "internal.", "ι.", false, 4, (Object) null), "ui.", "u.", false, 4, (Object) null), "Modifier", "μ", false, 4, (Object) null), "material.", "m.", false, 4, (Object) null), "Function", "λ", false, 4, (Object) null), "OpaqueKey", "κ", false, 4, (Object) null), "MutableState", "σ", false, 4, (Object) null);
        String substring = replace$default.substring(0, Math.min(i, replace$default.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final CompositionGroup compositionGroupOf(SlotTable slotTable, int i) {
        return new SlotTableGroup(slotTable, i, slotTable.getVersion$runtime_release());
    }

    private static final int getFirstBitSet(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    private static final int groupInfo(int[] iArr, int i) {
        return iArr[(i * 5) + 1];
    }

    private static final boolean isNode(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 1073741824) != 0;
    }

    private static final int nodeIndex(int[] iArr, int i) {
        return iArr[(i * 5) + 4];
    }

    private static final boolean hasObjectKey(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 536870912) != 0;
    }

    public static final int objectKeyIndex(int[] iArr, int i) {
        int i2 = i * 5;
        return iArr[i2 + 4] + Integer.bitCount(iArr[i2 + 1] >> 30);
    }

    private static final boolean hasAux(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 268435456) != 0;
    }

    public static final void addAux(int[] iArr, int i) {
        int i2 = (i * 5) + 1;
        iArr[i2] = iArr[i2] | 268435456;
    }

    private static final boolean hasMark(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 134217728) != 0;
    }

    public static final void updateMark(int[] iArr, int i, boolean z) {
        int i2 = (i * 5) + 1;
        iArr[i2] = ((z ? 1 : 0) << 27) | (iArr[i2] & (-134217729));
    }

    private static final boolean containsMark(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 67108864) != 0;
    }

    public static final void updateContainsMark(int[] iArr, int i, boolean z) {
        int i2 = (i * 5) + 1;
        iArr[i2] = ((z ? 1 : 0) << 26) | (iArr[i2] & (-67108865));
    }

    private static final boolean containsAnyMark(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 201326592) != 0;
    }

    public static final int auxIndex(int[] iArr, int i) {
        int i2 = i * 5;
        return i2 >= iArr.length ? iArr.length : iArr[i2 + 4] + Integer.bitCount(iArr[i2 + 1] >> 29);
    }

    public static final int slotAnchor(int[] iArr, int i) {
        int i2 = i * 5;
        return iArr[i2 + 4] + Integer.bitCount(iArr[i2 + 1] >> 28);
    }

    private static final int countOneBits(int i) {
        return Integer.bitCount(i);
    }

    private static final int key(int[] iArr, int i) {
        return iArr[i * 5];
    }

    public static final List<Integer> keys(int[] iArr, int i) {
        return slice(iArr, RangesKt.step(RangesKt.until(0, i), 5));
    }

    public static /* synthetic */ List keys$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iArr.length;
        }
        return keys(iArr, i);
    }

    private static final int nodeCount(int[] iArr, int i) {
        return iArr[(i * 5) + 1] & 67108863;
    }

    public static final void updateNodeCount(int[] iArr, int i, int i2) {
        if (i2 >= 0) {
        }
        int i3 = (i * 5) + 1;
        iArr[i3] = i2 | (iArr[i3] & (-67108864));
    }

    static /* synthetic */ List nodeCounts$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iArr.length;
        }
        return nodeCounts(iArr, i);
    }

    public static final List<Integer> nodeCounts(int[] iArr, int i) {
        List<Integer> slice = slice(iArr, RangesKt.step(RangesKt.until(1, i), 5));
        ArrayList arrayList = new ArrayList(slice.size());
        int size = slice.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(Integer.valueOf(slice.get(i2).intValue() & 67108863));
        }
        return arrayList;
    }

    private static final int parentAnchor(int[] iArr, int i) {
        return iArr[(i * 5) + 2];
    }

    private static final void updateParentAnchor(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 2] = i2;
    }

    static /* synthetic */ List parentAnchors$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iArr.length;
        }
        return parentAnchors(iArr, i);
    }

    public static final List<Integer> parentAnchors(int[] iArr, int i) {
        return slice(iArr, RangesKt.step(RangesKt.until(2, i), 5));
    }

    public static final int groupSize(int[] iArr, int i) {
        return iArr[(i * 5) + 3];
    }

    public static final void updateGroupSize(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 3] = i2;
    }

    private static final List<Integer> slice(int[] iArr, Iterable<Integer> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Integer num : iterable) {
            arrayList.add(Integer.valueOf(iArr[num.intValue()]));
        }
        return arrayList;
    }

    static /* synthetic */ List groupSizes$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iArr.length;
        }
        return groupSizes(iArr, i);
    }

    public static final List<Integer> groupSizes(int[] iArr, int i) {
        return slice(iArr, RangesKt.step(RangesKt.until(3, i), 5));
    }

    private static final int dataAnchor(int[] iArr, int i) {
        return iArr[(i * 5) + 4];
    }

    private static final void updateDataAnchor(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 4] = i2;
    }

    public static /* synthetic */ List dataAnchors$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iArr.length;
        }
        return dataAnchors(iArr, i);
    }

    public static final List<Integer> dataAnchors(int[] iArr, int i) {
        return slice(iArr, RangesKt.step(RangesKt.until(4, i), 5));
    }

    public static final void initGroup(int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4) {
        int i5 = i * 5;
        iArr[i5] = i2;
        iArr[i5 + 1] = ((z ? 1 : 0) << 30) | ((z2 ? 1 : 0) << 29) | ((z3 ? 1 : 0) << 28);
        iArr[i5 + 2] = i3;
        iArr[i5 + 3] = 0;
        iArr[i5 + 4] = i4;
    }

    public static final void updateGroupKey(int[] iArr, int i, int i2) {
        iArr[i * 5] = i2;
    }

    private static final Anchor getOrAdd(ArrayList<Anchor> arrayList, int i, int i2, Function0<Anchor> function0) {
        int search = search(arrayList, i, i2);
        if (search < 0) {
            Anchor invoke = function0.invoke();
            arrayList.add(-(search + 1), invoke);
            return invoke;
        }
        return arrayList.get(search);
    }

    public static final Anchor find(ArrayList<Anchor> arrayList, int i, int i2) {
        int search = search(arrayList, i, i2);
        if (search >= 0) {
            return arrayList.get(search);
        }
        return null;
    }

    public static final int search(ArrayList<Anchor> arrayList, int i, int i2) {
        int size = arrayList.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) >>> 1;
            int location$runtime_release = arrayList.get(i4).getLocation$runtime_release();
            if (location$runtime_release < 0) {
                location$runtime_release += i2;
            }
            int compare = Intrinsics.compare(location$runtime_release, i);
            if (compare < 0) {
                i3 = i4 + 1;
            } else if (compare <= 0) {
                return i4;
            } else {
                size = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static final int locationOf(ArrayList<Anchor> arrayList, int i, int i2) {
        int search = search(arrayList, i, i2);
        return search >= 0 ? search : -(search + 1);
    }

    public static final void add(MutableIntObjectMap<MutableIntSet> mutableIntObjectMap, int i, int i2) {
        MutableIntSet mutableIntSet = mutableIntObjectMap.get(i);
        if (mutableIntSet == null) {
            mutableIntSet = new MutableIntSet(0, 1, null);
            mutableIntObjectMap.set(i, mutableIntSet);
        }
        mutableIntSet.add(i2);
    }

    public static final void throwConcurrentModificationException() {
        throw new ConcurrentModificationException();
    }
}
