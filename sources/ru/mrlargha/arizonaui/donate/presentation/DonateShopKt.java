package ru.mrlargha.arizonaui.donate.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateShop.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "setBASE_URL", "(Ljava/lang/String;)V", "DONATE_URL", "getDONATE_URL", "setDONATE_URL", "ArizonaUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateShopKt {
    private static String BASE_URL = "";
    private static String DONATE_URL = "june2_donation.json";

    public static final String getBASE_URL() {
        return BASE_URL;
    }

    public static final void setBASE_URL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BASE_URL = str;
    }

    public static final String getDONATE_URL() {
        return DONATE_URL;
    }

    public static final void setDONATE_URL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        DONATE_URL = str;
    }
}
