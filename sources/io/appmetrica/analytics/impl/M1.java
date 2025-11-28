package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.BlockingExecutor;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrash;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceConfig;
import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class M1 implements A1, InterfaceC0560s0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f584a;
    public final Context b;
    public volatile InterfaceC0736z1 c;
    public final C0313i4 d;
    public final T1 e;
    public Xg f;
    public final C0396la g;
    public final C0488p2 h;
    public final N1 i;
    public final C0325ih j;

    public M1(Context context, InterfaceC0736z1 interfaceC0736z1) {
        this(context, interfaceC0736z1, new C0365k5(context));
    }

    public final void a() {
        this.e.c(new S1() { // from class: io.appmetrica.analytics.impl.M1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.S1
            public final void a(Intent intent) {
                M1.this.d(intent);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void b(Intent intent) {
        this.e.d(intent);
        if (intent != null) {
            String action = intent.getAction();
            Uri data = intent.getData();
            String encodedAuthority = data == null ? null : data.getEncodedAuthority();
            if (!"io.appmetrica.analytics.IAppMetricaService".equals(action) || encodedAuthority == null || data == null || !Objects.equals(data.getPath(), "/client")) {
                return;
            }
            int parseInt = Integer.parseInt(data.getQueryParameter("pid"));
            this.d.a(encodedAuthority, Integer.valueOf(parseInt), data.getQueryParameter("psid"));
            this.h.a(parseInt);
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void c(Intent intent) {
        T1 t1 = this.e;
        if (intent != null) {
            t1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                t1.f694a.a(action, Integer.valueOf(T1.a(intent)));
            }
            for (Map.Entry entry : t1.b.entrySet()) {
                S1 s1 = (S1) entry.getKey();
                if (((R1) entry.getValue()).a(intent)) {
                    s1.a(intent);
                }
            }
            return;
        }
        t1.getClass();
    }

    public final void d(Intent intent) {
        C0620ua.H.v().a(AbstractC0447nb.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onConfigurationChanged(Configuration configuration) {
        C0620ua.H.v().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onCreate() {
        if (!this.f584a) {
            this.g.b(this.b);
            C0620ua c0620ua = C0620ua.H;
            synchronized (c0620ua) {
                c0620ua.B.initAsync();
                c0620ua.u.a(c0620ua.f1149a);
                c0620ua.u.a(new lo(c0620ua.B));
                NetworkServiceLocator.init(new C0416m5(new C0628ui(c0620ua.h()), new C0665w5(c0620ua.f1149a)));
                c0620ua.l().a(c0620ua.q);
                c0620ua.E();
            }
            AbstractC0148bk.f818a.e();
            C0408lm c0408lm = C0620ua.H.u;
            c0408lm.b();
            C0356jm b = c0408lm.b();
            Ck p = C0620ua.H.p();
            p.a(new C0303hk(new C0296hd(this.e)), b);
            c0408lm.a(p);
            ((El) C0620ua.H.A()).getClass();
            a();
            C0620ua.H.m().init();
            C0620ua.H.c().init();
            N1 n1 = this.i;
            Context context = this.b;
            C0313i4 c0313i4 = this.d;
            n1.getClass();
            this.f = new Xg(context, c0313i4);
            Context context2 = this.b;
            AbstractC0586t1.f1122a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            Xg xg = this.f;
            Vd r = C0620ua.k().r();
            IHandlerExecutor e = C0620ua.k().x().e();
            C0442n6 c0442n6 = new C0442n6(context3, xg, EnumC0320ib.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new X(), new BlockingExecutor(), "previous");
            C0442n6 c0442n62 = new C0442n6(context3, xg, EnumC0320ib.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new C0596tb(), e, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                FileObserverC0392l6 fileObserverC0392l6 = new FileObserverC0392l6(crashesDirectory, c0442n62, new C0293ha());
                e.execute(new Zf(crashesDirectory, c0442n6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                fileObserverC0392l6.startWatching();
                C0620ua.H.E.storeReference(fileObserverC0392l6);
            }
            r.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                r.f732a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = r.f732a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    Qd b2 = r.b.b(context3, xg);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                r.f732a.setDefaultCrashHandler(r.b.a(context3, xg));
            }
            new P5(CollectionsKt.listOf(new RunnableC0197dh())).run();
            this.f584a = true;
        } else {
            C0620ua.H.v().a(this.b.getResources().getConfiguration());
        }
        C0620ua.H.l().a();
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onDestroy() {
        Mb l = C0620ua.H.l();
        synchronized (l) {
            Iterator it = l.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0506pk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void pauseUserSession(Bundle bundle) {
        Gf gf;
        bundle.setClassLoader(Gf.class.getClassLoader());
        String str = Gf.c;
        try {
            gf = (Gf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            gf = null;
        }
        Integer asInteger = gf != null ? gf.f492a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0328ik> list = (List) C0620ua.H.v.f957a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0328ik interfaceC0328ik : list) {
            interfaceC0328ik.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void resumeUserSession(Bundle bundle) {
        Gf gf;
        bundle.setClassLoader(Gf.class.getClassLoader());
        String str = Gf.c;
        try {
            gf = (Gf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            gf = null;
        }
        Integer asInteger = gf != null ? gf.f492a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public M1(Context context, InterfaceC0736z1 interfaceC0736z1, C0365k5 c0365k5) {
        this(context, interfaceC0736z1, new C0313i4(context, c0365k5), new T1(), C0396la.d, C0620ua.k().e(), new N1());
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent) {
        T1 t1 = this.e;
        if (intent != null) {
            t1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                t1.f694a.a(action, Integer.valueOf(T1.a(intent)));
            }
            for (Map.Entry entry : t1.b.entrySet()) {
                S1 s1 = (S1) entry.getKey();
                if (((R1) entry.getValue()).a(intent)) {
                    s1.a(intent);
                }
            }
            return;
        }
        t1.getClass();
    }

    public M1(Context context, InterfaceC0736z1 interfaceC0736z1, C0313i4 c0313i4, T1 t1, C0396la c0396la, C0488p2 c0488p2, N1 n1) {
        this.f584a = false;
        this.b = context;
        this.c = interfaceC0736z1;
        this.d = c0313i4;
        this.e = t1;
        this.g = c0396la;
        this.h = c0488p2;
        this.i = n1;
        this.j = new C0325ih();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        W5.b(bundle);
        Xg xg = this.f;
        if (xg != null) {
            xg.a(W5.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(InterfaceC0736z1 interfaceC0736z1) {
        this.c = interfaceC0736z1;
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent, int i) {
        ((C0686x1) this.c).f1196a.stopSelfResult(i);
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent, int i, int i2) {
        ((C0686x1) this.c).f1196a.stopSelfResult(i2);
    }
}
