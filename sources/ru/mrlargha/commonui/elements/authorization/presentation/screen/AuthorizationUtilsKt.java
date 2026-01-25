package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: AuthorizationUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"authToast", "Landroid/widget/Toast;", "TOAST_SHOW_TIME", "", "getRuLettersFilter", "Landroid/text/InputFilter;", "onFindRuLetters", "Lkotlin/Function0;", "", "showErrorToast", "Landroid/content/Context;", "messages", "", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AuthorizationUtilsKt {
    private static final long TOAST_SHOW_TIME = 2000;
    private static Toast authToast;

    public static final InputFilter getRuLettersFilter(final Function0<Unit> onFindRuLetters) {
        Intrinsics.checkNotNullParameter(onFindRuLetters, "onFindRuLetters");
        return new InputFilter() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.AuthorizationUtilsKt$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                CharSequence ruLettersFilter$lambda$0;
                ruLettersFilter$lambda$0 = AuthorizationUtilsKt.getRuLettersFilter$lambda$0(Function0.this, charSequence, i, i2, spanned, i3, i4);
                return ruLettersFilter$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getRuLettersFilter$lambda$0(Function0 function0, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if ((1040 > charAt || charAt >= 1072) && !((1072 <= charAt && charAt < 1104) || charAt == 1025 || charAt == 1105)) {
                sb.append(charAt);
            } else {
                z = true;
            }
            i++;
        }
        String sb2 = sb.toString();
        if (z) {
            function0.invoke();
        }
        if (z) {
            return sb2;
        }
        return null;
    }

    public static final void showErrorToast(Context context, String messages) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (authToast == null) {
            Toast makeText = Toast.makeText(context.getApplicationContext(), messages, 0);
            authToast = makeText;
            if (makeText != null) {
                makeText.show();
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AuthorizationUtilsKt$showErrorToast$1(null), 3, null);
        }
    }
}
