package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
/* compiled from: KProperty.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000fJ\u000f\u0010\u0004\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007H§\u0080\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nR\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/KProperty0;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/KProperty;", "Lkotlin/Function0;", "get", "()Ljava/lang/Object;", "getDelegate", "", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.1", "getter", "Lkotlin/reflect/KProperty0$Getter;", "getGetter", "()Lkotlin/reflect/KProperty0$Getter;", "Getter", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KProperty0<V> extends KProperty<V>, Function0<V> {

    /* compiled from: KProperty.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/reflect/KProperty0$Getter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/KProperty$Getter;", "Lkotlin/Function0;", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Getter<V> extends KProperty.Getter<V>, Function0<V> {
    }

    V get();

    Object getDelegate();

    @Override // 
    Getter<V> getGetter();
}
