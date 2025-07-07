package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ScopeMap.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001d\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00028\u00002!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001e0\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b&\u0010'J\u001a\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b*\u0010'J;\u0010+\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\u0017H\u0086\b¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b/\u0010\rJ\u001d\u00100\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b4\u00105J5\u00106\u001a\u00020\u000f2#\b\u0004\u00107\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\b¢\u0006\u0004\b8\u00109J\u001d\u0010:\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010;\u001a\u00028\u0001¢\u0006\u0004\b<\u0010\u0013J\u0010\u0010=\u001a\u00020>HÖ\u0001¢\u0006\u0004\b?\u0010@R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0088\u0001\u0004¨\u0006A"}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize-impl", "(Landroidx/collection/MutableScatterMap;)I", "add", "", "key", "scope", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "anyScopeOf", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "anyScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "asMap", "", "", "asMap-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/util/Map;", "clear", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "contains", "element", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "equals", "other", "equals-impl", "forEachScopeOf", "forEachScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "hashCode-impl", "remove", "remove-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "removeScope-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)V", "removeScopeIf", "predicate", "removeScopeIf-impl", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function1;)V", "set", "value", "set-impl", "toString", "", "toString-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ScopeMap<Key, Scope> {
    private final MutableScatterMap<Object, Object> map;

    /* renamed from: box-impl */
    public static final /* synthetic */ ScopeMap m3617boximpl(MutableScatterMap mutableScatterMap) {
        return new ScopeMap(mutableScatterMap);
    }

    /* renamed from: constructor-impl */
    public static <Key, Scope> MutableScatterMap<Object, Object> m3619constructorimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: equals-impl */
    public static boolean m3622equalsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return (obj instanceof ScopeMap) && Intrinsics.areEqual(mutableScatterMap, ((ScopeMap) obj).m3632unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m3623equalsimpl0(MutableScatterMap<Object, Object> mutableScatterMap, MutableScatterMap<Object, Object> mutableScatterMap2) {
        return Intrinsics.areEqual(mutableScatterMap, mutableScatterMap2);
    }

    /* renamed from: hashCode-impl */
    public static int m3626hashCodeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m3631toStringimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return "ScopeMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object obj) {
        return m3622equalsimpl(this.map, obj);
    }

    public int hashCode() {
        return m3626hashCodeimpl(this.map);
    }

    public String toString() {
        return m3631toStringimpl(this.map);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ MutableScatterMap m3632unboximpl() {
        return this.map;
    }

    private /* synthetic */ ScopeMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ MutableScatterMap m3620constructorimpl$default(MutableScatterMap mutableScatterMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            mutableScatterMap = ScatterMapKt.mutableScatterMapOf();
        }
        return m3619constructorimpl(mutableScatterMap);
    }

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    /* renamed from: getSize-impl */
    public static final int m3625getSizeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.getSize();
    }

    /* renamed from: set-impl */
    public static final void m3630setimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        mutableScatterMap.set(key, scope);
    }

    /* renamed from: contains-impl */
    public static final boolean m3621containsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key) {
        return mutableScatterMap.containsKey(key);
    }

    /* renamed from: forEachScopeOf-impl */
    public static final void m3624forEachScopeOfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Function1<? super Scope, Unit> function1) {
        Object obj = mutableScatterMap.get(key);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            function1.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                }
                i++;
            }
        } else {
            function1.invoke(obj);
        }
    }

    /* renamed from: clear-impl */
    public static final void m3618clearimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        mutableScatterMap.clear();
    }

    /* renamed from: remove-impl */
    public static final boolean m3627removeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        Object obj = mutableScatterMap.get(key);
        if (obj == null) {
            return false;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            boolean remove = mutableScatterSet.remove(scope);
            if (remove && mutableScatterSet.isEmpty()) {
                mutableScatterMap.remove(key);
            }
            return remove;
        } else if (Intrinsics.areEqual(obj, scope)) {
            mutableScatterMap.remove(key);
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: asMap-impl */
    public static final Map<Key, Set<Scope>> m3616asMapimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        Set mutableSetOf;
        HashMap hashMap = new HashMap();
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            Object obj2 = objArr2[i4];
                            HashMap hashMap2 = hashMap;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                mutableSetOf = ((MutableScatterSet) obj2).asSet();
                            } else {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                mutableSetOf = SetsKt.mutableSetOf(obj2);
                            }
                            hashMap2.put(obj, mutableSetOf);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.collection.MutableScatterSet] */
    /* renamed from: add-impl */
    public static final void m3614addimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        int findInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = findInsertIndex < 0;
        Scope scope2 = z ? null : mutableScatterMap.values[findInsertIndex];
        if (scope2 != null) {
            if (scope2 instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                ((MutableScatterSet) scope2).add(scope);
            } else if (scope2 != scope) {
                ?? mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                mutableScatterSet.add(scope2);
                mutableScatterSet.add(scope);
                scope = mutableScatterSet;
            }
            scope = scope2;
        }
        if (z) {
            int i = ~findInsertIndex;
            mutableScatterMap.keys[i] = key;
            mutableScatterMap.values[i] = scope;
            return;
        }
        mutableScatterMap.values[findInsertIndex] = scope;
    }

    /* renamed from: anyScopeOf-impl */
    public static final boolean m3615anyScopeOfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Function1<? super Scope, Boolean> function1) {
        Object obj = mutableScatterMap.get(key);
        if (obj != null) {
            if (obj instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128 && function1.invoke(objArr[(i << 3) + i3]).booleanValue()) {
                                    return true;
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                }
            } else if (function1.invoke(obj).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: removeScopeIf-impl */
    public static final void m3629removeScopeIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function1<? super Scope, Boolean> function1) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean booleanValue;
        MutableScatterSet mutableScatterSet;
        long[] jArr3;
        int i2;
        MutableScatterSet mutableScatterSet2;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr4[i3];
            char c2 = 7;
            long j4 = -9187201950435737472L;
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j3 & 255) < 128) {
                        int i7 = (i3 << 3) + i6;
                        c = c2;
                        Object obj = mutableScatterMap.keys[i7];
                        Object obj2 = mutableScatterMap.values[i7];
                        j2 = j4;
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet3.elements;
                            long[] jArr5 = mutableScatterSet3.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                int i8 = i4;
                                MutableScatterSet mutableScatterSet4 = mutableScatterSet3;
                                int i9 = 0;
                                while (true) {
                                    long j5 = jArr5[i9];
                                    j = j3;
                                    if ((((~j5) << c) & j5 & j2) != j2) {
                                        int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                        int i11 = 0;
                                        while (i11 < i10) {
                                            if ((j5 & 255) < 128) {
                                                jArr3 = jArr4;
                                                int i12 = (i9 << 3) + i11;
                                                i2 = i11;
                                                if (function1.invoke(objArr[i12]).booleanValue()) {
                                                    mutableScatterSet2 = mutableScatterSet4;
                                                    mutableScatterSet2.removeElementAt(i12);
                                                    j5 >>= i8;
                                                    mutableScatterSet4 = mutableScatterSet2;
                                                    i11 = i2 + 1;
                                                    jArr4 = jArr3;
                                                }
                                            } else {
                                                jArr3 = jArr4;
                                                i2 = i11;
                                            }
                                            mutableScatterSet2 = mutableScatterSet4;
                                            j5 >>= i8;
                                            mutableScatterSet4 = mutableScatterSet2;
                                            i11 = i2 + 1;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                        if (i10 != i8) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                    }
                                    if (i9 == length2) {
                                        break;
                                    }
                                    i9++;
                                    mutableScatterSet4 = mutableScatterSet;
                                    j3 = j;
                                    jArr4 = jArr2;
                                    i8 = 8;
                                }
                            } else {
                                jArr2 = jArr4;
                                j = j3;
                                mutableScatterSet = mutableScatterSet3;
                            }
                            booleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr4;
                            j = j3;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                            booleanValue = function1.invoke(obj2).booleanValue();
                        }
                        if (booleanValue) {
                            mutableScatterMap.removeValueAt(i7);
                        }
                        i = 8;
                    } else {
                        jArr2 = jArr4;
                        j = j3;
                        c = c2;
                        j2 = j4;
                        i = i4;
                    }
                    j3 = j >> i;
                    i6++;
                    i4 = i;
                    c2 = c;
                    j4 = j2;
                    jArr4 = jArr2;
                }
                jArr = jArr4;
                if (i5 != i4) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i3 == length) {
                return;
            }
            i3++;
            jArr4 = jArr;
        }
    }

    /* renamed from: removeScope-impl */
    public static final void m3628removeScopeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Scope scope) {
        boolean z;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = mutableScatterMap.keys[i4];
                        Object obj2 = mutableScatterMap.values[i4];
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            mutableScatterSet.remove(scope);
                            z = mutableScatterSet.isEmpty();
                        } else {
                            z = obj2 == scope;
                        }
                        if (z) {
                            mutableScatterMap.removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }
}
