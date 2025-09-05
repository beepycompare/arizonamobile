package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0388kl;
import io.appmetrica.analytics.impl.C0440ml;
import io.appmetrica.analytics.impl.C0492ol;
import io.appmetrica.analytics.impl.G3;
import io.appmetrica.analytics.impl.Ie;
import io.appmetrica.analytics.impl.InterfaceC0280gg;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class ECommerceEvent implements InterfaceC0280gg {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new G3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new Ie(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new Ie(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new G3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0388kl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0440ml(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0492ol(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0280gg
    public abstract /* synthetic */ List toProto();
}
