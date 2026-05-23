package io.appmetrica.analytics.impl;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class W implements InterfaceC0170cb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f814a;
    public final ICommonExecutor b;
    public FutureTask i;
    public final O l;
    public L n;
    public boolean o;
    public final String c = "advertising identifiers collecting is forbidden by client configuration";
    public final String d = "advertising identifiers collecting is forbidden by startup";
    public final String e = "advertising identifiers collecting is forbidden by unknown reason";
    public final K f = new K(new Og(Constants.REFERRER_API_GOOGLE));
    public final K g = new K(new Og("huawei"));
    public final K h = new K(new Og("yandex"));
    public final Lazy j = LazyKt.lazy(new S(this));
    public final long k = 90;
    public volatile AdvertisingIdsHolder m = new AdvertisingIdsHolder();

    public W(Context context, ICommonExecutor iCommonExecutor, Hm hm) {
        this.f814a = context;
        this.b = iCommonExecutor;
        this.l = new O(hm);
        M m = M.d;
        this.n = new L(m, m, m);
    }

    public static final Void f(W w) {
        w.m = new AdvertisingIdsHolder(w.a(w.n.f634a, new T(w)), w.a(w.n.b, new U(w)), w.a(w.n.c, new V(w, new C0742ye())));
        w.b.executeDelayed((FutureTask) w.j.getValue(), w.k, TimeUnit.SECONDS);
        return null;
    }

    public static final Void g(W w) {
        w.b();
        return null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsProvider
    public final synchronized AdvertisingIdsHolder getIdentifiers() {
        FutureTask futureTask = this.i;
        if (futureTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingRefreshTask");
            futureTask = null;
        }
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.m;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0170cb
    public final synchronized void init() {
        if (this.i == null) {
            this.n = this.l.a();
            FutureTask futureTask = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.W$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return W.f(W.this);
                }
            });
            this.i = futureTask;
            this.b.execute(futureTask);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0170cb, io.appmetrica.analytics.impl.Mm
    public final synchronized void a(Hm hm) {
        this.l.a(hm);
        a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0170cb
    public final synchronized void b(boolean z) {
        this.o = true;
        this.l.b.update(z);
        a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0170cb
    public final synchronized void c(boolean z) {
        if (!this.o) {
            b(z);
        }
    }

    public final void a() {
        L a2 = this.l.a();
        if (!Intrinsics.areEqual(a2, this.n)) {
            this.b.remove((FutureTask) this.j.getValue());
            this.n = a2;
            this.i = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.W$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return W.g(W.this);
                }
            });
        }
        ICommonExecutor iCommonExecutor = this.b;
        FutureTask futureTask = this.i;
        if (futureTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingRefreshTask");
            futureTask = null;
        }
        iCommonExecutor.execute(futureTask);
        if (this.i == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingRefreshTask");
        }
    }

    public final void b() {
        AdTrackingInfoResult a2 = a(this.n.f634a, new T(this));
        AdTrackingInfoResult google = this.m.getGoogle();
        IdentifierStatus identifierStatus = a2.mStatus;
        IdentifierStatus identifierStatus2 = IdentifierStatus.UNKNOWN;
        if (identifierStatus == identifierStatus2) {
            a2 = new AdTrackingInfoResult(google.mAdTrackingInfo, a2.mStatus, a2.mErrorExplanation);
        }
        AdTrackingInfoResult a3 = a(this.n.b, new U(this));
        AdTrackingInfoResult huawei = this.m.getHuawei();
        if (a3.mStatus == identifierStatus2) {
            a3 = new AdTrackingInfoResult(huawei.mAdTrackingInfo, a3.mStatus, a3.mErrorExplanation);
        }
        AdTrackingInfoResult a4 = a(this.n.c, new V(this, new C0441mo(3, ServiceStarter.ERROR_UNKNOWN)));
        AdTrackingInfoResult yandex = this.m.getYandex();
        if (a4.mStatus == identifierStatus2) {
            a4 = new AdTrackingInfoResult(yandex.mAdTrackingInfo, a4.mStatus, a4.mErrorExplanation);
        }
        this.m = new AdvertisingIdsHolder(a2, a3, a4);
        this.b.executeDelayed((FutureTask) this.j.getValue(), this.k, TimeUnit.SECONDS);
    }

    public final AdTrackingInfoResult a(M m, Function0 function0) {
        int ordinal = m.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, this.e);
                }
                return new AdTrackingInfoResult(null, IdentifierStatus.FEATURE_DISABLED, this.d);
            }
            return new AdTrackingInfoResult(null, IdentifierStatus.FORBIDDEN_BY_CLIENT_CONFIG, this.c);
        }
        return (AdTrackingInfoResult) function0.invoke();
    }
}
