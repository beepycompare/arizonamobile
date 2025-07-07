package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.co  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0200co extends MessageNano {
    public static volatile C0200co[] b;

    /* renamed from: a  reason: collision with root package name */
    public Zn[] f790a;

    public C0200co() {
        a();
    }

    public static C0200co[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0200co[0];
                }
            }
        }
        return b;
    }

    public final C0200co a() {
        this.f790a = Zn.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Zn[] znArr = this.f790a;
        if (znArr != null && znArr.length > 0) {
            int i = 0;
            while (true) {
                Zn[] znArr2 = this.f790a;
                if (i >= znArr2.length) {
                    break;
                }
                Zn zn = znArr2[i];
                if (zn != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, zn) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Zn[] znArr = this.f790a;
        if (znArr != null && znArr.length > 0) {
            int i = 0;
            while (true) {
                Zn[] znArr2 = this.f790a;
                if (i >= znArr2.length) {
                    break;
                }
                Zn zn = znArr2[i];
                if (zn != null) {
                    codedOutputByteBufferNano.writeMessage(1, zn);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0200co mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Zn[] znArr = this.f790a;
                int length = znArr == null ? 0 : znArr.length;
                int i = repeatedFieldArrayLength + length;
                Zn[] znArr2 = new Zn[i];
                if (length != 0) {
                    System.arraycopy(znArr, 0, znArr2, 0, length);
                }
                while (length < i - 1) {
                    Zn zn = new Zn();
                    znArr2[length] = zn;
                    codedInputByteBufferNano.readMessage(zn);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Zn zn2 = new Zn();
                znArr2[length] = zn2;
                codedInputByteBufferNano.readMessage(zn2);
                this.f790a = znArr2;
            }
        }
        return this;
    }

    public static C0200co b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0200co().mergeFrom(codedInputByteBufferNano);
    }

    public static C0200co a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0200co) MessageNano.mergeFrom(new C0200co(), bArr);
    }
}
