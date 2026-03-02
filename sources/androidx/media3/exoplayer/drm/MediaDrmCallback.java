package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.source.LoadEventInfo;
import java.util.UUID;
/* loaded from: classes2.dex */
public interface MediaDrmCallback {
    Response executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException;

    Response executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException;

    /* loaded from: classes2.dex */
    public static final class Response {
        public final byte[] data;
        public final LoadEventInfo loadEventInfo;

        /* loaded from: classes2.dex */
        public static final class Builder {
            private final byte[] data;
            private LoadEventInfo loadEventInfo;

            public Builder(byte[] bArr) {
                this.data = bArr;
            }

            public Builder setLoadEventInfo(LoadEventInfo loadEventInfo) {
                this.loadEventInfo = loadEventInfo;
                return this;
            }

            public Response build() {
                return new Response(this);
            }
        }

        public Response(byte[] bArr) {
            this.data = bArr;
            this.loadEventInfo = null;
        }

        private Response(Builder builder) {
            this.data = builder.data;
            this.loadEventInfo = builder.loadEventInfo;
        }
    }
}
