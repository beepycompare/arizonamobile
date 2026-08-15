package com.arizona.launcher.util;

import android.util.Log;
import com.arizona.game.BuildConfig;
import com.google.firebase.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigKt;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: FileServers.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u001b\u0010.\u001a\u00020/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d¢\u0006\u0002\u00101J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u00020/J\u000e\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005J\u000e\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005J\u0006\u0010:\u001a\u00020\u0005J\u0006\u0010;\u001a\u00020\u0005J\u000e\u0010<\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020\u0005J$\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020\u00052\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0AH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001eR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d8F¢\u0006\u0006\u001a\u0004\b+\u0010\u001eR\u0018\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-Ê\u0001\f\bC\u0012\b\bD\u0012\u0004\b\u0003\u0010\u0002¨\u0006B"}, d2 = {"Lcom/arizona/launcher/util/FileServers;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "FALLBACK_MAIN_ARIZONA", "FALLBACK_RESERVE_ARIZONA", "FALLBACK_MAIN_RODINA", "FALLBACK_RESERVE_RODINA", "ARCHIVE_STAGING_ARIZONA_MAIN_KEY", "ARCHIVE_STAGING_ARIZONA_RESERVE_KEY", "ARCHIVE_STAGING_RODINA_MAIN_KEY", "ARCHIVE_STAGING_RODINA_RESERVE_KEY", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "mainChannelArizona", "getMainChannelArizona", "()Ljava/lang/String;", "mainChannelRodina", "getMainChannelRodina", "reserveChannelArizona", "getReserveChannelArizona", "reserveChannelRodina", "getReserveChannelRodina", "buildGameServers", "", "()[Ljava/lang/String;", "buildLauncherServers", "configuredArchiveStagingServers", "Lcom/arizona/launcher/util/GameFileServerPair;", "configuredArchiveStagingPair", "mainKey", "reserveKey", "gamePool", "Lcom/arizona/launcher/util/FileServerPool;", "launcherPool", "game_servers", "getGame_servers", "launcher_servers", "getLauncher_servers", "benchmarkServersOverride", "[Ljava/lang/String;", "setBenchmarkServersForTests", "", "servers", "([Ljava/lang/String;)V", "refreshGameServers", "", "restartGameServersFromPrimary", "refreshLauncherServers", "warmUpAsync", "currentGameServerIsUnreachable", "failedServer", "currentLauncherServerIsUnreachable", "getCurrentGameServer", "getCurrentLauncherServer", "currentServerIsUnreachable", "getCurrentServer", "createPool", "name", "buildServers", "Lkotlin/Function0;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServers {
    public static final int $stable = 0;
    private static final String ARCHIVE_STAGING_ARIZONA_MAIN_KEY = "launcher_archive_staging_arizona_main_url";
    private static final String ARCHIVE_STAGING_ARIZONA_RESERVE_KEY = "launcher_archive_staging_arizona_reserve_url";
    private static final String ARCHIVE_STAGING_RODINA_MAIN_KEY = "launcher_archive_staging_rodina_main_url";
    private static final String ARCHIVE_STAGING_RODINA_RESERVE_KEY = "launcher_archive_staging_rodina_reserve_url";
    private static final String FALLBACK_MAIN_ARIZONA = "https://mob.maz-ins.com";
    private static final String FALLBACK_MAIN_RODINA = "https://mob.azinternal.com";
    private static final String FALLBACK_RESERVE_ARIZONA = "https://arz-mob.react-group.tech";
    private static final String FALLBACK_RESERVE_RODINA = "https://rod-mob.react-group.tech";
    public static final FileServers INSTANCE;
    private static final String TAG;
    private static volatile String[] benchmarkServersOverride;
    private static final FileServerPool gamePool;
    private static final FileServerPool launcherPool;

    private FileServers() {
    }

    static {
        FileServers fileServers = new FileServers();
        INSTANCE = fileServers;
        TAG = FileServers.class.getCanonicalName();
        gamePool = fileServers.createPool("game", new FileServers$gamePool$1(fileServers));
        launcherPool = fileServers.createPool("launcher", new FileServers$launcherPool$1(fileServers));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] buildGameServers() {
        String[] strArr = benchmarkServersOverride;
        if (strArr != null) {
            Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            String[] strArr2 = (String[]) copyOf;
            if (strArr2 != null) {
                return strArr2;
            }
        }
        return (String[]) GameFileServerRouteResolver.INSTANCE.resolveGame(BuildConfig.FLAVOR, "release", new GameFileServerOrigins(getMainChannelArizona(), getReserveChannelArizona(), getMainChannelRodina(), getReserveChannelRodina()), configuredArchiveStagingServers(), GameArchiveStagingFallbacks.INSTANCE.forFlavor(BuildConfig.FLAVOR)).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] buildLauncherServers() {
        return (String[]) GameFileServerRouteResolver.INSTANCE.resolveLauncher(BuildConfig.FLAVOR, "release", new GameFileServerOrigins(getMainChannelArizona(), getReserveChannelArizona(), getMainChannelRodina(), getReserveChannelRodina())).toArray(new String[0]);
    }

    private final GameFileServerPair configuredArchiveStagingServers() {
        GameFileServerPair configuredArchiveStagingPair = configuredArchiveStagingPair(ARCHIVE_STAGING_ARIZONA_MAIN_KEY, ARCHIVE_STAGING_ARIZONA_RESERVE_KEY);
        GameFileServerPair selectConfigured = GameArchiveStagingFallbacks.INSTANCE.selectConfigured(BuildConfig.FLAVOR, configuredArchiveStagingPair, configuredArchiveStagingPair(ARCHIVE_STAGING_RODINA_MAIN_KEY, ARCHIVE_STAGING_RODINA_RESERVE_KEY));
        if (!Intrinsics.areEqual(selectConfigured, configuredArchiveStagingPair)) {
            Log.e(TAG, "Archive staging config is deprecated or overlaps another product; using arizona fallback");
        }
        return selectConfigured;
    }

    private final GameFileServerPair configuredArchiveStagingPair(String str, String str2) {
        String string = getRemoteConfig().getString(str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getRemoteConfig().getString(str2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return new GameFileServerPair(string, string2);
    }

    public final String[] getGame_servers() {
        return (String[]) gamePool.getServers().toArray(new String[0]);
    }

    public final String[] getLauncher_servers() {
        return (String[]) launcherPool.getServers().toArray(new String[0]);
    }

    public final void setBenchmarkServersForTests(String[] strArr) {
        throw new IllegalStateException("Benchmark file-server overrides are disabled in this build".toString());
    }

    public final boolean refreshGameServers() {
        return gamePool.refresh();
    }

    public final String restartGameServersFromPrimary() {
        return gamePool.restartFromFirst();
    }

    public final boolean refreshLauncherServers() {
        return launcherPool.refresh();
    }

    public final void warmUpAsync() {
        gamePool.warmUpAsync();
        launcherPool.warmUpAsync();
    }

    public final String currentGameServerIsUnreachable(String failedServer) {
        Intrinsics.checkNotNullParameter(failedServer, "failedServer");
        return gamePool.advance(failedServer);
    }

    public final String currentLauncherServerIsUnreachable(String failedServer) {
        Intrinsics.checkNotNullParameter(failedServer, "failedServer");
        return launcherPool.advance(failedServer);
    }

    public final String getCurrentGameServer() {
        return gamePool.current();
    }

    public final String getCurrentLauncherServer() {
        return launcherPool.current();
    }

    public final String currentServerIsUnreachable(String failedServer) {
        Intrinsics.checkNotNullParameter(failedServer, "failedServer");
        return currentGameServerIsUnreachable(failedServer);
    }

    public final String getCurrentServer() {
        return getCurrentGameServer();
    }

    private final FileServerPool createPool(final String str, final Function0<String[]> function0) {
        return new FileServerPool(new Function0() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                list = ArraysKt.toList((Object[]) Function0.this.invoke());
                return list;
            }
        }, new FileServers$createPool$2(FirebaseConfigHelper.INSTANCE), new Function1() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileServers.createPool$lambda$1(str, (Function0) obj);
            }
        }, new Function2() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FileServers.createPool$lambda$2(str, (String) obj, ((Boolean) obj2).booleanValue());
            }
        }, new Function1() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileServers.createPool$lambda$3(str, (String) obj);
            }
        }, new Function1() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileServers.createPool$lambda$4(str, (String) obj);
            }
        }, new Function1() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileServers.createPool$lambda$5(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createPool$lambda$1(String str, final Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        new Thread(new Runnable() { // from class: com.arizona.launcher.util.FileServers$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        }, "FileServers-" + str + "-warmup").start();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createPool$lambda$2(String str, String server, boolean z) {
        String str2;
        Intrinsics.checkNotNullParameter(server, "server");
        String str3 = TAG;
        if (z) {
            str2 = "File server[" + str + "]: Reachable - " + server;
        } else {
            str2 = "File server[" + str + "]: Unreachable - " + server;
        }
        Log.w(str3, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createPool$lambda$3(String str, String server) {
        Intrinsics.checkNotNullParameter(server, "server");
        Log.w(TAG, "File server[" + str + "]: Use - " + server);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createPool$lambda$4(String str, String server) {
        Intrinsics.checkNotNullParameter(server, "server");
        Log.w(TAG, "File server[" + str + "]: No reachable server found, use - " + server);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit createPool$lambda$5(String str, String server) {
        Intrinsics.checkNotNullParameter(server, "server");
        Log.w(TAG, "File server[" + str + "]: Change to - " + server);
        return Unit.INSTANCE;
    }
}
