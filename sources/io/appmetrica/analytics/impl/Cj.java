package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Cj implements InterfaceC0383l {

    /* renamed from: a  reason: collision with root package name */
    public C0658vf f505a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final Bj e = new Bj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f505a == null) {
                this.f505a = C0569s4.l().b(activity);
            }
            C0658vf c0658vf = this.f505a;
            Intrinsics.checkNotNull(c0658vf);
            this.b = c0658vf.p();
            if (this.f505a == null) {
                this.f505a = C0569s4.l().b(activity);
            }
            C0658vf c0658vf2 = this.f505a;
            Intrinsics.checkNotNull(c0658vf2);
            this.c = c0658vf2.t();
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
            if (this.f505a == null) {
                this.f505a = C0569s4.l().b(context);
            }
            C0658vf c0658vf = this.f505a;
            Intrinsics.checkNotNull(c0658vf);
            c0658vf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f505a == null) {
                this.f505a = C0569s4.l().b(context);
            }
            C0658vf c0658vf = this.f505a;
            Intrinsics.checkNotNull(c0658vf);
            this.b = c0658vf.p();
            if (this.f505a == null) {
                this.f505a = C0569s4.l().b(context);
            }
            C0658vf c0658vf2 = this.f505a;
            Intrinsics.checkNotNull(c0658vf2);
            this.c = c0658vf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f505a == null) {
                        this.f505a = C0569s4.l().b(context);
                    }
                    C0658vf c0658vf3 = this.f505a;
                    Intrinsics.checkNotNull(c0658vf3);
                    c0658vf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0658vf c0658vf) {
        this.f505a = c0658vf;
    }
}
