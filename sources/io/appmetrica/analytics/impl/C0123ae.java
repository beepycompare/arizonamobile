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
/* renamed from: io.appmetrica.analytics.impl.ae  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0123ae implements NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f777a;
    public final IHandlerExecutor b = Ka.j().w().e();
    public final C0201de c;

    public C0123ae(Context context, C0384kh c0384kh, Function1<? super String, Unit> function1, InterfaceC0330ie interfaceC0330ie, EnumC0728yb enumC0728yb, String str) {
        this.f777a = function1;
        this.c = new C0201de(context, c0384kh, interfaceC0330ie, enumC0728yb);
    }

    public static final void a(C0123ae c0123ae, NativeCrash nativeCrash, File file) {
        c0123ae.f777a.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        B0 b0;
        C0677wa c0677wa;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String uuid = nativeCrash.getUuid();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            C0 a2 = D0.a(nativeCrash.getMetadata());
            Intrinsics.checkNotNull(a2);
            b0 = new B0(source, handlerVersion, uuid, dumpFile, creationTime, a2);
        } catch (Throwable unused) {
            b0 = null;
        }
        if (b0 != null) {
            LoggerStorage.getOrCreatePublicLogger(b0.f.f370a).info("Detected native crash with uuid = " + b0.c, new Object[0]);
            IHandlerExecutor iHandlerExecutor = this.b;
            C0201de c0201de = this.c;
            Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.ae$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                public final void consume(Object obj) {
                    C0123ae.a(C0123ae.this, nativeCrash, (File) obj);
                }
            };
            c0201de.getClass();
            Wd wd = new Wd(new Yd(b0.f354a, b0.b), c0201de.f);
            Td td = new Td(c0201de.b, b0.f, new C0175ce(b0, c0201de.d));
            C0702xa c0702xa = c0201de.e;
            String str = b0.d;
            c0702xa.getClass();
            File file = new File(str);
            Context context = c0201de.f830a;
            if (C0677wa.c == null) {
                synchronized (Reflection.getOrCreateKotlinClass(C0677wa.class)) {
                    if (C0677wa.c == null) {
                        C0677wa.c = new C0677wa(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            C0677wa c0677wa2 = C0677wa.c;
            if (c0677wa2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
                c0677wa = null;
            } else {
                c0677wa = c0677wa2;
            }
            iHandlerExecutor.execute(new RunnableC0409lg(file, wd, consumer, td, c0677wa, c0201de.c.a(b0)));
            return;
        }
        this.f777a.invoke(nativeCrash.getUuid());
    }
}
