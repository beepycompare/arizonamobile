package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.StrongEtag;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResponse;", "", "bytes", "", "strongEtag", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "effectiveUrl", "", "<init>", "([BLcom/arizona/launcher/updater/archive/range/StrongEtag;Ljava/lang/String;)V", "getBytes", "()[B", "getStrongEtag", "()Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "getEffectiveUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveByteRangeResponse {
    public static final int $stable = 8;
    private final byte[] bytes;
    private final String effectiveUrl;
    private final StrongEtag strongEtag;

    public static /* synthetic */ ArchiveByteRangeResponse copy$default(ArchiveByteRangeResponse archiveByteRangeResponse, byte[] bArr, StrongEtag strongEtag, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = archiveByteRangeResponse.bytes;
        }
        if ((i & 2) != 0) {
            strongEtag = archiveByteRangeResponse.strongEtag;
        }
        if ((i & 4) != 0) {
            str = archiveByteRangeResponse.effectiveUrl;
        }
        return archiveByteRangeResponse.copy(bArr, strongEtag, str);
    }

    public final byte[] component1() {
        return this.bytes;
    }

    public final StrongEtag component2() {
        return this.strongEtag;
    }

    public final String component3() {
        return this.effectiveUrl;
    }

    public final ArchiveByteRangeResponse copy(byte[] bytes, StrongEtag strongEtag, String effectiveUrl) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
        return new ArchiveByteRangeResponse(bytes, strongEtag, effectiveUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveByteRangeResponse) {
            ArchiveByteRangeResponse archiveByteRangeResponse = (ArchiveByteRangeResponse) obj;
            return Intrinsics.areEqual(this.bytes, archiveByteRangeResponse.bytes) && Intrinsics.areEqual(this.strongEtag, archiveByteRangeResponse.strongEtag) && Intrinsics.areEqual(this.effectiveUrl, archiveByteRangeResponse.effectiveUrl);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.bytes) * 31;
        StrongEtag strongEtag = this.strongEtag;
        return ((hashCode + (strongEtag == null ? 0 : strongEtag.hashCode())) * 31) + this.effectiveUrl.hashCode();
    }

    public String toString() {
        String arrays = Arrays.toString(this.bytes);
        StrongEtag strongEtag = this.strongEtag;
        return "ArchiveByteRangeResponse(bytes=" + arrays + ", strongEtag=" + strongEtag + ", effectiveUrl=" + this.effectiveUrl + ")";
    }

    public ArchiveByteRangeResponse(byte[] bytes, StrongEtag strongEtag, String effectiveUrl) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
        this.bytes = bytes;
        this.strongEtag = strongEtag;
        this.effectiveUrl = effectiveUrl;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    public final StrongEtag getStrongEtag() {
        return this.strongEtag;
    }

    public final String getEffectiveUrl() {
        return this.effectiveUrl;
    }
}
