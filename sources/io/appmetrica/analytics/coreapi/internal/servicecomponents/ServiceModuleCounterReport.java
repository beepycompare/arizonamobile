package io.appmetrica.analytics.coreapi.internal.servicecomponents;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u001b\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0002$#B-\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0010\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/servicecomponents/ServiceModuleCounterReport;", "", "other", "", "equals", "", "hashCode", "", "component1", "component2", "", "component3", "component4", "name", "value", "valueBytes", "type", "copy", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "b", "getValue", "c", "[B", "getValueBytes", "()[B", "d", "I", "getType", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;[BI)V", "Companion", "Builder", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class ServiceModuleCounterReport {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f379a;
    private final String b;
    private final byte[] c;
    private final int d;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/servicecomponents/ServiceModuleCounterReport$Builder;", "", "", "name", "withName", "value", "withValue", "", "valueBytes", "withValueBytes", "", "type", "withType", "Lio/appmetrica/analytics/coreapi/internal/servicecomponents/ServiceModuleCounterReport;", "build", "<init>", "()V", "core-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f380a;
        private String b;
        private byte[] c;
        private int d;

        public final ServiceModuleCounterReport build() {
            return new ServiceModuleCounterReport(this.f380a, this.b, this.c, this.d);
        }

        public final Builder withName(String str) {
            this.f380a = str;
            return this;
        }

        public final Builder withType(int i) {
            this.d = i;
            return this;
        }

        public final Builder withValue(String str) {
            this.b = str;
            return this;
        }

        public final Builder withValueBytes(byte[] bArr) {
            this.c = bArr;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0004"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/servicecomponents/ServiceModuleCounterReport$Companion;", "", "Lio/appmetrica/analytics/coreapi/internal/servicecomponents/ServiceModuleCounterReport$Builder;", "newBuilder", "core-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder newBuilder() {
            return new Builder();
        }

        private Companion() {
        }
    }

    public ServiceModuleCounterReport(String str, String str2, byte[] bArr, int i) {
        this.f379a = str;
        this.b = str2;
        this.c = bArr;
        this.d = i;
    }

    public static /* synthetic */ ServiceModuleCounterReport copy$default(ServiceModuleCounterReport serviceModuleCounterReport, String str, String str2, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = serviceModuleCounterReport.f379a;
        }
        if ((i2 & 2) != 0) {
            str2 = serviceModuleCounterReport.b;
        }
        if ((i2 & 4) != 0) {
            bArr = serviceModuleCounterReport.c;
        }
        if ((i2 & 8) != 0) {
            i = serviceModuleCounterReport.d;
        }
        return serviceModuleCounterReport.copy(str, str2, bArr, i);
    }

    public final String component1() {
        return this.f379a;
    }

    public final String component2() {
        return this.b;
    }

    public final byte[] component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final ServiceModuleCounterReport copy(String str, String str2, byte[] bArr, int i) {
        return new ServiceModuleCounterReport(str, str2, bArr, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceModuleCounterReport) {
            ServiceModuleCounterReport serviceModuleCounterReport = (ServiceModuleCounterReport) obj;
            return this.d == serviceModuleCounterReport.d && Intrinsics.areEqual(this.f379a, serviceModuleCounterReport.f379a) && Intrinsics.areEqual(this.b, serviceModuleCounterReport.b) && Arrays.equals(this.c, serviceModuleCounterReport.c);
        }
        return false;
    }

    public final String getName() {
        return this.f379a;
    }

    public final int getType() {
        return this.d;
    }

    public final String getValue() {
        return this.b;
    }

    public final byte[] getValueBytes() {
        return this.c;
    }

    public int hashCode() {
        int i = this.d * 31;
        String str = this.f379a;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        byte[] bArr = this.c;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "ServiceModuleCounterReport(name=" + this.f379a + ", value=" + this.b + ", valueBytes=" + Arrays.toString(this.c) + ", type=" + this.d + ')';
    }
}
