package kotlinx.datetime.serializers;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;
/* compiled from: DateTimeUnitSerializers.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"throwUnknownIndexException", "", FirebaseAnalytics.Param.INDEX, "", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateTimeUnitSerializersKt {
    public static final Void throwUnknownIndexException(int i) {
        throw new SerializationException("An unknown field for index " + i);
    }
}
