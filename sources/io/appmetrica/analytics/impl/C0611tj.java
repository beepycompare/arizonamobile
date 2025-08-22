package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.tj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0611tj implements InterfaceC0366k {

    /* renamed from: a  reason: collision with root package name */
    public C0408lf f1076a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0586sj e = new C0586sj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f1076a == null) {
                this.f1076a = new C0408lf(C0649v7.a(activity).a());
            }
            C0408lf c0408lf = this.f1076a;
            Intrinsics.checkNotNull(c0408lf);
            this.b = c0408lf.p();
            if (this.f1076a == null) {
                this.f1076a = new C0408lf(C0649v7.a(activity).a());
            }
            C0408lf c0408lf2 = this.f1076a;
            Intrinsics.checkNotNull(c0408lf2);
            this.c = c0408lf2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0586sj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f1076a == null) {
                this.f1076a = new C0408lf(C0649v7.a(context).a());
            }
            C0408lf c0408lf = this.f1076a;
            Intrinsics.checkNotNull(c0408lf);
            c0408lf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f1076a == null) {
                this.f1076a = new C0408lf(C0649v7.a(context).a());
            }
            C0408lf c0408lf = this.f1076a;
            Intrinsics.checkNotNull(c0408lf);
            this.b = c0408lf.p();
            if (this.f1076a == null) {
                this.f1076a = new C0408lf(C0649v7.a(context).a());
            }
            C0408lf c0408lf2 = this.f1076a;
            Intrinsics.checkNotNull(c0408lf2);
            this.c = c0408lf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f1076a == null) {
                        this.f1076a = new C0408lf(C0649v7.a(context).a());
                    }
                    C0408lf c0408lf3 = this.f1076a;
                    Intrinsics.checkNotNull(c0408lf3);
                    c0408lf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0408lf c0408lf) {
        this.f1076a = c0408lf;
    }
}
