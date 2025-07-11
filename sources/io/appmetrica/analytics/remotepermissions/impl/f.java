package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class f extends MessageNano {
    public static volatile f[] b;

    /* renamed from: a  reason: collision with root package name */
    public byte[][] f1266a;

    public f() {
        a();
    }

    public static f[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new f[0];
                }
            }
        }
        return b;
    }

    public final f a() {
        this.f1266a = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[][] bArr = this.f1266a;
        if (bArr == null || bArr.length <= 0) {
            return computeSerializedSize;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[][] bArr2 = this.f1266a;
            if (i >= bArr2.length) {
                return computeSerializedSize + i2 + i3;
            }
            byte[] bArr3 = bArr2[i];
            if (bArr3 != null) {
                i3++;
                i2 = CodedOutputByteBufferNano.computeBytesSizeNoTag(bArr3) + i2;
            }
            i++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[][] bArr = this.f1266a;
        if (bArr != null && bArr.length > 0) {
            int i = 0;
            while (true) {
                byte[][] bArr2 = this.f1266a;
                if (i >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    codedOutputByteBufferNano.writeBytes(1, bArr3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                byte[][] bArr = this.f1266a;
                int length = bArr == null ? 0 : bArr.length;
                int i = repeatedFieldArrayLength + length;
                byte[][] bArr2 = new byte[i];
                if (length != 0) {
                    System.arraycopy(bArr, 0, bArr2, 0, length);
                }
                while (length < i - 1) {
                    bArr2[length] = codedInputByteBufferNano.readBytes();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bArr2[length] = codedInputByteBufferNano.readBytes();
                this.f1266a = bArr2;
            }
        }
        return this;
    }

    public static f b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new f().mergeFrom(codedInputByteBufferNano);
    }

    public static f a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }
}
