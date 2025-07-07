package com.arkivanov.decompose.value;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.Lock;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableValueBuilder.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J,\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00028\u00002\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000fH\u0082\b¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u001c\u0010\u001f\u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001c\u0010 \u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0006¨\u0006!"}, d2 = {"Lcom/arkivanov/decompose/value/MutableValueImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/MutableValue;", "initialValue", "<init>", "(Ljava/lang/Object;)V", "lock", "Lcom/arkivanov/decompose/Lock;", "_value", "Ljava/lang/Object;", "isEmitting", "", "observers", "", "Lkotlin/Function1;", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "compareAndSet", "expected", "new", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "predicate", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "emit", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "subscribeObserver", "unsubscribeObserver", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableValueImpl<T> extends MutableValue<T> {
    private T _value;
    private boolean isEmitting;
    private final Lock lock;
    private Map<Function1<T, Unit>, Boolean> observers;

    public MutableValueImpl(T initialValue) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        this.lock = new Lock();
        this._value = initialValue;
        this.observers = MapsKt.emptyMap();
    }

    @Override // com.arkivanov.decompose.value.MutableValue, com.arkivanov.decompose.value.Value
    public T getValue() {
        T t;
        synchronized (this.lock) {
            t = this._value;
        }
        return t;
    }

    static /* synthetic */ boolean setValue$default(MutableValueImpl mutableValueImpl, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: com.arkivanov.decompose.value.MutableValueImpl$setValue$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj3) {
                    return invoke((MutableValueImpl$setValue$1<T>) obj3);
                }
            };
        }
        synchronized (mutableValueImpl.lock) {
            if (((Boolean) function1.invoke(mutableValueImpl._value)).booleanValue()) {
                mutableValueImpl._value = obj;
                if (mutableValueImpl.isEmitting) {
                    return true;
                }
                mutableValueImpl.isEmitting = true;
                Unit unit = Unit.INSTANCE;
                mutableValueImpl.emit();
                return true;
            }
            return false;
        }
    }

    private final boolean setValue(T t, Function1<? super T, Boolean> function1) {
        synchronized (this.lock) {
            if (function1.invoke((Object) this._value).booleanValue()) {
                this._value = t;
                if (this.isEmitting) {
                    return true;
                }
                this.isEmitting = true;
                Unit unit = Unit.INSTANCE;
                emit();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emit() {
        T t;
        Map<Function1<T, Unit>, Boolean> map;
        while (true) {
            synchronized (this.lock) {
                t = this._value;
                map = this.observers;
                Unit unit = Unit.INSTANCE;
            }
            for (Map.Entry<Function1<T, Unit>, Boolean> entry : map.entrySet()) {
                Function1<T, Unit> key = entry.getKey();
                if (entry.getValue().booleanValue()) {
                    key.invoke(t);
                }
            }
            synchronized (this.lock) {
                if (t == this._value) {
                    this.isEmitting = false;
                    return;
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    @Override // com.arkivanov.decompose.value.Value
    public Cancellation subscribe(final Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        subscribeObserver(observer);
        return new Cancellation() { // from class: com.arkivanov.decompose.value.MutableValueImpl$$ExternalSyntheticLambda0
            @Override // com.arkivanov.decompose.Cancellation
            public final void cancel() {
                MutableValueImpl.this.unsubscribeObserver(observer);
            }
        };
    }

    private final void subscribeObserver(Function1<? super T, Unit> function1) {
        Object obj;
        synchronized (this.lock) {
            if (this.observers.containsKey(function1)) {
                return;
            }
            this.observers = MapsKt.plus(this.observers, TuplesKt.to(function1, false));
            Unit unit = Unit.INSTANCE;
            while (true) {
                synchronized (this.lock) {
                    obj = (T) this._value;
                }
                function1.invoke(obj);
                synchronized (this.lock) {
                    if (!this.observers.containsKey(function1)) {
                        return;
                    }
                    if (obj == this._value) {
                        this.observers = MapsKt.plus(this.observers, TuplesKt.to(function1, true));
                        return;
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unsubscribeObserver(Function1<? super T, Unit> function1) {
        synchronized (this.lock) {
            this.observers = MapsKt.minus(this.observers, function1);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.arkivanov.decompose.value.MutableValue
    public void setValue(T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            Object unused = this._value;
            this._value = value;
            if (this.isEmitting) {
                return;
            }
            this.isEmitting = true;
            Unit unit = Unit.INSTANCE;
            emit();
        }
    }

    @Override // com.arkivanov.decompose.value.MutableValue
    public boolean compareAndSet(T expected, T t) {
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(t, "new");
        synchronized (this.lock) {
            if (this._value == expected) {
                this._value = t;
                if (this.isEmitting) {
                    return true;
                }
                this.isEmitting = true;
                Unit unit = Unit.INSTANCE;
                emit();
                return true;
            }
            return false;
        }
    }
}
