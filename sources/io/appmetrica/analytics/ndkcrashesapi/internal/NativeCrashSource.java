package io.appmetrica.analytics.ndkcrashesapi.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashSource;", "", "UNKNOWN", "CRASHPAD", "ndkcrashes-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class NativeCrashSource {
    public static final NativeCrashSource CRASHPAD;
    public static final NativeCrashSource UNKNOWN;

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ NativeCrashSource[] f1365a;
    private static final /* synthetic */ EnumEntries b;

    static {
        NativeCrashSource nativeCrashSource = new NativeCrashSource("UNKNOWN", 0);
        UNKNOWN = nativeCrashSource;
        NativeCrashSource nativeCrashSource2 = new NativeCrashSource("CRASHPAD", 1);
        CRASHPAD = nativeCrashSource2;
        NativeCrashSource[] nativeCrashSourceArr = {nativeCrashSource, nativeCrashSource2};
        f1365a = nativeCrashSourceArr;
        b = EnumEntriesKt.enumEntries(nativeCrashSourceArr);
    }

    private NativeCrashSource(String str, int i) {
    }

    public static EnumEntries<NativeCrashSource> getEntries() {
        return b;
    }

    public static NativeCrashSource valueOf(String str) {
        return (NativeCrashSource) Enum.valueOf(NativeCrashSource.class, str);
    }

    public static NativeCrashSource[] values() {
        return (NativeCrashSource[]) f1365a.clone();
    }
}
