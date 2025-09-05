package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public final class Vg implements J {

    /* renamed from: a  reason: collision with root package name */
    public final String f709a;
    public final Ug b;

    public Vg(String str) {
        this(str, new Ug());
    }

    @Override // io.appmetrica.analytics.impl.J
    public final AdTrackingInfoResult a(Context context) {
        return a(context, new C0585se());
    }

    public final AdTrackingInfoResult b(Context context) {
        Method method = Class.forName("io.appmetrica.analytics.identifiers.internal.AdvIdentifiersProvider").getMethod("requestIdentifiers", Context.class, Bundle.class);
        Bundle bundle = new Bundle();
        bundle.putString("io.appmetrica.analytics.identifiers.extra.PROVIDER", this.f709a);
        Ug ug = this.b;
        Object[] objArr = {context, bundle};
        AdTrackingInfo adTrackingInfo = null;
        Bundle bundle2 = (Bundle) method.invoke(null, objArr);
        ug.getClass();
        if (bundle2 != null) {
            Bundle bundle3 = bundle2.getBundle("io.appmetrica.analytics.identifiers.extra.TRACKING_INFO");
            if (bundle3 != null) {
                Object obj = U5.f690a.get(bundle3.getString("io.appmetrica.analytics.identifiers.extra.PROVIDER"));
                if (obj != null) {
                    adTrackingInfo = new AdTrackingInfo((AdTrackingInfo.Provider) obj, bundle3.getString("io.appmetrica.analytics.identifiers.extra.ID"), bundle3.containsKey("io.appmetrica.analytics.identifiers.extra.LIMITED") ? Boolean.valueOf(bundle3.getBoolean("io.appmetrica.analytics.identifiers.extra.LIMITED")) : null);
                } else {
                    throw new IllegalArgumentException(("Provider " + bundle3.getString("io.appmetrica.analytics.identifiers.extra.PROVIDER") + " is invalid").toString());
                }
            }
            return new AdTrackingInfoResult(adTrackingInfo, IdentifierStatus.Companion.from(bundle2.getString("io.appmetrica.analytics.identifiers.extra.STATUS")), bundle2.getString("io.appmetrica.analytics.identifiers.extra.ERROR_MESSAGE"));
        }
        return null;
    }

    public Vg(String str, Ug ug) {
        this.f709a = str;
        this.b = ug;
    }

    @Override // io.appmetrica.analytics.impl.J
    public final AdTrackingInfoResult a(Context context, InterfaceC0180cj interfaceC0180cj) {
        AdTrackingInfoResult adTrackingInfoResult;
        AdTrackingInfoResult adTrackingInfoResult2;
        if (ReflectionUtils.detectClassExists("io.appmetrica.analytics.identifiers.internal.AdvIdentifiersProvider")) {
            Pn pn = (Pn) interfaceC0180cj;
            pn.c = 0;
            adTrackingInfoResult = null;
            while (pn.b()) {
                try {
                    return b(context);
                } catch (InvocationTargetException e) {
                    adTrackingInfoResult2 = new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, "exception while fetching " + this.f709a + " adv_id: " + (e.getTargetException() != null ? e.getTargetException().getMessage() : null));
                    adTrackingInfoResult = adTrackingInfoResult2;
                    try {
                        Thread.sleep(((Pn) interfaceC0180cj).b);
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    adTrackingInfoResult2 = new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, "exception while fetching " + this.f709a + " adv_id: " + th.getMessage());
                    adTrackingInfoResult = adTrackingInfoResult2;
                    Thread.sleep(((Pn) interfaceC0180cj).b);
                }
            }
        } else {
            adTrackingInfoResult = new AdTrackingInfoResult(null, IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, "Module io.appmetrica.analytics:analytics-identifiers does not exist");
        }
        return adTrackingInfoResult == null ? new AdTrackingInfoResult() : adTrackingInfoResult;
    }
}
