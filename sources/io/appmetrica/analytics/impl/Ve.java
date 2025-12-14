package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Ve implements Sc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f820a;
    public final String b;
    public final String c;

    public Ve(Context context, String str, String str2) {
        this.f820a = context;
        this.b = str;
        this.c = str2;
    }

    public final Ve a(Context context, String str, String str2) {
        return new Ve(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ve) {
            Ve ve = (Ve) obj;
            return Intrinsics.areEqual(this.f820a, ve.f820a) && Intrinsics.areEqual(this.b, ve.b) && Intrinsics.areEqual(this.c, ve.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f820a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f820a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static Ve a(Ve ve, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = ve.f820a;
        }
        if ((i & 2) != 0) {
            str = ve.b;
        }
        if ((i & 4) != 0) {
            str2 = ve.c;
        }
        ve.getClass();
        return new Ve(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Sc
    public final String a() {
        String string = this.f820a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
