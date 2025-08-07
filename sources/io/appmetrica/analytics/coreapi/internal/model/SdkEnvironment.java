package io.appmetrica.analytics.coreapi.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bHÆ\u0003JK\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/model/SdkEnvironment;", "", "Lio/appmetrica/analytics/coreapi/internal/model/AppVersionInfo;", "component1", "", "component2", "Lio/appmetrica/analytics/coreapi/internal/model/ScreenInfo;", "component3", "Lio/appmetrica/analytics/coreapi/internal/model/SdkInfo;", "component4", "component5", "", "component6", "appVersionInfo", "appFramework", "screenInfo", "sdkInfo", "deviceType", "locales", "copy", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/coreapi/internal/model/AppVersionInfo;", "getAppVersionInfo", "()Lio/appmetrica/analytics/coreapi/internal/model/AppVersionInfo;", "b", "Ljava/lang/String;", "getAppFramework", "()Ljava/lang/String;", "c", "Lio/appmetrica/analytics/coreapi/internal/model/ScreenInfo;", "getScreenInfo", "()Lio/appmetrica/analytics/coreapi/internal/model/ScreenInfo;", "d", "Lio/appmetrica/analytics/coreapi/internal/model/SdkInfo;", "getSdkInfo", "()Lio/appmetrica/analytics/coreapi/internal/model/SdkInfo;", "e", "getDeviceType", "f", "Ljava/util/List;", "getLocales", "()Ljava/util/List;", "<init>", "(Lio/appmetrica/analytics/coreapi/internal/model/AppVersionInfo;Ljava/lang/String;Lio/appmetrica/analytics/coreapi/internal/model/ScreenInfo;Lio/appmetrica/analytics/coreapi/internal/model/SdkInfo;Ljava/lang/String;Ljava/util/List;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class SdkEnvironment {

    /* renamed from: a  reason: collision with root package name */
    private final AppVersionInfo f249a;
    private final String b;
    private final ScreenInfo c;
    private final SdkInfo d;
    private final String e;
    private final List f;

    public SdkEnvironment(AppVersionInfo appVersionInfo, String str, ScreenInfo screenInfo, SdkInfo sdkInfo, String str2, List<String> list) {
        this.f249a = appVersionInfo;
        this.b = str;
        this.c = screenInfo;
        this.d = sdkInfo;
        this.e = str2;
        this.f = list;
    }

    public static /* synthetic */ SdkEnvironment copy$default(SdkEnvironment sdkEnvironment, AppVersionInfo appVersionInfo, String str, ScreenInfo screenInfo, SdkInfo sdkInfo, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            appVersionInfo = sdkEnvironment.f249a;
        }
        if ((i & 2) != 0) {
            str = sdkEnvironment.b;
        }
        if ((i & 4) != 0) {
            screenInfo = sdkEnvironment.c;
        }
        if ((i & 8) != 0) {
            sdkInfo = sdkEnvironment.d;
        }
        if ((i & 16) != 0) {
            str2 = sdkEnvironment.e;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            list2 = sdkEnvironment.f;
        }
        String str3 = str2;
        List list3 = list2;
        return sdkEnvironment.copy(appVersionInfo, str, screenInfo, sdkInfo, str3, list3);
    }

    public final AppVersionInfo component1() {
        return this.f249a;
    }

    public final String component2() {
        return this.b;
    }

    public final ScreenInfo component3() {
        return this.c;
    }

    public final SdkInfo component4() {
        return this.d;
    }

    public final String component5() {
        return this.e;
    }

    public final List<String> component6() {
        return this.f;
    }

    public final SdkEnvironment copy(AppVersionInfo appVersionInfo, String str, ScreenInfo screenInfo, SdkInfo sdkInfo, String str2, List<String> list) {
        return new SdkEnvironment(appVersionInfo, str, screenInfo, sdkInfo, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SdkEnvironment) {
            SdkEnvironment sdkEnvironment = (SdkEnvironment) obj;
            return Intrinsics.areEqual(this.f249a, sdkEnvironment.f249a) && Intrinsics.areEqual(this.b, sdkEnvironment.b) && Intrinsics.areEqual(this.c, sdkEnvironment.c) && Intrinsics.areEqual(this.d, sdkEnvironment.d) && Intrinsics.areEqual(this.e, sdkEnvironment.e) && Intrinsics.areEqual(this.f, sdkEnvironment.f);
        }
        return false;
    }

    public final String getAppFramework() {
        return this.b;
    }

    public final AppVersionInfo getAppVersionInfo() {
        return this.f249a;
    }

    public final String getDeviceType() {
        return this.e;
    }

    public final List<String> getLocales() {
        return this.f;
    }

    public final ScreenInfo getScreenInfo() {
        return this.c;
    }

    public final SdkInfo getSdkInfo() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.d.hashCode();
        int hashCode4 = this.e.hashCode();
        return this.f.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f249a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "SdkEnvironment(appVersionInfo=" + this.f249a + ", appFramework=" + this.b + ", screenInfo=" + this.c + ", sdkInfo=" + this.d + ", deviceType=" + this.e + ", locales=" + this.f + ')';
    }
}
