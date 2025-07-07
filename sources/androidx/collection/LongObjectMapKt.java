package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LongObjectMap.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\u001aD\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aL\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0011\u001a7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0014\u001aG\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0017\u001aW\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u0002H\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001a\u001ag\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u0002H\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u0002H\u00052\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001d\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001f\u001a7\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u0005¢\u0006\u0002\u0010 \u001aG\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u0002H\u0005¢\u0006\u0002\u0010!\u001aW\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u0002H\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u0002H\u0005¢\u0006\u0002\u0010\"\u001ag\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u0002H\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u0002H\u00052\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u0002H\u0005¢\u0006\u0002\u0010#\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"EmptyLongObjectMap", "Landroidx/collection/MutableLongObjectMap;", "", "buildLongObjectMap", "Landroidx/collection/LongObjectMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "emptyLongObjectMap", "longObjectMapOf", "key1", "", "value1", "(JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key2", "value2", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key3", "value3", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key4", "value4", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key5", "value5", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "mutableLongObjectMapOf", "(JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LongObjectMapKt {
    private static final MutableLongObjectMap EmptyLongObjectMap = new MutableLongObjectMap(0);

    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        Intrinsics.checkNotNull(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        Intrinsics.checkNotNull(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2, long j3, V v3) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4, long j5, V v5) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        mutableLongObjectMap.set(j5, v5);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap<>(0, 1, null);
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2, long j3, V v3) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4, long j5, V v5) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        mutableLongObjectMap.set(j5, v5);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> buildLongObjectMap(Function1<? super MutableLongObjectMap<V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        builderAction.invoke(mutableLongObjectMap);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> buildLongObjectMap(int i, Function1<? super MutableLongObjectMap<V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(i);
        builderAction.invoke(mutableLongObjectMap);
        return mutableLongObjectMap;
    }
}
