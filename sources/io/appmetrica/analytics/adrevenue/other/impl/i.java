package io.appmetrica.analytics.adrevenue.other.impl;

import android.os.Bundle;
import com.facebook.ads.AdSDKNotificationListener;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class i implements AdSDKNotificationListener {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f240a;
    public final h b;

    public i(ClientContext clientContext, h hVar) {
        this.f240a = clientContext;
        this.b = hVar;
    }

    public final void onAdEvent(String str, Bundle bundle) {
        if (Intrinsics.areEqual(str, "impression")) {
            InternalClientModuleFacade internalClientModuleFacade = this.f240a.getInternalClientModuleFacade();
            this.b.getClass();
            BigDecimal bigDecimal = BigDecimal.ZERO;
            Currency currency = Currency.getInstance("USD");
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("source", "facebook");
            pairArr[1] = TuplesKt.to(AdRevenueConstants.ORIGINAL_SOURCE_KEY, "ad-revenue-other");
            pairArr[2] = TuplesKt.to(AdRevenueConstants.ORIGINAL_AD_TYPE_KEY, AbstractJsonLexerKt.NULL);
            JSONObject jSONObject = new JSONObject();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                jSONObject.put(str2, obj != null ? obj.toString() : null);
            }
            pairArr[3] = TuplesKt.to("raw_payload", jSONObject.toString());
            internalClientModuleFacade.reportAdRevenue(new ModuleAdRevenue(bigDecimal, currency, null, "facebook", null, null, null, null, null, MapsKt.hashMapOf(pairArr), true));
        }
    }
}
