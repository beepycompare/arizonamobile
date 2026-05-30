package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.Period;
import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.concurrent.TimeUnit;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class o {
    public static byte[] a(ProductInfo productInfo) {
        String str;
        z zVar = new z();
        zVar.f279a = productInfo.quantity;
        zVar.f = productInfo.priceMicros;
        try {
            str = Currency.getInstance(productInfo.priceCurrency).getCurrencyCode();
        } catch (Throwable unused) {
            str = "";
        }
        Charset charset = Charsets.UTF_8;
        zVar.b = str.getBytes(charset);
        zVar.c = productInfo.sku.getBytes(charset);
        u uVar = new u();
        uVar.f274a = productInfo.purchaseOriginalJson.getBytes(charset);
        uVar.b = productInfo.signature.getBytes(charset);
        zVar.e = uVar;
        zVar.g = true;
        zVar.h = 1;
        int i = n.f268a[productInfo.type.ordinal()];
        zVar.i = (i == 1 || i != 2) ? 1 : 2;
        y yVar = new y();
        yVar.f278a = productInfo.purchaseToken.getBytes(charset);
        yVar.b = TimeUnit.MILLISECONDS.toSeconds(productInfo.purchaseTime);
        zVar.j = yVar;
        if (productInfo.type == ProductType.SUBS) {
            x xVar = new x();
            xVar.f277a = productInfo.autoRenewing;
            Period period = productInfo.subscriptionPeriod;
            if (period != null) {
                w wVar = new w();
                wVar.f276a = period.number;
                int i2 = n.b[period.timeUnit.ordinal()];
                wVar.b = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 4 : 3 : 2 : 1;
                xVar.b = wVar;
            }
            v vVar = new v();
            vVar.f275a = productInfo.introductoryPriceMicros;
            Period period2 = productInfo.introductoryPricePeriod;
            if (period2 != null) {
                w wVar2 = new w();
                wVar2.f276a = period2.number;
                int i3 = n.b[period2.timeUnit.ordinal()];
                wVar2.b = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? 0 : 4 : 3 : 2 : 1;
                vVar.b = wVar2;
            }
            vVar.c = productInfo.introductoryPriceCycles;
            xVar.c = vVar;
            zVar.k = xVar;
        }
        return MessageNano.toByteArray(zVar);
    }
}
