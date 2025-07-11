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
/* loaded from: classes4.dex */
public final class T implements Ta {

    /* renamed from: a  reason: collision with root package name */
    public final Context f632a;
    public final ICommonExecutor b;
    public FutureTask i;
    public final I j;
    public final String c = "advertising identifiers collecting is forbidden by client configuration";
    public final String d = "advertising identifiers collecting is forbidden by startup";
    public final String e = "advertising identifiers collecting is forbidden by unknown reason";
    public final M f = new M(new Kg(Constants.REFERRER_API_GOOGLE));
    public final M g = new M(new Kg("huawei"));
    public final M h = new M(new Kg("yandex"));
    public volatile AdvertisingIdsHolder k = new AdvertisingIdsHolder();
    public F l = new F(4, 4, 4);

    public T(Context context, ICommonExecutor iCommonExecutor, C0190cm c0190cm) {
        this.f632a = context;
        this.b = iCommonExecutor;
        this.j = new I(c0190cm);
    }

    public static final Void e(T t) {
        t.k = new AdvertisingIdsHolder(t.a(t.l.f418a, new P(t)), t.a(t.l.b, new Q(t)), t.a(t.l.c, new S(t, new C0382ke())));
        return null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter
    public final synchronized AdvertisingIdsHolder getIdentifiers(Context context) {
        return getIdentifiers();
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized void init() {
        if (this.i == null) {
            this.l = this.j.a();
            FutureTask futureTask = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.T$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return T.e(T.this);
                }
            });
            this.i = futureTask;
            this.b.execute(futureTask);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ta, io.appmetrica.analytics.impl.InterfaceC0316hm
    public final synchronized void a(C0190cm c0190cm) {
        this.j.a(c0190cm);
        a((Qi) new C0382ke(), false);
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized void b(boolean z) {
        this.j.b.update(z);
        a((Qi) new C0382ke(), false);
    }

    @Override // io.appmetrica.analytics.impl.Ta
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

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized AdvertisingIdsHolder a() {
        return a(new C0382ke());
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized AdvertisingIdsHolder a(Qi qi) {
        try {
            a(qi, true).get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.k;
    }

    public final FutureTask a(final Qi qi, final boolean z) {
        final F a2 = this.j.a();
        FutureTask futureTask = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.T$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return T.a(z, a2, this, qi);
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

    public static final Void a(boolean z, F f, T t, Qi qi) {
        if (z || !Intrinsics.areEqual(f, t.l)) {
            AdvertisingIdsHolder advertisingIdsHolder = t.k;
            AdTrackingInfoResult a2 = t.a(f.f418a, new P(t));
            AdTrackingInfoResult google = advertisingIdsHolder.getGoogle();
            IdentifierStatus identifierStatus = a2.mStatus;
            IdentifierStatus identifierStatus2 = IdentifierStatus.UNKNOWN;
            if (identifierStatus == identifierStatus2) {
                a2 = new AdTrackingInfoResult(google.mAdTrackingInfo, a2.mStatus, a2.mErrorExplanation);
            }
            AdTrackingInfoResult a3 = t.a(f.b, new Q(t));
            AdTrackingInfoResult huawei = advertisingIdsHolder.getHuawei();
            if (a3.mStatus == identifierStatus2) {
                a3 = new AdTrackingInfoResult(huawei.mAdTrackingInfo, a3.mStatus, a3.mErrorExplanation);
            }
            AdTrackingInfoResult a4 = t.a(f.c, new S(t, qi));
            AdTrackingInfoResult yandex = advertisingIdsHolder.getYandex();
            if (a4.mStatus == identifierStatus2) {
                a4 = new AdTrackingInfoResult(yandex.mAdTrackingInfo, a4.mStatus, a4.mErrorExplanation);
            }
            t.k = new AdvertisingIdsHolder(a2, a3, a4);
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
