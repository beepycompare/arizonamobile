package ru.rustore.sdk.reactive.subject;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubjectExtensions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006¨\u0006\u0007"}, d2 = {"asStateSubject", "Lru/rustore/sdk/reactive/subject/StateSubject;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/subject/MutableStateSubject;", "asSubject", "Lru/rustore/sdk/reactive/subject/Subject;", "Lru/rustore/sdk/reactive/subject/MutableSubject;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubjectExtensionsKt {
    public static final <T> Subject<T> asSubject(MutableSubject<T> mutableSubject) {
        Intrinsics.checkNotNullParameter(mutableSubject, "<this>");
        return new ReadOnlySubject(mutableSubject);
    }

    public static final <T> Subject<T> asSubject(MutableStateSubject<T> mutableStateSubject) {
        Intrinsics.checkNotNullParameter(mutableStateSubject, "<this>");
        return new ReadOnlySubject(mutableStateSubject);
    }

    public static final <T> StateSubject<T> asStateSubject(MutableStateSubject<T> mutableStateSubject) {
        Intrinsics.checkNotNullParameter(mutableStateSubject, "<this>");
        return new ReadOnlyStateSubject(mutableStateSubject);
    }
}
