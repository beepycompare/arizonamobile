package com.arizona.game;

import ru.mrlargha.commonui.core.UIElementID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class GameTestBackendHarnessController {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void armIfEnabled() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFrontendMessageDelivered(UIElementID uiElementID) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onLiveFrontendMessage(int frontendId, UIElementID uiElementID, int subId, String message, boolean allowDebugLoginStart, boolean recordTrace) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onVisibilityApplied(UIElementID uiElementID, boolean visibility) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldSuppressVisibilityChange(UIElementID uiElementID, boolean visibility) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
    }

    GameTestBackendHarnessController() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GameTestBackendHarnessController create(GTASA gtasa) {
        return new GameTestBackendHarnessController();
    }
}
