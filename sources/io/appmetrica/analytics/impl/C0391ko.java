package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ko  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0391ko extends MessageNano {
    public static volatile C0391ko[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0314ho[] f944a;

    public C0391ko() {
        a();
    }

    public static C0391ko[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0391ko[0];
                }
            }
        }
        return b;
    }

    public final C0391ko a() {
        this.f944a = C0314ho.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0314ho[] c0314hoArr = this.f944a;
        if (c0314hoArr != null && c0314hoArr.length > 0) {
            int i = 0;
            while (true) {
                C0314ho[] c0314hoArr2 = this.f944a;
                if (i >= c0314hoArr2.length) {
                    break;
                }
                C0314ho c0314ho = c0314hoArr2[i];
                if (c0314ho != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0314ho) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0314ho[] c0314hoArr = this.f944a;
        if (c0314hoArr != null && c0314hoArr.length > 0) {
            int i = 0;
            while (true) {
                C0314ho[] c0314hoArr2 = this.f944a;
                if (i >= c0314hoArr2.length) {
                    break;
                }
                C0314ho c0314ho = c0314hoArr2[i];
                if (c0314ho != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0314ho);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0391ko mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0314ho[] c0314hoArr = this.f944a;
                int length = c0314hoArr == null ? 0 : c0314hoArr.length;
                int i = repeatedFieldArrayLength + length;
                C0314ho[] c0314hoArr2 = new C0314ho[i];
                if (length != 0) {
                    System.arraycopy(c0314hoArr, 0, c0314hoArr2, 0, length);
                }
                while (length < i - 1) {
                    C0314ho c0314ho = new C0314ho();
                    c0314hoArr2[length] = c0314ho;
                    codedInputByteBufferNano.readMessage(c0314ho);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0314ho c0314ho2 = new C0314ho();
                c0314hoArr2[length] = c0314ho2;
                codedInputByteBufferNano.readMessage(c0314ho2);
                this.f944a = c0314hoArr2;
            }
        }
        return this;
    }

    public static C0391ko b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0391ko().mergeFrom(codedInputByteBufferNano);
    }

    public static C0391ko a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0391ko) MessageNano.mergeFrom(new C0391ko(), bArr);
    }
}
