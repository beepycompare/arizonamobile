package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0218ea {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0218ea f963a;
    public static final EnumC0218ea b;
    public static final EnumC0218ea c;
    public static final EnumC0218ea d;
    public static final EnumC0218ea e;
    public static final EnumC0218ea f;
    public static final /* synthetic */ EnumC0218ea[] g;

    static {
        EnumC0218ea enumC0218ea = new EnumC0218ea("UNKNOWN", 0);
        EnumC0218ea enumC0218ea2 = new EnumC0218ea("APPSFLYER", 1);
        f963a = enumC0218ea2;
        EnumC0218ea enumC0218ea3 = new EnumC0218ea("ADJUST", 2);
        b = enumC0218ea3;
        EnumC0218ea enumC0218ea4 = new EnumC0218ea("KOCHAVA", 3);
        c = enumC0218ea4;
        EnumC0218ea enumC0218ea5 = new EnumC0218ea("TENJIN", 4);
        d = enumC0218ea5;
        EnumC0218ea enumC0218ea6 = new EnumC0218ea("AIRBRIDGE", 5);
        e = enumC0218ea6;
        EnumC0218ea enumC0218ea7 = new EnumC0218ea("SINGULAR", 6);
        f = enumC0218ea7;
        EnumC0218ea[] enumC0218eaArr = {enumC0218ea, enumC0218ea2, enumC0218ea3, enumC0218ea4, enumC0218ea5, enumC0218ea6, enumC0218ea7};
        g = enumC0218eaArr;
        EnumEntriesKt.enumEntries(enumC0218eaArr);
    }

    public EnumC0218ea(String str, int i) {
    }

    public static EnumC0218ea valueOf(String str) {
        return (EnumC0218ea) Enum.valueOf(EnumC0218ea.class, str);
    }

    public static EnumC0218ea[] values() {
        return (EnumC0218ea[]) g.clone();
    }
}
