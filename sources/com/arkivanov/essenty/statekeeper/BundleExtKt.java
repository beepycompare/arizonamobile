package com.arkivanov.essenty.statekeeper;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
/* compiled from: BundleExt.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f¢\u0006\u0002\u0010\r\u001a*\u0010\u000e\u001a\u0004\u0018\u0001H\u0002\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u000f*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0082\b¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u0001*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0012\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0014"}, d2 = {"putSerializable", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/os/Bundle;", "key", "", "value", "strategy", "Lkotlinx/serialization/SerializationStrategy;", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)V", "getSerializable", "Lkotlinx/serialization/DeserializationStrategy;", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "getParcelableCompat", "Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "putSerializableContainer", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "getSerializableContainer", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BundleExtKt {
    public static final <T> void putSerializable(Bundle bundle, String str, final T t, final SerializationStrategy<? super T> strategy) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        bundle.putParcelable(str, new ValueHolder(t, LazyKt.lazy(new Function0() { // from class: com.arkivanov.essenty.statekeeper.BundleExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte[] putSerializable$lambda$0;
                putSerializable$lambda$0 = BundleExtKt.putSerializable$lambda$0(t, strategy);
                return putSerializable$lambda$0;
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] putSerializable$lambda$0(Object obj, SerializationStrategy serializationStrategy) {
        if (obj != null) {
            return Utils_javaKt.serialize(obj, serializationStrategy);
        }
        return null;
    }

    private static final /* synthetic */ <T extends Parcelable> T getParcelableCompat(Bundle bundle, String str) {
        ClassLoader classLoader = bundle.getClassLoader();
        try {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            bundle.setClassLoader(Parcelable.class.getClassLoader());
            T t = (T) bundle.getParcelable(str);
            Intrinsics.reifiedOperationMarker(1, "T?");
            T t2 = t;
            T t3 = t;
            bundle.setClassLoader(classLoader);
            return t;
        } catch (Throwable th) {
            bundle.setClassLoader(classLoader);
            throw th;
        }
    }

    public static final void putSerializableContainer(Bundle bundle, String str, SerializableContainer serializableContainer) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        putSerializable(bundle, str, serializableContainer, SerializableContainer.Companion.serializer());
    }

    public static final SerializableContainer getSerializableContainer(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return (SerializableContainer) getSerializable(bundle, str, SerializableContainer.Companion.serializer());
    }

    public static final <T> T getSerializable(Bundle bundle, String str, DeserializationStrategy<? extends T> strategy) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        ClassLoader classLoader = bundle.getClassLoader();
        try {
            bundle.setClassLoader(ValueHolder.class.getClassLoader());
            ValueHolder valueHolder = (ValueHolder) bundle.getParcelable(str);
            bundle.setClassLoader(classLoader);
            ValueHolder valueHolder2 = valueHolder;
            if (valueHolder2 != null) {
                T t = (T) valueHolder2.getValue();
                if (t == null) {
                    byte[] value = valueHolder2.getBytes().getValue();
                    if (value != null) {
                        return (T) Utils_javaKt.deserialize(value, strategy);
                    }
                    return null;
                }
                return t;
            }
            return null;
        } catch (Throwable th) {
            bundle.setClassLoader(classLoader);
            throw th;
        }
    }
}
