package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.l8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0392l8 {
    public static final C0366k8 b;
    public static final EnumC0392l8 c;
    public static final EnumC0392l8 d;
    public static final EnumC0392l8 e;
    public static final EnumC0392l8 f;
    public static final /* synthetic */ EnumC0392l8[] g;

    /* renamed from: a  reason: collision with root package name */
    public final String f1081a;

    static {
        EnumC0392l8 enumC0392l8 = new EnumC0392l8(0, "UNDEFINED", "UNDEFINED");
        c = enumC0392l8;
        EnumC0392l8 enumC0392l82 = new EnumC0392l8(1, "APP", "APP");
        d = enumC0392l82;
        EnumC0392l8 enumC0392l83 = new EnumC0392l8(2, "SATELLITE", "SATELLITE");
        e = enumC0392l83;
        EnumC0392l8 enumC0392l84 = new EnumC0392l8(3, "RETAIL", "RETAIL");
        f = enumC0392l84;
        EnumC0392l8[] enumC0392l8Arr = {enumC0392l8, enumC0392l82, enumC0392l83, enumC0392l84};
        g = enumC0392l8Arr;
        EnumEntriesKt.enumEntries(enumC0392l8Arr);
        b = new C0366k8();
    }

    public EnumC0392l8(int i, String str, String str2) {
        this.f1081a = str2;
    }

    public static EnumC0392l8 valueOf(String str) {
        return (EnumC0392l8) Enum.valueOf(EnumC0392l8.class, str);
    }

    public static EnumC0392l8[] values() {
        return (EnumC0392l8[]) g.clone();
    }
}
