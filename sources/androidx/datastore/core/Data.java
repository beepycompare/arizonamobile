package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
/* compiled from: State.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/datastore/core/Data;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/State;", "value", "hashCode", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "<init>", "(Ljava/lang/Object;II)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getHashCode", "()I", "checkHashCode", "", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Data<T> extends State<T> {
    private final int hashCode;
    private final T value;

    public Data(T t, int i, int i2) {
        super(i2, null);
        this.value = t;
        this.hashCode = i;
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    public final T getValue() {
        return this.value;
    }

    public final void checkHashCode() {
        T t = this.value;
        if ((t != null ? t.hashCode() : 0) != this.hashCode) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }
}
