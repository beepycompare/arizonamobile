package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0730y3;
import io.appmetrica.analytics.impl.Gl;
import io.appmetrica.analytics.impl.Il;
import io.appmetrica.analytics.impl.InterfaceC0406lg;
import io.appmetrica.analytics.impl.Kl;
import io.appmetrica.analytics.impl.Oe;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class ECommerceEvent implements InterfaceC0406lg {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0730y3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new Oe(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new Oe(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0730y3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new Gl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new Il(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new Kl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lg
    public abstract /* synthetic */ List toProto();
}
