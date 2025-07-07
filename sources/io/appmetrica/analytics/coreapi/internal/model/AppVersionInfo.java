package io.appmetrica.analytics.coreapi.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/model/AppVersionInfo;", "", "", "component1", "component2", "appVersionName", "appBuildNumber", "copy", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getAppVersionName", "()Ljava/lang/String;", "b", "getAppBuildNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class AppVersionInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f246a;
    private final String b;

    public AppVersionInfo(String str, String str2) {
        this.f246a = str;
        this.b = str2;
    }

    public static /* synthetic */ AppVersionInfo copy$default(AppVersionInfo appVersionInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appVersionInfo.f246a;
        }
        if ((i & 2) != 0) {
            str2 = appVersionInfo.b;
        }
        return appVersionInfo.copy(str, str2);
    }

    public final String component1() {
        return this.f246a;
    }

    public final String component2() {
        return this.b;
    }

    public final AppVersionInfo copy(String str, String str2) {
        return new AppVersionInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppVersionInfo) {
            AppVersionInfo appVersionInfo = (AppVersionInfo) obj;
            return Intrinsics.areEqual(this.f246a, appVersionInfo.f246a) && Intrinsics.areEqual(this.b, appVersionInfo.b);
        }
        return false;
    }

    public final String getAppBuildNumber() {
        return this.b;
    }

    public final String getAppVersionName() {
        return this.f246a;
    }

    public int hashCode() {
        return this.b.hashCode() + (this.f246a.hashCode() * 31);
    }

    public String toString() {
        return "AppVersionInfo(appVersionName=" + this.f246a + ", appBuildNumber=" + this.b + ')';
    }
}
