package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Pm extends MessageNano {
    public static volatile Pm[] b;

    /* renamed from: a  reason: collision with root package name */
    public Om[] f723a;

    public Pm() {
        a();
    }

    public static Pm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Pm[0];
                }
            }
        }
        return b;
    }

    public final Pm a() {
        this.f723a = Om.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Om[] omArr = this.f723a;
        if (omArr != null && omArr.length > 0) {
            int i = 0;
            while (true) {
                Om[] omArr2 = this.f723a;
                if (i >= omArr2.length) {
                    break;
                }
                Om om = omArr2[i];
                if (om != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, om) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Om[] omArr = this.f723a;
        if (omArr != null && omArr.length > 0) {
            int i = 0;
            while (true) {
                Om[] omArr2 = this.f723a;
                if (i >= omArr2.length) {
                    break;
                }
                Om om = omArr2[i];
                if (om != null) {
                    codedOutputByteBufferNano.writeMessage(1, om);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Pm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Om[] omArr = this.f723a;
                int length = omArr == null ? 0 : omArr.length;
                int i = repeatedFieldArrayLength + length;
                Om[] omArr2 = new Om[i];
                if (length != 0) {
                    System.arraycopy(omArr, 0, omArr2, 0, length);
                }
                while (length < i - 1) {
                    Om om = new Om();
                    omArr2[length] = om;
                    codedInputByteBufferNano.readMessage(om);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Om om2 = new Om();
                omArr2[length] = om2;
                codedInputByteBufferNano.readMessage(om2);
                this.f723a = omArr2;
            }
        }
        return this;
    }

    public static Pm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Pm().mergeFrom(codedInputByteBufferNano);
    }

    public static Pm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Pm) MessageNano.mergeFrom(new Pm(), bArr);
    }
}
