package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0164bl;
import io.appmetrica.analytics.impl.C0216dl;
import io.appmetrica.analytics.impl.C0267fl;
import io.appmetrica.analytics.impl.Ce;
import io.appmetrica.analytics.impl.D3;
import io.appmetrica.analytics.impl.Xf;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class ECommerceEvent implements Xf {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new D3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new Ce(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new Ce(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new D3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0164bl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0216dl(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0267fl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.Xf
    public abstract /* synthetic */ List toProto();
}
