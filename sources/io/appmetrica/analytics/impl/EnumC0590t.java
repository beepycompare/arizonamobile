package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.t  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0590t {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ EnumC0590t[] f1209a;

    static {
        EnumC0590t[] enumC0590tArr = {new EnumC0590t(0, "AUTOCOLLECTED", "autocollected"), new EnumC0590t(1, "MANUAL", "manual")};
        f1209a = enumC0590tArr;
        EnumEntriesKt.enumEntries(enumC0590tArr);
    }

    public EnumC0590t(int i, String str, String str2) {
    }

    public static EnumC0590t valueOf(String str) {
        return (EnumC0590t) Enum.valueOf(EnumC0590t.class, str);
    }

    public static EnumC0590t[] values() {
        return (EnumC0590t[]) f1209a.clone();
    }
}
