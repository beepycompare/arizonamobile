package com.arkivanov.decompose.value.operator;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.Lock;
import com.arkivanov.decompose.value.Value;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Map.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00030\u0004B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000f\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/arkivanov/decompose/value/operator/MappedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "R", "Lcom/arkivanov/decompose/value/Value;", "upstream", "mapper", "Lkotlin/Function1;", "<init>", "(Lcom/arkivanov/decompose/value/Value;Lkotlin/jvm/functions/Function1;)V", "lock", "Lcom/arkivanov/decompose/Lock;", "lastUpstreamValue", "Ljava/lang/Object;", "lastMappedValue", "value", "getValue", "()Ljava/lang/Object;", "mapCached", "(Ljava/lang/Object;)Ljava/lang/Object;", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MappedValue<T, R> extends Value<R> {
    private R lastMappedValue;
    private T lastUpstreamValue;
    private final Lock lock;
    private final Function1<T, R> mapper;
    private final Value<T> upstream;

    /* JADX WARN: Multi-variable type inference failed */
    public MappedValue(Value<? extends T> upstream, Function1<? super T, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.upstream = upstream;
        this.mapper = mapper;
        this.lock = new Lock();
        T t = (T) upstream.getValue();
        this.lastUpstreamValue = t;
        this.lastMappedValue = (R) mapper.invoke(t);
    }

    @Override // com.arkivanov.decompose.value.Value
    public R getValue() {
        return mapCached(this.upstream.getValue());
    }

    private final R mapCached(T t) {
        R r;
        synchronized (this.lock) {
            if (t != this.lastUpstreamValue) {
                this.lastUpstreamValue = t;
                this.lastMappedValue = this.mapper.invoke(t);
            }
            r = this.lastMappedValue;
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subscribe$lambda$1(Function1 function1, MappedValue mappedValue, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(mappedValue.mapCached(it));
        return Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.value.Value
    public Cancellation subscribe(final Function1<? super R, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.upstream.subscribe(new Function1() { // from class: com.arkivanov.decompose.value.operator.MappedValue$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subscribe$lambda$1;
                subscribe$lambda$1 = MappedValue.subscribe$lambda$1(Function1.this, this, obj);
                return subscribe$lambda$1;
            }
        });
    }
}
