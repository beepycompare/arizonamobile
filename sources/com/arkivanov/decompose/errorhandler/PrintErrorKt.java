package com.arkivanov.decompose.errorhandler;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PrintError.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"LOG_TAG", "", "isLogCatEnabled", "", "printError", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrintErrorKt {
    private static final String LOG_TAG = "Decompose";
    private static boolean isLogCatEnabled = true;

    public static final void printError(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (isLogCatEnabled) {
            try {
                String message = exception.getMessage();
                if (message == null) {
                    message = "An occurred in Decompose";
                }
                Log.e(LOG_TAG, message, exception);
            } catch (Exception unused) {
                isLogCatEnabled = false;
            }
        }
    }
}
