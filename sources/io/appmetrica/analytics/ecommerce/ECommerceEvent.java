package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0285gl;
import io.appmetrica.analytics.impl.C0336il;
import io.appmetrica.analytics.impl.C0388kl;
import io.appmetrica.analytics.impl.D3;
import io.appmetrica.analytics.impl.Ee;
import io.appmetrica.analytics.impl.InterfaceC0177cg;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class ECommerceEvent implements InterfaceC0177cg {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new D3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new Ee(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new Ee(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new D3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0285gl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0336il(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0388kl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0177cg
    public abstract /* synthetic */ List toProto();
}
