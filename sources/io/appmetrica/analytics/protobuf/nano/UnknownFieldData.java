package io.appmetrica.analytics.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
final class UnknownFieldData {
    final byte[] bytes;
    final int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldData(int i, byte[] bArr) {
        this.tag = i;
        this.bytes = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeRawVarint32Size(this.tag) + this.bytes.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UnknownFieldData) {
            UnknownFieldData unknownFieldData = (UnknownFieldData) obj;
            return this.tag == unknownFieldData.tag && Arrays.equals(this.bytes, unknownFieldData.bytes);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes) + ((this.tag + 527) * 31);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeRawVarint32(this.tag);
        codedOutputByteBufferNano.writeRawBytes(this.bytes);
    }
}
