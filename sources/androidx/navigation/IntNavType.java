package androidx.navigation;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
/* compiled from: NavType.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u00022\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/navigation/IntNavType;", "Landroidx/navigation/NavType;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "put", "", "bundle", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "key", "value", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Integer;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IntNavType extends NavType<Integer> {
    public IntNavType() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Integer num) {
        put(bundle, str, num.intValue());
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return TypedValues.Custom.S_INT;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavType
    public Integer parseValue(String value) {
        int parseInt;
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.startsWith$default(value, "0x", false, 2, (Object) null)) {
            String substring = value.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
        } else {
            parseInt = Integer.parseInt(value);
        }
        return Integer.valueOf(parseInt);
    }

    public void put(Bundle bundle, String key, int i) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        SavedStateWriter.m7683putIntimpl(SavedStateWriter.m7666constructorimpl(bundle), key, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavType
    public Integer get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return Integer.valueOf(SavedStateReader.m7611getIntimpl(SavedStateReader.m7580constructorimpl(bundle), key));
    }
}
