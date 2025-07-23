package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.fo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0269fo extends MessageNano {
    public static volatile C0269fo[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0192co[] f853a;

    public C0269fo() {
        a();
    }

    public static C0269fo[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0269fo[0];
                }
            }
        }
        return b;
    }

    public final C0269fo a() {
        this.f853a = C0192co.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0192co[] c0192coArr = this.f853a;
        if (c0192coArr != null && c0192coArr.length > 0) {
            int i = 0;
            while (true) {
                C0192co[] c0192coArr2 = this.f853a;
                if (i >= c0192coArr2.length) {
                    break;
                }
                C0192co c0192co = c0192coArr2[i];
                if (c0192co != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0192co) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0192co[] c0192coArr = this.f853a;
        if (c0192coArr != null && c0192coArr.length > 0) {
            int i = 0;
            while (true) {
                C0192co[] c0192coArr2 = this.f853a;
                if (i >= c0192coArr2.length) {
                    break;
                }
                C0192co c0192co = c0192coArr2[i];
                if (c0192co != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0192co);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0269fo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0192co[] c0192coArr = this.f853a;
                int length = c0192coArr == null ? 0 : c0192coArr.length;
                int i = repeatedFieldArrayLength + length;
                C0192co[] c0192coArr2 = new C0192co[i];
                if (length != 0) {
                    System.arraycopy(c0192coArr, 0, c0192coArr2, 0, length);
                }
                while (length < i - 1) {
                    C0192co c0192co = new C0192co();
                    c0192coArr2[length] = c0192co;
                    codedInputByteBufferNano.readMessage(c0192co);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0192co c0192co2 = new C0192co();
                c0192coArr2[length] = c0192co2;
                codedInputByteBufferNano.readMessage(c0192co2);
                this.f853a = c0192coArr2;
            }
        }
        return this;
    }

    public static C0269fo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0269fo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0269fo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0269fo) MessageNano.mergeFrom(new C0269fo(), bArr);
    }
}
