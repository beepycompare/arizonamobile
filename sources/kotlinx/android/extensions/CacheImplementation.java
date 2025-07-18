package kotlinx.android.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CacheImplementation.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "<init>", "(Ljava/lang/String;I)V", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "Companion", "kotlin-android-extensions-runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CacheImplementation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CacheImplementation[] $VALUES;
    public static final Companion Companion;
    private static final CacheImplementation DEFAULT;
    public static final CacheImplementation HASH_MAP;
    public static final CacheImplementation NO_CACHE;
    public static final CacheImplementation SPARSE_ARRAY = new CacheImplementation("SPARSE_ARRAY", 0);

    private static final /* synthetic */ CacheImplementation[] $values() {
        return new CacheImplementation[]{SPARSE_ARRAY, HASH_MAP, NO_CACHE};
    }

    public static EnumEntries<CacheImplementation> getEntries() {
        return $ENTRIES;
    }

    public static CacheImplementation valueOf(String str) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, str);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }

    private CacheImplementation(String str, int i) {
    }

    static {
        CacheImplementation cacheImplementation = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = cacheImplementation;
        NO_CACHE = new CacheImplementation("NO_CACHE", 2);
        CacheImplementation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        DEFAULT = cacheImplementation;
    }

    /* compiled from: CacheImplementation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation$Companion;", "", "<init>", "()V", "DEFAULT", "Lkotlinx/android/extensions/CacheImplementation;", "getDEFAULT", "()Lkotlinx/android/extensions/CacheImplementation;", "kotlin-android-extensions-runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CacheImplementation getDEFAULT() {
            return CacheImplementation.DEFAULT;
        }
    }
}
