package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameUpdateCheckRunner.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.GameUpdateCheckRunner", f = "GameUpdateCheckRunner.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {33, 37}, m = "run", n = {"initialServer", "metadataFileName", "isCurrent", "onMetadataLoaded", "onMirrorRetry", "prepare", "server", "mirrorCount", "attemptsLeft", "initialServer", "metadataFileName", "isCurrent", "onMetadataLoaded", "onMirrorRetry", "prepare", "server", "metadataResult", "mirrorCount", "attemptsLeft"}, nl = {34, 38}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"}, v = 2)
/* loaded from: classes3.dex */
public final class GameUpdateCheckRunner$run$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameUpdateCheckRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameUpdateCheckRunner$run$1(GameUpdateCheckRunner gameUpdateCheckRunner, Continuation<? super GameUpdateCheckRunner$run$1> continuation) {
        super(continuation);
        this.this$0 = gameUpdateCheckRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run(null, 0, null, null, null, null, null, this);
    }
}
