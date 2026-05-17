package io.appmetrica.analytics.impl;

import android.content.Context;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class U implements Aa {

    /* renamed from: a  reason: collision with root package name */
    public final Context f809a;
    public final ICommonExecutor b;
    public FutureTask i;
    public final J j;
    public boolean m;
    public final String c = "advertising identifiers collecting is forbidden by client configuration";
    public final String d = "advertising identifiers collecting is forbidden by startup";
    public final String e = "advertising identifiers collecting is forbidden by unknown reason";
    public final N f = new N(new C0753zg(Constants.REFERRER_API_GOOGLE));
    public final N g = new N(new C0753zg("huawei"));
    public final N h = new N(new C0753zg("yandex"));
    public volatile AdvertisingIdsHolder k = new AdvertisingIdsHolder();
    public G l = new G(4, 4, 4);

    public U(Context context, ICommonExecutor iCommonExecutor, C0256fm c0256fm) {
        this.f809a = context;
        this.b = iCommonExecutor;
        this.j = new J(c0256fm);
    }

    public static final Void e(U u) {
        u.k = new AdvertisingIdsHolder(u.a(u.l.f592a, new Q(u)), u.a(u.l.b, new S(u)), u.a(u.l.c, new T(u, new Xd())));
        return null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter
    public final synchronized AdvertisingIdsHolder getIdentifiers(Context context) {
        return getIdentifiers();
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final synchronized void init() {
        if (this.i == null) {
            this.l = this.j.a();
            FutureTask futureTask = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.U$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return U.e(U.this);
                }
            });
            this.i = futureTask;
            this.b.execute(futureTask);
        }
    }

    @Override // io.appmetrica.analytics.impl.Aa, io.appmetrica.analytics.impl.InterfaceC0385km
    public final synchronized void a(C0256fm c0256fm) {
        this.j.a(c0256fm);
        a((Gi) new Xd(), false);
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final synchronized void b(boolean z) {
        this.m = true;
        this.j.b.update(z);
        a((Gi) new Xd(), false);
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final synchronized void c(boolean z) {
        if (!this.m) {
            b(z);
        }
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final synchronized AdvertisingIdsHolder getIdentifiers() {
        FutureTask futureTask = this.i;
        if (futureTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refresh");
            futureTask = null;
        }
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.k;
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final synchronized AdvertisingIdsHolder a() {
        return a(new Xd());
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final synchronized AdvertisingIdsHolder a(Gi gi) {
        try {
            a(gi, true).get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.k;
    }

    public final FutureTask a(final Gi gi, final boolean z) {
        final G a2 = this.j.a();
        FutureTask futureTask = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.U$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return U.a(z, a2, this, gi);
            }
        });
        this.i = futureTask;
        this.b.execute(futureTask);
        FutureTask futureTask2 = this.i;
        if (futureTask2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refresh");
            return null;
        }
        return futureTask2;
    }

    public static final Void a(boolean z, G g, U u, Gi gi) {
        if (z || !Intrinsics.areEqual(g, u.l)) {
            AdvertisingIdsHolder advertisingIdsHolder = u.k;
            AdTrackingInfoResult a2 = u.a(g.f592a, new Q(u));
            AdTrackingInfoResult google = advertisingIdsHolder.getGoogle();
            IdentifierStatus identifierStatus = a2.mStatus;
            IdentifierStatus identifierStatus2 = IdentifierStatus.UNKNOWN;
            if (identifierStatus == identifierStatus2) {
                a2 = new AdTrackingInfoResult(google.mAdTrackingInfo, a2.mStatus, a2.mErrorExplanation);
            }
            AdTrackingInfoResult a3 = u.a(g.b, new S(u));
            AdTrackingInfoResult huawei = advertisingIdsHolder.getHuawei();
            if (a3.mStatus == identifierStatus2) {
                a3 = new AdTrackingInfoResult(huawei.mAdTrackingInfo, a3.mStatus, a3.mErrorExplanation);
            }
            AdTrackingInfoResult a4 = u.a(g.c, new T(u, gi));
            AdTrackingInfoResult yandex = advertisingIdsHolder.getYandex();
            if (a4.mStatus == identifierStatus2) {
                a4 = new AdTrackingInfoResult(yandex.mAdTrackingInfo, a4.mStatus, a4.mErrorExplanation);
            }
            u.k = new AdvertisingIdsHolder(a2, a3, a4);
            return null;
        }
        return null;
    }

    public final AdTrackingInfoResult a(int i, Function0 function0) {
        if (i != 0) {
            int i2 = i - 1;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
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
        throw null;
    }
}
