package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class Ze implements Yc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f786a;
    public final String b;
    public final String c;

    public Ze(Context context, String str, String str2) {
        this.f786a = context;
        this.b = str;
        this.c = str2;
    }

    public final Ze a(Context context, String str, String str2) {
        return new Ze(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ze) {
            Ze ze = (Ze) obj;
            return Intrinsics.areEqual(this.f786a, ze.f786a) && Intrinsics.areEqual(this.b, ze.b) && Intrinsics.areEqual(this.c, ze.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f786a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f786a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static Ze a(Ze ze, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = ze.f786a;
        }
        if ((i & 2) != 0) {
            str = ze.b;
        }
        if ((i & 4) != 0) {
            str2 = ze.c;
        }
        ze.getClass();
        return new Ze(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Yc
    public final String a() {
        String string = this.f786a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
