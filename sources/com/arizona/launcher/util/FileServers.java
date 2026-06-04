package com.arizona.launcher.util;

import android.os.Looper;
import android.util.Log;
import com.google.firebase.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigKt;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: FileServers.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0002J\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020&J\u0006\u0010*\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0002¨\u0006+"}, d2 = {"Lcom/arizona/launcher/util/FileServers;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "FALLBACK_MAIN_ARIZONA", "FALLBACK_RESERVE_ARIZONA", "FALLBACK_MAIN_RODINA", "FALLBACK_RESERVE_RODINA", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "mainChannelArizona", "getMainChannelArizona", "()Ljava/lang/String;", "mainChannelRodina", "getMainChannelRodina", "reserveChannelArizona", "getReserveChannelArizona", "reserveChannelRodina", "getReserveChannelRodina", "buildServers", "", "()[Ljava/lang/String;", "game_servers", "getGame_servers", "serversIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "initConnection", "", "initStarted", "cachedServers", "[Ljava/lang/String;", "initLock", "initReachableConnection", "", "ensureInitialized", "warmUpAsync", "currentServerIsUnreachable", "getCurrentServer", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServers {
    public static final int $stable = 0;
    private static final String FALLBACK_MAIN_ARIZONA = "https://mob.maz-ins.com";
    private static final String FALLBACK_MAIN_RODINA = "https://mob.azinternal.com";
    private static final String FALLBACK_RESERVE_ARIZONA = "https://arz-mob.react-group.tech";
    private static final String FALLBACK_RESERVE_RODINA = "https://rod-mob.react-group.tech";
    private static volatile String[] cachedServers;
    private static volatile boolean initConnection;
    private static volatile boolean initStarted;
    public static final FileServers INSTANCE = new FileServers();
    private static final String TAG = FileServers.class.getCanonicalName();
    private static final AtomicInteger serversIndex = new AtomicInteger(0);
    private static final Object initLock = new Object();

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

    private final String[] buildServers() {
        int hashCode = "release".hashCode();
        return (hashCode == -1897523141 ? !"release".equals("staging") : hashCode == 95458899 ? !"release".equals("debug") : !(hashCode == 862681341 && "release".equals("public_debug"))) ? new String[]{getMainChannelArizona() + "/game/release/", getReserveChannelArizona() + "/game/release/"} : new String[]{getMainChannelArizona() + "/game/staging/", getReserveChannelArizona() + "/game/staging/"};
    }

    public final String[] getGame_servers() {
        String[] strArr;
        String[] strArr2 = cachedServers;
        if (strArr2 == null) {
            synchronized (initLock) {
                strArr = cachedServers;
                if (strArr == null) {
                    strArr = INSTANCE.buildServers();
                    cachedServers = strArr;
                }
            }
            return strArr;
        }
        return strArr2;
    }

    public final void initReachableConnection() {
        String[] buildServers;
        synchronized (initLock) {
            buildServers = INSTANCE.buildServers();
            cachedServers = buildServers;
        }
        Log.d(TAG, "initReachableConnection: " + ArraysKt.joinToString$default(buildServers, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        int length = buildServers.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = buildServers[i];
            int i3 = i2 + 1;
            if (FirebaseConfigHelper.INSTANCE.isServiceAvailable(str)) {
                Log.w(TAG, "File server: Use - " + str);
                serversIndex.set(i2);
                return;
            }
            Log.w(TAG, "File server: Unreachable - " + str);
            i++;
            i2 = i3;
        }
        serversIndex.set(0);
        Log.w(TAG, "File server: No reachable server found, use - " + ArraysKt.first(buildServers));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureInitialized() {
        synchronized (initLock) {
            if (initConnection) {
                return;
            }
            INSTANCE.initReachableConnection();
            initConnection = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void warmUpAsync() {
        if (initConnection || initStarted) {
            return;
        }
        synchronized (initLock) {
            if (!initConnection && !initStarted) {
                initStarted = true;
                Unit unit = Unit.INSTANCE;
                new Thread(new Runnable() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileServers.INSTANCE.ensureInitialized();
                    }
                }, "FileServers-warmup").start();
            }
        }
    }

    public final void currentServerIsUnreachable() {
        final String[] game_servers = getGame_servers();
        int updateAndGet = serversIndex.updateAndGet(new IntUnaryOperator() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda0
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i) {
                return FileServers.currentServerIsUnreachable$lambda$0(game_servers, i);
            }
        });
        Log.w(TAG, "File server: Change to - " + game_servers[updateAndGet]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int currentServerIsUnreachable$lambda$0(String[] strArr, int i) {
        return (i + 1) % strArr.length;
    }

    public final String getCurrentServer() {
        if (!initConnection) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                warmUpAsync();
            } else {
                ensureInitialized();
            }
        }
        String[] game_servers = getGame_servers();
        return game_servers[RangesKt.coerceIn(serversIndex.get(), 0, ArraysKt.getLastIndex(game_servers))];
    }
}
