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
public final class Kd implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f650a;
    public final IHandlerExecutor b = C0470oa.k().w().d();
    public final Nd c;

    public Kd(Context context, Tg tg, Function1<? super String, Unit> function1, Sd sd, EnumC0164cb enumC0164cb, String str) {
        this.f650a = function1;
        this.c = new Nd(context, tg, sd, enumC0164cb);
    }

    public static final void a(Kd kd, NativeCrash nativeCrash, File file) {
        kd.f650a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        G0 g0;
        C0111aa c0111aa;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String uuid = nativeCrash.getUuid();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            H0 a2 = I0.a(nativeCrash.getMetadata());
            Intrinsics.checkNotNull(a2);
            g0 = new G0(source, handlerVersion, uuid, dumpFile, creationTime, a2);
        } catch (Throwable unused) {
            g0 = null;
        }
        if (g0 != null) {
            LoggerStorage.getOrCreatePublicLogger(g0.f.f596a).info("Detected native crash with uuid = " + g0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            Nd nd = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Kd$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    Kd.a(Kd.this, nativeCrash, (File) obj);
                }
            };
            nd.getClass();
            Gd gd = new Gd(new Id(g0.f584a, g0.b), nd.f);
            Dd dd = new Dd(nd.b, g0.f, new Md(g0, nd.d));
            C0137ba c0137ba = nd.e;
            String str = g0.d;
            c0137ba.getClass();
            File file = new File(str);
            Context context = nd.f702a;
            if (C0111aa.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0111aa.class)) {
                    if (C0111aa.c == null) {
                        C0111aa.c = new C0111aa(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0111aa c0111aa2 = C0111aa.c;
            if (c0111aa2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0111aa = null;
            } else {
                c0111aa = c0111aa2;
            }
            iHandlerExecutor.execute(new Uf(file, gd, consumer, dd, c0111aa, nd.c.a(g0)));
            return;
        }
        this.f650a.invoke(nativeCrash.getUuid());
    }
}
