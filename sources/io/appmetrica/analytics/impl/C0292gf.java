package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.gf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0292gf implements InterfaceC0389kd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f854a;
    public final String b;
    public final String c;

    public C0292gf(Context context, String str, String str2) {
        this.f854a = context;
        this.b = str;
        this.c = str2;
    }

    public final C0292gf a(Context context, String str, String str2) {
        return new C0292gf(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0292gf) {
            C0292gf c0292gf = (C0292gf) obj;
            return Intrinsics.areEqual(this.f854a, c0292gf.f854a) && Intrinsics.areEqual(this.b, c0292gf.b) && Intrinsics.areEqual(this.c, c0292gf.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f854a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f854a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static C0292gf a(C0292gf c0292gf, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = c0292gf.f854a;
        }
        if ((i & 2) != 0) {
            str = c0292gf.b;
        }
        if ((i & 4) != 0) {
            str2 = c0292gf.c;
        }
        c0292gf.getClass();
        return new C0292gf(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0389kd
    public final String a() {
        String string = this.f854a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
