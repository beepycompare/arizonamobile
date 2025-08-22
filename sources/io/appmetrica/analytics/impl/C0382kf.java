package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.kf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0382kf implements InterfaceC0481od {

    /* renamed from: a  reason: collision with root package name */
    public final Context f938a;
    public final String b;
    public final String c;

    public C0382kf(Context context, String str, String str2) {
        this.f938a = context;
        this.b = str;
        this.c = str2;
    }

    public final C0382kf a(Context context, String str, String str2) {
        return new C0382kf(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0382kf) {
            C0382kf c0382kf = (C0382kf) obj;
            return Intrinsics.areEqual(this.f938a, c0382kf.f938a) && Intrinsics.areEqual(this.b, c0382kf.b) && Intrinsics.areEqual(this.c, c0382kf.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f938a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.f938a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static C0382kf a(C0382kf c0382kf, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = c0382kf.f938a;
        }
        if ((i & 2) != 0) {
            str = c0382kf.b;
        }
        if ((i & 4) != 0) {
            str2 = c0382kf.c;
        }
        c0382kf.getClass();
        return new C0382kf(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0481od
    public final String a() {
        String string = this.f938a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
