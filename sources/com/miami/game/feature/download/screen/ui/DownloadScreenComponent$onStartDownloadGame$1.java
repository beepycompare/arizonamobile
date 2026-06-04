package com.miami.game.feature.download.screen.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadScreenComponent.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.screen.ui.DownloadScreenComponent", f = "DownloadScreenComponent.kt", i = {}, l = {131}, m = "onStartDownloadGame", n = {}, nl = {132}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class DownloadScreenComponent$onStartDownloadGame$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadScreenComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadScreenComponent$onStartDownloadGame$1(DownloadScreenComponent downloadScreenComponent, Continuation<? super DownloadScreenComponent$onStartDownloadGame$1> continuation) {
        super(continuation);
        this.this$0 = downloadScreenComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object onStartDownloadGame;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        onStartDownloadGame = this.this$0.onStartDownloadGame(this);
        return onStartDownloadGame;
    }
}
