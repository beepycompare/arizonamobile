package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.km  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0390km extends MessageNano {
    public static volatile C0390km[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0365jm[] f912a;

    public C0390km() {
        a();
    }

    public static C0390km[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0390km[0];
                }
            }
        }
        return b;
    }

    public final C0390km a() {
        this.f912a = C0365jm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0365jm[] c0365jmArr = this.f912a;
        if (c0365jmArr != null && c0365jmArr.length > 0) {
            int i = 0;
            while (true) {
                C0365jm[] c0365jmArr2 = this.f912a;
                if (i >= c0365jmArr2.length) {
                    break;
                }
                C0365jm c0365jm = c0365jmArr2[i];
                if (c0365jm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0365jm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0365jm[] c0365jmArr = this.f912a;
        if (c0365jmArr != null && c0365jmArr.length > 0) {
            int i = 0;
            while (true) {
                C0365jm[] c0365jmArr2 = this.f912a;
                if (i >= c0365jmArr2.length) {
                    break;
                }
                C0365jm c0365jm = c0365jmArr2[i];
                if (c0365jm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0365jm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0390km mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0365jm[] c0365jmArr = this.f912a;
                int length = c0365jmArr == null ? 0 : c0365jmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0365jm[] c0365jmArr2 = new C0365jm[i];
                if (length != 0) {
                    System.arraycopy(c0365jmArr, 0, c0365jmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0365jm c0365jm = new C0365jm();
                    c0365jmArr2[length] = c0365jm;
                    codedInputByteBufferNano.readMessage(c0365jm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0365jm c0365jm2 = new C0365jm();
                c0365jmArr2[length] = c0365jm2;
                codedInputByteBufferNano.readMessage(c0365jm2);
                this.f912a = c0365jmArr2;
            }
        }
        return this;
    }

    public static C0390km b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0390km().mergeFrom(codedInputByteBufferNano);
    }

    public static C0390km a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0390km) MessageNano.mergeFrom(new C0390km(), bArr);
    }
}
