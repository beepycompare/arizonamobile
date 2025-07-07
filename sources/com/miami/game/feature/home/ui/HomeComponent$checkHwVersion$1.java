package com.miami.game.feature.home.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeComponent.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent", f = "HomeComponent.kt", i = {}, l = {107, 109}, m = "checkHwVersion", n = {}, s = {})
/* loaded from: classes4.dex */
public final class HomeComponent$checkHwVersion$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeComponent$checkHwVersion$1(HomeComponent homeComponent, Continuation<? super HomeComponent$checkHwVersion$1> continuation) {
        super(continuation);
        this.this$0 = homeComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object checkHwVersion;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkHwVersion = this.this$0.checkHwVersion(this);
        return checkHwVersion;
    }
}
