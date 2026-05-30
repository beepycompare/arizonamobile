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
public final class O1 implements C1, InterfaceC0624u0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f694a;
    public final Context b;
    public final B1 c;
    public final C0550r4 d;
    public final W1 e;
    public C0330ih f;
    public final Ba g;
    public final C0600t2 h;
    public final P1 i;
    public final C0719xh j;

    public O1(Context context, B1 b1) {
        this(context, b1, new C0603t5(context));
    }

    public static void e(Intent intent) {
        bp bpVar = Na.I.D().c.f876a;
        bp.a(bpVar.f914a);
        bp.a(bpVar.b);
    }

    public final void a() {
        this.e.c(new V1() { // from class: io.appmetrica.analytics.impl.O1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.V1
            public final void a(Intent intent) {
                O1.this.d(intent);
            }
        });
        this.e.a(new V1() { // from class: io.appmetrica.analytics.impl.O1$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.V1
            public final void a(Intent intent) {
                O1.e(intent);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.C1
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

    @Override // io.appmetrica.analytics.impl.C1
    public final void c(Intent intent) {
        W1 w1 = this.e;
        if (intent != null) {
            w1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                w1.f817a.a(action, Integer.valueOf(W1.a(intent)));
            }
            for (Map.Entry entry : w1.b.entrySet()) {
                V1 v1 = (V1) entry.getKey();
                if (((U1) entry.getValue()).a(intent)) {
                    v1.a(intent);
                }
            }
            return;
        }
        w1.getClass();
    }

    public final void d(Intent intent) {
        Na.I.v().a(Ib.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void onConfigurationChanged(Configuration configuration) {
        Na.I.v().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void onCreate() {
        if (!this.f694a) {
            this.g.b(this.b);
            Na na = Na.I;
            synchronized (na) {
                na.B.initAsync();
                na.u.a(na.f681a);
                na.u.a(new Mo(na.B));
                NetworkServiceLocator.init(na.f681a, new C0655v5(new Ji(na.h()), new F5(na.f681a)));
                na.l().a(na.q);
                na.E();
            }
            AbstractC0748yk.f1299a.e();
            Jm jm = Na.I.u;
            jm.a();
            Hm a2 = jm.a();
            Zk p = Na.I.p();
            p.a(new Ek(new Ad(this.e)), a2);
            jm.a(p);
            ((C0181cm) Na.I.z()).getClass();
            a();
            Na.I.m().init();
            Na.I.c().init();
            P1 p1 = this.i;
            Context context = this.b;
            C0550r4 c0550r4 = this.d;
            p1.getClass();
            this.f = new C0330ih(context, c0550r4);
            Context context2 = this.b;
            AbstractC0677w1.f1256a.c(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            C0330ih c0330ih = this.f;
            C0483oe r = Na.k().r();
            IHandlerExecutor f = Na.k().w().f();
            C0682w6 c0682w6 = new C0682w6(context3, c0330ih, Db.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new Z(), new BlockingExecutor(), "previous", new C0608ta());
            C0682w6 c0682w62 = new C0682w6(context3, c0330ih, Db.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Ob(), f, "actual", new C0608ta());
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                FileObserverC0630u6 fileObserverC0630u6 = new FileObserverC0630u6(crashesDirectory, c0682w62, new C0686wa());
                f.execute(new RunnableC0666vg(crashesDirectory, c0682w6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                fileObserverC0630u6.startWatching();
                Na.I.E.storeReference(fileObserverC0630u6);
            }
            r.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                r.f1131a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = r.f1131a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    C0353je b = r.b.b(context3, c0330ih);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b.newCrash(nativeCrash);
                    }
                }
                r.f1131a.setDefaultCrashHandler(r.b.a(context3, c0330ih));
            }
            new Y5(CollectionsKt.listOf(new RunnableC0512ph())).run();
            this.f694a = true;
        } else {
            Na.I.v().a(this.b.getResources().getConfiguration());
        }
        Na.I.l().a();
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void onDestroy() {
        C0300hc l = Na.I.l();
        synchronized (l) {
            Iterator it = l.c.iterator();
            while (it.hasNext()) {
                ((Nk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void pauseUserSession(Bundle bundle) {
        C0175cg c0175cg;
        bundle.setClassLoader(C0175cg.class.getClassLoader());
        String str = C0175cg.c;
        try {
            c0175cg = (C0175cg) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            c0175cg = null;
        }
        Integer asInteger = c0175cg != null ? c0175cg.f928a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<Fk> list = (List) Na.I.v.f564a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (Fk fk : list) {
            fk.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void resumeUserSession(Bundle bundle) {
        C0175cg c0175cg;
        bundle.setClassLoader(C0175cg.class.getClassLoader());
        String str = C0175cg.c;
        try {
            c0175cg = (C0175cg) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            c0175cg = null;
        }
        Integer asInteger = c0175cg != null ? c0175cg.f928a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public O1(Context context, B1 b1, C0603t5 c0603t5) {
        this(context, b1, new C0550r4(context, c0603t5), new W1(), Ba.d, Na.k().e(), new P1());
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void a(Intent intent) {
        W1 w1 = this.e;
        if (intent != null) {
            w1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                w1.f817a.a(action, Integer.valueOf(W1.a(intent)));
            }
            for (Map.Entry entry : w1.b.entrySet()) {
                V1 v1 = (V1) entry.getKey();
                if (((U1) entry.getValue()).a(intent)) {
                    v1.a(intent);
                }
            }
            return;
        }
        w1.getClass();
    }

    public O1(Context context, B1 b1, C0550r4 c0550r4, W1 w1, Ba ba, C0600t2 c0600t2, P1 p1) {
        this.f694a = false;
        this.b = context;
        this.c = b1;
        this.d = c0550r4;
        this.e = w1;
        this.g = ba;
        this.h = c0600t2;
        this.i = p1;
        this.j = new C0719xh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        C0242f6.b(bundle);
        C0330ih c0330ih = this.f;
        if (c0330ih != null) {
            c0330ih.a(C0242f6.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void a(Intent intent, int i) {
        ((C0676w0) this.c).f1255a.stopSelf(i);
    }

    @Override // io.appmetrica.analytics.impl.C1
    public final void a(Intent intent, int i, int i2) {
        ((C0676w0) this.c).f1255a.stopSelf(i2);
    }
}
