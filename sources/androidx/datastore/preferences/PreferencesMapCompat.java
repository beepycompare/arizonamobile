package androidx.datastore.preferences;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PreferencesMapCompat.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/datastore/preferences/PreferencesMapCompat;", "", "<init>", "()V", "Companion", "datastore-preferences-proto"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferencesMapCompat {
    public static final Companion Companion = new Companion(null);

    /* compiled from: PreferencesMapCompat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/datastore/preferences/PreferencesMapCompat$Companion;", "", "<init>", "()V", "readFrom", "Landroidx/datastore/preferences/PreferencesProto$PreferenceMap;", "input", "Ljava/io/InputStream;", "datastore-preferences-proto"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PreferencesProto.PreferenceMap readFrom(InputStream input) {
            Intrinsics.checkNotNullParameter(input, "input");
            try {
                PreferencesProto.PreferenceMap parseFrom = PreferencesProto.PreferenceMap.parseFrom(input);
                Intrinsics.checkNotNull(parseFrom);
                return parseFrom;
            } catch (InvalidProtocolBufferException e) {
                throw new CorruptionException("Unable to parse preferences proto.", e);
            }
        }
    }
}
