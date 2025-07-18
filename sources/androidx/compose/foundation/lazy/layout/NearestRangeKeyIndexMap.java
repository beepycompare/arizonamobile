package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
/* compiled from: LazyLayoutKeyIndexMap.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\fH\u0016R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", UserMetadata.KEYDATA_FILENAME, "", "", "[Ljava/lang/Object;", "keysStartIndex", "", "map", "Landroidx/collection/ObjectIntMap;", "getIndex", "key", "getKey", FirebaseAnalytics.Param.INDEX, "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    public static final int $stable = 8;
    private final Object[] keys;
    private final int keysStartIndex;
    private final ObjectIntMap<Object> map;

    public NearestRangeKeyIndexMap(IntRange intRange, LazyLayoutIntervalContent<?> lazyLayoutIntervalContent) {
        IntervalList<?> intervals = lazyLayoutIntervalContent.getIntervals();
        final int first = intRange.getFirst();
        if (!(first >= 0)) {
            InlineClassHelperKt.throwIllegalStateException("negative nearestRange.first");
        }
        final int min = Math.min(intRange.getLast(), intervals.getSize() - 1);
        if (min < first) {
            this.map = ObjectIntMapKt.emptyObjectIntMap();
            this.keys = new Object[0];
            this.keysStartIndex = 0;
            return;
        }
        int i = (min - first) + 1;
        this.keys = new Object[i];
        this.keysStartIndex = first;
        final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i);
        intervals.forEach(first, min, new Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval> interval) {
                invoke2(interval);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
                if (r3 == null) goto L12;
             */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval> interval) {
                Object defaultLazyLayoutKey;
                Object[] objArr;
                int i2;
                Function1<Integer, Object> key = interval.getValue().getKey();
                int max = Math.max(first, interval.getStartIndex());
                int min2 = Math.min(min, (interval.getStartIndex() + interval.getSize()) - 1);
                if (max > min2) {
                    return;
                }
                while (true) {
                    if (key != null) {
                        defaultLazyLayoutKey = key.invoke(Integer.valueOf(max - interval.getStartIndex()));
                    }
                    defaultLazyLayoutKey = Lazy_androidKt.getDefaultLazyLayoutKey(max);
                    mutableObjectIntMap.set(defaultLazyLayoutKey, max);
                    objArr = this.keys;
                    i2 = this.keysStartIndex;
                    objArr[max - i2] = defaultLazyLayoutKey;
                    if (max == min2) {
                        return;
                    }
                    max++;
                }
            }
        });
        this.map = mutableObjectIntMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object obj) {
        ObjectIntMap<Object> objectIntMap = this.map;
        int findKeyIndex = objectIntMap.findKeyIndex(obj);
        if (findKeyIndex >= 0) {
            return objectIntMap.values[findKeyIndex];
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int i) {
        Object[] objArr = this.keys;
        int i2 = i - this.keysStartIndex;
        if (i2 < 0 || i2 > ArraysKt.getLastIndex(objArr)) {
            return null;
        }
        return objArr[i2];
    }
}
