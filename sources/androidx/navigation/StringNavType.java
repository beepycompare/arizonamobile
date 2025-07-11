package androidx.navigation;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: NavType.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/navigation/StringNavType;", "Landroidx/navigation/NavType;", "", "<init>", "()V", "name", "getName", "()Ljava/lang/String;", "put", "", "bundle", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "key", "value", "get", "parseValue", "serializeAsValue", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringNavType extends NavType<String> {
    public StringNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return TypedValues.Custom.S_STRING;
    }

    @Override // androidx.navigation.NavType
    public String parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
            return null;
        }
        return value;
    }

    @Override // androidx.navigation.NavType
    public String serializeAsValue(String str) {
        String encode$default;
        return (str == null || (encode$default = NavUriUtils.encode$default(NavUriUtils.INSTANCE, str, null, 2, null)) == null) ? AbstractJsonLexerKt.NULL : encode$default;
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, String str) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle m7666constructorimpl = SavedStateWriter.m7666constructorimpl(bundle);
        if (str != null) {
            SavedStateWriter.m7699putStringimpl(m7666constructorimpl, key, str);
        } else {
            SavedStateWriter.m7689putNullimpl(m7666constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public String get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
        if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m7651getStringimpl(m7580constructorimpl, key);
    }
}
