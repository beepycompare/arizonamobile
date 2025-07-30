package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.z8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0752z8 extends MessageNano {
    public static volatile C0752z8[] b;

    /* renamed from: a  reason: collision with root package name */
    public byte[][] f1167a;

    public C0752z8() {
        a();
    }

    public static C0752z8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0752z8[0];
                }
            }
        }
        return b;
    }

    public final C0752z8 a() {
        this.f1167a = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[][] bArr = this.f1167a;
        if (bArr == null || bArr.length <= 0) {
            return computeSerializedSize;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[][] bArr2 = this.f1167a;
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
        byte[][] bArr = this.f1167a;
        if (bArr != null && bArr.length > 0) {
            int i = 0;
            while (true) {
                byte[][] bArr2 = this.f1167a;
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
    public final C0752z8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                byte[][] bArr = this.f1167a;
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
                this.f1167a = bArr2;
            }
        }
        return this;
    }

    public static C0752z8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0752z8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0752z8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0752z8) MessageNano.mergeFrom(new C0752z8(), bArr);
    }
}
