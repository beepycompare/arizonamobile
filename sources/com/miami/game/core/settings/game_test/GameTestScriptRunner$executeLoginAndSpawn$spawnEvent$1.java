package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class GameTestScriptRunner$executeLoginAndSpawn$spawnEvent$1 extends FunctionReferenceImpl implements Function1<GameTestBackendEvent, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GameTestScriptRunner$executeLoginAndSpawn$spawnEvent$1(Object obj) {
        super(1, obj, GameTestScriptRunner.class, "isSpawnOfferEvent", "isSpawnOfferEvent(Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(GameTestBackendEvent p0) {
        boolean isSpawnOfferEvent;
        Intrinsics.checkNotNullParameter(p0, "p0");
        isSpawnOfferEvent = ((GameTestScriptRunner) this.receiver).isSpawnOfferEvent(p0);
        return Boolean.valueOf(isSpawnOfferEvent);
    }
}
