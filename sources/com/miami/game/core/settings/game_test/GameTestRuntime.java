package com.miami.game.core.settings.game_test;

import androidx.core.app.NotificationCompat;
import com.miami.game.core.settings.game_test.GameTestStep;
import kotlin.Metadata;
/* compiled from: GameTestScriptRunner.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0018H&J\u001c\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\bH&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\"H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\bH&¨\u0006'À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestRuntime;", "", "notifyClick", "", "step", "Lcom/miami/game/core/settings/game_test/GameTestStep$NotifyClick;", "sendChat", "text", "", "tap", "Lcom/miami/game/core/settings/game_test/GameTestStep$Tap;", "swipe", "Lcom/miami/game/core/settings/game_test/GameTestStep$Swipe;", "captureScreenshot", "Lcom/miami/game/core/settings/game_test/GameTestStep$Screenshot;", "showUi", "Lcom/miami/game/core/settings/game_test/GameTestStep$ShowUi;", "hideUi", "Lcom/miami/game/core/settings/game_test/GameTestStep$HideUi;", "dispatchBackendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/miami/game/core/settings/game_test/BackendFixtureEvent;", "loadBackendFixture", "Lcom/miami/game/core/settings/game_test/BackendFixture;", "Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;", "previewBackendFixture", "", "fixture", "providerOverride", "validateBackendFixture", "startBackendTrace", "traceName", "stopBackendTrace", "startBackendValidation", "Lcom/miami/game/core/settings/game_test/GameTestStep$StartBackendValidation;", "stopBackendValidation", "closeAll", "log", "message", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GameTestRuntime {
    void captureScreenshot(GameTestStep.Screenshot screenshot);

    void closeAll();

    void dispatchBackendEvent(BackendFixtureEvent backendFixtureEvent);

    void hideUi(GameTestStep.HideUi hideUi);

    BackendFixture loadBackendFixture(GameTestStep.ReplayBackendFixture replayBackendFixture);

    void log(String str);

    void notifyClick(GameTestStep.NotifyClick notifyClick);

    boolean previewBackendFixture(BackendFixture backendFixture, String str);

    void sendChat(String str);

    void showUi(GameTestStep.ShowUi showUi);

    void startBackendTrace(String str);

    void startBackendValidation(GameTestStep.StartBackendValidation startBackendValidation);

    void stopBackendTrace();

    void stopBackendValidation();

    void swipe(GameTestStep.Swipe swipe);

    void tap(GameTestStep.Tap tap);

    void validateBackendFixture(BackendFixture backendFixture, String str);

    /* compiled from: GameTestScriptRunner.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ boolean previewBackendFixture$default(GameTestRuntime gameTestRuntime, BackendFixture backendFixture, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            return gameTestRuntime.previewBackendFixture(backendFixture, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: previewBackendFixture");
    }

    static /* synthetic */ void validateBackendFixture$default(GameTestRuntime gameTestRuntime, BackendFixture backendFixture, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateBackendFixture");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        gameTestRuntime.validateBackendFixture(backendFixture, str);
    }

    static /* synthetic */ void startBackendTrace$default(GameTestRuntime gameTestRuntime, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startBackendTrace");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        gameTestRuntime.startBackendTrace(str);
    }
}
