package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: Preferences.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0013\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0004H\u0096\u0002J$\u0010\u0016\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0019H\u0016J*\u0010\u001a\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\u0006\u0010\u001b\u001a\u0002H\u0014H\u0086\u0002¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\u00020\u000f2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u001eJ\u0011\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0001H\u0086\u0002J\u0015\u0010\u001f\u001a\u00020\u000f2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0086\u0002J\u0015\u0010#\u001a\u00020\u000f2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\u0002J'\u0010$\u001a\u00020\u000f2\u001a\u0010%\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\"0&\"\u0006\u0012\u0002\b\u00030\"¢\u0006\u0002\u0010'J\u001f\u0010(\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0004¢\u0006\u0002\u0010\u0017J\u0006\u0010)\u001a\u00020\u000fJ\u0013\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016R$\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "Landroidx/datastore/preferences/core/Preferences;", "preferencesMap", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "startFrozen", "", "<init>", "(Ljava/util/Map;Z)V", "getPreferencesMap$datastore_preferences_core", "()Ljava/util/Map;", "frozen", "Landroidx/datastore/preferences/core/AtomicBoolean;", "checkNotFrozen", "", "checkNotFrozen$datastore_preferences_core", "freeze", "freeze$datastore_preferences_core", "contains", ExifInterface.GPS_DIRECTION_TRUE, "key", "get", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "asMap", "", "set", "value", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)V", "setUnchecked", "setUnchecked$datastore_preferences_core", "plusAssign", "prefs", "pair", "Landroidx/datastore/preferences/core/Preferences$Pair;", "minusAssign", "putAll", "pairs", "", "([Landroidx/datastore/preferences/core/Preferences$Pair;)V", "remove", "clear", "equals", "other", "hashCode", "", "toString", "", "datastore-preferences-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    public MutablePreferences() {
        this(null, false, 3, null);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> preferencesMap, boolean z) {
        Intrinsics.checkNotNullParameter(preferencesMap, "preferencesMap");
        this.preferencesMap = preferencesMap;
        this.frozen = new AtomicBoolean(z);
    }

    public /* synthetic */ MutablePreferences(LinkedHashMap linkedHashMap, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 2) != 0 ? true : z);
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core() {
        return this.preferencesMap;
    }

    public final void checkNotFrozen$datastore_preferences_core() {
        if (this.frozen.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final void freeze$datastore_preferences_core() {
        this.frozen.set(true);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public <T> boolean contains(Preferences.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.preferencesMap.containsKey(key);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public <T> T get(Preferences.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this.preferencesMap.get(key);
        if (t instanceof byte[]) {
            byte[] bArr = (byte[]) t;
            T t2 = (T) Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(t2, "copyOf(...)");
            return t2;
        }
        return t;
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public Map<Preferences.Key<?>, Object> asMap() {
        Pair pair;
        Set<Map.Entry<Preferences.Key<?>, Object>> entrySet = this.preferencesMap.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                pair = new Pair(key, copyOf);
            } else {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return Actual_jvmAndroidKt.immutableMap(linkedHashMap);
    }

    public final <T> void set(Preferences.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        setUnchecked$datastore_preferences_core(key, t);
    }

    public final void setUnchecked$datastore_preferences_core(Preferences.Key<?> key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        checkNotFrozen$datastore_preferences_core();
        if (obj == null) {
            remove(key);
        } else if (obj instanceof Set) {
            this.preferencesMap.put(key, Actual_jvmAndroidKt.immutableCopyOfSet((Set) obj));
        } else if (!(obj instanceof byte[])) {
            this.preferencesMap.put(key, obj);
        } else {
            Map<Preferences.Key<?>, Object> map = this.preferencesMap;
            byte[] bArr = (byte[]) obj;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            map.put(key, copyOf);
        }
    }

    public final void plusAssign(Preferences prefs) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        checkNotFrozen$datastore_preferences_core();
        this.preferencesMap.putAll(prefs.asMap());
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        checkNotFrozen$datastore_preferences_core();
        putAll(pair);
    }

    public final void minusAssign(Preferences.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        checkNotFrozen$datastore_preferences_core();
        remove(key);
    }

    public final void putAll(Preferences.Pair<?>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        checkNotFrozen$datastore_preferences_core();
        for (Preferences.Pair<?> pair : pairs) {
            setUnchecked$datastore_preferences_core(pair.getKey$datastore_preferences_core(), pair.getValue$datastore_preferences_core());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        checkNotFrozen$datastore_preferences_core();
        return (T) this.preferencesMap.remove(key);
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core();
        this.preferencesMap.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean z;
        if (obj instanceof MutablePreferences) {
            MutablePreferences mutablePreferences = (MutablePreferences) obj;
            Map<Preferences.Key<?>, Object> map = mutablePreferences.preferencesMap;
            if (map == this.preferencesMap) {
                return true;
            }
            if (map.size() != this.preferencesMap.size()) {
                return false;
            }
            Map<Preferences.Key<?>, Object> map2 = mutablePreferences.preferencesMap;
            if (map2.isEmpty()) {
                return true;
            }
            for (Map.Entry<Preferences.Key<?>, Object> entry : map2.entrySet()) {
                Object obj2 = this.preferencesMap.get(entry.getKey());
                if (obj2 != null) {
                    Object value = entry.getValue();
                    if (!(value instanceof byte[])) {
                        z = Intrinsics.areEqual(value, obj2);
                        continue;
                    } else if ((obj2 instanceof byte[]) && Arrays.equals((byte[]) value, (byte[]) obj2)) {
                        z = true;
                        continue;
                    }
                    if (!z) {
                        return false;
                    }
                }
                z = false;
                continue;
                if (!z) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Iterator<T> it = this.preferencesMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            i += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return i;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", 0, null, new Function1() { // from class: androidx.datastore.preferences.core.MutablePreferences$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence string$lambda$0;
                string$lambda$0 = MutablePreferences.toString$lambda$0((Map.Entry) obj);
                return string$lambda$0;
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$0(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Object value = entry.getValue();
        return "  " + ((Preferences.Key) entry.getKey()).getName() + " = " + (value instanceof byte[] ? ArraysKt.joinToString$default((byte[]) value, (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null) : String.valueOf(entry.getValue()));
    }
}
