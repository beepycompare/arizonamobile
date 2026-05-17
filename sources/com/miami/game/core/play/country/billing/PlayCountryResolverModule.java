package com.miami.game.core.play.country.billing;

import com.miami.game.core.play.country.api.PlayCountryResolver;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
/* compiled from: PlayCountryResolverModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/miami/game/core/play/country/billing/PlayCountryResolverModule;", "", "<init>", "()V", "bindPlayCountryResolver", "Lcom/miami/game/core/play/country/api/PlayCountryResolver;", "resolver", "Lcom/miami/game/core/play/country/billing/BillingPlayCountryResolver;", "play-country-billing"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public abstract class PlayCountryResolverModule {
    @Binds
    public abstract PlayCountryResolver bindPlayCountryResolver(BillingPlayCountryResolver billingPlayCountryResolver);
}
