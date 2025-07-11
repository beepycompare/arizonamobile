package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.lj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0412lj implements InterfaceC0367k {

    /* renamed from: a  reason: collision with root package name */
    public C0309hf f926a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0387kj e = new C0387kj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f926a == null) {
                this.f926a = new C0309hf(C0549r7.a(activity).a());
            }
            C0309hf c0309hf = this.f926a;
            Intrinsics.checkNotNull(c0309hf);
            this.b = c0309hf.p();
            if (this.f926a == null) {
                this.f926a = new C0309hf(C0549r7.a(activity).a());
            }
            C0309hf c0309hf2 = this.f926a;
            Intrinsics.checkNotNull(c0309hf2);
            this.c = c0309hf2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0387kj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f926a == null) {
                this.f926a = new C0309hf(C0549r7.a(context).a());
            }
            C0309hf c0309hf = this.f926a;
            Intrinsics.checkNotNull(c0309hf);
            c0309hf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f926a == null) {
                this.f926a = new C0309hf(C0549r7.a(context).a());
            }
            C0309hf c0309hf = this.f926a;
            Intrinsics.checkNotNull(c0309hf);
            this.b = c0309hf.p();
            if (this.f926a == null) {
                this.f926a = new C0309hf(C0549r7.a(context).a());
            }
            C0309hf c0309hf2 = this.f926a;
            Intrinsics.checkNotNull(c0309hf2);
            this.c = c0309hf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f926a == null) {
                        this.f926a = new C0309hf(C0549r7.a(context).a());
                    }
                    C0309hf c0309hf3 = this.f926a;
                    Intrinsics.checkNotNull(c0309hf3);
                    c0309hf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0309hf c0309hf) {
        this.f926a = c0309hf;
    }
}
