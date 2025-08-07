package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.oj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0490oj implements InterfaceC0370k {

    /* renamed from: a  reason: collision with root package name */
    public C0361jf f990a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0465nj e = new C0465nj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f990a == null) {
                this.f990a = new C0361jf(C0627u7.a(activity).a());
            }
            C0361jf c0361jf = this.f990a;
            Intrinsics.checkNotNull(c0361jf);
            this.b = c0361jf.p();
            if (this.f990a == null) {
                this.f990a = new C0361jf(C0627u7.a(activity).a());
            }
            C0361jf c0361jf2 = this.f990a;
            Intrinsics.checkNotNull(c0361jf2);
            this.c = c0361jf2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0465nj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f990a == null) {
                this.f990a = new C0361jf(C0627u7.a(context).a());
            }
            C0361jf c0361jf = this.f990a;
            Intrinsics.checkNotNull(c0361jf);
            c0361jf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f990a == null) {
                this.f990a = new C0361jf(C0627u7.a(context).a());
            }
            C0361jf c0361jf = this.f990a;
            Intrinsics.checkNotNull(c0361jf);
            this.b = c0361jf.p();
            if (this.f990a == null) {
                this.f990a = new C0361jf(C0627u7.a(context).a());
            }
            C0361jf c0361jf2 = this.f990a;
            Intrinsics.checkNotNull(c0361jf2);
            this.c = c0361jf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f990a == null) {
                        this.f990a = new C0361jf(C0627u7.a(context).a());
                    }
                    C0361jf c0361jf3 = this.f990a;
                    Intrinsics.checkNotNull(c0361jf3);
                    c0361jf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0361jf c0361jf) {
        this.f990a = c0361jf;
    }
}
