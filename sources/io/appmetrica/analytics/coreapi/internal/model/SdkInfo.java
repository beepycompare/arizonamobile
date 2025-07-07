package io.appmetrica.analytics.coreapi.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u001a"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/model/SdkInfo;", "", "", "component1", "component2", "component3", "sdkVersionName", "sdkBuildNumber", "sdkBuildType", "copy", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getSdkVersionName", "()Ljava/lang/String;", "b", "getSdkBuildNumber", "c", "getSdkBuildType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class SdkInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f249a;
    private final String b;
    private final String c;

    public SdkInfo(String str, String str2, String str3) {
        this.f249a = str;
        this.b = str2;
        this.c = str3;
    }

    public static /* synthetic */ SdkInfo copy$default(SdkInfo sdkInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sdkInfo.f249a;
        }
        if ((i & 2) != 0) {
            str2 = sdkInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = sdkInfo.c;
        }
        return sdkInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f249a;
    }

    public final String component2() {
        return this.b;
    }

    public final String component3() {
        return this.c;
    }

    public final SdkInfo copy(String str, String str2, String str3) {
        return new SdkInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SdkInfo) {
            SdkInfo sdkInfo = (SdkInfo) obj;
            return Intrinsics.areEqual(this.f249a, sdkInfo.f249a) && Intrinsics.areEqual(this.b, sdkInfo.b) && Intrinsics.areEqual(this.c, sdkInfo.c);
        }
        return false;
    }

    public final String getSdkBuildNumber() {
        return this.b;
    }

    public final String getSdkBuildType() {
        return this.c;
    }

    public final String getSdkVersionName() {
        return this.f249a;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f249a.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "SdkInfo(sdkVersionName=" + this.f249a + ", sdkBuildNumber=" + this.b + ", sdkBuildType=" + this.c + ')';
    }
}
