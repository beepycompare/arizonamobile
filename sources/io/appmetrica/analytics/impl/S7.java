package io.appmetrica.analytics.impl;

import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
/* loaded from: classes3.dex */
public final class S7 {

    /* renamed from: a  reason: collision with root package name */
    public final U f679a;
    public final C0336j2 b;

    public S7(U u, C0336j2 c0336j2) {
        this.f679a = u;
        this.b = c0336j2;
    }

    public final String a() {
        AdvertisingIdsHolder advertisingIdsHolder;
        byte[] bArr;
        U u = this.f679a;
        Ln ln = new Ln(5, ServiceStarter.ERROR_UNKNOWN);
        synchronized (u) {
            try {
                u.a((Li) ln, true).get();
            } catch (InterruptedException | ExecutionException unused) {
            }
            advertisingIdsHolder = u.k;
        }
        AdTrackingInfoResult yandex = advertisingIdsHolder.getYandex();
        if (yandex.isValid()) {
            AdTrackingInfo adTrackingInfo = yandex.mAdTrackingInfo;
            Intrinsics.checkNotNull(adTrackingInfo);
            String str = adTrackingInfo.advId;
            Intrinsics.checkNotNull(str);
            try {
                bArr = MessageDigest.getInstance("MD5").digest(str.getBytes(Charsets.UTF_8));
            } catch (NoSuchAlgorithmException unused2) {
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
            } catch (Throwable unused3) {
            }
        }
        return StringsKt.replace$default(UUID.randomUUID().toString(), Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).toLowerCase(Locale.US);
    }

    public S7() {
        this(C0620ua.k().c(), C0620ua.k().d());
    }
}
