package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExperimentIds;
import java.util.Arrays;
/* loaded from: classes3.dex */
final class AutoValue_ExperimentIds extends ExperimentIds {
    private final byte[] clearBlob;
    private final byte[] encryptedBlob;

    private AutoValue_ExperimentIds(byte[] bArr, byte[] bArr2) {
        this.clearBlob = bArr;
        this.encryptedBlob = bArr2;
    }

    @Override // com.google.android.datatransport.cct.internal.ExperimentIds
    public byte[] getClearBlob() {
        return this.clearBlob;
    }

    @Override // com.google.android.datatransport.cct.internal.ExperimentIds
    public byte[] getEncryptedBlob() {
        return this.encryptedBlob;
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.clearBlob) + ", encryptedBlob=" + Arrays.toString(this.encryptedBlob) + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExperimentIds) {
            ExperimentIds experimentIds = (ExperimentIds) obj;
            boolean z = experimentIds instanceof AutoValue_ExperimentIds;
            if (Arrays.equals(this.clearBlob, z ? ((AutoValue_ExperimentIds) experimentIds).clearBlob : experimentIds.getClearBlob())) {
                if (Arrays.equals(this.encryptedBlob, z ? ((AutoValue_ExperimentIds) experimentIds).encryptedBlob : experimentIds.getEncryptedBlob())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.clearBlob) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.encryptedBlob);
    }

    /* loaded from: classes3.dex */
    static final class Builder extends ExperimentIds.Builder {
        private byte[] clearBlob;
        private byte[] encryptedBlob;

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public ExperimentIds.Builder setClearBlob(byte[] bArr) {
            this.clearBlob = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public ExperimentIds.Builder setEncryptedBlob(byte[] bArr) {
            this.encryptedBlob = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public ExperimentIds build() {
            return new AutoValue_ExperimentIds(this.clearBlob, this.encryptedBlob);
        }
    }
}
