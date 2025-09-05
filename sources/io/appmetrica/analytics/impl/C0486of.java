package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0486of implements InterfaceC0559rd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1016a;
    public final String b;
    public final String c;

    public C0486of(Context context, String str, String str2) {
        this.f1016a = context;
        this.b = str;
        this.c = str2;
    }

    public final C0486of a(Context context, String str, String str2) {
        return new C0486of(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0486of) {
            C0486of c0486of = (C0486of) obj;
            return Intrinsics.areEqual(this.f1016a, c0486of.f1016a) && Intrinsics.areEqual(this.b, c0486of.b) && Intrinsics.areEqual(this.c, c0486of.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1016a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f1016a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static C0486of a(C0486of c0486of, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = c0486of.f1016a;
        }
        if ((i & 2) != 0) {
            str = c0486of.b;
        }
        if ((i & 4) != 0) {
            str2 = c0486of.c;
        }
        c0486of.getClass();
        return new C0486of(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0559rd
    public final String a() {
        String string = this.f1016a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
