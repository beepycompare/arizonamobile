package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.jo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0357jo extends MessageNano {
    public static volatile C0357jo[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0280go[] f1046a;

    public C0357jo() {
        a();
    }

    public static C0357jo[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0357jo[0];
                }
            }
        }
        return b;
    }

    public final C0357jo a() {
        this.f1046a = C0280go.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0280go[] c0280goArr = this.f1046a;
        if (c0280goArr != null && c0280goArr.length > 0) {
            int i = 0;
            while (true) {
                C0280go[] c0280goArr2 = this.f1046a;
                if (i >= c0280goArr2.length) {
                    break;
                }
                C0280go c0280go = c0280goArr2[i];
                if (c0280go != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0280go) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0280go[] c0280goArr = this.f1046a;
        if (c0280goArr != null && c0280goArr.length > 0) {
            int i = 0;
            while (true) {
                C0280go[] c0280goArr2 = this.f1046a;
                if (i >= c0280goArr2.length) {
                    break;
                }
                C0280go c0280go = c0280goArr2[i];
                if (c0280go != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0280go);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0357jo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0280go[] c0280goArr = this.f1046a;
                int length = c0280goArr == null ? 0 : c0280goArr.length;
                int i = repeatedFieldArrayLength + length;
                C0280go[] c0280goArr2 = new C0280go[i];
                if (length != 0) {
                    System.arraycopy(c0280goArr, 0, c0280goArr2, 0, length);
                }
                while (length < i - 1) {
                    C0280go c0280go = new C0280go();
                    c0280goArr2[length] = c0280go;
                    codedInputByteBufferNano.readMessage(c0280go);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0280go c0280go2 = new C0280go();
                c0280goArr2[length] = c0280go2;
                codedInputByteBufferNano.readMessage(c0280go2);
                this.f1046a = c0280goArr2;
            }
        }
        return this;
    }

    public static C0357jo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0357jo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0357jo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0357jo) MessageNano.mergeFrom(new C0357jo(), bArr);
    }
}
