package com.miami.game.core.play.country.billing;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;
/* loaded from: classes3.dex */
public final class BillingPlayCountryResolver_Factory implements Factory<BillingPlayCountryResolver> {
    private final Provider<Context> contextProvider;

    private BillingPlayCountryResolver_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BillingPlayCountryResolver get() {
        return newInstance(this.contextProvider.get());
    }

    public static BillingPlayCountryResolver_Factory create(Provider<Context> provider) {
        return new BillingPlayCountryResolver_Factory(provider);
    }

    public static BillingPlayCountryResolver newInstance(Context context) {
        return new BillingPlayCountryResolver(context);
    }
}
