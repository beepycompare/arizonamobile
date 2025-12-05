package androidx.datastore.preferences.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Preferences.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH¦\u0002J$\u0010\t\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH¦\u0002¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00010\fH&J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0000¨\u0006\u0012"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "", "<init>", "()V", "contains", "", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "get", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "asMap", "", "toMutablePreferences", "Landroidx/datastore/preferences/core/MutablePreferences;", "toPreferences", "Key", "Pair", "datastore-preferences-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Preferences {
    public abstract Map<Key<?>, Object> asMap();

    public abstract <T> boolean contains(Key<T> key);

    public abstract <T> T get(Key<T> key);

    /* compiled from: Preferences.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$Key;", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", TypedValues.TransitionType.S_TO, "Landroidx/datastore/preferences/core/Preferences$Pair;", "value", "(Ljava/lang/Object;)Landroidx/datastore/preferences/core/Preferences$Pair;", "equals", "", "other", "hashCode", "", "toString", "datastore-preferences-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Key<T> {
        private final String name;

        public Key(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }

        public final Pair<T> to(T t) {
            return new Pair<>(this, t);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return Intrinsics.areEqual(this.name, ((Key) obj).name);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return this.name;
        }
    }

    /* compiled from: Preferences.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00028\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$Pair;", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "value", "<init>", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)V", "getKey$datastore_preferences_core", "()Landroidx/datastore/preferences/core/Preferences$Key;", "getValue$datastore_preferences_core", "()Ljava/lang/Object;", "Ljava/lang/Object;", "datastore-preferences-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Pair<T> {
        private final Key<T> key;
        private final T value;

        public Pair(Key<T> key, T t) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.value = t;
        }

        public final Key<T> getKey$datastore_preferences_core() {
            return this.key;
        }

        public final T getValue$datastore_preferences_core() {
            return this.value;
        }
    }

    public final MutablePreferences toMutablePreferences() {
        return new MutablePreferences(MapsKt.toMutableMap(asMap()), false);
    }

    public final Preferences toPreferences() {
        return new MutablePreferences(MapsKt.toMutableMap(asMap()), true);
    }
}
