package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C0174cl;
import io.appmetrica.analytics.impl.C0225el;
import io.appmetrica.analytics.impl.C0277gl;
import io.appmetrica.analytics.impl.C0311i3;
import io.appmetrica.analytics.impl.C0474oe;
import io.appmetrica.analytics.impl.Lf;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class ECommerceEvent implements Lf {
    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0311i3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new C0474oe(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new C0474oe(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C0311i3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0174cl(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0225el(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0277gl(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.Lf
    public abstract /* synthetic */ List toProto();
}
