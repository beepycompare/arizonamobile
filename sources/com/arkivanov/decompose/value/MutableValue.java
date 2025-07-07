package com.arkivanov.decompose.value;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
/* compiled from: MutableValue.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fR\u0018\u0010\u0006\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/value/MutableValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/Value;", "<init>", "()V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "compareAndSet", "", "expected", "new", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class MutableValue<T> extends Value<T> {
    public abstract boolean compareAndSet(T t, T t2);

    @Override // com.arkivanov.decompose.value.Value
    public abstract T getValue();

    public abstract void setValue(T t);
}
