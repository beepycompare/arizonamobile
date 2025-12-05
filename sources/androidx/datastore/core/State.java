package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: State.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Landroidx/datastore/core/State;", ExifInterface.GPS_DIRECTION_TRUE, "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "", "<init>", "(I)V", "getVersion", "()I", "Landroidx/datastore/core/Data;", "Landroidx/datastore/core/Final;", "Landroidx/datastore/core/NoValueDataState;", "Landroidx/datastore/core/ReadException;", "Landroidx/datastore/core/UnInitialized;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class State<T> {
    private final int version;

    public /* synthetic */ State(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private State(int i) {
        this.version = i;
    }

    public final int getVersion() {
        return this.version;
    }
}
