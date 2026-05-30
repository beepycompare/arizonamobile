package io.appmetrica.analytics.idsync.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class A {
    public static final z b;
    public static final A c;
    public static final A d;
    public static final A e;
    public static final /* synthetic */ A[] f;

    /* renamed from: a  reason: collision with root package name */
    public final String f413a;

    static {
        A a2 = new A("NONE", 0, "none");
        c = a2;
        A a3 = new A("SUCCESS", 1, FirebaseAnalytics.Param.SUCCESS);
        d = a3;
        A a4 = new A("INCOMPATIBLE_PRECONDITION", 2, "incompatible_precondition");
        A a5 = new A("FAILURE", 3, "failure");
        e = a5;
        A[] aArr = {a2, a3, a4, a5};
        f = aArr;
        EnumEntriesKt.enumEntries(aArr);
        b = new z();
    }

    public A(String str, int i, String str2) {
        this.f413a = str2;
    }

    public static A valueOf(String str) {
        return (A) Enum.valueOf(A.class, str);
    }

    public static A[] values() {
        return (A[]) f.clone();
    }
}
