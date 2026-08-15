package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.l8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0398l8 {
    public static final C0372k8 b;
    public static final EnumC0398l8 c;
    public static final EnumC0398l8 d;
    public static final EnumC0398l8 e;
    public static final EnumC0398l8 f;
    public static final /* synthetic */ EnumC0398l8[] g;

    /* renamed from: a  reason: collision with root package name */
    public final String f1078a;

    static {
        EnumC0398l8 enumC0398l8 = new EnumC0398l8(0, "UNDEFINED", "UNDEFINED");
        c = enumC0398l8;
        EnumC0398l8 enumC0398l82 = new EnumC0398l8(1, "APP", "APP");
        d = enumC0398l82;
        EnumC0398l8 enumC0398l83 = new EnumC0398l8(2, "SATELLITE", "SATELLITE");
        e = enumC0398l83;
        EnumC0398l8 enumC0398l84 = new EnumC0398l8(3, "RETAIL", "RETAIL");
        f = enumC0398l84;
        EnumC0398l8[] enumC0398l8Arr = {enumC0398l8, enumC0398l82, enumC0398l83, enumC0398l84};
        g = enumC0398l8Arr;
        EnumEntriesKt.enumEntries(enumC0398l8Arr);
        b = new C0372k8();
    }

    public EnumC0398l8(int i, String str, String str2) {
        this.f1078a = str2;
    }

    public static EnumC0398l8 valueOf(String str) {
        return (EnumC0398l8) Enum.valueOf(EnumC0398l8.class, str);
    }

    public static EnumC0398l8[] values() {
        return (EnumC0398l8[]) g.clone();
    }
}
