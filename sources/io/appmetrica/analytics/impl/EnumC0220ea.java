package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0220ea {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0220ea f961a;
    public static final EnumC0220ea b;
    public static final EnumC0220ea c;
    public static final EnumC0220ea d;
    public static final EnumC0220ea e;
    public static final EnumC0220ea f;
    public static final /* synthetic */ EnumC0220ea[] g;

    static {
        EnumC0220ea enumC0220ea = new EnumC0220ea("UNKNOWN", 0);
        EnumC0220ea enumC0220ea2 = new EnumC0220ea("APPSFLYER", 1);
        f961a = enumC0220ea2;
        EnumC0220ea enumC0220ea3 = new EnumC0220ea("ADJUST", 2);
        b = enumC0220ea3;
        EnumC0220ea enumC0220ea4 = new EnumC0220ea("KOCHAVA", 3);
        c = enumC0220ea4;
        EnumC0220ea enumC0220ea5 = new EnumC0220ea("TENJIN", 4);
        d = enumC0220ea5;
        EnumC0220ea enumC0220ea6 = new EnumC0220ea("AIRBRIDGE", 5);
        e = enumC0220ea6;
        EnumC0220ea enumC0220ea7 = new EnumC0220ea("SINGULAR", 6);
        f = enumC0220ea7;
        EnumC0220ea[] enumC0220eaArr = {enumC0220ea, enumC0220ea2, enumC0220ea3, enumC0220ea4, enumC0220ea5, enumC0220ea6, enumC0220ea7};
        g = enumC0220eaArr;
        EnumEntriesKt.enumEntries(enumC0220eaArr);
    }

    public EnumC0220ea(String str, int i) {
    }

    public static EnumC0220ea valueOf(String str) {
        return (EnumC0220ea) Enum.valueOf(EnumC0220ea.class, str);
    }

    public static EnumC0220ea[] values() {
        return (EnumC0220ea[]) g.clone();
    }
}
