package com.arizona.game.core;
/* loaded from: classes3.dex */
public interface GameSettingsProvider {
    String getGameSettingsJson();

    default String getResourceOverlayConfigJson() {
        return "{}";
    }
}
