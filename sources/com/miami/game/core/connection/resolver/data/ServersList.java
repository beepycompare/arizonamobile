package com.miami.game.core.connection.resolver.data;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.ktx.RemoteConfigKt;
import com.miami.game.core.build.config.BuildConfigRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServersList.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/miami/game/core/connection/resolver/data/ServersList;", "", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "<init>", "(Lcom/miami/game/core/build/config/BuildConfigRepository;)V", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "gameServersDesktop", "", "", "gameServersMobile", "dataServers", "gameInfoFilesServers", "newsServers", "connection-resolver_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServersList {
    private final BuildConfigRepository buildConfig;
    private final FirebaseRemoteConfig remoteConfig;

    @Inject
    public ServersList(BuildConfigRepository buildConfig) {
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        this.buildConfig = buildConfig;
        this.remoteConfig = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE);
    }

    public final List<String> gameServersDesktop() {
        String string = this.remoteConfig.getString("main_api");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.remoteConfig.getString("reserve_api");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (this.buildConfig.isArizona()) {
            if (this.buildConfig.isDebug()) {
                return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/servers/arizona", string2 + "/launcher/servers/arizona"});
            }
            return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/servers/arizona", string2 + "/launcher/servers/arizona"});
        } else if (this.buildConfig.isDebug()) {
            return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/servers/rodina", string2 + "/launcher/servers/rodina"});
        } else {
            return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/servers/rodina", string2 + "/launcher/servers/rodina"});
        }
    }

    public final List<String> gameServersMobile() {
        String string = this.remoteConfig.getString("main_api");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.remoteConfig.getString("reserve_api");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (this.buildConfig.isArizona()) {
            return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/servers/arizonaMobile", string2 + "/launcher/servers/arizonaMobile"});
        }
        return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/servers/rodinaMobile", string2 + "/launcher/servers/rodinaMobile"});
    }

    public final List<String> dataServers() {
        if ((this.buildConfig.isDebug() || this.buildConfig.isStaging()) && this.buildConfig.isArizona()) {
            return CollectionsKt.listOf((Object[]) new String[]{"https://mob.maz-ins.com/miami/staging/data", "https://arz-mob.react-group.tech/miami/staging/data"});
        }
        if (!this.buildConfig.isDebug() && !this.buildConfig.isStaging() && this.buildConfig.isArizona()) {
            return CollectionsKt.listOf((Object[]) new String[]{"https://mob.maz-ins.com/miami/release/data", "https://arz-mob.react-group.tech/miami/release/data"});
        }
        if ((this.buildConfig.isDebug() || this.buildConfig.isStaging()) && !this.buildConfig.isArizona()) {
            return CollectionsKt.listOf((Object[]) new String[]{"https://mob.maz-ins.com/miami/staging/data", "https://arz-mob.react-group.tech/miami/staging/data"});
        }
        if (!this.buildConfig.isDebug() && !this.buildConfig.isStaging() && !this.buildConfig.isArizona()) {
            return CollectionsKt.listOf((Object[]) new String[]{"https://mob.maz-ins.com/miami/staging/data", "https://arz-mob.react-group.tech/miami/staging/data"});
        }
        return CollectionsKt.listOf((Object[]) new String[]{"https://mob.maz-ins.com/miami/staging/data", "https://arz-mob.react-group.tech/miami/staging/data"});
    }

    public final List<String> gameInfoFilesServers() {
        String str = "release/";
        if (this.buildConfig.isArizona()) {
            String[] strArr = new String[2];
            strArr[0] = "https://mob.maz-ins.com/miami/".concat((this.buildConfig.isStaging() || this.buildConfig.isDebug()) ? "staging/" : "release/");
            strArr[1] = "https://arz-mob.react-group.tech/miami/".concat((this.buildConfig.isStaging() || this.buildConfig.isDebug()) ? "staging/" : "staging/");
            return CollectionsKt.listOf((Object[]) strArr);
        }
        String[] strArr2 = new String[2];
        strArr2[0] = "https://mob.maz-ins.com/miami/".concat((this.buildConfig.isStaging() || this.buildConfig.isDebug()) ? "staging/" : "release/");
        strArr2[1] = "https://arz-mob.react-group.tech/miami/".concat((this.buildConfig.isStaging() || this.buildConfig.isDebug()) ? "staging/" : "staging/");
        return CollectionsKt.listOf((Object[]) strArr2);
    }

    public final List<String> newsServers() {
        String string = this.remoteConfig.getString("main_api");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.remoteConfig.getString("reserve_api");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (this.buildConfig.isArizona()) {
            return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/news/arizona?limit=2", string2 + "/launcher/news/arizona?limit=2"});
        }
        return CollectionsKt.listOf((Object[]) new String[]{string + "/launcher/news/rodina?limit=2", string2 + "/launcher/news/rodina?limit=2"});
    }
}
