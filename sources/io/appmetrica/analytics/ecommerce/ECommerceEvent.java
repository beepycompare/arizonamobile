package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.Ae;
import io.appmetrica.analytics.impl.C0137al;
import io.appmetrica.analytics.impl.C0189cl;
import io.appmetrica.analytics.impl.D3;
import io.appmetrica.analytics.impl.Vf;
import io.appmetrica.analytics.impl.Yk;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class ECommerceEvent implements Vf {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new D3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new Ae(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new Ae(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new D3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new Yk(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0137al(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0189cl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.Vf
    public abstract /* synthetic */ List toProto();
}
