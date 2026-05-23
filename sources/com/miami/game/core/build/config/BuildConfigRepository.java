package com.miami.game.core.build.config;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: BuildConfigRepository.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/build/config/BuildConfigRepository;", "", "buildType", "", "versionName", "versionCode", "", "isDebug", "", "isArizona", "isBrazil", "applicationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZZLjava/lang/String;)V", "getVersionCode", "()I", "getApplicationId", "()Ljava/lang/String;", "isHw", "isGooglePlay", "isStaging", "build-config"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BuildConfigRepository {
    private final String applicationId;
    private final String buildType;
    private final boolean isArizona;
    private final boolean isBrazil;
    private final boolean isDebug;
    private final int versionCode;
    private final String versionName;

    public BuildConfigRepository(String buildType, String versionName, int i, boolean z, boolean z2, boolean z3, String applicationId) {
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        this.buildType = buildType;
        this.versionName = versionName;
        this.versionCode = i;
        this.isDebug = z;
        this.isArizona = z2;
        this.isBrazil = z3;
        this.applicationId = applicationId;
        Log.d("BuildConfigRepository", "BuildConfig " + buildType + " " + versionName + " " + i + " " + z + " " + z2 + " " + applicationId + " " + isStaging());
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final boolean isHw() {
        return Intrinsics.areEqual(this.buildType, "release_hw");
    }

    public final boolean isGooglePlay() {
        return Intrinsics.areEqual(this.buildType, "release");
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }

    public final boolean isBrazil() {
        return this.isBrazil;
    }

    public final boolean isStaging() {
        return StringsKt.contains$default((CharSequence) this.applicationId, (CharSequence) "staging", false, 2, (Object) null);
    }
}
