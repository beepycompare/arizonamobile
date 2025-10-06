package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0487of implements InterfaceC0560rd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1021a;
    public final String b;
    public final String c;

    public C0487of(Context context, String str, String str2) {
        this.f1021a = context;
        this.b = str;
        this.c = str2;
    }

    public final C0487of a(Context context, String str, String str2) {
        return new C0487of(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0487of) {
            C0487of c0487of = (C0487of) obj;
            return Intrinsics.areEqual(this.f1021a, c0487of.f1021a) && Intrinsics.areEqual(this.b, c0487of.b) && Intrinsics.areEqual(this.c, c0487of.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1021a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f1021a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static C0487of a(C0487of c0487of, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = c0487of.f1021a;
        }
        if ((i & 2) != 0) {
            str = c0487of.b;
        }
        if ((i & 4) != 0) {
            str2 = c0487of.c;
        }
        c0487of.getClass();
        return new C0487of(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0560rd
    public final String a() {
        String string = this.f1021a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
