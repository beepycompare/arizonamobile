package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class M {

    /* renamed from: a  reason: collision with root package name */
    public static final M f656a;
    public static final M b;
    public static final M c;
    public static final M d;
    public static final /* synthetic */ M[] e;

    static {
        M m = new M("ALLOWED", 0);
        f656a = m;
        M m2 = new M("FORBIDDEN_BY_CLIENT_CONFIG", 1);
        b = m2;
        M m3 = new M("FORBIDDEN_BY_REMOTE_CONFIG", 2);
        c = m3;
        M m4 = new M("UNKNOWN", 3);
        d = m4;
        M[] mArr = {m, m2, m3, m4};
        e = mArr;
        EnumEntriesKt.enumEntries(mArr);
    }

    public M(String str, int i) {
    }

    public static M valueOf(String str) {
        return (M) Enum.valueOf(M.class, str);
    }

    public static M[] values() {
        return (M[]) e.clone();
    }
}
