package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import kotlin.collections.ArraysKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.v5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0655v5 implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final IExecutionPolicy[] f1243a;
    public final String b;

    public C0655v5(IExecutionPolicy... iExecutionPolicyArr) {
        this.f1243a = iExecutionPolicyArr;
        this.b = "Composite of {" + ArraysKt.joinToString$default(iExecutionPolicyArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C0629u5.f1225a, 30, (Object) null) + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        IExecutionPolicy iExecutionPolicy;
        IExecutionPolicy[] iExecutionPolicyArr = this.f1243a;
        if (iExecutionPolicyArr.length == 0) {
            return false;
        }
        int length = iExecutionPolicyArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                iExecutionPolicy = null;
                break;
            }
            iExecutionPolicy = iExecutionPolicyArr[i];
            if (!iExecutionPolicy.canBeExecuted()) {
                break;
            }
            i++;
        }
        return iExecutionPolicy == null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.b;
    }
}
