package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.appsetid.internal.IAppSetIdRetriever;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdProvider;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.a2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0107a2 implements AppSetIdProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f900a;
    public final IAppSetIdRetriever b;
    public volatile AppSetId c;
    public CountDownLatch d;
    public final long e;
    public final Z1 f;

    public C0107a2(Context context, IAppSetIdRetriever iAppSetIdRetriever) {
        this.f900a = context;
        this.b = iAppSetIdRetriever;
        this.d = new CountDownLatch(1);
        this.e = 20L;
        this.f = new Z1(this);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdProvider
    public final synchronized AppSetId getAppSetId() {
        AppSetId appSetId;
        if (this.c == null) {
            try {
                this.d = new CountDownLatch(1);
                this.b.retrieveAppSetId(this.f900a, this.f);
                this.d.await(this.e, TimeUnit.SECONDS);
            } catch (Throwable unused) {
            }
        }
        appSetId = this.c;
        if (appSetId == null) {
            appSetId = new AppSetId(null, AppSetIdScope.UNKNOWN);
            this.c = appSetId;
        }
        return appSetId;
    }

    public C0107a2(Context context) {
        this(context, AbstractC0133b2.a());
    }
}
