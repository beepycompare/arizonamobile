package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class EventMessage implements Metadata.Entry {
    public static final String ID3_SCHEME_ID_AOM = "https://aomedia.org/emsg/ID3";
    private static final String ID3_SCHEME_ID_APPLE = "https://developer.apple.com/streaming/emsg-id3";
    public static final String SCTE35_SCHEME_ID = "urn:scte:scte35:2014:bin";
    public final long durationMs;
    private int hashCode;
    public final long id;
    public final byte[] messageData;
    public final String schemeIdUri;
    public final String value;
    private static final Format ID3_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_ID3).build();
    private static final Format SCTE35_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_SCTE35).build();

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j;
        this.id = j2;
        this.messageData = bArr;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public Format getWrappedMetadataFormat() {
        String str = this.schemeIdUri;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals(SCTE35_SCHEME_ID)) {
                    c = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals(ID3_SCHEME_ID_AOM)) {
                    c = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals(ID3_SCHEME_ID_APPLE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SCTE35_FORMAT;
            case 1:
            case 2:
                return ID3_FORMAT;
            default:
                return null;
        }
    }

    @Override // androidx.media3.common.Metadata.Entry
    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.messageData;
        }
        return null;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.durationMs;
            long j2 = this.id;
            this.hashCode = ((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.durationMs == eventMessage.durationMs && this.id == eventMessage.id && Objects.equals(this.schemeIdUri, eventMessage.schemeIdUri) && Objects.equals(this.value, eventMessage.value) && Arrays.equals(this.messageData, eventMessage.messageData)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "EMSG: scheme=" + this.schemeIdUri + ", id=" + this.id + ", durationMs=" + this.durationMs + ", value=" + this.value;
    }
}
