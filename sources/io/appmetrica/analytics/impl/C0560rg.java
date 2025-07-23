package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.rg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0560rg {

    /* renamed from: a  reason: collision with root package name */
    public final C0735yg f1037a;
    public final Ua b;
    public final Jg c;
    public final Lazy d = LazyKt.lazy(new C0486og(this));
    public final Lazy e = LazyKt.lazy(new C0436mg(this));
    public final Lazy f = LazyKt.lazy(new C0536qg(this));
    public final ArrayList g = new ArrayList();

    public C0560rg(C0735yg c0735yg, Ig ig, Ua ua, Jg jg) {
        this.f1037a = c0735yg;
        this.b = ua;
        this.c = jg;
    }

    public static final InterfaceC0361jg a(C0560rg c0560rg) {
        return (InterfaceC0361jg) c0560rg.d.getValue();
    }

    public static final void a(C0560rg c0560rg, Ag ag, InterfaceC0361jg interfaceC0361jg) {
        boolean areEqual;
        c0560rg.g.add(ag);
        Jg jg = c0560rg.c;
        if (ag == null) {
            jg.getClass();
        } else {
            SafePackageManager safePackageManager = jg.b;
            Context context = jg.f507a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = ag.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(jg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(jg.g, installerPackageName);
            }
            if (areEqual) {
                c0560rg.a(ag);
                return;
            }
        }
        interfaceC0361jg.a();
    }

    public final void a(Ag ag) {
        C0735yg c0735yg = this.f1037a;
        synchronized (c0735yg) {
            c0735yg.b = ag;
            c0735yg.c = true;
            c0735yg.d.a(ag);
            c0735yg.d.d();
            c0735yg.a(c0735yg.b);
        }
    }
}
