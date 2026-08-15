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
public final class C0254fj extends MessageNano {
    public static volatile C0254fj[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f984a;
    public C0228ej b;
    public C0203dj c;

    public C0254fj() {
        a();
    }

    public static C0254fj[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0254fj[0];
                }
            }
        }
        return d;
    }

    public final C0254fj a() {
        this.f984a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f984a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        C0228ej c0228ej = this.b;
        if (c0228ej != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0228ej);
        }
        C0203dj c0203dj = this.c;
        return c0203dj != null ? CodedOutputByteBufferNano.computeMessageSize(3, c0203dj) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f984a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        C0228ej c0228ej = this.b;
        if (c0228ej != null) {
            codedOutputByteBufferNano.writeMessage(2, c0228ej);
        }
        C0203dj c0203dj = this.c;
        if (c0203dj != null) {
            codedOutputByteBufferNano.writeMessage(3, c0203dj);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0254fj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f984a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0228ej();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new C0203dj();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static C0254fj b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0254fj().mergeFrom(codedInputByteBufferNano);
    }

    public static C0254fj a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0254fj) MessageNano.mergeFrom(new C0254fj(), bArr);
    }
}
