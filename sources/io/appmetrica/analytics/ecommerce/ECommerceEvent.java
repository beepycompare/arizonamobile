package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0252fl;
import io.appmetrica.analytics.impl.C0304hl;
import io.appmetrica.analytics.impl.C0355jl;
import io.appmetrica.analytics.impl.C0489p3;
import io.appmetrica.analytics.impl.C0624ue;
import io.appmetrica.analytics.impl.Pf;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class ECommerceEvent implements Pf {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0489p3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new C0624ue(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new C0624ue(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0489p3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0252fl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0304hl(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0355jl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.Pf
    public abstract /* synthetic */ List toProto();
}
