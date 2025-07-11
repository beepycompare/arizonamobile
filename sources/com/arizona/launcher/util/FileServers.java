package com.arizona.launcher.util;

import android.util.Log;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.ktx.RemoteConfigKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: FileServers.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u0005R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/arizona/launcher/util/FileServers;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "mainChannelArizona", "getMainChannelArizona", "()Ljava/lang/String;", "mainChannelRodina", "getMainChannelRodina", "reserveChannelArizona", "getReserveChannelArizona", "reserveChannelRodina", "getReserveChannelRodina", "game_servers", "", "getGame_servers", "()[Ljava/lang/String;", "[Ljava/lang/String;", "serversIndex", "", "initConnection", "", "initReachableConnection", "", "currentServerIsUnreachable", "getCurrentServer", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServers {
    public static final int $stable;
    public static final FileServers INSTANCE = new FileServers();
    private static final String TAG = FileServers.class.getCanonicalName();
    private static final String[] game_servers;
    private static boolean initConnection;
    private static final String mainChannelArizona;
    private static final String mainChannelRodina;
    private static final FirebaseRemoteConfig remoteConfig;
    private static final String reserveChannelArizona;
    private static final String reserveChannelRodina;
    private static int serversIndex;

    private FileServers() {
    }

    static {
        String[] strArr;
        FirebaseRemoteConfig remoteConfig2 = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE);
        remoteConfig = remoteConfig2;
        String string = remoteConfig2.getString("main_channel_arizona");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        mainChannelArizona = string;
        String string2 = remoteConfig2.getString("main_channel_rodina");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        mainChannelRodina = string2;
        String string3 = remoteConfig2.getString("reserve_channel_arizona");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        reserveChannelArizona = string3;
        String string4 = remoteConfig2.getString("reserve_channel_rodina");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        reserveChannelRodina = string4;
        int hashCode = "release_web".hashCode();
        if (hashCode == -1897523141) {
            if ("release_web".equals("staging")) {
                strArr = new String[]{string + "/game/staging/", string3 + "/game/staging/"};
            }
            strArr = new String[]{string + "/game/release/", string3 + "/game/release/"};
        } else if (hashCode != 95458899) {
            if (hashCode == 862681341 && "release_web".equals("public_debug")) {
                strArr = new String[]{string + "/game/staging/", string3 + "/game/staging/"};
            }
            strArr = new String[]{string + "/game/release/", string3 + "/game/release/"};
        } else {
            if ("release_web".equals("debug")) {
                strArr = new String[]{string + "/game/staging/", string3 + "/game/staging/"};
            }
            strArr = new String[]{string + "/game/release/", string3 + "/game/release/"};
        }
        game_servers = strArr;
        $stable = 8;
    }

    public final FirebaseRemoteConfig getRemoteConfig() {
        return remoteConfig;
    }

    public final String getMainChannelArizona() {
        return mainChannelArizona;
    }

    public final String getMainChannelRodina() {
        return mainChannelRodina;
    }

    public final String getReserveChannelArizona() {
        return reserveChannelArizona;
    }

    public final String getReserveChannelRodina() {
        return reserveChannelRodina;
    }

    public final String[] getGame_servers() {
        return game_servers;
    }

    public final void initReachableConnection() {
        String str = TAG;
        String[] strArr = game_servers;
        Log.d(str, "getReachableConnection: " + strArr);
        for (String str2 : strArr) {
            if ((FirebaseConfigHelper.INSTANCE.checkWithIsReachable(str2) || FirebaseConfigHelper.INSTANCE.checkWithUnixSystemPing(str2) || FirebaseConfigHelper.INSTANCE.checkWithLinuxNC(str2)) && FirebaseConfigHelper.INSTANCE.isServiceAvailable(str2)) {
                Log.w(TAG, "File server: Use - " + str2);
                serversIndex = ArraysKt.indexOf(game_servers, str2);
                return;
            }
            Log.w(TAG, "File server: Unreachable - " + str2);
        }
        serversIndex = 0;
        Log.w(TAG, "File server: No reachable server found, use - " + ArraysKt.first(game_servers));
    }

    public final void currentServerIsUnreachable() {
        int i = serversIndex + 1;
        serversIndex = i;
        String[] strArr = game_servers;
        if (i >= strArr.length) {
            serversIndex = 0;
        }
        Log.w(TAG, "File server: Change to - " + strArr[serversIndex]);
    }

    public final String getCurrentServer() {
        if (!initConnection) {
            initReachableConnection();
            initConnection = true;
        }
        return game_servers[serversIndex];
    }
}
