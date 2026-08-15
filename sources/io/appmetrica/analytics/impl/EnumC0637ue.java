package io.appmetrica.analytics.impl;

import com.google.android.gms.stats.CodePackage;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: io.appmetrica.analytics.impl.ue  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC0637ue {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0637ue f1234a;
    public static final EnumC0637ue b;
    public static final /* synthetic */ EnumC0637ue[] c;

    static {
        EnumC0637ue enumC0637ue = new EnumC0637ue("REPORT", 0);
        f1234a = enumC0637ue;
        EnumC0637ue enumC0637ue2 = new EnumC0637ue(CodePackage.LOCATION, 1);
        EnumC0637ue enumC0637ue3 = new EnumC0637ue("STARTUP", 2);
        b = enumC0637ue3;
        EnumC0637ue[] enumC0637ueArr = {enumC0637ue, enumC0637ue2, enumC0637ue3, new EnumC0637ue("DIAGNOSTIC", 3)};
        c = enumC0637ueArr;
        EnumEntriesKt.enumEntries(enumC0637ueArr);
    }

    public EnumC0637ue(String str, int i) {
    }

    public static EnumC0637ue valueOf(String str) {
        return (EnumC0637ue) Enum.valueOf(EnumC0637ue.class, str);
    }

    public static EnumC0637ue[] values() {
        return (EnumC0637ue[]) c.clone();
    }
}
