package io.appmetrica.analytics.impl;

import com.google.android.gms.stats.CodePackage;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ue  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0636ue {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0636ue f1234a;
    public static final EnumC0636ue b;
    public static final /* synthetic */ EnumC0636ue[] c;

    static {
        EnumC0636ue enumC0636ue = new EnumC0636ue("REPORT", 0);
        f1234a = enumC0636ue;
        EnumC0636ue enumC0636ue2 = new EnumC0636ue(CodePackage.LOCATION, 1);
        EnumC0636ue enumC0636ue3 = new EnumC0636ue("STARTUP", 2);
        b = enumC0636ue3;
        EnumC0636ue[] enumC0636ueArr = {enumC0636ue, enumC0636ue2, enumC0636ue3, new EnumC0636ue("DIAGNOSTIC", 3)};
        c = enumC0636ueArr;
        EnumEntriesKt.enumEntries(enumC0636ueArr);
    }

    public EnumC0636ue(String str, int i) {
    }

    public static EnumC0636ue valueOf(String str) {
        return (EnumC0636ue) Enum.valueOf(EnumC0636ue.class, str);
    }

    public static EnumC0636ue[] values() {
        return (EnumC0636ue[]) c.clone();
    }
}
