package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.t  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0595t {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ EnumC0595t[] f1206a;

    static {
        EnumC0595t[] enumC0595tArr = {new EnumC0595t(0, "AUTOCOLLECTED", "autocollected"), new EnumC0595t(1, "MANUAL", "manual")};
        f1206a = enumC0595tArr;
        EnumEntriesKt.enumEntries(enumC0595tArr);
    }

    public EnumC0595t(int i, String str, String str2) {
    }

    public static EnumC0595t valueOf(String str) {
        return (EnumC0595t) Enum.valueOf(EnumC0595t.class, str);
    }

    public static EnumC0595t[] values() {
        return (EnumC0595t[]) f1206a.clone();
    }
}
