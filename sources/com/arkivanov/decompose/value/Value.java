package com.arkivanov.decompose.value;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: Value.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH&R\u0012\u0010\u0005\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/value/Value;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "value", "getValue", "()Ljava/lang/Object;", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "Lkotlin/Function1;", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Value<T> {
    public abstract T getValue();

    public abstract Cancellation subscribe(Function1<? super T, Unit> function1);
}
