package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0350jg {

    /* renamed from: a  reason: collision with root package name */
    public final C0527qg f954a;
    public final Ga b;
    public final Bg c;
    public final Lazy d = LazyKt.lazy(new C0273gg(this));
    public final Lazy e = LazyKt.lazy(new C0221eg(this));
    public final Lazy f = LazyKt.lazy(new C0324ig(this));
    public final ArrayList g = new ArrayList();

    public C0350jg(C0527qg c0527qg, Ag ag, Ga ga, Bg bg) {
        this.f954a = c0527qg;
        this.b = ga;
        this.c = bg;
    }

    public static final InterfaceC0144bg a(C0350jg c0350jg) {
        return (InterfaceC0144bg) c0350jg.d.getValue();
    }

    public static final void a(C0350jg c0350jg, C0576sg c0576sg, InterfaceC0144bg interfaceC0144bg) {
        boolean areEqual;
        c0350jg.g.add(c0576sg);
        Bg bg = c0350jg.c;
        if (c0576sg == null) {
            bg.getClass();
        } else {
            SafePackageManager safePackageManager = bg.b;
            Context context = bg.f413a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = c0576sg.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(bg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(bg.g, installerPackageName);
            }
            if (areEqual) {
                c0350jg.a(c0576sg);
                return;
            }
        }
        interfaceC0144bg.a();
    }

    public final void a(C0576sg c0576sg) {
        C0527qg c0527qg = this.f954a;
        synchronized (c0527qg) {
            c0527qg.b = c0576sg;
            c0527qg.c = true;
            c0527qg.d.a(c0576sg);
            c0527qg.d.d();
            c0527qg.a(c0527qg.b);
        }
    }
}
