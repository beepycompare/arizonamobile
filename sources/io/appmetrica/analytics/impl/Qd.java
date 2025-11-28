package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrash;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes5.dex */
public final class Qd implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f650a;
    public final IHandlerExecutor b = C0620ua.k().x().e();
    public final Td c;

    public Qd(Context context, Xg xg, Function1<? super String, Unit> function1, Yd yd, EnumC0320ib enumC0320ib, String str) {
        this.f650a = function1;
        this.c = new Td(context, xg, yd, enumC0320ib);
    }

    public static final void a(Qd qd, NativeCrash nativeCrash, File file) {
        qd.f650a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        E0 e0;
        C0267ga c0267ga;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String uuid = nativeCrash.getUuid();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            F0 a2 = G0.a(nativeCrash.getMetadata());
            Intrinsics.checkNotNull(a2);
            e0 = new E0(source, handlerVersion, uuid, dumpFile, creationTime, a2);
        } catch (Throwable unused) {
            e0 = null;
        }
        if (e0 != null) {
            LoggerStorage.getOrCreatePublicLogger(e0.f.f468a).info("Detected native crash with uuid = " + e0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            Td td = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Qd$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    Qd.a(Qd.this, nativeCrash, (File) obj);
                }
            };
            td.getClass();
            Md md = new Md(new Od(e0.f447a, e0.b), td.f);
            Jd jd = new Jd(td.b, e0.f, new Sd(e0, td.d));
            C0293ha c0293ha = td.e;
            String str = e0.d;
            c0293ha.getClass();
            File file = new File(str);
            Context context = td.f705a;
            if (C0267ga.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0267ga.class)) {
                    if (C0267ga.c == null) {
                        C0267ga.c = new C0267ga(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0267ga c0267ga2 = C0267ga.c;
            if (c0267ga2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0267ga = null;
            } else {
                c0267ga = c0267ga2;
            }
            iHandlerExecutor.execute(new Yf(file, md, consumer, jd, c0267ga, td.c.a(e0)));
            return;
        }
        this.f650a.invoke(nativeCrash.getUuid());
    }
}
