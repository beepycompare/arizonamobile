package io.appmetrica.analytics.impl;

import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.e8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0218e8 {

    /* renamed from: a  reason: collision with root package name */
    public final W f961a;
    public final C0445n2 b;

    public C0218e8(W w, C0445n2 c0445n2) {
        this.f961a = w;
        this.b = c0445n2;
    }

    public final String a() {
        byte[] bArr;
        AdTrackingInfoResult yandex = this.f961a.getIdentifiers().getYandex();
        if (yandex.isValid()) {
            AdTrackingInfo adTrackingInfo = yandex.mAdTrackingInfo;
            Intrinsics.checkNotNull(adTrackingInfo);
            String str = adTrackingInfo.advId;
            Intrinsics.checkNotNull(str);
            try {
                bArr = MessageDigest.getInstance("MD5").digest(str.getBytes(Charsets.UTF_8));
            } catch (NoSuchAlgorithmException unused) {
                bArr = new byte[0];
            }
            return StringUtils.toHexString(bArr);
        }
        String id = this.b.getAppSetId().getId();
        if (id != null && id.length() != 0) {
            try {
                UUID.fromString(id);
                if (!Intrinsics.areEqual(id, "00000000-0000-0000-0000-000000000000")) {
                    return StringsKt.replace$default(id, Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null);
                }
            } catch (Throwable unused2) {
            }
        }
        return StringsKt.replace$default(UUID.randomUUID().toString(), Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).toLowerCase(Locale.US);
    }

    public C0218e8() {
        this(Na.k().c(), Na.k().d());
    }
}
