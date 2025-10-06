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
public final class L1 implements InterfaceC0748z1, InterfaceC0547r0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f550a;
    public final Context b;
    public volatile InterfaceC0723y1 c;
    public final C0751z4 d;
    public final S1 e;
    public C0489oh f;
    public final Ea g;
    public final C0474o2 h;
    public final M1 i;
    public final C0764zh j;

    public L1(Context context, InterfaceC0723y1 interfaceC0723y1) {
        this(context, interfaceC0723y1, new B5(context));
    }

    public final void a() {
        this.e.c(new R1() { // from class: io.appmetrica.analytics.impl.L1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.R1
            public final void a(Intent intent) {
                L1.this.d(intent);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void c(Intent intent) {
        S1 s1 = this.e;
        if (intent != null) {
            s1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                s1.f663a.a(action, Integer.valueOf(S1.a(intent)));
            }
            for (Map.Entry entry : s1.b.entrySet()) {
                R1 r1 = (R1) entry.getKey();
                if (((Q1) entry.getValue()).a(intent)) {
                    r1.a(intent);
                }
            }
            return;
        }
        s1.getClass();
    }

    public final void d(Intent intent) {
        Na.F.u().a(Gb.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void onConfigurationChanged(Configuration configuration) {
        Na.F.u().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void onCreate() {
        if (!this.f550a) {
            this.g.b(this.b);
            Na na = Na.F;
            synchronized (na) {
                na.B.initAsync();
                na.u.a(na.f594a);
                na.u.a(new po(na.B));
                NetworkServiceLocator.init(new D5(new Li(na.g()), new N5(na.f594a)));
                na.k().a(na.q);
                na.C();
            }
            AbstractC0518pk.f1038a.e();
            C0545qm c0545qm = Na.F.u;
            c0545qm.b();
            C0494om b = c0545qm.b();
            Hk o = Na.F.o();
            o.a(new C0617tk(new Ad(this.e)), b);
            c0545qm.a(o);
            ((Jl) Na.F.y()).getClass();
            a();
            Na.F.l().init();
            Na.F.b().init();
            M1 m1 = this.i;
            Context context = this.b;
            C0751z4 c0751z4 = this.d;
            m1.getClass();
            this.f = new C0489oh(context, c0751z4);
            Context context2 = this.b;
            AbstractC0573s1.f1075a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            C0489oh c0489oh = this.f;
            C0356je q = Na.j().q();
            IHandlerExecutor e = Na.j().w().e();
            F6 f6 = new F6(context3, c0489oh, Bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new W(), new BlockingExecutor(), "previous");
            F6 f62 = new F6(context3, c0489oh, Bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Mb(), e, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                D6 d6 = new D6(crashesDirectory, f62, new Aa());
                e.execute(new RunnableC0539qg(crashesDirectory, f6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                d6.startWatching();
                Na.F.E.storeReference(d6);
            }
            q.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                q.f940a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = q.f940a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    C0227ee b2 = q.b.b(context3, c0489oh);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                q.f940a.setDefaultCrashHandler(q.b.a(context3, c0489oh));
            }
            new RunnableC0297h6(CollectionsKt.listOf(new RunnableC0639uh())).run();
            this.f550a = true;
        } else {
            Na.F.u().a(this.b.getResources().getConfiguration());
        }
        Na.F.k().a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void onDestroy() {
        C0251fc k = Na.F.k();
        synchronized (k) {
            Iterator it = k.c.iterator();
            while (it.hasNext()) {
                ((Bk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void pauseUserSession(Bundle bundle) {
        Vf vf;
        bundle.setClassLoader(Vf.class.getClassLoader());
        String str = Vf.c;
        try {
            vf = (Vf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            vf = null;
        }
        Integer asInteger = vf != null ? vf.f713a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0642uk> list = (List) Na.F.v.f1130a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0642uk interfaceC0642uk : list) {
            interfaceC0642uk.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void resumeUserSession(Bundle bundle) {
        Vf vf;
        bundle.setClassLoader(Vf.class.getClassLoader());
        String str = Vf.c;
        try {
            vf = (Vf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            vf = null;
        }
        Integer asInteger = vf != null ? vf.f713a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public L1(Context context, InterfaceC0723y1 interfaceC0723y1, B5 b5) {
        this(context, interfaceC0723y1, new C0751z4(context, b5), new S1(), Ea.d, Na.j().d(), new M1());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void a(Intent intent) {
        S1 s1 = this.e;
        if (intent != null) {
            s1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                s1.f663a.a(action, Integer.valueOf(S1.a(intent)));
            }
            for (Map.Entry entry : s1.b.entrySet()) {
                R1 r1 = (R1) entry.getKey();
                if (((Q1) entry.getValue()).a(intent)) {
                    r1.a(intent);
                }
            }
            return;
        }
        s1.getClass();
    }

    public L1(Context context, InterfaceC0723y1 interfaceC0723y1, C0751z4 c0751z4, S1 s1, Ea ea, C0474o2 c0474o2, M1 m1) {
        this.f550a = false;
        this.b = context;
        this.c = interfaceC0723y1;
        this.d = c0751z4;
        this.e = s1;
        this.g = ea;
        this.h = c0474o2;
        this.i = m1;
        this.j = new C0764zh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        C0478o6.b(bundle);
        C0489oh c0489oh = this.f;
        if (c0489oh != null) {
            c0489oh.a(C0478o6.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void a(InterfaceC0723y1 interfaceC0723y1) {
        this.c = interfaceC0723y1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void a(Intent intent, int i) {
        ((C0673w1) this.c).f1134a.stopSelfResult(i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0748z1
    public final void a(Intent intent, int i, int i2) {
        ((C0673w1) this.c).f1134a.stopSelfResult(i2);
    }
}
