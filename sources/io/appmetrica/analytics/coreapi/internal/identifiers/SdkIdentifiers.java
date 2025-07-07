package io.appmetrica.analytics.coreapi.internal.identifiers;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u001a"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/identifiers/SdkIdentifiers;", "", "", "component1", "component2", "component3", CommonUrlParts.UUID, "deviceId", "deviceIdHash", "copy", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "b", "getDeviceId", "c", "getDeviceIdHash", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class SdkIdentifiers {

    /* renamed from: a  reason: collision with root package name */
    private final String f244a;
    private final String b;
    private final String c;

    public SdkIdentifiers(String str, String str2, String str3) {
        this.f244a = str;
        this.b = str2;
        this.c = str3;
    }

    public static /* synthetic */ SdkIdentifiers copy$default(SdkIdentifiers sdkIdentifiers, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sdkIdentifiers.f244a;
        }
        if ((i & 2) != 0) {
            str2 = sdkIdentifiers.b;
        }
        if ((i & 4) != 0) {
            str3 = sdkIdentifiers.c;
        }
        return sdkIdentifiers.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f244a;
    }

    public final String component2() {
        return this.b;
    }

    public final String component3() {
        return this.c;
    }

    public final SdkIdentifiers copy(String str, String str2, String str3) {
        return new SdkIdentifiers(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SdkIdentifiers) {
            SdkIdentifiers sdkIdentifiers = (SdkIdentifiers) obj;
            return Intrinsics.areEqual(this.f244a, sdkIdentifiers.f244a) && Intrinsics.areEqual(this.b, sdkIdentifiers.b) && Intrinsics.areEqual(this.c, sdkIdentifiers.c);
        }
        return false;
    }

    public final String getDeviceId() {
        return this.b;
    }

    public final String getDeviceIdHash() {
        return this.c;
    }

    public final String getUuid() {
        return this.f244a;
    }

    public int hashCode() {
        String str = this.f244a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SdkIdentifiers(uuid=" + this.f244a + ", deviceId=" + this.b + ", deviceIdHash=" + this.c + ')';
    }
}
