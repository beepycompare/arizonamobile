package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.if  reason: invalid class name */
/* loaded from: classes4.dex */
public final class Cif implements InterfaceC0433md {

    /* renamed from: a  reason: collision with root package name */
    public final Context f901a;
    public final String b;
    public final String c;

    public Cif(Context context, String str, String str2) {
        this.f901a = context;
        this.b = str;
        this.c = str2;
    }

    public final Cif a(Context context, String str, String str2) {
        return new Cif(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cif) {
            Cif cif = (Cif) obj;
            return Intrinsics.areEqual(this.f901a, cif.f901a) && Intrinsics.areEqual(this.b, cif.b) && Intrinsics.areEqual(this.c, cif.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f901a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f901a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static Cif a(Cif cif, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = cif.f901a;
        }
        if ((i & 2) != 0) {
            str = cif.b;
        }
        if ((i & 4) != 0) {
            str2 = cif.c;
        }
        cif.getClass();
        return new Cif(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0433md
    public final String a() {
        String string = this.f901a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
