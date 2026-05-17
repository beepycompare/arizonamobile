package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Ue implements Rc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f816a;
    public final String b;
    public final String c;

    public Ue(Context context, String str, String str2) {
        this.f816a = context;
        this.b = str;
        this.c = str2;
    }

    public final Ue a(Context context, String str, String str2) {
        return new Ue(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ue) {
            Ue ue = (Ue) obj;
            return Intrinsics.areEqual(this.f816a, ue.f816a) && Intrinsics.areEqual(this.b, ue.b) && Intrinsics.areEqual(this.c, ue.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f816a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f816a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static Ue a(Ue ue, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = ue.f816a;
        }
        if ((i & 2) != 0) {
            str = ue.b;
        }
        if ((i & 4) != 0) {
            str2 = ue.c;
        }
        ue.getClass();
        return new Ue(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Rc
    public final String a() {
        String string = this.f816a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
