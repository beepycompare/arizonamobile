package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.l8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0397l8 {
    public static final C0371k8 b;
    public static final EnumC0397l8 c;
    public static final EnumC0397l8 d;
    public static final EnumC0397l8 e;
    public static final EnumC0397l8 f;
    public static final /* synthetic */ EnumC0397l8[] g;

    /* renamed from: a  reason: collision with root package name */
    public final String f1078a;

    static {
        EnumC0397l8 enumC0397l8 = new EnumC0397l8(0, "UNDEFINED", "UNDEFINED");
        c = enumC0397l8;
        EnumC0397l8 enumC0397l82 = new EnumC0397l8(1, "APP", "APP");
        d = enumC0397l82;
        EnumC0397l8 enumC0397l83 = new EnumC0397l8(2, "SATELLITE", "SATELLITE");
        e = enumC0397l83;
        EnumC0397l8 enumC0397l84 = new EnumC0397l8(3, "RETAIL", "RETAIL");
        f = enumC0397l84;
        EnumC0397l8[] enumC0397l8Arr = {enumC0397l8, enumC0397l82, enumC0397l83, enumC0397l84};
        g = enumC0397l8Arr;
        EnumEntriesKt.enumEntries(enumC0397l8Arr);
        b = new C0371k8();
    }

    public EnumC0397l8(int i, String str, String str2) {
        this.f1078a = str2;
    }

    public static EnumC0397l8 valueOf(String str) {
        return (EnumC0397l8) Enum.valueOf(EnumC0397l8.class, str);
    }

    public static EnumC0397l8[] values() {
        return (EnumC0397l8[]) g.clone();
    }
}
