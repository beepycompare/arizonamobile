package io.appmetrica.analytics.impl;

import com.google.android.gms.stats.CodePackage;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ue  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0638ue {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0638ue f1232a;
    public static final EnumC0638ue b;
    public static final /* synthetic */ EnumC0638ue[] c;

    static {
        EnumC0638ue enumC0638ue = new EnumC0638ue("REPORT", 0);
        f1232a = enumC0638ue;
        EnumC0638ue enumC0638ue2 = new EnumC0638ue(CodePackage.LOCATION, 1);
        EnumC0638ue enumC0638ue3 = new EnumC0638ue("STARTUP", 2);
        b = enumC0638ue3;
        EnumC0638ue[] enumC0638ueArr = {enumC0638ue, enumC0638ue2, enumC0638ue3, new EnumC0638ue("DIAGNOSTIC", 3)};
        c = enumC0638ueArr;
        EnumEntriesKt.enumEntries(enumC0638ueArr);
    }

    public EnumC0638ue(String str, int i) {
    }

    public static EnumC0638ue valueOf(String str) {
        return (EnumC0638ue) Enum.valueOf(EnumC0638ue.class, str);
    }

    public static EnumC0638ue[] values() {
        return (EnumC0638ue[]) c.clone();
    }
}
