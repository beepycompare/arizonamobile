package io.appmetrica.analytics.impl;

import com.google.android.gms.stats.CodePackage;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ue  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0631ue {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0631ue f1237a;
    public static final EnumC0631ue b;
    public static final /* synthetic */ EnumC0631ue[] c;

    static {
        EnumC0631ue enumC0631ue = new EnumC0631ue("REPORT", 0);
        f1237a = enumC0631ue;
        EnumC0631ue enumC0631ue2 = new EnumC0631ue(CodePackage.LOCATION, 1);
        EnumC0631ue enumC0631ue3 = new EnumC0631ue("STARTUP", 2);
        b = enumC0631ue3;
        EnumC0631ue[] enumC0631ueArr = {enumC0631ue, enumC0631ue2, enumC0631ue3, new EnumC0631ue("DIAGNOSTIC", 3)};
        c = enumC0631ueArr;
        EnumEntriesKt.enumEntries(enumC0631ueArr);
    }

    public EnumC0631ue(String str, int i) {
    }

    public static EnumC0631ue valueOf(String str) {
        return (EnumC0631ue) Enum.valueOf(EnumC0631ue.class, str);
    }

    public static EnumC0631ue[] values() {
        return (EnumC0631ue[]) c.clone();
    }
}
