package com.arizona.launcher.util;

import android.util.Log;
import com.google.firebase.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigKt;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: FileServers.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/arizona/launcher/util/FileServers;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "FALLBACK_MAIN_ARIZONA", "FALLBACK_RESERVE_ARIZONA", "FALLBACK_MAIN_RODINA", "FALLBACK_RESERVE_RODINA", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "mainChannelArizona", "getMainChannelArizona", "()Ljava/lang/String;", "mainChannelRodina", "getMainChannelRodina", "reserveChannelArizona", "getReserveChannelArizona", "reserveChannelRodina", "getReserveChannelRodina", "game_servers", "", "getGame_servers", "()[Ljava/lang/String;", "serversIndex", "", "initConnection", "", "initReachableConnection", "", "currentServerIsUnreachable", "getCurrentServer", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileServers {
    private static final String FALLBACK_MAIN_ARIZONA = "https://mob.maz-ins.com";
    private static final String FALLBACK_MAIN_RODINA = "https://mob.azinternal.com";
    private static final String FALLBACK_RESERVE_ARIZONA = "https://arz-mob.react-group.tech";
    private static final String FALLBACK_RESERVE_RODINA = "https://rod-mob.react-group.tech";
    private static boolean initConnection;
    private static int serversIndex;
    public static final FileServers INSTANCE = new FileServers();
    private static final String TAG = FileServers.class.getCanonicalName();
    public static final int $stable = 8;

    private FileServers() {
    }

    private final FirebaseRemoteConfig getRemoteConfig() {
        return RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE);
    }

    private final String getMainChannelArizona() {
        String string = getRemoteConfig().getString("main_channel_arizona");
        if (StringsKt.isBlank(string)) {
            string = FALLBACK_MAIN_ARIZONA;
        }
        Intrinsics.checkNotNullExpressionValue(string, "ifBlank(...)");
        return string;
    }

    private final String getMainChannelRodina() {
        String string = getRemoteConfig().getString("main_channel_rodina");
        if (StringsKt.isBlank(string)) {
            string = FALLBACK_MAIN_RODINA;
        }
        Intrinsics.checkNotNullExpressionValue(string, "ifBlank(...)");
        return string;
    }

    private final String getReserveChannelArizona() {
        String string = getRemoteConfig().getString("reserve_channel_arizona");
        if (StringsKt.isBlank(string)) {
            string = FALLBACK_RESERVE_ARIZONA;
        }
        Intrinsics.checkNotNullExpressionValue(string, "ifBlank(...)");
        return string;
    }

    private final String getReserveChannelRodina() {
        String string = getRemoteConfig().getString("reserve_channel_rodina");
        if (StringsKt.isBlank(string)) {
            string = FALLBACK_RESERVE_RODINA;
        }
        Intrinsics.checkNotNullExpressionValue(string, "ifBlank(...)");
        return string;
    }

    public final String[] getGame_servers() {
        int hashCode = "release".hashCode();
        return (hashCode == -1897523141 ? !"release".equals("staging") : hashCode == 95458899 ? !"release".equals("debug") : !(hashCode == 862681341 && "release".equals("public_debug"))) ? new String[]{getMainChannelArizona() + "/game/release/", getReserveChannelArizona() + "/game/release/"} : new String[]{getMainChannelArizona() + "/game/staging/", getReserveChannelArizona() + "/game/staging/"};
    }

    public final void initReachableConnection() {
        String[] game_servers = getGame_servers();
        Log.d(TAG, "initReachableConnection: " + ArraysKt.joinToString$default(game_servers, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        int length = game_servers.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = game_servers[i];
            int i3 = i2 + 1;
            if (FirebaseConfigHelper.INSTANCE.isServiceAvailable(str)) {
                Log.w(TAG, "File server: Use - " + str);
                serversIndex = i2;
                return;
            }
            Log.w(TAG, "File server: Unreachable - " + str);
            i++;
            i2 = i3;
        }
        serversIndex = 0;
        Log.w(TAG, "File server: No reachable server found, use - " + ArraysKt.first(game_servers));
    }

    public final void currentServerIsUnreachable() {
        int i = serversIndex + 1;
        serversIndex = i;
        if (i >= getGame_servers().length) {
            serversIndex = 0;
        }
        Log.w(TAG, "File server: Change to - " + getGame_servers()[serversIndex]);
    }

    public final String getCurrentServer() {
        if (!initConnection) {
            initReachableConnection();
            initConnection = true;
        }
        return getGame_servers()[serversIndex];
    }
}
