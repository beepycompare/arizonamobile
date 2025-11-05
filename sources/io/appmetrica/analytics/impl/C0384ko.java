package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ko  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0384ko extends MessageNano {
    public static volatile C0384ko[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0307ho[] f979a;

    public C0384ko() {
        a();
    }

    public static C0384ko[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0384ko[0];
                }
            }
        }
        return b;
    }

    public final C0384ko a() {
        this.f979a = C0307ho.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0307ho[] c0307hoArr = this.f979a;
        if (c0307hoArr != null && c0307hoArr.length > 0) {
            int i = 0;
            while (true) {
                C0307ho[] c0307hoArr2 = this.f979a;
                if (i >= c0307hoArr2.length) {
                    break;
                }
                C0307ho c0307ho = c0307hoArr2[i];
                if (c0307ho != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0307ho) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0307ho[] c0307hoArr = this.f979a;
        if (c0307hoArr != null && c0307hoArr.length > 0) {
            int i = 0;
            while (true) {
                C0307ho[] c0307hoArr2 = this.f979a;
                if (i >= c0307hoArr2.length) {
                    break;
                }
                C0307ho c0307ho = c0307hoArr2[i];
                if (c0307ho != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0307ho);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0384ko mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0307ho[] c0307hoArr = this.f979a;
                int length = c0307hoArr == null ? 0 : c0307hoArr.length;
                int i = repeatedFieldArrayLength + length;
                C0307ho[] c0307hoArr2 = new C0307ho[i];
                if (length != 0) {
                    System.arraycopy(c0307hoArr, 0, c0307hoArr2, 0, length);
                }
                while (length < i - 1) {
                    C0307ho c0307ho = new C0307ho();
                    c0307hoArr2[length] = c0307ho;
                    codedInputByteBufferNano.readMessage(c0307ho);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0307ho c0307ho2 = new C0307ho();
                c0307hoArr2[length] = c0307ho2;
                codedInputByteBufferNano.readMessage(c0307ho2);
                this.f979a = c0307hoArr2;
            }
        }
        return this;
    }

    public static C0384ko b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0384ko().mergeFrom(codedInputByteBufferNano);
    }

    public static C0384ko a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0384ko) MessageNano.mergeFrom(new C0384ko(), bArr);
    }
}
