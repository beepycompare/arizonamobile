package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposerImpl.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a5\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000b\"\b\b\u0000\u0010\f*\u00020\t\"\b\b\u0001\u0010\r*\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000f\u001a(\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002\u001a\u001a\u0010\u0014\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0007H\u0002\u001a\u001a\u0010\u0018\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0007H\u0002\u001a,\u0010\u0019\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002\u001a$\u0010\u001e\u001a\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002\u001a\u001c\u0010!\u001a\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002\u001a\"\u0010\"\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002\u001a7\u0010#\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010%H\u0082\b\u001a\f\u0010&\u001a\u00020\u0007*\u00020'H\u0002\u001a\f\u0010(\u001a\u00020'*\u00020\u0007H\u0002\u001a\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015*\u00020*2\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001c\u0010-\u001a\u00020\u0007*\u00020.2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002\u001a$\u00100\u001a\u00020\u0007*\u00020.2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002\"\u0018\u00104\u001a\u00020\t*\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\"\u001e\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u001609j\b\u0012\u0004\u0012\u00020\u0016`:X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"deactivateCurrentGroup", "", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "removeData", FirebaseAnalytics.Param.INDEX, "", "data", "", "multiMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "getKey", "value", TtmlNode.LEFT, TtmlNode.RIGHT, "findLocation", "", "Landroidx/compose/runtime/Invalidation;", FirebaseAnalytics.Param.LOCATION, "findInsertLocation", "insertIfMissing", "", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "firstInRange", TtmlNode.START, TtmlNode.END, "removeLocation", "removeRange", "forEachInRange", "block", "Lkotlin/Function1;", "asInt", "", "asBool", "collectNodesFrom", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "root", "nearestCommonRootOf", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "common", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "InvalidationLocationAscending", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "rootKey", "nodeKey", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerImplKt {
    private static final Comparator<Invalidation> InvalidationLocationAscending = new Comparator() { // from class: androidx.compose.runtime.ComposerImplKt$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compare;
            compare = Intrinsics.compare(((Invalidation) obj).getLocation(), ((Invalidation) obj2).getLocation());
            return compare;
        }
    };
    public static final int nodeKey = 125;
    public static final int rootKey = 100;

    public static final /* synthetic */ boolean access$asBool(int i) {
        return asBool(i);
    }

    public static final /* synthetic */ int access$asInt(boolean z) {
        return asInt(z);
    }

    public static final /* synthetic */ List access$collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        return collectNodesFrom(slotTable, anchor);
    }

    public static final /* synthetic */ int access$findInsertLocation(List list, int i) {
        return findInsertLocation(list, i);
    }

    public static final /* synthetic */ Invalidation access$firstInRange(List list, int i, int i2) {
        return firstInRange(list, i, i2);
    }

    public static final /* synthetic */ Comparator access$getInvalidationLocationAscending$p() {
        return InvalidationLocationAscending;
    }

    public static final /* synthetic */ Object access$getJoinedKey(KeyInfo keyInfo) {
        return getJoinedKey(keyInfo);
    }

    public static final /* synthetic */ Object access$getKey(Object obj, Object obj2, Object obj3) {
        return getKey(obj, obj2, obj3);
    }

    public static final /* synthetic */ void access$insertIfMissing(List list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        insertIfMissing(list, i, recomposeScopeImpl, obj);
    }

    public static final /* synthetic */ MutableScatterMap access$multiMap(int i) {
        return multiMap(i);
    }

    public static final /* synthetic */ int access$nearestCommonRootOf(SlotReader slotReader, int i, int i2, int i3) {
        return nearestCommonRootOf(slotReader, i, i2, i3);
    }

    public static final /* synthetic */ Invalidation access$removeLocation(List list, int i) {
        return removeLocation(list, i);
    }

    public static final /* synthetic */ void access$removeRange(List list, int i, int i2) {
        removeRange(list, i, i2);
    }

    public static final boolean asBool(int i) {
        return i != 0;
    }

    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    public static final void deactivateCurrentGroup(final SlotWriter slotWriter, final RememberManager rememberManager) {
        slotWriter.forAllDataInRememberOrder(slotWriter.getCurrentGroup(), new Function2() { // from class: androidx.compose.runtime.ComposerImplKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ComposerImplKt.deactivateCurrentGroup$lambda$0(RememberManager.this, slotWriter, ((Integer) obj).intValue(), obj2);
            }
        });
    }

    public static final Unit deactivateCurrentGroup$lambda$0(RememberManager rememberManager, SlotWriter slotWriter, int i, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            rememberManager.deactivating((ComposeNodeLifecycleCallback) obj);
        } else if (!(obj instanceof ReusableRememberObserverHolder)) {
            if (obj instanceof RememberObserverHolder) {
                removeData(slotWriter, i, obj);
                rememberManager.forgetting((RememberObserverHolder) obj);
            } else if (obj instanceof RecomposeScopeImpl) {
                removeData(slotWriter, i, obj);
                ((RecomposeScopeImpl) obj).release();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void removeData(SlotWriter slotWriter, int i, Object obj) {
        Object clear = slotWriter.clear(i);
        if (obj == clear) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Slot table is out of sync (expected " + obj + ", got " + clear + ')');
    }

    public static final <K, V> MutableScatterMap<Object, Object> multiMap(int i) {
        return MultiValueMap.m4120constructorimpl(new MutableScatterMap(i));
    }

    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey != null) {
            if (Intrinsics.areEqual(joinedKey.getLeft(), obj2) && Intrinsics.areEqual(joinedKey.getRight(), obj3)) {
                return obj;
            }
            Object key = getKey(joinedKey.getLeft(), obj2, obj3);
            return key == null ? getKey(joinedKey.getRight(), obj2, obj3) : key;
        }
        return null;
    }

    private static final int findLocation(List<Invalidation> list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int compare = Intrinsics.compare(list.get(i3).getLocation(), i);
            if (compare < 0) {
                i2 = i3 + 1;
            } else if (compare <= 0) {
                return i3;
            } else {
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findInsertLocation(List<Invalidation> list, int i) {
        int findLocation = findLocation(list, i);
        return findLocation < 0 ? -(findLocation + 1) : findLocation;
    }

    public static final void insertIfMissing(List<Invalidation> list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int findLocation = findLocation(list, i);
        if (findLocation < 0) {
            int i2 = -(findLocation + 1);
            if (!(obj instanceof DerivedState)) {
                obj = null;
            }
            list.add(i2, new Invalidation(recomposeScopeImpl, i, obj));
            return;
        }
        Invalidation invalidation = list.get(findLocation);
        if (obj instanceof DerivedState) {
            Object instances = invalidation.getInstances();
            if (instances == null) {
                invalidation.setInstances(obj);
                return;
            } else if (instances instanceof MutableScatterSet) {
                ((MutableScatterSet) instances).add(obj);
                return;
            } else {
                invalidation.setInstances(ScatterSetKt.mutableScatterSetOf(instances, obj));
                return;
            }
        }
        invalidation.setInstances(null);
    }

    public static final Invalidation firstInRange(List<Invalidation> list, int i, int i2) {
        int findInsertLocation = findInsertLocation(list, i);
        if (findInsertLocation < list.size()) {
            Invalidation invalidation = list.get(findInsertLocation);
            if (invalidation.getLocation() < i2) {
                return invalidation;
            }
            return null;
        }
        return null;
    }

    public static final Invalidation removeLocation(List<Invalidation> list, int i) {
        int findLocation = findLocation(list, i);
        if (findLocation >= 0) {
            return list.remove(findLocation);
        }
        return null;
    }

    public static final void removeRange(List<Invalidation> list, int i, int i2) {
        int findInsertLocation = findInsertLocation(list, i);
        while (findInsertLocation < list.size() && list.get(findInsertLocation).getLocation() < i2) {
            list.remove(findInsertLocation);
        }
    }

    private static final void forEachInRange(List<Invalidation> list, int i, int i2, Function1<? super Invalidation, Unit> function1) {
        for (int findInsertLocation = findInsertLocation(list, i); findInsertLocation < list.size(); findInsertLocation++) {
            Invalidation invalidation = list.get(findInsertLocation);
            if (invalidation.getLocation() >= i2) {
                return;
            }
            function1.invoke(invalidation);
        }
    }

    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader openReader = slotTable.openReader();
        try {
            collectNodesFrom$lambda$0$collectFromGroup(openReader, arrayList, slotTable.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            openReader.close();
        }
    }

    private static final void collectNodesFrom$lambda$0$collectFromGroup(SlotReader slotReader, List<Object> list, int i) {
        if (slotReader.isNode(i)) {
            list.add(slotReader.node(i));
            return;
        }
        int i2 = i + 1;
        int groupSize = i + slotReader.groupSize(i);
        while (i2 < groupSize) {
            collectNodesFrom$lambda$0$collectFromGroup(slotReader, list, i2);
            i2 += slotReader.groupSize(i2);
        }
    }

    private static final int distanceFrom(SlotReader slotReader, int i, int i2) {
        int i3 = 0;
        while (i > 0 && i != i2) {
            i = slotReader.parent(i);
            i3++;
        }
        return i3;
    }

    public static final int nearestCommonRootOf(SlotReader slotReader, int i, int i2, int i3) {
        if (i != i2) {
            if (i == i3 || i2 == i3) {
                return i3;
            }
            if (slotReader.parent(i) == i2) {
                return i2;
            }
            if (slotReader.parent(i2) != i) {
                if (slotReader.parent(i) == slotReader.parent(i2)) {
                    return slotReader.parent(i);
                }
                int distanceFrom = distanceFrom(slotReader, i, i3);
                int distanceFrom2 = distanceFrom(slotReader, i2, i3);
                int i4 = distanceFrom - distanceFrom2;
                for (int i5 = 0; i5 < i4; i5++) {
                    i = slotReader.parent(i);
                }
                int i6 = distanceFrom2 - distanceFrom;
                for (int i7 = 0; i7 < i6; i7++) {
                    i2 = slotReader.parent(i2);
                }
                while (i != i2) {
                    i = slotReader.parent(i);
                    i2 = slotReader.parent(i2);
                }
                return i;
            }
        }
        return i;
    }

    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }
}
