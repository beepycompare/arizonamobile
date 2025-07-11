package com.miami.game.feature.download.dialog.ui.connection;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionHolder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionHolder;", "", "<init>", "()V", "onConnectTest", "Lkotlin/Function0;", "", "getOnConnectTest", "()Lkotlin/jvm/functions/Function0;", "setOnConnectTest", "(Lkotlin/jvm/functions/Function0;)V", "onStartGame", "getOnStartGame", "setOnStartGame", "onShareLogs", "getOnShareLogs", "setOnShareLogs", "onCheckGame", "getOnCheckGame", "setOnCheckGame", "settingsData", "Lcom/miami/game/feature/download/dialog/ui/connection/SettingsData;", "getSettingsData", "()Lcom/miami/game/feature/download/dialog/ui/connection/SettingsData;", "setSettingsData", "(Lcom/miami/game/feature/download/dialog/ui/connection/SettingsData;)V", "selectedServer", "Lcom/miami/game/feature/download/dialog/ui/connection/ServerModel;", "getSelectedServer", "()Lcom/miami/game/feature/download/dialog/ui/connection/ServerModel;", "setSelectedServer", "(Lcom/miami/game/feature/download/dialog/ui/connection/ServerModel;)V", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionHolder {
    public static final ConnectionHolder INSTANCE = new ConnectionHolder();
    private static Function0<Unit> onConnectTest = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit unit;
            unit = Unit.INSTANCE;
            return unit;
        }
    };
    private static Function0<Unit> onStartGame = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit unit;
            unit = Unit.INSTANCE;
            return unit;
        }
    };
    private static Function0<Unit> onShareLogs = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit unit;
            unit = Unit.INSTANCE;
            return unit;
        }
    };
    private static Function0<Unit> onCheckGame = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit unit;
            unit = Unit.INSTANCE;
            return unit;
        }
    };
    private static SettingsData settingsData = new SettingsData(0, 0, false, false, false, false, false, null, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
    private static ServerModel selectedServer = new ServerModel(0, null, null, null, false, 31, null);
    public static final int $stable = 8;

    private ConnectionHolder() {
    }

    public final Function0<Unit> getOnConnectTest() {
        return onConnectTest;
    }

    public final void setOnConnectTest(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onConnectTest = function0;
    }

    public final Function0<Unit> getOnStartGame() {
        return onStartGame;
    }

    public final void setOnStartGame(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onStartGame = function0;
    }

    public final Function0<Unit> getOnShareLogs() {
        return onShareLogs;
    }

    public final void setOnShareLogs(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onShareLogs = function0;
    }

    public final Function0<Unit> getOnCheckGame() {
        return onCheckGame;
    }

    public final void setOnCheckGame(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onCheckGame = function0;
    }

    public final SettingsData getSettingsData() {
        return settingsData;
    }

    public final void setSettingsData(SettingsData settingsData2) {
        Intrinsics.checkNotNullParameter(settingsData2, "<set-?>");
        settingsData = settingsData2;
    }

    public final ServerModel getSelectedServer() {
        return selectedServer;
    }

    public final void setSelectedServer(ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(serverModel, "<set-?>");
        selectedServer = serverModel;
    }
}
