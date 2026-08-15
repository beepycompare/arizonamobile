package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Cj implements InterfaceC0389l {

    /* renamed from: a  reason: collision with root package name */
    public C0664vf f502a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final Bj e = new Bj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f502a == null) {
                this.f502a = C0575s4.l().b(activity);
            }
            C0664vf c0664vf = this.f502a;
            Intrinsics.checkNotNull(c0664vf);
            this.b = c0664vf.p();
            if (this.f502a == null) {
                this.f502a = C0575s4.l().b(activity);
            }
            C0664vf c0664vf2 = this.f502a;
            Intrinsics.checkNotNull(c0664vf2);
            this.c = c0664vf2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = Bj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f502a == null) {
                this.f502a = C0575s4.l().b(context);
            }
            C0664vf c0664vf = this.f502a;
            Intrinsics.checkNotNull(c0664vf);
            c0664vf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f502a == null) {
                this.f502a = C0575s4.l().b(context);
            }
            C0664vf c0664vf = this.f502a;
            Intrinsics.checkNotNull(c0664vf);
            this.b = c0664vf.p();
            if (this.f502a == null) {
                this.f502a = C0575s4.l().b(context);
            }
            C0664vf c0664vf2 = this.f502a;
            Intrinsics.checkNotNull(c0664vf2);
            this.c = c0664vf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f502a == null) {
                        this.f502a = C0575s4.l().b(context);
                    }
                    C0664vf c0664vf3 = this.f502a;
                    Intrinsics.checkNotNull(c0664vf3);
                    c0664vf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0664vf c0664vf) {
        this.f502a = c0664vf;
    }
}
