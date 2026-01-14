package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.c5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0163c5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0111a5 f931a;
    public final C0137b5 b;
    protected final Context c;
    public final Q4 d;
    public final C0468o4 e;
    public final V4 f;
    protected final C0257fm g;
    public final InterfaceC0304hh h;
    public final H8 i;
    public final ICommonExecutor j;
    public final Fb k;
    public final InterfaceC0572s9 l;
    public final int m;

    public C0163c5(Context context, Q4 q4, C0468o4 c0468o4, V4 v4, C0257fm c0257fm, InterfaceC0304hh interfaceC0304hh, ICommonExecutor iCommonExecutor, int i, Fb fb, InterfaceC0572s9 interfaceC0572s9) {
        this(context, q4, c0468o4, v4, c0257fm, interfaceC0304hh, iCommonExecutor, new H8(), i, new C0111a5(c0468o4.f1147a), new C0137b5(context, q4), fb, interfaceC0572s9);
    }

    public static X8 c(X4 x4) {
        return new X8(x4);
    }

    public final M8 a() {
        Context context = this.c;
        Q4 q4 = this.d;
        return new M8(new R8(context, q4), this.m);
    }

    public final L6 b(X4 x4) {
        return new L6(x4, C0449na.I.B().c(this.c, this.d), new H6(x4.c()), new C0242f7());
    }

    public final C0111a5 d() {
        return this.f931a;
    }

    public final C0137b5 e() {
        return this.b;
    }

    public final xo f() {
        xo xoVar;
        Bo c0142ba;
        Ao D = C0449na.I.D();
        Q4 q4 = this.d;
        synchronized (D) {
            String valueOf = String.valueOf(q4);
            LinkedHashMap linkedHashMap = D.b;
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                We we = new We(C0449na.I.B().b(D.f505a, q4));
                if (q4.d()) {
                    String str = "appmetrica_vital_" + q4.b + ".dat";
                    c0142ba = new C0266g5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C0142ba(D.f505a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C0142ba(D.f505a, "appmetrica_vital_main.dat"))}));
                } else {
                    c0142ba = new C0142ba(D.f505a, "appmetrica_vital_" + q4.b + ".dat");
                }
                obj = new xo(we, c0142ba, valueOf);
                linkedHashMap.put(valueOf, obj);
            }
            xoVar = (xo) obj;
        }
        return xoVar;
    }

    public C0163c5(Context context, Q4 q4, C0468o4 c0468o4, V4 v4, C0257fm c0257fm, InterfaceC0304hh interfaceC0304hh, ICommonExecutor iCommonExecutor, H8 h8, int i, C0111a5 c0111a5, C0137b5 c0137b5, Fb fb, InterfaceC0572s9 interfaceC0572s9) {
        this.c = context;
        this.d = q4;
        this.e = c0468o4;
        this.f = v4;
        this.g = c0257fm;
        this.h = interfaceC0304hh;
        this.j = iCommonExecutor;
        this.i = h8;
        this.m = i;
        this.f931a = c0111a5;
        this.b = c0137b5;
        this.k = fb;
        this.l = interfaceC0572s9;
    }

    public final Jk c() {
        return new Jk(this.c, this.d);
    }

    public final C0656vi d(X4 x4) {
        C0656vi c0656vi = new C0656vi(x4, this.f.a(), this.j);
        Fb fb = this.k;
        synchronized (fb) {
            fb.c.add(c0656vi);
        }
        return c0656vi;
    }

    public final Qg a(X4 x4) {
        return new Qg(new C0329ih(x4, this.h, new C3()), this.g, new C0252fh(this.e));
    }

    public static Rk a(X4 x4, xo xoVar, W4 w4) {
        Qk qk = new Qk(xoVar);
        return new Rk(x4, qk, w4, new C0297ha(x4, qk, new Uk(x4.h(), "foreground"), AbstractC0689x1.a(), new SystemTimeProvider()), new C0740z2(x4, qk, new Uk(x4.h(), C0740z2.g), AbstractC0689x1.a(), new SystemTimeProvider()));
    }

    public static S4 b() {
        return new S4();
    }

    public final C0417m3 b(We we) {
        Context context = this.c;
        return new C0417m3(context, we, context.getPackageName(), new SafePackageManager());
    }

    public final C0373k9 a(We we, xo xoVar, Rk rk, L6 l6, C0338j0 c0338j0, Jk jk, C0656vi c0656vi) {
        return new C0373k9(we, xoVar, rk, l6, c0338j0, this.i, jk, this.m, new Z4(c0656vi), new SystemTimeProvider());
    }

    public static C0606ti a(X4 x4, X8 x8) {
        return new C0606ti(x8, x4);
    }

    public InterfaceC0523q9 a(InterfaceC0647v9 interfaceC0647v9, L6 l6, Qg qg, C0468o4 c0468o4, Q4 q4, We we) {
        return this.l.a(interfaceC0647v9, l6, qg, c0468o4, q4, we).a();
    }

    public final C0491p2 a(We we) {
        return new C0491p2(this.d, we);
    }
}
