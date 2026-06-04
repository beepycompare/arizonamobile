package com.miami.game.feature.home.ui;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeComponent.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent", f = "HomeComponent.kt", i = {0, 1, 1, 1}, l = {327, 333}, m = "isShopAllowedForDetectedRegion", n = {"context", "context", "playCountryCode", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE}, nl = {328, 335}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes5.dex */
public final class HomeComponent$isShopAllowedForDetectedRegion$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeComponent$isShopAllowedForDetectedRegion$1(HomeComponent homeComponent, Continuation<? super HomeComponent$isShopAllowedForDetectedRegion$1> continuation) {
        super(continuation);
        this.this$0 = homeComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object isShopAllowedForDetectedRegion;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        isShopAllowedForDetectedRegion = this.this$0.isShopAllowedForDetectedRegion(null, this);
        return isShopAllowedForDetectedRegion;
    }
}
