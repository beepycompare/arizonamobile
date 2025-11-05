package ru.mrlargha.certificate;

import com.arizonagames.feature.arizona.certificate.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: images.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"certificateIc", "", "name", "", "certificate_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImagesKt {
    public static final int certificateIc(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        switch (name.hashCode()) {
            case -2124887163:
                if (name.equals("icon-transport-safe")) {
                    return R.drawable.sertificate_ic_safe;
                }
                break;
            case -1457036466:
                if (name.equals("icon-transport-heart")) {
                    return R.drawable.sertificate_ic_hp;
                }
                break;
            case -1449253807:
                if (name.equals("icon-transport-price")) {
                    return R.drawable.sertificate_ic_gov;
                }
                break;
            case -1446546609:
                if (name.equals("icon-transport-speed")) {
                    return R.drawable.sertificate_ic_speed;
                }
                break;
            case 280951689:
                if (name.equals("icon-transport-container")) {
                    return R.drawable.sertificate_ic_container;
                }
                break;
            case 1810418316:
                if (name.equals("icon-transport-animation")) {
                    return R.drawable.sertificate_ic_anim;
                }
                break;
            case 1888466280:
                if (name.equals("icon-transport-armour")) {
                    return R.drawable.sertificate_ic_armor;
                }
                break;
            case 1911433871:
                if (name.equals("icon-transport-blinks")) {
                    return R.drawable.sertificate_ic_set;
                }
                break;
            case 1999104058:
                if (name.equals("icon-transport-engine")) {
                    return R.drawable.sertificate_ic_engine;
                }
                break;
            case 2099890812:
                if (name.equals("icon-transport-supports")) {
                    return R.drawable.sertificate_ic_caliper;
                }
                break;
        }
        return R.drawable.sertificate_ic_hp;
    }
}
