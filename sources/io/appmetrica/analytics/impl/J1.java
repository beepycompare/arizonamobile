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
public final class J1 implements InterfaceC0701x1, InterfaceC0501p0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f483a;
    public final Context b;
    public volatile InterfaceC0676w1 c;
    public final C0679w4 d;
    public final Q1 e;
    public C0219dh f;
    public final C0710xa g;
    public final C0428m2 h;
    public final K1 i;
    public final C0493oh j;

    public J1(Context context, InterfaceC0676w1 interfaceC0676w1) {
        this(context, interfaceC0676w1, new C0730y5(context));
    }

    public final void a() {
        this.e.c(new P1() { // from class: io.appmetrica.analytics.impl.J1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.P1
            public final void a(Intent intent) {
                J1.this.d(intent);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void c(Intent intent) {
        Q1 q1 = this.e;
        if (intent != null) {
            q1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                q1.f588a.a(action, Integer.valueOf(Q1.a(intent)));
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
        Ga.F.u().a(AbstractC0761zb.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void onConfigurationChanged(Configuration configuration) {
        Ga.F.u().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void onCreate() {
        if (!this.f483a) {
            this.g.b(this.b);
            Ga ga = Ga.F;
            synchronized (ga) {
                ga.B.initAsync();
                ga.u.a(ga.f443a);
                ga.u.a(new Cdo(ga.B));
                NetworkServiceLocator.init();
                ga.k().a(ga.q);
                ga.C();
            }
            AbstractC0222dk.f808a.e();
            C0249em c0249em = Ga.F.u;
            c0249em.b();
            C0198cm b = c0249em.b();
            C0670vk o = Ga.F.o();
            o.a(new C0322hk(new C0613td(this.e)), b);
            c0249em.a(o);
            ((C0721xl) Ga.F.y()).getClass();
            a();
            Ga.F.l().init();
            Ga.F.b().init();
            K1 k1 = this.i;
            Context context = this.b;
            C0679w4 c0679w4 = this.d;
            k1.getClass();
            this.f = new C0219dh(context, c0679w4);
            Context context2 = this.b;
            AbstractC0527q1.f998a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            C0219dh c0219dh = this.f;
            C0164be q = Ga.j().q();
            IHandlerExecutor e = Ga.j().w().e();
            C0756z6 c0756z6 = new C0756z6(context3, c0219dh, EnumC0636ub.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new W(), new BlockingExecutor(), "previous");
            C0756z6 c0756z62 = new C0756z6(context3, c0219dh, EnumC0636ub.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Fb(), e, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                FileObserverC0706x6 fileObserverC0706x6 = new FileObserverC0706x6(crashesDirectory, c0756z62, new C0610ta());
                e.execute(new RunnableC0268fg(crashesDirectory, c0756z6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                fileObserverC0706x6.startWatching();
                Ga.F.E.storeReference(fileObserverC0706x6);
            }
            q.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                q.f769a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = q.f769a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    Wd b2 = q.b.b(context3, c0219dh);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                q.f769a.setDefaultCrashHandler(q.b.a(context3, c0219dh));
            }
            new RunnableC0156b6(CollectionsKt.listOf(new RunnableC0368jh())).run();
            this.f483a = true;
        } else {
            Ga.F.u().a(this.b.getResources().getConfiguration());
        }
        Ga.F.k().a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void onDestroy() {
        Yb k = Ga.F.k();
        synchronized (k) {
            Iterator it = k.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0521pk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void pauseUserSession(Bundle bundle) {
        Nf nf;
        bundle.setClassLoader(Nf.class.getClassLoader());
        String str = Nf.c;
        try {
            nf = (Nf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            nf = null;
        }
        Integer asInteger = nf != null ? nf.f553a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0346ik> list = (List) Ga.F.v.f894a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0346ik interfaceC0346ik : list) {
            interfaceC0346ik.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void resumeUserSession(Bundle bundle) {
        Nf nf;
        bundle.setClassLoader(Nf.class.getClassLoader());
        String str = Nf.c;
        try {
            nf = (Nf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            nf = null;
        }
        Integer asInteger = nf != null ? nf.f553a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public J1(Context context, InterfaceC0676w1 interfaceC0676w1, C0730y5 c0730y5) {
        this(context, interfaceC0676w1, new C0679w4(context, c0730y5), new Q1(), C0710xa.d, Ga.j().d(), new K1());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(Intent intent) {
        Q1 q1 = this.e;
        if (intent != null) {
            q1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                q1.f588a.a(action, Integer.valueOf(Q1.a(intent)));
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

    public J1(Context context, InterfaceC0676w1 interfaceC0676w1, C0679w4 c0679w4, Q1 q1, C0710xa c0710xa, C0428m2 c0428m2, K1 k1) {
        this.f483a = false;
        this.b = context;
        this.c = interfaceC0676w1;
        this.d = c0679w4;
        this.e = q1;
        this.g = c0710xa;
        this.h = c0428m2;
        this.i = k1;
        this.j = new C0493oh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        C0333i6.b(bundle);
        C0219dh c0219dh = this.f;
        if (c0219dh != null) {
            c0219dh.a(C0333i6.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(InterfaceC0676w1 interfaceC0676w1) {
        this.c = interfaceC0676w1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(Intent intent, int i) {
        ((C0626u1) this.c).f1065a.stopSelfResult(i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0701x1
    public final void a(Intent intent, int i, int i2) {
        ((C0626u1) this.c).f1065a.stopSelfResult(i2);
    }
}
