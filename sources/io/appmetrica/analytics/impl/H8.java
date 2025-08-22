package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class H8 extends MessageNano {
    public static volatile H8[] c;

    /* renamed from: a  reason: collision with root package name */
    public G8[] f473a;
    public int b;

    public H8() {
        a();
    }

    public static H8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new H8[0];
                }
            }
        }
        return c;
    }

    public final H8 a() {
        this.f473a = G8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        G8[] g8Arr = this.f473a;
        if (g8Arr != null && g8Arr.length > 0) {
            int i = 0;
            while (true) {
                G8[] g8Arr2 = this.f473a;
                if (i >= g8Arr2.length) {
                    break;
                }
                G8 g8 = g8Arr2[i];
                if (g8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, g8);
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        G8[] g8Arr = this.f473a;
        if (g8Arr != null && g8Arr.length > 0) {
            int i = 0;
            while (true) {
                G8[] g8Arr2 = this.f473a;
                if (i >= g8Arr2.length) {
                    break;
                }
                G8 g8 = g8Arr2[i];
                if (g8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, g8);
                }
                i++;
            }
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final H8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                G8[] g8Arr = this.f473a;
                int length = g8Arr == null ? 0 : g8Arr.length;
                int i = repeatedFieldArrayLength + length;
                G8[] g8Arr2 = new G8[i];
                if (length != 0) {
                    System.arraycopy(g8Arr, 0, g8Arr2, 0, length);
                }
                while (length < i - 1) {
                    G8 g8 = new G8();
                    g8Arr2[length] = g8;
                    codedInputByteBufferNano.readMessage(g8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                G8 g82 = new G8();
                g8Arr2[length] = g82;
                codedInputByteBufferNano.readMessage(g82);
                this.f473a = g8Arr2;
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readUInt32();
            }
        }
        return this;
    }

    public static H8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new H8().mergeFrom(codedInputByteBufferNano);
    }

    public static H8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (H8) MessageNano.mergeFrom(new H8(), bArr);
    }
}
