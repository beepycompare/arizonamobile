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
    public boolean f506a;
    public final Context b;
    public volatile InterfaceC0668w1 c;
    public final C0671w4 d;
    public final Q1 e;
    public C0384kh f;
    public final Ba g;
    public final C0420m2 h;
    public final K1 i;
    public final C0659vh j;

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
                q1.f612a.a(action, Integer.valueOf(Q1.a(intent)));
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
        Ka.F.u().a(Db.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void onConfigurationChanged(Configuration configuration) {
        Ka.F.u().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void onCreate() {
        if (!this.f506a) {
            this.g.b(this.b);
            Ka ka = Ka.F;
            synchronized (ka) {
                ka.B.initAsync();
                ka.u.a(ka.f529a);
                ka.u.a(new lo(ka.B));
                NetworkServiceLocator.init(new A5(new Hi(ka.g()), new K5(ka.f529a)));
                ka.k().a(ka.q);
                ka.C();
            }
            AbstractC0413lk.f955a.e();
            C0440mm c0440mm = Ka.F.u;
            c0440mm.b();
            C0389km b = c0440mm.b();
            Dk o = Ka.F.o();
            o.a(new C0513pk(new C0705xd(this.e)), b);
            c0440mm.a(o);
            ((Fl) Ka.F.y()).getClass();
            a();
            Ka.F.l().init();
            Ka.F.b().init();
            K1 k1 = this.i;
            Context context = this.b;
            C0671w4 c0671w4 = this.d;
            k1.getClass();
            this.f = new C0384kh(context, c0671w4);
            Context context2 = this.b;
            AbstractC0519q1.f1019a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            C0384kh c0384kh = this.f;
            C0252fe q = Ka.j().q();
            IHandlerExecutor e = Ka.j().w().e();
            C6 c6 = new C6(context3, c0384kh, EnumC0728yb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new W(), new BlockingExecutor(), "previous");
            C6 c62 = new C6(context3, c0384kh, EnumC0728yb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Jb(), e, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                A6 a6 = new A6(crashesDirectory, c62, new C0702xa());
                e.execute(new RunnableC0434mg(crashesDirectory, c6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                a6.startWatching();
                Ka.F.E.storeReference(a6);
            }
            q.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                q.f856a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = q.f856a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    C0123ae b2 = q.b.b(context3, c0384kh);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                q.f856a.setDefaultCrashHandler(q.b.a(context3, c0384kh));
            }
            new RunnableC0218e6(CollectionsKt.listOf(new RunnableC0535qh())).run();
            this.f506a = true;
        } else {
            Ka.F.u().a(this.b.getResources().getConfiguration());
        }
        Ka.F.k().a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void onDestroy() {
        C0173cc k = Ka.F.k();
        synchronized (k) {
            Iterator it = k.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0712xk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void pauseUserSession(Bundle bundle) {
        Rf rf;
        bundle.setClassLoader(Rf.class.getClassLoader());
        String str = Rf.c;
        try {
            rf = (Rf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            rf = null;
        }
        Integer asInteger = rf != null ? rf.f635a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0538qk> list = (List) Ka.F.v.f1048a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0538qk interfaceC0538qk : list) {
            interfaceC0538qk.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void resumeUserSession(Bundle bundle) {
        Rf rf;
        bundle.setClassLoader(Rf.class.getClassLoader());
        String str = Rf.c;
        try {
            rf = (Rf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            rf = null;
        }
        Integer asInteger = rf != null ? rf.f635a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public J1(Context context, InterfaceC0668w1 interfaceC0668w1, C0722y5 c0722y5) {
        this(context, interfaceC0668w1, new C0671w4(context, c0722y5), new Q1(), Ba.d, Ka.j().d(), new K1());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(Intent intent) {
        Q1 q1 = this.e;
        if (intent != null) {
            q1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                q1.f612a.a(action, Integer.valueOf(Q1.a(intent)));
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

    public J1(Context context, InterfaceC0668w1 interfaceC0668w1, C0671w4 c0671w4, Q1 q1, Ba ba, C0420m2 c0420m2, K1 k1) {
        this.f506a = false;
        this.b = context;
        this.c = interfaceC0668w1;
        this.d = c0671w4;
        this.e = q1;
        this.g = ba;
        this.h = c0420m2;
        this.i = k1;
        this.j = new C0659vh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        C0399l6.b(bundle);
        C0384kh c0384kh = this.f;
        if (c0384kh != null) {
            c0384kh.a(C0399l6.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(InterfaceC0668w1 interfaceC0668w1) {
        this.c = interfaceC0668w1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(Intent intent, int i) {
        ((C0618u1) this.c).f1080a.stopSelfResult(i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0693x1
    public final void a(Intent intent, int i, int i2) {
        ((C0618u1) this.c).f1080a.stopSelfResult(i2);
    }
}
