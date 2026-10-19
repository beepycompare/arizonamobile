package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.fj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0248fj extends MessageNano {
    public static volatile C0248fj[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f987a;
    public C0222ej b;
    public C0197dj c;

    public C0248fj() {
        a();
    }

    public static C0248fj[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0248fj[0];
                }
            }
        }
        return d;
    }

    public final C0248fj a() {
        this.f987a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f987a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        C0222ej c0222ej = this.b;
        if (c0222ej != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0222ej);
        }
        C0197dj c0197dj = this.c;
        return c0197dj != null ? CodedOutputByteBufferNano.computeMessageSize(3, c0197dj) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f987a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        C0222ej c0222ej = this.b;
        if (c0222ej != null) {
            codedOutputByteBufferNano.writeMessage(2, c0222ej);
        }
        C0197dj c0197dj = this.c;
        if (c0197dj != null) {
            codedOutputByteBufferNano.writeMessage(3, c0197dj);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0248fj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f987a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0222ej();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new C0197dj();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static C0248fj b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0248fj().mergeFrom(codedInputByteBufferNano);
    }

    public static C0248fj a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0248fj) MessageNano.mergeFrom(new C0248fj(), bArr);
    }
}
