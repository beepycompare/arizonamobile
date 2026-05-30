package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.t  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0597t {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ EnumC0597t[] f1204a;

    static {
        EnumC0597t[] enumC0597tArr = {new EnumC0597t(0, "AUTOCOLLECTED", "autocollected"), new EnumC0597t(1, "MANUAL", "manual")};
        f1204a = enumC0597tArr;
        EnumEntriesKt.enumEntries(enumC0597tArr);
    }

    public EnumC0597t(int i, String str, String str2) {
    }

    public static EnumC0597t valueOf(String str) {
        return (EnumC0597t) Enum.valueOf(EnumC0597t.class, str);
    }

    public static EnumC0597t[] values() {
        return (EnumC0597t[]) f1204a.clone();
    }
}
