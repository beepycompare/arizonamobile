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
public final class C0398km extends MessageNano {
    public static volatile C0398km[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0373jm[] f911a;

    public C0398km() {
        a();
    }

    public static C0398km[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0398km[0];
                }
            }
        }
        return b;
    }

    public final C0398km a() {
        this.f911a = C0373jm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0373jm[] c0373jmArr = this.f911a;
        if (c0373jmArr != null && c0373jmArr.length > 0) {
            int i = 0;
            while (true) {
                C0373jm[] c0373jmArr2 = this.f911a;
                if (i >= c0373jmArr2.length) {
                    break;
                }
                C0373jm c0373jm = c0373jmArr2[i];
                if (c0373jm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0373jm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0373jm[] c0373jmArr = this.f911a;
        if (c0373jmArr != null && c0373jmArr.length > 0) {
            int i = 0;
            while (true) {
                C0373jm[] c0373jmArr2 = this.f911a;
                if (i >= c0373jmArr2.length) {
                    break;
                }
                C0373jm c0373jm = c0373jmArr2[i];
                if (c0373jm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0373jm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0398km mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0373jm[] c0373jmArr = this.f911a;
                int length = c0373jmArr == null ? 0 : c0373jmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0373jm[] c0373jmArr2 = new C0373jm[i];
                if (length != 0) {
                    System.arraycopy(c0373jmArr, 0, c0373jmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0373jm c0373jm = new C0373jm();
                    c0373jmArr2[length] = c0373jm;
                    codedInputByteBufferNano.readMessage(c0373jm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0373jm c0373jm2 = new C0373jm();
                c0373jmArr2[length] = c0373jm2;
                codedInputByteBufferNano.readMessage(c0373jm2);
                this.f911a = c0373jmArr2;
            }
        }
        return this;
    }

    public static C0398km b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0398km().mergeFrom(codedInputByteBufferNano);
    }

    public static C0398km a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0398km) MessageNano.mergeFrom(new C0398km(), bArr);
    }
}
