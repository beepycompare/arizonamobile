package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0152bl;
import io.appmetrica.analytics.impl.C0204dl;
import io.appmetrica.analytics.impl.C0255fl;
import io.appmetrica.analytics.impl.C0289h3;
import io.appmetrica.analytics.impl.C0452ne;
import io.appmetrica.analytics.impl.Kf;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class ECommerceEvent implements Kf {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0289h3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new C0452ne(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new C0452ne(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0289h3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0152bl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0204dl(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0255fl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.Kf
    public abstract /* synthetic */ List toProto();
}
