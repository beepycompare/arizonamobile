package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.rm  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0557rm extends MessageNano {
    public static volatile C0557rm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0533qm[] f1101a;

    public C0557rm() {
        a();
    }

    public static C0557rm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0557rm[0];
                }
            }
        }
        return b;
    }

    public final C0557rm a() {
        this.f1101a = C0533qm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0533qm[] c0533qmArr = this.f1101a;
        if (c0533qmArr != null && c0533qmArr.length > 0) {
            int i = 0;
            while (true) {
                C0533qm[] c0533qmArr2 = this.f1101a;
                if (i >= c0533qmArr2.length) {
                    break;
                }
                C0533qm c0533qm = c0533qmArr2[i];
                if (c0533qm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0533qm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0533qm[] c0533qmArr = this.f1101a;
        if (c0533qmArr != null && c0533qmArr.length > 0) {
            int i = 0;
            while (true) {
                C0533qm[] c0533qmArr2 = this.f1101a;
                if (i >= c0533qmArr2.length) {
                    break;
                }
                C0533qm c0533qm = c0533qmArr2[i];
                if (c0533qm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0533qm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0557rm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0533qm[] c0533qmArr = this.f1101a;
                int length = c0533qmArr == null ? 0 : c0533qmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0533qm[] c0533qmArr2 = new C0533qm[i];
                if (length != 0) {
                    System.arraycopy(c0533qmArr, 0, c0533qmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0533qm c0533qm = new C0533qm();
                    c0533qmArr2[length] = c0533qm;
                    codedInputByteBufferNano.readMessage(c0533qm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0533qm c0533qm2 = new C0533qm();
                c0533qmArr2[length] = c0533qm2;
                codedInputByteBufferNano.readMessage(c0533qm2);
                this.f1101a = c0533qmArr2;
            }
        }
        return this;
    }

    public static C0557rm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0557rm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0557rm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0557rm) MessageNano.mergeFrom(new C0557rm(), bArr);
    }
}
