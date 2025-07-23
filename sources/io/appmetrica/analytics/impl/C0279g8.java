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
/* renamed from: io.appmetrica.analytics.impl.g8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0279g8 {

    /* renamed from: a  reason: collision with root package name */
    public final T f862a;
    public final C0273g2 b;

    public C0279g8(T t, C0273g2 c0273g2) {
        this.f862a = t;
        this.b = c0273g2;
    }

    public final String a() {
        AdvertisingIdsHolder advertisingIdsHolder;
        byte[] bArr;
        T t = this.f862a;
        Gn gn = new Gn(5, ServiceStarter.ERROR_UNKNOWN);
        synchronized (t) {
            try {
                t.a((Ti) gn, true).get();
            } catch (InterruptedException | ExecutionException unused) {
            }
            advertisingIdsHolder = t.k;
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

    public C0279g8() {
        this(Ia.j().b(), Ia.j().c());
    }
}
