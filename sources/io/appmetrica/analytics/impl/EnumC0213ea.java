package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0213ea {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0213ea f966a;
    public static final EnumC0213ea b;
    public static final EnumC0213ea c;
    public static final EnumC0213ea d;
    public static final EnumC0213ea e;
    public static final EnumC0213ea f;
    public static final /* synthetic */ EnumC0213ea[] g;

    static {
        EnumC0213ea enumC0213ea = new EnumC0213ea("UNKNOWN", 0);
        EnumC0213ea enumC0213ea2 = new EnumC0213ea("APPSFLYER", 1);
        f966a = enumC0213ea2;
        EnumC0213ea enumC0213ea3 = new EnumC0213ea("ADJUST", 2);
        b = enumC0213ea3;
        EnumC0213ea enumC0213ea4 = new EnumC0213ea("KOCHAVA", 3);
        c = enumC0213ea4;
        EnumC0213ea enumC0213ea5 = new EnumC0213ea("TENJIN", 4);
        d = enumC0213ea5;
        EnumC0213ea enumC0213ea6 = new EnumC0213ea("AIRBRIDGE", 5);
        e = enumC0213ea6;
        EnumC0213ea enumC0213ea7 = new EnumC0213ea("SINGULAR", 6);
        f = enumC0213ea7;
        EnumC0213ea[] enumC0213eaArr = {enumC0213ea, enumC0213ea2, enumC0213ea3, enumC0213ea4, enumC0213ea5, enumC0213ea6, enumC0213ea7};
        g = enumC0213eaArr;
        EnumEntriesKt.enumEntries(enumC0213eaArr);
    }

    public EnumC0213ea(String str, int i) {
    }

    public static EnumC0213ea valueOf(String str) {
        return (EnumC0213ea) Enum.valueOf(EnumC0213ea.class, str);
    }

    public static EnumC0213ea[] values() {
        return (EnumC0213ea[]) g.clone();
    }
}
