package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Ki extends MessageNano {
    public static volatile Ki[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f666a;
    public Ji b;
    public Ii c;

    public Ki() {
        a();
    }

    public static Ki[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new Ki[0];
                }
            }
        }
        return d;
    }

    public final Ki a() {
        this.f666a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f666a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        Ji ji = this.b;
        if (ji != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, ji);
        }
        Ii ii = this.c;
        return ii != null ? CodedOutputByteBufferNano.computeMessageSize(3, ii) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f666a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        Ji ji = this.b;
        if (ji != null) {
            codedOutputByteBufferNano.writeMessage(2, ji);
        }
        Ii ii = this.c;
        if (ii != null) {
            codedOutputByteBufferNano.writeMessage(3, ii);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Ki mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f666a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new Ji();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new Ii();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static Ki b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ki().mergeFrom(codedInputByteBufferNano);
    }

    public static Ki a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ki) MessageNano.mergeFrom(new Ki(), bArr);
    }
}
