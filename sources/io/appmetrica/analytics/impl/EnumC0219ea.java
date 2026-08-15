package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0219ea {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0219ea f963a;
    public static final EnumC0219ea b;
    public static final EnumC0219ea c;
    public static final EnumC0219ea d;
    public static final EnumC0219ea e;
    public static final EnumC0219ea f;
    public static final /* synthetic */ EnumC0219ea[] g;

    static {
        EnumC0219ea enumC0219ea = new EnumC0219ea("UNKNOWN", 0);
        EnumC0219ea enumC0219ea2 = new EnumC0219ea("APPSFLYER", 1);
        f963a = enumC0219ea2;
        EnumC0219ea enumC0219ea3 = new EnumC0219ea("ADJUST", 2);
        b = enumC0219ea3;
        EnumC0219ea enumC0219ea4 = new EnumC0219ea("KOCHAVA", 3);
        c = enumC0219ea4;
        EnumC0219ea enumC0219ea5 = new EnumC0219ea("TENJIN", 4);
        d = enumC0219ea5;
        EnumC0219ea enumC0219ea6 = new EnumC0219ea("AIRBRIDGE", 5);
        e = enumC0219ea6;
        EnumC0219ea enumC0219ea7 = new EnumC0219ea("SINGULAR", 6);
        f = enumC0219ea7;
        EnumC0219ea[] enumC0219eaArr = {enumC0219ea, enumC0219ea2, enumC0219ea3, enumC0219ea4, enumC0219ea5, enumC0219ea6, enumC0219ea7};
        g = enumC0219eaArr;
        EnumEntriesKt.enumEntries(enumC0219eaArr);
    }

    public EnumC0219ea(String str, int i) {
    }

    public static EnumC0219ea valueOf(String str) {
        return (EnumC0219ea) Enum.valueOf(EnumC0219ea.class, str);
    }

    public static EnumC0219ea[] values() {
        return (EnumC0219ea[]) g.clone();
    }
}
