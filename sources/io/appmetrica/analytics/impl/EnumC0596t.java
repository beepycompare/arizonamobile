package io.appmetrica.analytics.impl;

import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.t  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0596t {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ EnumC0596t[] f1206a;

    static {
        EnumC0596t[] enumC0596tArr = {new EnumC0596t(0, "AUTOCOLLECTED", "autocollected"), new EnumC0596t(1, "MANUAL", "manual")};
        f1206a = enumC0596tArr;
        EnumEntriesKt.enumEntries(enumC0596tArr);
    }

    public EnumC0596t(int i, String str, String str2) {
    }

    public static EnumC0596t valueOf(String str) {
        return (EnumC0596t) Enum.valueOf(EnumC0596t.class, str);
    }

    public static EnumC0596t[] values() {
        return (EnumC0596t[]) f1206a.clone();
    }
}
