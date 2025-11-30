package io.appmetrica.analytics.impl;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.ModulesFacade;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class F0 {

    /* renamed from: a  reason: collision with root package name */
    public final Cb f470a = new Cb(C0158c4.l().d());
    public final Db b = new Db();
    public final Fb c = new Fb();

    public final void a(final String str, final String str2, final String str3) {
        Cb cb = this.f470a;
        if (cb.c.a((Void) null).f1107a && cb.d.a(str).f1107a && cb.e.a(str2).f1107a && cb.f.a(str3).f1107a) {
            this.b.getClass();
            IHandlerExecutor a2 = C0158c4.l().c.a();
            ((A9) a2).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.F0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    F0.a(F0.this, str, str2, str3);
                }
            });
            return;
        }
        PublicLogger.Companion.getAnonymousInstance().warning("[AppMetricaLibraryAdapterProxy]" + ("Failed report event from sender: " + str + " with name = " + str2 + " and payload = " + str3), new Object[0]);
    }

    public static final void a(F0 f0, String str, String str2, String str3) {
        List<InterfaceC0584t> list;
        Context a2;
        Fb fb = f0.c;
        fb.getClass();
        Pair[] pairArr = new Pair[3];
        if (str == null) {
            str = AbstractJsonLexerKt.NULL;
        }
        pairArr[0] = TuplesKt.to("sender", str);
        if (str2 == null) {
            str2 = AbstractJsonLexerKt.NULL;
        }
        pairArr[1] = TuplesKt.to(NotificationCompat.CATEGORY_EVENT, str2);
        if (str3 == null) {
            str3 = AbstractJsonLexerKt.NULL;
        }
        pairArr[2] = TuplesKt.to("payload", str3);
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(pairArr);
        ModuleEvent.Builder withName = ModuleEvent.newBuilder(4).withName("appmetrica_system_event_42");
        synchronized (fb) {
            if (fb.f477a == null && (a2 = C0158c4.l().g.a()) != null) {
                fb.f477a = CollectionsKt.listOf((Object[]) new InterfaceC0584t[]{new Qd(), new C0280gn(a2), new Ko()});
            }
            list = fb.f477a;
        }
        if (list != null) {
            for (InterfaceC0584t interfaceC0584t : list) {
                interfaceC0584t.a(mutableMapOf);
            }
        }
        ModulesFacade.reportEvent(withName.withAttributes(mutableMapOf).build());
    }
}
