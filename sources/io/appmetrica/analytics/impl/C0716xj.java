package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0716xj implements InterfaceC0367k {

    /* renamed from: a  reason: collision with root package name */
    public C0513pf f1159a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0691wj e = new C0691wj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f1159a == null) {
                this.f1159a = new C0513pf(C0729y7.a(activity).a());
            }
            C0513pf c0513pf = this.f1159a;
            Intrinsics.checkNotNull(c0513pf);
            this.b = c0513pf.p();
            if (this.f1159a == null) {
                this.f1159a = new C0513pf(C0729y7.a(activity).a());
            }
            C0513pf c0513pf2 = this.f1159a;
            Intrinsics.checkNotNull(c0513pf2);
            this.c = c0513pf2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0691wj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f1159a == null) {
                this.f1159a = new C0513pf(C0729y7.a(context).a());
            }
            C0513pf c0513pf = this.f1159a;
            Intrinsics.checkNotNull(c0513pf);
            c0513pf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f1159a == null) {
                this.f1159a = new C0513pf(C0729y7.a(context).a());
            }
            C0513pf c0513pf = this.f1159a;
            Intrinsics.checkNotNull(c0513pf);
            this.b = c0513pf.p();
            if (this.f1159a == null) {
                this.f1159a = new C0513pf(C0729y7.a(context).a());
            }
            C0513pf c0513pf2 = this.f1159a;
            Intrinsics.checkNotNull(c0513pf2);
            this.c = c0513pf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f1159a == null) {
                        this.f1159a = new C0513pf(C0729y7.a(context).a());
                    }
                    C0513pf c0513pf3 = this.f1159a;
                    Intrinsics.checkNotNull(c0513pf3);
                    c0513pf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0513pf c0513pf) {
        this.f1159a = c0513pf;
    }
}
