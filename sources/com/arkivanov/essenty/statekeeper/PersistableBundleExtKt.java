package com.arkivanov.essenty.statekeeper;

import android.os.PersistableBundle;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.statekeeper.base64.DecoderKt;
import com.arkivanov.essenty.statekeeper.base64.EncoderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
/* compiled from: PersistableBundleExt.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a5\u0010\u000b\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0011"}, d2 = {"putSerializable", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/os/PersistableBundle;", "key", "", "value", "strategy", "Lkotlinx/serialization/SerializationStrategy;", "(Landroid/os/PersistableBundle;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)V", "getSerializable", "Lkotlinx/serialization/DeserializationStrategy;", "(Landroid/os/PersistableBundle;Ljava/lang/String;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "putSerializableContainer", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "getSerializableContainer", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PersistableBundleExtKt {
    public static final <T> void putSerializable(PersistableBundle persistableBundle, String str, T t, SerializationStrategy<? super T> strategy) {
        byte[] serialize;
        Intrinsics.checkNotNullParameter(persistableBundle, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        persistableBundle.putString(str, (t == null || (serialize = Utils_javaKt.serialize(t, strategy)) == null) ? null : EncoderKt.toBase64(serialize));
    }

    public static final <T> T getSerializable(PersistableBundle persistableBundle, String str, DeserializationStrategy<? extends T> strategy) {
        byte[] base64ToByteArray;
        Intrinsics.checkNotNullParameter(persistableBundle, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        String string = persistableBundle.getString(str);
        if (string == null || (base64ToByteArray = DecoderKt.base64ToByteArray(string)) == null) {
            return null;
        }
        return (T) Utils_javaKt.deserialize(base64ToByteArray, strategy);
    }

    public static final void putSerializableContainer(PersistableBundle persistableBundle, String str, SerializableContainer serializableContainer) {
        Intrinsics.checkNotNullParameter(persistableBundle, "<this>");
        putSerializable(persistableBundle, str, serializableContainer, SerializableContainer.Companion.serializer());
    }

    public static final SerializableContainer getSerializableContainer(PersistableBundle persistableBundle, String str) {
        Intrinsics.checkNotNullParameter(persistableBundle, "<this>");
        return (SerializableContainer) getSerializable(persistableBundle, str, SerializableContainer.Companion.serializer());
    }
}
