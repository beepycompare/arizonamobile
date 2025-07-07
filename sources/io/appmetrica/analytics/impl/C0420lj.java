package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.lj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0420lj implements InterfaceC0375k {

    /* renamed from: a  reason: collision with root package name */
    public C0317hf f925a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0395kj e = new C0395kj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f925a == null) {
                this.f925a = new C0317hf(C0557r7.a(activity).a());
            }
            C0317hf c0317hf = this.f925a;
            Intrinsics.checkNotNull(c0317hf);
            this.b = c0317hf.p();
            if (this.f925a == null) {
                this.f925a = new C0317hf(C0557r7.a(activity).a());
            }
            C0317hf c0317hf2 = this.f925a;
            Intrinsics.checkNotNull(c0317hf2);
            this.c = c0317hf2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0395kj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f925a == null) {
                this.f925a = new C0317hf(C0557r7.a(context).a());
            }
            C0317hf c0317hf = this.f925a;
            Intrinsics.checkNotNull(c0317hf);
            c0317hf.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f925a == null) {
                this.f925a = new C0317hf(C0557r7.a(context).a());
            }
            C0317hf c0317hf = this.f925a;
            Intrinsics.checkNotNull(c0317hf);
            this.b = c0317hf.p();
            if (this.f925a == null) {
                this.f925a = new C0317hf(C0557r7.a(context).a());
            }
            C0317hf c0317hf2 = this.f925a;
            Intrinsics.checkNotNull(c0317hf2);
            this.c = c0317hf2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f925a == null) {
                        this.f925a = new C0317hf(C0557r7.a(context).a());
                    }
                    C0317hf c0317hf3 = this.f925a;
                    Intrinsics.checkNotNull(c0317hf3);
                    c0317hf3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0317hf c0317hf) {
        this.f925a = c0317hf;
    }
}
