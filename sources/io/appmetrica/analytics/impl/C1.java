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
public final class C1 implements B1, InterfaceC0559s0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f517a;
    public final Context b;
    public final A1 c;
    public final C0131b4 d;
    public final K1 e;
    public Tg f;
    public final C0240fa g;
    public final C0284h2 h;
    public final D1 i;
    public final C0221eh j;

    public C1(Context context, A1 a1) {
        this(context, a1, new C0209e5(context));
    }

    public final void a() {
        this.e.c(new J1() { // from class: io.appmetrica.analytics.impl.C1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.J1
            public final void a(Intent intent) {
                C1.this.d(intent);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.B1
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

    @Override // io.appmetrica.analytics.impl.B1
    public final void c(Intent intent) {
        K1 k1 = this.e;
        if (intent != null) {
            k1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                k1.f645a.a(action, Integer.valueOf(K1.a(intent)));
            }
            for (Map.Entry entry : k1.b.entrySet()) {
                J1 j1 = (J1) entry.getKey();
                if (((I1) entry.getValue()).a(intent)) {
                    j1.a(intent);
                }
            }
            return;
        }
        k1.getClass();
    }

    public final void d(Intent intent) {
        C0470oa.I.v().a(AbstractC0293hb.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void onConfigurationChanged(Configuration configuration) {
        C0470oa.I.v().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void onCreate() {
        if (!this.f517a) {
            this.g.b(this.b);
            C0470oa c0470oa = C0470oa.I;
            synchronized (c0470oa) {
                c0470oa.B.initAsync();
                c0470oa.u.a(c0470oa.f1144a);
                c0470oa.u.a(new C0383ko(c0470oa.B));
                NetworkServiceLocator.init(new C0261g5(new C0528qi(c0470oa.h()), new C0515q5(c0470oa.f1144a)));
                c0470oa.l().a(c0470oa.q);
                c0470oa.E();
            }
            Xj.f850a.e();
            C0329im c0329im = C0470oa.I.u;
            c0329im.b();
            C0278gm b = c0329im.b();
            C0729yk p = C0470oa.I.p();
            p.a(new C0199dk(new C0140bd(this.e)), b);
            c0329im.a(p);
            ((Bl) C0470oa.I.z()).getClass();
            a();
            C0470oa.I.m().init();
            C0470oa.I.c().init();
            D1 d1 = this.i;
            Context context = this.b;
            C0131b4 c0131b4 = this.d;
            d1.getClass();
            this.f = new Tg(context, c0131b4);
            Context context2 = this.b;
            AbstractC0635v1.f1256a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            Tg tg = this.f;
            Pd r = C0470oa.k().r();
            IHandlerExecutor d = C0470oa.k().w().d();
            C0288h6 c0288h6 = new C0288h6(context3, tg, EnumC0164cb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new X(), new BlockingExecutor(), "previous");
            C0288h6 c0288h62 = new C0288h6(context3, tg, EnumC0164cb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new C0446nb(), d, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                FileObserverC0236f6 fileObserverC0236f6 = new FileObserverC0236f6(crashesDirectory, c0288h62, new C0137ba());
                d.execute(new Vf(crashesDirectory, c0288h6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                fileObserverC0236f6.startWatching();
                C0470oa.I.E.storeReference(fileObserverC0236f6);
            }
            r.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                r.f732a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = r.f732a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    Kd b2 = r.b.b(context3, tg);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                r.f732a.setDefaultCrashHandler(r.b.a(context3, tg));
            }
            new J5(CollectionsKt.listOf(new Zg())).run();
            this.f517a = true;
        } else {
            C0470oa.I.v().a(this.b.getResources().getConfiguration());
        }
        C0470oa.I.l().a();
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void onDestroy() {
        Gb l = C0470oa.I.l();
        synchronized (l) {
            Iterator it = l.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0430mk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void pauseUserSession(Bundle bundle) {
        Cf cf;
        bundle.setClassLoader(Cf.class.getClassLoader());
        String str = Cf.c;
        try {
            cf = (Cf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            cf = null;
        }
        Integer asInteger = cf != null ? cf.f530a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0224ek> list = (List) C0470oa.I.v.f992a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0224ek interfaceC0224ek : list) {
            interfaceC0224ek.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void resumeUserSession(Bundle bundle) {
        Cf cf;
        bundle.setClassLoader(Cf.class.getClassLoader());
        String str = Cf.c;
        try {
            cf = (Cf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            cf = null;
        }
        Integer asInteger = cf != null ? cf.f530a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public C1(Context context, A1 a1, C0209e5 c0209e5) {
        this(context, a1, new C0131b4(context, c0209e5), new K1(), C0240fa.d, C0470oa.k().e(), new D1());
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void a(Intent intent) {
        K1 k1 = this.e;
        if (intent != null) {
            k1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                k1.f645a.a(action, Integer.valueOf(K1.a(intent)));
            }
            for (Map.Entry entry : k1.b.entrySet()) {
                J1 j1 = (J1) entry.getKey();
                if (((I1) entry.getValue()).a(intent)) {
                    j1.a(intent);
                }
            }
            return;
        }
        k1.getClass();
    }

    public C1(Context context, A1 a1, C0131b4 c0131b4, K1 k1, C0240fa c0240fa, C0284h2 c0284h2, D1 d1) {
        this.f517a = false;
        this.b = context;
        this.c = a1;
        this.d = c0131b4;
        this.e = k1;
        this.g = c0240fa;
        this.h = c0284h2;
        this.i = d1;
        this.j = new C0221eh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        Q5.b(bundle);
        Tg tg = this.f;
        if (tg != null) {
            tg.a(Q5.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void a(Intent intent, int i) {
        ((C0609u0) this.c).f1238a.stopSelf(i);
    }

    @Override // io.appmetrica.analytics.impl.B1
    public final void a(Intent intent, int i, int i2) {
        ((C0609u0) this.c).f1238a.stopSelf(i2);
    }
}
