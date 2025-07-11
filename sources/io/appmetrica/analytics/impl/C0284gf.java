package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.gf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0284gf implements InterfaceC0381kd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f855a;
    public final String b;
    public final String c;

    public C0284gf(Context context, String str, String str2) {
        this.f855a = context;
        this.b = str;
        this.c = str2;
    }

    public final C0284gf a(Context context, String str, String str2) {
        return new C0284gf(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0284gf) {
            C0284gf c0284gf = (C0284gf) obj;
            return Intrinsics.areEqual(this.f855a, c0284gf.f855a) && Intrinsics.areEqual(this.b, c0284gf.b) && Intrinsics.areEqual(this.c, c0284gf.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f855a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f855a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static C0284gf a(C0284gf c0284gf, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = c0284gf.f855a;
        }
        if ((i & 2) != 0) {
            str = c0284gf.b;
        }
        if ((i & 4) != 0) {
            str2 = c0284gf.c;
        }
        c0284gf.getClass();
        return new C0284gf(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0381kd
    public final String a() {
        String string = this.f855a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
