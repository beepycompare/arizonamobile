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
/* loaded from: classes4.dex */
public final class J1 implements InterfaceC0695x1, InterfaceC0495p0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f495a;
    public final Context b;
    public volatile InterfaceC0670w1 c;
    public final C0673w4 d;
    public final Q1 e;
    public C0262fh f;
    public final C0754za g;
    public final C0422m2 h;
    public final K1 i;
    public final C0537qh j;

    public J1(Context context, InterfaceC0670w1 interfaceC0670w1) {
        this(context, interfaceC0670w1, new C0724y5(context));
    }

    public final void a() {
        this.e.c(new P1() { // from class: io.appmetrica.analytics.impl.J1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.P1
            public final void a(Intent intent) {
                J1.this.d(intent);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void c(Intent intent) {
        Q1 q1 = this.e;
        if (intent != null) {
            q1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                q1.f605a.a(action, Integer.valueOf(Q1.a(intent)));
            }
            for (Map.Entry entry : q1.b.entrySet()) {
                P1 p1 = (P1) entry.getKey();
                if (((O1) entry.getValue()).a(intent)) {
                    p1.a(intent);
                }
            }
            return;
        }
        q1.getClass();
    }

    public final void d(Intent intent) {
        Ia.F.u().a(Bb.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void onConfigurationChanged(Configuration configuration) {
        Ia.F.u().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void onCreate() {
        if (!this.f495a) {
            this.g.b(this.b);
            Ia ia = Ia.F;
            synchronized (ia) {
                ia.B.initAsync();
                ia.u.a(ia.f489a);
                ia.u.a(new go(ia.B));
                NetworkServiceLocator.init(new A5(new Ci(ia.g()), new K5(ia.f489a)));
                ia.k().a(ia.q);
                ia.C();
            }
            AbstractC0291gk.f869a.e();
            C0318hm c0318hm = Ia.F.u;
            c0318hm.b();
            C0267fm b = c0318hm.b();
            C0739yk o = Ia.F.o();
            o.a(new C0390kk(new C0657vd(this.e)), b);
            c0318hm.a(o);
            ((Al) Ia.F.y()).getClass();
            a();
            Ia.F.l().init();
            Ia.F.b().init();
            K1 k1 = this.i;
            Context context = this.b;
            C0673w4 c0673w4 = this.d;
            k1.getClass();
            this.f = new C0262fh(context, c0673w4);
            Context context2 = this.b;
            AbstractC0521q1.f1011a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            C0262fh c0262fh = this.f;
            C0208de q = Ia.j().q();
            IHandlerExecutor e = Ia.j().w().e();
            C6 c6 = new C6(context3, c0262fh, EnumC0680wb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new W(), new BlockingExecutor(), "previous");
            C6 c62 = new C6(context3, c0262fh, EnumC0680wb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Hb(), e, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                A6 a6 = new A6(crashesDirectory, c62, new C0654va());
                e.execute(new RunnableC0312hg(crashesDirectory, c6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                a6.startWatching();
                Ia.F.E.storeReference(a6);
            }
            q.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                q.f816a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = q.f816a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    Yd b2 = q.b.b(context3, c0262fh);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                q.f816a.setDefaultCrashHandler(q.b.a(context3, c0262fh));
            }
            new RunnableC0225e6(CollectionsKt.listOf(new RunnableC0412lh())).run();
            this.f495a = true;
        } else {
            Ia.F.u().a(this.b.getResources().getConfiguration());
        }
        Ia.F.k().a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void onDestroy() {
        C0128ac k = Ia.F.k();
        synchronized (k) {
            Iterator it = k.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0589sk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void pauseUserSession(Bundle bundle) {
        Pf pf;
        bundle.setClassLoader(Pf.class.getClassLoader());
        String str = Pf.c;
        try {
            pf = (Pf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            pf = null;
        }
        Integer asInteger = pf != null ? pf.f595a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0415lk> list = (List) Ia.F.v.f957a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0415lk interfaceC0415lk : list) {
            interfaceC0415lk.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void resumeUserSession(Bundle bundle) {
        Pf pf;
        bundle.setClassLoader(Pf.class.getClassLoader());
        String str = Pf.c;
        try {
            pf = (Pf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            pf = null;
        }
        Integer asInteger = pf != null ? pf.f595a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public J1(Context context, InterfaceC0670w1 interfaceC0670w1, C0724y5 c0724y5) {
        this(context, interfaceC0670w1, new C0673w4(context, c0724y5), new Q1(), C0754za.d, Ia.j().d(), new K1());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void a(Intent intent) {
        Q1 q1 = this.e;
        if (intent != null) {
            q1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                q1.f605a.a(action, Integer.valueOf(Q1.a(intent)));
            }
            for (Map.Entry entry : q1.b.entrySet()) {
                P1 p1 = (P1) entry.getKey();
                if (((O1) entry.getValue()).a(intent)) {
                    p1.a(intent);
                }
            }
            return;
        }
        q1.getClass();
    }

    public J1(Context context, InterfaceC0670w1 interfaceC0670w1, C0673w4 c0673w4, Q1 q1, C0754za c0754za, C0422m2 c0422m2, K1 k1) {
        this.f495a = false;
        this.b = context;
        this.c = interfaceC0670w1;
        this.d = c0673w4;
        this.e = q1;
        this.g = c0754za;
        this.h = c0422m2;
        this.i = k1;
        this.j = new C0537qh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        C0401l6.b(bundle);
        C0262fh c0262fh = this.f;
        if (c0262fh != null) {
            c0262fh.a(C0401l6.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void a(InterfaceC0670w1 interfaceC0670w1) {
        this.c = interfaceC0670w1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void a(Intent intent, int i) {
        ((C0620u1) this.c).f1075a.stopSelfResult(i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0695x1
    public final void a(Intent intent, int i, int i2) {
        ((C0620u1) this.c).f1075a.stopSelfResult(i2);
    }
}
