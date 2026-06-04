package com.miami.game.core.design.system.component.background;

import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter", f = "BackgroundManager.kt", i = {0, 1, 1, 1}, l = {115, 121}, m = "loadLocal", n = {UtilsKt.SCHEME_FILE, "t", "$this$loadLocal_u24lambda_u240", "fallbackFile"}, nl = {116, 122}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes5.dex */
public final class LauncherBackgroundWriter$loadLocal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LauncherBackgroundWriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherBackgroundWriter$loadLocal$1(LauncherBackgroundWriter launcherBackgroundWriter, Continuation<? super LauncherBackgroundWriter$loadLocal$1> continuation) {
        super(continuation);
        this.this$0 = launcherBackgroundWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadLocal;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadLocal = this.this$0.loadLocal(this);
        return loadLocal;
    }
}
