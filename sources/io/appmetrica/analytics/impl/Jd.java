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
public final class Jd implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f642a;
    public final IHandlerExecutor b = C0449na.k().w().d();
    public final Md c;

    public Jd(Context context, Sg sg, Function1<? super String, Unit> function1, Rd rd, EnumC0143bb enumC0143bb, String str) {
        this.f642a = function1;
        this.c = new Md(context, sg, rd, enumC0143bb);
    }

    public static final void a(Jd jd, NativeCrash nativeCrash, File file) {
        jd.f642a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        G0 g0;
        Z9 z9;
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
            LoggerStorage.getOrCreatePublicLogger(g0.f.f605a).info("Detected native crash with uuid = " + g0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            Md md = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Jd$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    Jd.a(Jd.this, nativeCrash, (File) obj);
                }
            };
            md.getClass();
            Fd fd = new Fd(new Hd(g0.f588a, g0.b), md.f);
            Cd cd = new Cd(md.b, g0.f, new Ld(g0, md.d));
            C0116aa c0116aa = md.e;
            String str = g0.d;
            c0116aa.getClass();
            File file = new File(str);
            Context context = md.f693a;
            if (Z9.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(Z9.class)) {
                    if (Z9.c == null) {
                        Z9.c = new Z9(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Z9 z92 = Z9.c;
            if (z92 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                z9 = null;
            } else {
                z9 = z92;
            }
            iHandlerExecutor.execute(new Tf(file, fd, consumer, cd, z9, md.c.a(g0)));
            return;
        }
        this.f642a.invoke(nativeCrash.getUuid());
    }
}
