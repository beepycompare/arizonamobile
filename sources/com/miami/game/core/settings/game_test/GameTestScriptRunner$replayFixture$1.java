package com.miami.game.core.settings.game_test;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner", f = "GameTestScriptRunner.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {DownloaderService.STATUS_PENDING}, m = "replayFixture", n = {"fixture", TypedValues.AttributesType.S_TARGET, "providerOverride", "$this$forEach$iv", "element$iv", NotificationCompat.CATEGORY_EVENT, "$i$f$forEach", "$i$a$-forEach-GameTestScriptRunner$replayFixture$2"}, nl = {192}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1"}, v = 2)
/* loaded from: classes4.dex */
public final class GameTestScriptRunner$replayFixture$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$replayFixture$1(GameTestScriptRunner gameTestScriptRunner, Continuation<? super GameTestScriptRunner$replayFixture$1> continuation) {
        super(continuation);
        this.this$0 = gameTestScriptRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object replayFixture;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        replayFixture = this.this$0.replayFixture(null, null, null, this);
        return replayFixture;
    }
}
