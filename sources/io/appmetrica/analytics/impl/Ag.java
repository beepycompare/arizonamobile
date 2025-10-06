package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Ag {

    /* renamed from: a  reason: collision with root package name */
    public final Hg f351a;
    public final Za b;
    public final Sg c;
    public final Lazy d = LazyKt.lazy(new C0713xg(this));
    public final Lazy e = LazyKt.lazy(new C0663vg(this));
    public final Lazy f = LazyKt.lazy(new C0763zg(this));
    public final ArrayList g = new ArrayList();

    public Ag(Hg hg, Rg rg, Za za, Sg sg) {
        this.f351a = hg;
        this.b = za;
        this.c = sg;
    }

    public static final InterfaceC0588sg a(Ag ag) {
        return (InterfaceC0588sg) ag.d.getValue();
    }

    public static final void a(Ag ag, Jg jg, InterfaceC0588sg interfaceC0588sg) {
        boolean areEqual;
        ag.g.add(jg);
        Sg sg = ag.c;
        if (jg == null) {
            sg.getClass();
        } else {
            SafePackageManager safePackageManager = sg.b;
            Context context = sg.f672a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = jg.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(sg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(sg.g, installerPackageName);
            }
            if (areEqual) {
                ag.a(jg);
                return;
            }
        }
        interfaceC0588sg.a();
    }

    public final void a(Jg jg) {
        Hg hg = this.f351a;
        synchronized (hg) {
            hg.b = jg;
            hg.c = true;
            hg.d.a(jg);
            hg.d.d();
            hg.a(hg.b);
        }
    }
}
