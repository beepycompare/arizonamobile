package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: ScopeMap.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001d\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0004\b\u001d\u0010\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b!\u0010\"J0\u0010#\u001a\u00020\u00132!\u0010$\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0004\b(\u0010)J;\u0010*\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002!\u0010$\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00130%H\u0086\b¢\u0006\u0004\b+\u0010,J;\u0010-\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00028\u00002!\u0010$\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001f0%H\u0086\b¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0013¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u001f¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u001f¢\u0006\u0004\b7\u00105JH\u00108\u001a\u00020\u001326\u0010$\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001309H\u0086\b¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b=\u0010\u0011J\u001d\u0010<\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001¢\u0006\u0004\b=\u0010>J5\u0010?\u001a\u00020\u00132#\b\u0004\u0010@\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001f0%H\u0086\b¢\u0006\u0004\bA\u0010)J*\u0010B\u001a\u00020\u00132\u0018\u0010@\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001f09H\u0086\b¢\u0006\u0004\bC\u0010;J\u0015\u0010D\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0001¢\u0006\u0004\bE\u0010FJ\u001f\u0010G\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010I0H¢\u0006\u0004\bJ\u0010KJ\u0014\u0010L\u001a\u00020\u001f2\b\u0010M\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010N\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010O\u001a\u00020PHÖ\u0081\u0004R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0088\u0001\u0004¨\u0006Q"}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize-impl", "(Landroidx/collection/MutableScatterMap;)I", "get", "key", "get-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "add", "", "scope", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "addAll", "Landroidx/collection/ScatterSet;", "addAll-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Landroidx/collection/ScatterSet;)V", "set", "value", "set-impl", "contains", "", "element", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "forEachKey", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachKey-impl", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function1;)V", "forEachScopeOf", "forEachScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "anyScopeOf", "anyScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "clear", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "isEmpty", "isEmpty-impl", "(Landroidx/collection/MutableScatterMap;)Z", "isNotEmpty", "isNotEmpty-impl", "forEach", "Lkotlin/Function2;", "forEach-impl", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "remove", "remove-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScopeIf", "predicate", "removeScopeIf-impl", "removeIf", "removeIf-impl", "removeScope", "removeScope-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)V", "asMap", "", "", "asMap-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/util/Map;", "equals", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ScopeMap<Key, Scope> {
    private final MutableScatterMap<Object, Object> map;

    /* renamed from: box-impl */
    public static final /* synthetic */ ScopeMap m4504boximpl(MutableScatterMap mutableScatterMap) {
        return new ScopeMap(mutableScatterMap);
    }

    /* renamed from: constructor-impl */
    public static <Key, Scope> MutableScatterMap<Object, Object> m4506constructorimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: equals-impl */
    public static boolean m4509equalsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return (obj instanceof ScopeMap) && Intrinsics.areEqual(mutableScatterMap, ((ScopeMap) obj).m4526unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m4510equalsimpl0(MutableScatterMap<Object, Object> mutableScatterMap, MutableScatterMap<Object, Object> mutableScatterMap2) {
        return Intrinsics.areEqual(mutableScatterMap, mutableScatterMap2);
    }

    /* renamed from: hashCode-impl */
    public static int m4516hashCodeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m4525toStringimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return "ScopeMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object obj) {
        return m4509equalsimpl(this.map, obj);
    }

    public int hashCode() {
        return m4516hashCodeimpl(this.map);
    }

    public String toString() {
        return m4525toStringimpl(this.map);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ MutableScatterMap m4526unboximpl() {
        return this.map;
    }

    private /* synthetic */ ScopeMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ MutableScatterMap m4507constructorimpl$default(MutableScatterMap mutableScatterMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            mutableScatterMap = ScatterMapKt.mutableScatterMapOf();
        }
        return m4506constructorimpl(mutableScatterMap);
    }

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    /* renamed from: getSize-impl */
    public static final int m4515getSizeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.getSize();
    }

    /* renamed from: get-impl */
    public static final Object m4514getimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key) {
        return mutableScatterMap.get(key);
    }

    /* renamed from: set-impl */
    public static final void m4524setimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        mutableScatterMap.set(key, scope);
    }

    /* renamed from: contains-impl */
    public static final boolean m4508containsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key) {
        return mutableScatterMap.containsKey(key);
    }

    /* renamed from: forEachKey-impl */
    public static final void m4512forEachKeyimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function1<? super Key, Unit> function1) {
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        Function1 function12 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1);
        Object[] objArr = mutableScatterMap2.keys;
        long[] jArr = mutableScatterMap2.metadata;
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
                        function12.invoke(objArr[(i << 3) + i3]);
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

    /* renamed from: forEachScopeOf-impl */
    public static final void m4513forEachScopeOfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Function1<? super Scope, Unit> function1) {
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
    public static final void m4505clearimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        mutableScatterMap.clear();
    }

    /* renamed from: isEmpty-impl */
    public static final boolean m4517isEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isEmpty();
    }

    /* renamed from: isNotEmpty-impl */
    public static final boolean m4518isNotEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isNotEmpty();
    }

    /* renamed from: forEach-impl */
    public static final void m4511forEachimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function2<? super Key, Object, Unit> function2) {
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
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
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                        function2.invoke(obj, obj2);
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

    /* renamed from: remove-impl */
    public static final Object m4519removeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key) {
        return mutableScatterMap.remove(key);
    }

    /* renamed from: remove-impl */
    public static final boolean m4520removeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
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
    public static final Map<Key, Set<Scope>> m4503asMapimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
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
    public static final void m4500addimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
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

    /* JADX WARN: Code restructure failed: missing block: B:42:0x003a, code lost:
        if (r1 != false) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.collection.MutableScatterSet] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.collection.MutableScatterSet] */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.collection.MutableScatterSet] */
    /* renamed from: addAll-impl */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4501addAllimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, ScatterSet<Scope> scatterSet) {
        Scope scope;
        int findInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = findInsertIndex < 0;
        Scope scope2 = z ? null : mutableScatterMap.values[findInsertIndex];
        if (scope2 == null) {
            ?? mutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSetOf.addAll(scatterSet);
            scope = mutableScatterSetOf;
        } else if (scope2 instanceof MutableScatterSet) {
            Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
            ?? r3 = (MutableScatterSet) scope2;
            r3.addAll(scatterSet);
            scope = r3;
        } else {
            Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
            if (scatterSet.getSize() == 1) {
                boolean contains = scatterSet.contains(scope2);
                scope = scope2;
            }
            ?? mutableScatterSetOf2 = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSetOf2.addAll(scatterSet);
            mutableScatterSetOf2.add(scope2);
            scope = mutableScatterSetOf2;
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
    public static final boolean m4502anyScopeOfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Function1<? super Scope, Boolean> function1) {
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
    public static final void m4523removeScopeIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function1<? super Scope, Boolean> function1) {
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

    /* renamed from: removeIf-impl */
    public static final void m4521removeIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function2<? super Key, ? super Scope, Boolean> function2) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        int i2;
        boolean booleanValue;
        long[] jArr3;
        long j3;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j4 = jArr4[i3];
            char c2 = 7;
            long j5 = -9187201950435737472L;
            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j4 & 255) < 128) {
                        int i7 = (i3 << 3) + i6;
                        c = c2;
                        Object obj = mutableScatterMap.keys[i7];
                        j2 = j5;
                        Object obj2 = mutableScatterMap.values[i7];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr5 = mutableScatterSet.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                j = j4;
                                int i8 = i4;
                                int i9 = 0;
                                while (true) {
                                    long j6 = jArr5[i9];
                                    Object[] objArr2 = objArr;
                                    i = i6;
                                    if ((((~j6) << c) & j6 & j2) != j2) {
                                        int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                        int i11 = 0;
                                        while (i11 < i10) {
                                            if ((j6 & 255) < 128) {
                                                jArr3 = jArr4;
                                                int i12 = (i9 << 3) + i11;
                                                j3 = j6;
                                                if (function2.invoke(obj, objArr2[i12]).booleanValue()) {
                                                    mutableScatterSet.removeElementAt(i12);
                                                }
                                            } else {
                                                jArr3 = jArr4;
                                                j3 = j6;
                                            }
                                            j6 = j3 >> i8;
                                            i11++;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        if (i10 != i8) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                    }
                                    if (i9 == length2) {
                                        break;
                                    }
                                    i9++;
                                    i6 = i;
                                    objArr = objArr2;
                                    jArr4 = jArr2;
                                    i8 = 8;
                                }
                            } else {
                                jArr2 = jArr4;
                                j = j4;
                                i = i6;
                            }
                            booleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr4;
                            j = j4;
                            i = i6;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                            booleanValue = function2.invoke(obj, obj2).booleanValue();
                        }
                        if (booleanValue) {
                            mutableScatterMap.removeValueAt(i7);
                        }
                        i2 = 8;
                    } else {
                        jArr2 = jArr4;
                        j = j4;
                        c = c2;
                        j2 = j5;
                        i = i6;
                        i2 = i4;
                    }
                    j4 = j >> i2;
                    i6 = i + 1;
                    i4 = i2;
                    c2 = c;
                    j5 = j2;
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
    public static final void m4522removeScopeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Scope scope) {
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
