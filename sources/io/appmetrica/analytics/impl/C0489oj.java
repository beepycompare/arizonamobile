package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.oj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0489oj implements InterfaceC0369k {

    /* renamed from: a  reason: collision with root package name */
    public C0360jf f990a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0464nj e = new C0464nj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f990a == null) {
                this.f990a = new C0360jf(C0626u7.a(activity).a());
            }
            C0360jf c0360jf = this.f990a;
            Intrinsics.checkNotNull(c0360jf);
            this.b = c0360jf.p();
            if (this.f990a == null) {
                this.f990a = new C0360jf(C0626u7.a(activity).a());
            }
            C0360jf c0360jf2 = this.f990a;
            Intrinsics.checkNotNull(c0360jf2);
            this.c = c0360jf2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0464nj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f990a == null) {
                this.f990a = new C0360jf(C0626u7.a(context).a());
            }
            C0360jf c0360jf = this.f990a;
            Intrinsics.checkNotNull(c0360jf);
            c0360jf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f990a == null) {
                this.f990a = new C0360jf(C0626u7.a(context).a());
            }
            C0360jf c0360jf = this.f990a;
            Intrinsics.checkNotNull(c0360jf);
            this.b = c0360jf.p();
            if (this.f990a == null) {
                this.f990a = new C0360jf(C0626u7.a(context).a());
            }
            C0360jf c0360jf2 = this.f990a;
            Intrinsics.checkNotNull(c0360jf2);
            this.c = c0360jf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f990a == null) {
                        this.f990a = new C0360jf(C0626u7.a(context).a());
                    }
                    C0360jf c0360jf3 = this.f990a;
                    Intrinsics.checkNotNull(c0360jf3);
                    c0360jf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0360jf c0360jf) {
        this.f990a = c0360jf;
    }
}
