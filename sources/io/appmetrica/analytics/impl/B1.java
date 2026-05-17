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
public final class B1 implements A1, InterfaceC0562s0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f512a;
    public final Context b;
    public final InterfaceC0738z1 c;
    public final C0109a4 d;
    public final J1 e;
    public Sg f;
    public final C0218ea g;
    public final C0262g2 h;
    public final C1 i;
    public final C0200dh j;

    public B1(Context context, InterfaceC0738z1 interfaceC0738z1) {
        this(context, interfaceC0738z1, new C0188d5(context));
    }

    public final void a() {
        this.e.c(new I1() { // from class: io.appmetrica.analytics.impl.B1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.I1
            public final void a(Intent intent) {
                B1.this.d(intent);
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
        J1 j1 = this.e;
        if (intent != null) {
            j1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                j1.f641a.a(action, Integer.valueOf(J1.a(intent)));
            }
            for (Map.Entry entry : j1.b.entrySet()) {
                I1 i1 = (I1) entry.getKey();
                if (((H1) entry.getValue()).a(intent)) {
                    i1.a(intent);
                }
            }
            return;
        }
        j1.getClass();
    }

    public final void d(Intent intent) {
        C0448na.I.v().a(AbstractC0271gb.e(intent.getStringExtra("screen_size")));
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onConfigurationChanged(Configuration configuration) {
        C0448na.I.v().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onCreate() {
        if (!this.f512a) {
            this.g.b(this.b);
            C0448na c0448na = C0448na.I;
            synchronized (c0448na) {
                c0448na.B.initAsync();
                c0448na.u.a(c0448na.f1138a);
                c0448na.u.a(new C0361jo(c0448na.B));
                NetworkServiceLocator.init(c0448na.f1138a, new C0239f5(new C0506pi(c0448na.h()), new C0493p5(c0448na.f1138a)));
                c0448na.l().a(c0448na.q);
                c0448na.E();
            }
            Wj.f846a.e();
            C0308hm c0308hm = C0448na.I.u;
            c0308hm.b();
            C0256fm b = c0308hm.b();
            C0707xk p = C0448na.I.p();
            p.a(new C0177ck(new C0118ad(this.e)), b);
            c0308hm.a(p);
            ((Al) C0448na.I.z()).getClass();
            a();
            C0448na.I.m().init();
            C0448na.I.c().init();
            C1 c1 = this.i;
            Context context = this.b;
            C0109a4 c0109a4 = this.d;
            c1.getClass();
            this.f = new Sg(context, c0109a4);
            Context context2 = this.b;
            AbstractC0613u1.f1250a.b(context2);
            AppMetrica.getReporter(context2, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Context context3 = this.b;
            Sg sg = this.f;
            Od r = C0448na.k().r();
            IHandlerExecutor d = C0448na.k().w().d();
            C0266g6 c0266g6 = new C0266g6(context3, sg, EnumC0142bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new X(), new BlockingExecutor(), "previous");
            C0266g6 c0266g62 = new C0266g6(context3, sg, EnumC0142bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new C0424mb(), d, "actual");
            File crashesDirectory = FileUtils.getCrashesDirectory(context3);
            if (crashesDirectory != null) {
                FileObserverC0214e6 fileObserverC0214e6 = new FileObserverC0214e6(crashesDirectory, c0266g62, new C0115aa());
                d.execute(new Uf(crashesDirectory, c0266g6));
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory() && crashesDirectory.delete()) {
                        crashesDirectory.mkdir();
                    }
                } else {
                    crashesDirectory.mkdir();
                }
                fileObserverC0214e6.startWatching();
                C0448na.I.E.storeReference(fileObserverC0214e6);
            }
            r.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                r.f728a.init(context3, new NativeCrashServiceConfig(absolutePath));
                List<NativeCrash> allCrashes = r.f728a.getAllCrashes();
                if (!allCrashes.isEmpty()) {
                    Jd b2 = r.b.b(context3, sg);
                    for (NativeCrash nativeCrash : allCrashes) {
                        b2.newCrash(nativeCrash);
                    }
                }
                r.f728a.setDefaultCrashHandler(r.b.a(context3, sg));
            }
            new I5(CollectionsKt.listOf(new Yg())).run();
            this.f512a = true;
        } else {
            C0448na.I.v().a(this.b.getResources().getConfiguration());
        }
        C0448na.I.l().a();
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void onDestroy() {
        Fb l = C0448na.I.l();
        synchronized (l) {
            Iterator it = l.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC0408lk) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void pauseUserSession(Bundle bundle) {
        Bf bf;
        bundle.setClassLoader(Bf.class.getClassLoader());
        String str = Bf.c;
        try {
            bf = (Bf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            bf = null;
        }
        Integer asInteger = bf != null ? bf.f525a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void reportData(int i, Bundle bundle) {
        this.j.getClass();
        List<InterfaceC0203dk> list = (List) C0448na.I.v.f986a.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list.isEmpty()) {
            return;
        }
        for (InterfaceC0203dk interfaceC0203dk : list) {
            interfaceC0203dk.reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void resumeUserSession(Bundle bundle) {
        Bf bf;
        bundle.setClassLoader(Bf.class.getClassLoader());
        String str = Bf.c;
        try {
            bf = (Bf) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            bf = null;
        }
        Integer asInteger = bf != null ? bf.f525a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.h.c(asInteger.intValue());
        }
    }

    public B1(Context context, InterfaceC0738z1 interfaceC0738z1, C0188d5 c0188d5) {
        this(context, interfaceC0738z1, new C0109a4(context, c0188d5), new J1(), C0218ea.d, C0448na.k().e(), new C1());
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent) {
        J1 j1 = this.e;
        if (intent != null) {
            j1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                j1.f641a.a(action, Integer.valueOf(J1.a(intent)));
            }
            for (Map.Entry entry : j1.b.entrySet()) {
                I1 i1 = (I1) entry.getKey();
                if (((H1) entry.getValue()).a(intent)) {
                    i1.a(intent);
                }
            }
            return;
        }
        j1.getClass();
    }

    public B1(Context context, InterfaceC0738z1 interfaceC0738z1, C0109a4 c0109a4, J1 j1, C0218ea c0218ea, C0262g2 c0262g2, C1 c1) {
        this.f512a = false;
        this.b = context;
        this.c = interfaceC0738z1;
        this.d = c0109a4;
        this.e = j1;
        this.g = c0218ea;
        this.h = c0262g2;
        this.i = c1;
        this.j = new C0200dh();
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        P5.b(bundle);
        Sg sg = this.f;
        if (sg != null) {
            sg.a(P5.b(bundle), bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent, int i) {
        ((C0612u0) this.c).f1249a.stopSelf(i);
    }

    @Override // io.appmetrica.analytics.impl.A1
    public final void a(Intent intent, int i, int i2) {
        ((C0612u0) this.c).f1249a.stopSelf(i2);
    }
}
