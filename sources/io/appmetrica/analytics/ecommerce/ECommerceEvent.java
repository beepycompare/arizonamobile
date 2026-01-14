package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0153bl;
import io.appmetrica.analytics.impl.C0205dl;
import io.appmetrica.analytics.impl.C0256fl;
import io.appmetrica.analytics.impl.C0290h3;
import io.appmetrica.analytics.impl.C0453ne;
import io.appmetrica.analytics.impl.Kf;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class ECommerceEvent implements Kf {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0290h3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new C0453ne(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new C0453ne(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0290h3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0153bl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0205dl(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0256fl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.Kf
    public abstract /* synthetic */ List toProto();
}
