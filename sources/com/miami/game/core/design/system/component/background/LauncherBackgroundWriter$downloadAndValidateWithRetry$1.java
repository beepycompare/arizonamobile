package com.miami.game.core.design.system.component.background;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter", f = "BackgroundManager.kt", i = {0, 0, 0, 0}, l = {313}, m = "downloadAndValidateWithRetry", n = {"remoteUrls", "tmp", "expectedHash", "attempt"}, nl = {315}, s = {"L$0", "L$1", "L$2", "I$2"}, v = 2)
/* loaded from: classes5.dex */
public final class LauncherBackgroundWriter$downloadAndValidateWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LauncherBackgroundWriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherBackgroundWriter$downloadAndValidateWithRetry$1(LauncherBackgroundWriter launcherBackgroundWriter, Continuation<? super LauncherBackgroundWriter$downloadAndValidateWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = launcherBackgroundWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object downloadAndValidateWithRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        downloadAndValidateWithRetry = this.this$0.downloadAndValidateWithRetry(null, null, null, this);
        return downloadAndValidateWithRetry;
    }
}
