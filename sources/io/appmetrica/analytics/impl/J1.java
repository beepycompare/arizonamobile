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
public final class J1 implements InterfaceC0693x1, InterfaceC0493p0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f484a;
    public final Context b;
    public volatile InterfaceC0668w1 c;
    public final C0671w4 d;
    public final Q1 e;
    public C0211dh f;
    public final C0702xa g;
    public final C0420m2 h;
    public final K1 i;
    public final C0485oh j;

    public J1(Context context, InterfaceC0668w1 interfaceC0668w1) {
        this(context, interfaceC0668w1, new C0722y5(context));
    }

    public final void a() {
        this.e.c(new P1() { // from class: io.appmetrica.analytics.impl.J1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.P1
            public final void a(Intent intent) {
                J1.this.d(intent);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void c(Intent intent) {
        Q1 q1 = this.e;
        if (intent != null) {
            q1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                q1.f589a.a(action, Integer.valueOf(Q1.a(intent)));
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
        Ga.F.u().a(AbstractC0753zb.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void onConfigurationChanged(Configuration configuration) {
        Ga.F.u().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void onCreate() {
        if (!this.f484a) {
            this.g.b(this.b);
            Ga ga = Ga.F;
            synchronized (ga) {
                ga.B.initAsync();
                ga.u.a(ga.f444a);
                ga.u.a(new Cdo(ga.B));
                NetworkServiceLocator.init();
                ga.k().a(ga.q);
                ga.C();
            }
            AbstractC0214dk.f809a.e();
            C0241em c0241em = Ga.F.u;
            c0241em.b();
            C0190cm b = c0241em.b();
            C0662vk o = Ga.F.o();
            o.a(new C0314hk(new C0605td(this.e)), b);
            c0241em.a(o);
            ((C0713xl) Ga.F.y()).getClass();
            a();
            Ga.F.l().init();
            Ga.F.b().init();
            K1 k1 = this.i;
            Context context = this.b;
            C0671w4 c0671w4 = this.d;
            k1.getClass();
            this.f = new C0211dh(context, c0671w4);
            Context context2 = this.b;
            AbstractC0519q1.f999a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            C0211dh c0211dh = this.f;
            C0156be q = Ga.j().q();
            IHandlerExecutor e = Ga.j().w().e();
            C0748z6 c0748z6 = new C0748z6(context3, c0211dh, EnumC0628ub.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new W(), new BlockingExecutor(), "previous");
            C0748z6 c0748z62 = new C0748z6(context3, c0211dh, EnumC0628ub.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Fb(), e, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                FileObserverC0698x6 fileObserverC0698x6 = new FileObserverC0698x6(crashesDirectory, c0748z62, new C0602ta());
                e.execute(new RunnableC0260fg(crashesDirectory, c0748z6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                fileObserverC0698x6.startWatching();
                Ga.F.E.storeReference(fileObserverC0698x6);
            }
            q.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                q.f770a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = q.f770a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    Wd b2 = q.b.b(context3, c0211dh);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                q.f770a.setDefaultCrashHandler(q.b.a(context3, c0211dh));
            }
            new RunnableC0148b6(CollectionsKt.listOf(new RunnableC0360jh())).run();
            this.f484a = true;
        } else {
            Ga.F.u().a(this.b.getResources().getConfiguration());
        }
        Ga.F.k().a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void onDestroy() {
        Yb k = Ga.F.k();
        synchronized (k) {
            Iterator it = k.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0513pk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void pauseUserSession(Bundle bundle) {
        Nf nf;
        bundle.setClassLoader(Nf.class.getClassLoader());
        String str = Nf.c;
        try {
            nf = (Nf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            nf = null;
        }
        Integer asInteger = nf != null ? nf.f554a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0338ik> list = (List) Ga.F.v.f895a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0338ik interfaceC0338ik : list) {
            interfaceC0338ik.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void resumeUserSession(Bundle bundle) {
        Nf nf;
        bundle.setClassLoader(Nf.class.getClassLoader());
        String str = Nf.c;
        try {
            nf = (Nf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            nf = null;
        }
        Integer asInteger = nf != null ? nf.f554a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public J1(Context context, InterfaceC0668w1 interfaceC0668w1, C0722y5 c0722y5) {
        this(context, interfaceC0668w1, new C0671w4(context, c0722y5), new Q1(), C0702xa.d, Ga.j().d(), new K1());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(Intent intent) {
        Q1 q1 = this.e;
        if (intent != null) {
            q1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                q1.f589a.a(action, Integer.valueOf(Q1.a(intent)));
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

    public J1(Context context, InterfaceC0668w1 interfaceC0668w1, C0671w4 c0671w4, Q1 q1, C0702xa c0702xa, C0420m2 c0420m2, K1 k1) {
        this.f484a = false;
        this.b = context;
        this.c = interfaceC0668w1;
        this.d = c0671w4;
        this.e = q1;
        this.g = c0702xa;
        this.h = c0420m2;
        this.i = k1;
        this.j = new C0485oh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        C0325i6.b(bundle);
        C0211dh c0211dh = this.f;
        if (c0211dh != null) {
            c0211dh.a(C0325i6.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(InterfaceC0668w1 interfaceC0668w1) {
        this.c = interfaceC0668w1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(Intent intent, int i) {
        ((C0618u1) this.c).f1066a.stopSelfResult(i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(Intent intent, int i, int i2) {
        ((C0618u1) this.c).f1066a.stopSelfResult(i2);
    }
}
