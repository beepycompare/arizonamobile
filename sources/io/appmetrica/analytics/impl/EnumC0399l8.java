package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.l8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0399l8 {
    public static final C0373k8 b;
    public static final EnumC0399l8 c;
    public static final EnumC0399l8 d;
    public static final EnumC0399l8 e;
    public static final EnumC0399l8 f;
    public static final /* synthetic */ EnumC0399l8[] g;

    /* renamed from: a  reason: collision with root package name */
    public final String f1075a;

    static {
        EnumC0399l8 enumC0399l8 = new EnumC0399l8(0, "UNDEFINED", "UNDEFINED");
        c = enumC0399l8;
        EnumC0399l8 enumC0399l82 = new EnumC0399l8(1, "APP", "APP");
        d = enumC0399l82;
        EnumC0399l8 enumC0399l83 = new EnumC0399l8(2, "SATELLITE", "SATELLITE");
        e = enumC0399l83;
        EnumC0399l8 enumC0399l84 = new EnumC0399l8(3, "RETAIL", "RETAIL");
        f = enumC0399l84;
        EnumC0399l8[] enumC0399l8Arr = {enumC0399l8, enumC0399l82, enumC0399l83, enumC0399l84};
        g = enumC0399l8Arr;
        EnumEntriesKt.enumEntries(enumC0399l8Arr);
        b = new C0373k8();
    }

    public EnumC0399l8(int i, String str, String str2) {
        this.f1075a = str2;
    }

    public static EnumC0399l8 valueOf(String str) {
        return (EnumC0399l8) Enum.valueOf(EnumC0399l8.class, str);
    }

    public static EnumC0399l8[] values() {
        return (EnumC0399l8[]) g.clone();
    }
}
