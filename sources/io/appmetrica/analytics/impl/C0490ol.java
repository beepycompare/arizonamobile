package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.ol  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0490ol extends MessageNano {
    public static volatile C0490ol[] c;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1136a;
    public byte[] b;

    public C0490ol() {
        a();
    }

    public static C0490ol[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0490ol[0];
                }
            }
        }
        return c;
    }

    public final C0490ol a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f1136a = bArr;
        this.b = bArr;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f1136a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1136a);
        }
        return !Arrays.equals(this.b, bArr2) ? CodedOutputByteBufferNano.computeBytesSize(2, this.b) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f1136a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1136a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0490ol mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1136a = codedInputByteBufferNano.readBytes();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBytes();
            }
        }
        return this;
    }

    public static C0490ol b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0490ol().mergeFrom(codedInputByteBufferNano);
    }

    public static C0490ol a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0490ol) MessageNano.mergeFrom(new C0490ol(), bArr);
    }
}
